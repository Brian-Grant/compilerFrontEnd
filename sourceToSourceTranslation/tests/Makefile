#run regression tests
COURSE_DIR= $$HOME/cs572
LIB_DIR = $(COURSE_DIR)/lib
BIN_DIR = $(COURSE_DIR)/bin

MAIN_CLASS = cs572.Tl0

MAKEFLAGS += --no-print-directory

TLO = ../tl0

test:
			@isOk=true; \
			for t in *.gold; \
			do \
			  tst=`basename $$t .gold`.tst ; \
			  rm -f $$tst ; \
			  $(MAKE) $$tst ; \
			  if cmp $$t $$tst 2>/dev/null ;  \
			  then \
			    echo $$tst ok ; \
			    rm $$tst ; \
			  else \
			    echo $$tst FAIL ; \
			    isOk=false ; \
			  fi \
			done ; \
			$$isOk

%-tokens.text.tst:	%.tl0
			@$(TLO) -t $@ $< >/dev/null


%-ast.text.tst:		%.tl0
			@$(TLO) -a $@ $< >/dev/null

%-ast.xml.tst:		%.tl0
			@$(TLO) -a $$$$.xml $< >/dev/null ; \
			mv $$$$.xml $@ 

%-sem.text.tst:		%.tl0
			@$(TLO) -s $@ $< >/dev/null

%-sem.xml.tst:		%.tl0
			@$(TLO) -s $$$$.xml $< >/dev/null ; \
			mv $$$$.xml $@

%-xform.tl0.tst:	%.tl0
			@$(TLO) --let $$$$.tl0 $< >/dev/null ; \
			mv $$$$.tl0 $@

%-xform.tl0:		%.tl0
			@$(TLO) --let $$$$.tl0 $< >/dev/null ; \
			mv $$$$.tl0 $@

%-err.tst:		%.tl0
			@$(TLO) $< 2>$@ >/dev/null || true

%.j:			%.tl0
			$(TLO) $< >$@

%-run.tst:		%.tl0
			@rm -f `basename $< .tl0`.j
			@$(MAKE) `basename $< .tl0`.j
			@$(BIN_DIR)/jrun $(MAIN_CLASS) `basename $< .tl0`.j \
				 > $@
