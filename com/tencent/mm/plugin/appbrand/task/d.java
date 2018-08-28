package com.tencent.mm.plugin.appbrand.task;

import android.content.MutableContextWrapper;
import android.os.Looper;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.mm.plugin.appbrand.g.e;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public final class d {
    private static boolean gte = false;
    private static boolean gtf = false;
    private static HashSet<a> gtg = new HashSet();
    private static List<p> gth = new LinkedList();
    private static List<l> gti = new LinkedList();
    private static l gtj;
    private static String gtk = null;
    private static String gtl = null;
    private static c gtm = new 2();
    private static boolean gtn = false;
    private static boolean gto = false;

    public interface a {
        void onReady();
    }

    static /* synthetic */ void vg() {
        com.tencent.mm.ipcinvoker.wx_extension.a.a aVar = b.dnp;
        com.tencent.mm.storage.c fJ = com.tencent.mm.ipcinvoker.wx_extension.a.a.fJ("100308");
        if (fJ == null) {
            x.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "initPreloadABTest item is null");
            return;
        }
        boolean z = fJ.isValid() && "1".equals(fJ.ckq().get("closeClientPreload"));
        gtn = z;
        z = fJ.isValid() && "1".equals(fJ.ckq().get("openDevelopControlPreload"));
        gto = z;
        x.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "initPreloadABTest close:%b, openDevelopCrt:%b", new Object[]{Boolean.valueOf(gtn), Boolean.valueOf(gto)});
    }

    private static synchronized void reset() {
        synchronized (d.class) {
            gte = false;
            gtf = false;
            gtg.clear();
            gth.clear();
            gti.clear();
            gtj = null;
            gtk = null;
            gtl = null;
        }
    }

    public static synchronized void vv(String str) {
        synchronized (d.class) {
            gtk = str;
            gtl = str;
        }
    }

    public static synchronized void a(a aVar, boolean z) {
        synchronized (d.class) {
            if (z) {
                reset();
            }
            if (gte) {
                if (aVar != null) {
                    gtg.add(aVar);
                }
            } else if (!gtf) {
                gte = true;
                if (aVar != null) {
                    gtg.add(aVar);
                }
                x.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "TRACE_ORDER:AppBrandProcessPreloader.java");
                com.tencent.mm.plugin.appbrand.r.c.Em().H(new Runnable() {
                    public final void run() {
                        x.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "preInit start");
                        new com.tencent.mm.plugin.appbrand.k.l().init();
                        d.vg();
                        try {
                            WxaCommLibRuntimeReader.kS();
                            if (WebView.hasInited()) {
                                d.amZ();
                                x.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "webview already init done");
                                return;
                            }
                            WebView.initWebviewCore(ad.getContext(), MMWebView.uHn, "appbrand", new 1(this));
                            x.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "misc preload done");
                        } catch (Throwable th) {
                            x.e("MicroMsg.AppBrandProcessPreloader[applaunch]", "skip preload runtime, load CommLib get exception %s", new Object[]{th});
                            d.reset();
                        }
                    }
                });
            } else if (aVar != null) {
                aVar.onReady();
            }
        }
    }

    private static synchronized void amV() {
        synchronized (d.class) {
            if (gti.size() <= 0) {
                l lVar = new l();
                lVar.fdT = true;
                x.d("MicroMsg.AppBrandService", "preInjectConfig");
                JSONObject jSONObject = new JSONObject();
                l.a(jSONObject, "preload", Boolean.valueOf(true));
                lVar.g(jSONObject);
                lVar.fdQ.evaluateJavascript(String.format("var __wxConfig = %s;", new Object[]{jSONObject.toString()}), null);
                lVar.aaH();
                if (lVar.fdQ.y(e.class) != null) {
                    ((e) lVar.fdQ.y(e.class)).setJsRuntimeTitle("https://servicewechat.com/preload/js-engine");
                }
                gti.add(lVar);
                gtj = lVar;
            }
        }
    }

    private static synchronized void amW() {
        synchronized (d.class) {
            if (gth.size() <= 0) {
                p pVar = new p();
                pVar.fdT = true;
                pVar.gns = new t(new MutableContextWrapper(ad.getContext()));
                pVar.gns.setIsPreload(true);
                pVar.alN();
                pVar.gns.init();
                gth.add(pVar);
            }
        }
    }

    public static synchronized l vw(String str) {
        l lVar;
        synchronized (d.class) {
            if (bi.oW(str) || !str.equals(gtl)) {
                gtl = str;
                if (gti.size() <= 0) {
                    lVar = null;
                } else {
                    lVar = (l) gti.get(0);
                    if (lVar == null) {
                        lVar = null;
                    } else {
                        gti.remove(lVar);
                    }
                }
            } else {
                lVar = null;
            }
        }
        return lVar;
    }

    public static synchronized l amX() {
        l lVar;
        synchronized (d.class) {
            lVar = gtj;
        }
        return lVar;
    }

    public static synchronized p vx(String str) {
        p pVar;
        synchronized (d.class) {
            if (bi.oW(str) || !str.equals(gtk)) {
                gtk = str;
                if (gth.size() <= 0) {
                    pVar = null;
                } else {
                    pVar = (p) gth.get(0);
                    if (pVar == null) {
                        pVar = null;
                    } else {
                        gth.remove(pVar);
                    }
                }
            } else {
                pVar = null;
            }
        }
        return pVar;
    }

    public static synchronized void amY() {
        boolean z = true;
        synchronized (d.class) {
            if (!WebView.isSys()) {
                if (WebView.isX5()) {
                    if (WebView.getUsingTbsCoreVersion(ad.getContext()) == 0) {
                        x.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "closeClientPreload without x5");
                    } else if (!com.tencent.xweb.x5.sdk.d.canOpenWebPlus(ad.getContext())) {
                        x.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "closeClientPreload can not OpenWebPlus");
                    }
                }
                z = gtn;
            }
            if (z) {
                x.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "preLoadNextRuntime disable preload");
            } else {
                x.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "preLoadNextRuntime");
                try {
                    amV();
                    amW();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AppBrandProcessPreloader[applaunch]", e, "preLoadNextRuntime exception.", new Object[0]);
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.AppBrandProcessPreloader[applaunch]", e2, "preLoadNextRuntime Error.", new Object[0]);
                }
            }
        }
    }

    public static synchronized void amZ() {
        synchronized (d.class) {
            3 3 = new 3();
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                3.run();
            } else {
                ah.A(3);
            }
        }
    }

    private static synchronized void done() {
        synchronized (d.class) {
            x.i("MicroMsg.AppBrandProcessPreloader[applaunch]", "preInit finished");
            gtf = true;
            gte = false;
            Iterator it = gtg.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar != null) {
                    aVar.onReady();
                }
            }
            gtg.clear();
        }
    }

    public static boolean ana() {
        return gtf;
    }

    public static boolean anb() {
        return gto;
    }
}
