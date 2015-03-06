#!/bin/sh


# get comment
comment="$1"

if [ "$comment" == "" ]; then
comment="push form CI"
echo "no comment specified to deploy, using default : $comment"
fi


sbt fullOptJS

ghPagesPath="/Users/chandrasekharkode/Desktop/Kode/Programming/scalaprojects/chandu0101.github.io"

projectName="sjsf"

projectPath=$ghPagesPath/$projectName

cp examples/index.html $projectPath

cp  examples/js/examples-opt.js $projectPath/js/

cp  examples/js/examples-jsdeps.js $projectPath/js/

cp -r examples/styles/ $projectPath/styles/
cp -r examples/images/ $projectPath/images/

cd $ghPagesPath

git add $projectName

git commit -a -m "$comment"

git push