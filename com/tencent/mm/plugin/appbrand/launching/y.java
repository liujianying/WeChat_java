package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.mm.ab.w;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.b.f;
import com.tencent.mm.plugin.appbrand.appcache.ak;
import com.tencent.mm.plugin.appbrand.appcache.al;
import com.tencent.mm.plugin.appbrand.appcache.b;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.d;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.akm;
import com.tencent.mm.protocal.c.cgw;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;
import java.util.concurrent.Callable;
import junit.framework.Assert;

abstract class y extends w<WxaPkgWrappingInfo> implements i {
    final String appId;
    private final int fii;
    final int fmv;
    final d frP;
    String fwZ = null;
    final int gfw;
    private WxaPkgWrappingInfo ggo;

    y(String str, int i, int i2, int i3, d dVar) {
        this.appId = str;
        this.fmv = i;
        this.fii = i2;
        this.gfw = i3;
        this.frP = dVar;
    }

    public void akC() {
    }

    public void akE() {
    }

    private WxaPkgWrappingInfo afp() {
        Pair t = ak.t(this.appId, this.fmv, this.fii);
        if (t.second != null) {
            x.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, using existing pkg with appId(%s) versionType(%d) pkgVersion(%d)", new Object[]{this.appId, Integer.valueOf(this.fmv), Integer.valueOf(this.fii)});
            return (WxaPkgWrappingInfo) t.second;
        }
        Pair t2;
        if (a.jC(this.fmv)) {
            com.tencent.mm.plugin.appbrand.appcache.x q = ((com.tencent.mm.plugin.appbrand.appcache.y) e.x(com.tencent.mm.plugin.appbrand.appcache.y.class)).q(this.appId, 1, this.fii);
            if (q != null) {
                PLong pLong = new PLong();
                x.i("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "decrypt ret %b, with appId(%s) version(%d)", new Object[]{Boolean.valueOf(f.a(q, f.a.fiM, pLong)), this.appId, Integer.valueOf(this.fii)});
                if (f.a(q, f.a.fiM, pLong)) {
                    t2 = ak.t(this.appId, this.fmv, this.fii);
                    int i;
                    if (t2.second != null) {
                        i = com.tencent.mm.plugin.appbrand.appcache.a.c.a.fiY;
                        com.tencent.mm.plugin.appbrand.appcache.a.c.a.n(pLong.value, 180);
                        return (WxaPkgWrappingInfo) t2.second;
                    }
                    i = com.tencent.mm.plugin.appbrand.appcache.a.c.a.fiY;
                    com.tencent.mm.plugin.appbrand.appcache.a.c.a.n(pLong.value, 181);
                    if (ak.a.fhC.equals(t2.first)) {
                        x.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, manifest NULL, appId(%s) type(%d) version(%d)", new Object[]{this.appId, Integer.valueOf(this.fmv), Integer.valueOf(this.fii)});
                        e.abi().a(this.appId, this.frP);
                        if (e.abi().a(this.appId, this.fii, this.fmv, new String[0]) == null) {
                            x.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, insert manifest fail again!!! appId(%s) type(%d) version(%d)", new Object[]{this.appId, Integer.valueOf(this.fmv), Integer.valueOf(this.fii)});
                        } else {
                            t2 = Pair.create(ak.a.fhF, null);
                        }
                    }
                    if (ak.a.fhF.equals(t2.first)) {
                        if (this.fmv == 0) {
                            this.ggo = e.aG(this.appId, 1);
                            WxaPkgWrappingInfo c;
                            try {
                                al a = e.abi().a(this.appId, 0, new String[]{"version", "versionMd5", "versionState"});
                                if (a == null) {
                                    throw new i.a.a().m(c.getMMString(j.app_brand_preparing_pkg_manifest_null, new Object[]{com.tencent.mm.plugin.appbrand.appcache.a.jB(this.fmv)}), new Object[0]).n("get NULL record with md5", new Object[0]).akF();
                                }
                                long VF = bi.VF();
                                int i2 = a.field_version;
                                int i3 = this.ggo == null ? 0 : this.ggo.fii;
                                com.tencent.mm.ab.a.a b = w.b(new b(this.appId, a.field_version, a.field_versionMd5, 0, i3).diG);
                                if (b != null && b.errType == 0 && b.errCode == 0) {
                                    r.a(r.b.ggk, this.appId, i2, this.fmv, this.gfw, bi.VF() - VF);
                                    if (bi.oW(((akm) b.dIv).url)) {
                                        throw new i.a.a().n("CgiGetDownloadURL return EMPTY url, ret = %d", new Object[]{Integer.valueOf(((akm) b.dIv).ret)}).akF();
                                    }
                                    cgw cgw = new cgw();
                                    String str = ((akm) b.dIv).url;
                                    this.fwZ = str;
                                    cgw.sBd = str;
                                    cgw.riv = a.field_version;
                                    cgw.sBb = a.field_versionState;
                                    cgw.sBc = a.field_versionMd5;
                                    e.abi().a(this.appId, cgw, 0);
                                    if (this.frP.fsk > 0) {
                                        long VF2 = bi.VF();
                                        q.a bL = q.bL((long) this.frP.fsk);
                                        VF2 = bi.VF() - VF2;
                                        x.d("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "trimOff %d, cost %d, result %s", new Object[]{Integer.valueOf(this.frP.fsk), Long.valueOf(VF2), bL.name()});
                                    }
                                    c = c(new a(this, i3, i2, (akm) b.dIv, (byte) 0));
                                    if (c != null) {
                                        return c;
                                    }
                                    throw new i.a.a().n("Download Fail", new Object[0]).akF();
                                }
                                String mMString;
                                if (b == null || b.errCode != -1001) {
                                    i = j.app_brand_prepare_get_cdn_url_err;
                                    Object[] objArr = new Object[2];
                                    objArr[0] = Integer.valueOf(b == null ? -1 : b.errType);
                                    objArr[1] = Integer.valueOf(b == null ? -1 : b.errCode);
                                    mMString = x.getMMString(i, objArr);
                                } else {
                                    mMString = x.getMMString(j.app_brand_preparing_cgi_get_download_url_disaster, new Object[0]);
                                }
                                i.a.a aVar = new i.a.a();
                                String str2 = "fail get download url, resp %s";
                                Object[] objArr2 = new Object[1];
                                objArr2[0] = b == null ? null : String.format(Locale.US, "(%d, %d)", new Object[]{Integer.valueOf(b.errType), Integer.valueOf(b.errCode)});
                                throw aVar.n(str2, objArr2).m(mMString, new Object[0]).akF();
                            } catch (i.a e) {
                                i.a aVar2 = e;
                                x.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "release_pkg APP_BROKEN obtain appId %s, message %s", new Object[]{this.appId, aVar2.getMessage()});
                                if (this.fii <= 0) {
                                    c = e.aG(this.appId, 1);
                                    if (c != null) {
                                        return c;
                                    }
                                }
                                if (!bi.oW(aVar2.gfG)) {
                                    x.um(aVar2.gfG);
                                }
                                return null;
                            }
                        }
                        WxaPkgWrappingInfo c2 = c(new b(this, 0, (byte) 0));
                        if (c2 != null) {
                            return c2;
                        }
                    }
                    a((ak.a) t2.first);
                    return null;
                }
            }
        }
        t2 = t;
        if (ak.a.fhC.equals(t2.first)) {
            x.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, manifest NULL, appId(%s) type(%d) version(%d)", new Object[]{this.appId, Integer.valueOf(this.fmv), Integer.valueOf(this.fii)});
            e.abi().a(this.appId, this.frP);
            if (e.abi().a(this.appId, this.fii, this.fmv, new String[0]) == null) {
                x.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "call, insert manifest fail again!!! appId(%s) type(%d) version(%d)", new Object[]{this.appId, Integer.valueOf(this.fmv), Integer.valueOf(this.fii)});
            } else {
                t2 = Pair.create(ak.a.fhF, null);
            }
        }
        if (ak.a.fhF.equals(t2.first)) {
            if (this.fmv == 0) {
                this.ggo = e.aG(this.appId, 1);
                WxaPkgWrappingInfo c3;
                try {
                    al a2 = e.abi().a(this.appId, 0, new String[]{"version", "versionMd5", "versionState"});
                    if (a2 == null) {
                        throw new i.a.a().m(c.getMMString(j.app_brand_preparing_pkg_manifest_null, new Object[]{com.tencent.mm.plugin.appbrand.appcache.a.jB(this.fmv)}), new Object[0]).n("get NULL record with md5", new Object[0]).akF();
                    }
                    long VF3 = bi.VF();
                    int i22 = a2.field_version;
                    int i32 = this.ggo == null ? 0 : this.ggo.fii;
                    com.tencent.mm.ab.a.a b2 = w.b(new b(this.appId, a2.field_version, a2.field_versionMd5, 0, i32).diG);
                    if (b2 != null && b2.errType == 0 && b2.errCode == 0) {
                        r.a(r.b.ggk, this.appId, i22, this.fmv, this.gfw, bi.VF() - VF3);
                        if (bi.oW(((akm) b2.dIv).url)) {
                            throw new i.a.a().n("CgiGetDownloadURL return EMPTY url, ret = %d", new Object[]{Integer.valueOf(((akm) b2.dIv).ret)}).akF();
                        }
                        cgw cgw2 = new cgw();
                        String str3 = ((akm) b2.dIv).url;
                        this.fwZ = str3;
                        cgw2.sBd = str3;
                        cgw2.riv = a2.field_version;
                        cgw2.sBb = a2.field_versionState;
                        cgw2.sBc = a2.field_versionMd5;
                        e.abi().a(this.appId, cgw2, 0);
                        if (this.frP.fsk > 0) {
                            long VF22 = bi.VF();
                            q.a bL2 = q.bL((long) this.frP.fsk);
                            VF22 = bi.VF() - VF22;
                            x.d("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "trimOff %d, cost %d, result %s", new Object[]{Integer.valueOf(this.frP.fsk), Long.valueOf(VF22), bL2.name()});
                        }
                        c3 = c(new a(this, i32, i22, (akm) b2.dIv, (byte) 0));
                        if (c3 != null) {
                            return c3;
                        }
                        throw new i.a.a().n("Download Fail", new Object[0]).akF();
                    }
                    String mMString2;
                    if (b2 == null || b2.errCode != -1001) {
                        i = j.app_brand_prepare_get_cdn_url_err;
                        Object[] objArr3 = new Object[2];
                        objArr3[0] = Integer.valueOf(b2 == null ? -1 : b2.errType);
                        objArr3[1] = Integer.valueOf(b2 == null ? -1 : b2.errCode);
                        mMString2 = x.getMMString(i, objArr3);
                    } else {
                        mMString2 = x.getMMString(j.app_brand_preparing_cgi_get_download_url_disaster, new Object[0]);
                    }
                    i.a.a aVar3 = new i.a.a();
                    String str22 = "fail get download url, resp %s";
                    Object[] objArr22 = new Object[1];
                    objArr22[0] = b2 == null ? null : String.format(Locale.US, "(%d, %d)", new Object[]{Integer.valueOf(b2.errType), Integer.valueOf(b2.errCode)});
                    throw aVar3.n(str22, objArr22).m(mMString2, new Object[0]).akF();
                } catch (i.a e2) {
                    i.a aVar22 = e2;
                    x.e("MicroMsg.AppBrand.PrepareStepCheckAppPkg", "release_pkg APP_BROKEN obtain appId %s, message %s", new Object[]{this.appId, aVar22.getMessage()});
                    if (this.fii <= 0) {
                        c3 = e.aG(this.appId, 1);
                        if (c3 != null) {
                            return c3;
                        }
                    }
                    if (!bi.oW(aVar22.gfG)) {
                        x.um(aVar22.gfG);
                    }
                    return null;
                }
            }
            WxaPkgWrappingInfo c22 = c(new b(this, 0, (byte) 0));
            if (c22 != null) {
                return c22;
            }
        }
        a((ak.a) t2.first);
        return null;
    }

    private WxaPkgWrappingInfo c(Callable<WxaPkgWrappingInfo> callable) {
        if (callable == this) {
            Assert.assertTrue("Why the hell you pass 'this' to this method", false);
            return null;
        }
        WxaPkgWrappingInfo wxaPkgWrappingInfo;
        akC();
        try {
            wxaPkgWrappingInfo = (WxaPkgWrappingInfo) callable.call();
        } catch (Exception e) {
            wxaPkgWrappingInfo = null;
        }
        akE();
        return wxaPkgWrappingInfo;
    }

    final void a(ak.a aVar) {
        if (ak.a.fhC.equals(aVar)) {
            String mMString;
            if (this.fmv == 1) {
                mMString = c.getMMString(j.app_brand_launching_dev_pkg_expired, new Object[0]);
            } else {
                mMString = c.getMMString(j.app_brand_preparing_pkg_manifest_null, new Object[]{com.tencent.mm.plugin.appbrand.appcache.a.jB(this.fmv)});
            }
            if (this.fmv == 1) {
                com.tencent.mm.plugin.appbrand.task.e.aN(this.appId, this.fmv);
                com.tencent.mm.plugin.appbrand.report.a.G(this.appId, 10, this.fmv + 1);
            }
            x.um(mMString);
        } else if (ak.a.fhE.equals(aVar) || ak.a.fhD.equals(aVar)) {
            x.lc(this.fmv != 0 ? j.app_brand_launching_dev_pkg_expired : j.app_brand_launching_release_pkg_deleted);
            if (this.fmv == 1) {
                com.tencent.mm.plugin.appbrand.report.a.G(this.appId, 10, this.fmv + 1);
            }
            com.tencent.mm.plugin.appbrand.task.e.aN(this.appId, this.fmv);
        } else {
            x.um(c.getMMString(j.app_brand_preparing_comm_err_code, new Object[]{Integer.valueOf(1), Integer.valueOf(aVar.acj())}));
        }
    }

    final String getTag() {
        return "MicroMsg.AppBrand.PrepareStepCheckAppPkg";
    }
}
