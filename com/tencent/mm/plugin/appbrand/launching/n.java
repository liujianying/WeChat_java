package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.aq$b;
import com.tencent.mm.plugin.appbrand.appcache.aq.a;
import com.tencent.mm.plugin.appbrand.appcache.base.WxaPkgLoadProgress;
import com.tencent.mm.plugin.appbrand.appcache.base.b$a$a;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.pluginsdk.g.a.c.k;
import com.tencent.mm.sdk.platformtools.x;

abstract class n implements a {
    final int fmv;

    abstract String akG();

    abstract void c(WxaPkgWrappingInfo wxaPkgWrappingInfo);

    public final /* synthetic */ void a(k kVar) {
        x.i("MicroMsg.AppBrand.LaunchCommonDownloadCallback", "hy: onPkgUpdateProgress: %s", new Object[]{((WxaPkgLoadProgress) kVar).toString()});
        c(r6);
    }

    public final /* synthetic */ void a(String str, b$a$a b_a_a, Object obj) {
        aq$b aq_b = (aq$b) obj;
        x.i("MicroMsg.AppBrand.LaunchCommonDownloadCallback", "[%s] onPkgUpdateResult, appId = %s, return = %s", new Object[]{akG(), str, b_a_a.name()});
        if (b$a$a.OK.equals(b_a_a)) {
            WxaPkgWrappingInfo qX = WxaPkgWrappingInfo.qX(aq_b.filePath);
            if (qX == null) {
                x.e("MicroMsg.AppBrand.LaunchCommonDownloadCallback", "[%s] onPkgUpdateResult, ret=OK but obtain null appPkgInfo");
            } else {
                qX.fii = aq_b.version;
                qX.fij = c.aow();
                qX.fih = aq_b.fig;
            }
            c(qX);
            return;
        }
        if (b$a$a.SEVER_FILE_NOT_FOUND.equals(b_a_a)) {
            x.lc(j.app_brand_preparing_server_file_not_found);
            com.tencent.mm.plugin.appbrand.report.a.G(str, 23, this.fmv + 1);
        } else {
            x.um(c.getMMString(j.app_brand_preparing_comm_err_code, new Object[]{Integer.valueOf(2), Integer.valueOf(b_a_a.code)}));
        }
        c(null);
    }

    n(int i) {
        this.fmv = i;
    }

    protected void c(WxaPkgLoadProgress wxaPkgLoadProgress) {
    }
}
