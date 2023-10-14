/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DataAccess.WorkerDao;
import model.History;

/**
 *
 * @author dotha
 */
public class workerResponsitory implements IworkerResponsitory {
    private WorkerDao run = new WorkerDao();
    private History history;
    @Override
    public void addWorker() {
        run.addWorker();
    }

    @Override
    public void UpSalary() {
        run.changeSalary();
    }

    @Override
    public void Downsalary() {
        run.changeSalary();
    }

    @Override
    public void DisPlay() {
        run.printListHistory();
    }
    
}