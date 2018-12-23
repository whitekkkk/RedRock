import java.io.IOException;
import java.util.Scanner;


public class FindStudent {
    public static void main(String []args)throws IOException {
        Scanner input = new Scanner(System.in);
        Student[] list = FileUtil.parseStudents("D:\\students.txt");
        String id = input.next();
        for (Student stu : list) {
            if (stu.getStuid().equals(id)) {
                if (stu.getName() != null) {
                    System.out.println("该学生存在");
                } else {
                    System.out.println("该学生不存在");
                }
            }
        }

    }
}
