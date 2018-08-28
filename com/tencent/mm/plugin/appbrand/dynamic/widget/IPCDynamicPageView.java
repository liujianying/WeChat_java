package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.modelappbrand.aa;
import com.tencent.mm.modelappbrand.ab;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.w;
import com.tencent.mm.modelappbrand.y;
import com.tencent.mm.modelappbrand.z;
import com.tencent.mm.plugin.appbrand.canvas.f;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.dynamic.b;
import com.tencent.mm.plugin.appbrand.dynamic.h;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.widget.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;

public class IPCDynamicPageView extends LinearLayout implements l, a, h {
    public static ag fun;
    private static LayoutParams fyk = new LayoutParams(-1, -1);
    public String doU;
    private long fmZ;
    private g fut;
    private Bundle fyc;
    private com.tencent.mm.plugin.appbrand.dynamic.a fyd;
    public u fye;
    public volatile boolean fyf;
    public long fyg;
    private a fyh;
    private Runnable fyi = new 1(this);
    private Runnable fyj = new 2(this);
    private volatile boolean mDetached;

    static {
        HandlerThread Xs = e.Xs("WxaWidget#UIActionThread");
        Xs.start();
        fun = new ag(Xs.getLooper());
    }

    public IPCDynamicPageView(Context context) {
        super(context);
        init(context);
    }

