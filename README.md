# CSV-Data-Transformation-Script
This GitHub repository contains a Java program that demonstrates how to read and transform CSV data from two input files into a new CSV file. The program combines and processes data based on a common key and outputs the result into a new file.

## This Java program is designed to read and transform CSV data from two input files into a new CSV file. It performs the following tasks:
1. Reads data from a CSV file (2.csv) and stores it in a HashMap, using a specific column as the key.
2. Reads data from another CSV file (1b.csv) and processes it based on the keys found in the first file.
3. Combines the data from both files based on the common key and writes the result to an output CSV file (output.csv).

The program assumes that the common key for matching is in the 5th column of the CSV files (values[4]). You can adjust this index if your data structure is different.
