/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texttomp3.Pages;

import WSwingUILib.Component.JMiddleContentPanel;
import java.awt.Toolkit;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import texttomp3.JTextSpeaker;
import texttomp3.SpeakConfig;
import texttomp3.TextSpeaker;

/**
 *
 * @author wcss
 */
public class MainPanel extends JMiddleContentPanel {

    private File textTempFile = null;

    /**
     * Creates new form MainPanel
     */
    public MainPanel() {
        initComponents();

        cbSpeakerList.removeAllItems();
        TextSpeaker[] tss = TextSpeaker.values();
        for (TextSpeaker ts : tss) {
            cbSpeakerList.addItem(ts.name());
        }
        cbSpeakerList.setSelectedItem("Mandarin");
    }

    private SpeakConfig getSpeakConfig() {
        if (tbSpeakText.getText() != null && tbSpeakText.getText().length() > 20) {
            try {
                // TODO add your handling code here:
                textTempFile = new File(JAppToolKit.JRunHelper.getUserHomeDirPath() + "/speakTemp.txt");
                JAppToolKit.JDataHelper.writeAllLines(textTempFile.getAbsolutePath(), new String[]{tbSpeakText.getText()});
            } catch (Exception ex) {
                Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            textTempFile = null;
        }

        SpeakConfig sc = new SpeakConfig();
        sc.setSpeaker(TextSpeaker.valueOf(cbSpeakerList.getSelectedItem().toString()));
        sc.setSpeed(srSpeed.getValue());
        sc.setVolume(srVolume.getValue());
        sc.setPitch(srPitch.getValue());
        sc.setTextFile(textTempFile);
        sc.setText(tbSpeakText.getText().trim().replace("\n", ""));
        return sc;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        plTool = new javax.swing.JPanel();
        srPitch = new javax.swing.JSlider();
        srSpeed = new javax.swing.JSlider();
        srVolume = new javax.swing.JSlider();
        btnStop = new WSwingUILib.Component.JUIButton();
        btnLoadFrom = new WSwingUILib.Component.JUIButton();
        btnExport = new WSwingUILib.Component.JUIButton();
        btnPlay = new WSwingUILib.Component.JUIButton();
        cbSpeakerList = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSpeakText = new javax.swing.JTextPane();

        setLayout(null);

        plTool.setBackground(java.awt.Color.white);
        plTool.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "功能区", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("文泉驿等宽微米黑", 0, 12))); // NOI18N
        plTool.setLayout(null);

        srPitch.setBackground(java.awt.Color.white);
        srPitch.setMinimum(-100);
        srPitch.setPaintLabels(true);
        srPitch.setPaintTicks(true);
        srPitch.setValue(0);
        srPitch.setBorder(javax.swing.BorderFactory.createTitledBorder("语调"));
        srPitch.setDoubleBuffered(true);
        plTool.add(srPitch);
        srPitch.setBounds(310, 20, 140, 70);

        srSpeed.setBackground(java.awt.Color.white);
        srSpeed.setMaximum(300);
        srSpeed.setMinimum(-50);
        srSpeed.setPaintLabels(true);
        srSpeed.setPaintTicks(true);
        srSpeed.setValue(0);
        srSpeed.setBorder(javax.swing.BorderFactory.createTitledBorder("语速"));
        srSpeed.setDoubleBuffered(true);
        plTool.add(srSpeed);
        srSpeed.setBounds(10, 20, 140, 70);

        srVolume.setBackground(java.awt.Color.white);
        srVolume.setMinimum(-100);
        srVolume.setPaintLabels(true);
        srVolume.setPaintTicks(true);
        srVolume.setValue(0);
        srVolume.setBorder(javax.swing.BorderFactory.createTitledBorder("音量"));
        srVolume.setDoubleBuffered(true);
        plTool.add(srVolume);
        srVolume.setBounds(160, 20, 140, 70);

