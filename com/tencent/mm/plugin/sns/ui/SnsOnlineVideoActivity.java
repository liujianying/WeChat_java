package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.VelocityTracker;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.g.a.px;
import com.tencent.mm.g.a.py;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.av;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.f;

@a(3)
public class SnsOnlineVideoActivity extends MMActivity {
    private float aaZ = 0.0f;
    private float aba = 0.0f;
    private String bNH;
    private String bOX;
    private VelocityTracker cE;
    private ate caK;
    private String dXA;
    private GestureDetector gbw;
    private Bundle hDg;
    private boolean hDh = false;
    private f hDi;
    private int hDj = 0;
    private int hDk = 0;
    private int hDl = 0;
    private int hDm = 0;
    private boolean hEj;
    d hqV = new 3(this);
    private RelativeLayout jdF;
    private ImageView jdG;
    private boolean jdl = true;
    private boolean ldV;
    private com.tencent.mm.ui.widget.a.d nMS;
    private boolean nPn;
    private n nSE;
    private float nTE = 1.0f;
    private int nTF = 0;
    private int nTG = 0;
    private Button nTv;
    private OnlineVideoView nZe;
    private boolean nZf = false;
    private boolean nZg;
    private boolean nZh = false;
    private boolean nZi = false;
    private boolean nZj = false;
    c nZk = new 2(this);
    private int scene = 0;

    public void onCreate(Bundle bundle) {
        if (getIntent().getExtras() != null) {
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        }
        super.onCreate(bundle);
        this.mController.hideTitleView();
        try {
            if (com.tencent.mm.compatible.util.d.fR(19)) {
                getWindow().setFlags(201327616, 201327616);
                this.ldV = true;
            } else {
                getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                this.ldV = false;
            }
            getWindow().addFlags(128);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsOnlineVideoActivity", e, "", new Object[0]);
        }
        this.hDg = bundle;
        this.bOX = getIntent().getStringExtra("intent_thumbpath");
        this.bNH = getIntent().getStringExtra("intent_localid");
        this.scene = getIntent().getIntExtra("intent_from_scene", -1);
        this.nPn = getIntent().getBooleanExtra("intent_ispreview", false);
        this.hEj = getIntent().getBooleanExtra("intent_ismute", false);
        x.i("MicroMsg.SnsOnlineVideoActivity", "init data get intent info finish. thumbPath %s localId %s scene %d isPreView %b isMute %b videoPath %s", new Object[]{this.bOX, this.bNH, Integer.valueOf(this.scene), Boolean.valueOf(this.nPn), Boolean.valueOf(this.hEj), getIntent().getStringExtra("intent_videopath")});
        if (this.nPn) {
            this.dXA = r0;
        } else {
            try {
                this.nSE = af.byo().Nl(this.bNH);
                this.caK = (ate) this.nSE.bAJ().sqc.ruA.get(0);
                this.dXA = an.s(af.getAccSnsPath(), this.caK.ksA) + i.j(this.caK);
                x.i("MicroMsg.SnsOnlineVideoActivity", "init data finish, sns info local id %s ", new Object[]{this.nSE.bBe()});
            } catch (Exception e2) {
                x.e("MicroMsg.SnsOnlineVideoActivity", "init data exception " + e2.toString());
            }
        }
        this.jdF = (RelativeLayout) findViewById(com.tencent.mm.plugin.sns.i.f.video_ui_root);
        this.nZe = (OnlineVideoView) findViewById(com.tencent.mm.plugin.sns.i.f.video_view);
        if (this.nPn) {
            OnlineVideoView onlineVideoView = this.nZe;
            String str = this.dXA;
            String str2 = this.bOX;
            onlineVideoView.nPo = str;
            onlineVideoView.nPn = true;
            onlineVideoView.jdj.setImageBitmap(b.e(str2, 1.0f));
            x.i("MicroMsg.OnlineVideoView", "%d set preview video %s isPreview %b ", new Object[]{Integer.valueOf(onlineVideoView.hashCode()), str, Boolean.valueOf(onlineVideoView.nPn)});
        } else {
            this.nZe.a(this.caK, this.nSE.bBe(), this.nSE.field_createTime);
        }
        this.nZe.setMute(this.hEj);
        this.jdG = (ImageView) findViewById(com.tencent.mm.plugin.sns.i.f.gallery_bg);
        this.jdG.setLayerType(2, null);
        this.jdF.setOnTouchListener(new 1(this));
        this.gbw = new GestureDetector(this.mController.tml, new 4(this));
        this.nZe.setOnTouchListener(new 5(this));
        this.hDi = new f(this.mController.tml);
        n nVar = this.nSE;
        if (nVar == null) {
            x.i("MicroMsg.SnsOnlineVideoActivity", "snsInfo is null, return");
        } else {
            this.nTv = (Button) findViewById(com.tencent.mm.plugin.sns.i.f.game_more_button);
            bsu bAJ = nVar.bAJ();
            av avVar = bAJ != null ? bAJ.nsB : null;
            ay ayVar = new ay();
            ag.a(this, ayVar, bAJ.nsB);
            if (ayVar.ofl) {
                this.nTv.setVisibility(0);
                this.nTv.setText(ayVar.ofm);
                this.nTv.setOnClickListener(new 6(this, avVar, bAJ));
                if (getRequestedOrientation() != 0) {
                    bDF();
                }
            } else {
                this.nTv.setVisibility(8);
            }
        }
        ayJ();
        rz rzVar = new rz();
        rzVar.ccO.type = 1;
        com.tencent.mm.sdk.b.a.sFg.m(rzVar);
    }

