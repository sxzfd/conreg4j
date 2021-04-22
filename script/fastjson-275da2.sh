name=fastjson-275da2

echo "Pull bug ID: ${name} ...."

docker pull regminer/${name}:1.0

docker run --name ${name} -it -d regminer/${name}:1.0 /bin/bash 

touch ../bugs.csv

echo ${name} >> ../bugs.csv

echo "Success"

exit


