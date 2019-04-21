# Make an executable jar file.
# cvfm flag means "create a jar; show verbose output; specify the output jar file name; specify the manifest file name"

JARFILE = ListTest
MAINCLASS = ListTest
SOURCES = List.java ListInterface.java ListTest.java\
	  ListIndexOutOfBoundsException.java
CLASSES = List.class ListInterface.class ListTest.class List\$$Node.class\
	  ListIndexOutOfBoundsException.class

# Build targets
all: $(JARFILE)

$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Manifest
	jar cvfm $(JARFILE) Manifest $(CLASSES)
	rm Manifest
	chmod +x $(JARFILE)

$(CLASSES): $(SOURCES)
	javac -Xlint $(SOURCES)

clean:
	rm $(CLASSES) $(JARFILE)
