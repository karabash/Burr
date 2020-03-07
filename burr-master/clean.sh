#!/bin/bash

find . -name '*.class' | xargs -r rm
rm -rf instrumented cobertura.ser cobertura_report test-output
