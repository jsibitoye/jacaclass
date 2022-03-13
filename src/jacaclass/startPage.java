/*     */ package jacaclass;
/*     */ 
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class startPage extends JPanel
{
    JPanel status,prog;
    public int state;
    int a,b,c,load,col;
    JLabel imgbg,statejl;
    public Timer tim;
    String part;
    JLabel imghold = new JLabel();
    boolean chk;

   startPage()
   {
    
/*  19 */     setLayout(null);
imgbg = new JLabel();
imgbg.setIcon(new ImageIcon(getClass().getResource("picture/firstpage.png")));
imgbg.setBounds(15, 10, 950, 650);
status = new JPanel();
statejl = new JLabel();
statejl.setBounds(400, 0, 150, 50);
statejl.setBackground(Color.blue);
status.add(this.statejl);
prog = new JPanel();
status.setBounds(16, 600, 950, 50);
status.setBackground(Color.black);
prog.setLayout(null); this.status.setLayout(null);
prog.setBounds(25, 10, 1, 30);

status.add(this.prog);
/*  36 */     add(this.status);
/*  37 */     this.part = "picture/erin.png";
/*  38 */     Icon i = new ImageIcon(getClass().getResource(this.part));
/*  39 */     this.imghold.setIcon(i);
/*  40 */     this.imghold.setBounds(600, 0, 150, 120);
/*  41 */     add(this.imghold);
/*  42 */     add(this.imgbg);
/*  43 */     tim = new Timer(2, new time());
/*  44 */     tim.start();
/*     */   }
/*     */   public class time implements ActionListener {
/*     */     public time() {
/*     */     }
/*     */ 
/*     */     public void actionPerformed(ActionEvent event) {
/*  51 */       if (a == 0)
/*     */       {
/*  53 */         b += 5;
/*  54 */         imghold.setBounds(600,b, 150, 120);
/*  55 */         if (b == 400)
/*  56 */          a = 1;
/*     */       }
/*  58 */       else if (a == 1)
/*     */       {
/*  60 */         b -= 4;
/*  61 */         imghold.setBounds(600,b, 150, 120);
/*  62 */         if (b == 200)
/*  63 */           a = 2;
/*     */       }
/*  65 */       else if (a == 2)
/*     */       {
/*  67 */         b += 2;
/*  68 */        imghold.setBounds(600,b, 150, 120);
/*  69 */         if (b == 400)
/*  70 */           a = 3;
/*     */       }
/*  72 */       else if (a == 3)
/*     */       {
/*  74 */         b -= 1;
/*  75 */        imghold.setBounds(600, b, 150, 120);
/*  76 */         if (b == 300)
/*  77 */           a = 4;
/*     */       }
/*  79 */       else if (a == 4)
/*     */       {
/*  81 */         b += 1;
/*  82 */         imghold.setBounds(600,b, 150, 120);
/*  83 */         if (b == 400) {
/*  84 */           a = 5;
/*     */         }
/*     */       }
/*  88 */       state += 1;
/*     */       try {
/*  90 */         if (state % 9 == 0){
/*  91 */          load += 1;
col+=1000;
prog.setBackground(new Color(col));
}
/*  92 */         statejl.setText("LOADING........" + Integer.toString(load) + " %");
/*  93 */         if (load == 48) {part = (part = "picture/erin2.png");
/*  94 */           Icon i = new ImageIcon(getClass().getResource(part));
/*  95 */           imghold.setIcon(i);
/*     */         }
/*  97 */         if (load == 49) { part = (part = "picture/erin.png");
/*  98 */           Icon i = new ImageIcon(getClass().getResource(part));
/*  99 */           startPage.this.imghold.setIcon(i);
/*     */         }
/* 101 */         if (load == 55) { part = "picture/point.png";
/* 102 */           Icon i = new ImageIcon(getClass().getResource(part));
/* 103 */           imghold.setIcon(i);
/* 104 */           imghold.setBounds(570, 400, 150, 120); }
/*     */       }
/*     */       catch (Exception ee) { System.out.println("stp error 1"+ee);
/*     */       }
/* 108 */       prog.setSize(state, 30);
/* 109 */       if (state == 600)
/*     */       {
/* 111 */         tim.stop();
/* 112 */         chk = true;
/*     */       }
/*     */     }
/*     */   }
/*     */ }
/* Location:           C:\Users\HP PC\Documents\NetBeansProjects\javaClass\build\classes\
 * Qualified Name:     jacaclass.startPage
 * JD-Core Version:    0.6.0
 */