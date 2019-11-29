#run regression tests
COURSE_DIR= $$HOME/cs572
LIB_DIR = $(COURSE_DIR)/lib
BIN_DIR = $(COURSE_DIR)/bin

MAIN_CLASS = cs572.Tl0

MAKEFLAGS += --no-print-directory

PROG = ../main.py

#filters out coord's to make tests less brittle
test:
			@isOk=true; \
			for t in *.gold; \
			do \
			  tst=`basename $$t .gold`.tst ; \
			  rm -f $$tst ; \
			  $(MAKE) $$tst ; \
			  sed -e 's/coord=[^ ]*//' $$t > $$t.tmp ; \
			  sed -e 's/coord=[^ ]*//' $$tst > $$tst.tmp ; \
			  if cmp $$t.tmp $$tst.tmp 2>/dev/null ;  \
			  then \
			    echo $$tst ok ; \
			    rm $$tst $$t.tmp $$tst.tmp; \
			  else \
			    echo $$tst FAIL ; \
			    isOk=false ; \
			  fi \
			done ; \
			$$isOk

%.tst:			%.walnut
			@rm -f $@.text
			@touch $@.text
			@$(PROG) -o $@ $< 2>$@.err || true
			@cat $@.text $@.err >$@
			@rm -f $@.text $@.dot $@.xml $@.err

#run make diff after failing tests to see diffs
.PHONY:			diff
diff:
			for f in *.tst.tmp; \
			do \
			  echo "******* $$f"; \
			  diff -y --suppress-common-lines \
			    `basename $$f .tst.tmp`.gold.tmp $$f; \
			done

#run make ok after *.tst failing tests have been validated manually
.PHONY:			ok
ok:
			for f in *.tst; \
			do \
			  mv $$f `basename $$f .tst`.gold; \
			done
