package com.tencent.mm.plugin.appbrand.dynamic;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mm.ipcinvoker.wx_extension.b$a;
import com.tencent.mm.model.u;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.modelappbrand.x;
import com.tencent.mm.plugin.appbrand.canvas.widget.b;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.widget.g;
import com.tencent.mm.protocal.c.su;
import com.tencent.mm.protocal.c.sv;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.u.c.e;
import com.tencent.mm.u.c.f;
import java.util.Set;

public final class c implements b {
    boolean Sx;
    String appId;
    volatile e doR;
    String doU;
    String fmS;
    Runnable fuA;
    int fuq;
    String fur;
    boolean fus;
    g fut;
    String fuu;
    volatile boolean fuv;
    private volatile boolean fuw;
    boolean fux = false;
    boolean fuy = false;
    private b$a fuz;
    Context mContext;
    String mUrl;

    private static class a implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("widgetId");
            String string2 = bundle.getString("respData");
            if (!bi.oW(string)) {
                IPCDynamicPageView sH = com.tencent.mm.plugin.appbrand.dynamic.h.a.afs().sH(string);
                if (sH != null) {
                    1 1 = new 1(this);
                    if (sH.fye == null) {
                        1.b(false, "listener is null", null);
                        return;
                    }
                    x xVar = (x) sH.fye.jr("OnDataPush");
                    if (xVar == null) {
                        1.b(false, "listener is null", null);
                    } else {
                        xVar.Z(string, string2);
                    }
                }
            }
        }
    }

    public c(Context context) {
        this.mContext = context;
        this.fuz = new 1(this);
        this.fuA = new Runnable() {
            public final void run() {
                c.this.aeP();
            }
        };
    }

    public final boolean bg(String str, String str2) {
        if (this.doR == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        f fVar = this.doR.doW;
        com.tencent.mm.u.b.e fO = fVar.dpa.fO(str);
        if (fO == null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) do not exist.", new Object[]{str});
            return false;
        } else if (fVar.doM.gu(fO.getIndex())) {
            if (bi.oW(str2)) {
                str2 = "{}";
            }
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.MiniJsEventDispatcher", "dispatch, event: %s, data size: %s, srcId: %d", new Object[]{str, Integer.valueOf(str2.length()), Integer.valueOf(0)});
            fVar.doX.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\", %s, %s, %s)", new Object[]{str, str2, "undefined", f.Db()}), null);
            return true;
        } else {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.MiniJsEventDispatcher", "JsEvent(%s) no permission.", new Object[]{str});
            return false;
        }
    }

    final void cleanup() {
        if (this.fut != null) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup(%s, %s, %s)", new Object[]{this.fut.field_id, this.fut.field_appId, this.fut.field_cacheKey});
        } else {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.DynamicPageViewIPCProxy", "cleanup");
        }
        if (this.doR != null) {
            e eVar = this.doR;
            com.tencent.mm.sdk.platformtools.x.v("MicroMsg.MiniJsBridge", "onStop(%s)", new Object[]{eVar.doU});
            eVar.Sx = false;
            eVar.doX.cleanup();
            com.tencent.mm.u.c.c cVar = eVar.doV;
            cVar.doO.quit();
            cVar.doL.doS.recycle();
            if (eVar.doZ != null) {
                eVar.doZ.C(eVar.doU, 4);
                eVar.doZ = null;
            }
        }
    }

    final void aeP() {
        if (!this.fus) {
            g gVar = this.fut;
            if (gVar != null && this.Sx) {
                if (this.fuv) {
                    this.fuw = true;
                } else if (bi.oW(gVar.field_appId)) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.DynamicPageViewIPCProxy", "tryToRefresh(%s) failed, has no appId", new Object[]{this.doU});
                } else {
                    this.fuw = false;
                    long currentTimeMillis = (gVar.field_updateTime + (((long) gVar.field_interval) * 1000)) - System.currentTimeMillis();
                    if (currentTimeMillis > 0) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.DynamicPageViewIPCProxy", "post delay refresh(%s) data.", new Object[]{Long.valueOf(currentTimeMillis)});
                        b.e(this.fuA, currentTimeMillis);
                        return;
                    }
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.DynamicPageViewIPCProxy", "refresh data(%s, %s, %s)", new Object[]{this.fut.field_id, this.fut.field_appId, this.fut.field_cacheKey});
                    s.i("MicroMsg.DynamicPageViewIPCProxy", "refresh data(%s, %s, %s)", this.fut.field_id, this.fut.field_appId, this.fut.field_cacheKey);
                    com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
                    aVar.dIF = 1193;
                    aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/getdynamicdata";
                    su suVar = new su();
                    suVar.bPS = gVar.field_appId;
                    suVar.aAL = gVar.field_cacheKey;
                    suVar.scene = this.fuq;
                    suVar.bWm = this.fur;
                    suVar.url = this.mUrl;
                    aVar.dIG = suVar;
                    aVar.dIH = new sv();
                    com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.KT(), this.fuz);
                }
            }
        }
    }

    static void a(e eVar, g gVar) {
        boolean z = false;
        if (eVar == null || gVar == null || bi.oW(gVar.field_data)) {
            boolean z2;
            String str = "MicroMsg.DynamicPageViewIPCProxy";
            String str2 = "pushData failed, jsBridge(isNull : %s) or cacheData(isNull : %s) or cacheData.field_data is null";
            Object[] objArr = new Object[2];
            if (eVar == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[0] = Boolean.valueOf(z2);
            if (gVar == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            com.tencent.mm.sdk.platformtools.x.i(str, str2, objArr);
            return;
        }
        s.i("MicroMsg.DynamicPageViewIPCProxy", "pushData %s", gVar.field_id);
        com.tencent.mm.plugin.appbrand.dynamic.f.c cVar = new com.tencent.mm.plugin.appbrand.dynamic.f.c();
        cVar.data = gVar.field_data;
        eVar.a(cVar);
        Parcelable bundle = new Bundle();
        bundle.putString("widgetId", gVar.field_id);
        bundle.putString("respData", gVar.field_data);
        com.tencent.mm.ipcinvoker.f.a("com.tencent.mm:tools", bundle, a.class, null);
    }

    public final void n(Bundle bundle) {
        if (bundle != null && this.doR != null) {
            u.b bVar = this.doR.doV.doL.doS;
            if (bVar != null) {
                Set<String> keySet = bundle.keySet();
                if (keySet != null && bVar != null) {
                    for (String str : keySet) {
                        bVar.p(str, bundle.get(str));
                    }
                }
            }
        }
    }

    public final void onPause() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.DynamicPageViewIPCProxy", "onPause(%s)", new Object[]{this.doU});
        this.fuv = true;
        if (this.doR != null) {
            this.doR.b(new com.tencent.mm.plugin.appbrand.dynamic.f.f());
        }
    }

    public final void onResume() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.DynamicPageViewIPCProxy", "onResume(%s)", new Object[]{this.doU});
        boolean z = this.fuv;
        if (this.doR != null) {
            this.doR.c(new com.tencent.mm.plugin.appbrand.dynamic.f.g());
        }
        this.fuv = false;
        if (z && this.fuw) {
            aeP();
        }
    }

    public final boolean isPaused() {
        return this.fuv;
    }
}
