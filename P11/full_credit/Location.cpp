#include "Location.h"
Location::Location(const string& filename, int line) : filename(filename), line(line)
{

}

std::ostream& operator<<(std::ostream& ost, const Location& location)
{
    ost << "Filename " << location.filename << " Line Number " << location.line;
    return ost;
}

bool Location::operator==(const Location& location) const 
{
    return filename == location.filename && line == location.line;
}

bool Location::operator!=(const Location& location) const 
{
    return !(*this == location);
}

bool Location::operator<(const Location& location) const 
{
    return filename < location.filename || (filename == location.filename && line < location.line);
}

bool Location::operator>(const Location& location) const 
{
    return filename > location.filename || (filename == location.filename && line > location.line);
}

bool Location::operator<=(const Location& location) const 
{
    return *this < location || *this == location;
}

bool Location::operator>=(const Location& location) const 
{
    return *this > location || *this == location;
}
