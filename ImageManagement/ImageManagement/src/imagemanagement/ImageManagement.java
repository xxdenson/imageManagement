/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imagemanagement;

import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Edi
 */
public class ImageManagement {
    public static ArrayList<Application> allApplications = new ArrayList<>();
    public static ArrayList<Image> allImages = new ArrayList<>();
    
    public static ApplicationsPanel appPanel;
    public static ComputersPanel imagePanel;
    public static MainPanel mainPanel;
    public static UselessControlPanel uselessPanel; //this just demonstrates how an interface without tabs will work
    
    //checks to see if an application is part of any of the images in the repository
    public static boolean isApplicationInUse(Application app){
        for(int i  = 0; i < allImages.size(); i++){
            Image image = allImages.get(i);
            if(image.hasApplication(app))
                return true;//found it, get out of the function
        }
        //if the program gets to here... the application is not in use
        return false;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //hardcode some images and applications and save them in my data repository
        Image x, y;
        Application a1, a2, a3;
        
        a1 = new Application();
        a1.setName("Chrome");
        a1.setBasicSize(12.1);
        a1.setCpuCores(1);
        a1.setMemorySize(230);
        
        allApplications.add(a1); //add this to my list - hardcode!
        
        a2 = new Application();
        a2.setName("Photoshop");
        a2.setBasicSize(230);
        a2.setCpuCores(3);
        a2.setMemorySize(1300);
        
        allApplications.add(a2); //add this to my list - hardcode!
        
        a3 = new Application();
        a3.setName("Discord");
        a3.setBasicSize(100);
        a3.setCpuCores(2);
        a3.setMemorySize(800);
        
        allApplications.add(a3);
        
        x = new Image();
        x.setName("Marketing Desktops");
        x.addApplication(a1, 0); //nothing extra for chrome
        x.addApplication(a2, 51); //requires 51 Gb in addition to 230 basic size
        
        allImages.add(x); //add this to my repository
        
        x = new Image(); //now x points to a different image object
        x.setName("Kiosk Lobby");
        x.addApplication(a1, 11); //on this image, Chrome has an extra 11 Gb
        
        allImages.add(x); //add the kiosk lobby to my repository
        
        y = new Image();
        y.setName("Gaming");
        y.addApplication(a3, 99);
        
        allImages.add(y);
        
        
        //Done hardcoding -------------------------------------
        
        //Create my JFrame
        JFrame f = new JFrame("IT Image Management");
        
        f.setSize(1000, 600);
        f.setLocation(500, 10); //change this to show up on your screen
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //build all the panels to be used in my program
        appPanel = new ApplicationsPanel(); //note that it is a "global" variable to allow other parts of the code to find this panel
        imagePanel = new ComputersPanel();
        mainPanel = new MainPanel();
        
        uselessPanel = new UselessControlPanel();
        
        mainPanel.getApplicationSlotPanel().add(appPanel);
        mainPanel.getImagesSlotPanel().add(imagePanel);
        
        mainPanel.getControlFictionaSlotlPanel().add(uselessPanel);
        
        f.add(mainPanel);
        f.setVisible(true);
        
//        System.out.println("Printing image for " + x.getName() + " ----------");
//        //print all the applications one at a time
//        for(int i = 0; i < x.getNumberOfApplications(); i++){
//            //find application at position i
//            Application a;
//            a = x.getApplication(i);
//            
//            //print information about that app
//            System.out.println("\t" + a.getName() + ": basic size " + a.getBasicSize() +
//                    ", cores " + a.getCpuCores() + ", memory " + a.getMemorySize());
//            
//            //get extraData
//            System.out.println("\t\tExrta Data on this image: " + x.getApplicationExtraData(a));
//        }
//     System.out.println("-------------------");
    }
    
}
