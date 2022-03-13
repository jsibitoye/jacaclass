/*     */ package jacaclass;
/*     */ import java.awt.*;
        import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.text.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
 public class details extends JPanel
{
   JPanel prog,jp,p_other;
  int state,load,a,b,c,d = 0,navigator;
   JLabel fnm,lnm,lvl,dpt,fact,cgpa,cur_cgpa,gpa,img1,ask,curent,smstr_jl,l_other;
   boolean chk;
   String dtl[] = new String[5];
  JComboBox jc_level,jc_dept,jc_fact,smstr_jc;
 JTextField fname,lname,cgptf,t_other;
 JRadioButton cgpbut,gpbut;
   JButton go,forword,back;
  ArrayList<String> data;
 String[] smstr_ar={ "HAMATERN SEMESTER","RAIN SEMESTER"};
  String[] lv = { "Select", "100L", "200L", "300L", "400L", "500L" };
  String[] fty = {"Select", "ENGINEERING AND TECHNOLOGY", "MANAGEMENT SCIENCES",
                  "AGRICULTURAL SCIENCES","PURE AND APPLIED SCIENCES","ENVIRONMENTAL SCIENCES"
                  ,"BASIC MEDICAL SCIENCES","CLINICAL SCIENCES"};
String[] agric={"Agric Economics","Agric Extension & Rural Developement","Animal production & Health",
                 "Animal Nutrition & Biotechnology","Crop Production & Soil Sciences","Crop & Env Protection"};
String[] eng={"Agricultural Engineering","Chemical Engineering","Civil Engineering","Computer Science & Engineering",
              "ElectElcet Engineering","Food Science & Engineering","Mechanical Engineering"};
String[] manage={"Management & Accounting","Transport Management","Marketing Management","Economics & Information Technology"};
String[] pasa={"Pure & Applied Biology","Pure & Applied Chemistry","Pure & Applied Mathematics",
                "Pure & Applied Physics","Earth Sciences","Statistics","General Studies"};
String[] basicmed={"Anatomy","Medical Microbiology & Parasitology","Physiology","Biochemistry","Biomedical Science",
                   "Morbid Anatomy/Histopathology","Haemathology and Blood transfusion","Chemical Pathology","Pharmaology & Therapeutics"};
String[] clinic={"Medicine","Nursing","surgery","Radiology","Paediatrics"};
String[] environ={"Architecture","Fine & Applied Arts","Urban & Regional Planning"};
 JCheckBox jc;
 JCheckBox jcc;
 Border bbb;
NumberFormat nf = NumberFormat.getNumberInstance();
                
                           
boolean chk2;
   public JPanel infom()
   { 
jp = new JPanel();
jp.setLayout(null);
fnm = new JLabel("FULL NAME       : ");
fnm.setBounds(130, 180, 100, 20);
jp.add(fnm);
fname = new JTextField();
fname.setBounds(300, 180, 150, 20);
bbb= BorderFactory.createMatteBorder(0,5,1,1, Color.blue);
jp.add(fname);
lvl = new JLabel("LEVEL                :");
lvl.setBounds(130, 240, 100, 20);
jp.add(lvl);
jc_level = new JComboBox(lv);
jc_level.addActionListener(new ActionListener()
{
 public void actionPerformed(ActionEvent aev)
 {
      String sem_selected = jc_level.getSelectedItem().toString();
      if(!sem_selected.equalsIgnoreCase("select"))
      {
          jc.setEnabled(true);
          jcc.setEnabled(true);
      }
      else{
      jc.setEnabled(false);
       jcc.setEnabled(false);
      }
 }
});
jc_level.setBounds(300, 240, 70, 20);
jp.add(jc_level);
fact = new JLabel("FACULTY            :");
fact.setBounds(130, 300, 100, 20);
jp.add(fact);
nf.setMaximumFractionDigits(2);
nf.setMinimumFractionDigits(2);
Arrays.sort(fty);
Arrays.sort(agric);
Arrays.sort(eng);
Arrays.sort(manage);
Arrays.sort(pasa);
Arrays.sort(basicmed);
Arrays.sort(clinic);
Arrays.sort(environ);

     jc_fact = new JComboBox(fty);
               jc_dept = new JComboBox();
                jc_fact.addActionListener(
                new ActionListener()
                { 
                    public void actionPerformed(ActionEvent e)
                    {
                    int select = jc_fact.getSelectedIndex();
                     jc_dept.setEnabled(true);
                        switch(select)
                        {
                            case 0:jc_dept.removeAllItems();
                                jc_dept.addItem("Select");
                                for (int i=0; i<agric.length; i++){
                                    jc_dept.addItem(agric[i]);}
                                break;
                            case 1: jc_dept.removeAllItems();
                            jc_dept.addItem("Select");
                                for (int i=0; i<basicmed.length; i++){
                                    jc_dept.addItem(basicmed[i]);}
                                 break;
                            case 2: jc_dept.removeAllItems();
                            jc_dept.addItem("Select");
                                for (int i=0; i<clinic.length; i++){
                                    jc_dept.addItem(clinic[i]);}
                                 break;
                            case 3:jc_dept.removeAllItems();
                            jc_dept.addItem("Select");
                                for (int i=0; i<eng.length; i++){
                                    jc_dept.addItem(eng[i]);}
                                break;
                            case 4:jc_dept.removeAllItems();
                            jc_dept.addItem("Select");
                                for (int i=0; i<environ.length; i++){
                                    jc_dept.addItem(environ[i]);}
                                break;
                            case 5:jc_dept.removeAllItems();
                            jc_dept.addItem("Select");
                                for (int i=0; i<manage.length; i++){
                                    jc_dept.addItem(manage[i]);}
                                break;
                            case 6:jc_dept.removeAllItems();
                            jc_dept.addItem("Select");
                                for (int i=0; i<pasa.length; i++){
                                    jc_dept.addItem(pasa[i]);}
                                 break;
                            default:jc_dept.removeAllItems();
                            jc_dept.addItem("Select");
                                    jc_dept.setEnabled(false);
                        }
                    }
                });
              jc_fact.setSelectedIndex(fty.length-1);
    jc_fact.setBounds(300, 300, 170, 20);
    jp.add(jc_fact);
    dpt = new JLabel("DEPARTMENT    :");
    dpt.setBounds(130, 360, 100, 20);
jp.add(dpt);
 jc_dept.setBounds(300, 360, 170, 20);
 jp.add(jc_dept);
p_other= new JPanel(); 
p_other.setBackground(Color.LIGHT_GRAY);
p_other.setBounds(700,150,300,530);
p_other.setBorder(bbb);
jp.add(p_other);

ask = new JLabel("WHAT DO YOU WANT TO CALCULATE  ?");
ask.setBounds(190, 420, 300, 20);
jp.add(ask);
cgpa = new JLabel("CGPA                    :");
cgpa.setBounds(130, 500, 100, 20);
jp.add(cgpa);
jc = new JCheckBox();
jc.setEnabled(false);
jcc = new JCheckBox();
jcc.setEnabled(false);
    jp.add(jcc);
jp.add(jc);
  ButtonGroup ggg = new ButtonGroup();
 ggg.add(jcc);
 ggg.add(jc); 
jc.setBounds(300, 500, 20, 20);
curent = new JLabel("CURRENT CGPA  :");
  curent.setBounds(360, 500, 140, 20);
  jp.add(curent);
   cgptf = new JTextField();
    cgptf.setBounds(470, 500, 30, 20);
    jp.add(cgptf);
     curent.setVisible(false);
    cgptf.setVisible(false);

    jc.addItemListener(new ItemListener()
  {
     public void itemStateChanged(ItemEvent e) {
       if (details.this.jc.isSelected())
      {
          
          String R_s =jc_level.getSelectedItem().toString();
          R_s = R_s.substring(0,1);
          int R_det = Integer.parseInt(R_s);
          
       String R_smstr = smstr_jc.getSelectedItem().toString();
       System.out.println(R_smstr);
          int R_n=0;
          switch(R_det)
          {
              case 1:
                  R_n= 0; break;
              case 2: case 3: case 4: case 5:
                  R_n = (R_det*2) - 2;   
          }
          if (R_smstr.equals("RAIN SEMESTER"))
               R_n = R_n +1;       
        multioption mo = new multioption(); 
          double p_gp = mo.jamb(R_n,"Result","Your Previouse Semester Results from 100L");   
         curent.setVisible(true);
         cgptf.setVisible(true);
         cgptf.setText(nf.format(p_gp));
      
      }
      else if (!details.this.jc.isSelected())
        {
         curent.setVisible(false);
         cgptf.setVisible(false);
        }
      }
  });
   gpa = new JLabel("GPA                       :");
   gpa.setBounds(130, 550, 100, 20);
    jp.add(gpa);
 //smstr_jl.setBounds();
    jcc.setBounds(300, 550, 20, 20);
smstr_jl= new JLabel("SEMESTER           :");
smstr_jl.setBounds(130,460,120,20);

jp.add(smstr_jl);
smstr_jc = new JComboBox(smstr_ar);
smstr_jc.setBounds(300,460,150,20);

jp.add(smstr_jc);
         go = new JButton("PROCEED");
         go.setBackground(Color.white);
         //go.setBorder(null);
               go.addActionListener(
                new ActionListener()
                {  public void actionPerformed(ActionEvent e)
                    {   
                        File f= new File("student_detail.txt");
                        if(f.exists())
                        {
                           f.delete();
                        }
                    try {
                       
                        PrintWriter pw= new PrintWriter(
                                    new BufferedWriter(
                                    new FileWriter(f)),true);
                       data = new ArrayList();
                       data.add((String)jc_fact.getSelectedItem());
                       data.add((String)jc_dept.getSelectedItem());
                       data.add((String)jc_level.getSelectedItem());
                       data.add((String)smstr_jc.getSelectedItem());
                       data.add(fname.getText());
                       if (jc.isSelected()){
                           data.add(cgptf.getText());}
                       if(data.get(0).equals("") | data.get(1).equals("Select") | data.get(3).equals("Select")|( !jcc.isSelected() & !jc.isSelected() )  ) 
                       {
                            JOptionPane.showMessageDialog(null, "review your data please");
                       }
                       else{ 
                           if( (jc.isSelected() && !data.get(5).equals("")) | jcc.isSelected() )
                           {
                            for(String i: data)
                                {
                                pw.println(i);
                                }
                             d=1; 
                           }
                           else JOptionPane.showMessageDialog(null, "review your data pleas");
                            }
                 } catch (IOException ex) {System.out.println("dt error 1"+ex);
                        }    
                    }
                });
    go.setBounds(500, 615, 140, 30);
  jp.add(go);
  forword= new JButton(); back= new JButton();
  forword.setBounds(100,5,35,20);
  forword.setIcon(new ImageIcon(getClass().getResource("picture/f.png")));
  //back.setBounds(20,5,35,20);
//  back.setIcon(new ImageIcon(getClass().getResource("picture/b.png")));
//  back.setBackground(null);
  jp.add(forword);
  if(navigator==0)
  {
      forword.setEnabled(false);
  }
  else
   forword.setEnabled(true);
  forword.addActionListener(
  new ActionListener()
  {
    public void actionPerformed(ActionEvent e) {
        d=2;
    }
  });
   img1 = new JLabel();
   Icon i = new ImageIcon(getClass().getResource("picture/dpic.png"));
    img1.setIcon(i);
    img1.setBounds(0,0,1000,700);
   jp.add(img1);
    add(jp) ;
   return jp;
  }
 }

/* Location:           C:\Users\HP PC\Documents\NetBeansProjects\javaClass\build\classes\
 * Qualified Name:     jacaclass.details
 * JD-Core Version:    0.6.0
 */