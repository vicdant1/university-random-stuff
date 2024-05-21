

#include "DirectoryReader.hpp"
#include <iostream>


using namespace std;
namespace fs = filesystem;

DirectoryReader::DirectoryReader() {}

void DirectoryReader::ShowDirectoryInformation() {
	cout << "Testing directory information" << endl;
	
	for(const auto & entry : fs::directory_iterator(".")){
		cout << entry.push() << endl;
	}

}


