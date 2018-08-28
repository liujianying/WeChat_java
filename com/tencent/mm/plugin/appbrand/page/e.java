package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.appbrand.config.a.f;
import com.tencent.mm.plugin.appbrand.q.l;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.widget.c;
import com.tencent.mm.plugin.appbrand.widget.c.2;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class e extends l {
    private String gmq;
    private LinearLayout gmr;
    private FrameLayout gms;
    private c gmt;
    private FrameLayout gmu;
    private p gmv = getContainer().getPreloadedPageView();
    private Map<String, p> gmw = new HashMap();
    private LinkedList<b> gmx = new LinkedList();

    public e(Context context, n nVar) {
        super(context, nVar);
    }

    protected final View agC() {
        if (this.gmr == null) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new LayoutParams(-1, -1));
            this.gms = new FrameLayout(getContext());
            this.gms.setLayoutParams(new LayoutParams(-1, -2));
            this.gmu = new FrameLayout(getContext());
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
            layoutParams.weight = 1.0f;
            this.gmu.setLayoutParams(layoutParams);
            this.gmt = alG();
            if ("top".equals(getContainer().getAppConfig().foP.fpa)) {
                linearLayout.addView(this.gms);
                linearLayout.addView(this.gmt);
                linearLayout.addView(this.gmu);
            } else {
                linearLayout.addView(this.gms);
                linearLayout.addView(this.gmu);
                linearLayout.addView(this.gmt);
            }
            this.gmr = linearLayout;
        }
        return this.gmr;
    }

    private c alG() {
        c cVar = new c(getContext());
        com.tencent.mm.plugin.appbrand.config.a.e eVar = getContainer().getAppConfig().foP;
        cVar.setPosition(eVar.fpa);
        cVar.h(eVar.dxh, eVar.fpb, eVar.fpc, eVar.fpd);
        Iterator it = eVar.bUX.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            String str = fVar.url;
            String str2 = fVar.text;
            String str3 = fVar.bWP;
            String str4 = fVar.fpe;
            c$a c_a = new c$a();
            try {
                c_a.sq = c.we(str3);
                c_a.gEv = c.we(str4);
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandPageTabBar", e.getMessage());
            }
            c_a.gEw = str2;
            c_a.mUrl = str;
            if (c_a.gEw == null && (c_a.sq == null || c_a.gEv == null)) {
                x.e("MicroMsg.AppBrandPageTabBar", "illegal data");
            } else {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(cVar.getContext()).inflate(h.app_brand_tab_bar_item, cVar.gEg, false);
                cVar.a(viewGroup, c_a);
                viewGroup.setOnClickListener(new 2(cVar));
                cVar.gEl.add(c_a);
                cVar.gEg.addView(viewGroup);
            }
        }
        cVar.setClickListener(new 1(this, eVar));
        return cVar;
    }

    public final c getTabBar() {
        return this.gmt;
    }

    public final void loadUrl(String str) {
        if (!str.equals(this.gmq)) {
            int wf = this.gmt.wf(str);
            if (wf >= 0) {
                this.gmq = str;
                this.gmt.lU(wf);
                if (this.gmw.get(l.vP(str)) == null) {
                    p uU = uU(l.vP(str));
                    agH();
                    2 2 = new 2(this, str);
                    uU.a(new 3(this, uU, 2, System.currentTimeMillis()));
                    if (this.gmw.size() > 1) {
                        this.gmx.add(2);
                        postDelayed(2, 500);
                    }
                    uU.sX(str);
                    return;
                }
                alH();
                uV(str);
            }
        }
    }

    private synchronized p uU(String str) {
        p pVar;
        if (this.gmv != null) {
            pVar = this.gmv;
            this.gmv = null;
        } else {
            pVar = getContainer().getPreloadedPageView();
        }
        this.gmw.put(str, pVar);
        this.gmu.addView(pVar.getContentView(), 0);
        pVar.agX();
        this.gms.addView(pVar.gnn.getActionView(), 0);
        return pVar;
    }

    private void uV(String str) {
        p pVar = (p) this.gmw.get(l.vP(str));
        pVar.getContentView().setVisibility(4);
        p pVar2 = null;
        for (p pVar3 : this.gmw.values()) {
            p pVar32;
            if (pVar32.getContentView().getVisibility() != 0) {
                pVar32 = pVar2;
            }
            pVar2 = pVar32;
        }
        this.gms.removeAllViews();
        pVar.agX();
        pVar.getContentView().setVisibility(0);
        if (this.gms.indexOfChild(pVar.gnn.getActionView()) == -1) {
            this.gms.addView(pVar.gnn.getActionView(), 0);
        }
        if (pVar2 != null) {
            pVar2.getContentView().setVisibility(4);
        }
        pVar.agL();
        if (pVar2 != null) {
            pVar2.agK();
        }
        agG();
    }

    private void alH() {
        Iterator it = this.gmx.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            removeCallbacks(bVar);
            bVar.Ju = true;
        }
        this.gmx.clear();
    }

    protected final void agG() {
        super.agG();
        getCurrentPageView().cF(getContainer().getAppConfig().foN.adV());
    }

    public final boolean sV(String str) {
        return this.gmt.wf(str) != -1;
    }

    public final void agE() {
        super.agE();
        getCurrentPageView().agL();
    }

    public final void agF() {
        super.agF();
        getCurrentPageView().agK();
    }

    protected final void agD() {
        super.agD();
        if (this.gmv != null) {
            this.gmv.onDestroy();
        }
        for (p onDestroy : this.gmw.values()) {
            onDestroy.onDestroy();
        }
    }

    public final void b(String str, String str2, int[] iArr) {
        if (this.gmv != null && d(iArr, this.gmv.hashCode())) {
            this.gmv.j(str, str2, 0);
        }
        for (p pVar : this.gmw.values()) {
            if (d(iArr, pVar.hashCode())) {
                pVar.j(str, str2, 0);
            }
        }
    }

    public final void cleanup() {
        super.cleanup();
        if (this.gmv != null) {
            this.gmv.cleanup();
        }
        for (p cleanup : this.gmw.values()) {
            cleanup.cleanup();
        }
        alH();
    }

    public final synchronized p getCurrentPageView() {
        p pVar;
        if (this.gmv != null) {
            pVar = this.gmv;
        } else {
            pVar = (p) this.gmw.get(l.vP(this.gmq));
        }
        return pVar;
    }

    public final String getCurrentUrl() {
        return this.gmq;
    }
}
