package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.mm.ab.a$a;
import com.tencent.mm.ab.w;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ak;
import com.tencent.mm.plugin.appbrand.appcache.al;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appcache.c;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.protocal.c.ain;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;

final class q extends o {
    final String appId;
    final int bPh;
    final String fgp;

    q(String str, String str2, int i) {
        super(new r(str, str2));
        this.appId = str;
        this.fgp = str2;
        this.bPh = i;
    }

    public final String akH() {
        return String.format(Locale.US, "appId %s, module %s, pkgType %d", new Object[]{this.appId, this.fgp, Integer.valueOf(this.bPh)});
    }

    public final void prepare() {
        int i = -1;
        Pair t = ak.t(this.gfS.toString(), this.bPh, 1);
        if (t.second != null) {
            ((WxaPkgWrappingInfo) t.second).name = this.fgp;
            d((WxaPkgWrappingInfo) t.second);
            return;
        }
        String ai;
        if (bi.oW(this.fgp)) {
            ai = e.abi().ai(this.appId, this.bPh);
        } else {
            al a = e.abi().a(this.gfS.toString(), this.bPh, new String[]{"versionMd5"});
            if (a == null) {
                x.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s, NULL record", new Object[]{akH()});
                ai = null;
            } else {
                a$a a2 = w.a(new c(this.appId, this.fgp, a.field_versionMd5, this.bPh));
                if (a2 != null && a2.errType == 0 && a2.errCode == 0) {
                    x.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "resp.errcode %d, resp.errmsg %s, resp.url %s", new Object[]{Integer.valueOf(((ain) a2.dIv).rLp), ((ain) a2.dIv).rLo, ((ain) a2.dIv).dPW});
                    if (bi.oW(((ain) a2.dIv).dPW)) {
                        if (((ain) a2.dIv).rLp == -1001) {
                            AppBrand404PageUI.show(j.app_brand_qrcode_result_uin_invalid);
                            a.G(this.appId, 4, this.bPh + 1);
                        } else {
                            x.um(com.tencent.mm.plugin.appbrand.r.c.getMMString(j.app_brand_preparing_comm_err_code, new Object[]{Integer.valueOf(5), Integer.valueOf(((ain) a2.dIv).rLp)}));
                        }
                    }
                    ai = ((ain) a2.dIv).dPW;
                } else {
                    String str = "MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode";
                    String str2 = "%s, cgi failed, %d %d";
                    Object[] objArr = new Object[3];
                    objArr[0] = akH();
                    objArr[1] = Integer.valueOf(a2 == null ? -1 : a2.errType);
                    objArr[2] = Integer.valueOf(a2 == null ? -1 : a2.errCode);
                    x.e(str, str2, objArr);
                    int i2 = j.app_brand_prepare_get_cdn_url_err;
                    Object[] objArr2 = new Object[2];
                    objArr2[0] = Integer.valueOf(a2 == null ? -1 : a2.errType);
                    if (a2 != null) {
                        i = a2.errCode;
                    }
                    objArr2[1] = Integer.valueOf(i);
                    x.um(x.getMMString(i2, objArr2));
                    ai = null;
                }
            }
        }
        1 1 = new 1(this, this.bPh);
        x.i("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s before download, url(%s)", new Object[]{akH(), ai});
        if (bi.oW(ai)) {
            d(null);
        } else if (!aq.b(this.gfS.toString(), this.bPh, 1, ai, 1)) {
            x.e("MicroMsg.AppBrand.LaunchPkgPrepareJobTestCode", "%s start downloadPkg failed", new Object[]{akH()});
            d(null);
        }
    }
}
