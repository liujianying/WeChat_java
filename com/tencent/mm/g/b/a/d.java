package com.tencent.mm.g.b.a;

import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Arrays;

public final class d extends a {
    private String cgA = "";
    private String cgB = "";
    private int cgC = 0;
    private String cgD = "";
    private long cgE = 0;
    private long cgF = 0;
    private long cgG = 0;
    private long cgH = 0;
    private long cgI = 0;
    private long cgJ = 0;
    private long cgK = 0;
    private long cgL = 0;
    private long cgM = 0;
    private String cgN = "";
    private long cgO = 0;
    private long cgP = 0;
    private long cgQ = 0;
    private String cgR = "";
    private String cgx = "";
    private String cgy = "";
    private long cgz = 0;

    public d(String str) {
        if (str != null) {
            Object split = str.split(",");
            if (split != null) {
                Object obj;
                if (split.length < 21) {
                    obj = new String[21];
                    Arrays.fill(obj, 0, 21, "");
                    System.arraycopy(split, 0, obj, 0, split.length);
                } else {
                    obj = split;
                }
                this.cgx = obj[0];
                this.cgy = obj[1];
                this.cgz = bi.getLong(obj[2], 0);
                this.cgA = obj[3];
                this.cgB = obj[4];
                this.cgC = bi.getInt(obj[5], 0);
                this.cgD = obj[6];
                this.cgE = bi.getLong(obj[7], 0);
                this.cgF = bi.getLong(obj[8], 0);
                this.cgG = bi.getLong(obj[9], 0);
                this.cgH = bi.getLong(obj[10], 0);
                this.cgI = bi.getLong(obj[11], 0);
                this.cgJ = bi.getLong(obj[12], 0);
                this.cgK = bi.getLong(obj[13], 0);
                this.cgL = bi.getLong(obj[14], 0);
                this.cgM = bi.getLong(obj[15], 0);
                this.cgN = obj[16];
                this.cgO = bi.getLong(obj[17], 0);
                this.cgP = bi.getLong(obj[18], 0);
                this.cgQ = bi.getLong(obj[19], 0);
                this.cgR = obj[20];
            }
        }
    }

    public final int getId() {
        return 13795;
    }

    public final String wE() {
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cgx);
        stringBuffer.append(str);
        stringBuffer.append(this.cgy);
        stringBuffer.append(str);
        stringBuffer.append(this.cgz);
        stringBuffer.append(str);
        stringBuffer.append(this.cgA);
        stringBuffer.append(str);
        stringBuffer.append(this.cgB);
        stringBuffer.append(str);
        stringBuffer.append(this.cgC);
        stringBuffer.append(str);
        stringBuffer.append(this.cgD);
        stringBuffer.append(str);
        stringBuffer.append(this.cgE);
        stringBuffer.append(str);
        stringBuffer.append(this.cgF);
        stringBuffer.append(str);
        stringBuffer.append(this.cgG);
        stringBuffer.append(str);
        stringBuffer.append(this.cgH);
        stringBuffer.append(str);
        stringBuffer.append(this.cgI);
        stringBuffer.append(str);
        stringBuffer.append(this.cgJ);
        stringBuffer.append(str);
        stringBuffer.append(this.cgK);
        stringBuffer.append(str);
        stringBuffer.append(this.cgL);
        stringBuffer.append(str);
        stringBuffer.append(this.cgM);
        stringBuffer.append(str);
        stringBuffer.append(this.cgN);
        stringBuffer.append(str);
        stringBuffer.append(this.cgO);
        stringBuffer.append(str);
        stringBuffer.append(this.cgP);
        stringBuffer.append(str);
        stringBuffer.append(this.cgQ);
        stringBuffer.append(str);
        stringBuffer.append(this.cgR);
        str = stringBuffer.toString();
        KD(str);
        return str;
    }

    public final String wF() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FromUser:").append(this.cgx);
        stringBuffer.append("\r\n");
        stringBuffer.append("Session:").append(this.cgy);
        stringBuffer.append("\r\n");
        stringBuffer.append("ChatNum:").append(this.cgz);
        stringBuffer.append("\r\n");
        stringBuffer.append("FileId:").append(this.cgA);
        stringBuffer.append("\r\n");
        stringBuffer.append("SnsUrl:").append(this.cgB);
        stringBuffer.append("\r\n");
        stringBuffer.append("NetType:").append(this.cgC);
        stringBuffer.append("\r\n");
        stringBuffer.append("NewMd5:").append(this.cgD);
        stringBuffer.append("\r\n");
        stringBuffer.append("DownloadStartTime:").append(this.cgE);
        stringBuffer.append("\r\n");
        stringBuffer.append("DownloadEndTime:").append(this.cgF);
        stringBuffer.append("\r\n");
        stringBuffer.append("VideoSize:").append(this.cgG);
        stringBuffer.append("\r\n");
        stringBuffer.append("VideoDuration:").append(this.cgH);
        stringBuffer.append("\r\n");
        stringBuffer.append("VideoBitrate:").append(this.cgI);
        stringBuffer.append("\r\n");
        stringBuffer.append("AudioBitrate:").append(this.cgJ);
        stringBuffer.append("\r\n");
        stringBuffer.append("VideoFps:").append(this.cgK);
        stringBuffer.append("\r\n");
        stringBuffer.append("VideoWidth:").append(this.cgL);
        stringBuffer.append("\r\n");
        stringBuffer.append("VideoHeight:").append(this.cgM);
        stringBuffer.append("\r\n");
        stringBuffer.append("CDNIp:").append(this.cgN);
        stringBuffer.append("\r\n");
        stringBuffer.append("OriginalAudioChannel:").append(this.cgO);
        stringBuffer.append("\r\n");
        stringBuffer.append("HadPreloadSize:").append(this.cgP);
        stringBuffer.append("\r\n");
        stringBuffer.append("HadPreloadCompletion:").append(this.cgQ);
        stringBuffer.append("\r\n");
        stringBuffer.append("Publishid:").append(this.cgR);
        return stringBuffer.toString();
    }
}
