#!/bin/bash

SCRIPT_PATH=$(cd $(dirname "$0"); pwd)

type -P mvn &>/dev/null || {
   echo "Maven2 is required to deploy Test Designer. Please install Maven2 and try again." >&2
   exit 1
}

cd $SCRIPT_PATH

echo "Cleaning..."
rm -rf target
echo "Building..."
mvn package
