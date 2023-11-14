#ifndef TIME_H
#define TIME_H
#include <iostream>

class Time
{
public:
    Time(int hour, int minute, int second);
    Time operator+(const Time& time) const;
    Time& operator++();
    Time operator++(int);
    bool operator==(const Time& time) const;
    bool operator!=(const Time& time) const;
    bool operator<(const Time& time) const;
    bool operator>(const Time& time) const;
    bool operator<=(const Time& time) const;
    bool operator>=(const Time& time) const;
    friend std::ostream& operator<<(std::ostream& ost, Time& time);
    friend std::istream& operator>>(std::istream& ist, Time& time);

private:
    int hour;
    int minute;
    int second;
    void rationalize();
};

#endif