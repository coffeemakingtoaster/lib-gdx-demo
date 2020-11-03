./gradlew desktop:dist
if [ $? -eq 0 ]; then
	echo Compile OK!
	echo Running compiled jar
	java -jar desktop/build/libs/desktop-1.0.jar
else
	echo Compile Failed!
fi
