package Thread;

import Http.Httpj;

public class Thread16 implements Runnable{
    @Override
    public void run()//重写
    {
        int k=20162099;
        for(int i=0;i<=100;i++)
        {
            k++;
            String j=k+"";
            try {
                Httpj.aa(j);
                Thread.currentThread().sleep(500); //线程休眠
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
