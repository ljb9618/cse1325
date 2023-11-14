#include "Time.h"

Time::Time(int hour, int minute, int second) : hour(hour), minute(minute), second(second)
{
    rationalize();
}

Time Time::operator+(const Time& time) const
{
    int seconds = second + time.second;
    int extra_seconds = seconds / 60;
    seconds %= 60;

    int minutes = minute + time.minute + extra_seconds;
    int extra_minutes = minutes / 60;
    minutes %= 60;

    int hours = hour + time.hour + extra_minutes;

    return Time(hours, minutes, seconds);
}

Time& Time::operator++()
{
    second++;
    if (second >= 60)
    {
        second = 0;
        minute++;
        if (minute >= 60)
        {
            minute = 0;
            hour++;
            if (hour >= 24)
            {
                hour = 0;
            }
        }
    }
    return *this;
}

Time Time::operator++(int)
{
    Time newTime(hour, minute, second);
    second++;
    if (second >= 60)
    {
        second = 0;
        minute++;
        if (minute >= 60)
        {
            minute = 0;
            hour++;
            if (hour >= 24)
            {
                hour = 0;
            }
        }
    }
    return newTime;
}

bool Time::operator==(const Time& time) const
{
    if ((hour == time.hour) && (minute == time.minute) && (second == time.second))
        return true;
    return false;
}

bool Time::operator!=(const Time& time) const
{
    if ((hour != time.hour) && (minute != time.minute) && (second != time.second))
        return true;
    return false;
}

bool Time::operator<(const Time& time) const
{
    if (hour < time.hour)
        return true;
    else if (hour == time.hour && minute < time.minute)
        return true;
    else if (hour == time.hour && minute == time.minute && second < time.second)
        return true;
    return false;
}

bool Time::operator>(const Time& time) const
{
    if (hour > time.hour)
        return true;
    else if (hour == time.hour && minute > time.minute)
        return true;
    else if (hour == time.hour && minute == time.minute && second > time.second)
        return true;
    return false;
}

bool Time::operator<=(const Time& time) const
{
    if ((hour == time.hour) && (minute == time.minute) && (second == time.second))
        return true;
    else if (hour < time.hour)
        return true;
    else if (hour == time.hour && minute < time.minute)
        return true;
    else if (hour == time.hour && minute == time.minute && second < time.second)
        return true;
    return false;
}

bool Time::operator>=(const Time& time) const
{
    if ((hour == time.hour) && (minute == time.minute) && (second == time.second))
        return true;
    else if (hour > time.hour)
        return true;
    else if (hour == time.hour && minute > time.minute)
        return true;
    else if (hour == time.hour && minute == time.minute && second > time.second)
        return true;
    return false;
}

void Time::rationalize()
{
    int seconds = (hour * 3600) + (minute * 60) + second;
    int hours = seconds / 3600;
    int minutes = (seconds % 3600) / 60;
    int new_seconds = (seconds % 60);
    second = new_seconds;
    minute = minutes;
    hour = hours;
}