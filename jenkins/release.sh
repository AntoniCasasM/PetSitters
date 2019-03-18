#!/usr/bin/env bash

echo 'The following Maven command installs your Maven-built Java application'
echo 'into the local Maven repository, which will ultimately be stored in'
echo 'Jenkins''s local Maven repository (and the "maven-repository" Docker data'
echo 'volume).'
set -x
mvn jar:jar install:install help:evaluate -Dexpression=project.name
set +x

echo 'The following complex command extracts the value of the <name/> element'
echo 'within <project/> of your Java/Maven project''s "pom.xml" file.'
set -x
NAME=`mvn help:evaluate -Dexpression=project.name | grep "^[^\[]"`
set +x

echo 'The following complex command behaves similarly to the previous one but'
echo 'extracts the value of the <version/> element within <project/> instead.'
set -x
VERSION=`mvn help:evaluate -Dexpression=project.version | grep "^[^\[]"`
set +x
test -f application.pid && xargs kill < application.pid || echo 'App was not running, nothing to stop'
echo 'The following command runs and outputs the execution of your Java'
echo 'application (which Jenkins built using Maven) to the Jenkins UI.'
# exit 1 on errors
set -e

# deal with remote
echo "Checking if remote exists..."
if ! git ls-remote heroku; then
  echo "Adding heroku remote..."
  git remote add heroku git@heroku.com:petshit.git
fi

# push only origin/master to heroku/master - will do nothing if
# master doesn't change.
echo "Updating heroku master branch..."
git push heroku origin/master:master