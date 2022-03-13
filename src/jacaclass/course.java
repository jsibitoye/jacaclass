/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jacaclass;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
//import javax.swing.colorchooser.*;
public class course extends JPanel{
    public int d;
    boolean jtf_chk;
    JLabel img1,dpt_col,dp1,dp2,dp3,oda_dp,jl_uni,jl_details,un_err;
    JPanel jp_dpt,jp_list,jp_add,jp_uni,jp_detail;
    int count,increment,a,t_point=0,t_unit=0,b,nav;
    JTextField jt1= new JTextField(), jt2= new JTextField(), jt3= new JTextField(), jt4= new JTextField();
    JTextArea jta= new JTextArea();
     JButton aprove = new JButton(),cancel = new JButton(),plus = new JButton("Add New"),proc= new JButton("Calculate"),back,forword;
     
    double gpa,cgpa,p_cgpa;
    Icon rem_icon1,rem_icon2;
    String pat= "c",s_detail,div[];
     ArrayList<String> c_cod= new ArrayList(),c_tit= new ArrayList();   
     ArrayList <Character>grad = new ArrayList();
     ArrayList <Integer>score= new ArrayList(),point= new ArrayList(),c_uni= new ArrayList();
     ArrayList <JLabel> jl = new ArrayList(),jl2 = new ArrayList(),jl3 = new ArrayList();
     ArrayList <JTextField> jtf = new ArrayList();
     ArrayList <JButton> jb = new ArrayList();
     Border bbb= BorderFactory.createMatteBorder(1,1,1,1, Color.red),bbb2= BorderFactory.createMatteBorder(1,1,1,1,Color.GREEN),
                bbb3= BorderFactory.createMatteBorder(0,5,0,0, Color.white),bbb4= BorderFactory.createMatteBorder(1,1,1,1,Color.gray);
    public details dt;
    course()
    {   
        try{
        System.out.println("alayea");
     setLayout(null);
     img1 = new JLabel();
     Icon i = new ImageIcon(getClass().getResource("picture/dpic.png"));
     img1.setIcon(i);
     img1.setBounds(0, 0,1000,700);
     jp_detail= new JPanel();
     jp_detail.setLayout(null);
     jp_detail.setBorder(bbb3);
     jp_detail.setBounds(800,40,200,610);
     add(jp_detail);
     
  forword= new JButton(); back= new JButton();
  forword.setBounds(100,5,35,20);
  forword.setIcon(new ImageIcon(getClass().getResource("picture/f.png")));
  back.setBounds(20,5,35,20);
  back.setIcon(new ImageIcon(getClass().getResource("picture/b.png")));
  back.addActionListener(
          new ActionListener(){
          public void actionPerformed(ActionEvent aee){
              d=2;
          }
          });
  forword.addActionListener(
          new ActionListener(){
          public void actionPerformed(ActionEvent aee){
              proc.doClick();
          }
          });
  
  add(forword);
  add(back);
  
     
     plus.addMouseListener(
     new MouseAdapter()
     {
         public void mouseClicked( MouseEvent mvv)
         {
            jtf_chk= true;
             jp_dpt.add(jt1);
             jt1.setBounds(25,increment,100,20);
             jt1.addKeyListener(
             new KeyAdapter(){
                 public void keyReleased(KeyEvent kev){
                     if (jt1.getText().length()>0 && jt1.getBorder().equals(bbb))
                         jt1.setBorder(bbb4);
                     if (jt1.getText().length()>7)
                         jt1.setText(jt1.getText().substring(0,7)); 
                     jt1.setText(jt1.getText().toUpperCase());
                 }
             });
             jp_uni.add(jt4);
             jt4.setBounds(10,increment,50,20);
             jt4.addKeyListener(
             new KeyAdapter(){
                 public void keyReleased(KeyEvent e) {
                            
                            String chcker= jt4.getText();
                            String[]c=chcker.split("");
                            String gpstring="";
                            for(int j= 0;j<=chcker.length();j++){
                               try{int num = Integer.parseInt(c[j]);
                                gpstring +=num;
                               }
                               catch(Exception notnum){ System.out.println("er:1  "+notnum);}
                               }
                            if(gpstring.length()>2)
                            gpstring=gpstring.substring(0,2);
                            jt4.setText(gpstring);
                            if(jt4.getText().length()>0)
                                jt4.setBorder(bbb4);
                 
                 }
                 
             
             });
             jp_list.add(jt2);
             jt2.setBounds(50,increment,100,20);
             
             jt2.addKeyListener(
             new KeyAdapter(){
                 public void keyReleased(KeyEvent kev){
                     if (jt2.getText().length()>0 && jt2.getBorder().equals(bbb))
                         jt2.setBorder(bbb4);
                 }
             });
             jp_add.add(jt3);
             jt3.setBounds(20,increment,100,20);
             jt3.addKeyListener(new update(100));
             jp_add.add(aprove);
             aprove.setBounds(150,increment,20,20);
             aprove.setIcon(new ImageIcon(getClass().getResource("picture/aprv.png")));
             aprove.setRolloverIcon(new ImageIcon(getClass().getResource("picture/aprv1.png")));
             aprove.addMouseListener(
             new MouseAdapter(){
                 public void mouseClicked(MouseEvent ap){
                     if(!jt1.getText().isEmpty() && !jt2.getText().isEmpty() &&!jt4.getText().isEmpty())
                     {       
                     System.out.println(c_uni.size());
               c_cod.add(jt1.getText());
               c_tit.add(jt2.getText());
               c_uni.add(Integer.parseInt(jt4.getText()));
               System.out.println(c_uni.toString()+"\n"+c_tit.toString()+"\n"+c_cod.toString() +"\n"+c_uni.size());
               jl.add( new JLabel(jt1.getText()));
               jl2.add( new JLabel(jt2.getText()) );
               jl3.add( new JLabel(jt4.getText()) );
               jtf.add(new JTextField());
               jb.add(new JButton());
               jp_dpt.removeAll();
              jp_list.removeAll();
              jp_add.removeAll();
              jp_add.removeAll();
              jp_uni.removeAll();
                    jt1.setText("");
                     jt2.setText("");
                    jt3.setText("");
                    jt4.setText("");
                adder();
                jtf_chk= false;
                 }
                     else 
                     {if(jt1.getText().isEmpty())
                         jt1.setBorder(bbb);
                      if(jt2.getText().isEmpty())
                         jt2.setBorder(bbb);
                      if(jt4.getText().isEmpty())
                         jt4.setBorder(bbb);
                     }
                    }
             });
             
             aprove.setToolTipText("ADD");
             jp_add.add(cancel);
             cancel.setBounds(175,increment,20,20);
             cancel.setIcon(rem_icon1);
             cancel.setRolloverIcon(rem_icon2);
             cancel.setToolTipText("canccel"); 
            cancel.addMouseListener(
             new MouseAdapter(){
                 public void mouseClicked(MouseEvent mc){
                     jp_dpt.removeAll();
              jp_list.removeAll();
              jp_add.removeAll();
              jp_uni.removeAll();
                    jt1.setText("");
                    jt2.setText("");
                    jt3.setText("");
                    jt4.setText("");
                adder();
                jtf_chk= false;
                      }
                 });
          repaint();   
         }
     });
     add(plus);
     plus.setBounds(39,628,120,20);
     plus.setToolTipText("Add A New Course");
     plus.setBackground(Color.white);
     
       un_err= new JLabel("Total Unit Can Not Be Greater Than 24!!");
       un_err.setBounds(350,632,200,50);
       un_err.setForeground(Color.red);
       un_err.setFont(new Font("Serif",Font.PLAIN+Font.ITALIC,12));
       un_err.setVisible(false);
       add(un_err);
       
       
     add(proc);
     proc.setBounds(650,628,100,20);
     proc.setToolTipText("Display Result");
     proc.setBackground(Color.white);
     proc.addActionListener(
     new ActionListener()
     {
         public void actionPerformed(ActionEvent pr){
             score.clear();
             Color coll= Color.red;
             if (jtf_chk==false){
             File f= new File("result.txt");
                        if(f.exists())
                        {
                           f.delete();
                        }
                    try {
                        PrintWriter pw= new PrintWriter(
                                    new BufferedWriter(
                                    new FileWriter(f)),true);
                       for(int t= 0;t<c_uni.size();t++)
                       {
                         if(!jtf.get(t).getText().equals("") && !jtf.get(t).getForeground().equals(coll))
                         score.add(Integer.parseInt(jtf.get(t).getText()));
                         else jtf.get(t).setBorder(bbb);
                       }
                        
                       if(c_uni.size()==score.size() && c_uni.size()> 0)
                       {
                           NumberFormat nf = NumberFormat.getNumberInstance();
                           nf.setMaximumFractionDigits(2);
                           nf.setMinimumFractionDigits(2);
                            a=0;
                            t_unit=0;
                            t_point=0;
                            for(int i:score)
                                {
                                    System.out.println(c_cod.get(a));
                                    calculator(a,i);
                                    pw.println(c_cod.get(a)+"\t"+c_tit.get(a)+"\t"+c_uni.get(a)+"\t"+i+"\t"+grad.get(a));
                                    a++; 
                                }
                            if(t_unit<=24 && t_unit>=0)
                            {
                                gpa= (t_point+0.0)/(t_unit+0.0);
                                pw.println(t_unit + "\t"+t_point+"\t"+nf.format(gpa));
                                pw.println(pat);
                                 if(count>5){
                                  cgpa= ((p_cgpa+0.0)+(gpa+0.0))/2.0;
                                 pw.println(nf.format(cgpa));
                                 }
                                 pw.close();
                                d=1;
                            }
                            else{ 
                                pw.close();
                                f.delete();
                                System.out.println("total unit error: "+t_unit);
                                un_err.setVisible(true);
//                                JLabel ji = new JLabel("wow working");
//                                 ji.setBounds(0,0,100,50);
//                                 jp_detail.add(ji);
                              
                            }
                       }
                       else {System.out.println("c_uni size : "+c_uni.size()+" score size : "+score.size()); 
                       for (int k = 0 ; k<=c_uni.size(); k++)
                       {
                           System.out.println("C_uni : "+c_uni.get(k)+" Score : "+score.get(k)); 
                       }
                       }
                    } catch (IOException ex) {System.out.println("er:2  "+ex);
                        } 
             }
             else 
                     {if(jt1.getText().isEmpty())
                         jt1.setBorder(bbb);
                      if(jt2.getText().isEmpty())
                         jt2.setBorder(bbb);
                      if(jt4.getText().isEmpty())
                         jt4.setBorder(bbb);
                     }
         }
     });
     
     jp_dpt= new JPanel();jp_list= new JPanel(); jp_add = new JPanel(); jp_uni= new JPanel(); 
     dp1= new JLabel("COURSE TITTLE"); dp2 = new JLabel("SCORE");dp3= new JLabel("COURSE UNIT");
     dt= new details();
     jp_dpt.setBounds(30,150,140,500);
     dpt_col= new JLabel("COURSE CODE");
     jp_dpt.setLayout(null);
     dpt_col.setBounds(20,0,100,20);
     add(jp_dpt);
     jp_list.setLayout(null);
     jp_list.setBounds(218,150,200,500);
     dp1.setBounds(30,0,130,20);  
     add(jp_list);  
     jp_uni.setLayout(null);
     jp_uni.setBounds(465,150,100,500);
     dp3.setBounds(10,0,130,20);
     
     add(jp_uni);
     jp_add.setLayout(null);
     jp_add.setBounds(600,150,200,500);
     dp2.setBounds(60,0,150,20);
     add(jp_add);
        File dir= new File("student_detail.txt");
        try {
           BufferedReader br= new BufferedReader( new FileReader(dir));
           String line = br.readLine();
            while(line!=null)
            {   count++;
            
                if(count<5)
                    pat+="/"+line;
                if (count==6){
                      p_cgpa=Double.parseDouble(line);
                }
                line= br.readLine();
            }
            br.close();
        }
        catch(Exception ex){ System.out.println("er:3  "+ex);}
     pat +=".txt";
        File dir2= new File(pat);
    try {
       BufferedReader b= new BufferedReader( new FileReader(dir2));
       String lin= b.readLine();
       String[] couse_detail =new String[3];
            couse_detail = lin.split("\t");
       c_cod.add(couse_detail[0]);
       c_tit.add(couse_detail[1]);
       c_uni.add(Integer.parseInt(couse_detail[2]));
       jl.add( new JLabel(couse_detail[0]) );
       jl2.add( new JLabel(couse_detail[1]) );
       jl3.add( new JLabel(couse_detail[2]) );
       int c=1,c2=1;
        while(lin!=null)
        { 
            lin= b.readLine();
            if (lin==null)
                b.close();
            couse_detail= lin.split("\t");
            c_cod.add(couse_detail[0]);
            jl.add( new JLabel(couse_detail[0]) );
            c_tit.add(couse_detail[1]);
            jl2.add(new JLabel(couse_detail[1]) );
            c_uni.add(Integer.parseInt(couse_detail[2]));           
            jl3.add( new JLabel(couse_detail[2]) );
             c++;c2++;
        }
    }catch(Exception ex){System.out.println("er:4  "+ex);}
    
    s_detail="      LADOKE AKINTOLA\n            UNIVERSITY OF\n    TECHNOLOGY \n            OGBOMOSO\n\n";
     s_detail+="...............................................\n\n";
     div=pat.split("/");
     s_detail+=div[1]+"\n\n"+div[2]+"\n\n\t"+div[3]+"evel \n\n"+div[4].subSequence(0,div[4].indexOf("."));
     jta.setText(s_detail);
     jta.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,15));
     jta.setForeground(Color.white);
     jta.setOpaque(false);
     jta.setEditable(false);
     jta.setBounds(10,0,180,500);
     jp_detail.add(jta);
     
