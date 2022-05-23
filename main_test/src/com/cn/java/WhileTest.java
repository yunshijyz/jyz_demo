package com.cn.java;

public class WhileTest {

    public static void main(String[] args) {
        boolean exist = true;
        String templateName = "嘻嘻哈哈";
        StringBuilder newName = new StringBuilder();
        newName.append(templateName).append("副本");
        System.out.println(newName);
        Integer i = 1;
        int count = 5;
        while (exist){
            if(count == 0){
                exist = false;
                break;
            }
            Integer z = i-1;
            if(newName.toString().contains("(")){
                String replace = newName.toString().replace(z.toString(), i.toString());
                newName = new StringBuilder(replace);
            }else {
                newName = newName.append("(").append(i).append(")");
            }
            System.out.println(newName);
            count--;
            i++;
        }




    }
}
