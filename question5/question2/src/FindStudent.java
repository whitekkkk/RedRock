import java.io.IOException;

public class FindStudent {
    public static void main(String []args) throws IOException
    {
        int []a=new int [18826];
        Student [] list=FileUtil.parseStudents("D:\\students.txt");
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if (list[i].getName().equals(list[j].getName()))
                    a[i]++;
            }
        }
        int count= 0;
        int countindex = 0;
        for (int i = 0; i < list.length - 1; i++) {

            if (count <= a[i]) {
                count = a[i];
                countindex = i;// 输出最大值的索引
            }
        }
        System.out.println(list[countindex].getName() + "出现了" + count + "次");
    }
}