        btnStop.setButtonText("停止");
        btnStop.setEnabled(false);
        btnStop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStopMouseClicked(evt);
            }
        });
        plTool.add(btnStop);
        btnStop.setBounds(770, 60, 80, 30);

        btnLoadFrom.setButtonText("导入文本");
        btnLoadFrom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoadFromMouseClicked(evt);
            }
        });
        plTool.add(btnLoadFrom);
        btnLoadFrom.setBounds(680, 20, 80, 30);

        btnExport.setButtonText("导出OGG");
        btnExport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExportMouseClicked(evt);
            }
        });
        plTool.add(btnExport);
        btnExport.setBounds(680, 60, 80, 30);

        btnPlay.setButtonText("开始朗读");
        btnPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlayMouseClicked(evt);
            }
        });
        plTool.add(btnPlay);
        btnPlay.setBounds(770, 20, 80, 30);

        cbSpeakerList.setBackground(java.awt.Color.white);
        plTool.add(cbSpeakerList);
        cbSpeakerList.setBounds(530, 40, 130, 29);

        jLabel1.setText("朗读者：");
        plTool.add(jLabel1);
        jLabel1.setBounds(480, 40, 60, 30);

        add(plTool);
        plTool.setBounds(10, 400, 860, 100);

        tbSpeakText.setBorder(javax.swing.BorderFactory.createTitledBorder("文本"));
        tbSpeakText.setFont(new java.awt.Font("文泉驿等宽微米黑", 0, 14)); // NOI18N
        tbSpeakText.setDoubleBuffered(true);
        jScrollPane1.setViewportView(tbSpeakText);

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 860, 380);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayMouseClicked
        // TODO add your handling code here:
        JTextSpeaker.playText(getSpeakConfig(), false);
    }//GEN-LAST:event_btnPlayMouseClicked

    private void btnStopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStopMouseClicked
        JTextSpeaker.killEkho();
    }//GEN-LAST:event_btnStopMouseClicked

    private void btnLoadFromMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoadFromMouseClicked
        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jfc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isFile()) {
                    return f != null ? (f.getName().endsWith(".txt")) : false;
                } else {
                    return true;
                }
            }

            @Override
            public String getDescription() {
                return "*.txt";
            }

        });
        jfc.showOpenDialog(null);
        File file = jfc.getSelectedFile();
        if (file.isFile()) {
            try {
                String[] tt = JAppToolKit.JDataHelper.readAllLines(file.getAbsolutePath());
                StringBuilder sb = new StringBuilder();
                for (String s : tt) {
                    sb.append(s).append("\n");
                }
                tbSpeakText.setText(sb.toString());
            } catch (Exception ex) {
                Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnLoadFromMouseClicked

    private void btnExportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportMouseClicked
        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jfc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isFile()) {
                    return f != null ? (f.getName().endsWith(".ogg")) : false;
                } else {
                    return true;
                }
            }

            @Override
            public String getDescription() {
                return "*.ogg";
            }

        });
        jfc.showSaveDialog(null);
        File file = jfc.getSelectedFile();
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    JTextSpeaker.exportToOggFile(file.getAbsolutePath() + ".ogg", getSpeakConfig(), true);

                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "导出完成！", "提示", JOptionPane.WARNING_MESSAGE);
                }

            }).start();
            
            JOptionPane.showMessageDialog(null, "正在导出到OGG文件，请稍等！");
        } catch (Exception ex) {
            Logger.getLogger(MainPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private WSwingUILib.Component.JUIButton btnExport;
    private WSwingUILib.Component.JUIButton btnLoadFrom;
    private WSwingUILib.Component.JUIButton btnPlay;
    private WSwingUILib.Component.JUIButton btnStop;
    private javax.swing.JComboBox<String> cbSpeakerList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel plTool;
    private javax.swing.JSlider srPitch;
    private javax.swing.JSlider srSpeed;
    private javax.swing.JSlider srVolume;
    private javax.swing.JTextPane tbSpeakText;
    // End of variables declaration//GEN-END:variables
}