   for(int cc= 0 ; cc< c_uni.size();cc++)
     {
          jtf.add(new JTextField());
          jb.add(new JButton());
          
     }
     add(img1);
     adder();
     } catch(Exception e1){System.out.println("er:5  "+e1);}
    }
    void adder()
    {
        try{
        jp_dpt.add(dpt_col);
        jp_add.add(dp2);
        jp_list.add(dp1);
        jp_uni.add(dp3);
         increment = 50;
          for(int v= 0 ; v<jl3.size();v++)
          {
          }
    rem_icon1 = new ImageIcon(getClass().getResource("picture/rem.png"));
    rem_icon2 = new ImageIcon(getClass().getResource("picture/rem2.png"));
    for(int j =0; j<c_uni.size(); j++){
       jl.get(j).setBounds(30,increment, 50,20);
       jp_dpt.add(jl.get(j));
       jl2.get(j).setBounds(2,increment,195,20);
       jp_list.add(jl2.get(j));
       
       jl3.get(j).setBounds(30,increment, 50,20);
       jp_uni.add(jl3.get(j));
       jtf.get(j).setBounds(50,increment,50,20);
       jtf.get(j).setText("7");
       jtf.get(j).addKeyListener(new update( j));
       jp_add.add(jtf.get(j));
       jb.get(j).setBounds(150,increment,20,20);
       jb.get(j).setActionCommand(Integer.toString(j));
       jb.get(j).addMouseListener(
       new MouseAdapter()
       {
           public void mouseClicked( MouseEvent mc){
               try{
            int indx= jb.indexOf(mc.getSource());
          jb.remove(indx);
          jb.trimToSize();
       jl.remove(indx);
       jl.trimToSize();
       jl2.remove(indx);
       jl2.trimToSize();
       jl3.remove(indx);
       jl3.trimToSize();
       jtf.remove(indx);
       jtf.trimToSize();
       c_cod.remove(indx);
       c_cod.trimToSize();
       c_uni.remove(indx);
       c_uni.trimToSize();
       c_tit.remove(indx);
       c_tit.trimToSize();
           jp_dpt.removeAll();
          jp_list.removeAll();
          jp_add.removeAll();
          jp_add.removeAll();
          jp_uni.removeAll();
            
            adder();
               }
               catch(Exception es){System.out.println("er:6  "+es);}
        }
       });
       jb.get(j).setIcon(rem_icon1);
       jb.get(j).setRolloverIcon(rem_icon2);
       jb.get(j).setToolTipText("Remove");
       jp_add.add(jb.get(j));
        increment+=40;
        
    }
        }catch(Exception exx){System.out.println("er:7  "+exx);}
        validate();
        repaint();
    }
    class update implements KeyListener{
        int dummy;
        public void keyTyped(KeyEvent e) {}
        public void keyPressed(KeyEvent e) {}
        update(int dum )
        {
           dummy = dum;
        }
        public void keyReleased(KeyEvent e) {
            try{
          switch(dummy)
          {
              case 100:{
                          String chcker= jt3.getText();
                            String[]c=chcker.split("");
                            String gpstring="";
                            for(int j= 0;j<=chcker.length();j++){
                               try{int num = Integer.parseInt(c[j]);
                                gpstring +=num;
                               }
                               catch(Exception notnum){System.out.println("er:8  "+notnum);
                               }
                            }
                            if (gpstring.length()>3)
                             gpstring= gpstring.substring(0, 3);
                            try{
                                int nm= Integer.parseInt(gpstring);
                                if(nm>100)
                                jt3.setForeground(Color.red);
                            else
                                jt3.setForeground(Color.black);
                            }
                            catch(Exception eee){System.out.println("er:9  "+eee);}
                            jt3.setText(gpstring);
                        }break;
              default:{
                    String chcker= jtf.get(dummy).getText();
                    String[] c=chcker.split("");
                    String gpstring="";
                    for(int j= 0;j<=chcker.length();j++){
                       try{int num = Integer.parseInt(c[j]);
                        gpstring +=num;
                       }
                       catch(Exception notnum){System.out.println("er:10  "+notnum);
                       }
                    }
                    if (gpstring.length()>3)
                     gpstring= gpstring.substring(0, 3);
                    try{
                        
                        int nm= Integer.parseInt(gpstring);
                        if(nm>99)
                        jtf.get(dummy).setForeground(Color.red);
                    else
                        jtf.get(dummy).setForeground(Color.black);
                        jtf.get(dummy).setBorder(bbb2);
                    }
                    catch(Exception eee){System.out.println("er:11  "+eee);}
                    jtf.get(dummy).setText(gpstring);
              }
          }
        } catch(Exception e1){System.out.println("er:12  "+e1);}
    }
    }
    void calculator(int ind,int sco)
    {       
   try{
        if(sco>=70){
            grad.add('A');
            point.add(5*c_uni.get(ind));
        }
        else if(sco>=60){
            grad.add('B');
        point.add(4*c_uni.get(ind));
        }
        else if(sco>=50){
            grad.add('C');
        point.add(3*c_uni.get(ind));
        }
        else if(sco>=45){
            grad.add('D');
        point.add(2*c_uni.get(ind));
        }
        else if(sco>=40){
            grad.add('E');
        point.add(1*c_uni.get(ind));
        }
        else if(sco<=39){
            grad.add('F');
        point.add(0*c_uni.get(ind));
        }
        t_point+=point.get(ind);
         t_unit += c_uni.get(ind);
      } catch(Exception e1){System.out.println("er:13  "+e1);}
    }
    
}
