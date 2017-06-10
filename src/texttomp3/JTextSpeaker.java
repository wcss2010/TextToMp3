/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texttomp3;

import java.util.logging.Level;
import java.util.logging.Logger;
import texttomp3.Pages.MainPanel;

/**
 *
 * @author wcss
 */
public class JTextSpeaker {

    /**
     * 执行EKHO指令
     *
     * @param content 指令内容
     * @param isWaitFor 是否等待
     */
    public static Process runEkhoCmd(String content, boolean isWaitFor) {
        if (content == null || content.equals("")) {
            return null;
        }

        try {
            // TODO code application logic here
            return JAppToolKit.JRunHelper.runSysCmd("ekho " + content, isWaitFor);
        } catch (Exception ex) {
            Logger.getLogger(TextToMp3.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * 生成朗读指令
     * @return 
     */
    private static String getSpeakTextParam(SpeakConfig config)
    {
       StringBuilder sb = new StringBuilder();
       sb.append("-v ").append(config.getSpeaker().name()).append(" --speed=").append(config.getSpeed()).append(" --volume=").append(config.getVolume()).append(" --pitch=").append(config.getPitch()).append(" ").append(config.getTextFile() == null?"\"" + config.getText() + "\"":"--file=" + config.getTextFile().getAbsolutePath());
       return sb.toString();
    }
    
    /**
     * 播放文本
     *
     * @param speaker 朗读者('Cantonese', 'Mandarin', 'Toisanese', 'Hakka',
     * 'Tibetan', 'Ngangien','Hangul')
     * @param txt 文本
     * @param isWaitFor 是否等待
     */
    public static Process playText(SpeakConfig config, boolean isWaitFor) {
        return runEkhoCmd(getSpeakTextParam(config), isWaitFor);
    }
    
    /**
     * 导出语音到Ogg文件
     * @param outputFile 输出.ogg文件
     * @param txt 朗读的文本
     * @param isWaitFor 是否等待
     */
    public static Process exportToOggFile(String outputFile,SpeakConfig config,boolean isWaitFor) {
        return runEkhoCmd("-t ogg -o " + outputFile + " " + getSpeakTextParam(config),isWaitFor);
    }
    
    /**
     * 杀掉EKHO进程
     * @return 
     */
    public static Process killEkho()
    {
        try {
            // TODO add your handling code here:
            return JAppToolKit.JRunHelper.runSysCmd("killall ekho", false);
        } catch (Exception ex) {
            Logger.getLogger(JTextSpeaker.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}