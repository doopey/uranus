mvn clean -Dmaven.test.skip=true package
nohup java -jar target/uranus-0.0.1-SNAPSHOT.jar &
