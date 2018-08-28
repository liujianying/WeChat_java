package com.tencent.mm.modelrecovery;

public class b$b {
    public int edA;
    public int edB;
    public int edC;
    public int edr;
    public int eds;
    public int edt;
    public int edu;
    public int edv;
    public int edw;
    public int edx;
    public int edy;
    public int edz;

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.edr > 0) {
            stringBuffer.append("appForegroundExpCount:" + this.edr + " ");
        }
        if (this.eds > 0) {
            stringBuffer.append("appBackgroundExpCount:" + this.eds + " ");
        }
        if (this.edt > 0) {
            stringBuffer.append("componentForegroundExpCount:" + this.edt + " ");
        }
        if (this.edu > 0) {
            stringBuffer.append("componentBackgroundExpCount:" + this.edu + " ");
        }
        if (this.edv > 0) {
            stringBuffer.append("appForegroundCrashOrAnrExpCount:" + this.edv + " ");
        }
        if (this.edw > 0) {
            stringBuffer.append("appBackgroundCrashOrAnrExpCount:" + this.edw + " ");
        }
        if (this.edx > 0) {
            stringBuffer.append("componentForegroundCrashOrAnrExpCount:" + this.edx + " ");
        }
        if (this.edy > 0) {
            stringBuffer.append("componentBackgroundCrashOrAnrExpCount:" + this.edy + " ");
        }
        if (this.edz > 0) {
            stringBuffer.append("appForegroundTimeoutExpCount:" + this.edz + " ");
        }
        if (this.edA > 0) {
            stringBuffer.append("appBackgroundTimeoutExpCount:" + this.edA + " ");
        }
        if (this.edB > 0) {
            stringBuffer.append("componentForegroundTimeoutExpCount:" + this.edB + " ");
        }
        if (this.edC > 0) {
            stringBuffer.append("componentBackgroundTimeoutExpCount:" + this.edC + " ");
        }
        return stringBuffer.toString();
    }
}
