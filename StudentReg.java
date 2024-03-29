// TASK - 5
// STUDENT COURSE REGISTRATION SYSTEM
// Course Database:
// Store course information, including course code, title,
// description, capacity, and schedule.
// Student Database:
// Store student information, including student ID, name, and
// registered courses.
// Course Listing:
// Display available courses with details and available slots.
// Student Registration:
// Allow students to register for courses from the availableoptions.
// Course Removal:
// Enable students to drop courses they have registered for
import java.util.*;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private List<Student> students;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (students.size() < capacity) {
            students.add(student);
            System.out.println(student.getName() + " has been registered for " + title);
        } else {
            System.out.println("Sorry, the course is full.");
        }
    }

    public void removeStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            System.out.println(student.getName() + " has been unenrolled from " + title);
        } else {
            System.out.println(student.getName() + " is not enrolled in this course.");
        }
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }
}

class Student {
    private String studentId;
    private String name;
    private List<Course> courses;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void registerCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
        System.out.println(name + " has registered for " + course.getTitle());
    }

    public void dropCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
            course.removeStudent(this);
            System.out.println(name + " has dropped " + course.getTitle());
        } else {
            System.out.println(name + " is not enrolled in " + course.getTitle());
        }
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public List<Course> getCourses() {
        return courses;
    }
}

class CourseDatabase {
    private Map<String, Course> courses;

    public CourseDatabase() {
        this.courses = new HashMap<>();
    }

    public void addCourse(Course course) {
        courses.put(course.getCode(), course);
    }

    public Course getCourseByCode(String code) {
        return courses.get(code);
    }

    public Map<String, Course> getCourses() {
        return courses;
    }
}

class StudentDatabase {
    private Map<String, Student> students;

    public StudentDatabase() {
        this.students = new HashMap<>();
    }

    public void addStudent(Student student) {
        students.put(student.getStudentId(), student);
    }

    public Student getStudentById(String studentId) {
        return students.get(studentId);
    }
}

public class StudentReg {
    public static void displayCourseListing(CourseDatabase courseDatabase) {
        System.out.println("Available Courses:");
        for (Course course : courseDatabase.getCourses().values()) {
            int availableSlots = course.getCapacity() - course.getStudents().size();
            System.out.println("Code: " + course.getCode() + ", Title: " + course.getTitle() + ", Available Slots: " + availableSlots);
        }
    }

    public static void main(String[] args) {
        CourseDatabase courseDatabase = new CourseDatabase();
        StudentDatabase studentDatabase = new StudentDatabase();
        Scanner scanner = new Scanner(System.in);


        Course course1 = new Course("CP2024", "C language", "An introductory course to programming", 74, "Mon/Wed 9:00 AM");
        Course course2 = new Course("PY2024", "Python", "Python Programming", 62, "Tue/Thu/Sat 2:00 PM");
        Course course3 = new Course("JA2024", "JAVA", "JAva Programming", 62, "Mon/Wed/Fri 1:00 PM");
         Course course4 = new Course("MA2024", "MATHS", "MATHEMATICS",80, "Mon/Fri 4:00 PM");



        courseDatabase.addCourse(course1);
        courseDatabase.addCourse(course2);
       
        courseDatabase.addCourse(course3); courseDatabase.addCourse(course4);


        
        Student student1 = new Student("2023C001", "Rohit");
        Student student2 = new Student("2023C002", "Deepika");
        Student student3 = new Student("2023C003", "Sreeja");
        Student student4 = new Student("2023C002", "Sandhya");

        studentDatabase.addStudent(student1);
        studentDatabase.addStudent(student2);
        studentDatabase.addStudent(student3);
        studentDatabase.addStudent(student4);

        int choice;
        do {
            System.out.println("\n1. Register Course");
            System.out.println("2. Drop Course");
            System.out.println("3. Display Course Listing");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.nextLine();
                    Student student = studentDatabase.getStudentById(studentId);
                    if (student == null) {
                        System.out.println("Student not found.");
                        break;
                    }
                    displayCourseListing(courseDatabase);
                    System.out.print("Enter course code to register: ");
                    String courseCode = scanner.nextLine();
                    Course course = courseDatabase.getCourseByCode(courseCode);
                    if (course == null) {
                        System.out.println("Course not found.");
                        break;
                    }
                    student.registerCourse(course);
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    studentId = scanner.nextLine();
                    student = studentDatabase.getStudentById(studentId);
                    if (student == null) {
                        System.out.println("Student not found.");
                        break;
                    }
                    System.out.println("Courses enrolled by " + student.getName() + ":");
                    for (Course c : student.getCourses()) {
                        System.out.println(c.getTitle());
                    }
                    System.out.print("Enter course code to drop: ");
                    courseCode = scanner.nextLine();
                    course = courseDatabase.getCourseByCode(courseCode);
                    if (course == null) {
                        System.out.println("Course not found.");
                        break;
                    }
                    student.dropCourse(course);
                    break;
                case 3:
                    displayCourseListing(courseDatabase);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}