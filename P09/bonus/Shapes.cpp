#include <iostream>
#include "Shape.h"
#include "Square.h"
#include "Circle.h"
#include <vector>

int main()
{
    std::vector<Shape*> S;

    Square square(4, 4);
    Square square2(10, 10);
    Circle circle(9);
    Circle circle2(13);

    S.push_back(&square);
    S.push_back(&square2);
    S.push_back(&circle);
    S.push_back(&circle2);


    for (int i = 0; i < S.size(); i++)
    {
        std::cout << S[i]->toString() << std::endl;
    }
    return 0;
}