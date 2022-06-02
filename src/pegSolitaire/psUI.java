/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pegSolitaire;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.Arrays;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author athar
 */
public class psUI extends javax.swing.JFrame {

    /**
     * Creates new form psUI
     */
    static boolean board[][] = new boolean[7][7];
    static HashSet<Integer> arr = new HashSet<>();
    boolean gameOver = false;
    
    JButton[][] btns = new JButton[7][7];
    
    public psUI() {
        initComponents();
        
        GridLayout layout = new GridLayout(7,7);
        layout.setHgap(10);
        layout.setVgap(10);
        jPanel2.setLayout(layout);
        
        for(int i=0; i<7; i++){
            for(int j=0; j<7; j++){
                if(!check(i,j)){
                    btns[i][j] = new RoundButton();
                    btns[i][j].setPreferredSize(new Dimension(50,50));
                    if(i == 3 && j == 3)
                        btns[i][j].setBackground(new java.awt.Color(210, 210, 210));
                    jPanel2.add(btns[i][j]);
                }
                else{
                    JLabel label = new JLabel();
                    label.setOpaque(false);
                    label.setText("");
                    jPanel2.add(label);
                }
            }
        }
        
        statusBar.setVisible(false);
    }
    
    private boolean check(int i, int j){
        return (arr.contains(i) && arr.contains(j));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        startBtn = new javax.swing.JButton();
        statusBar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        title.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        title.setText("Peg Solitaire");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        startBtn.setText("Start");
        startBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startBtnMouseClicked(evt);
            }
        });

        statusBar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        statusBar.setText("Hello!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(startBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(statusBar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 406, Short.MAX_VALUE)
                .addComponent(statusBar)
                .addGap(18, 18, 18)
                .addComponent(startBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startBtnMouseClicked
        startBtn.setVisible(false);
        statusBar.setVisible(true);
        statusBar.setText("Waiting ;)");
    }//GEN-LAST:event_startBtnMouseClicked

    /**
     * @param args the command line arguments
     */
    private void init(){
        for (boolean[] row: board) 
            Arrays.fill(row, true);
        board[3][3] = false;
        
        gameOver = false;
        
        for(int i=0; i<7; i++){
            for(int j=0; j<7; j++){
                btns[i][j].setBackground(new java.awt.Color(157, 0, 255));
                if(i == 3 && j == 3)
                    btns[i][j].setBackground(new java.awt.Color(210, 210, 210));
            }
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(psUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(psUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(psUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(psUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        arr.add(0);
        arr.add(1);
        arr.add(5);
        arr.add(6);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new psUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton startBtn;
    private javax.swing.JLabel statusBar;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}

class RoundButton extends JButton {
 
  public RoundButton() {
    super();
 
    //setBackground(Color.lightGray);
    setBackground(new java.awt.Color(157, 0, 255));
    setFocusable(false);
 
    /*
     These statements enlarge the button so that it 
     becomes a circle rather than an oval.
    */
    Dimension size = getPreferredSize();
    size.width = size.height = Math.max(size.width, size.height);
    setPreferredSize(size);
 
    /*
     This call causes the JButton not to paint the background.
     This allows us to paint a round background.
    */
    setContentAreaFilled(false);
  }
 
  protected void paintComponent(Graphics g) {
    if (getModel().isArmed()) {
      g.setColor(Color.gray);
    } else {
      g.setColor(getBackground());
    }
    g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
 
    super.paintComponent(g);
  }
 
  protected void paintBorder(Graphics g) {
    g.setColor(Color.darkGray);
    g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
  }
 
  // Hit detection.
  Shape shape;
 
  public boolean contains(int x, int y) {
    // If the button has changed size,  make a new shape object.
    if (shape == null || !shape.getBounds().equals(getBounds())) {
      shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
    }
    return shape.contains(x, y);
  }
}