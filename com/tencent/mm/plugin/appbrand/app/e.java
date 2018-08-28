package com.tencent.mm.plugin.appbrand.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.g.a.bs;
import com.tencent.mm.g.a.id;
import com.tencent.mm.g.a.is;
import com.tencent.mm.g.a.ja;
import com.tencent.mm.g.a.jo;
import com.tencent.mm.g.a.k;
import com.tencent.mm.g.a.mo;
import com.tencent.mm.g.a.o;
import com.tencent.mm.g.a.sl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bv;
import com.tencent.mm.network.n;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appcache.ap;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appcache.u;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.appusage.l;
import com.tencent.mm.plugin.appbrand.appusage.p;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.launching.s;
import com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.plugin.appbrand.widget.h;
import com.tencent.mm.plugin.appbrand.widget.i;
import com.tencent.mm.plugin.appbrand.widget.m;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.az;
import com.tencent.xweb.WebView$d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xwalk.core.XWalkEnvironment;

public final class e implements ar {
    private static volatile c feB;
    private static volatile com.tencent.mm.plugin.appbrand.config.c feC;
    private static volatile ap feD;
    private static volatile p feE;
    private static volatile l feF;
    private static volatile com.tencent.mm.plugin.appbrand.config.p feG;
    private static volatile s feH;
    private static volatile h feI;
    private static volatile i feJ;
    private static volatile a feK;
    private static volatile m feL;
    private static volatile com.tencent.mm.y.a.c feM;
    private static volatile com.tencent.mm.plugin.appbrand.p.a feN;
    private static volatile u feO;
    private static volatile com.tencent.mm.plugin.appbrand.game.a.a.c feP;
    private static com.tencent.mm.plugin.appbrand.c.c feQ;
    private static b feR;
    private j.a dEC = new 29(this);
    private final n dOT = new 24(this);
    private az.a feS = new com.tencent.mm.plugin.appbrand.o.a();
    private com.tencent.mm.vending.b.b feT = null;
    private final com.tencent.mm.plugin.auth.a.a feU = new 10(this);
    private final Set<com.tencent.mm.sdk.b.c> feV = new HashSet();
    private final com.tencent.mm.sdk.b.c<ja> feW = new 11(this);
    private final com.tencent.mm.sdk.b.c<sl> feX = new 13(this);
    private final com.tencent.mm.sdk.b.c<jo> feY = new com.tencent.mm.sdk.b.c<jo>() {
        {
            this.sFo = jo.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ab abVar = ((jo) bVar).bTj.bTk;
            if (ab.gr(abVar.field_username)) {
                abVar.setType(0);
                r.se(abVar.field_username);
            }
            return false;
        }
    };
    private final com.tencent.mm.sdk.b.c<mo> feZ = new 15(this);
    private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.l> ffa = new com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.l>() {
        {
            this.sFo = com.tencent.mm.g.a.l.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            com.tencent.mm.g.a.l lVar = (com.tencent.mm.g.a.l) bVar;
            if (!bi.oW(lVar.bGw.bGy)) {
                lVar.bGx.bGz = bi.getInt(e.abf().get(lVar.bGw.bGy + "_unreadCount", "0"), 0);
            }
            return false;
        }
    };
    private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.p> ffb = new 17(this);
    private final com.tencent.mm.sdk.b.c<o> ffc = new 18(this);
    private final com.tencent.mm.sdk.b.c<k> ffd = new 19(this);
    private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.n> ffe = new 20(this);
    private final com.tencent.mm.sdk.b.c<bs> fff = new 21(this);
    private final com.tencent.mm.sdk.b.c<is> ffg = new 22(this);
    private final bv.a ffh = new an();
    private com.tencent.mm.sdk.b.c ffi = new 25(this);
    private com.tencent.mm.sdk.b.c ffj = new 26(this);
    private com.tencent.mm.sdk.b.c ffk = new 27(this);
    private com.tencent.mm.sdk.b.c<id> ffl = new 28(this);
    private final AppBrandGuideUI.a ffm = new AppBrandGuideUI.a();

