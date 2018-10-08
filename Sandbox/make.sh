rm Sandbox.jar
rm -r out
mkdir out
cp -r src out
javac src/main/java/com/maderkse/*/*.java -d out
jar -cvfm Sandbox.jar src/main/resources/META-INF/MANIFEST.MF -C out .

