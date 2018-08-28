package com.tencent.mm.g.b.a;

import com.tencent.mm.plugin.report.a;

public final class b extends a {
    public String cgb = "";
    public int cge = 0;
    public long cgf = 0;
    public long cgg = 0;
    public long cgh = 0;
    private long cgj = 0;
    public long cgk = 0;
    public String cgl = "";

    public final int getId() {
        return 15460;
    }

    public final b an(long j) {
        this.cgj = j;
        String str = "StayTimeMs";
        long j2 = this.cgj;
        if (j2 <= 0) {
            super.eo(str, String.valueOf(j2));
        } else if (j2 >= 3600000) {
            super.eo(str, String.valueOf(j2));
        }
        return this;
    }

    public final String wE() {
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cgb);
        stringBuffer.append(str);
        stringBuffer.append(this.cge);
        stringBuffer.append(str);
        stringBuffer.append(this.cgf);
        stringBuffer.append(str);
        stringBuffer.append(this.cgg);
        stringBuffer.append(str);
        stringBuffer.append(this.cgh);
        stringBuffer.append(str);
        stringBuffer.append(this.cgj);
        stringBuffer.append(str);
        stringBuffer.append(this.cgk);
        stringBuffer.append(str);
        stringBuffer.append(this.cgl);
        str = stringBuffer.toString();
        KD(str);
        return str;
    }

    public final String wF() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ChatroomName:").append(this.cgb);
        stringBuffer.append("\r\n");
        stringBuffer.append("ChatroomMute:").append(this.cge);
        stringBuffer.append("\r\n");
        stringBuffer.append("UnreadCount:").append(this.cgf);
        stringBuffer.append("\r\n");
        stringBuffer.append("DisRedDotCount:").append(this.cgg);
        stringBuffer.append("\r\n");
        stringBuffer.append("EnterCount:").append(this.cgh);
        stringBuffer.append("\r\n");
        stringBuffer.append("StayTimeMs:").append(this.cgj);
        stringBuffer.append("\r\n");
        stringBuffer.append("SendCount:").append(this.cgk);
        stringBuffer.append("\r\n");
        stringBuffer.append("Score:").append(this.cgl);
        return stringBuffer.toString();
    }
}
