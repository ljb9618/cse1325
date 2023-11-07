#include "Square.h"
#include "Shape.h"


Square::Square(double base, double height)
{
    _base = base; _height = height;
}

string Square::name() const
{
    string returnString;
    returnString = "(" + std::to_string(_height) + " X " +  std::to_string(_base) + ")";
    return returnString + " Square";
}

double Square::area() const
{
    double Area = (_height * _base);
    return Area;
}