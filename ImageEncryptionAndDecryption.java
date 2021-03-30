package image.encryption.and.decryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Hassan Yosuf
 */
public class ImageOperation extends javax.swing.JFrame {

    public ImageOperation() {
        initComponents();
    }

    public static void Operate(int key) {
        JFileChooser filechooser = new JFileChooser();
        filechooser.showOpenDialog(null);
        File file = filechooser.getSelectedFile();
        
        try{
            FileInputStream fis = new FileInputStream(file);
            byte []data = new byte[fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data)
            {
                System.out.println(b);
                data[i] = (byte)(b^key);
                i++;
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Done!! Your Image Has been Processed");
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public static void keyEmpty() {
        
        
        
    }
    
    private void initComponents() {

        textfield = new javax.swing.JTextField();
        browseBtn = new javax.swing.JButton();
        label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image Processor");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(350, 300));
        setName("f"); // NOI18N
        setPreferredSize(new java.awt.Dimension(300, 250));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textfield.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        textfield.setToolTipText("Enter the Key");
        getContentPane().add(textfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 210, 50));

        browseBtn.setBackground(java.awt.Color.black);
        browseBtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        browseBtn.setForeground(java.awt.Color.white);
        browseBtn.setText("Browse Image");
        browseBtn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        browseBtn.setBorderPainted(false);
        browseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseBtnActionPerformed(evt);
            }
        });
        getContentPane().add(browseBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 150, 40));

        label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label.setText("Enter the Key");
        getContentPane().add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }

    private void browseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseBtnActionPerformed
        // TODO add your handling code here:
        System.out.println("Button Clicked");
        String text = textfield.getText();
        int temp = Integer.parseInt(text);
        Operate(temp);
    }
    
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ImageOperation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImageOperation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImageOperation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImageOperation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImageOperation().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton browseBtn;
    public javax.swing.JLabel label;
    public javax.swing.JTextField textfield;
    // End of variables declaration//GEN-END:variables
}
