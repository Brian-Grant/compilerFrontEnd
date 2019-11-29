COURSE_DIR = $(HOME)/cs572
ANTLR = $(COURSE_DIR)/bin/antlr4
GRUN = $(COURSE_DIR)/bin/grun
ANTLR_JAR = /usr/local/share/java/antlr-4.7.2-complete.jar

GEN_DIR = gen
JAVA_DIR = $(GEN_DIR)/java
PYTHON_DIR = $(GEN_DIR)/python

BASE = Walnut

BUILDER = $(BASE)AstBuilder.py
VISITOR = $(PYTHON_DIR)/$(BASE)Visitor.py

TARGET = $(VISITOR) $(JAVA_DIR)/$(BASE).class

all:			$(TARGET)

%-ast:			%.walnut $(VISITOR) $(BUILDER)
			$(MAKE) $(VISITOR)
			./$(BUILDER) -g $<
			base=`basename $< .walnut`; dir=`dirname $<`; \
			if [ $$? -eq 0 ] ; \
			  then \
			    dot -Tpng $$dir/$$base.dot \
			      -o $$dir/`basename $< .walnut`.png ; \
			    rm -f $$dir/$$base.dot ; \
			  fi

#rule to build visitor code from an antlr grammar file
$(VISITOR): 		$(BASE).g4
			mkdir -p $(PYTHON_DIR)
			$(ANTLR) -o $(PYTHON_DIR) -Dlanguage=Python3 \
			  -no-listener -visitor $<

#generate java parser and compile generated java to .class files.
#necessary in order to run grun.
$(JAVA_DIR)/%.class:	%.g4
			mkdir -p $(JAVA_DIR)
			$(ANTLR) -o $(JAVA_DIR) $<
			(cd $(JAVA_DIR); \
			 rm -f *.class; \
                         javac -cp ".:$(ANTLR_JAR)" *.java)

.PHONY:			clean jclean
jclean:
			rm -f $(JAVA_DIR)
clean:
			rm -rf gen *~


