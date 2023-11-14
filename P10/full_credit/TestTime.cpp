#include <iostream>
#include <ostream>
#include <iomanip>
#include "Time.h"

std::ostream& operator<<(std::ostream& ost, Time& time) {
    ost << std::setfill('0') << std::setw(2) << time.hour << ":"
        << std::setfill('0') << std::setw(2) << time.minute << ":"
        << std::setfill('0') << std::setw(2) << time.second;
    return ost;
}
std::istream& operator>>(std::istream& ist, Time& time) {
    char first_colon, second_colon;
    int hr, min, sec;
    ist >> hr >> first_colon >> min >> second_colon >> sec;
    if (first_colon == ':' && second_colon == ':') {
        time = Time(hr, min, sec);
    }
    else {
        ist.setstate(std::ios::failbit);
    }
    return ist;
}
int main()
{
    return 0;
}