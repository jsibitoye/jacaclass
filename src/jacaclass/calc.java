/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jacaclass;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class calc extends JPanel{
    JLabel img1;
    JButton back;
    int count,indx , k=1,d=0;
    String c_pat, s_head,s_detail,s1,s2,s3,r_detail,tu_tp_gpa;
    JTextArea jta= new JTextArea(100,12);
    JTextArea jta2= new JTextArea(100,12);
    JTextArea jta3= new JTextArea(100,12);
    JTextArea jta4= new JTextArea(100,10);
    ArrayList <String> all = new ArrayList();
    ArrayList <String> cod = new ArrayList();
    calc()
    {
        setLayout(null);
        Icon i = new ImageIcon(getClass().getResource("picture/bpic.png"));
        img1 = new JLabel();
     img1.setIcon(i);
     img1.setBounds(0, 0,1000,700);
     jta.setOpaque(true);
     String[] det = new String[6];
     File dir= new File("student_detail.txt");
        try {
           BufferedReader br= new BufferedReader( new FileReader(dir));
           String line = br.readLine();
            while(line!=null)
            {   
                det[count]=line;
                line= br.readLine();
                count++;
            }
            br.close();
        }
        catch(Exception ex){}
        
        File dir2=new File("result.txt");
            try {
       BufferedReader b= new BufferedReader( new FileReader(dir2));
       String lin= b.readLine();
        while(lin!=null)
        { 
            all.add(lin);
            lin= b.readLine();
        }
        b.close();
    }catch(Exception ex){}
           
    if(count==6){     
    c_pat = all.get(all.size()-2);
     tu_tp_gpa=all.get(all.size()-3);
    }
    else {c_pat = all.get(all.size()-1);
     tu_tp_gpa=all.get(all.size()-2);
    }
     
//     File dir3= new File(c_pat);
//            try {
//       BufferedReader b3= new BufferedReader( new FileReader(dir3));
//       String lin= b3.readLine();
//        while(lin!=null)
//        {
//            cod.add(lin);
//            lin= b3.readLine();
//        }
//        b3.close();
//    }catch(Exception ex){}
                
       back= new JButton();
  back.setBounds(20,5,35,20);
  back.setIcon(new ImageIcon(getClass().getResource("picture/b.png")));
  back.addActionListener(
          new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                d=1;
            }
          });
  add(back);
     
     s_head="DEPARTMENT OF"+det[1].toUpperCase()+"\n"+"FACULTY OF "+ det[0].toUpperCase()+"\n"+"LADOKE AKINTOLA UNIVERSITY OF TECHNOLOGY ,\n \t      OGBOMOSO.";
     s_detail= "NAME \t \t:  "+det[4].toUpperCase()+"\nSEMESTER \t \t:  "+det[3].toUpperCase()+"\nLEVEL \t \t:  "+det[2].toUpperCase()+"\nPROGRAM \t \t:  "+det[1].toUpperCase();
    
     jta.setText(s_head);
     jta.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,15));
     jta.setLineWrap(true);
     jta.setEditable(false);
     jta.setBounds(350,5,420,100);
     
     add(jta);
     
     jta2.setText(s_detail);
     jta2.setFont(new Font("Serif",Font.PLAIN,12));
     jta2.setLineWrap(true);
     jta2.setEditable(false);
     jta2.setBounds(50,100,400,100); 
     add(jta2);
     s2 ="*";
     s1="";
     for(int w= 0 ; w<=20; w++)
     {
        s2 +="---------";
     }
    
     s2+="*";
     s1 +="\n*\tCOURSE CODE *\t\t COURSE TITLE\t\t *        UNIT       *       SCORE       *       GRADE       *";
     s3=s2+s1+"\n"+s2;
     k=0;
     
     for(String c: all)
     {
         String [] split= c.split("\t");
          if(split.length>3){
         //String [] split2= all.get(k).split("\t");
         String tab ="";
          if(split[1].length()<13)
         tab="\t\t\t\t";
         else if(split[1].length()<26)
            tab="\t\t\t";
         else if(split[1].length()<40)
             tab="\t\t";
         else tab="\t";
         s3=s3+"\n\t   "+split[0] +"\t\t   "+split[1]+tab+"             "+split[2]+"\t               "+split[3]+"\t\t"+split[4]+"\n" +s2;
         k++;
          }
     }
     jta3.setText(s3);
     jta3.setFont(new Font("Serif",Font.PLAIN,12));
     jta3.setLineWrap(true);
     jta3.setEditable(false);
     jta3.setBounds(100,190,800,400); 
     add(jta3);
     String[]tup = tu_tp_gpa.split("\t");
     r_detail= "Semester Total Unit\t \t:  "+tup[0]+"\nSemester Total Point\t \t:  "+tup[1]+"\nSemester G.P.A\t \t:  "+tup[2];
     if(count==6)
         r_detail +="\nCumulative G.P.A\t\t:   "+all.get(all.size()-1);
     jta4.setText(r_detail);
     jta4.setFont(new Font("Serif",Font.PLAIN,12));
     jta4.setLineWrap(true);
     jta4.setEditable(false);
     jta4.setBounds(50,590,400,70); 
     add(jta4);
     add(img1);
    }
}