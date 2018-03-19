#!/bin/bash

FILE=$1
again=true
counter=0
motors=()
file=$FILE.java


echo "import com.qualcomm.robotcore.hardware.DcMotor;" >> $file
echo "import com.qualcomm.robotcore.hardware.HardwareMap;" >> $file
echo "" >> $file

while [ "$again" = true ]
do
echo Motor Name:
read motor
motors[$counter]=$motor
counter=$counter+1
echo Again\(y/n\)\:
read bool
if [ "$bool" = y ]
then
again=true
fi
if [ "$bool" = n ]
then
again=false
fi
done

echo "public class hardwareMap(){" >> $file
for i in "${motors[@]}"
do
echo "	public DcMotor $i = null;" >> $file
done
echo "" >> $file
echo "	HardwareMap hwMap = null;" >> $file
echo "" >> $file
echo "	public $file(){" >> $file
echo "	}" >> $file
echo "" >> $file
echo "	public void init(HardwareMap ahwMap){" >> $file
echo "		hwMap = ahwMap;" >> $file
for i in "${motors[@]}"
do
echo "		$i = hwMap.dcMotor.get(\"$i\");" >> $file
done
echo "	}" >> $file
echo "" >> $file
echo "}" >> $file
clear

for i in "${motors[@]}"
do
echo $i
done

echo Done

