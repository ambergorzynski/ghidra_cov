#!/bin/sh

GHIDRA=/data/dev/ghidra_cov

cd $GHIDRA

gradle :IntegrationTest:integrationTest --tests FuzzerTest -x sleighCompile -x buildHelp

