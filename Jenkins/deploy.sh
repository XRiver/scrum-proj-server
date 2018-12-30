#!/bin/bash

NAME=`mvn help:evaluate -Dexpression=project.name | grep "^[^\[]"`
VERSION=`mvn help:evaluate -Dexpression=project.version | grep "^[^\[]"`

JARNAME=$NAME-$VERSION
BUILDDIR=target/
DEPLOYDIR=/tmp/project-jar/


if [ ! -d $DIR/backup ];then
   mkdir -p $DEPLOYDIR
fi

ps -ef | grep $JARFILE | grep -v grep | awk '{print $2}' | xargs kill -9

rm -f $DEPLOYDIR/$JARNAME

cp $BUILDDIR/$JARNAME $DEPLOYDIR

java -jar $DEPLOYDIR/$JARNAME > $DEPLOYDIR/out.log &

if [ $? = 0 ];then
        sleep 30
        tail -n 50 out.log
fi
