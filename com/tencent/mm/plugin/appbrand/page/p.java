package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.z;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.n;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.k.i;
import com.tencent.mm.plugin.appbrand.menu.k;
import com.tencent.mm.plugin.appbrand.menu.l;
import com.tencent.mm.plugin.appbrand.menu.m;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.s$e;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.widget.f.b;
import com.tencent.mm.plugin.appbrand.widget.input.ad;
import com.tencent.mm.plugin.appbrand.widget.input.f;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.an;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@SuppressLint({"ViewConstructor"})
public class p extends c {
    private volatile boolean Sx = true;
    public g fdO;
    private d fdP;
    public boolean fdT = false;
    protected List<k> gmF;
    private FrameLayout gmu;
    public int gnA = 0;
    private c gnB;
    public final com.tencent.mm.plugin.appbrand.report.a.c gnC = new com.tencent.mm.plugin.appbrand.report.a.c(hashCode());
    public final b gnD = new b(this);
    public final com.tencent.mm.plugin.appbrand.page.a.c gnE = ahg();
    public Runnable gnF = new 1(this);
    private ViewGroup gnG = null;
    Set<g> gnh = Collections.newSetFromMap(new ConcurrentHashMap());
    Set<d> gni = Collections.newSetFromMap(new ConcurrentHashMap());
    Set<f> gnj = Collections.newSetFromMap(new ConcurrentHashMap());
    Set<e> gnk = Collections.newSetFromMap(new ConcurrentHashMap());
    public Set<c> gnl = Collections.newSetFromMap(new ConcurrentHashMap());
    RelativeLayout gnm;
    public com.tencent.mm.plugin.appbrand.widget.actionbar.c gnn;
    AppBrandRecentView gno;
    public com.tencent.mm.plugin.appbrand.widget.actionbar.d gnp;
    u gnq;
    public f gnr;
    public t gns;
    public r gnt;
    private boolean gnu = false;
    boolean gnv = false;
    int gnw;
    boolean gnx = false;
    String gny = null;
    public boolean gnz = false;
    public String mAppId;
    public Context mContext;

    public final void a(Context context, g gVar) {
        boolean z = true;
        this.mContext = context;
        this.fdO = gVar;
        this.mAppId = gVar.mAppId;
        String str = this.mAppId;
        List linkedList = new LinkedList();
        m.b(linkedList, l.gjv - 1, false);
        m.b(linkedList, l.gjw - 1, true);
        m.b(linkedList, l.gjD - 1, false);
        AppBrandSysConfig qa = a.qa(str);
        boolean z2 = !com.tencent.mm.sdk.a.b.chp() && (qa == null || qa.frm.fih == 1);
        m.b(linkedList, l.gjE - 1, z2);
        m.b(linkedList, l.gjF - 1, false);
        m.b(linkedList, l.gjy - 1, false);
        m.b(linkedList, l.gjA - 1, false);
        m.b(linkedList, l.gjI - 1, false);
        m.b(linkedList, l.gjz - 1, false);
        int i = l.gjG - 1;
        if (com.tencent.mm.sdk.a.b.chp()) {
            z = false;
        }
        m.b(linkedList, i, z);
        m.b(linkedList, l.gjH - 1, false);
        m.b(linkedList, l.gjC - 1, false);
        this.gmF = linkedList;
        this.gnC.h(gVar);
        this.gnw = an.n(this.mContext.getResources().getColor(s.d.statusbar_fg_color), context.getResources().getColor(s.d.normal_actionbar_color));
        initView();
    }

    public com.tencent.mm.plugin.appbrand.page.a.c ahg() {
        return VERSION.SDK_INT >= 21 ? new com.tencent.mm.plugin.appbrand.page.a.a(this) : new com.tencent.mm.plugin.appbrand.page.a.b();
    }

