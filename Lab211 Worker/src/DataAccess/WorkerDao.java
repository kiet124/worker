/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 
package DataAccess;


import comon.validate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.History;
import model.Worker;

/**
 *
 * @author dotha
 */
public class WorkerDao {

    private List<Worker> workerList;
    private List<History> historyList;
    private Scanner sc = new Scanner(System.in);

    public WorkerDao() {
        this.workerList = new ArrayList<>();
        this.historyList = new ArrayList<>();
    }

    public void addWorker() {
        String choice;
        do {
            System.out.println("--------- Add Worker ----------");
            System.out.print("Enter Code: ");
            String code = validate.checkInputString();
            System.out.print("Enter Name: ");
            String name = validate.checkInputString();
            System.out.print("Enter Age: ");
            int Age = validate.checkInputIntLimit(18, 50);
            System.out.print("Enter Salary: ");
            int salary = validate.checkInputSalary();
            System.out.print("Enter work location: ");
            String location = validate.checkInputString();
            if (!validate.checkWorkerExist((ArrayList<Worker>) workerList, code, name, Age, salary, location)) {
                System.out.println("");
            } else {
                Worker addmore = new Worker(code, name, Age, salary, location);
                workerList.add(addmore);
                System.out.println("Worker added successfully.");
                History history = new History("ADD", getCurrentDate(), code, name, Age, salary, location);
                historyList.add(history);
            }
            System.out.print("Do you want to add another worker? (Y/N): ");
            choice = sc.nextLine();
        } while (choice.equalsIgnoreCase("Y"));
    }

    public void changeSalary() {
    if (workerList.isEmpty()) {
        System.err.println("List is empty.");
        return;
    }

    System.out.print("Enter worker code: ");
    String code = validate.checkInputString();
    Worker worker = getWorkerByCode(code);

    if (worker == null) {
        System.err.println("Worker not found.");
        return;
    }

    int currentSalary = worker.getSalary();
    int newSalary;

    System.out.print("Enter new salary: ");
    newSalary = validate.checkInputSalary();

    String status = newSalary < currentSalary ? "DOWN" : newSalary > currentSalary ? "UP" : "NO CHANGE";

    if (newSalary != currentSalary) {
        worker.setSalary(newSalary);
        System.err.println("Salary " + status + " successfully.");
    } else {
        System.err.println("Salary remains the same.");
    }

    History history = new History(status, getCurrentDate(), code, worker.getName(), worker.getAge(), newSalary, worker.getWorkLocation());
    historyList.add(history);
}


    public Worker getWorkerByCode(String code) {
        for (Worker worker : workerList) {
            if (worker.getCode().equalsIgnoreCase(code)) {
                return worker;
            }
        }
        return null;
    }

    public Date getCurrentDate() {
    return new Date();
}


    public void printListHistory() {
        if (historyList.isEmpty()) {
            System.err.println("List is empty.");
            return;
        }

        // Sort the historyList by date
        Collections.sort(historyList, new Comparator<History>() {
            @Override
            public int compare(History h1, History h2) {
                return h1.getDate().compareTo(h2.getDate());
            }
        });

        System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n", "Code", "Name", "Age",
                "Salary", "Status", "Date");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (History history : historyList) {
            String formattedDate = dateFormat.format(history.getDate());
            System.out.printf("%-5s%-15s%-5s%-10s%-10s%-20s\n",
                    history.getCode(),
                    history.getName(),
                    history.getAge(),
                    history.getSalary(),
                    history.getStatus(),
                    formattedDate);
        }
    }
}