    public IPCDynamicPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public IPCDynamicPageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.fyd = new com.tencent.mm.plugin.appbrand.dynamic.a(this);
        View bH = c.bH(context);
        addView(bH, fyk);
        this.fyh = (a) bH;
    }

    public final void d(String str, String str2, Bundle bundle) {
        fun.post(new 4(this, bundle, str, str2));
    }

    public final void detach() {
        if (Looper.myLooper() == fun.getLooper()) {
            this.fyj.run();
        } else {
            fun.post(this.fyj);
        }
    }

    public final void cleanup() {
        if (this.fut != null) {
            x.i("MicroMsg.IPCDynamicPageView", "cleanup(id : %s, %s, %s, %s)", new Object[]{this.doU, this.fut.field_id, this.fut.field_appId, this.fut.field_cacheKey});
        } else {
            x.i("MicroMsg.IPCDynamicPageView", "cleanup(id : %s)", new Object[]{this.doU});
        }
        adl();
    }

    public final void ka(int i) {
        kf(i);
        detach();
    }

    public final void b(String str, r rVar) {
        if (this.fye == null) {
            rVar.b(false, "listener is null", null);
            return;
        }
        w wVar = (w) this.fye.jr("makePhoneCall");
        if (wVar == null) {
            rVar.b(false, "listener is null", null);
        } else {
            wVar.js(str);
        }
    }

    public final void c(String str, r rVar) {
        if (this.fye == null) {
            rVar.b(false, "listener is null", null);
            return;
        }
        aa aaVar = (aa) this.fye.jr("onSearchWAWidgetReloadData");
        if (aaVar == null) {
            rVar.b(false, "listener is null", null);
        } else {
            aaVar.ju(str);
        }
    }

    public final void a(String str, r rVar) {
        if (this.fye == null) {
            rVar.b(false, "listener is null", null);
            return;
        }
        z zVar = (z) this.fye.jr("openApp");
        if (zVar == null) {
            rVar.b(false, "listener is null", null);
        } else {
            zVar.jt(str);
        }
    }

    public final void a(boolean z, String str, boolean z2, r rVar) {
        if (this.fye == null) {
            rVar.b(false, "listener is null", null);
            return;
        }
        y yVar = (y) this.fye.jr("OnTapCallback");
        if (yVar == null) {
            rVar.b(false, "listener is null", null);
        } else {
            yVar.b(z, str, z2);
        }
    }

    public final void a(String str, String str2, r rVar) {
        if (this.fye == null) {
            rVar.b(false, "listener is null", null);
            return;
        }
        t tVar = (t) this.fye.jr("showPicker");
        if (tVar == null) {
            rVar.b(false, "listener is null", null);
        } else {
            tVar.a(str, str2, rVar);
        }
    }

    public final void b(int i, r rVar) {
        if (this.fye == null) {
            rVar.b(false, "listener is null", null);
            return;
        }
        ab abVar = (ab) this.fye.jr("setWidgetSize");
        if (abVar == null) {
            rVar.b(false, "listener is null", null);
        } else {
            abVar.a(i, rVar);
        }
    }

    public final boolean d(Canvas canvas) {
        return this.fyh.d(canvas);
    }

    public final void adk() {
        long currentTimeMillis = System.currentTimeMillis() - this.fmZ;
        fun.removeCallbacks(this.fyi);
        if (currentTimeMillis < 12) {
            fun.postDelayed(this.fyi, currentTimeMillis);
        } else {
            this.fyi.run();
        }
    }

    public final void a(JSONArray jSONArray, a.a aVar) {
        this.fyh.a(jSONArray, aVar);
    }

    public final void b(JSONArray jSONArray, a.a aVar) {
        this.fyh.b(jSONArray, aVar);
    }

    public final void adl() {
        this.fyh.adl();
    }

    public void setId(String str) {
        this.fyh.setId(str);
    }

    public int getType() {
        return this.fyh.getType();
    }

    public final void m(Runnable runnable) {
        this.fyh.m(runnable);
    }

    public f getDrawContext() {
        return this.fyh.getDrawContext();
    }

    public final void onPause() {
        x.v("MicroMsg.IPCDynamicPageView", "onPause(%s)", new Object[]{this.doU});
        this.fyh.onPause();
        fun.post(new 5(this));
    }

    public final void onResume() {
        x.v("MicroMsg.IPCDynamicPageView", "onResume(%s)", new Object[]{this.doU});
        this.fyh.onResume();
        fun.post(new 6(this));
    }

    public final boolean isPaused() {
        return this.fyh.isPaused();
    }

    public String getSessionId() {
        return this.fyh.getSessionId();
    }

    public void setSessionId(String str) {
        this.fyh.setSessionId(str);
    }

    public int getDrawActionCostTimeReportId() {
        return this.fyh.getDrawActionCostTimeReportId();
    }

    public int getDrawCostTimeReportId() {
        return this.fyh.getDrawCostTimeReportId();
    }

    public void setStartTime(long j) {
        this.fyh.setStartTime(j);
    }

    public final void adm() {
        this.fyh.adm();
    }

    public String getExtId() {
        return this.doU;
    }

    public Bundle getExtData() {
        return this.fyc;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        x.i("MicroMsg.IPCDynamicPageView", "onSizeChanged(w : %d, h : %d, oldw : %d, oldh : %d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        Bundle bundle = new Bundle();
        bundle.putInt("__page_view_width", i);
        bundle.putInt("__page_view_height", i2);
        String str = this.doU;
        Parcelable bundle2 = new Bundle();
        bundle2.putString("id", str);
        bundle2.putBundle("__env_args", bundle);
        com.tencent.mm.ipcinvoker.f.a(i.aeT().sz(str), bundle2, a$g.class, null);
    }

    private void kf(int i) {
        if (this.fye == null) {
            x.i("MicroMsg.IPCDynamicPageView", "publishOnWidgetStateChanged(id : %s, state : %d) failed, listener wrapper is null.", new Object[]{this.doU, Integer.valueOf(i)});
            return;
        }
        com.tencent.mm.modelappbrand.f JX = this.fye.JX();
        if (JX == null) {
            x.i("MicroMsg.IPCDynamicPageView", "publishOnWidgetStateChanged(id : %s, state : %d) failed, listener is null.", new Object[]{this.doU, Integer.valueOf(i)});
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            JX.q(this, i);
        } else {
            b.o(new 7(this, JX, i));
        }
    }

    public final boolean Y(String str, String str2) {
        com.tencent.mm.plugin.appbrand.dynamic.a aVar = this.fyd;
        String str3 = this.doU;
        if (aVar.doU == null || aVar.doU.length() == 0 || str == null || str.length() == 0) {
            return false;
        }
        Parcelable bundle = new Bundle();
        bundle.putString("id", str3);
        bundle.putString("event", str);
        bundle.putString("data", str2);
        IPCBoolean iPCBoolean = (IPCBoolean) com.tencent.mm.ipcinvoker.f.a(i.aeT().sz(str3), bundle, a$f.class);
        return iPCBoolean != null ? iPCBoolean.value : false;
    }

    public final void kg(int i) {
        com.tencent.mm.plugin.appbrand.dynamic.a aVar = this.fyd;
        String str = this.doU;
        if (aVar.doU != null && aVar.doU.length() != 0) {
            Parcelable bundle = new Bundle();
            bundle.putString("id", str);
            bundle.putInt("widgetState", i);
            com.tencent.mm.ipcinvoker.f.a(i.aeT().sz(str), bundle, com.tencent.mm.plugin.appbrand.dynamic.f.a.class, null);
        }
    }
}
