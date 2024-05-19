import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(Student[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(Student[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Student[] L = new Student[n1];
        Student[] R = new Student[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Student[] students = {
            new Student("Ruchira Lakshan", "2019T00472", 3.5),
            new Student("Praneeth Sandaruwan", "2019T00466", 3.7),
            new Student("Tharaka Nalindra", "2019T00459", 3.6),
            new Student("Sanjaya Nuwan", "2019T00453", 3.4),
            new Student("Gagana Sonnadara", "2019T00474", 3.1),
            new Student("Isindu Jayanetti", "2019T00450", 3.0),
            new Student("Tharaka Harischandra", "2019T00463", 3.2)
            
        };
        int n = students.length;
        mergeSort(students, 0, n - 1);

        System.out.println("Sorted student records:");
        System.out.println("\tName\t\t\tStudent No\tGrade");
        for (Student student : students) {
            System.out.printf("%-20s\t\t%-10s\t%.2f\n", student.name, student.id, student.grade);
        }
    }
}
class Student implements Comparable<Student> {
    String name;
    String id;
    double grade;

    public Student(String name, String id, double grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    @Override
    public int compareTo(Student other) {
        return Double.compare(this.grade, other.grade);
    }

    @Override
    public String toString() {
        return name + " |" + id + "| =>  " + grade;
    }
}
