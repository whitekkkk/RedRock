package main;

import dao.Dao;
import service.Info11;


public class Main {
    public static void main(String []args)throws Exception {
        Dao dao=new Dao();
        Info11.Json();
        Info11.select();
        dao.select();
    }
}
