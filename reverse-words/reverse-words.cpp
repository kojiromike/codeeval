#include <iostream>
#include <fstream>

using namespace std;
/**
 * Given a file that contains multiple sentences, one per line, where empty lines are also possible,
 * Write a program which reverses the words in each input sentence,
 * And prints to stdout each sentence with the reversed words in it, one per line.
 *
 * Empty lines in the input should be ignored. Ensure that there are no trailing empty spaces in each line you print.
 */
int main(int argc, char *argv[]) {
    ifstream stream(argv[1]);
    string line;
    std::size_t head;
    std::size_t tail;
    while (getline(stream, line)) {
        tail = line.find_last_not_of(' ');
        head = line.find_last_of(' ', tail);
        while (head != tail) {
            if (head == std::string::npos) {
                std::cout << line.substr(0, 1 + tail) << '\n';
                break;
            }
            std::cout << line.substr(1 + head, tail - head) << ' ';
            tail = line.find_last_not_of(' ', head);
            head = line.find_last_of(' ', tail);
        }
    }
    return 0;
}
