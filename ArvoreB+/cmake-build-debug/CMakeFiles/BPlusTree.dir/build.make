# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.9

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "C:\Users\fbeze\AppData\Roaming\JetBrains\CLion 2017.3.4\bin\cmake\bin\cmake.exe"

# The command to remove a file.
RM = "C:\Users\fbeze\AppData\Roaming\JetBrains\CLion 2017.3.4\bin\cmake\bin\cmake.exe" -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = C:\Users\fbeze\Desktop\Faculdade\SGBD\ce_trab1

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = C:\Users\fbeze\Desktop\Faculdade\SGBD\ce_trab1\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/BPlusTree.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/BPlusTree.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/BPlusTree.dir/flags.make

CMakeFiles/BPlusTree.dir/main.c.obj: CMakeFiles/BPlusTree.dir/flags.make
CMakeFiles/BPlusTree.dir/main.c.obj: ../main.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=C:\Users\fbeze\Desktop\Faculdade\SGBD\ce_trab1\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/BPlusTree.dir/main.c.obj"
	C:\PROGRA~2\MINGW-~1\I686-6~1.0-P\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles\BPlusTree.dir\main.c.obj   -c C:\Users\fbeze\Desktop\Faculdade\SGBD\ce_trab1\main.c

CMakeFiles/BPlusTree.dir/main.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/BPlusTree.dir/main.c.i"
	C:\PROGRA~2\MINGW-~1\I686-6~1.0-P\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E C:\Users\fbeze\Desktop\Faculdade\SGBD\ce_trab1\main.c > CMakeFiles\BPlusTree.dir\main.c.i

CMakeFiles/BPlusTree.dir/main.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/BPlusTree.dir/main.c.s"
	C:\PROGRA~2\MINGW-~1\I686-6~1.0-P\mingw32\bin\gcc.exe $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S C:\Users\fbeze\Desktop\Faculdade\SGBD\ce_trab1\main.c -o CMakeFiles\BPlusTree.dir\main.c.s

CMakeFiles/BPlusTree.dir/main.c.obj.requires:

.PHONY : CMakeFiles/BPlusTree.dir/main.c.obj.requires

CMakeFiles/BPlusTree.dir/main.c.obj.provides: CMakeFiles/BPlusTree.dir/main.c.obj.requires
	$(MAKE) -f CMakeFiles\BPlusTree.dir\build.make CMakeFiles/BPlusTree.dir/main.c.obj.provides.build
.PHONY : CMakeFiles/BPlusTree.dir/main.c.obj.provides

CMakeFiles/BPlusTree.dir/main.c.obj.provides.build: CMakeFiles/BPlusTree.dir/main.c.obj


# Object files for target BPlusTree
BPlusTree_OBJECTS = \
"CMakeFiles/BPlusTree.dir/main.c.obj"

# External object files for target BPlusTree
BPlusTree_EXTERNAL_OBJECTS =

BPlusTree.exe: CMakeFiles/BPlusTree.dir/main.c.obj
BPlusTree.exe: CMakeFiles/BPlusTree.dir/build.make
BPlusTree.exe: CMakeFiles/BPlusTree.dir/linklibs.rsp
BPlusTree.exe: CMakeFiles/BPlusTree.dir/objects1.rsp
BPlusTree.exe: CMakeFiles/BPlusTree.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=C:\Users\fbeze\Desktop\Faculdade\SGBD\ce_trab1\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable BPlusTree.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\BPlusTree.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/BPlusTree.dir/build: BPlusTree.exe

.PHONY : CMakeFiles/BPlusTree.dir/build

CMakeFiles/BPlusTree.dir/requires: CMakeFiles/BPlusTree.dir/main.c.obj.requires

.PHONY : CMakeFiles/BPlusTree.dir/requires

CMakeFiles/BPlusTree.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\BPlusTree.dir\cmake_clean.cmake
.PHONY : CMakeFiles/BPlusTree.dir/clean

CMakeFiles/BPlusTree.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" C:\Users\fbeze\Desktop\Faculdade\SGBD\ce_trab1 C:\Users\fbeze\Desktop\Faculdade\SGBD\ce_trab1 C:\Users\fbeze\Desktop\Faculdade\SGBD\ce_trab1\cmake-build-debug C:\Users\fbeze\Desktop\Faculdade\SGBD\ce_trab1\cmake-build-debug C:\Users\fbeze\Desktop\Faculdade\SGBD\ce_trab1\cmake-build-debug\CMakeFiles\BPlusTree.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/BPlusTree.dir/depend