    protected final int getLayoutId() {
        return g.sns_video_ui;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            x.d("MicroMsg.SnsOnlineVideoActivity", "vertical orientation");
            bDF();
        } else if (configuration.orientation == 2) {
            x.d("MicroMsg.SnsOnlineVideoActivity", "horizontal orientation");
            if (this.nTv != null && this.nTv.getVisibility() == 0) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.nTv.getLayoutParams();
                if (marginLayoutParams.bottomMargin != getResources().getDimensionPixelSize(com.tencent.mm.plugin.sns.i.d.sns_game_more_button_bottom_margin)) {
                    marginLayoutParams.bottomMargin = getResources().getDimensionPixelSize(com.tencent.mm.plugin.sns.i.d.sns_game_more_button_bottom_margin);
                    this.nTv.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }

    private void bDF() {
        boolean gt = ak.gt(this);
        int gs = ak.gs(this);
        if (this.ldV && gt && this.nTv != null && this.nTv.getVisibility() == 0) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.nTv.getLayoutParams();
            marginLayoutParams.bottomMargin = gs + marginLayoutParams.bottomMargin;
            this.nTv.setLayoutParams(marginLayoutParams);
        }
    }

    private void ayJ() {
        if (this.nPn) {
            x.i("MicroMsg.SnsOnlineVideoActivity", "it is preview mode, don't register menu.");
        } else {
            this.nZe.setOnLongClickListener(new 7(this));
        }
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
                    this.nZe.getViewTreeObserver().addOnPreDrawListener(new 10(this));
                }
            }
        }
        super.onStart();
    }

    protected void onResume() {
        if (VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(2048);
        }
        if (!this.jdl) {
            this.nZe.onResume();
        }
        this.jdl = false;
        if (this.nZf) {
            this.nZf = false;
        }
        super.onResume();
        m.Bk(1);
    }

    protected void onPause() {
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(2048, 2048);
        }
        this.nZe.onPause();
        if (!this.nZf) {
            x.d("MicroMsg.SnsOnlineVideoActivity", "close Popup");
            if (this.nZg) {
                new ag().postDelayed(new Runnable() {
                    public final void run() {
                        SnsOnlineVideoActivity.this.finish();
                    }
                }, 500);
            } else {
                new ag().post(new 9(this));
            }
        }
        super.onPause();
        m.Bk(2);
    }

    protected void onDestroy() {
        this.nZe.onDestroy();
        try {
            getWindow().clearFlags(128);
        } catch (Exception e) {
        }
        super.onDestroy();
        if (this.nSE != null && this.nSE.bAJ().sqc.ruA.size() > 0) {
            String str = ((ate) this.nSE.bAJ().sqc.ruA.get(0)).jPK;
            int i = this.nSE.bAJ().sqj;
            t.a(aq.D((ate) this.nSE.bAJ().sqc.ruA.get(0)), new PInt(), new PInt());
            int playVideoDuration = this.nZe.getPlayVideoDuration();
            h.mEJ.h(15534, new Object[]{str, this.nSE.bAJ().ksA, Integer.valueOf(i), Integer.valueOf(r3.value * 1000), Integer.valueOf(playVideoDuration * 1000)});
        }
    }

    public final void ayH() {
        if (this.nTv != null && this.nTv.getVisibility() == 0) {
            this.nTv.setVisibility(8);
        }
        int width = this.jdF.getWidth();
        int height = this.jdF.getHeight();
        if (!(this.hDl == 0 || this.hDm == 0)) {
            height = (int) ((((float) width) / ((float) this.hDl)) * ((float) this.hDm));
        }
        this.hDi.fh(width, height);
        this.hDi.u(this.hDk, this.hDj, this.hDl, this.hDm);
        if (((double) this.nTE) != 1.0d) {
            this.hDi.uzR = 1.0f / this.nTE;
            if (!(this.nTF == 0 && this.nTG == 0)) {
                this.hDi.fi(((int) (((float) (this.jdF.getWidth() / 2)) * (1.0f - this.nTE))) + this.nTF, (int) (((float) ((this.jdF.getHeight() / 2) + this.nTG)) - (((float) (height / 2)) * this.nTE)));
            }
        }
        this.hDi.a(this.nZe, this.jdG, new 11(this), null);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        x.d("MicroMsg.SnsOnlineVideoActivity", "dispatchKeyEvent");
        ayH();
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.SnsOnlineVideoActivity", "on activity result reqCode %d resultCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (4097 == i && -1 == i2) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            String stringExtra2 = intent.getStringExtra("custom_send_text");
            for (String str : bi.F(stringExtra.split(","))) {
                if (this.scene == 0) {
                    n Nl = af.byo().Nl(this.bNH);
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
                bsu bAJ = this.nSE.bAJ();
                int LQ = i.LQ(this.dXA);
                if (bi.oW(this.bOX)) {
                    ate ate = this.caK;
                    if (ate == null) {
                        stringExtra = "";
                    } else {
                        String s = an.s(af.getAccSnsPath(), ate.ksA);
                        stringExtra = s + i.e(ate);
                        x.d("MicroMsg.SnsVideoLogic", "get sns video thumb path %s [%b]", new Object[]{stringExtra, Boolean.valueOf(FileOp.cn(stringExtra))});
                        if (!FileOp.cn(stringExtra)) {
                            stringExtra = s + i.n(ate);
                            x.i("MicroMsg.SnsVideoLogic", "get sns video thumb path %s", new Object[]{stringExtra});
                        }
                    }
                } else {
                    stringExtra = this.bOX;
                }
                this.bOX = stringExtra;
                x.i("MicroMsg.SnsOnlineVideoActivity", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[]{str, this.dXA, this.bOX, this.caK.rVL, Integer.valueOf(this.caK.oig), Integer.valueOf(LQ)});
                com.tencent.mm.plugin.messenger.a.g.bcT().a(this, str, this.dXA, this.bOX, 43, LQ, bAJ.nNV);
                if (stringExtra2 != null) {
                    com.tencent.mm.plugin.messenger.a.g.bcT().dF(stringExtra2, str);
                }
                com.tencent.mm.ui.widget.snackbar.b.h(this, getString(j.has_send));
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final int getForceOrientation() {
        return 2;
    }
}
