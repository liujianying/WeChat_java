package com.tencent.mm.g.b.a;

import com.tencent.mm.plugin.report.a;

public final class l extends a {
    public long ciu = 0;
    public long ciw = 0;
    public String cix = "";
    public long ciy = 0;
    public long ciz = 0;

    public final int getId() {
        return 15402;
    }

    public final String wE() {
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ciw);
        stringBuffer.append(str);
        stringBuffer.append(this.cix);
        stringBuffer.append(str);
        stringBuffer.append(this.ciy);
        stringBuffer.append(str);
        stringBuffer.append(this.ciz);
        stringBuffer.append(str);
        stringBuffer.append(this.ciu);
        str = stringBuffer.toString();
        KD(str);
        return str;
    }

    public final String wF() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DeleteReason:").append(this.ciw);
        stringBuffer.append("\r\n");
        stringBuffer.append("Appid:").append(this.cix);
        stringBuffer.append("\r\n");
        stringBuffer.append("DebugType:").append(this.ciy);
        stringBuffer.append("\r\n");
        stringBuffer.append("DeleteCount:").append(this.ciz);
        stringBuffer.append("\r\n");
        stringBuffer.append("AbtestStatus:").append(this.ciu);
        return stringBuffer.toString();
    }
}
