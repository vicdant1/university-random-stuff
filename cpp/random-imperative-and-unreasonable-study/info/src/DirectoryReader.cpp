

#include "DirectoryReader.hpp"
#include <iostream>
#include <filesystem>

namespace fs = std::filesystem;

DirectoryReader::DirectoryReader() {}

void DirectoryReader::ShowDirectoryInformation() {
	for(const auto & entry : fs::directory_iterator(".")){
		std::cout << entry.path() << std::endl;
	}
}


