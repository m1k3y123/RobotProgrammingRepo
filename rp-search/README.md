# Search Interfaces for Robot Programming Exercise 4

This repository contains search interfaces, some small helper classes and some test problems which you can use in Exercise 4. 

## Getting the code

To use this code in your project you first need to clone the project into your Eclipse workspace. The following assumes you use the directory `~/workspace` as your Eclipse workspace as it is the default value. If this is not true, then replace this directory with the correct one for you. 

1. Open a terminal
2. Change into your workspace directory: `cd ~/workspace`
3. Clone this project using Git: `git clone https://github.com/hawesie/rp-search`
4. In Eclipse, create a new leJOS NXT project with the name `rp-search`. This should automatically find the sources you just cloned. You could also create a leJOS PC or standard Java project for this code, but using a leJOS NXT project ensures that this code should run on the robot too.

## Using the code

You should develop your own code in a *separate project* to `rp-search` as this will allow you to easily update the provided code if necessary. To do this, use the `Java Build Path` entry in your other project's properties, and `Add...` the `rp-search` project under the `Projects` tab.

The interfaces are only provided as a guideline. If you want to ignore them, or change them (for the better), please feel free to do so. If you wish to change them, you can [fork this repository](https://github.com/hawesie/rp-search/fork) to create your own copy. 

## Fixing bugs

If you find any bugs in my code, please open an [issue](https://github.com/hawesie/rp-search/issues) or create a pull request with the fix.
