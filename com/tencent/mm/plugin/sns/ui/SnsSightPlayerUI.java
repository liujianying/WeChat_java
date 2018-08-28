package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.px;
import com.tencent.mm.g.a.py;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.model.d;
import com.tencent.mm.model.m;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.a.b.h;
import com.tencent.mm.plugin.sns.a.b.j.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.o;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bri;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.av;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

@a(3)
public class SnsSightPlayerUI extends MMActivity implements d.a, b {
    private float aaZ = 0.0f;
    private float aba = 0.0f;
    private String bNH = "";
    private String bOX = "";
    private VelocityTracker cE;
    private ate caK = null;
    private int ccR = 0;
    public k contextMenuHelper;
    private boolean dDR = false;
    private String dXA = "";
    private int duration = 0;
    private d gbl;
    private GestureDetector gbw;
    Bundle hDg;
    private boolean hDh = false;
    f hDi;
    private int hDj = 0;
    private int hDk = 0;
    private int hDl = 0;
    private int hDm = 0;
    com.tencent.mm.pluginsdk.ui.tools.f hEl = null;
    n.d hqV = new 6(this);
    private boolean huc = false;
    private int iYO = 0;
    private String imagePath = "";
    private TextView jcm = null;
    private boolean jcp = false;
    private ImageView jdG;
    private float nTE = 1.0f;
    private int nTF = 0;
    private int nTG = 0;
    private boolean nZf = false;
    private boolean nZh = false;
    private boolean nZi = false;
    private boolean nZj = false;
    private int ncW = 0;
    private TextView ndP = null;
    private boolean ndQ = false;
    ViewGroup ndZ;
    private int neh = 0;
    private int nei = 0;
    public int nep = 0;
    private boolean nkG = false;
    private h oaT = new h("SnsSightPlayerUI");
    private String oaU = "";
    private TextView oaV = null;
    private MMPinProgressBtn oaW = null;
    private com.tencent.mm.plugin.sns.storage.n oaX = null;
    private String oaY = "";
    private RelativeLayout oaZ;
    OnCreateContextMenuListener oba = new 5(this);
    private int scene = 0;

