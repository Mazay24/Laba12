package com.metanit;

import java.io.BufferedWriter;
import java.io.*;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String IP = null;
        String regulyr = "\\b(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b";
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку программа найдет верный IP: ");
        String goodIP = in.nextLine();
        Pattern P = Pattern.compile(regulyr);
        Matcher M = P.matcher(goodIP);
        if (M.find()){
            IP = M.group();
            System.out.println("Найдет верный IP:" + M.group());
        }
        else {
            System.out.println("Верный IP не найдет");
        }
        Copy(IP);

    }
    public static void Copy(String IP){
        try(BufferedWriter ip = new BufferedWriter(new FileWriter("ip.txt"))){
            ip.write(IP);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