    public void initView() {
        int i = 2;
        initActionBar();
        if (this.gns == null) {
            this.gns = new t(this.mContext);
            alN();
        } else if (this.gns.getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) this.gns.getContext()).setBaseContext(this.mContext);
        }
        this.gns.setFullscreenImpl(alO());
        t tVar = this.gns;
        g gVar = this.fdO;
        x.i("MicroMsg.AppBrandWebView", "onRuntimeReady, preLoadWebView %b", new Object[]{Boolean.valueOf(tVar.goC)});
        tVar.fdO = gVar;
        tVar.mAppId = gVar.mAppId;
        if (bi.oW(tVar.mAppId)) {
            x.d("MicroMsg.AppBrandWebView", "doInitWebView mAppId is null");
        } else {
            if (!(!tVar.goC || tVar.fdO == null || tVar.getX5WebViewExtension() == null)) {
                x.i("MicroMsg.AppBrandWebView", "setReferer %s", new Object[]{"https://servicewechat.com/" + tVar.mAppId + "/" + tVar.fdO.fcu.frm.fii + "/page-frame.html"});
                new Bundle().putString(SlookSmartClipMetaTag.TAG_TYPE_URL, r0);
                try {
                    a.a.cJ(tVar.getX5WebViewExtension()).y("invokeMiscMethod", "setReferer", new Bundle());
                } catch (Exception e) {
                    x.e("MicroMsg.AppBrandWebView", "setReferer error " + e);
                }
            }
            com.tencent.mm.plugin.appbrand.k qv = com.tencent.mm.plugin.appbrand.k.qv(tVar.mAppId);
            if (qv != null) {
                qv.fdI.set(true);
            }
            boolean isX5Kernel = tVar.getIsX5Kernel();
            h hVar = h.mEJ;
            if (!isX5Kernel) {
                i = 3;
            }
            hVar.a(482, 482, 1, i, 1, 1, false);
            tVar.gox = i.uQ(tVar.mAppId);
        }
        if (tVar.fwK) {
            tVar.d();
        }
        this.gns.setOnTrimListener(new 3(this));
        if (this.fdT) {
            j("onWxConfigReady", "", 0);
        } else {
            this.gns.init();
        }
        this.gnt = new r(this.mContext, this.gns);
        this.gnt.setOnPullDownListener(new 4(this));
        this.gnt.setOnPullDownOffsetListener(new 5(this));
        this.gmu = new FrameLayout(this.mContext);
        this.gmu.addView(this.gnt);
        r rVar = this.gnt;
        f fVar = new f(this.mContext, this);
        this.gnr = fVar;
        rVar.addView(fVar);
        this.gnt.setOnPullDownOffsetListener(this.gnr);
        this.gns.setOnScrollChangedListener(this.gnr);
        this.gnm = new 12(this, this.mContext);
        this.gnm.setLayoutParams(new LayoutParams(-1, -1));
        if (this.fdO.fcv.foN.adV()) {
            this.gnm.addView(this.gmu, new LayoutParams(-1, -1));
            cF(true);
        } else {
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(10, -1);
            this.gnn.getActionView().setId(s.g.action_bar_root);
            this.gnm.addView(this.gnn.getActionView(), layoutParams);
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, s.g.action_bar_root);
            this.gnm.addView(this.gmu, layoutParams);
        }
        this.gnq = new u(this.gnr);
        ViewGroup viewGroup = (ViewGroup) this.gns.getView();
        fVar = this.gnr;
        viewGroup.setOnTouchListener(new 22(this, fVar, new ad(fVar)));
        this.gnq.setFullscreenImpl(alO());
        com.tencent.mm.plugin.appbrand.widget.input.m.m(this);
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final String getAppId() {
        return this.mAppId;
    }

    public final g getRuntime() {
        return this.fdO;
    }

    public com.tencent.mm.plugin.appbrand.g.b aaI() {
        return this.gns;
    }

    public View getContentView() {
        return this.gnm;
    }

    public final void initActionBar() {
        com.tencent.mm.plugin.appbrand.widget.actionbar.c bVar;
        Context context = this.mContext;
        g gVar = this.fdO;
        int i = (gVar.fcv == null || gVar.fcv.foN == null || !gVar.fcv.foN.adV()) ? 0 : 1;
        if (i != 0 || gVar.aaq()) {
            boolean z;
            if (!gVar.aaq() || gVar.fcv.foR.foW) {
                z = true;
            } else {
                z = false;
            }
            bVar = new com.tencent.mm.plugin.appbrand.widget.actionbar.b(context, z);
        } else {
            bVar = new com.tencent.mm.plugin.appbrand.widget.actionbar.a(context);
        }
        this.gnn = bVar;
        LayoutParams layoutParams = this.gnn.getLayoutParams();
        layoutParams.height = com.tencent.mm.plugin.appbrand.widget.a.cM(this.mContext);
        this.gnn.setLayoutParams(layoutParams);
        this.gnn.setBackButtonClickListener(new 30(this));
        this.gnn.setCloseButtonClickListener(new 31(this));
        this.gnn.setTitleAreaOnDoubleClickListener(new 32(this));
        this.gnn.setOptionButtonClickListener(new 33(this));
        this.gnn.aoZ();
        com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
        this.gno = ((com.tencent.mm.plugin.appbrand.widget.recentview.d) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.appbrand.widget.recentview.d.class)).a(this.mContext, com.tencent.mm.plugin.appbrand.widget.recentview.d.b.gPz, new 34(this));
        this.gnp = new com.tencent.mm.plugin.appbrand.widget.actionbar.d(this.mContext);
        this.gnp.setWidth(-1);
        this.gnp.setBackgroundDrawable(new ColorDrawable());
        if (this.gno != null) {
            this.gno.refresh();
            this.gnp.setHeight(this.gno.getLayoutParams().height);
            this.gno.setBackground(com.tencent.mm.bp.a.f(this.mContext, s.f.app_brand_game_recent_popwindow_background));
            this.gnp.setContentView(this.gno);
            this.gno.setOnItemClickListener(new 35(this));
        } else {
            x.w("MicroMsg.AppBrandPageView", "AppBrandRecentView is null, appId: %s", new Object[]{this.mAppId});
        }
        this.gnn.setCapsuleHomeButtonLongClickListener(new 2(this));
    }

    public final void alN() {
        t tVar = this.gns;
        d dVar = new d(this, this.gns);
        this.fdP = dVar;
        tVar.addJavascriptInterface(dVar, "WeixinJSCore");
        this.gns.addJavascriptInterface(new a(this, (byte) 0), "__deviceInfo");
    }

    public final c alO() {
        if (this.gnB != null) {
            return this.gnB;
        }
        this.gnB = new c(this.mContext);
        this.gnB.a(new 6(this));
        return this.gnB;
    }

    public FrameLayout aha() {
        return this.gmu;
    }

    public void agX() {
        ViewGroup viewGroup = (ViewGroup) this.gnn.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.gnn.getActionView());
        }
    }

    public u agU() {
        return this.gnq;
    }

    public String getURL() {
        return this.gns.getPagePath();
    }

    public String ahc() {
        return this.gns.getPageURL();
    }

    public void sX(String str) {
        boolean z;
        boolean z2 = false;
        t tVar = this.gns;
        tVar.fCQ = com.tencent.mm.plugin.appbrand.q.l.vP(str);
        tVar.gou = str;
        tVar.goE = false;
        if (ao.b(tVar.fdO, tVar.fCQ)) {
            tVar.goG = System.currentTimeMillis();
            if (tVar.fwK) {
                tVar.vc(tVar.fCQ);
                x.i("MicroMsg.AppBrandWebView", "Frame ready, inject page");
            } else {
                x.i("MicroMsg.AppBrandWebView", "Frame not ready, wait for it");
            }
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (com.tencent.mm.plugin.appbrand.permission.c.b(this, b.gnU)) {
                x.i("MicroMsg.AppBrandPageView", "publishPageNotFound url:%s", new Object[]{str});
                Map hashMap = new HashMap();
                hashMap.put("path", com.tencent.mm.plugin.appbrand.q.l.vP(str));
                hashMap.put("query", com.tencent.mm.plugin.appbrand.q.l.vQ(str));
                if (!(this.fdO == null || this.fdO.fct == null || !str.equals(bi.aG(this.fdO.fct.fqx, "")))) {
                    z2 = true;
                }
                hashMap.put("isEntryPage", Boolean.valueOf(z2));
                com.tencent.mm.plugin.appbrand.r.c.m(hashMap);
                a("onPageNotFound", new com.tencent.mm.v.h(hashMap).toString(), null);
                ah.i(this.gnF, 2000);
                z2 = true;
            }
            if (!z2) {
                alQ();
            }
            onReady();
        }
        this.gnC.vq(str);
        if (z && z.ak(getContentView())) {
            getContentView().post(new Runnable() {
                public final void run() {
                    if (!z.ai(p.this.getContentView())) {
                        p.this.getContentView().forceLayout();
                        ViewParent parent = p.this.getContentView().getParent();
                        do {
                            ((View) parent).forceLayout();
                            parent = parent.getParent();
                        } while (parent instanceof View);
                        if (parent != null) {
                            parent.requestLayout();
                        }
                    }
                }
            });
        }
    }

    public void a(String str, String str2, int[] iArr) {
        if (this.fdO == null) {
            if (this.fdT) {
                com.tencent.mm.plugin.appbrand.l amX = com.tencent.mm.plugin.appbrand.task.d.amX();
                if (amX != null) {
                    amX.j(str, str2, hashCode());
                    return;
                }
            }
            x.i("MicroMsg.AppBrandPageView", "publish runtime is null, event %s", new Object[]{str});
            return;
        }
        this.fdO.fcy.j(str, str2, hashCode());
    }

    public boolean isRunning() {
        return this.Sx;
    }

    public boolean isFullScreen() {
        return this.gnu;
    }

    public final void cleanup() {
        super.cleanup();
        agT();
        this.gnh.clear();
        this.gnk.clear();
        this.gni.clear();
        this.gnj.clear();
        this.gnl.clear();
        if (this.gno != null) {
            this.gno.release();
        }
        if (this.gnp != null) {
            com.tencent.mm.plugin.appbrand.widget.actionbar.d dVar = this.gnp;
            dVar.dismiss();
            if (dVar.gFE != null) {
                dVar.gFE.removeAllViews();
                dVar.gFE = null;
            }
        }
    }

    public void agT() {
        this.gns.destroy();
        this.fdP.cleanup();
    }

    static void runOnUiThread(Runnable runnable) {
        if (ah.isMainThread()) {
            runnable.run();
        } else {
            ah.A(runnable);
        }
    }

    public void show() {
        this.gnm.setVisibility(0);
    }

    public void hide() {
        this.gnm.setVisibility(4);
    }

    public final void a(g gVar) {
        this.gnh.add(gVar);
    }

    public final void b(g gVar) {
        this.gnh.remove(gVar);
    }

    public final void onReady() {
        agO();
        runOnUiThread(new 9(this));
    }

    public void agO() {
        runOnUiThread(new 8(this));
    }

    public final void agL() {
        agP();
        runOnUiThread(new Runnable() {
            public final void run() {
                for (f agL : p.this.gnj) {
                    agL.agL();
                }
            }
        });
    }

    public void agP() {
        this.gns.onResume();
        if (!this.gnu) {
            if (this.fdO.fcE.scene == 1023) {
                alR();
            } else if (this.fdO.aap() || this.fdO.fcz.getPageCount() != 1) {
                this.gnn.setNavHidden(false);
                this.gnn.setNavBackOrClose(true);
            } else {
                alR();
            }
        }
        a.b(this);
        this.gnE.agE();
        if (this.gns.goE) {
            x.i("MicroMsg.AppBrandPageView", "reload page %s", new Object[]{this.gns.getPageURL()});
            this.gns.init();
            sX(this.gns.getPageURL());
            i iVar = new i();
            Map hashMap = new HashMap();
            hashMap.put("path", getURL());
            iVar.x(hashMap).aC(this.mAppId, hashCode()).ahM();
        }
        this.gnC.agL();
        this.gns.setWebViewTitle(va("VISIBLE"));
    }

    public final void a(f fVar) {
        this.gnj.add(fVar);
    }

    public final void b(f fVar) {
        this.gnj.remove(fVar);
    }

    public final void agK() {
        agQ();
        runOnUiThread(new 11(this));
    }

    public void agQ() {
        this.gns.onPause();
        this.gnC.agK();
        this.gns.setWebViewTitle(va("INVISIBLE"));
        this.gnB.alE();
        if (this.gnp != null) {
            this.gnp.dismiss();
        }
    }

    public final void a(d dVar) {
        this.gni.add(dVar);
    }

    public final void b(d dVar) {
        this.gni.remove(dVar);
    }

    public boolean agV() {
        boolean z = false;
        if (this.gnB.alE()) {
            return true;
        }
        if (this.gnl.size() == 0) {
            return false;
        }
        Iterator it = this.gnl.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            if (((c) it.next()).agV()) {
                z = true;
            } else {
                z = z2;
            }
        }
    }

    public final void onDestroy() {
        agR();
        runOnUiThread(new 13(this));
    }

    public void agR() {
        this.Sx = false;
        this.gnC.onDestroy();
    }

    public final void a(e eVar) {
        this.gnk.add(eVar);
    }

    public final void b(e eVar) {
        this.gnk.remove(eVar);
    }

    public final void q(double d) {
        runOnUiThread(new 14(this, d));
    }

    public void sY(String str) {
        runOnUiThread(new 15(this, str));
    }

    public void kp(int i) {
        runOnUiThread(new 16(this, i));
    }

    public void sZ(String str) {
        runOnUiThread(new 17(this, str));
    }

    public String agW() {
        CharSequence mainTitle = this.gnn.getMainTitle();
        return mainTitle != null ? mainTitle.toString() : "";
    }

    public void ta(final String str) {
        runOnUiThread(new Runnable() {
            public final void run() {
                p.this.gnn.setForegroundStyle(str);
            }
        });
    }

    public void kq(int i) {
        runOnUiThread(new 20(this, i));
    }

    public void cD(boolean z) {
        runOnUiThread(new 21(this, z));
    }

    public void cF(boolean z) {
        if (z) {
            agX();
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            layoutParams.rightMargin = com.tencent.mm.bp.a.ae(this.mContext, s$e.app_brand_game_mode_icon_margin_right);
            this.gnm.addView(this.gnn.getActionView(), layoutParams);
        }
    }

    public void agY() {
        runOnUiThread(new Runnable() {
            public final void run() {
                p.this.gnt.cE(true);
                p.this.gnt.alW();
            }
        });
    }

    public void agZ() {
        runOnUiThread(new 24(this));
    }

    public void cE(boolean z) {
        runOnUiThread(new 25(this, z));
    }

    public void bm(String str, String str2) {
        runOnUiThread(new 27(this, str2, str));
    }

    public final void D(int i, boolean z) {
        if (i != 0) {
            List<k> list = this.gmF;
            int i2 = i - 1;
            if (list != null && !list.isEmpty()) {
                for (k kVar : list) {
                    if (kVar != null && kVar.id == i2) {
                        kVar.gju = z;
                        return;
                    }
                }
            }
        }
    }

    public final k lo(int i) {
        return m.e(this.gmF, i - 1);
    }

    public final void alP() {
        O(this.gnw, this.gny);
    }

    public void tb(String str) {
        this.gnx = true;
        this.gny = str;
        runOnUiThread(new 28(this));
    }

    public void kr(int i) {
        this.gnv = true;
        this.gnw = i;
        runOnUiThread(new 29(this));
    }

    final void O(int i, String str) {
        com.tencent.mm.ui.statusbar.a.c(getContentView(), i, "black".equals(str));
    }

    public final void alQ() {
        boolean z = true;
        runOnUiThread(new Runnable() {
            final /* synthetic */ boolean gnO = false;

            public final void run() {
                p.this.gnt.setPullDownEnabled(this.gnO);
            }
        });
        if (this.fdO.fcz.getPageCount() < 2) {
            this.fdO.fcR = true;
        }
        d dVar = new d(this.mContext);
        g gVar = this.fdO;
        d.inflate(dVar.getContext(), s.h.app_brand_error_page_layout, dVar);
        dVar.gmn = (ImageView) dVar.findViewById(s.g.app_brand_error_page_iv);
        dVar.gmo = (TextView) dVar.findViewById(s.g.app_brand_error_page_tips);
        dVar.gmp = (Button) dVar.findViewById(s.g.app_brand_error_page_index);
        dVar.gmo.setText(dVar.getResources().getString(j.app_brand_error_guide, new Object[]{gVar.fcu.bKC}));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) dVar.gmn.getLayoutParams();
        if (gVar.fcv == null || gVar.fcv.foN == null || !gVar.fcv.foN.adV()) {
            z = false;
        }
        if (z || gVar.aaq()) {
            layoutParams.topMargin = com.tencent.mm.bp.a.ae(dVar.getContext(), s$e.app_brand_error_page_top_margin);
            dVar.gmn.setLayoutParams(layoutParams);
            dVar.requestLayout();
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        dVar.gmn.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        com.tencent.mm.modelappbrand.b.b.Ka().a(dVar.gmn, gVar.fcu.fqJ, com.tencent.mm.modelappbrand.b.a.JZ(), com.tencent.mm.modelappbrand.b.f.dGr);
        dVar.gmp.setVisibility(8);
        dVar.setBackgroundColor(-1);
        com.tencent.mm.plugin.appbrand.report.a.G(gVar.fcu.appId, 27, 0);
        this.gmu.addView(dVar);
    }

    private String va(String str) {
        return this.mAppId + ":" + this.gns.getPagePath() + ":" + str;
    }

    private void alR() {
        if (this.fdO.fcz.getPageCount() == 1) {
            this.gnn.setNavHidden(true);
            return;
        }
        this.gnn.setNavHidden(false);
        this.gnn.setNavBackOrClose(true);
    }

    public final void vb(String str) {
        if (str.equalsIgnoreCase("dark")) {
            this.gnz = true;
        } else {
            this.gnz = false;
        }
    }

    public View ahb() {
        if (this.gnA <= 0) {
            return null;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(s.h.appbrand_action_header_layout, null);
        ((TextView) inflate.findViewById(s.g.appbrand_action_header_status)).setText(this.mContext.getResources().getString(this.gnA));
        return inflate;
    }

    public void ks(int i) {
        this.gnA = i;
    }

    public final com.tencent.mm.plugin.appbrand.jsapi.p.a alS() {
        View findViewById = getContentView().findViewById(s.g.app_brand_pageview_html_webview);
        if (findViewById instanceof com.tencent.mm.plugin.appbrand.jsapi.p.a) {
            return (com.tencent.mm.plugin.appbrand.jsapi.p.a) findViewById;
        }
        return null;
    }

    public <T> T a(int i, Bundle bundle, Object... objArr) {
        return null;
    }

    public Bitmap ahe() {
        View view = this.gns.getView();
        if (view == null) {
            return null;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        int scrollX = view.getScrollX();
        int scrollY = view.getScrollY();
        if (width == 0 || height == 0) {
            return null;
        }
        view.scrollTo(0, 0);
        Bitmap c;
        Bitmap createBitmap;
        if (this.gns.isXWalkKernel()) {
            c = c(view, this.gnr);
            createBitmap = Bitmap.createBitmap(c, 0, 0, width, height);
            c.recycle();
            view.postDelayed(new 36(this, view, scrollX, scrollY), 500);
            return createBitmap;
        }
        c = c(view, this.gnr);
        createBitmap = Bitmap.createBitmap(c, 0, 0, width, height);
        c.recycle();
        view.scrollTo(scrollX, scrollY);
        return createBitmap;
    }

    private Bitmap c(View view, View view2) {
        if (view == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = view.getBackground();
        if (background != null) {
            background.draw(canvas);
        }
        if (this.gns.isXWalkKernel()) {
            this.gns.drawCanvas(canvas);
        } else {
            view.draw(canvas);
        }
        if (view instanceof n) {
            return createBitmap;
        }
        com.tencent.mm.sdk.platformtools.c.a(canvas, view2);
        return createBitmap;
    }
}
