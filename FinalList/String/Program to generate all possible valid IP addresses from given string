package com.company.BackTracking;
import java.util.*;
public class GenerateIPAdd {
    public static void main(String[] args) {
        System.out.println(generateIP("25505011535"));
    }

    private static List<String> generateIP(String s) {
        List<String> allIP=new ArrayList<>();
        int[] path=new int[4];
        generateIPUtil(allIP,s,0,path,0);
        return allIP;
    }

    private static void generateIPUtil(List<String> allIP, String s, int builderIndex, int[] path, int segment) {

        if (segment==4&&builderIndex==s.length()){
            allIP.add(path[0]+"."+path[1]+"."+path[2]+"."+path[3]);
            return;
        }else if(segment==4||builderIndex==s.length())
            return;


        for (int len = 1; len <=3&&builderIndex+len<=s.length() ; len++) {
            String snapshot=s.substring(builderIndex,builderIndex+len);
            int value=Integer.parseInt(snapshot);
            if(value>255||value<0||len>=2&&s.charAt(builderIndex)=='0')
                break;
            path[segment]=value;
            generateIPUtil(allIP,s,builderIndex+len,path,segment+1);
            path[segment]=-1;
        }
    }
}
