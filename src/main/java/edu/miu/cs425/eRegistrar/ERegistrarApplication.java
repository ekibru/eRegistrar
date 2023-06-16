package edu.miu.cs425.eRegistrar;

import edu.miu.cs425.eRegistrar.enitity.Classroom;
import edu.miu.cs425.eRegistrar.enitity.Course;
import edu.miu.cs425.eRegistrar.enitity.Student;
import edu.miu.cs425.eRegistrar.enitity.Transcript;
import edu.miu.cs425.eRegistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ERegistrarApplication  implements CommandLineRunner{
	@Autowired
	private StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(ERegistrarApplication.class, args);
	}

		@Override
		public void run(String... args) throws Exception {

			System.out.println("Application is Started");



			var transcript1 = new Transcript("BS Computer Science");
			var transcript2 = new Transcript("BS Computer Science");

			var classroom1 = new Classroom("McLaughlin building","M105");
			var classroom2 = new Classroom("Verihill building","V11");

			var course1 = new Course("CS401","Modern Prog Practices");
			var course2 = new Course("CS390","FPP");
			var course3 = new Course("CS4750","WAP");

			var anna = new Student("000-61-0001","Anna","Lynn","Smith",
					3.45, LocalDate.of(2019,05,24));
			var mike = new Student("000-61-0002","Mike","Lala","John",
					3.75, LocalDate.of(2012,05,24));

			List<Student> studentLists = new ArrayList<>(Arrays.asList(anna,mike));
			List<Course> courseLists = new ArrayList<>(Arrays.asList(course1,course2,course3));

			anna.setTranscript(transcript1);
			mike.setTranscript(transcript2);
			anna.setClassroom(classroom1);
			mike.setClassroom(classroom2);
			anna.setCourses(courseLists);
			mike.setCourses(courseLists);

			transcript1.setStudent(anna);
			transcript2.setStudent(mike);

			classroom1.setStudents(studentLists);
			classroom2.setStudents(studentLists);

			course1.setStudentList(studentLists);
			course2.setStudentList(studentLists);
			course3.setStudentList(studentLists);

			var student1 = createsStudent(anna);
			var student2 = createsStudent(mike);


			System.out.println(student1);
			System.out.println(student2);
			System.out.println("Application is End");
		}

	private Student createsStudent(Student student){

		return studentService.saveStudent(student);
	}
/*
You are expected to implement the following 5 basic use-cases:

Display a homepage for the web app (e.g. url - http://localhost/eregistrar/home etc) which presents menu of items/links on a navigation bar.
Display List of Students - presents to the user, a list of all the students who have been registered in the university. You may display the data in an html table.
Register a New Student - enables the user (e.g. the university registrar) to add a new Student into the system, using an html form.
Edit a Student's registration data - enables the user (e.g. the university registrar) to retrieve a Student's registration data, update it and save the change(s) to into the system.
Delete a student's registration data.
Also add a feature in the application, to provide a means for the user to be able to search for Students.
Note: The specification for Student data, is as follows:
{
   studentId : (should be the primary key field)
   studentNumber: e.g. 000-61-0001 (required)
   FirstName: e.g. Anna (required)
   MiddleName: (optional)
   LastName: e.g. Smith (required)
   cgpa: e.g. 3.78 (optional)
   enrollmentDate: e.g. 2019-5-12 (required)
   isInternational: (values: "Yes", "No") (required) - Hint: Implement/present this data in a drop-down list or Radio button

When complete: Take screenshots of your eRegistrar screens and add them to a subfolder inside your project named screenshots; zip your project folder into a zip file named, eregistrar.zip and upload/Submit here on Sakai or push to your github and submit its url to sakai. (Advice: Use the elibrary project (shown in class) as a guide)
//-- Enjoy --//
 */

}
