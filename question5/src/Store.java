public class Store {

    public String getGoods(int point)//根据积分给予商品
    {
        String message=null;
        Goods goods=new Goods("高数","辣条");
        switch (point)
        {
            case 3:
                message="获得:"+goods.getSnake();
                break;
            case 5:
                message="获得:"+goods.getBook();
                break;
            case 10:
                message="获得:"+goods.getSnake()+goods.getBook();

        }
        return message;
    }
}
