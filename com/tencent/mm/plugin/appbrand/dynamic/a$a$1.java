package com.tencent.mm.plugin.appbrand.dynamic;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.plugin.appbrand.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.dynamic.a.a;
import com.tencent.mm.plugin.appbrand.dynamic.f.f;
import com.tencent.mm.plugin.appbrand.dynamic.j.b;
import com.tencent.mm.plugin.appbrand.q.l;
import com.tencent.mm.plugin.appbrand.widget.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.c.e;
import java.util.Map;
import junit.framework.Assert;

class a$a$1 implements Runnable {
    final /* synthetic */ String bAj;
    final /* synthetic */ Bundle fuf;
    final /* synthetic */ c fuh;
    final /* synthetic */ a fui;
    final /* synthetic */ String sk;

    a$a$1(a aVar, c cVar, String str, String str2, Bundle bundle) {
        this.fui = aVar;
        this.fuh = cVar;
        this.sk = str;
        this.bAj = str2;
        this.fuf = bundle;
    }

    public final void run() {
        String string;
        long j;
        c cVar = this.fuh;
        String str = this.sk;
        String str2 = this.bAj;
        Bundle bundle = this.fuf;
        Assert.assertNotNull(str);
        if (!(str.equals(cVar.doU) || cVar.doR == null)) {
            cVar.cleanup();
            cVar.Sx = false;
            cVar.doR = null;
        }
        cVar.doU = str;
        cVar.appId = str2;
        String str3 = "";
        long j2 = 0;
        if (bundle != null) {
            string = bundle.getString("cache_key", "");
            cVar.fur = bundle.getString("query");
            cVar.fus = bundle.getBoolean("is_testing_ui");
            cVar.mUrl = bundle.getString("url");
            cVar.fuq = bundle.getInt("widget_type");
            cVar.fuu = bundle.getString("search_id");
            cVar.fmS = bundle.getString("__session_id");
            j = bundle.getLong("__on_bind_nano_time");
            if (!bi.oW(cVar.fmS)) {
                c.a((CollectSession) bundle.getParcelable("__cost_time_session"));
            }
            j2 = j;
        } else {
            string = str3;
        }
        x.i("MicroMsg.DynamicPageViewIPCProxy", "attach(%s, %s, %s)", new Object[]{str, str2, string});
        s.i("MicroMsg.DynamicPageViewIPCProxy", "attach(%s, %s, %s)", new Object[]{str, str2, string});
        Object obj = 1;
        cVar.fut = b.sJ(str);
        if (cVar.fut == null) {
            cVar.fut = new g();
            obj = null;
        }
        Object obj2 = cVar.fuq == 1 ? null : obj;
        cVar.fut.field_id = str;
        cVar.fut.field_cacheKey = string;
        cVar.fut.field_appId = str2;
        if (cVar.doR == null) {
            e eVar;
            c.aZ(cVar.fmS, "before_init_js_engine");
            Context context = cVar.mContext;
            String str4 = cVar.doU;
            WxaWidgetContext sA = k.sA(str4);
            if (sA == null || bundle == null) {
                x.w("MicroMsg.WxaWidgetInitializer", "FwContext is null(id : %s)", new Object[]{str4});
                eVar = null;
            } else {
                x.i("MicroMsg.WxaWidgetInitializer", "initJsBridge(%s)", new Object[]{str4});
                eVar = com.tencent.mm.plugin.appbrand.dynamic.h.e.a(context, sA, new com.tencent.mm.plugin.appbrand.dynamic.d.b.a(str4, sA.afa()), bundle);
            }
            cVar.doR = eVar;
            c.aZ(cVar.fmS, "after_init_js_engine");
            cVar.doR.doU = cVar.doU;
            if (bundle != null) {
                cVar.n(bundle.getBundle("__env_args"));
            }
            cVar.doR.onStart();
            if (cVar.fuv) {
                cVar.doR.b(new f());
            } else {
                cVar.doR.c(new com.tencent.mm.plugin.appbrand.dynamic.f.g());
            }
            e eVar2 = cVar.doR;
            str4 = "";
            str3 = "";
            String str5 = "";
            Map map = null;
            int i = 0;
            int i2 = 0;
            if (bundle != null) {
                i = bundle.getInt("view_init_width");
                i2 = bundle.getInt("view_init_height");
                str4 = bundle.getString("cache_key", "");
                str3 = bundle.getString("msg_title", "");
                str2 = bundle.getString("msg_path", "");
                str5 = l.vP(str2);
                map = l.vQ(str2);
            }
            com.tencent.mm.plugin.appbrand.dynamic.f.b bVar = new com.tencent.mm.plugin.appbrand.dynamic.f.b();
            bVar.fwS = str4;
            bVar.title = str3;
            bVar.path = str5;
            bVar.fwR = map;
            bVar.fwT = i;
            bVar.fwU = i2;
            eVar2.a(bVar);
            if (j2 > 0) {
                j = (System.nanoTime() - j2) / 1000000;
                int i3 = 22;
                if (j <= 50) {
                    i3 = 0;
                } else if (j <= 100) {
                    i3 = 1;
                } else if (j <= 200) {
                    i3 = 2;
                } else if (j <= 300) {
                    i3 = 3;
                } else if (j <= 400) {
                    i3 = 4;
                } else if (j <= 500) {
                    i3 = 5;
                } else if (j <= 600) {
                    i3 = 6;
                } else if (j <= 1000) {
                    i3 = 17;
                } else if (j <= 1500) {
                    i3 = 18;
                } else if (j <= 2000) {
                    i3 = 19;
                } else if (j <= 2500) {
                    i3 = 20;
                } else if (j <= 3000) {
                    i3 = 21;
                }
                h.mEJ.a(677, (long) i3, 1, false);
                h.mEJ.a(677, 8, 1, false);
            }
            c.aZ(cVar.fmS, "init_finish");
            c.print(cVar.fmS);
        } else {
            c.rw(cVar.fmS);
            if (bundle != null) {
                cVar.n(bundle.getBundle("__env_args"));
            }
            cVar.doR.onStart();
            if (cVar.fuv) {
                cVar.doR.b(new f());
            } else {
                cVar.doR.c(new com.tencent.mm.plugin.appbrand.dynamic.f.g());
            }
        }
        cVar.Sx = true;
        if (obj2 != null) {
            c.a(cVar.doR, cVar.fut);
        } else if (cVar.fus) {
            cVar.fut.field_data = bundle.getString("init_data");
            c.a(cVar.doR, cVar.fut);
        }
        cVar.aeP();
    }
}
