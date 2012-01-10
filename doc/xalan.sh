#!/bin/bash

java org.apache.xalan.xslt.Process -IN fissuresDoc.xml -XSL ~/docbook/docbook/html/docbook.xsl -OUT fissures.html
