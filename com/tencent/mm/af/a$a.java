package com.tencent.mm.af;

public class a$a implements Comparable<a$a> {
    public long dQX = 0;
    public int dQY = 0;
    public boolean dQZ = true;
    public boolean dRa = false;
    public int dRb = 0;
    public long dRc = 0;
    public long dRd = 0;
    public long dRe = 0;
    public long endTime = 0;
    public int pid = 0;
    public long startTime = 0;
    public int type = 0;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        a$a a_a = (a$a) obj;
        return (this.dQX == 0 || a_a.dQX == 0) ? (int) (this.startTime - a_a.startTime) : (int) (this.dQX - a_a.dQX);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        switch (this.type) {
            case 0:
                stringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,[mm] pid:%s,normal execute:%s", new Object[]{a.bn(this.dQX), a.bn(this.startTime), a.bn(this.endTime), Integer.valueOf(this.pid), Boolean.valueOf(this.dQZ)}));
                break;
            case 1:
                stringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,[push] pid:%s,network:%s,normal execute:%s", new Object[]{a.bn(this.dQX), a.bn(this.startTime), a.bn(this.endTime), Integer.valueOf(this.pid), Integer.valueOf(this.dQY), Boolean.valueOf(this.dQZ)}));
                break;
            case 2:
                stringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,send broadcast type(push):%s", new Object[]{a.bn(this.dQX), a.bn(this.startTime), a.bn(this.endTime), Integer.valueOf(this.dRb)}));
                break;
            case 3:
                stringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,receive broadcast type(mm):%s", new Object[]{a.bn(this.dQX), a.bn(this.startTime), a.bn(this.endTime), Integer.valueOf(this.dRb)}));
                break;
            case 4:
                stringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,delayed msg pid:%s, msg server time:%s,interval time:%s, msg server id:%s", new Object[]{a.bn(this.dQX), a.bn(this.startTime), a.bn(this.endTime), Integer.valueOf(this.pid), a.bn(this.dRc), Long.valueOf(this.dRd), Long.valueOf(this.dRe)}));
                break;
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
