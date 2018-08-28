package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.x;

public final class g {
    public String bSZ;
    public int cXB;
    public long cYb;
    public String extra = "";
    public int iVN;
    public int iVO;
    public int jzg;
    public int nBk;
    public int nIF;
    public int nIG;
    public int nIH;
    public int nII;
    public int nIJ;
    public int nIK;
    public int nIL;
    public int nIM;
    public String nIN;
    public String nIO;
    public String nIP;
    public String ntU;
    public String ntX;

    public final String bAC() {
        long j = 0;
        try {
            j = i.LP(this.bSZ);
        } catch (Exception e) {
            x.e("AdLandingPagesReportInfo", "", new Object[]{e});
        }
        return i.eF(j) + "," + this.ntU + "," + this.nIF + "," + this.cXB + "," + this.nIG + "," + this.nIH + "," + this.nII + "," + this.nIJ + "," + this.nIK + "," + this.nIL + "," + this.nIM + "," + this.iVO + "," + this.iVN + "," + this.jzg + "," + this.nIN + "," + this.cYb + "," + this.nIO + "," + (this.ntX == null ? "" : this.ntX) + "," + this.extra + "," + this.nBk + "," + this.nIP;
    }
}
