package com.tencent.mm.plugin.topstory.ui.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.g.a.rq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.h;
import com.tencent.mm.plugin.topstory.ui.a;
import com.tencent.mm.plugin.topstory.ui.b.f;
import com.tencent.mm.plugin.topstory.ui.webview.TopStoryWebView;
import com.tencent.mm.plugin.topstory.ui.webview.d;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.protocal.c.bte;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.smtt.sdk.WebView;

public class b implements a {
    protected bte ccA;
    protected ThreeDotsLoadingView gzp;
    protected FrameLayout nED;
    protected d ozA;
    protected View ozB;
    protected c<rq> ozC = new 5(this);
    protected MMActivity ozw;
    protected boolean ozx;
    protected com.tencent.mm.plugin.topstory.ui.webview.b ozy;
    protected TopStoryWebView ozz;

    public b(MMActivity mMActivity, boolean z) {
        this.ozw = mMActivity;
        this.ozx = z;
    }

    public void onCreate(Bundle bundle) {
        x.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "onCreate");
        this.ccA = new bte();
        try {
            this.ccA.aG(this.ozw.getIntent().getByteArrayExtra("key_context"));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TopStory.TopStoryUIComponentImpl", e, "initData use intent", new Object[0]);
            if (bundle != null) {
                try {
                    this.ccA.aG(bundle.getByteArray("key_context"));
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.TopStory.TopStoryUIComponentImpl", e2, "initData use savedInstanceState", new Object[0]);
                }
            }
        }
        if (bi.oW(this.ccA.sqA)) {
            x.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "Create HomeContext Fail");
            this.ozw.finish();
        } else {
            x.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "Create HomeContext Success %s", new Object[]{this.ccA.sqA});
        }
        this.ozC.cht();
        ad.Ad(17);
        this.ozw.setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                b.this.bHH();
                return true;
            }
        });
        this.nED = (FrameLayout) this.ozw.findViewById(com.tencent.mm.plugin.topstory.ui.b.d.webview_container);
        if (((a) g.n(a.class)).getWebViewMgr() != null) {
            if (!((a) g.n(a.class)).getWebViewMgr().ozJ) {
                ((a) g.n(a.class)).getWebViewMgr().a(this.ccA);
            }
            ((a) g.n(a.class)).getWebViewMgr().a(this);
        } else {
            d dVar = new d();
            dVar.a(this.ccA);
            dVar.a(this);
        }
        this.ozB = this.ozw.findViewById(com.tencent.mm.plugin.topstory.ui.b.d.splash_view);
        this.gzp = (ThreeDotsLoadingView) this.ozw.findViewById(com.tencent.mm.plugin.topstory.ui.b.d.loading_view);
        if (VERSION.SDK_INT >= 21 && !com.tencent.mm.ui.statusbar.d.Af()) {
            this.ozw.getWindow().setStatusBarColor(this.ozw.getResources().getColor(com.tencent.mm.plugin.topstory.ui.b.a.websearch_bg));
            this.ozw.cqc();
        }
        this.ozw.setMMTitle(this.ccA.sqD);
        this.ozw.nS(WebView.NIGHT_MODE_COLOR);
        this.ozw.cqf();
        this.ozw.lF(Color.parseColor("#F2F2F2"));
        this.gzp.cAG();
        if (bHI()) {
            this.ozw.addIconOptionMenu(0, f.actionbar_icon_dark_search, new 2(this));
        }
        try {
            this.ozw.setTitleBarDoubleClickListener(new 3(this));
        } catch (Throwable th) {
        }
        com.tencent.mm.plugin.topstory.ui.d.c(this.ccA, "uiOnCreate", System.currentTimeMillis());
    }

    public final boolean yd(int i) {
        if (i != 4) {
            return false;
        }
        bHH();
        return true;
    }

    protected final void bHH() {
        h.a(this.ccA, "uiBackBtnClick", System.currentTimeMillis());
        ad.Ad(19);
        if (this.ozx) {
            this.ozw.finish();
        } else {
            this.ozw.moveTaskToBack(true);
        }
    }

    protected final void onResume() {
        h.a(this.ccA, "uiOnResume", System.currentTimeMillis());
        this.ozA.Ox("onResume");
    }

    protected final void onPause() {
        h.a(this.ccA, "uiOnPause", System.currentTimeMillis());
        this.ozA.Ox("onPause");
    }

    protected final void onDestroy() {
        bte bte = this.ccA;
        if (this.ozw.cql() > 0) {
            x.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryHomePageBrowseTime 15018 %s", new Object[]{String.format("%s,%s,%s,%s", new Object[]{Integer.valueOf(bte.scene), Long.valueOf(this.ozw.cql()), Integer.valueOf(bte.bxk), Integer.valueOf(bte.sqC)})});
            com.tencent.mm.plugin.report.service.h.mEJ.k(15018, r0);
        }
        h.a(this.ccA, "uiOnDestroy", System.currentTimeMillis());
        ad.Ad(18);
        com.tencent.mm.plugin.topstory.ui.webview.b bVar = this.ozy;
        bVar.oCq = null;
        bVar.oCs = null;
        g.DF().b(1943, bVar);
        this.ozC.dead();
    }

    protected final void onNewIntent(Intent intent) {
        bte bte = new bte();
        try {
            bte.aG(intent.getByteArrayExtra("key_context"));
        } catch (Exception e) {
            this.ozw.finish();
        }
        this.ccA.bJK = bte.bJK;
        this.ccA.bWr = bte.bWr;
        this.ccA.scene = bte.scene;
        this.ccA.kJG = bte.kJG;
        h.a(this.ccA, "uiOnNewIntent", System.currentTimeMillis());
        ad.Ad(20);
        this.ozA.Ox("onNewIntent");
    }

    public final MMActivity baA() {
        return this.ozw;
    }

    public final void bHG() {
        ah.A(new Runnable() {
            public final void run() {
                b.this.gzp.cAH();
                b.this.ozB.setVisibility(8);
                b.this.ozz.setVisibility(0);
            }
        });
    }

    protected boolean bHI() {
        return true;
    }

    public final void Ot(String str) {
        this.ozA.Ot(str);
    }

    public final void a(com.tencent.mm.plugin.topstory.ui.webview.b bVar, TopStoryWebView topStoryWebView, d dVar, bte bte) {
        this.ozy = bVar;
        this.ozz = topStoryWebView;
        this.ozA = dVar;
        this.ozA.oCq = this;
        this.ccA = bte;
        this.ozy.oCq = this;
        this.nED.addView(this.ozz, new LayoutParams(-1, -1));
    }

    protected final void onSaveInstanceState(Bundle bundle) {
        try {
            bundle.putByteArray("key_context", this.ccA.toByteArray());
            x.i("MicroMsg.TopStory.TopStoryUIComponentImpl", "onSaveInstanceState %s", new Object[]{this.ccA.sqA});
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TopStory.TopStoryUIComponentImpl", e, "onSaveInstanceState", new Object[0]);
        }
    }
}
