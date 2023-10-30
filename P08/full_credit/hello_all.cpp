#include <iostream>

int main() {
    std::string input;

    std::cout << "Enter your name: " << std::endl;
    std::getline(std::cin, input);

    std::cout << "Your name is " << input << std::endl;
    
    return 0;
}
