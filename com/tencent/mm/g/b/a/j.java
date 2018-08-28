package com.tencent.mm.g.b.a;

import com.tencent.mm.plugin.report.a;

public final class j extends a {
    public long cip = 0;
    public long ciq = 0;

    public final int getId() {
        return 15522;
    }

    public final String wE() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cip);
        stringBuffer.append(",");
        stringBuffer.append(this.ciq);
        String stringBuffer2 = stringBuffer.toString();
        KD(stringBuffer2);
        return stringBuffer2;
    }

    public final String wF() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ReportScene:").append(this.cip);
        stringBuffer.append("\r\n");
        stringBuffer.append("ResetScece:").append(this.ciq);
        return stringBuffer.toString();
    }
}
