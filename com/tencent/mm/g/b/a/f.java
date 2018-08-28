package com.tencent.mm.g.b.a;

import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Arrays;

public final class f extends a {
    private String cgA = "";
    private String cgB = "";
    private String cgD = "";
    private long cgE = 0;
    private long cgF = 0;
    private String cgN = "";
    private String cgR = "";
    private String cgx = "";
    private String cgy = "";
    private long chE = 0;
    private long chF = 0;
    private int chG = 0;
    private long chH = 0;
    private long chI = 0;

    public f(String str) {
        if (str != null) {
            Object split = str.split(",");
            if (split != null) {
                Object obj;
                if (split.length < 14) {
                    obj = new String[14];
                    Arrays.fill(obj, 0, 14, "");
                    System.arraycopy(split, 0, obj, 0, split.length);
                } else {
                    obj = split;
                }
                this.cgE = bi.getLong(obj[0], 0);
                this.cgF = bi.getLong(obj[1], 0);
                this.chE = bi.getLong(obj[2], 0);
                this.cgD = obj[3];
                this.chF = bi.getLong(obj[4], 0);
                this.chG = bi.getInt(obj[5], 0);
                this.chH = bi.getLong(obj[6], 0);
                this.cgN = obj[7];
                this.cgx = obj[8];
                this.cgy = obj[9];
                this.chI = bi.getLong(obj[10], 0);
                this.cgA = obj[11];
                this.cgB = obj[12];
                this.cgR = obj[13];
            }
        }
    }

    public final int getId() {
        return 14499;
    }

    public final String wE() {
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cgE);
        stringBuffer.append(str);
        stringBuffer.append(this.cgF);
        stringBuffer.append(str);
        stringBuffer.append(this.chE);
        stringBuffer.append(str);
        stringBuffer.append(this.cgD);
        stringBuffer.append(str);
        stringBuffer.append(this.chF);
        stringBuffer.append(str);
        stringBuffer.append(this.chG);
        stringBuffer.append(str);
        stringBuffer.append(this.chH);
        stringBuffer.append(str);
        stringBuffer.append(this.cgN);
        stringBuffer.append(str);
        stringBuffer.append(this.cgx);
        stringBuffer.append(str);
        stringBuffer.append(this.cgy);
        stringBuffer.append(str);
        stringBuffer.append(this.chI);
        stringBuffer.append(str);
        stringBuffer.append(this.cgA);
        stringBuffer.append(str);
        stringBuffer.append(this.cgB);
        stringBuffer.append(str);
        stringBuffer.append(this.cgR);
        str = stringBuffer.toString();
        KD(str);
        return str;
    }

    public final String wF() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DownloadStartTime:").append(this.cgE);
        stringBuffer.append("\r\n");
        stringBuffer.append("DownloadEndTime:").append(this.cgF);
        stringBuffer.append("\r\n");
        stringBuffer.append("DownloadSize:").append(this.chE);
        stringBuffer.append("\r\n");
        stringBuffer.append("NewMd5:").append(this.cgD);
        stringBuffer.append("\r\n");
        stringBuffer.append("MsgType:").append(this.chF);
        stringBuffer.append("\r\n");
        stringBuffer.append("DownloadSpeed:").append(this.chG);
        stringBuffer.append("\r\n");
        stringBuffer.append("HadFinishSize:").append(this.chH);
        stringBuffer.append("\r\n");
        stringBuffer.append("CDNIp:").append(this.cgN);
        stringBuffer.append("\r\n");
        stringBuffer.append("FromUser:").append(this.cgx);
        stringBuffer.append("\r\n");
        stringBuffer.append("Session:").append(this.cgy);
        stringBuffer.append("\r\n");
        stringBuffer.append("ChatroomNum:").append(this.chI);
        stringBuffer.append("\r\n");
        stringBuffer.append("FileId:").append(this.cgA);
        stringBuffer.append("\r\n");
        stringBuffer.append("SnsUrl:").append(this.cgB);
        stringBuffer.append("\r\n");
        stringBuffer.append("Publishid:").append(this.cgR);
        return stringBuffer.toString();
    }
}
