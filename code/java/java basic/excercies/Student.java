package wiproPracticeDay1;

public class Student {
    String name;
    int age;
    String course;
    int marks;
    int rollnum;
    static int rollNumCount = 1000; 

    public Student(String name, int age, String course, int marks) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
        this.rollnum = rollNumCount++;
    }

    public Student(String name, int age, String course, int marks, int rollnum) {
		super();
		this.name = name;
		this.age = age;
		this.course = course;
		this.marks = marks;
		this.rollnum = rollnum;
	}

	public void isPass() {
        if (marks >= 40) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }
    }

    public void print() {
        System.out.println("Roll No: " + rollnum);
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("Course : " + course);
        System.out.println("Marks  : " + marks);
        System.out.print("Status : ");
        isPass();
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {
        Student s1 = new Student("Chandu", 24, "Java", 75);
        Student s2 = new Student("Dharani", 23, "Python", 38);
        Student s3 = new Student("Kiran", 22, "Data Science", 90);

        s1.print();
        s2.print();
        s3.print();
    }
}
