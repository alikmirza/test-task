default:
  cat ./vv
dist: keystore
  ./gradlew clean build

  java -jar build/libs/test-task-0.0.1-SNAPSHOT.jar