    public void onCreate(Bundle bundle) {
        String s;
        if (getIntent().getExtras() != null) {
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        }
        this.scene = getIntent().getIntExtra("intent_from_scene", -1);
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        this.mController.hideTitleView();
        af.byj().a(this);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(c.black));
        }
        if (com.tencent.mm.compatible.util.d.fR(19)) {
            getWindow().setFlags(201327616, 201327616);
        } else {
            getWindow().setFlags(1024, 1024);
        }
        this.hDg = bundle;
        this.gbl = new d();
        this.dXA = getIntent().getStringExtra("intent_videopath");
        this.imagePath = getIntent().getStringExtra("intent_thumbpath");
        this.bNH = getIntent().getStringExtra("intent_localid");
        this.nkG = getIntent().getBooleanExtra("intent_isad", false);
        this.oaX = af.byo().Nl(this.bNH);
        if (this.nkG) {
            boolean z;
            if (this.oaX == null) {
                z = false;
            } else {
                this.caK = (ate) this.oaX.bAJ().sqc.ruA.get(0);
                s = an.s(af.getAccSnsPath(), this.caK.ksA);
                this.oaY = s + i.k(this.caK);
                this.bOX = s + i.e(this.caK);
                z = true;
            }
            if (!z) {
                finish();
                return;
            }
        }
        if (com.tencent.mm.p.a.vv() != null) {
            com.tencent.mm.p.a.vv().xv();
        }
        this.oaT.njm = bi.VG();
        this.oaZ = (RelativeLayout) findViewById(com.tencent.mm.plugin.sns.i.f.content_root);
        this.oaZ.setOnTouchListener(new 1(this));
        x.d("MicroMsg.SnsSightPlayerUI", g.Ab() + " initView: fullpath:" + this.dXA + ", imagepath:" + this.imagePath);
        this.hDi = new f(this.mController.tml);
        this.jdG = (ImageView) findViewById(com.tencent.mm.plugin.sns.i.f.gallery_bg);
        this.jdG.setLayerType(2, null);
        this.ndP = (TextView) findViewById(com.tencent.mm.plugin.sns.i.f.tips_tv);
        this.oaW = (MMPinProgressBtn) findViewById(com.tencent.mm.plugin.sns.i.f.sight_downloading_pb);
        this.ndZ = (ViewGroup) findViewById(com.tencent.mm.plugin.sns.i.f.video_container);
        this.hEl = o.fb(this.mController.tml);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.jcm = (TextView) findViewById(com.tencent.mm.plugin.sns.i.f.show_ad_sight);
        this.ndZ.addView((View) this.hEl, 0, layoutParams);
        this.oaV = (TextView) findViewById(com.tencent.mm.plugin.sns.i.f.time_counter_tv);
        this.oaV.setText("");
        if (!this.nkG) {
            this.oaV.setVisibility(8);
        }
        if (this.nkG) {
            if (this.caK == null) {
                this.jcm.setVisibility(8);
            } else if (bi.oW(this.caK.rVL)) {
                x.i("MicroMsg.SnsSightPlayerUI", "onCreate: there is no attachurl, show more info btn");
                bsu bAJ = this.oaX.bAJ();
                com.tencent.mm.plugin.sns.storage.b bAF = this.oaX.bAF();
                CharSequence charSequence = bAF.nyM;
                String str = bAF.nyN;
                if (bi.oW(charSequence) || bi.oW(str)) {
                    this.jcm.setVisibility(8);
                } else {
                    this.jcm.setVisibility(0);
                    this.jcm.setText(charSequence);
                    this.jcm.setOnClickListener(new 7(this, bAJ, str));
                }
            } else {
                s = getResources().getString(j.sns_ad_sight_full);
                if (this.caK.oig / 60 > 0) {
                    s = s + getResources().getString(j.sns_ad_sight_full_m, new Object[]{Integer.valueOf(this.caK.oig / 60)});
                }
                if (this.caK.oig % 60 > 0) {
                    s = s + getResources().getString(j.sns_ad_sight_full_s, new Object[]{Integer.valueOf(this.caK.oig % 60)});
                }
                this.jcm.setText(s + getResources().getString(j.sns_ad_sight_full_end));
                this.jcm.setVisibility(0);
                this.jcm.setOnClickListener(new 8(this));
            }
            com.tencent.mm.pluginsdk.ui.tools.n.a(this.jcm, (VideoSightView) this.hEl);
        } else {
            this.jcm.setVisibility(8);
        }
        this.hEl.setVideoCallback(new com.tencent.mm.pluginsdk.ui.tools.f.a() {
            public final void iy() {
                x.d("MicroMsg.SnsSightPlayerUI", g.Ab() + " onPrepared");
                SnsSightPlayerUI.this.hL(true);
            }

            public final void onError(int i, int i2) {
                x.e("MicroMsg.SnsSightPlayerUI", "on play video error, what %d extra %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                SnsSightPlayerUI.this.hEl.stop();
                if (!SnsSightPlayerUI.this.jcp) {
                    SnsSightPlayerUI.this.jcp = true;
                    com.tencent.mm.sdk.a.b.A(Base64.encodeToString((com.tencent.mm.plugin.sight.base.d.bvD() + "[SnsSightPlayerUI] on play video error, what " + i + " extra " + i2 + ", path=" + bi.aG(SnsSightPlayerUI.this.imagePath, "")).getBytes(), 2), "FullScreenPlaySight");
                    String c = SnsSightPlayerUI.this.imagePath;
                    ah.A(new 1(this, com.tencent.mm.ak.o.Pf().a(c, com.tencent.mm.bp.a.getDensity(SnsSightPlayerUI.this.mController.tml), SnsSightPlayerUI.this.mController.tml, -1), c));
                }
            }

            public final void wd() {
                x.d("MicroMsg.SnsSightPlayerUI", "on completion");
                if (!SnsSightPlayerUI.this.nkG) {
                    SnsSightPlayerUI.this.ndP.post(new 2(this));
                }
                SnsSightPlayerUI.this.hEl.setLoop(true);
                com.tencent.mm.plugin.sns.a.b.a.a aVar = SnsSightPlayerUI.this.oaT.njs;
                aVar.nkp++;
                SnsSightPlayerUI.this.hL(false);
            }

            public final int ck(int i, int i2) {
                return 0;
            }

            public final void cl(int i, int i2) {
            }
        });
        findViewById(com.tencent.mm.plugin.sns.i.f.video_container).setOnClickListener(new 10(this));
        ((View) this.hEl).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                SnsSightPlayerUI.this.ayH();
            }
        });
        this.gbw = new GestureDetector(this.mController.tml, new 12(this));
        ((View) this.hEl).setOnTouchListener(new 13(this));
        if (FileOp.cn(this.dXA)) {
            if (this.dXA != null) {
                this.hEl.stop();
                this.hEl.setVideoPath(this.dXA);
            }
            this.oaW.setVisibility(8);
            this.oaT.njk = 1;
        } else {
            af.byj().a(this.caK, 6, null, av.tbu);
            this.oaW.setVisibility(0);
            this.oaW.cAt();
            this.oaT.njk = 0;
        }
        x.d("MicroMsg.SnsSightPlayerUI", (System.currentTimeMillis() - currentTimeMillis) + " initView end");
        rz rzVar = new rz();
        rzVar.ccO.type = 1;
        com.tencent.mm.sdk.b.a.sFg.m(rzVar);
        if (this.contextMenuHelper == null) {
            this.contextMenuHelper = new k(this.mController.tml);
        }
        this.contextMenuHelper.a((View) this.hEl, this.oba, this.hqV);
        ((View) this.hEl).post(new 14(this));
    }

    public void finish() {
        if (!this.dDR) {
            super.finish();
            this.dDR = true;
        }
    }

    private void hL(boolean z) {
        this.hEl.start();
        this.duration = this.hEl.getDuration();
        x.i("MicroMsg.SnsSightPlayerUI", "startplay get duration " + this.duration);
        this.gbl.a(this);
        if (z) {
            this.oaT.njs.nkt = getResources().getConfiguration().orientation == 2 ? 2 : 1;
            this.oaT.njs.nku = bi.VG();
            this.oaT.njs.nks = 2;
        }
    }

    private void bAf() {
        x.i("MicroMsg.SnsSightPlayerUI", "snsSightplayui pauseplay");
        this.hEl.pause();
        this.hEl.onDetach();
        this.gbl.bv(false);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.sns.i.g.sns_sight_player_ui;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.nkG) {
            String str;
            int i;
            int i2;
            if (this.oaX == null) {
                str = "";
            } else {
                str = this.oaX.bBn();
            }
            String bwN = this.oaT.bwN();
            if (this.oaX == null) {
                i = 0;
            } else {
                i = this.oaX.bBq();
            }
            long j = ((long) this.oaT.njl) - this.oaT.egP;
            if (j < 0) {
                x.e("MicroMsg.SnsSightPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[]{Integer.valueOf(this.oaT.njl), Long.valueOf(this.oaT.egP)});
                j = (long) this.oaT.njl;
            }
            int i3 = (int) j;
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.ab.o oVar = com.tencent.mm.kernel.g.Eh().dpP;
            if (this.scene == 0) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            oVar.a(new com.tencent.mm.plugin.sns.a.b.d(str, i2, 2, this.oaT.njl, null, null, 2, bwN, -1, i, i3, i3, 0), 0);
        }
        x.d("MicroMsg.SnsSightPlayerUI", "on dismiss");
        if (this.nkG && this.oaX != null && this.oaX.xb(32)) {
            com.tencent.mm.plugin.sns.a.b.j.a(com.tencent.mm.plugin.sns.a.b.j.b.njT, com.tencent.mm.plugin.sns.a.b.j.a.njO, this.oaX);
        }
        af.byj().b(this);
        com.tencent.mm.modelsns.b p = com.tencent.mm.modelsns.b.p(getIntent());
        if (p != null) {
            if (this.nkG) {
                p.bP(!bi.oW(this.caK.rVL));
            } else {
                p.bP(false);
            }
            p.update();
            p.RD();
        }
        if (com.tencent.mm.p.a.vv() != null) {
            com.tencent.mm.p.a.vv().xu();
        }
        if (this.hEl != null) {
            this.hEl.setVideoCallback(null);
            this.hEl.stop();
            this.hEl.onDetach();
        }
        if (!this.ndQ) {
            rz rzVar = new rz();
            rzVar.ccO.type = 0;
            rzVar.ccO.ccP = this.ncW;
            rzVar.ccO.ccQ = this.iYO;
            rzVar.ccO.ccR = this.ccR;
            com.tencent.mm.sdk.b.a.sFg.m(rzVar);
        }
        this.gbl.bv(false);
    }

    public void onStart() {
        Bundle bundle = this.hDg;
        if (!this.hDh) {
            this.hDh = true;
            if (VERSION.SDK_INT >= 12) {
                this.hDj = getIntent().getIntExtra("img_gallery_top", 0);
                this.hDk = getIntent().getIntExtra("img_gallery_left", 0);
                this.hDl = getIntent().getIntExtra("img_gallery_width", 0);
                this.hDm = getIntent().getIntExtra("img_gallery_height", 0);
                this.hDi.u(this.hDk, this.hDj, this.hDl, this.hDm);
                if (bundle == null) {
                    this.ndZ.getViewTreeObserver().addOnPreDrawListener(new 3(this));
                }
            }
        }
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
        if (!this.huc) {
            x.i("MicroMsg.SnsSightPlayerUI", "initOrientation " + getResources().getConfiguration().orientation);
            if (getResources().getConfiguration().orientation == 2) {
                U(getResources().getConfiguration().orientation, true);
            }
            this.huc = true;
        }
        if (this.nei == 0 || this.neh == 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.nei = displayMetrics.heightPixels;
            this.neh = displayMetrics.widthPixels;
        }
        if (this.nZf && FileOp.cn(this.dXA)) {
            hL(false);
            this.nZf = false;
        }
        if (this.oaT != null) {
            this.oaT.onResume();
        }
    }

    public void onPause() {
        super.onPause();
        int i = getResources().getConfiguration().orientation;
        x.i("MicroMsg.SnsSightPlayerUI", "onpause  " + i);
        xy(i);
        if (this.nZf) {
            bAf();
        } else {
            bAf();
            x.v("check", "onclick");
            new ag().post(new 2(this));
        }
        if (this.oaT != null) {
            this.oaT.egO = bi.VG();
        }
    }

    public final void ayH() {
        int width = this.ndZ.getWidth();
        int height = this.ndZ.getHeight();
        if (!(this.hDl == 0 || this.hDm == 0)) {
            height = (int) ((((float) width) / ((float) this.hDl)) * ((float) this.hDm));
        }
        this.hDi.fh(width, height);
        this.hDi.u(this.hDk, this.hDj, this.hDl, this.hDm);
        if (((double) this.nTE) != 1.0d) {
            width = ak.gs(this.mController.tml);
            this.hDi.uzR = 1.0f / this.nTE;
            if (!(this.nTF == 0 && this.nTG == 0)) {
                this.hDi.fi(((int) (((float) (this.ndZ.getWidth() / 2)) * (1.0f - this.nTE))) + this.nTF, (int) ((((float) ((width + this.ndZ.getHeight()) / 2)) - (((float) (height / 2)) * this.nTE)) + ((float) this.nTG)));
            }
        }
        this.hDi.a(this.ndZ, this.jdG, new 4(this), null);
    }

    public void onBackPressed() {
        ayH();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (4097 == i) {
            if (-1 == i2) {
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                for (String str : bi.F(stringExtra.split(","))) {
                    if (this.scene == 0) {
                        com.tencent.mm.plugin.sns.storage.n Nl = af.byo().Nl(this.bNH);
                        if (Nl != null) {
                            if (s.fq(str)) {
                                px pxVar = new px();
                                pxVar.caD.bSZ = i.g(Nl);
                                pxVar.caD.bKW = Nl.bBe();
                                com.tencent.mm.sdk.b.a.sFg.m(pxVar);
                            } else {
                                py pyVar = new py();
                                pyVar.caE.bSZ = i.g(Nl);
                                pyVar.caE.bKW = Nl.bBe();
                                com.tencent.mm.sdk.b.a.sFg.m(pyVar);
                            }
                        }
                    }
                    bsu bAJ = this.oaX.bAJ();
                    if (this.nkG) {
                        com.tencent.mm.plugin.sns.storage.b bAF = this.oaX.bAF();
                        bri bri = new bri();
                        bri.rBq = this.caK.oig;
                        bri.dyJ = this.caK.rVL;
                        if (bAJ.sqc.ruz == 15) {
                            bri.dyP = this.oaX.bAH().ntU;
                            bri.dyQ = bAJ.ksA;
                        } else {
                            bri.dyP = bAJ.sqh.dyP;
                            bri.dyQ = bAJ.sqh.dyQ;
                        }
                        bri.dyL = bi.oW(this.caK.rVP) ? bAJ.spZ : this.caK.rVP;
                        if (bi.oW(this.caK.rVO)) {
                            stringExtra = this.caK.rVE;
                        } else {
                            stringExtra = this.caK.rVO;
                        }
                        bri.dyO = stringExtra;
                        if (bAF != null && bAF.nyL == 0) {
                            bri.dyN = bAF.nyN;
                            bri.dyM = bAF.nyM;
                        }
                        if (bAF != null) {
                            bri.dyN = bAF.nxZ;
                        }
                        x.i("MicroMsg.SnsSightPlayerUI", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d streamvideothumburl %s, duration: %s", new Object[]{str, this.dXA, this.imagePath, this.caK.rVL, Integer.valueOf(this.caK.oig), bri.dyO, Integer.valueOf(i.LQ(this.dXA))});
                        com.tencent.mm.plugin.messenger.a.g.bcT().a(this, str, this.dXA, this.imagePath, 43, r6, bri, bAJ.nNV);
                    } else {
                        x.i("MicroMsg.SnsSightPlayerUI", "send sight to %s, videopath %s, thumbpath %s, duration: %s", new Object[]{str, this.dXA, this.imagePath, Integer.valueOf(i.LQ(this.dXA))});
                        com.tencent.mm.plugin.messenger.a.g.bcT().a(this, str, this.dXA, this.imagePath, 43, r6, bAJ.nNV);
                    }
                    if (stringExtra2 != null) {
                        com.tencent.mm.plugin.messenger.a.g.bcT().dF(stringExtra2, str);
                    }
                    com.tencent.mm.ui.widget.snackbar.b.h(this, getString(j.has_send));
                    if (this.nkG) {
                        com.tencent.mm.plugin.sns.a.b.j.c cVar;
                        int gK;
                        com.tencent.mm.plugin.sns.a.b.c cVar2 = new com.tencent.mm.plugin.sns.a.b.c(this.oaX.bBn(), 12, 5, "", 2, this.oaX.bAK());
                        com.tencent.mm.kernel.g.Ek();
                        com.tencent.mm.kernel.g.Eh().dpP.a(cVar2, 0);
                        boolean fq = s.fq(str);
                        com.tencent.mm.plugin.sns.a.b.j.d dVar = com.tencent.mm.plugin.sns.a.b.j.d.nke;
                        if (fq) {
                            cVar = com.tencent.mm.plugin.sns.a.b.j.c.nkb;
                        } else {
                            cVar = com.tencent.mm.plugin.sns.a.b.j.c.nka;
                        }
                        e eVar = e.nkl;
                        if (fq) {
                            gK = m.gK(str);
                        } else {
                            gK = 0;
                        }
                        com.tencent.mm.plugin.sns.a.b.j.a(dVar, cVar, eVar, gK, this.oaX);
                    }
                }
            } else if (this.nkG) {
                com.tencent.mm.plugin.sns.a.b.c cVar3 = new com.tencent.mm.plugin.sns.a.b.c(this.oaX.bBn(), 13, 5, "", 2, this.oaX.bAK());
                com.tencent.mm.kernel.g.Ek();
                com.tencent.mm.kernel.g.Eh().dpP.a(cVar3, 0);
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void LR(String str) {
    }

    public final void aS(String str, boolean z) {
    }

    public final void bxb() {
    }

    public final void aT(String str, boolean z) {
        x.i("MicroMsg.SnsSightPlayerUI", "onSightFinish " + str);
        if (this.nkG && !bi.oW(str) && this.caK != null && str.equals(this.caK.ksA) && FileOp.cn(this.dXA)) {
            this.oaT.njk = 1;
            this.hEl.setVideoPath(this.dXA);
            hL(true);
            if (this.oaW != null) {
                this.oaW.setVisibility(8);
            }
        }
    }

    protected final int getForceOrientation() {
        return 7;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        x.i("MicroMsg.SnsSightPlayerUI", "onConfigurationChanged " + configuration.orientation + " " + this.nep);
        if (this.nep != configuration.orientation) {
            int i = configuration.orientation;
            U(configuration.orientation, false);
            this.nep = configuration.orientation;
        }
    }

    private void U(int i, boolean z) {
        if (this.nei == 0 || this.neh == 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.nei = displayMetrics.heightPixels;
            this.neh = displayMetrics.widthPixels;
        }
        LayoutParams layoutParams = this.ndZ.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.oaV.getLayoutParams();
        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        if (i == 1) {
            layoutParams3.width = this.neh;
            layoutParams3.height = (int) (((((double) this.neh) * 1.0d) * 240.0d) / 320.0d);
            layoutParams2.addRule(12, 0);
            layoutParams2.addRule(1, 0);
            layoutParams2.addRule(11, -1);
            layoutParams2.addRule(3, this.ndZ.getId());
            findViewById(com.tencent.mm.plugin.sns.i.f.tips_tv).setVisibility(0);
        } else {
            layoutParams3.height = this.neh;
            layoutParams3.width = (int) (((((double) this.neh) * 1.0d) * 320.0d) / 240.0d);
            layoutParams2.addRule(11, 0);
            layoutParams2.addRule(3, 0);
            layoutParams2.addRule(12, -1);
            layoutParams2.addRule(1, this.ndZ.getId());
            findViewById(com.tencent.mm.plugin.sns.i.f.tips_tv).setVisibility(8);
        }
        x.i("MicroMsg.SnsSightPlayerUI", "orientation " + i + " " + layoutParams3.width + " " + layoutParams3.height);
        ((View) this.hEl).setLayoutParams(layoutParams3);
        if (this.hEl instanceof com.tencent.mm.plugin.sight.decode.a.a) {
            ((com.tencent.mm.plugin.sight.decode.a.a) this.hEl).dt(layoutParams3.width, layoutParams3.height);
        }
        layoutParams.height = layoutParams3.height;
        layoutParams.width = layoutParams3.width;
        this.ndP.setLayoutParams(layoutParams2);
        this.ndZ.setLayoutParams(layoutParams);
        ((View) this.hEl).requestLayout();
        if (!z) {
            xy(i);
        }
    }

    private void xy(int i) {
        if (this.nkG && this.hEl.isPlaying()) {
            if (this.duration == 0) {
                this.duration = this.hEl.getDuration();
            }
            this.oaT.wh(this.duration);
            this.oaT.njs.nku = bi.VG();
            this.oaT.njs.nkt = i == 2 ? 2 : 1;
            this.oaT.njs.nks = 2;
            x.i("MicroMsg.SnsSightPlayerUI", "duration " + this.duration + " orient " + this.oaT.njs.nkt);
        }
    }
}
