package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.mm.protocal.c.ape;
import com.tencent.mm.protocal.c.apf;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public final class b {
    private static final LinkedList<Runnable> gpS = new LinkedList();
    private static final a gpT = new a();
    private static boolean gpU = false;
    private final b gpQ;
    private final String gpR;
    private final String mAppId;

    private static final class a {
        final HashMap<String, HashSet<String>> gqc;

        private a() {
            this.gqc = new HashMap();
        }

        /* synthetic */ a(byte b) {
            this();
        }

        final boolean bJ(String str, String str2) {
            if (bi.oW(str) || bi.oW(str2)) {
                return false;
            }
            boolean z;
            synchronized (this) {
                HashSet hashSet = (HashSet) this.gqc.get(str);
                if (hashSet == null || !hashSet.contains(str2)) {
                    z = false;
                } else {
                    z = true;
                }
            }
            return z;
        }

        final void put(String str, String str2) {
            if (!bi.oW(str) && !bi.oW(str2)) {
                synchronized (this) {
                    HashSet hashSet = (HashSet) this.gqc.get(str);
                    if (hashSet == null) {
                        hashSet = new HashSet();
                        this.gqc.put(str, hashSet);
                    }
                    hashSet.add(str2);
                }
            }
        }

        final void F(String str, String str2) {
            if (!bi.oW(str) && !bi.oW(str2)) {
                synchronized (this) {
                    HashSet hashSet = (HashSet) this.gqc.get(str);
                    if (hashSet != null) {
                        hashSet.remove(str2);
                    }
                }
            }
        }
    }

    private static final class c implements b {
        private final b gqd;

        private c(b bVar) {
            this.gqd = bVar;
        }

        public final void aml() {
            if (this.gqd != null) {
                this.gqd.aml();
            }
            amn();
        }

        public final void amm() {
            if (this.gqd != null) {
                this.gqd.amm();
            }
            amn();
        }

        public final void onCancel() {
            if (this.gqd != null) {
                this.gqd.onCancel();
            }
            amn();
        }

        private void amn() {
            com.tencent.mm.plugin.appbrand.r.c.Em().H(new 1(this));
        }
    }

    static /* synthetic */ void a(b bVar, apf apf) {
        x.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, appId %s, api %s, checkAuth Response.errcode %d", new Object[]{bVar.mAppId, bVar.gpR, Integer.valueOf(apf.rRd.bMH)});
        if (apf.rRd.bMH == 0) {
            gpT.put(bVar.mAppId, bVar.gpR);
            bVar.gpQ.aml();
        } else if (apf.rRd.bMH != -12000) {
            bVar.gpQ.amm();
        } else {
            ah.A(new 3(bVar, com.tencent.mm.plugin.appbrand.a.pY(bVar.mAppId), apf.rjT, apf.rRp));
        }
    }

    static /* synthetic */ void b(String str, String str2, b bVar) {
        if (gpT.bJ(str, str2)) {
            x.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, before cgi, appId %s, api %s, found in AUTH_CACHE, return ok", new Object[]{str, str2});
            bVar.aml();
            return;
        }
        x.i("MicroMsg.AppBrandJsApiUserAuth", "requestUSerAuth, before cgi, appId %s, api %s", new Object[]{str, str2});
        b bVar2 = new b(bVar, str, str2);
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIF = 1116;
        aVar.uri = "/cgi-bin/mmbiz-bin/js-userauth";
        ape ape = new ape();
        ape.jQb = bVar2.mAppId;
        ape.rRo = bVar2.gpR;
        aVar.dIG = ape;
        aVar.dIH = new apf();
        com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.KT(), new 2(bVar2));
    }

    private b(b bVar, String str, String str2) {
        this.gpQ = bVar;
        this.mAppId = str;
        this.gpR = str2;
    }

    public static boolean bI(String str, String str2) {
        return gpT.bJ(str, str2);
    }

    public static void a(final String str, final String str2, final b bVar) {
        if (!bi.oW(str) && !bi.oW(str2)) {
            com.tencent.mm.plugin.appbrand.r.c.Em().H(new 5(new Runnable() {
                public final void run() {
                    b.b(str, str2, new c(bVar));
                }
            }, str, str2));
        }
    }

    public static void vm(String str) {
        a aVar = gpT;
        if (!bi.oW(str)) {
            synchronized (aVar) {
                aVar.gqc.remove(str);
            }
        }
    }
}
