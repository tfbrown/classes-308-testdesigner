#/bin/bash

SCRIPT_PATH=$(cd $(dirname "$0"); pwd)

cd $SCRIPT_PATH
rm -rf doc/
mkdir doc
cd doc
javadoc -sourcepath ../src/ -subpackages edu.calpoly.csc.wiki.ratz
