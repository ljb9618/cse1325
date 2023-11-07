#ifndef _SQUARE_H
#define _SQUARE_H
#include "Shape.h"
#include <string>

using std::string;
class Square: public Shape
        {
public:
    Square(double base, double height);
    string name() const override;
    double area() const override;

private:
    double _base;
    double _height;
};

#endif