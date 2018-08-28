package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.appbrand.appcache.k;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class n {
    public final String appId;
    private int bMH;
    public final int fgJ;
    public final int gfU;
    private long gsp;
    public final boolean gsq;
    public boolean gsr;
    public boolean gss;
    public int gst;
    public int gsu;
    public long gsv;

    public n(String str, int i, int i2) {
        if ("@LibraryAppId".equals(str)) {
            this.appId = "publiclib";
            this.gsq = k.abF();
        } else {
            this.appId = str;
            this.gsq = k.abE();
        }
        this.fgJ = i;
        this.gfU = i2;
    }

    public final void amR() {
        this.gsp = bi.VF() - this.gsv;
    }

    public final void lD(int i) {
        if (this.gsq) {
            this.bMH = i;
        }
    }

    public final String toString() {
        return "kv_14609{appId='" + this.appId + '\'' + ", oldVersion=" + this.fgJ + ", targetVersion=" + this.gfU + ", spendTime=" + this.gsp + ", canUsePatchUpdate=" + this.gsq + ", isUpdateComplete=" + this.gsr + ", isUpdateCompleteWithPatch=" + this.gss + ", fullPkgSize=" + this.gst + ", patchSize=" + this.gsu + ", errcode=" + this.bMH + '}';
    }

    public final void xP() {
        int i;
        int i2 = 1;
        x.i("MicroMsg.AppBrand.Report.kv_14609", "report %s", new Object[]{toString()});
        f fVar = f.mDy;
        Object[] objArr = new Object[12];
        objArr[0] = this.appId;
        objArr[1] = Integer.valueOf(1);
        objArr[2] = a.cH(ad.getContext());
        objArr[3] = Integer.valueOf(this.fgJ);
        objArr[4] = Integer.valueOf(this.gfU);
        objArr[5] = Long.valueOf(this.gsp);
        objArr[6] = Integer.valueOf(this.gsq ? 1 : 0);
        if (this.gsr) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[7] = Integer.valueOf(i);
        if (!this.gss) {
            i2 = 0;
        }
        objArr[8] = Integer.valueOf(i2);
        objArr[9] = Integer.valueOf(this.gst);
        objArr[10] = Integer.valueOf(this.gsu);
        objArr[11] = Integer.valueOf(this.bMH);
        fVar.h(14609, objArr);
    }
}
