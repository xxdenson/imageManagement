/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imagemanagement;

import java.util.ArrayList;

/**
 *
 * @author Edi
 */
public class Image {
    private String name;
    private ArrayList<Application> apps;
    private ArrayList<Double> extraData;
    
    public Image(){
        name = ""; //the name won't be null, just empty
        
        apps = new ArrayList<>();
        extraData = new ArrayList<>();
    }
    
    public double computeTotalDiskSize(){
        double totalSize = 0;
    
        for(int i = 0; i < apps.size(); i++){
            Application app = apps.get(i);
            totalSize = totalSize + app.getBasicSize(); //add the application size
            
            //also add any extra space required by this application
            totalSize += extraData.get(i);
        }
        return totalSize;
    }
    
    public boolean hasApplication(Application a){
        if(apps.contains(a))
            return true; //the application is already in this image
        else
            return false;
    }
    
    @Override
    public String toString(){
        String tmp = name;
        tmp = tmp + " " + computeTotalDiskSize() + "MB [";
        for(int i = 0; i < apps.size(); i++){
            Application app = apps.get(i);
            tmp = tmp + app.getName() + " " + extraData.get(i) +", ";
        }
        tmp = tmp + "]";
        return tmp;
    }
    
    public void removeAllAppilcation(){
        apps.clear();
        extraData.clear();
    }
    
    public void addApplication(Application a, double d){
        apps.add(a);
        extraData.add(d);
    }
    
    public void removeApplication(int index){
        apps.remove(index);
        extraData.remove(index);
    }
    
    public void removeApplication(Application a){
        int index = apps.indexOf(a);
        removeApplication(index);
    }
    
    public void setApplicationData(int index, double d){
        extraData.set(index, d);
    }
    
    public void setApplicationData(Application a, double d){
        int index = apps.indexOf(a);
        setApplicationData(index, d);
    }
    
    public int getNumberOfApplications(){
        return apps.size();
    }
    
    public Application getApplication(int index){
        return apps.get(index);
    }
    
    public double getApplicationExtraData(int index){
        return extraData.get(index);
    }
    
    public double getApplicationExtraData(Application a){
        int index = apps.indexOf(a);
        return getApplicationExtraData(index);
    }
    
    public int indexOf(Application a){
        return apps.indexOf(a);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
