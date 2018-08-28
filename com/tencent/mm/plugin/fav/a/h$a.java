package com.tencent.mm.plugin.fav.a;

public class h$a {
    public String bWm;
    public long iVH;
    public String iVI;
    public long iVJ;
    public long iVK;
    public boolean iVL;
    public int iVM;
    public int iVN;
    public int iVO;
    public int iVP;
    public int iVQ;
    public boolean iVR;
    public boolean iVS;
    public int iVT;
    public String iVU;
    public int iVV;
    public String iVW;
    public int index;
    public int scene;
    public int source;
    public long timestamp;
    public int type;

    public final String toString() {
        int i;
        int i2 = 1;
        String str = "%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s";
        Object[] objArr = new Object[22];
        objArr[0] = Integer.valueOf(this.scene);
        objArr[1] = Integer.valueOf(this.index);
        objArr[2] = Long.valueOf(this.iVH);
        objArr[3] = Integer.valueOf(this.type);
        objArr[4] = this.iVI;
        objArr[5] = Integer.valueOf(this.source);
        objArr[6] = Long.valueOf(this.timestamp);
        objArr[7] = Long.valueOf(this.iVJ);
        objArr[8] = Long.valueOf(this.iVK);
        if (this.iVL) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[9] = Integer.valueOf(i);
        objArr[10] = Integer.valueOf(this.iVM);
        objArr[11] = Integer.valueOf(this.iVN);
        objArr[12] = Integer.valueOf(this.iVO);
        objArr[13] = Integer.valueOf(this.iVP);
        objArr[14] = Integer.valueOf(this.iVQ);
        objArr[15] = Integer.valueOf(this.iVR ? 1 : 0);
        if (!this.iVS) {
            i2 = 0;
        }
        objArr[16] = Integer.valueOf(i2);
        objArr[17] = Integer.valueOf(this.iVT);
        objArr[18] = this.iVU;
        objArr[19] = Integer.valueOf(this.iVV);
        objArr[20] = this.bWm;
        objArr[21] = this.iVW;
        return String.format(str, objArr);
    }
}
