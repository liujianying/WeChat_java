package com.tencent.mm.plugin.fts.ui;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.g.a.sh;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.j.b;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.d;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.e.i;
import java.util.HashMap;
import java.util.Map;

@a(3)
public class FTSMainUI extends FTSBaseVoiceSearchUI implements com.tencent.mm.modelgeo.a.a {
    long ghF;
    private Dialog iwc;
    private int jsZ;
    int jvZ = -1;
    private FTSMainUIEducationLayout jwW;
    private LinearLayout jwX;
    private LinearLayout jwY;
    private LinearLayout jwZ;
    private View jxa;
    private View jxb;
    private FTSLocalPageRelevantView jxc;
    private TextView jxd;
    private TextView jxe;
    private View jxf;
    private View jxg;
    private TextView jxh;
    private String jxi;
    private Map<String, Integer> jxj = new HashMap();
    private j jxk;
    private b jxl = new 6(this);
    private d jxm = new 3(this);
    private OnClickListener jxn = new 5(this);
    private c<tt> jxo = new 13(this);

    static /* synthetic */ void b(FTSMainUI fTSMainUI, String str) {
        com.tencent.mm.plugin.fts.ui.c.b bVar = fTSMainUI.jxk.jwK;
        bVar.jzl = fTSMainUI.jxk.getBlockCount() + 1;
        int count = fTSMainUI.jxk.getCount();
        int i = fTSMainUI.jsZ;
        int i2 = com.tencent.mm.plugin.fts.a.d.Cx(str) ? 8 : 9;
        int i3 = count + 1;
        long currentTimeMillis = System.currentTimeMillis() - bVar.jyY;
        if (currentTimeMillis < 0 || bVar.jyY == 0) {
            currentTimeMillis = 0;
        }
        x.v("MicroMsg.FTS.FTSReportLogic", "report home page click: %d, %s", new Object[]{Integer.valueOf(10991), String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(currentTimeMillis), Integer.valueOf(bVar.jzb), Integer.valueOf(bVar.jzc), Integer.valueOf(bVar.jzd), Integer.valueOf(bVar.jze), Integer.valueOf(bVar.jzf), Integer.valueOf(bVar.jzg), Integer.valueOf(bVar.jzh), Integer.valueOf(bVar.jzj), Integer.valueOf(bVar.jzk), e.jqM, str, Integer.valueOf(bVar.jzi), Integer.valueOf(bVar.jzl)})});
        x.i("MicroMsg.FTS.FTSReportLogic", "lxl, click blockpos:" + bVar.jzl);
        h.mEJ.k(10991, r0);
        j jVar = fTSMainUI.jxk;
        jVar.jwG = true;
        if (!bi.oW(jVar.bWm)) {
            ad.h(jVar.bWm, jVar.jvU, 1, 3);
        }
        if (str != null && str.length() != 0 && str.trim().length() != 0) {
            fTSMainUI.jvZ = Character.isDigit(str.charAt(0)) ? 15 : 3;
            11 11 = new 11(fTSMainUI, str);
            g.DF().a(s$l.AppCompatTheme_ratingBarStyle, 11);
            f fVar = new f(str, 3);
            g.DF().a(fVar, 0);
            fTSMainUI.getString(n.g.app_tip);
            fTSMainUI.iwc = com.tencent.mm.ui.base.h.a(fTSMainUI, fTSMainUI.getString(n.g.search_contact_doing), true, new 12(fTSMainUI, fVar, 11));
        }
    }

    static /* synthetic */ void d(FTSMainUI fTSMainUI) {
        fTSMainUI.jxk.jwG = true;
        String str = fTSMainUI.bWm;
        if (str != null && !bi.oW(str.trim()) && System.currentTimeMillis() - fTSMainUI.ghF > 1000) {
            fTSMainUI.ghF = System.currentTimeMillis();
            ((com.tencent.mm.plugin.websearch.api.f) g.l(com.tencent.mm.plugin.websearch.api.f.class)).b(fTSMainUI.mController.tml, 3, str, e.jqM);
            ad.Ac(3);
            if (!bi.oW(fTSMainUI.bWm)) {
                ad.h(fTSMainUI.bWm, 2, 2, 3);
            }
            fTSMainUI.jxa.setEnabled(false);
            com.tencent.mm.plugin.fts.ui.c.b bVar = fTSMainUI.jxk.jwK;
            if (fTSMainUI.jxf == null || fTSMainUI.jxf.getVisibility() != 0) {
                bVar.jzl = fTSMainUI.jxk.getBlockCount() + 1;
            } else {
                bVar.jzl = fTSMainUI.jxk.getBlockCount() + 2;
            }
            int count = fTSMainUI.jxk.getCount();
            int i = fTSMainUI.jsZ;
            int i2 = count + 1;
            long currentTimeMillis = System.currentTimeMillis() - bVar.jyY;
            if (currentTimeMillis < 0 || bVar.jyY == 0) {
                currentTimeMillis = 0;
            }
            x.v("MicroMsg.FTS.FTSReportLogic", "report home page click: %d, %s", new Object[]{Integer.valueOf(10991), String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(i), Integer.valueOf(18), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(currentTimeMillis), Integer.valueOf(bVar.jzb), Integer.valueOf(bVar.jzc), Integer.valueOf(bVar.jzd), Integer.valueOf(bVar.jze), Integer.valueOf(bVar.jzf), Integer.valueOf(bVar.jzg), Integer.valueOf(bVar.jzh), Integer.valueOf(bVar.jzj), Integer.valueOf(bVar.jzk), e.jqM, str, Integer.valueOf(bVar.jzi), Integer.valueOf(bVar.jzl)})});
            x.i("MicroMsg.FTS.FTSReportLogic", "lxl, click blockpos:" + bVar.jzl);
            h.mEJ.k(10991, r0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(n.d.action_bar_container), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        cqh();
        e.jqM = p.zK(3);
        x.d("MicroMsg.FTS.FTSReportLogic", "reportFTSEnterClick: %d, %s", new Object[]{Integer.valueOf(10991), String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(this.jsZ), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), e.jqM, ""})});
        h.mEJ.k(10991, r0);
        this.jwW = (FTSMainUIEducationLayout) findViewById(n.d.search_education_layout);
        this.jwZ = (LinearLayout) findViewById(n.d.search_loading_view);
        this.jwW.setOnCellClickListener(this.jxn);
        this.jwW.setOnHotwordClickListener(new 1(this));
        this.jwW.setNeedHotWord(false);
        g.l(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
        com.tencent.mm.modelgeo.c.OB().a(this, true);
        if (((n) g.n(n.class)).getFTSImageLoader() == null) {
            finish();
            return;
        }
        ((n) g.n(n.class)).getFTSImageLoader().aPO();
        r.zZ(3);
        com.tencent.mm.sdk.b.a.sFg.a(this.jxo);
    }

    public void onBackPressed() {
        finish();
    }

    protected final void aQB() {
        switch (getIntent().getIntExtra("from_tab_index", -1)) {
            case 0:
                this.jsZ = 1;
                return;
            case 1:
                this.jsZ = 2;
                return;
            case 2:
                this.jsZ = 3;
                return;
            case 3:
                this.jsZ = 4;
                return;
            default:
                this.jsZ = 0;
                return;
        }
    }

    protected final boolean aQH() {
        return w.chM();
    }

    protected final d a(e eVar) {
        this.jxk = new j(eVar, this.jsZ, this.jxl);
        return this.jxk;
    }

    protected final int getLayoutId() {
        return n.e.fts_main_ui;
    }

    public final void a(com.tencent.mm.plugin.fts.a.d.a.a aVar) {
    }

    protected void onDestroy() {
        com.tencent.mm.modelgeo.c.OB().c(this);
        if (((n) g.n(n.class)).getFTSImageLoader() != null) {
            ((n) g.n(n.class)).getFTSImageLoader().aPP();
        }
        com.tencent.mm.sdk.b.a.sFg.c(this.jxo);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        sh shVar = new sh();
        shVar.cdd.btC = 0;
        com.tencent.mm.sdk.b.a.sFg.m(shVar);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        sendBroadcast(intent);
        if (this.jxa != null) {
            this.jxa.setEnabled(true);
        }
        if (!bi.oW(this.jxi)) {
            this.bWm = this.jxi;
            this.jxi = null;
        }
        p.bSQ();
    }

    public void finish() {
        int i = 100;
        if (!this.mController.hideVKB()) {
            i = 0;
        }
        ah.i(new 7(this), (long) i);
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        x.i("MicroMsg.FTS.FTSMainUI", "onGetLocation %b %f|%f", new Object[]{Boolean.valueOf(z), Float.valueOf(f), Float.valueOf(f2)});
        com.tencent.mm.modelgeo.c.OB().c(this);
        return false;
    }

    private void aQO() {
        this.jwW.setVisibility(0);
        this.jwW.aL();
    }

    private void aQP() {
        this.jwW.setVisibility(8);
    }

    protected final void aQI() {
        super.aQI();
        aQP();
        this.jwZ.setVisibility(8);
    }

    protected final void aQJ() {
        super.aQJ();
        aQO();
        this.jwZ.setVisibility(8);
    }

    protected final void aQG() {
        super.aQG();
        aQO();
        this.jwZ.setVisibility(8);
    }

    protected final void aQF() {
        super.aQF();
        aQP();
        this.jwZ.setVisibility(8);
    }

    protected final void aQE() {
        super.aQE();
        aQP();
        this.jwZ.setVisibility(8);
        this.jwh.setVisibility(0);
        this.jwj.setVisibility(8);
    }

    protected final void aQD() {
        super.aQD();
        aQP();
        this.jwZ.setVisibility(8);
    }

    public final View ayg() {
        if (this.jwX == null) {
            this.jwX = (LinearLayout) getLayoutInflater().inflate(n.e.fts_loading_footer, null);
            this.jxd = (TextView) this.jwX.findViewById(n.d.search_network_tv);
            this.jxe = (TextView) this.jwX.findViewById(n.d.fts_on_search_network_tv);
            try {
                x.i("MicroMsg.FTS.FTSMainUI", "set searchNetworkTips %s", new Object[]{r.PX("webSearchBar").optString("wording")});
                this.jxe.setText(r0);
            } catch (Exception e) {
            }
            this.jxb = this.jwX.findViewById(n.d.search_network_divider);
            this.jxa = this.jwX.findViewById(n.d.search_network_layout);
            this.jxa.setOnClickListener(new 8(this));
            this.jxc = new FTSLocalPageRelevantView(this);
            this.jxc.setOnRelevantClickListener(new 9(this));
            int indexOfChild = this.jwX.indexOfChild(this.jxa);
            if (indexOfChild >= 0 && indexOfChild < this.jwX.getChildCount()) {
                this.jwX.addView(this.jxc, indexOfChild + 1);
            }
            this.jxh = (TextView) this.jwX.findViewById(n.d.search_contact_tv);
            this.jxg = this.jwX.findViewById(n.d.search_contact_divider);
            this.jxf = this.jwX.findViewById(n.d.search_contact_layout);
            this.jxf.setOnClickListener(new 10(this));
            this.jwY = (LinearLayout) this.jwX.findViewById(n.d.footer_layout);
        }
        return this.jwX;
    }

    public final boolean pj(String str) {
        return super.pj(str);
    }

    protected final void aQK() {
        if (this.jwY != null) {
            this.jwY.setVisibility(0);
        }
    }

    protected final void aQL() {
        if (this.jwY != null) {
            this.jwY.setVisibility(8);
        }
    }

    public final void a(boolean z, String[] strArr, long j, int i) {
        super.a(z, strArr, j, i);
        if (z) {
            if (strArr == null || strArr.length <= 0) {
                e.qf(2);
            } else {
                e.qf(1);
            }
            com.tencent.mm.bg.d.e(this, ".ui.voicesearch.VoiceSearchResultUI", new Intent().putExtra("VoiceSearchResultUI_Resultlist", strArr).putExtra("VoiceSearchResultUI_VoiceId", j).putExtra("VoiceSearchResultUI_ShowType", i));
            return;
        }
        e.qf(4);
        com.tencent.mm.bg.d.e(this, ".ui.voicesearch.VoiceSearchResultUI", new Intent().putExtra("VoiceSearchResultUI_Resultlist", new String[0]).putExtra("VoiceSearchResultUI_Error", this.mController.tml.getString(n.g.search_contact_iap_err)).putExtra("VoiceSearchResultUI_VoiceId", j).putExtra("VoiceSearchResultUI_ShowType", i));
    }

    public final void K(int i, boolean z) {
        super.K(i, z);
        this.jxc.setVisibility(8);
        if (!z && i == 0 && this.jxk.jwS) {
            this.jwZ.setVisibility(0);
        } else {
            this.jwZ.setVisibility(8);
        }
        if (z) {
            boolean Cx = com.tencent.mm.plugin.fts.a.d.Cx(this.bWm);
            boolean Cy = com.tencent.mm.plugin.fts.a.d.Cy(this.bWm);
            if (i > 0) {
                if (Cx || Cy) {
                    this.jxg.setVisibility(0);
                }
                this.jxb.setVisibility(0);
            } else {
                this.jxg.setVisibility(8);
                if (Cx || Cy) {
                    this.jxb.setVisibility(0);
                } else {
                    this.jxb.setVisibility(8);
                }
            }
            if (Cx || Cy) {
                this.jxf.setVisibility(0);
            }
            this.jxa.setVisibility(0);
            if (this.bWm != null && this.bWm.length() > 0) {
                ((com.tencent.mm.plugin.websearch.api.e) g.l(com.tencent.mm.plugin.websearch.api.e.class)).a(this.bWm, this.jxm);
                return;
            }
            return;
        }
        this.jxa.setVisibility(8);
        this.jxf.setVisibility(8);
    }

    protected final void aQy() {
        super.aQy();
        this.jxd.setText(j.a(this, com.tencent.mm.plugin.fts.a.f.a(getString(n.g.fts_on_search_network), "", com.tencent.mm.plugin.fts.a.a.d.b(this.bWm, this.bWm)).jrO, com.tencent.mm.bp.a.ad(this, n.b.NormalTextSize)));
        CharSequence charSequence = null;
        if (com.tencent.mm.plugin.fts.a.d.Cx(this.bWm)) {
            charSequence = com.tencent.mm.plugin.fts.a.f.a(getString(n.g.fts_find_phone_qq_tip_prefix), "", com.tencent.mm.plugin.fts.a.a.d.b(this.bWm, this.bWm)).jrO;
        } else if (com.tencent.mm.plugin.fts.a.d.Cy(this.bWm)) {
            charSequence = com.tencent.mm.plugin.fts.a.f.a(getString(n.g.fts_find_wxid_tip_prefix), "", com.tencent.mm.plugin.fts.a.a.d.b(this.bWm, this.bWm)).jrO;
        }
        this.jxh.setText(j.a(this, charSequence, com.tencent.mm.bp.a.ad(this, n.b.NormalTextSize)));
    }

    public void onClickWxApp(View view) {
        if (view.getTag().equals("more-click")) {
            ((com.tencent.mm.plugin.appbrand.n.g) g.l(com.tencent.mm.plugin.appbrand.n.g.class)).a((Context) this, e.jqM, com.tencent.mm.plugin.appbrand.n.g.a.gsN);
        } else if (view.getTag().equals("more-swipe")) {
            ((com.tencent.mm.plugin.appbrand.n.g) g.l(com.tencent.mm.plugin.appbrand.n.g.class)).a((Context) this, e.jqM, com.tencent.mm.plugin.appbrand.n.g.a.gsO);
        } else {
            ((com.tencent.mm.plugin.appbrand.n.g) g.l(com.tencent.mm.plugin.appbrand.n.g.class)).a((Context) this, (com.tencent.mm.plugin.appbrand.n.g.c) view.getTag(), e.jqM);
        }
    }
}
