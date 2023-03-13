public class Student {
    private int id;
    private double gpa;
    private static Student[] students = new Student[100];
    private static int student_count;

    Student(){

    }
    Student(int id, double gpa){
        this.id = id;
        this.gpa = gpa;
        // Since we're using a static-array rather than an ArrayList, this statement will run if we exceed over
        // 100 students, thus enlarging arrays' size by double (just like an ArrayList would do).
        if (student_count > students.length){
            Student[] copy_students = new Student[students.length * 2];
            System.arraycopy(students, 0, copy_students, 0, students.length);
            students = copy_students;
        }
        students[student_count++] = this;
        // insertionSort(students); --commenting out because quick sort is much faster.
        quickSort(students, 0, student_count - 1);
    }

    public int getID(){
        return id;
    }
    public double getGPA(){
        return gpa;
    }
    public void setGPA(double new_gpa){
        this.gpa = new_gpa;
    }
    // The findStudent method is performing Binary Search on the students array to find the student with given GPA.
    // By performing Binary Search, the findStudent function is expected to run at Θ(logn) time complexity.
    public Student findStudent(double gpa){
        int student_index = binarySearch(gpa);
        if (student_index < 0) return null;
        return students[student_index];
    }

    private static int binarySearch(double gpa){
        int low_index = 0;
        int high_index = student_count - 1;
        while (low_index <= high_index){
            int middle_index = (low_index + high_index)/2;
            if (students[middle_index].getGPA() == gpa) return middle_index;
            else if (students[middle_index].getGPA() > gpa) high_index = middle_index - 1;
            else low_index = middle_index + 1;
        }
        return -1;
    }
    // Question 2 - Implementing Insertion Sort
    public static void insertionSort(Student[] students){
        // The Insertion Sort algorithm is based on "Decrease-by-one" approach. Assuming we have a student array with
        // n-number of students, the for-loop will iterate through the array until the "i" index reaches to the
        // student count (which the for-loop will run at a time complexity of Θ(n)) and the while-loop inside
        // the for-loop will keep comparing the GPA of j-student before the ith student to the GPA of the ith student
        // in our student array (which the while loop will also run at the complexity of Θ(n)).
        // As a result, since while-loop is inner loop of the for-loop, the Insertion Sort algorithm will be running
        // at a time complexity of Θ(n²).
        for (int i = 1; i < student_count; i++){
            Student current = students[i];
            int j = i - 1;
            while ((j != -1) && (students[j].getGPA() > current.getGPA())){
                students[j + 1] = students[j];
                j --;
            }
            students[j + 1] = current;
        }
    }
    // Question 3 - Augmenting our Solution by Implementing Quick Sort
    public static void quickSort(Student[] students, int low_index, int high_index){
        // Unlike the Insertion Sort algorithm, the Quick Sort algorithm is based on "Divide-and-Conquer" approach, and
        // is a recursive function. Assuming we have a student array with n-number of students, the array will be
        // divided into two-parts depending on our partition index (where the partition part will take place in this),
        // thus this part will run at a time complexity of Θ(logn). Inside the partition function, the GPA of the
        // last element/student is taken as pivot and according to that, the students with lower GPAs than the pivot
        // is placed at the left hand-side and the students with higher GPAs than the pivot placed at the right
        // hand-side (thus the partition part will run at a time complexity of Θ(n)). Since both partition and quickSort
        // are hand-to-hand, the Quick Sort algorithm will run at a time complexity of Θ(nlogn), and is a far better
        // solution compared to the Insertion Sort (which was running at a time complexity of Θ(n²)).
        if (low_index >= high_index) return;
        int partition_index = partition(students, low_index, high_index);
        quickSort(students, low_index, partition_index - 1);
        quickSort(students, partition_index + 1, high_index);
    }

    private static int partition(Student[] students, int low_index, int high_index){
        double pivot = students[high_index].getGPA();
        int index_1 = low_index - 1;
        for (int index_2 = low_index; index_2 < high_index; index_2++){
            if (students[index_2].getGPA() <= pivot){
                index_1++;
                swap(students, index_1, index_2);
            }
        }
        swap(students, index_1 + 1, high_index);
        return index_1 + 1;
    }

    private static void swap(Student[] students, int index_1, int index_2) {
        Student temp_for_swap = students[index_1];
        students[index_1] = students[index_2];
        students[index_2] = temp_for_swap;
    }
    // (Optional Method) To display our array to view the students array and to also
    // check our quickSort and/or insertionSort algorithms are executed correctly.
    public static void getStudents(){
        for (int i = 0; i < student_count; i++)
            System.out.println("Student ID: " + students[i].getID() + " || Student GPA: " + students[i].getGPA());
    }
}