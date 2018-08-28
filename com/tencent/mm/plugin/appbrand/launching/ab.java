package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.d.h;
import com.tencent.mm.plugin.appbrand.appcache.al;
import com.tencent.mm.plugin.appbrand.appcache.k;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.plugin.appbrand.appusage.d;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.launching.r.a;
import com.tencent.mm.plugin.appbrand.launching.r.b;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;

final class ab extends w<Pair<WxaAttributes, Boolean>> {
    private String appId;
    private final int fmv;
    private final String fqx;
    private final int gfw;
    private boolean ggA = false;
    private boolean ggB = false;
    private int ggC = a.gfZ;
    private final int ggz;
    private String username;

    ab(String str, String str2, int i, int i2, int i3, String str3) {
        this.username = str;
        this.appId = str2;
        this.fmv = i;
        this.ggz = i2;
        this.gfw = i3;
        this.fqx = str3;
    }

    /* renamed from: akM */
    public final Pair<WxaAttributes, Boolean> call() {
        int i;
        Object[] objArr;
        Pair<WxaAttributes, Boolean> create;
        WxaAttributes akN = akN();
        if (akN == null) {
            this.ggA = true;
            this.ggC = a.ggg;
        } else {
            this.username = akN.field_username;
            this.appId = akN.field_appId;
            if (c(akN)) {
                q.rZ(this.username);
                this.ggA = true;
                this.ggC = a.ggc;
            } else {
                boolean z;
                String str = this.username;
                com.tencent.mm.plugin.appbrand.appusage.a aVar = new com.tencent.mm.plugin.appbrand.appusage.a();
                aVar.field_username = str;
                if (((d) e.x(d.class)).b(aVar, new String[0])) {
                    z = false;
                } else {
                    x.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "forceUpdateByLastOpenTime, usage record not found with username(%s), forceUpdate=TRUE", new Object[]{str});
                    z = true;
                }
                if (z) {
                    this.ggA = true;
                    this.ggB = true;
                    this.ggC = a.ggb;
                } else if (com.tencent.mm.plugin.appbrand.appcache.d.a.jC(this.fmv)) {
                    if (this.ggz <= 0 || this.ggz <= akN.ael().cbu) {
                        z = k.abG() && akN.ael() != null && akN.ael().fsm;
                        String rVar = z ? new r(akN.field_appId, "__APP__").toString() : akN.field_appId;
                        i = akN.ael().cbu;
                        if (this.fmv == 0) {
                            al a = e.abi().a(rVar, i, 0, "version", "pkgPath", "versionMd5");
                            if (a == null) {
                                x.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "forceUpdateAttrsByPkgState, get null manifest record by key(%s), version(%d), forceSync", new Object[]{rVar, Integer.valueOf(i)});
                                z = true;
                            } else {
                                z = !bi.oW(a.field_pkgPath) && a.field_versionMd5.equals(g.cu(a.field_pkgPath));
                                if (!bi.oW(this.fqx)) {
                                    boolean z2 = z && e.bA(a.field_pkgPath, this.fqx);
                                    x.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "forceUpdateAttrsByPkgState, latestPkgExists[%B], enterPath[%s], pathAccessible[%B]", new Object[]{Boolean.valueOf(z), this.fqx, Boolean.valueOf(z2)});
                                    if (!z2) {
                                        this.ggC = a.gge;
                                    }
                                    z = !z2;
                                } else if (z) {
                                    x.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "local available pkg version[%d] LATEST, no need force update", new Object[]{Integer.valueOf(a.field_version)});
                                } else {
                                    WxaPkgWrappingInfo aG = e.aG(this.appId, 1);
                                    if (aG == null) {
                                        x.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "forceUpdateAttrsByPkgState, no local available pkg, force update");
                                        z = true;
                                    } else if (this.ggz <= 0 || this.ggz <= aG.fii) {
                                        x.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "forceUpdateAttrsByPkgState, local available pkg version[%d], no need force update", new Object[]{Integer.valueOf(aG.fii)});
                                    } else {
                                        x.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "forceUpdateAttrsByPkgState, local available pkg version[%d], preferred version[%d], force update", new Object[]{Integer.valueOf(aG.fii), Integer.valueOf(this.ggz)});
                                        z = true;
                                    }
                                }
                            }
                            if (z) {
                                com.tencent.mm.plugin.appbrand.appcache.a.d.g gVar;
                                h hVar = (h) e.x(h.class);
                                String str2 = akN.field_username;
                                if (!bi.oW(str2)) {
                                    com.tencent.mm.plugin.appbrand.appcache.a.d.g gVar2 = new com.tencent.mm.plugin.appbrand.appcache.a.d.g();
                                    gVar2.field_username = str2;
                                    if (hVar.b(gVar2, new String[0])) {
                                        gVar = gVar2;
                                        if (gVar != null && gVar.field_appVersion > akN.ael().cbu) {
                                            this.ggA = true;
                                            this.ggC = a.ggf;
                                            i = com.tencent.mm.plugin.appbrand.appcache.a.c.a.fiY;
                                            com.tencent.mm.plugin.appbrand.appcache.a.c.a.n((long) gVar.field_reportId, 154);
                                        }
                                    }
                                }
                                gVar = null;
                                this.ggA = true;
                                this.ggC = a.ggf;
                                i = com.tencent.mm.plugin.appbrand.appcache.a.c.a.fiY;
                                com.tencent.mm.plugin.appbrand.appcache.a.c.a.n((long) gVar.field_reportId, 154);
                            } else {
                                this.ggA = true;
                                if (this.ggC == a.gfZ) {
                                    this.ggC = a.gga;
                                }
                            }
                        }
                        z = false;
                        if (z) {
                            com.tencent.mm.plugin.appbrand.appcache.a.d.g gVar3;
                            h hVar2 = (h) e.x(h.class);
                            String str22 = akN.field_username;
                            if (!bi.oW(str22)) {
                                com.tencent.mm.plugin.appbrand.appcache.a.d.g gVar22 = new com.tencent.mm.plugin.appbrand.appcache.a.d.g();
                                gVar22.field_username = str22;
                                if (hVar2.b(gVar22, new String[0])) {
                                    gVar3 = gVar22;
                                    if (gVar3 != null && gVar3.field_appVersion > akN.ael().cbu) {
                                        this.ggA = true;
                                        this.ggC = a.ggf;
                                        i = com.tencent.mm.plugin.appbrand.appcache.a.c.a.fiY;
                                        com.tencent.mm.plugin.appbrand.appcache.a.c.a.n((long) gVar3.field_reportId, 154);
                                    }
                                }
                            }
                            gVar3 = null;
                            this.ggA = true;
                            this.ggC = a.ggf;
                            i = com.tencent.mm.plugin.appbrand.appcache.a.c.a.fiY;
                            com.tencent.mm.plugin.appbrand.appcache.a.c.a.n((long) gVar3.field_reportId, 154);
                        } else {
                            this.ggA = true;
                            if (this.ggC == a.gfZ) {
                                this.ggC = a.gga;
                            }
                        }
                    } else {
                        x.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "call, preferVersion[%d], attrs.appVersion[%d], forceSync", new Object[]{Integer.valueOf(this.ggz), Integer.valueOf(akN.ael().cbu)});
                        this.ggA = true;
                        this.ggC = a.ggd;
                    }
                }
            }
        }
        x.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "getAttrs, awaitCgi=%B, fallbackIfCgiFailed=%B, reason=%d", new Object[]{Boolean.valueOf(this.ggA), Boolean.valueOf(this.ggB), Integer.valueOf(this.ggC - 1)});
        long VF = bi.VF();
        Pair R = bi.oW(this.username) ? com.tencent.mm.plugin.appbrand.config.r.R(this.appId, this.ggA) : com.tencent.mm.plugin.appbrand.config.r.S(this.username, this.ggA);
        if (R.first == null) {
            i = j.app_brand_preparing_attr_sync_timeout;
            objArr = new Object[1];
            objArr[0] = R.second == null ? "" : String.format(Locale.US, "(%d,%d)", new Object[]{Integer.valueOf(((com.tencent.mm.ab.a.a) R.second).errType), Integer.valueOf(((com.tencent.mm.ab.a.a) R.second).errCode)});
            x.um(x.getMMString(i, objArr));
            com.tencent.mm.plugin.appbrand.report.a.G("", 7, this.fmv + 1);
        } else {
            long VF2 = bi.VF() - VF;
            if (R.second != null) {
                r.a(b.ggi, this.appId, ((WxaAttributes) R.first).ael().cbu, this.fmv, this.gfw, VF2);
            }
        }
        if (!this.ggA || R.second == null || ((com.tencent.mm.ab.a.a) R.second).errType == 0) {
            create = Pair.create(R.first, Boolean.valueOf(this.ggA));
        } else if (this.ggB) {
            x.i("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "getInternal, await but cgi failed, return result from db");
            create = Pair.create(akN(), Boolean.valueOf(false));
        } else {
            i = j.app_brand_preparing_attr_sync_timeout;
            objArr = new Object[1];
            objArr[0] = String.format(Locale.US, "(%d,%d)", new Object[]{Integer.valueOf(((com.tencent.mm.ab.a.a) R.second).errType), Integer.valueOf(((com.tencent.mm.ab.a.a) R.second).errCode)});
            x.um(x.getMMString(i, objArr));
            create = Pair.create(null, Boolean.valueOf(true));
        }
        if (!c((WxaAttributes) create.first)) {
            return create;
        }
        x.lc(j.app_brand_launching_get_attrs_invalid_fields);
        return Pair.create(null, Boolean.valueOf(false));
    }

    private WxaAttributes akN() {
        if (bi.oW(this.username)) {
            return e.aba().f(this.appId, new String[0]);
        }
        return e.aba().e(this.username, new String[0]);
    }

    private static boolean c(WxaAttributes wxaAttributes) {
        if (bi.oW(wxaAttributes.field_appId)) {
            x.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "invalid appID in contact(%s)", new Object[]{wxaAttributes.field_username});
            return true;
        } else if (wxaAttributes.ael().fsi != 0 || !bi.oW(wxaAttributes.ael().fsj)) {
            return false;
        } else {
            x.e("MicroMsg.AppBrand.PrepareStepGetWxaAttrs", "invalid versionMD5 in contact(%s)", new Object[]{wxaAttributes.field_username});
            return true;
        }
    }

    final String getTag() {
        return "MicroMsg.AppBrand.PrepareStepGetWxaAttrs";
    }
}
