package com.tencent.mm.plugin.topstory.ui.video;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.System;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.v;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.appbrand.jsapi.h.f;
import com.tencent.mm.plugin.boots.a.b;
import com.tencent.mm.plugin.topstory.a.c;
import com.tencent.mm.plugin.topstory.ui.b$a;
import com.tencent.mm.plugin.topstory.ui.b.d;
import com.tencent.mm.plugin.topstory.ui.b.e;
import com.tencent.mm.plugin.topstory.ui.video.b.a;
import com.tencent.mm.protocal.c.bth;
import com.tencent.mm.protocal.c.bti;
import com.tencent.mm.protocal.c.xe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.FlowLayout;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TopStoryVideoStreamUI extends MMActivity implements c, a {
    private boolean fYk = false;
    private o kXg;
    private ImageButton lAV;
    private View mTX;
    private LinearLayoutManager nCW;
    private RecyclerView oAC;
    private ViewGroup oAD;
    private View oAE;
    private TextView oAF;
    private ProgressDialog oAG;
    private f oAH;
    private l oAI;
    private boolean oAJ = false;
    private long oAK = -1;
    private int oAL;
    private View oAM;
    private View oAN;
    private b oAO;
    private a oAP = new 5(this);
    i oAQ;
    private e oAR;
    private o oAS;
    j oAT;
    private g oAU;
    private View oAV;
    private FlowLayout oAW;
    private List<Integer> oAX = new ArrayList();
    private bth oyK;

    static /* synthetic */ void a(TopStoryVideoStreamUI topStoryVideoStreamUI, int i) {
        boolean z = true;
        x.i("MicroMsg.TopStory.TopStoryVideoStreamUI", "onDeviceOrientationChange, orientation: %s sysOrienOn: %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(System.getInt(topStoryVideoStreamUI.getContentResolver(), "accelerometer_rotation", 0) == 1)});
        if (!(System.getInt(topStoryVideoStreamUI.getContentResolver(), "accelerometer_rotation", 0) == 1)) {
            return;
        }
        if (i == 90 || i == f.CTRL_INDEX) {
            if (topStoryVideoStreamUI.oAQ.jMc) {
                i iVar = topStoryVideoStreamUI.oAQ;
                if (i == 90) {
                    z = false;
                }
                iVar.oAf = z;
                topStoryVideoStreamUI.oAQ.bIc();
            } else if (topStoryVideoStreamUI.oAS.oCg) {
                com.tencent.mm.plugin.topstory.ui.a.c b = h.b(topStoryVideoStreamUI);
                if (b != null) {
                    i iVar2 = topStoryVideoStreamUI.oAQ;
                    n nVar = b.oCJ;
                    if (i == 90) {
                        z = false;
                    }
                    iVar2.a(nVar, z);
                    b.bID();
                }
            }
        } else if ((i == 180 || i == 0) && topStoryVideoStreamUI.oAQ.jMc) {
            topStoryVideoStreamUI.oAQ.bId();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ((com.tencent.mm.plugin.boots.a.c) g.l(com.tencent.mm.plugin.boots.a.c.class)).ch(b.hjy, 885);
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_context");
        this.oyK = new bth();
        try {
            this.oyK.aG(byteArrayExtra);
        } catch (IOException e) {
            finish();
        }
        ((com.tencent.mm.plugin.topstory.a.b) g.n(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUICreate();
        this.oAU = new g();
        this.oAQ = new i();
        this.oAR = new e();
        this.oAR.ozW = this;
        this.oAS = new o();
        this.oAT = new j();
        if (!this.fYk) {
            this.oAO = new b(this);
            this.oAO.enable();
            this.oAO.ozK = this.oAP;
            this.fYk = true;
        }
        overridePendingTransition(MMFragmentActivity.a.tnC, MMFragmentActivity.a.tnD);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0));
            getSupportActionBar().hide();
        }
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(b$a.fts_recommend_video_list_bg_color));
        }
        i iVar = this.oAQ;
        iVar.oAb = this;
        iVar.oAh = null;
        iVar.oAg = null;
        iVar.oAf = false;
        iVar.jMc = false;
        this.oAT.oAb = this;
        g gVar = this.oAU;
        gVar.oAb = this;
        gVar.oAc = com.tencent.mm.plugin.topstory.a.g.Os(bHT().sqA);
        this.oAS.oAb = this;
        this.oAC = (RecyclerView) findViewById(d.video_recycle_view);
        this.nCW = new com.tencent.mm.plugin.topstory.ui.a.b();
        this.oAI = new l(this, this.oyK);
        l lVar = this.oAI;
        View inflate = LayoutInflater.from(this).inflate(e.top_story_video_header, null);
        inflate.setClickable(false);
        inflate.setFocusableInTouchMode(false);
        inflate.setFocusable(false);
        View findViewById = inflate.findViewById(d.header_border_view);
        View findViewById2 = inflate.findViewById(d.header_layout);
        if (this.oyK.sqN != null) {
            findViewById.setVisibility(8);
            findViewById2.setVisibility(0);
            this.oAF = (TextView) inflate.findViewById(d.header_title_tv);
            this.oAF.setText(this.oyK.sqN.title);
            TextView textView = (TextView) inflate.findViewById(d.sub_header_title_tv);
            if (bi.oW(this.oyK.sqN.hwC)) {
                textView.setVisibility(8);
            } else {
                textView.setText(this.oyK.sqN.hwC);
            }
        } else {
            findViewById.setVisibility(0);
            findViewById2.setVisibility(8);
        }
        inflate.setLayoutParams(new LayoutParams(-1, -2));
        lVar.addHeaderView(inflate);
        l lVar2 = this.oAI;
        View inflate2 = LayoutInflater.from(this).inflate(e.top_story_video_list_loading_footer, null);
        inflate2.setPadding(0, 0, 0, ((com.tencent.mm.bp.a.fl(this.mController.tml) * 2) / 5) - getResources().getDimensionPixelSize(com.tencent.mm.plugin.topstory.ui.b.b.top_story_video_list_header_height));
        inflate2.setLayoutParams(new LayoutParams(-1, -2));
        this.oAN = inflate2.findViewById(d.footer_loading_tv);
        this.oAM = inflate2.findViewById(d.footer_progress_bar);
        lVar2.cW(inflate2);
        this.oAC.setAdapter(this.oAI);
        this.oAC.setLayoutManager(this.nCW);
        this.oAC.setItemAnimator(new v());
        this.oAC.a(new 1(this));
        this.mTX = findViewById(d.title_container);
        this.oAE = findViewById(d.title_tv);
        if (this.oyK.sqN != null) {
            this.oAE.setVisibility(8);
        }
        this.oAT.oAl = 2;
        this.oAD = (ViewGroup) findViewById(d.fullscreen_holder);
        this.oAQ.oAh = this.oAD;
        this.lAV = (ImageButton) findViewById(d.back_btn);
        this.lAV.getDrawable().setColorFilter(getResources().getColor(b$a.white), Mode.SRC_ATOP);
        this.lAV.setOnClickListener(new 2(this));
        if (!bIh()) {
            this.oAN.setVisibility(4);
            this.oAM.setVisibility(4);
        } else if (this.oAR.isConnected()) {
            bIg();
            this.oAJ = false;
            if (this.oyK.scene != 21 && this.oyK.sqN == null) {
                this.oAG = h.a(this, getString(com.tencent.mm.plugin.topstory.ui.b.g.loading_tips), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        TopStoryVideoStreamUI.this.finish();
                    }
                });
            }
        } else {
            Toast.makeText(this, com.tencent.mm.plugin.topstory.ui.b.g.recommend_video_init_not_network_failed_hint, 1).show();
            this.oAJ = true;
        }
        this.oAI.oAs = true;
        if (this.oyK.sqP) {
            this.oAR.ozV = true;
        }
        this.oAC.post(new 4(this));
        com.tencent.mm.plugin.websearch.api.a.a.kB(13);
    }

    protected void onResume() {
        super.onResume();
        ((com.tencent.mm.plugin.topstory.a.b) g.n(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIResume();
        o oVar = this.oAS;
        if (oVar.oCd != null) {
            oVar.oCd.SM();
            if (oVar.oCe != null) {
                oVar.oCe.bIq();
            }
        }
        i iVar = this.oAQ;
        if (iVar.jMc) {
            iVar.bIc();
        }
        this.oAR.ozX = e.bIa();
        com.tencent.mm.plugin.websearch.api.a.a.kB(14);
    }

    protected void onPause() {
        super.onPause();
        o oVar = this.oAS;
        if (oVar.oCd != null) {
            oVar.oCd.SL();
        }
        ((com.tencent.mm.plugin.topstory.a.b) g.n(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIPause();
        com.tencent.mm.plugin.websearch.api.a.a.kB(15);
    }

    protected void onDestroy() {
        bth bth = this.oyK;
        if (cql() > 0) {
            x.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryVideoPageBrowseTime 15018 %s", new Object[]{String.format("%s,%s,%s,%s", new Object[]{Integer.valueOf(bth.scene), Long.valueOf(cql()), Long.valueOf(bth.sqL), Integer.valueOf(3)})});
            com.tencent.mm.plugin.report.service.h.mEJ.k(15018, r0);
        }
        if (this.oAI != null) {
            g.DF().b(1943, this.oAI.dKj);
        }
        if (this.fYk) {
            this.oAO.disable();
            this.oAO.ozK = null;
            this.oAO = null;
        }
        ((com.tencent.mm.plugin.topstory.a.b) g.n(com.tencent.mm.plugin.topstory.a.b.class)).onVideoListUIDestroy(this.oyK);
        o oVar = this.oAS;
        if (oVar.oCd != null) {
            oVar.stopPlay();
            oVar.oCd.ajZ();
        }
        oVar.oAb = null;
        i iVar = this.oAQ;
        iVar.oAb = null;
        iVar.oAh = null;
        iVar.oAg = null;
        iVar.oAf = false;
        iVar.jMc = false;
        e eVar = this.oAR;
        g.Eh().b(eVar.hKh);
        eVar.ozW = null;
        eVar.ozX = 0;
        eVar.ozV = false;
        j jVar = this.oAT;
        jVar.bIe();
        jVar.oAb = null;
        g gVar = this.oAU;
        gVar.oAd.clear();
        com.tencent.mm.sdk.f.e.post(new g.a(gVar, gVar.oAc), "TopStory.DeleteVideoCacheTask");
        gVar.oAb = null;
        com.tencent.mm.plugin.websearch.api.a.a.kB(16);
        super.onDestroy();
    }

    public final int getForceOrientation() {
        if (this.oAQ.jMc) {
            return 0;
        }
        return 1;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        k kVar = k.oAn;
        if (i == 1024) {
            if (i2 == -1) {
                Toast.makeText(ad.getContext(), com.tencent.mm.plugin.topstory.ui.b.g.app_shared, 1).show();
                com.tencent.mm.plugin.topstory.a.h.a(bHT(), kVar.oAo, "1", q.GF(), "");
            }
        } else if (i == 2048 && i2 == -1) {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("SendMsgUsernames");
            if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                StringBuilder stringBuilder = new StringBuilder("");
                StringBuilder stringBuilder2 = new StringBuilder("");
                Iterator it = stringArrayListExtra.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (s.fq(str)) {
                        stringBuilder.append(3);
                        stringBuilder.append(";");
                    } else {
                        stringBuilder.append(2);
                        stringBuilder.append(";");
                    }
                    stringBuilder2.append(str);
                    stringBuilder2.append(";");
                }
                com.tencent.mm.plugin.topstory.a.h.a(bHT(), kVar.oAo, stringBuilder.toString(), q.GF(), stringBuilder2.toString());
            }
        }
        if (i == 10001 && this.oAR.aEY()) {
            com.tencent.mm.plugin.topstory.ui.a.c a = h.a(this);
            if (a != null) {
                a.iE(false);
            }
        }
    }

    private void bIf() {
        this.oAN.setVisibility(0);
        this.oAM.setVisibility(0);
        this.oAK = bi.VG();
        this.oAI.yh(this.oAI.oAr.size());
    }

    private void bIg() {
        this.oAN.setVisibility(0);
        this.oAM.setVisibility(0);
        this.oAI.yh(0);
    }

    public final void dM(int i, int i2) {
        if ((i2 == 2 || i2 == 1) && this.oAJ) {
            bIg();
        }
        i iVar = this.oAQ;
        if (iVar.jMc) {
            iVar.oAg.dN(i, i2);
        }
        o oVar = this.oAS;
        if (i == 0) {
            if (oVar.oCg && oVar.oCj) {
                oVar.oCj = false;
                oVar.bGR();
            }
        } else if (i2 == 0 && oVar.oCg && oVar.bIB()) {
            oVar.oCj = true;
            oVar.bAf();
        }
        if (!this.oAQ.jMc) {
            com.tencent.mm.plugin.topstory.ui.a.c a = h.a(this);
            if (a != null) {
                a.oCJ.dN(i, i2);
            }
        }
    }

    protected final int getLayoutId() {
        return e.top_story_video_stream_ui;
    }

    public final MMActivity baA() {
        return this;
    }

    public final void bHK() {
        this.mTX.animate().alpha(0.1f).setDuration(200).setStartDelay(3000);
        if (this.oyK.sqN != null && this.oAF != null) {
            this.oAF.animate().alpha(0.1f).setDuration(200).setStartDelay(3000);
        }
    }

    public final void bHL() {
        this.mTX.animate().cancel();
        this.mTX.setAlpha(1.0f);
        if (this.oyK.sqN != null && this.oAF != null) {
            this.oAF.setAlpha(1.0f);
        }
    }

    public final void ye(int i) {
        x.i("MicroMsg.TopStory.TopStoryVideoStreamUI", "tryToPlayPositionVideo %d", new Object[]{Integer.valueOf(i)});
        this.oAC.smoothScrollToPosition(this.oAI.oAp.size() + i);
    }

    public final void yf(int i) {
        x.i("MicroMsg.TopStory.TopStoryVideoStreamUI", "selectPosition %d", new Object[]{Integer.valueOf(i)});
        this.nCW.Q(this.oAI.oAp.size() + i, 0);
    }

    public final void a(f fVar) {
        this.oAH = fVar;
        if (this.oAQ.jMc && !this.oAI.oAu) {
            bIf();
        }
    }

    public final void bHM() {
        this.oAN.setVisibility(4);
        this.oAM.setVisibility(4);
        if (this.oAG != null) {
            this.oAG.dismiss();
            this.oAG = null;
        }
        if (this.oAH != null) {
            this.oAH.bIb();
            this.oAH = null;
        }
    }

    public final void Ou(String str) {
        this.oAN.setVisibility(4);
        this.oAM.setVisibility(4);
        if (this.oAG != null) {
            this.oAG.dismiss();
            this.oAG = null;
        }
        if (!ao.isNetworkConnected(this)) {
            Toast.makeText(this, getString(com.tencent.mm.plugin.topstory.ui.b.g.recommend_video_fetch_network_failed), 1).show();
        } else if (bi.oW(str)) {
            Toast.makeText(this, getString(com.tencent.mm.plugin.topstory.ui.b.g.recommend_video_fetch_server_failed), 1).show();
        } else {
            Toast.makeText(this, str, 1).show();
        }
    }

    public final boolean bHN() {
        return this.oAI.oAu;
    }

    public final List<bti> bHO() {
        return this.oAI.oAr;
    }

    public final RecyclerView bAt() {
        return this.oAC;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        com.tencent.mm.plugin.topstory.ui.a.c b;
        if (i == 25 && keyEvent.getAction() == 0) {
            if (this.oAQ.jMc) {
                this.oAQ.oAg.bIu();
            } else {
                b = h.b(this);
                if (!(b == null || b.oCJ == null)) {
                    b.oCJ.bIu();
                }
            }
        } else if (i == 24 && keyEvent.getAction() == 0) {
            if (this.oAQ.jMc) {
                this.oAQ.oAg.setMute(false);
            } else {
                b = h.b(this);
                if (!(b == null || b.oCJ == null)) {
                    b.oCJ.setMute(false);
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void onBackPressed() {
        if (this.oAQ.jMc) {
            this.oAQ.bId();
        } else {
            super.onBackPressed();
        }
    }

    public final int bHP() {
        return this.oAL;
    }

    public final void yg(int i) {
        this.oAL = i;
    }

    public final i bHQ() {
        return this.oAQ;
    }

    public final e bHR() {
        return this.oAR;
    }

    public final o bHS() {
        return this.oAS;
    }

    public final bth bHT() {
        return this.oyK;
    }

    public final j bHU() {
        return this.oAT;
    }

    public final g bHV() {
        return this.oAU;
    }

    public final String bHW() {
        return com.tencent.mm.plugin.topstory.a.g.Os(this.oyK.sqA);
    }

    public void onFeedBackItemClick(View view) {
        bti bti = (bti) view.getTag();
        if (this.kXg == null) {
            View inflate = LayoutInflater.from(this).inflate(e.top_story_feedback_layout, null);
            this.kXg = new o(inflate, com.tencent.mm.bp.a.fk(this), -2);
            this.kXg.setFocusable(true);
            this.oAW = (FlowLayout) inflate.findViewById(d.fb_content_fl);
            this.oAV = inflate.findViewById(d.disincline_btn);
            this.oAV.setOnClickListener(new 6(this));
        }
        this.oAV.setTag(bti);
        this.oAX.clear();
        this.oAW.removeAllViews();
        for (int i = 0; i < bti.sre.size(); i++) {
            xe xeVar = (xe) bti.sre.get(i);
            View inflate2 = LayoutInflater.from(this).inflate(e.top_story_feedback_content_item, this.oAW, false);
            CheckBox checkBox = (CheckBox) inflate2.findViewById(d.item_cb);
            checkBox.setTag(Integer.valueOf(i));
            checkBox.setText(xeVar.bSc);
            checkBox.setOnCheckedChangeListener(new 7(this));
            this.oAW.addView(inflate2);
        }
        this.kXg.showAsDropDown(view, 0, 0);
    }

    protected final boolean bIh() {
        if (this.oyK.scene == 36) {
            return false;
        }
        return true;
    }

    public final boolean bHX() {
        return bIh();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }
}
