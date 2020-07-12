**Steps to run the project**
1) either run it with direct java as single file java 
2) Maven project 
    
    ```mvn clean compile assembly:single ```
    
    ``` java -jar target/my-app-1.0-SNAPSHOT-jar-with-dependencies.jar```
 Sample explaination 
 
 
```
java -jar target/my-app-1.0-SNAPSHOT-jar-with-dependencies.jar 
   6 4 
   rowsCount=4   Col count = 6
   0 0 0 0 0 0
    0 0 0 0 0 0
    0 0 0 0 0 0
    0 0 0 0 0 1
   [0, 0, 0, 0, 0, 0]
   [0, 0, 0, 0, 0, 0]
   [0, 0, 0, 0, 0, 0]
   [0, 0, 0, 0, 0, 1]
   Steps required to completely fill matrix is = 8
```
in above example I insered the col count and row count at 6 4
and then Input matrix is 

```
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 1
````
and reponse will be ```Steps required to completely fill matrix is = 8```