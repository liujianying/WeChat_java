package com.tencent.mm.g.b.a;

import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Arrays;

public final class i extends a {
    private String cgB = "";
    private int cgC = 0;
    private String cgD = "";
    private String cgN = "";
    private long cgO = 0;
    private String chT = "";
    private String chU = "";
    private String chV = "";
    private String chW = "";
    private long chX = 0;
    private long chY = 0;
    private long chZ = 0;
    private long cia = 0;
    private long cib = 0;
    private long cic = 0;
    private long cid = 0;
    private long cie = 0;
    private long cif = 0;
    private int cig = 0;
    private long cih = 0;
    private long cii = 0;
    private long cij = 0;
    private long cik = 0;
    private long cil = 0;
    private long cim = 0;
    private long cin = 0;
    private long cio = 0;

    public i(String str) {
        if (str != null) {
            Object split = str.split(",");
            if (split != null) {
                Object obj;
                if (split.length < 27) {
                    obj = new String[27];
                    Arrays.fill(obj, 0, 27, "");
                    System.arraycopy(split, 0, obj, 0, split.length);
                } else {
                    obj = split;
                }
                this.chT = obj[0];
                this.chU = obj[1];
                this.cgC = bi.getInt(obj[2], 0);
                this.chV = obj[3];
                this.cgD = obj[4];
                this.chW = obj[5];
                this.chX = bi.getLong(obj[6], 0);
                this.chY = bi.getLong(obj[7], 0);
                this.chZ = bi.getLong(obj[8], 0);
                this.cia = bi.getLong(obj[9], 0);
                this.cib = bi.getLong(obj[10], 0);
                this.cic = bi.getLong(obj[11], 0);
                this.cid = bi.getLong(obj[12], 0);
                this.cie = bi.getLong(obj[13], 0);
                this.cif = bi.getLong(obj[14], 0);
                this.cig = bi.getInt(obj[15], 0);
                this.cih = bi.getLong(obj[16], 0);
                this.cii = bi.getLong(obj[17], 0);
                this.cij = bi.getLong(obj[18], 0);
                this.cik = bi.getLong(obj[19], 0);
                this.cil = bi.getLong(obj[20], 0);
                this.cim = bi.getLong(obj[21], 0);
                this.cin = bi.getLong(obj[22], 0);
                this.cio = bi.getLong(obj[23], 0);
                this.cgN = obj[24];
                this.cgO = bi.getLong(obj[25], 0);
                this.cgB = obj[26];
            }
        }
    }

    public final int getId() {
        return 13794;
    }

    public final String wE() {
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.chT);
        stringBuffer.append(str);
        stringBuffer.append(this.chU);
        stringBuffer.append(str);
        stringBuffer.append(this.cgC);
        stringBuffer.append(str);
        stringBuffer.append(this.chV);
        stringBuffer.append(str);
        stringBuffer.append(this.cgD);
        stringBuffer.append(str);
        stringBuffer.append(this.chW);
        stringBuffer.append(str);
        stringBuffer.append(this.chX);
        stringBuffer.append(str);
        stringBuffer.append(this.chY);
        stringBuffer.append(str);
        stringBuffer.append(this.chZ);
        stringBuffer.append(str);
        stringBuffer.append(this.cia);
        stringBuffer.append(str);
        stringBuffer.append(this.cib);
        stringBuffer.append(str);
        stringBuffer.append(this.cic);
        stringBuffer.append(str);
        stringBuffer.append(this.cid);
        stringBuffer.append(str);
        stringBuffer.append(this.cie);
        stringBuffer.append(str);
        stringBuffer.append(this.cif);
        stringBuffer.append(str);
        stringBuffer.append(this.cig);
        stringBuffer.append(str);
        stringBuffer.append(this.cih);
        stringBuffer.append(str);
        stringBuffer.append(this.cii);
        stringBuffer.append(str);
        stringBuffer.append(this.cij);
        stringBuffer.append(str);
        stringBuffer.append(this.cik);
        stringBuffer.append(str);
        stringBuffer.append(this.cil);
        stringBuffer.append(str);
        stringBuffer.append(this.cim);
        stringBuffer.append(str);
        stringBuffer.append(this.cin);
        stringBuffer.append(str);
        stringBuffer.append(this.cio);
        stringBuffer.append(str);
        stringBuffer.append(this.cgN);
        stringBuffer.append(str);
        stringBuffer.append(this.cgO);
        stringBuffer.append(str);
        stringBuffer.append(this.cgB);
        str = stringBuffer.toString();
        KD(str);
        return str;
    }

    public final String wF() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ToUser:").append(this.chT);
        stringBuffer.append("\r\n");
        stringBuffer.append("MsgSource:").append(this.chU);
        stringBuffer.append("\r\n");
        stringBuffer.append("NetType:").append(this.cgC);
        stringBuffer.append("\r\n");
        stringBuffer.append("FieldId:").append(this.chV);
        stringBuffer.append("\r\n");
        stringBuffer.append("NewMd5:").append(this.cgD);
        stringBuffer.append("\r\n");
        stringBuffer.append("SnsInfoId:").append(this.chW);
        stringBuffer.append("\r\n");
        stringBuffer.append("UploadStartTime:").append(this.chX);
        stringBuffer.append("\r\n");
        stringBuffer.append("UploadEndTime:").append(this.chY);
        stringBuffer.append("\r\n");
        stringBuffer.append("OriginalSize:").append(this.chZ);
        stringBuffer.append("\r\n");
        stringBuffer.append("OriginalDuration:").append(this.cia);
        stringBuffer.append("\r\n");
        stringBuffer.append("OriginalVideoBitrate:").append(this.cib);
        stringBuffer.append("\r\n");
        stringBuffer.append("OriginalAudioBitrate:").append(this.cic);
        stringBuffer.append("\r\n");
        stringBuffer.append("OriginalFps:").append(this.cid);
        stringBuffer.append("\r\n");
        stringBuffer.append("OriginalWidth:").append(this.cie);
        stringBuffer.append("\r\n");
        stringBuffer.append("OriginalHeight:").append(this.cif);
        stringBuffer.append("\r\n");
        stringBuffer.append("CpStatus:").append(this.cig);
        stringBuffer.append("\r\n");
        stringBuffer.append("CpSize:").append(this.cih);
        stringBuffer.append("\r\n");
        stringBuffer.append("CpDuration:").append(this.cii);
        stringBuffer.append("\r\n");
        stringBuffer.append("CpVideoBitrate:").append(this.cij);
        stringBuffer.append("\r\n");
        stringBuffer.append("CpAudioiBitrate:").append(this.cik);
        stringBuffer.append("\r\n");
        stringBuffer.append("CpFps:").append(this.cil);
        stringBuffer.append("\r\n");
        stringBuffer.append("CpWidth:").append(this.cim);
        stringBuffer.append("\r\n");
        stringBuffer.append("CpHeight:").append(this.cin);
        stringBuffer.append("\r\n");
        stringBuffer.append("SendScene:").append(this.cio);
        stringBuffer.append("\r\n");
        stringBuffer.append("CDNIp:").append(this.cgN);
        stringBuffer.append("\r\n");
        stringBuffer.append("OriginalAudioChannel:").append(this.cgO);
        stringBuffer.append("\r\n");
        stringBuffer.append("SnsUrl:").append(this.cgB);
        return stringBuffer.toString();
    }
}
