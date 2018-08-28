package com.tencent.mm.g.b.a;

import com.tencent.mm.plugin.report.a;

public final class m extends a {
    private long chK = 0;
    public long ciA = 0;
    public long ciB = 0;
    public long ciC = 0;
    private long ciD = 0;
    public String ciE = "";
    public String ciF = "";

    public final int getId() {
        return 15452;
    }

    public final m ap(long j) {
        this.chK = j;
        super.ae("StartTimeStampSec", this.chK);
        return this;
    }

    public final m aq(long j) {
        this.ciD = j;
        super.ae("EndTimeStampSec", this.ciD);
        return this;
    }

    public final String wE() {
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ciA);
        stringBuffer.append(str);
        stringBuffer.append(this.ciB);
        stringBuffer.append(str);
        stringBuffer.append(this.ciC);
        stringBuffer.append(str);
        stringBuffer.append(this.chK);
        stringBuffer.append(str);
        stringBuffer.append(this.ciD);
        stringBuffer.append(str);
        stringBuffer.append(this.ciE);
        stringBuffer.append(str);
        stringBuffer.append(this.ciF);
        str = stringBuffer.toString();
        KD(str);
        return str;
    }

    public final String wF() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ExptId:").append(this.ciA);
        stringBuffer.append("\r\n");
        stringBuffer.append("GroupId:").append(this.ciB);
        stringBuffer.append("\r\n");
        stringBuffer.append("ExptSeq:").append(this.ciC);
        stringBuffer.append("\r\n");
        stringBuffer.append("StartTimeStampSec:").append(this.chK);
        stringBuffer.append("\r\n");
        stringBuffer.append("EndTimeStampSec:").append(this.ciD);
        stringBuffer.append("\r\n");
        stringBuffer.append("ExptKey:").append(this.ciE);
        stringBuffer.append("\r\n");
        stringBuffer.append("ExptVal:").append(this.ciF);
        return stringBuffer.toString();
    }
}
