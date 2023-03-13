# UniversityStudentSystem
A project that simulates an university system where a set number of students (100 students in this given case) are added and ranked 
according to their GPAs in an increasing order.

The following UML Diagram has been implemented in Java in order to create the university student system.

-------------------------------------
| Student                           |
| -id: int                          | 
| -gpa: double                      |
| -students: Student[]              |
-------------------------------------
| Student(id: int, gpa: double)     |
| getID(): int                      |
| getGPA(): double                  |
| setGPA(gpa: double)               |
| findStudent(gpa: double): Student |
-------------------------------------

Note: " -students: Student[] " is static, as it's underlined on UML notation (which README.md writage on GitHub didn't allow to underline...)

The findStudent method is performing a binary search on the students array to find the student with the given GPA, and is running in 𝜃(𝑙𝑜𝑔𝑛) time complexity. 
Write a main method that generates 100 students with random 5 digit ID, and random double value GPA between 0 and 4. Although using an ArrayList or a VectorList
would be much beneficial in our actual system, it's refrained from usage on this project to see if there could be any workarounds (which it was possible by creating
an array by doubled the size of our orijinal array [sort of like an ArrayList] and the previous objects were copied on the new array and overwritted the old/previous
array).

There are also Insertion Sort and Quick Sort algorithms that are implemented on the Student class where those will be run as a new instance of Student object has
been created (although Insertion Sort algorithm is commented out on this case since it runs much slower [Θ(n²)] compared to Quick Sort algorithm [Θ(nlogn)]).
