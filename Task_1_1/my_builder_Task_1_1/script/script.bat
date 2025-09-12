cd ..
javac src/HeapSort.java -d class
javadoc src/HeapSort.java -d doc
jar --create --file heapsort.jar --main-class HeapSort -C class .
java -cp class HeapSort
java -jar heapsort.jar
