#!/bin/sh

GHIDRA=/data/dev/ghidra_cov

cd $GHIDRA

gradle jacocoReport -x sleighCompile -x buildHelp
