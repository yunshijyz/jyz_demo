package demo;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(null,"jiad");
        map.put(null,"jiang");

        Map table = new Hashtable();
//        table.put(null,"table");
        table.put("niu","niu");

        Object o = map.get(null);
        Object niu = table.get("niu");
        System.out.println(niu);
//        Object o1 = table.get(null);
//        System.out.println(o1);
        System.out.println(o);

    }
}
