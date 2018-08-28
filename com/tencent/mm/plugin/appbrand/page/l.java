package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.page.n.18;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.a;
import com.tencent.mm.ui.widget.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class l extends SwipeBackLayout implements a, g.a {
    private View FU;
    private n fcz;
    private boolean gmD;
    public boolean mSwiping = false;

    public abstract View agC();

    public abstract void b(String str, String str2, int[] iArr);

    public abstract p getCurrentPageView();

    public abstract String getCurrentUrl();

    public abstract void loadUrl(String str);

    public abstract boolean sV(String str);

    public l(Context context, n nVar) {
        super(context);
        this.fcz = nVar;
        setLayoutParams(new MarginLayoutParams(-1, -1));
        init();
        setNeedRequestActivityTranslucent(false);
        mC(true);
        this.FU = agB();
        ((ViewGroup) this.FU).addView(agC(), new LayoutParams(-1, -1));
        addView(getContentView());
        setContentView(getContentView());
        setSwipeGestureDelegate(this);
    }

    public void cleanup() {
        g.b(this);
    }

    public void agE() {
        x.d("MicroMsg.AppBrandPage", "onPageForeground: %s", new Object[]{getCurrentUrl()});
        g.b(this);
        this.uIg = false;
        setEnableGesture(this.fcz.agM());
        onSwipe(1.0f);
        this.gmD = false;
        setVisibility(0);
        agG();
    }

    public void agF() {
        x.d("MicroMsg.AppBrandPage", "onPageBackground: %s", new Object[]{getCurrentUrl()});
        g.a(this);
        this.gmD = true;
    }

    public void agD() {
        x.d("MicroMsg.AppBrandPage", "onPageDestroy: %s", new Object[]{getCurrentUrl()});
    }

    public final void hide() {
        if (this.gmD) {
            setVisibility(4);
        }
    }

    public View agB() {
        return new b(getContext());
    }

    private View getContentView() {
        return this.FU;
    }

    public String getAppId() {
        return this.fcz.getAppId();
    }

    public n getContainer() {
        return this.fcz;
    }

    public d getPageConfig() {
        return this.fcz.getAppConfig().rG(com.tencent.mm.plugin.appbrand.q.l.vP(getCurrentUrl()));
    }

    public void agG() {
        d pageConfig = getPageConfig();
        p currentPageView = getCurrentPageView();
        String str = pageConfig.fpj;
        String str2 = pageConfig.fpg;
        if (!currentPageView.gnv) {
            currentPageView.gnw = j.aO(str, currentPageView.gnw);
        }
        if (!currentPageView.gnx) {
            currentPageView.gny = str2;
        }
        currentPageView.O(currentPageView.gnw, currentPageView.gny);
    }

    public void agH() {
        d pageConfig = getPageConfig();
        getCurrentPageView().sZ(pageConfig.fpf);
        getCurrentPageView().q(pageConfig.fph);
        getCurrentPageView().sY(pageConfig.fpj);
        getCurrentPageView().q(pageConfig.fph);
        getCurrentPageView().ta(pageConfig.fpg);
        getCurrentPageView().gnn.dk(true);
        getCurrentPageView().cE(pageConfig.fpo);
        getCurrentPageView().bm(pageConfig.fpp, pageConfig.fpc);
        if (c.b(getCurrentPageView(), b.b.gmi)) {
            p currentPageView = getCurrentPageView();
            String str = pageConfig.fpk;
            String str2 = pageConfig.fpl;
            boolean z = pageConfig.fpm;
            if (currentPageView != null) {
                if (bi.oW(str) && bi.oW(str2) && !z) {
                    currentPageView.gnn.aoZ();
                } else {
                    b.a(currentPageView, z);
                }
            }
        }
    }

    private void a(String str, aa aaVar) {
        Map hashMap = new HashMap();
        hashMap.put("path", com.tencent.mm.plugin.appbrand.q.l.vP(getCurrentUrl()));
        hashMap.put("query", com.tencent.mm.plugin.appbrand.q.l.vQ(getCurrentUrl()));
        if (aaVar != null) {
            hashMap.put("openType", aaVar.toString());
        }
        com.tencent.mm.plugin.appbrand.r.c.m(hashMap);
        getCurrentPageView().a(str, new JSONObject(hashMap).toString(), null);
    }

    public final void a(aa aaVar) {
        a("onAppRoute", aaVar);
        x.i("MicroMsg.AppBrandPage", "onAppRoute: %s, %s", new Object[]{aaVar.toString(), getCurrentUrl()});
    }

    public final void alJ() {
        a("onAppRouteDone", null);
        x.i("MicroMsg.AppBrandPage", "onAppRouteDone: %s", new Object[]{getCurrentUrl()});
    }

    protected static boolean d(int[] iArr, int i) {
        if (iArr == null || iArr.length == 0) {
            return true;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public void onSwipe(float f) {
        if (this.gmD) {
            if (f != 1.0f) {
                setVisibility(0);
            } else {
                hide();
            }
        }
        if (Float.compare(1.0f, f) <= 0) {
            i.n(getContentView(), 0.0f);
            return;
        }
        i.n(getContentView(), (((float) (getContentView().getWidth() / 4)) * (1.0f - f)) * -1.0f);
    }

    public void onSettle(boolean z, int i) {
        long j = 110;
        View contentView;
        if (z) {
            contentView = getContentView();
            if (i <= 0) {
                j = 220;
            }
            i.a(contentView, j, 0.0f, null);
            return;
        }
        contentView = getContentView();
        if (i <= 0) {
            j = 220;
        }
        i.a(contentView, j, (float) ((getContentView().getWidth() * -1) / 4), null);
    }

    public boolean forceRemoveNoMatchOnPath() {
        return false;
    }

    public void onSwipeBack() {
        n nVar = this.fcz;
        nVar.runOnUiThread(new 18(nVar, this));
        com.tencent.mm.plugin.appbrand.report.a.a(getAppId(), getCurrentUrl(), 23, null, bi.VE(), 1, 0);
        MMActivity mMActivity = getContainer().getRuntime().fcq;
        if (mMActivity != null && mMActivity.isFinishing()) {
            mMActivity.onSwipeBack();
        }
    }

    public void onDrag() {
        this.mSwiping = true;
    }

    public void onCancel() {
        this.mSwiping = false;
    }

    public void agI() {
    }
}
