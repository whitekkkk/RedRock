public class Main {
    public static void main(String []args)
    {
        Senior senior=new Senior();
        Student stu=new Student("tom",7894,1);
        int allPoint=stu.getPoint(senior.check(stu.getWorkLv()));
        Store store=new Store();
        System.out.println(stu.getName()+store.getGoods(allPoint));
    }
}