    static /* synthetic */ void abp() {
        com.tencent.mm.storage.c fJ = com.tencent.mm.model.c.c.Jx().fJ("100249");
        ad.getContext().getSharedPreferences("system_config_prefs", 4).edit().putInt("appbrand_video_player", fJ.isValid() ? bi.getInt((String) fJ.ckq().get("appbrand_player"), -1) : -1).commit();
        x.i("MicroMsg.SubCoreAppBrand", "check appbrand video ab test[%d]", new Object[]{Integer.valueOf(r0)});
    }

    static /* synthetic */ void abq() {
        try {
            com.tencent.xweb.k.ik(ad.getContext());
            com.tencent.mm.storage.c fJ = com.tencent.mm.model.c.c.Jx().fJ("100367");
            x.i("MicroMsg.SubCoreAppBrand", "get abtest of webview core");
            if (fJ.isValid()) {
                x.i("MicroMsg.SubCoreAppBrand", "abtest of webview core is on");
                Map ckq = fJ.ckq();
                if (bi.getInt((String) ckq.get("WebCoreTestFlag"), 0) == 1) {
                    int i = bi.getInt((String) ckq.get("ModuleToolsType"), 2);
                    int i2 = bi.getInt((String) ckq.get("ModuleAppbrandType"), 2);
                    int i3 = bi.getInt((String) ckq.get("ModuleSupportType"), 2);
                    x.i("MicroMsg.SubCoreAppBrand", "moduleToolsType:" + i + ";moduleAppbrandType:" + i2 + ";moduleSupportType" + i3 + ":jsRuntimeType" + bi.getInt((String) ckq.get("JsRuntimeType"), 0));
                    Editor edit = ad.getContext().getSharedPreferences("wcwebview", 4).edit();
                    edit.putString("ABTestWebViewtools", WebView$d.values()[i].toString());
                    edit.putString("ABTestWebViewappbrand", WebView$d.values()[i2].toString());
                    edit.putString("ABTestWebViewsupport", WebView$d.values()[i3].toString());
                    edit.commit();
                    if (i == 1 || i2 == 1 || i3 == 1) {
                        XWalkEnvironment.setGrayValueForTest(1);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    static /* synthetic */ void abr() {
        com.tencent.mm.storage.c fJ = com.tencent.mm.model.c.c.Jx().fJ("100371");
        x.i("MicroMsg.SubCoreAppBrand", "get abtest of XWebLocalDebug");
        if (fJ.isValid()) {
            x.i("MicroMsg.SubCoreAppBrand", "abtest of XWebLocalDebug is on");
            int i = bi.getInt((String) fJ.ckq().get("bEnableLocalDebug"), 0);
            Editor edit = ad.getContext().getSharedPreferences("wcwebview", 4).edit();
            if (i == 1) {
                edit.putBoolean("m_bEnableLocalDebug", true).commit();
            } else {
                edit.putBoolean("m_bEnableLocalDebug", false).commit();
            }
        }
    }

    private HashMap<Integer, d> aaU() {
        HashMap<Integer, d> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("AppKVStorageDBCreate".hashCode()), new 1(this));
        hashMap.put(Integer.valueOf("AppBrandWxaPkgStorageDBCreate".hashCode()), new 12(this));
        hashMap.put(Integer.valueOf("AppBrandCommonConfigStorageCreate".hashCode()), new 23(this));
        hashMap.put(Integer.valueOf("AppBrandLayoutStorageCreate".hashCode()), new d() {
            public final String[] xb() {
                return p.dzV;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandStarAppStorageCreate".hashCode()), new 31(this));
        hashMap.put(Integer.valueOf("WxaAttributesTableCreate".hashCode()), new 32(this));
        hashMap.put(Integer.valueOf("LaunchWxaAppInfoCreate".hashCode()), new 33(this));
        hashMap.put(Integer.valueOf("DynamicMsgCacheDataCreate".hashCode()), new 34(this));
        hashMap.put(Integer.valueOf("LaunchWxaWidgetCacheCreate".hashCode()), new 35(this));
        hashMap.put(Integer.valueOf("WxaWidgetInfoStorageCreate".hashCode()), new 2(this));
        hashMap.put(Integer.valueOf("WxaUpdateableMsgStorageCreate".hashCode()), new 3(this));
        hashMap.put(Integer.valueOf("AppBrandCommonKVBinaryDataStorage".hashCode()), new 4(this));
        hashMap.put(Integer.valueOf("PkgUpdateStatsStorage".hashCode()), new 5(this));
        hashMap.put(Integer.valueOf("MiniGameInfoStorage".hashCode()), new 6(this));
        for (Entry entry : a.fep.entrySet()) {
            final String[] strArr = (String[]) entry.getValue();
            hashMap.put(Integer.valueOf(((a.a) entry.getKey()).hashCode()), new d() {
                public final String[] xb() {
                    return strArr;
                }
            });
        }
        return hashMap;
    }

    public static a aaV() {
        return feK;
    }

    public static e aaW() {
        com.tencent.mm.plugin.appbrand.a.b bVar = (com.tencent.mm.plugin.appbrand.a.b) g.n(com.tencent.mm.plugin.appbrand.a.b.class);
        if (bVar != null) {
            return ((PluginAppBrand) bVar).getCore();
        }
        return null;
    }

    public final a aaX() {
        String str = g.Ei().cachePath + "AppBrandComm.db";
        if (feK != null && str.equals(feK.getPath())) {
            return feK;
        }
        a a = com.tencent.mm.platformtools.u.a(hashCode(), str, aaU(), true);
        feK = a;
        return a;
    }

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        x.d("MicroMsg.SubCoreAppBrand", "onAccountPostReset updated %b", new Object[]{Boolean.valueOf(z)});
        this.feT = ((com.tencent.mm.plugin.auth.a.b) g.n(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(this.feU);
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("app_brand_global_sp", 0);
        if (sharedPreferences != null) {
            Set stringSet = sharedPreferences.getStringSet("uin_set", new HashSet());
            if (stringSet != null) {
                StringBuilder stringBuilder = new StringBuilder();
                g.Eg();
                if (stringSet.add(stringBuilder.append(com.tencent.mm.kernel.a.Df()).toString())) {
                    Editor edit = sharedPreferences.edit();
                    edit.remove("uin_set");
                    edit.commit();
                    edit.putStringSet("uin_set", stringSet);
                    edit.commit();
                }
            }
        }
        for (com.tencent.mm.sdk.b.c cht : this.feV) {
            cht.cht();
        }
        for (String a : an.fhL.keySet()) {
            ((com.tencent.mm.plugin.messenger.foundation.a.o) g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().a(a, this.ffh, true);
        }
        com.tencent.mm.plugin.appbrand.appusage.j.b.adc();
        com.tencent.mm.plugin.appbrand.appusage.o.a.adc();
        ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().b(this.feS);
        aaX();
        feB = new c(feK);
        feC = new com.tencent.mm.plugin.appbrand.config.c(feK);
        feD = new ap(feK);
        feE = new p(feK);
        feF = new l(feK);
        feH = new s(feK);
        feI = new h(feK);
        feJ = new i(feK);
        feL = new m(feK);
        feM = new com.tencent.mm.y.a.c(feK);
        feN = new com.tencent.mm.plugin.appbrand.p.a(feK);
        feO = new u(feK);
        feP = new com.tencent.mm.plugin.appbrand.game.a.a.c(feK);
        aba();
        a.a(feK);
        f.setup();
        q.aei();
        c$a.gsM.prepare();
        ((com.tencent.mm.plugin.fts.a.n) g.n(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon().a(-86016, new com.tencent.mm.plugin.fts.a.a.a() {
            public final boolean execute() {
                com.tencent.mm.plugin.appbrand.f.c cVar = new com.tencent.mm.plugin.appbrand.f.c();
                ((com.tencent.mm.plugin.fts.a.n) g.n(com.tencent.mm.plugin.fts.a.n.class)).registerIndexStorage(cVar);
                cVar.create();
                com.tencent.mm.plugin.appbrand.f.b bVar = new com.tencent.mm.plugin.appbrand.f.b();
                ((com.tencent.mm.plugin.fts.a.n) g.n(com.tencent.mm.plugin.fts.a.n.class)).registerNativeLogic(7, bVar);
                bVar.create();
                ((com.tencent.mm.plugin.fts.a.n) g.n(com.tencent.mm.plugin.fts.a.n.class)).registerFTSUILogic(new com.tencent.mm.plugin.appbrand.f.g());
                ((com.tencent.mm.plugin.fts.a.n) g.n(com.tencent.mm.plugin.fts.a.n.class)).registerFTSUILogic(new com.tencent.mm.plugin.appbrand.f.e());
                return true;
            }

            public final String getName() {
                return "InitFTSWeAppPluginTask";
            }
        });
        ((com.tencent.mm.plugin.fts.a.n) g.n(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon().a(-86016, new com.tencent.mm.plugin.fts.a.a.a() {
            public final boolean execute() {
                com.tencent.mm.plugin.appbrand.game.a.a aVar = new com.tencent.mm.plugin.appbrand.game.a.a();
                ((com.tencent.mm.plugin.fts.a.n) g.n(com.tencent.mm.plugin.fts.a.n.class)).registerIndexStorage(aVar);
                aVar.create();
                com.tencent.mm.plugin.appbrand.game.a.b bVar = new com.tencent.mm.plugin.appbrand.game.a.b();
                ((com.tencent.mm.plugin.fts.a.n) g.n(com.tencent.mm.plugin.fts.a.n.class)).registerNativeLogic(10, bVar);
                bVar.create();
                ((com.tencent.mm.plugin.fts.a.n) g.n(com.tencent.mm.plugin.fts.a.n.class)).registerFTSUILogic(new com.tencent.mm.plugin.appbrand.game.a.f());
                ((com.tencent.mm.plugin.fts.a.n) g.n(com.tencent.mm.plugin.fts.a.n.class)).registerFTSUILogic(new com.tencent.mm.plugin.appbrand.game.a.d());
                return true;
            }

            public final String getName() {
                return "InitFTSMiniGamePluginTask";
            }
        });
        g.Eh().a(this.dOT);
        com.tencent.mm.plugin.appbrand.dynamic.g.initialize();
        com.tencent.mm.model.c.c.Jx().c(this.dEC);
        com.tencent.mm.plugin.appbrand.config.f.init();
        AppBrandGuideUI.a aVar = this.ffm;
        AppBrandGuideUI.a.ano().registerActivityLifecycleCallbacks(aVar);
        AppBrandStickyBannerLogic.b.d(aVar);
        aVar.guw = false;
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        x.d("MicroMsg.SubCoreAppBrand", "onAccountRelease");
        if (this.feT != null) {
            this.feT.dead();
            this.feT = null;
        }
        for (com.tencent.mm.sdk.b.c dead : this.feV) {
            dead.dead();
        }
        f.release();
        for (String b : an.fhL.keySet()) {
            ((com.tencent.mm.plugin.messenger.foundation.a.o) g.n(com.tencent.mm.plugin.messenger.foundation.a.o.class)).getSysCmdMsgExtension().b(b, this.ffh, true);
        }
        com.tencent.mm.plugin.appbrand.appusage.j.b.unregister();
        com.tencent.mm.plugin.appbrand.appusage.o.a.unregister();
        ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().c(this.feS);
        aq.shutdown();
        feB = null;
        feG = null;
        feC = null;
        feD = null;
        feE = null;
        feF = null;
        feH = null;
        feI = null;
        feJ = null;
        feL = null;
        feM = null;
        feN = null;
        feO = null;
        feP = null;
        a.aaP();
        if (feR != null) {
            b bVar = feR;
            bVar.fnS.clear();
            bVar.fnT.clear();
            feR = null;
        }
        feQ = null;
        if (feK != null) {
            feK.iQ(hashCode());
            feK = null;
        }
        com.tencent.mm.plugin.appbrand.appusage.c.release();
        q.release();
        com.tencent.mm.plugin.appbrand.appcache.a.b.i iVar = com.tencent.mm.plugin.appbrand.appcache.a.b.i.fiQ;
        if (iVar.fiS != null) {
            iVar.fiS.cBH();
        }
        iVar.fiR = false;
        com.tencent.mm.plugin.appbrand.m.c cVar = c$a.gsM;
        x.d("MicroMsg.WxaFTSSearchCore", "reset");
        com.tencent.mm.sdk.b.a.sFg.c(cVar.gsI);
        com.tencent.mm.sdk.b.a.sFg.c(cVar.gsJ);
        cVar.gsK.dead();
        com.tencent.mm.plugin.appbrand.r.c.aox();
        ((com.tencent.mm.plugin.fts.a.n) g.n(com.tencent.mm.plugin.fts.a.n.class)).unregisterIndexStorage(512);
        ((com.tencent.mm.plugin.fts.a.n) g.n(com.tencent.mm.plugin.fts.a.n.class)).unregisterNativeLogic(7);
        ((com.tencent.mm.plugin.fts.a.n) g.n(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(144);
        ((com.tencent.mm.plugin.fts.a.n) g.n(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(4224);
        ((com.tencent.mm.plugin.fts.a.n) g.n(com.tencent.mm.plugin.fts.a.n.class)).unregisterIndexStorage(8);
        ((com.tencent.mm.plugin.fts.a.n) g.n(com.tencent.mm.plugin.fts.a.n.class)).unregisterNativeLogic(10);
        ((com.tencent.mm.plugin.fts.a.n) g.n(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(com.tencent.mm.plugin.appbrand.jsapi.a.f.CTRL_INDEX);
        ((com.tencent.mm.plugin.fts.a.n) g.n(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(4240);
        g.Eh().b(this.dOT);
        com.tencent.mm.plugin.appbrand.dynamic.g.release();
        com.tencent.mm.model.c.c.Jx().d(this.dEC);
        com.tencent.mm.plugin.appbrand.config.f.release();
        AppBrandGuideUI.a aVar = this.ffm;
        AppBrandGuideUI.a.ano().unregisterActivityLifecycleCallbacks(aVar);
        AppBrandStickyBannerLogic.b.c(aVar);
        aVar.guw = false;
    }

    public e() {
        this.feV.add(this.ffd);
        this.feV.add(new com.tencent.mm.plugin.appbrand.launching.a());
        this.feV.add(this.ffe);
        this.feV.add(this.feY);
        this.feV.add(this.feZ);
        this.feV.add(this.feX);
        this.feV.add(new com.tencent.mm.plugin.appbrand.config.e());
        this.feV.add(this.feW);
        this.feV.add(com.tencent.mm.plugin.appbrand.appusage.b.fkZ);
        this.feV.add(this.ffa);
        this.feV.add(this.ffb);
        this.feV.add(this.ffc);
        this.feV.add(this.ffi);
        this.feV.add(this.fff);
        this.feV.add(this.ffg);
        this.feV.add(this.ffj);
        this.feV.add(this.ffk);
        this.feV.add(this.ffl);
    }

    public static AppBrandGuideUI.a aaY() {
        return aaW() == null ? null : aaW().ffm;
    }

    public static c aaZ() {
        return feB;
    }

    public static com.tencent.mm.plugin.appbrand.config.p aba() {
        synchronized (e.class) {
            if (!((feG != null && feG.aeh()) || feK == null || feK.cjr())) {
                feG = new com.tencent.mm.plugin.appbrand.config.p(feK);
            }
        }
        return feG;
    }

    public static s abb() {
        return feH;
    }

    public static i abc() {
        return feJ;
    }

    public static m abd() {
        return feL;
    }

    public static com.tencent.mm.y.a.c abe() {
        return feM;
    }

    public static com.tencent.mm.plugin.appbrand.config.c abf() {
        if (!(feC != null || feK == null || feK.cjr())) {
            feC = new com.tencent.mm.plugin.appbrand.config.c(feK);
        }
        return feC;
    }

    public static p abg() {
        return feE;
    }

    public static l abh() {
        return feF;
    }

    public static ap abi() {
        return feD;
    }

    public static h abj() {
        return feI;
    }

    public static com.tencent.mm.plugin.appbrand.c.c abk() {
        if (feQ == null) {
            feQ = new com.tencent.mm.plugin.appbrand.c.c();
        }
        return feQ;
    }

    public static b abl() {
        if (feR == null) {
            feR = new b();
        }
        return feR;
    }

    public static com.tencent.mm.plugin.appbrand.p.a abm() {
        return feN;
    }

    public static u abn() {
        return feO;
    }

    public static com.tencent.mm.plugin.appbrand.game.a.a.c abo() {
        return feP;
    }

    public static <T> T x(Class<T> cls) {
        return a.x(cls);
    }
}
