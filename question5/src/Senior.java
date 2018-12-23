public class Senior {
    public String name;
    public int check(int lv)//根据作业等级给予积分
    {
        int point=0;
        switch (lv)
        {
            case 0:
                point=3;
            break;
            case 1:
                point=5;
            break;
            case 2:
                point=10;
            break;
            default:
                point=20;
        }
        return point;
    }

}
