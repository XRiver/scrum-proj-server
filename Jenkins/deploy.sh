#!/bin/bash

# Make sure that maven has downloaded needed jars for "help:evaluate"
mvn help:evaluate -Dexpression=project.name

NAME=`mvn help:evaluate -Dexpression=project.name | grep "^[^\[]"`
VERSION=`mvn help:evaluate -Dexpression=project.version | grep "^[^\[]"`

# Environment variables needed.
JARNAME=$NAME-$VERSION.jar
BUILDDIR=target/
DEPLOYDIR=/tmp/project-jar/

# Create DELPOYDIR if needed
if [ ! -d $DIR/backup ];then
   mkdir -p $DEPLOYDIR
fi

# Kill previous SpringBoot processes.
ps -ef | grep $NAME | grep -v grep | awk '{print $2}' | xargs kill -9

# Remove previous jar.
rm -f $DEPLOYDIR/$JARNAME

# Copy new jar to DEPLOYDIR.
cp $BUILDDIR/$JARNAME $DEPLOYDIR

# Execute the jar and wait for a little log.
java -jar $DEPLOYDIR/$JARNAME > $DEPLOYDIR/out.log &

if [ $? = 0 ];then
        sleep 30
        tail -n 50 out.log
fi
