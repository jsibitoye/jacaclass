/*    */ package jacaclass;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.event.InputMethodEvent;
/*    */ import java.awt.event.InputMethodListener;
/*    */ import java.io.PrintStream;
/*    */ import javax.swing.BorderFactory;
/*    */ import javax.swing.Icon;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JTextField;
/*    */ import javax.swing.border.Border;
/*    */ 
/*    */ public class deletchar extends JFrame
/*    */ {
/*    */   private JTextField jtf;
/*    */   private JPanel jp;
/*    */ 
/*    */   deletchar()
/*    */   {
/* 13 */     super("delet other char except for numbers");
/* 14 */     Icon i = new ImageIcon(getClass().getResource("picture/point.png"));
/* 15 */     Border bd = BorderFactory.createLineBorder(Color.BLUE, 300);
/* 16 */     Border b = BorderFactory.createRaisedBevelBorder();
/* 17 */     b = BorderFactory.createTitledBorder(bd, "josh", 5, 1);
/*    */ 
/* 19 */     this.jtf = new JTextField();
/* 20 */     setLayout(null);
/* 21 */     this.jtf.setBounds(20, 20, 100, 20);
/* 22 */     this.jp = new JPanel();
/* 23 */     this.jp.setLayout(null);
/* 24 */     this.jp.setBounds(5, 5, 500, 500);
/* 25 */     this.jp.add(this.jtf);
/* 26 */     this.jp.setBorder(b);
/* 27 */     this.jtf.addInputMethodListener(new InputMethodListener()
/*    */     {
/*    */       public void inputMethodTextChanged(InputMethodEvent event)
/*    */       {
/* 33 */         System.out.println("wow");
/*    */       }
/*    */ 
/*    */       public void caretPositionChanged(InputMethodEvent event)
/*    */       {
/*    */       }
/*    */     });
/* 41 */     add(this.jp);
/* 42 */     setSize(600, 600);
/* 43 */     setLocationRelativeTo(null);
/* 44 */     setDefaultCloseOperation(3);
/* 45 */     setVisible(true);
/*    */   }
/*    */ 
/*    */   public static void main(String[] args)
/*    */   {
/* 50 */     new deletchar();
/*    */   }
/*    */ }

/* Location:           C:\Users\HP PC\Documents\NetBeansProjects\javaClass\build\classes\
 * Qualified Name:     jacaclass.deletchar
 * JD-Core Version:    0.6.0
 */