/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 
package jacaclass;
 
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.*;
import javax.swing.JFrame;
/**
 *
 * @author HP PC
 */
public class ssii extends JFrame {
    ssii()
    {
        setDefaultCloseOperation(3);//1: do nothing. 2: hide 3: exit
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        course cs = new course();
        setContentPane(cs);
        setVisible(true); 
       setTitle("CGPA CALCULATOR By JOSH_ReeD");
        File dir= new File("t.txt");
        try {
           BufferedReader br= new BufferedReader( new FileReader(dir));
           String line = br.readLine();
            while(line!=null)
            {
                System.out.println(line);
                line= br.readLine();
            }
            br.close();
        }
        catch(Exception ex)
        {  System.out.println(ex);}
    }
    public static void main(String[] args)
    {
       // new ssii();  
        multioption mo = new multioption();
        mo.jamb(2,"Result","Your Previouse Semester Results from 100L");
    }
}
