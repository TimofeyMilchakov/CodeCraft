1.Overall Introduction
    
(1) Use build.sh for compilation and packing. 
(2) If the compilation succeeds, the executable binary file cdn.jar will be generated in the bin/ directory. 
(3) Use the following command to invoke and debug your program:   
    Linux environment: root> sh startup.sh /xxx/topo.txt /xxx/result.txt
    NOTE: In the preceding command, topo.txt is the input file and result.text is the output file. 
(4) Compress the code and makelist.txt file to one package in tar.gz format, and then upload it. 
    cdn.tar.gz(end with tar.gz or zip, the file name can not contain spaces and characters.)
    |
    |-- bin/	
    |-- code/   
    |-- makelist.txt  
    |-- build.sh		Can not be modified or deleted  
    |-- cdn_tar.sh  
    |-- readme.txt	


2.SDK Directory Structure
    
SDK-java.zip/
|-- bin/				 		        Binary file path.
|    |-- cdn.jar						Executable JAR file that is generated using the build.sh.
|    |-- startup.sh						Execution script for the Linux environment.
|-- code/							Source code path.
|    |-- cdn/   
|         |-- bin/						Class file created after the compilation.
|         |-- src/						Java source code path.
|              |-- com/
|                   |-- filetool/
|                           |-- main/
|                                 |-- Main.java			Main function source file, which cannot be modified.
|                           |-- util/
|                                 |-- FileUtil.java		Source file providing file reading and writing functions, which cannot be modified. 
|                                 |-- LogUtil.java		Source file providing the log recording function, which cannot be modified.
|                   |-- cacheserverdeploy/
|                                 |-- deploy/
|                                       |--Deploy.java		Source file where you code, which is required to be modified.   
|-- build.sh							Compilation and packing script for the Linux environment, which cannot be modified. It create cdn.jar    
|-- makelist.txt						Java files to be compiled, which are invoked by scripts. 
|-- cdn_tar.sh							Packing script, which generates the cdn.tar.gz package.
|-- readme.txt							The file you are reading.
    
NOTE:
 (1)The makelist.txt file needs to be modified if a source file is added.
 (2)If an error is reported indicating that the thirteen line of the startup.sh file is faulty during the runtime, modify this line based on your local system condition. The startup.sh script is just for debugging.


3.SDK Code Description
  Now, necessary information has been explained. What you need to do is as follows:
 (1) Implement the XXX method in the Deploy.java file.
 (2) Return and output the result.
 (3) Output NA If there is no solution.
The SDK provides the functions of reading files, writing files in required format, and printing the start and end time. The SDK prints read information to to facilitate debugging. You can delete the information if necessary.   
NOTE:
  The function of reading files refers to reading the image information files and path information files by lines to the memory. The file storage format remains to be the character string format. The storage format is related to the algorithm design, which will spark your thoughts. 


4.Note 
 Please note that only the code source file you have modified or added can be submitted in the preliminary. The compilation will be performed on the contest question server. Therefore, special attentions must be paid to the following things:
(1) The code development must be based on the SDK. Otherwise, the compilation fails. 
(2) In the SDK source files, only Deploy.java and makelist.txt files can be modified. Do not modify other files, otherwise it may compile failed;
(3) Use the cdn_tar.sh script to pack and compress files, ensuring that the file directory structure is correct.
(4) Use JDK 1.7.
