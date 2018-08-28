package com.tencent.mm.plugin.appbrand.app;

import android.app.Application;
import android.support.annotation.Keep;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.p;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.appcache.l;
import com.tencent.mm.plugin.appbrand.appcache.m;
import com.tencent.mm.plugin.appbrand.appcache.s;
import com.tencent.mm.plugin.appbrand.appusage.t;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.appbrand.config.g.1;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.launching.ae;
import com.tencent.mm.plugin.appbrand.launching.precondition.j;
import com.tencent.mm.plugin.appbrand.r.d;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

@Keep
public final class PluginAppBrand extends f implements c, ai, b {
    public static final String TAG = "MicroMsg.PluginAppBrand";
    private final d singletonRegistry = new d();

    private static final class a extends p implements com.tencent.mm.kernel.a.b.b {
        private com.tencent.mm.plugin.appbrand.debugger.f feA = new com.tencent.mm.plugin.appbrand.debugger.f();
        private com.tencent.mm.plugin.appbrand.jsapi.appdownload.a fez;

        a() {
            super(e.class);
        }

        public final void onAccountInitialized(e.c cVar) {
            super.onAccountInitialized(cVar);
            com.tencent.mm.plugin.appbrand.dynamic.widget.c.initialize();
            ((com.tencent.mm.plugin.messenger.a.e) g.l(com.tencent.mm.plugin.messenger.a.e.class)).a("link_view_wxapp", new com.tencent.mm.plugin.appbrand.h.d());
            ((com.tencent.mm.plugin.messenger.a.e) g.l(com.tencent.mm.plugin.messenger.a.e.class)).a("link_view_wxapp", new com.tencent.mm.plugin.appbrand.h.c());
            g.a(com.tencent.mm.plugin.appbrand.a.a.class, new com.tencent.mm.kernel.c.e(m.fgc));
            g.a(u.class, new com.tencent.mm.kernel.c.e((com.tencent.mm.kernel.c.a) e.x(com.tencent.mm.plugin.appbrand.appusage.g.class)));
            g.a(com.tencent.mm.plugin.appbrand.widget.recentview.d.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.widget.d()));
            com.tencent.mm.a.e.co(ad.getContext().getFilesDir().getParent() + File.separator + "voice_split_joint/");
            ((o) g.n(o.class)).getSysCmdMsgExtension().a("WeAppSyncCommand", com.tencent.mm.plugin.appbrand.appcache.a.c.fiB);
            ((o) g.n(o.class)).getSysCmdMsgExtension().a("subscribesysmsg", com.tencent.mm.plugin.appbrand.h.b.gjW);
            this.fez = new com.tencent.mm.plugin.appbrand.jsapi.appdownload.a();
            com.tencent.mm.plugin.downloader.model.d.aCU();
            com.tencent.mm.plugin.downloader.model.b.a(this.fez);
            ((o) g.n(o.class)).getSysCmdMsgExtension().a("DebugAppCodeUpdated", this.feA);
        }

        public final void parallelsDependency() {
            com.tencent.mm.kernel.a.b.a.a(this, c.class).aN(g.n(n.class));
            com.tencent.mm.kernel.a.b.a.a(this, c.class).aN(g.n(b.class));
        }

        public final void onAccountRelease() {
            g.m(u.class);
            g.m(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
            super.onAccountRelease();
            ((com.tencent.mm.plugin.messenger.a.e) g.l(com.tencent.mm.plugin.messenger.a.e.class)).Gs("link_view_wxapp");
            ((com.tencent.mm.plugin.messenger.a.e) g.l(com.tencent.mm.plugin.messenger.a.e.class)).Gt("link_view_wxapp");
            ((o) g.n(o.class)).getSysCmdMsgExtension().b("WeAppSyncCommand", com.tencent.mm.plugin.appbrand.appcache.a.c.fiB);
            ((o) g.n(o.class)).getSysCmdMsgExtension().b("subscribesysmsg", com.tencent.mm.plugin.appbrand.h.b.gjW);
            com.tencent.mm.plugin.downloader.model.d.aCU();
            com.tencent.mm.plugin.downloader.model.b.b(this.fez);
            ((o) g.n(o.class)).getSysCmdMsgExtension().b("DebugAppCodeUpdated", this.feA);
        }
    }

    static {
        k.b("appbrandcommon", PluginAppBrand.class.getClassLoader());
    }

    public final List<ah> getDataTransferList() {
        List linkedList = new LinkedList();
        linkedList.add(new 1(new com.tencent.mm.plugin.appbrand.config.g()));
        linkedList.add(new t());
        return linkedList;
    }

    public final void onAccountInitialized(e.c cVar) {
    }

    public final void onAccountRelease() {
    }

    final e getCore() {
        return (e) p.v(e.class);
    }

    public final void installed() {
        alias(b.class);
    }

    public final void dependency() {
        dependsOn(com.tencent.mm.plugin.comm.a.a.class);
        dependsOn(com.tencent.mm.plugin.appbrand.compat.a.e.class);
    }

    public final void configure(com.tencent.mm.kernel.b.g gVar) {
    }

