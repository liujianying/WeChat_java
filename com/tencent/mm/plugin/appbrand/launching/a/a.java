package com.tencent.mm.plugin.appbrand.launching.a;

import android.util.Pair;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.by.f;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.appcache.u;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.launching.ILaunchWxaAppInfoNotify;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.protocal.c.aqk;
import com.tencent.mm.protocal.c.aql;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.protocal.c.cgg;
import com.tencent.mm.protocal.c.chd;
import com.tencent.mm.protocal.c.chh;
import com.tencent.mm.protocal.c.chx;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;

public final class a extends com.tencent.mm.ab.a<aql> {
    final b diG;
    final String fdE;
    public volatile t ggV;
    public volatile boolean ggm;

    protected final /* synthetic */ void a(int i, int i2, String str, bhp bhp, l lVar) {
        String str2;
        aql aql = (aql) bhp;
        int i3 = lVar == null ? 1 : 0;
        if (aql == null) {
            str2 = "NULL";
        } else {
            if (aql.rSV == null) {
                str2 = "NULL_API_INFO";
            } else {
                str2 = "api_info~ fg:" + (aql.rSV.rsl == null ? "NULL" : Integer.valueOf(aql.rSV.rsl.lR.length));
                if (aql.rSV.rsm != null) {
                    if (aql.rSV.rsm.size() > 0) {
                        str2 = str2 + " | bg:" + ((com.tencent.mm.bk.b) aql.rSV.rsm.get(0)).lR.length;
                    }
                    if (aql.rSV.rsm.size() > 1) {
                        str2 = str2 + " | suspend:" + ((com.tencent.mm.bk.b) aql.rSV.rsm.get(1)).lR.length;
                    }
                }
                str2 = str2 + "~";
            }
            str2 = aql.rSU == null ? str2 + " || NULL_LAUNCH" : str2 + " || launch " + aql.rSU.qZk;
        }
        x.i("MicroMsg.AppBrand.CgiLaunchWxaApp", "onCgiBack, errType %d, errCode %d, errMsg %s, req[appId %s, bg %B, sync %B, libVersion %d], resp[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, getAppId(), Boolean.valueOf(akP()), Boolean.valueOf(this.ggm), Integer.valueOf(akQ().rSP.rUD), str2});
        if (i == 0 && i2 == 0 && aql != null) {
            if (i3 != 0) {
                this.ggV = new t();
                this.ggV.field_appId = getAppId();
                this.ggV.a(aql);
            } else {
                this.ggV = e.abb().a(getAppId(), aql);
            }
            this.ggV.ggm = this.ggm;
            ac.a(akQ().rSP.rUD, aql.rSX);
            if (aql.rSU != null) {
                if (aql.rSU.rSL) {
                    e.abg().a(q.rY(getAppId()), akO(), akP(), aan(), 1, this.fdE);
                }
                if (!this.ggm) {
                    ILaunchWxaAppInfoNotify.gfI.a(getAppId(), akO(), this.fdE, this.ggV);
                }
            }
        } else if (this.ggm) {
            int i4 = j.app_brand_preparing_permission_sync_timeout;
            Object[] objArr = new Object[1];
            objArr[0] = String.format(Locale.US, " (%d,%d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            com.tencent.mm.plugin.appbrand.launching.x.um(com.tencent.mm.plugin.appbrand.launching.x.getMMString(i4, objArr));
        }
    }

    public a(String str, boolean z, cgg cgg, chx chx, chh chh, String str2, int i) {
        this.ggm = false;
        this.fdE = str2;
        aqk aqk = new aqk();
        aqk.jQb = str;
        aqk.rSN = cgg;
        aqk.rKO = z ? 1 : 2;
        aqk.rSQ = chx;
        aqk.rSR = chh;
        chd chd = new chd();
        chd.rUD = i;
        if (i > 0) {
            u abn = e.abn();
            if (abn != null) {
                com.tencent.mm.plugin.appbrand.appcache.t tVar = new com.tencent.mm.plugin.appbrand.appcache.t();
                tVar.field_key = "@LibraryAppId";
                tVar.field_version = i;
                if (abn.b(tVar, new String[]{"key", "version"})) {
                    chd.rca = (int) tVar.field_updateTime;
                    chd.sBh = tVar.field_scene;
                }
            }
        }
        aqk.rSP = chd;
        try {
            if (com.tencent.mm.compatible.e.q.deU.dbw) {
                x.i("MicroMsg.AppBrand.CgiLaunchWxaApp", "DeviceInfo isLimit benchmarkLevel");
                aqk.rST = -2;
            } else {
                aqk.rST = g.AT().getInt("ClientBenchmarkLevel", 0);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrand.CgiLaunchWxaApp", e, "read performanceLevel", new Object[0]);
        }
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIF = 1122;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaattr/launchwxaapp";
        aVar.dIG = aqk;
        aVar.dIH = new aql();
        b KT = aVar.KT();
        this.diG = KT;
        this.diG = KT;
    }

    public a(String str, cgg cgg, String str2, int i) {
        this(str, false, cgg, null, null, str2, i);
    }

    private String getAppId() {
        return ((aqk) this.diG.dID.dIL).jQb;
    }

    private int akO() {
        return ((aqk) this.diG.dID.dIL).rSN.rRb;
    }

    private boolean akP() {
        return ((aqk) this.diG.dID.dIL).rSN.rUB > 0;
    }

    private int aan() {
        return ((aqk) this.diG.dID.dIL).rSN.otY;
    }

    private aqk akQ() {
        return (aqk) this.diG.dID.dIL;
    }

    public final void akR() {
        c.Em().H(new Runnable() {
            public final void run() {
                a.this.ggm = false;
                a.this.KM();
            }
        });
    }

    public final synchronized f<com.tencent.mm.ab.a.a<aql>> KM() {
        f<com.tencent.mm.ab.a.a<aql>> c;
        Pair am = ((com.tencent.mm.plugin.appbrand.appcache.a.d.e) e.x(com.tencent.mm.plugin.appbrand.appcache.a.d.e.class)).am(getAppId(), aan());
        int i;
        if (am.first != null) {
            x.i("MicroMsg.AppBrand.CgiLaunchWxaApp", "before run, get issued data by appId(%s) scene(%d)", new Object[]{getAppId(), Integer.valueOf(aan())});
            i = com.tencent.mm.plugin.appbrand.appcache.a.c.a.fiY;
            com.tencent.mm.plugin.appbrand.appcache.a.c.a.n(((Long) am.second).longValue(), 106);
            c = com.tencent.mm.by.g.c(new 2(this, am));
        } else {
            if (!this.ggm) {
                am = ((com.tencent.mm.plugin.appbrand.appcache.a.d.b) e.x(com.tencent.mm.plugin.appbrand.appcache.a.d.b.class)).w(getAppId(), 2, aan());
                if (((Boolean) am.first).booleanValue()) {
                    i = com.tencent.mm.plugin.appbrand.appcache.a.c.a.fiY;
                    com.tencent.mm.plugin.appbrand.appcache.a.c.a.n((long) ((Integer) am.second).intValue(), 168);
                    x.i("MicroMsg.AppBrand.CgiLaunchWxaApp", "async launch with appid(%s) scene(%d) blocked", new Object[]{getAppId(), Integer.valueOf(aan())});
                    c = com.tencent.mm.by.g.c(new com.tencent.mm.vending.g.c.a<com.tencent.mm.ab.a.a<aql>>() {
                        public final /* synthetic */ Object call() {
                            return com.tencent.mm.ab.a.a.a(3, 99999999, "Async Launch Blocked", null, null, a.this);
                        }
                    });
                }
            }
            c = super.KM();
        }
        return c;
    }
}
