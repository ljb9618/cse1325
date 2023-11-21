#ifndef _LOCATION_H
#define _LOCATION_H
#include <iostream>
using namespace std;

class Location 
{
public:
    Location(const string& filename, int line);
    friend std::ostream& operator<<(std::ostream& ost, const Location& location);
    bool operator==(const Location& location) const;
    bool operator!=(const Location& location) const;
    bool operator<(const Location& location) const;
    bool operator>(const Location& location) const;
    bool operator<=(const Location& location) const;
    bool operator>=(const Location& location) const;

private:
    string filename;
    int line;
};

#endif