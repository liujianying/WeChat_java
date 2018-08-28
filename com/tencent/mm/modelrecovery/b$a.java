package com.tencent.mm.modelrecovery;

public class b$a {
    public int edl;
    public int edm;
    public int edn;
    public int edo;
    public int edp;
    public int edq;

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.edl > 0) {
            stringBuffer.append("totalCount:" + this.edl + " ");
        }
        if (this.edm > 0) {
            stringBuffer.append("enterRecoveryCount:" + this.edm + " ");
        }
        if (this.edn > 0) {
            stringBuffer.append("existRecoveryProcessCount:" + this.edn + " ");
        }
        if (this.edo > 0) {
            stringBuffer.append("foregroundExpCount:" + this.edo + " ");
        }
        if (this.edp > 0) {
            stringBuffer.append("backgroundExpCount:" + this.edp + " ");
        }
        if (this.edq > 0) {
            stringBuffer.append("normalCount:" + this.edq + " ");
        }
        return stringBuffer.toString();
    }
}
