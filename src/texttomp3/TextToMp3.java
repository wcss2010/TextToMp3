/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texttomp3;

import WSwingUILib.Component.Base.JImagePanel;
import WSwingUILib.Frame.JTemplateFrame;
import texttomp3.Pages.MainPanel;

/**
 *
 * @author wcss
 */
public class TextToMp3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (javax.swing.UIManager.getSystemLookAndFeelClassName().equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

            JTemplateFrame.useDefaultFontConfig();
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JTemplateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JTemplateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JTemplateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JTemplateFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JTemplateFrame jtf = new JTemplateFrame();
                    jtf.setSoftName("海天盛筵Txt文本朗读器");
                    jtf.setSoftInfo("欢迎使用海天盛筵Txt文本朗读器");
                    jtf.setAppIcoFromImageObj(JImagePanel.getImageIconObjFromResource("/texttomp3/UIImage/book-icon.png"));
                    jtf.setVersionText("V1.0");

                    //添加首页(标签页)
                    jtf.setTabPage(0, "   首页", JImagePanel.getImageIconObjFromResource("/texttomp3/UIImage/manager.png"), new MainPanel());

                    jtf.setVisible(true);

                    //显示首页
                    jtf.setActiveTabPage(0);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}