    public final void execute(com.tencent.mm.kernel.b.g gVar) {
        x.d(TAG, "current process name = %s, isMainThread %b", new Object[]{((h) g.Ef().DM()).dox, Boolean.valueOf(com.tencent.mm.sdk.platformtools.ah.isMainThread())});
        g.a(com.tencent.mm.plugin.appbrand.n.d.class, new com.tencent.mm.kernel.c.e(new ae()));
        g.a(com.tencent.mm.modelappbrand.e.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.dynamic.a.c()));
        g.a(com.tencent.mm.plugin.appbrand.n.e.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.launching.b.f()));
        g.a(com.tencent.mm.plugin.appbrand.appstorage.a.a.class, (com.tencent.mm.kernel.c.a) (gVar.ES() ? com.tencent.mm.plugin.appbrand.appstorage.n.b.fkX : com.tencent.mm.plugin.appbrand.appstorage.n.a.fkV));
        com.tencent.mm.plugin.appbrand.game.b.c.adc();
        if (gVar.ES()) {
            com.tencent.mm.plugin.ah.c.nbP.a(new com.tencent.mm.plugin.appbrand.u());
            g.a(a.class, new com.tencent.mm.kernel.c.e(new a()));
            g.a(com.tencent.mm.modelappbrand.g.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.share.a.a()));
            g.a(com.tencent.mm.plugin.appbrand.ui.banner.e.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.ui.banner.a()));
            g.a(com.tencent.mm.plugin.appbrand.n.a.class, new com.tencent.mm.kernel.c.e(new d()));
            g.a(com.tencent.mm.plugin.appbrand.n.c.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.config.o()));
            g.a(com.tencent.mm.plugin.appbrand.n.f.class, new com.tencent.mm.kernel.c.e(new c()));
            g.a(com.tencent.mm.plugin.appbrand.a.c.class, new com.tencent.mm.kernel.c.e(new f()));
            g.a(com.tencent.mm.plugin.appbrand.widget.a.a.class, new com.tencent.mm.kernel.c.e(new g()));
            g.a(com.tencent.mm.plugin.appbrand.n.g.class, new com.tencent.mm.kernel.c.e(new w()));
            g.a(com.tencent.mm.plugin.appbrand.n.b.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.game.e()));
            g.a(i.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.h.e()));
            g.a(com.tencent.mm.modelappbrand.h.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.h.a()));
            com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.appbrand.b(), new String[]{"//enable_appbrand_monkey_test", "//disable_appbrand_monkey_test", "//callsearchshowoutwxaapp", "//getsearchshowoutwxaapp", "//appbrandtest", "//wxafts", "//wxatest", "//localwxalibrary"});
            com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.appbrand.dynamic.c.a(), new String[]{"//widget"});
            g.Ek().a(new com.tencent.mm.kernel.api.g() {
                public final void vk() {
                    ((com.tencent.mm.modelappbrand.e) g.l(com.tencent.mm.modelappbrand.e.class)).initialize();
                }

                public final void aF(boolean z) {
                    ((com.tencent.mm.modelappbrand.e) g.l(com.tencent.mm.modelappbrand.e.class)).shutdown();
                    ((com.tencent.mm.modelappbrand.e) g.l(com.tencent.mm.modelappbrand.e.class)).JM().exit();
                }
            });
            if (DebuggerShell.aer()) {
                g.a(DebuggerShell.class, new DebuggerShell());
            }
            s.a(new l());
            return;
        }
        if (ad.cie() || isAppBrandProcess()) {
            b.aaQ();
            com.tencent.mm.plugin.appbrand.report.a.h.amK();
            g.a(u.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.appusage.h()));
            g.a(com.tencent.mm.plugin.appbrand.widget.recentview.d.class, new com.tencent.mm.kernel.c.e(new com.tencent.mm.plugin.appbrand.widget.d()));
            j.cF(ad.getContext());
            d dVar = this.singletonRegistry;
            Application application = gVar.dsQ;
            x.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.AppSingletonRegistry ");
            application.registerActivityLifecycleCallbacks(dVar);
            dVar = this.singletonRegistry;
            application = gVar.dsQ;
            dVar.gBB = true;
            dVar.app = application;
            dVar = this.singletonRegistry;
            x.i("MicroMsg.AppSingletonRegistry", "registerAppSingleton() called with: singleton = [%s]", new Object[]{com.tencent.mm.plugin.appbrand.r.a.a.gCg});
            dVar.gBz.offer(r1);
        }
        if (ad.cie()) {
            com.tencent.mm.plugin.appbrand.dynamic.widget.c.initialize();
            ak.a(new ak.c() {
                public final void c(String str, Throwable th) {
                    if (bi.oV(str).contains(".plugin.appbrand")) {
                        com.tencent.mm.plugin.report.service.h.mEJ.a(365, 3, 1, false);
                        KVCommCrossProcessReceiver.brP();
                    }
                }
            });
        } else if (isAppBrandProcess()) {
            AppBrandProcessSuicideLogic.d(gVar.dsQ);
        } else if (isSupportProcess(gVar.dox)) {
            com.tencent.mm.plugin.appbrand.dynamic.e.c.initialize();
            com.tencent.mm.plugin.appbrand.dynamic.e.c.a(new com.tencent.mm.plugin.appbrand.dynamic.e.c.a() {
                public final void aaS() {
                    com.tencent.mm.plugin.appbrand.dynamic.h.e.cv(ad.getContext());
                }
            });
            com.tencent.mm.v.g.initialize();
        }
    }

    public final String name() {
        return "plugin-appbrand";
    }

    private static boolean isAppBrandProcess() {
        try {
            return ((h) g.Ef().DM()).dox.startsWith(ad.getPackageName() + ":appbrand");
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isSupportProcess(String str) {
        try {
            return "com.tencent.mm:support".equals(str);
        } catch (Exception e) {
            return false;
        }
    }
}
