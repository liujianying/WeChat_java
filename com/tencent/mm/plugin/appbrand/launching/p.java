package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ak;
import com.tencent.mm.plugin.appbrand.appcache.ak.a;
import com.tencent.mm.plugin.appbrand.appcache.b;
import com.tencent.mm.plugin.appbrand.appcache.d;
import com.tencent.mm.plugin.appbrand.appcache.k;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.protocal.c.akl;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;

public final class p extends o {
    public final String appId;
    public final int bPh;
    public final String fgp;
    public final int gfU;
    public final boolean gfV;

    public p(String str, String str2, int i) {
        this(str, str2, i, true);
    }

    public p(String str, String str2, int i, boolean z) {
        super(new r(str, str2));
        this.bPh = 0;
        this.appId = str;
        this.fgp = str2;
        this.gfU = i;
        this.gfV = z;
    }

    public final String akH() {
        return String.format(Locale.US, "pkg %s, targetVersion %d, pkgType %d", new Object[]{this.gfS.toString(), Integer.valueOf(this.gfU), Integer.valueOf(0)});
    }

    public final void prepare() {
        Pair t = ak.t(this.gfS.toString(), 0, this.gfU);
        if (t.second != null) {
            x.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s prepare ok", new Object[]{akH()});
            ((WxaPkgWrappingInfo) t.second).name = this.fgp;
            d((WxaPkgWrappingInfo) t.second);
        } else if (a.fhF.equals(t.first)) {
            x.i("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s getDownloadURL", new Object[]{akH()});
            akl akl = new akl();
            akl.bPS = this.appId;
            akl.rkb = this.gfU;
            akl.rNa = 0;
            if (!bi.oW(this.fgp)) {
                akl.rLl = this.fgp;
                akl.rNa = 4;
            }
            akl.rMZ = e.abi().a(this.gfS.toString(), 0, new String[]{"versionMd5"}).field_versionMd5;
            if (k.abE() && d.a.jC(0)) {
                WxaPkgWrappingInfo aG = e.aG(this.gfS.toString(), 1);
                if (aG != null) {
                    akl.rNb = aG.fii;
                }
            }
            new b(akl).KM().h(new 1(this, akl));
        } else {
            x.e("MicroMsg.AppBrand.LaunchPkgPrepareJobReleaseCode", "%s, local check failed ret=%s", new Object[]{akH(), t.first});
            d(null);
        }
    }
}
