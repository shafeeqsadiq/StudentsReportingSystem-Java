import java.util.ArrayList;
import java.util.List;

public class StudentsReportingSystem {
    // A class to represent a student
    static class Student {
        private String name;
        private List<Marks> marksList;

        public Student(String name) {
            this.name = name;
            this.marksList = new ArrayList<>();
        }

        public void addMarks(Marks marks) {
            marksList.add(marks);
        }

        public String getName() {
            return name;
        }

        public List<Marks> getMarksList() {
            return marksList;
        }
    }

    // A class to represent the marks of a student in a particular subject and semester
    static class Marks {
        private int semester;
        private String subject;
        private int marks;

        public Marks(int semester, String subject, int marks) {
            this.semester = semester;
            this.subject = subject;
            this.marks = marks;
        }

        public int getSemester() {
            return semester;
        }

        public String getSubject() {
            return subject;
        }

        public int getMarks() {
            return marks;
        }
    }

    // A class to represent the students reporting system
    static class StudentsReporting {
        private List<Student> students;

        public StudentsReporting() {
            this.students = new ArrayList<>();
        }

        public void addStudent(Student student) {
            students.add(student);
        }

        public List<Student> getStudents() {
            return students;
        }

        // Method to calculate the average percentage of the whole class in the recent semester
        public double averagePercentageRecentSemester() {
            int totalMarks = 0;
            int totalMaxMarks = 0;
            int recentSemester = 0;
            for (Student student : students) {
                for (Marks marks : student.getMarksList()) {
                    if (marks.getSemester() > recentSemester) {
                        recentSemester = marks.getSemester();
                    }
                }
            }
            for (Student student : students) {
                for (Marks marks : student.getMarksList()) {
                    if (marks.getSemester() == recentSemester) {
                        totalMarks += marks.getMarks();
                        totalMaxMarks += 100;
                    }
                }
            }
            return (double) totalMarks / totalMaxMarks * 100;
        }

        // Method to calculate the average marks of students in a particular subject
        // Method to calculate the average marks of students in a particular subject
        public double averageMarksSubject(String subject) {
            int totalMarks = 0;
            int totalStudents = 0;
            for (Student student : students) {
                for (Marks marks : student.getMarksList()) {
                    if (marks.getSubject().equals(subject)) {
                        totalMarks += marks.getMarks();
                        totalStudents++;
                    }
                }
            }
            return (double) totalMarks / totalStudents;
        }

        // Method to find the top 2 consistent students across all semesters
        public List<Student> topConsistentStudents() {
            List<Student> topStudents = new ArrayList<>();
            double maxAvg = Double.MIN_VALUE;
            for (Student student : students) {
                double avg = 0;
                int totalMarks = 0;
                int totalSubjects = 0;
                for (Marks marks : student.getMarksList()) {
                    totalMarks += marks.getMarks();
                    totalSubjects++;
                }
                avg = (double) totalMarks / totalSubjects;
                if (avg > maxAvg) {
                    maxAvg = avg;
                    topStudents.clear();
                    topStudents.add(student);
                } else if (avg == maxAvg) {
                    topStudents.add(student);
                }
            }
            return topStudents;
        }
    }

    public static void main(String[] args) {
        StudentsReporting reporting = new StudentsReporting();
        Student s1 = new Student("John");
        s1.addMarks(new Marks(1, "English", 85));
        s1.addMarks(new Marks(1, "Maths", 90));
        s1.addMarks(new Marks(1, "Science", 80));
        s1.addMarks(new Marks(2, "English", 75));
        s1.addMarks(new Marks(2, "Maths", 85));
        s1.addMarks(new Marks(2, "Science", 70));
        reporting.addStudent(s1);
        Student s2 = new Student("Jane");
        s2.addMarks(new Marks(1, "English", 75));
        s2.addMarks(new Marks(1, "Maths", 80));
        s2.addMarks(new Marks(1, "Science", 70));
        s2.addMarks(new Marks(2, "English", 85));
        s2.addMarks(new Marks(2, "Maths", 90));
        s2.addMarks(new Marks(2, "Science", 80));
        reporting.addStudent(s2);
        Student s3 = new Student("Mike");
        s3.addMarks(new Marks(1, "English", 70));
        s3.addMarks(new Marks(1, "Maths", 75));
        s3.addMarks(new Marks(1, "Science", 65));
        s3.addMarks(new Marks(2, "English", 80));
        s3.addMarks(new Marks(2, "Maths", 85));
        s3.addMarks(new Marks(2, "Science", 75));
        reporting.addStudent(s3);
        // Calculate the average percentage of the whole class in the recent semester
        System.out.println("Average percentage of the whole class in the recent semester: " + reporting.averagePercentageRecentSemester() + "%");
        // Calculate the average marks of students in the "Maths" subject
        System.out.println("Average marks of students in the Maths subject: " + reporting.averageMarksSubject("Maths"));
        // Find the top 2 consistent students across all semesters
        List<Student> topStudents = reporting.topConsistentStudents();
        System.out.println("Top consistent students across all semesters:");
        for (Student student : topStudents) {
            System.out.println(student.getName());
        }
    }
}

// This code defines three classes: Student, Marks, and StudentsReporting. The Student class represents a student with a name and a list of their
// marks in different subjects and semesters. The Marks class represents the marks of a student in a particular subject and semester. The
// StudentsReporting class represents the students reporting system, which contains a list of students and provides methods for calculating the
// average percentage of the whole class in the recent semester, the average marks of students in a particular subject, and the top 2 consistent
// students across all semesters.
//
//In the main method, we create three Student objects and add them to a StudentsReporting object. Then, we call the various methods provided by
// the StudentsReporting class to perform the desired calculations and print the results.

