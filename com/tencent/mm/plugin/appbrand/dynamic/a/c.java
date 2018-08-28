package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.modelappbrand.j;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.appcache.s;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer;
import com.tencent.mm.plugin.appbrand.dynamic.b.d;
import com.tencent.mm.plugin.appbrand.dynamic.h.a;
import com.tencent.mm.plugin.appbrand.dynamic.h.a$a;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.1;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class c implements OnAttachStateChangeListener, e, a$a, com.tencent.mm.sdk.platformtools.ak.c {
    private String eIe;
    private volatile com.tencent.mm.modelappbrand.c fvh;
    private volatile b fvo;
    private volatile d fvp;

    public final void initialize() {
        if (!(this.eIe == null || this.eIe.length() == 0)) {
            shutdown();
        }
        this.eIe = "Token#" + System.nanoTime();
        ak.a(this);
        s.a(new d());
    }

    public final void shutdown() {
        Map JL = aff().JL();
        if (JL != null && !JL.isEmpty()) {
            for (Object next : new LinkedHashSet(JL.keySet())) {
                if (next != null && (next instanceof String)) {
                    jl((String) next);
                }
            }
        }
    }

    public final View bH(Context context) {
        return new IPCDynamicPageView(context);
    }

    public final String a(String str, View view, Bundle bundle, u uVar) {
        f fVar = null;
        if (!(view instanceof IPCDynamicPageView)) {
            return "";
        }
        String string;
        String string2;
        String bT = k.bT(System.nanoTime());
        com.tencent.mm.plugin.appbrand.collector.c.c("widget_launch", bT, "on_bind_view", true);
        com.tencent.mm.plugin.appbrand.collector.c.ba(bT, "init_finish");
        IPCDynamicPageView iPCDynamicPageView = (IPCDynamicPageView) view;
        if (bundle != null) {
            string = bundle.getString("app_id");
            string2 = bundle.getString("msg_id");
            bundle.putString("__session_id", str);
            bundle.putLong("__on_bind_nano_time", System.nanoTime());
            bundle.putString("__session_id", bT);
            bundle.putParcelable("__cost_time_session", com.tencent.mm.plugin.appbrand.collector.c.rv(bT));
        } else {
            string2 = null;
            string = null;
        }
        bT = WxaWidgetInitializer.bh(string, string2);
        i.aeT().fuO.put(bT, bundle.getString("exec_process_name", "com.tencent.mm:support"));
        com.tencent.mm.modelappbrand.s.i("MicroMsg.DynamicPageService", "onBindView(%s)", new Object[]{bT});
        iPCDynamicPageView.removeOnAttachStateChangeListener(this);
        iPCDynamicPageView.addOnAttachStateChangeListener(this);
        Assert.assertNotNull(bT);
        iPCDynamicPageView.fyg = System.currentTimeMillis();
        if (uVar != null) {
            fVar = uVar.JX();
        }
        if (!(iPCDynamicPageView.doU == null || bT.equals(iPCDynamicPageView.doU))) {
            iPCDynamicPageView.cleanup();
        }
        if (!(fVar == null || (bT.equals(iPCDynamicPageView.doU) && iPCDynamicPageView.fyf))) {
            fVar.q(iPCDynamicPageView, 0);
        }
        iPCDynamicPageView.fyf = false;
        com.tencent.mm.modelappbrand.s.i("MicroMsg.IPCDynamicPageView", "attach (%s)", new Object[]{bT});
        IPCDynamicPageView.fun.post(new IPCDynamicPageView$3(iPCDynamicPageView, bT, bundle, uVar, string));
        x.v("MicroMsg.DynamicPageService", "onBindView(%s)", new Object[]{bT});
        a afs = a.afs();
        if (!(this == null || str == null || str.length() == 0)) {
            afs.fxs.put(str, this);
        }
        a.afs().c(str, iPCDynamicPageView);
        aff().g(str, iPCDynamicPageView);
        return bT;
    }

    public final void a(String str, View view) {
        if (view instanceof IPCDynamicPageView) {
            IPCDynamicPageView iPCDynamicPageView = (IPCDynamicPageView) view;
            x.v("MicroMsg.DynamicPageService", "onUnBindView(%s)", new Object[]{iPCDynamicPageView.getExtId()});
            iPCDynamicPageView.removeOnAttachStateChangeListener(this);
            aff().h(str, iPCDynamicPageView);
            a.afs().b(str, iPCDynamicPageView);
            iPCDynamicPageView.detach();
        }
    }

    public final void bB(View view) {
        if (view instanceof IPCDynamicPageView) {
            ((IPCDynamicPageView) view).kg(TXLiveConstants.PLAY_WARNING_RECV_DATA_LAG);
        }
    }

    public final void jl(String str) {
        a.afs().fxr.remove(str);
        a afs = a.afs();
        if (!(str == null || str.length() == 0)) {
            afs.fxs.remove(str);
        }
        Set<View> aY = aff().aY(str);
        if (aY != null && !aY.isEmpty()) {
            for (View view : aY) {
                if (view != null && (view instanceof IPCDynamicPageView)) {
                    IPCDynamicPageView iPCDynamicPageView = (IPCDynamicPageView) view;
                    x.v("MicroMsg.DynamicPageService", "onUnbindAllView, do unBindView(%s)", new Object[]{iPCDynamicPageView.getExtId()});
                    iPCDynamicPageView.removeOnAttachStateChangeListener(this);
                    iPCDynamicPageView.detach();
                }
            }
            if (aff().JL().isEmpty()) {
                com.tencent.mm.bu.a.post(new 1());
            }
        }
    }

    public final l bC(View view) {
        if (view instanceof IPCDynamicPageView) {
            return (l) view;
        }
        return null;
    }

    private com.tencent.mm.modelappbrand.c aff() {
        if (this.fvh == null) {
            synchronized (this) {
                if (this.fvh == null) {
                    this.fvh = new a();
                }
            }
        }
        return this.fvh;
    }

    public final com.tencent.mm.modelappbrand.d JM() {
        if (this.fvo == null) {
            synchronized (this) {
                if (this.fvo == null) {
                    this.fvo = new b(aff());
                }
            }
        }
        return this.fvo;
    }

    public final j JN() {
        if (this.fvp == null) {
            synchronized (this) {
                if (this.fvp == null) {
                    this.fvp = new d();
                }
            }
        }
        return this.fvp;
    }

    public final void c(String str, Throwable th) {
        x.e("MicroMsg.DynamicPageService", "uncaughtException(%s)", new Object[]{Log.getStackTraceString(th)});
        shutdown();
    }

    public final void onViewAttachedToWindow(View view) {
        if (view != null && (view instanceof IPCDynamicPageView)) {
            x.d("MicroMsg.DynamicPageService", "onViewAttachedToWindow(%s)", new Object[]{((IPCDynamicPageView) view).getExtId()});
            r6.onResume();
        }
    }

    public final void onViewDetachedFromWindow(View view) {
        if (view != null && (view instanceof IPCDynamicPageView)) {
            x.d("MicroMsg.DynamicPageService", "onViewDetachedFromWindow(%s)", new Object[]{((IPCDynamicPageView) view).getExtId()});
            r6.onPause();
        }
    }

    public final void a(String str, IPCDynamicPageView iPCDynamicPageView) {
        x.v("MicroMsg.DynamicPageService", "onOverLength(sessionId : %s, view : %s)", new Object[]{str, iPCDynamicPageView.getExtId()});
        a(str, (View) iPCDynamicPageView);
    }
}
