/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Repository.workerResponsitory;
import view.Menu;




/**
 *
 * @author dotha
 */
public class WorkerController extends Menu {

    workerResponsitory workerResponsitory;
    static String[] option = {"Add Worker", "Up salary", "Down salary", "Display Information salary", "Exit"};

    public WorkerController() {
        super("======== Worker Management =========", option);
        workerResponsitory = new workerResponsitory();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                workerResponsitory.addWorker();
                break;
            case 2:
                workerResponsitory.UpSalary();
                break;
            case 3:
                workerResponsitory.Downsalary();
                break;
            case 4:
                workerResponsitory.DisPlay();
                break;
            case 5:
                System.out.println("Exit!!!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid!!!!");
        }
    }

}