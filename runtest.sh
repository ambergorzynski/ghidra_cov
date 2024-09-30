#!/bin/sh

GHIDRA=/data/dev/ghidra_cov

cd $GHIDRA

gradle buildGhidra
gradle jacocoReport
