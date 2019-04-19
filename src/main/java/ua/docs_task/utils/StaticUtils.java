package ua.docs_task.utils;

import ua.docs_task.service.ServiceDB;

import java.util.Scanner;

public class StaticUtils {

    private static ServiceDB serviceDB;

    static void setServiceDB(ServiceDB service) {
        StaticUtils.serviceDB = service;
    }

    public static void printDoc() {
        Scanner scanner = new Scanner(System.in);
        String inn = scanner.next();

        if ("888".equals(inn)) {  // Эмуляция вызова метода изменений
            serviceDB.upVersion("a1");
        } else {
            serviceDB.printPackages(inn);
        }
    }
}
