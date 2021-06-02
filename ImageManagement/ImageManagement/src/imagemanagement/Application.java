/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imagemanagement;

/**
 *
 * @author Edi
 */
public class Application{
    private String name;
    private double basicSize; //assune it is in MB
    private int cpuCores;
    private int memorySize; //in MB
    
    public Application(){
        name = ""; //make the name not null, just empty
    }
    
    @Override
    public String toString(){
        String tmp;
        //if(ImageManagement.isApplicationInUse(this)) //check if this application is not in use, and put a star
        tmp = name;
        //else
            //tmp = "*" + name; if you have a notusedList, this is not really needed
        tmp = tmp + " [" + basicSize + "MB";
        tmp = tmp + ", " + cpuCores + ", " + memorySize + "MB]";
        return tmp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasicSize() {
        return basicSize;
    }

    public void setBasicSize(double basicSize) {
        this.basicSize = basicSize;
    }

    public int getCpuCores() {
        return cpuCores;
    }

    public void setCpuCores(int cpuCores) {
        this.cpuCores = cpuCores;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }
    
    
}
