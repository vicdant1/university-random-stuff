
cmake_minimum_required(VERSION 3.2)

project(info)

add_executable(${PROJECT_NAME} 
	src/main.cpp
	src/DirectoryReader.cpp
	)

install(TARGETS ${PROJECT_NAME} DESTINATION bin) 


target_include_directories(${PROJECT_NAME} PUBLIC include)

