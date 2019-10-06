# ExcelTransliterator
Jar transliterates English letters to georgian letters in Excel.

# Specification
* Only works with excel 97-2003 workbook 
* is only capable to edit string values

# Arguments
1) fileFullPath name included
2) boolean - to ignore First row
3) Nth column (you can specify multiple decimals)

# Example 
java -jar excelTransliterator-jar-with-dependencies.jar "C:/Users/User/Desktop/file.xls" true 2 3
* filePath - "C:/Users/User/Desktop/file.xls"
* ignoreFirstRow - true
* Index of columns to edit - 2,3 (counting from 1)

# Overview
in a nutshell it is designed for very specific purpose, grimly does its work
and sits motionless till it's time to work again.
