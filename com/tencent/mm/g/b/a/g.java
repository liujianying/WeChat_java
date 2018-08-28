package com.tencent.mm.g.b.a;

import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Arrays;

public final class g extends a {
    public long chJ = 0;
    public long chK = 0;
    public String chL = "";
    public boolean chM;

    public g(String str) {
        if (str != null) {
            Object split = str.split(",");
            if (split != null) {
                Object obj;
                boolean z;
                if (split.length < 4) {
                    obj = new String[4];
                    Arrays.fill(obj, 0, 4, "");
                    System.arraycopy(split, 0, obj, 0, split.length);
                } else {
                    obj = split;
                }
                this.chJ = bi.getLong(obj[0], 0);
                ao(bi.getLong(obj[1], 0));
                this.chL = obj[2];
                if (bi.getInt(obj[3], 0) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.chM = z;
            }
        }
    }

    public final int getId() {
        return 0;
    }

    private g ao(long j) {
        this.chK = j;
        super.ae("StartTimeStampSec", this.chK);
        return this;
    }

    public final g wG() {
        return ao(bi.VE());
    }

    public final String wE() {
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.chJ);
        stringBuffer.append(str);
        stringBuffer.append(this.chK);
        stringBuffer.append(str);
        stringBuffer.append(this.chL);
        stringBuffer.append(str);
        stringBuffer.append(this.chM ? 1 : 0);
        str = stringBuffer.toString();
        KD(str);
        return str;
    }

    public final String wF() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ExptFlag:").append(this.chJ);
        stringBuffer.append("\r\n");
        stringBuffer.append("StartTimeStampSec:").append(this.chK);
        stringBuffer.append("\r\n");
        stringBuffer.append("Roomname:").append(this.chL);
        stringBuffer.append("\r\n");
        stringBuffer.append("hardcodeExptBool:").append(this.chM);
        return stringBuffer.toString();
    }
}
