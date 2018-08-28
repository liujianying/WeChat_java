package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import com.tencent.mm.g.a.gj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.a.b.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.pluginsdk.model.t;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.av;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.f$a;
import java.util.List;

@a(3)
public class SnsBrowseUI extends SnsBaseGalleryUI implements t$a {
    private String bNH;
    private int bPz = 0;
    Bundle hDg;
    private boolean hDh = false;
    f hDi;
    private int hDj = 0;
    private int hDk = 0;
    private int hDl = 0;
    private int hDm = 0;
    private int hmV = 0;
    private int hmW = 0;
    private ImageView jdG;
    private ag mHandler = new ag();
    private t nTA;
    private int nTB;
    private int nTC;
    private int nTD = 0;
    private float nTE = 1.0f;
    private int nTF = 0;
    private int nTG = 0;
    private int nTw = 0;
    private boolean nTx = false;
    private boolean nTy = false;
    private boolean nTz = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        if (getIntent().getExtras() != null) {
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        }
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        initView();
        this.hDg = bundle;
    }

    public void onDestroy() {
        b io;
        if (this.nTu != null) {
            int intExtra = getIntent().getIntExtra("K_ad_scene", -1);
            SnsInfoFlip snsInfoFlip = this.nTu;
            String str = this.bNH;
            if (snsInfoFlip.nkG) {
                if (intExtra < 0) {
                    x.i("MicroMsg.SnsInfoFlip", "pass by scene " + intExtra);
                } else {
                    n Nl = af.byo().Nl(str);
                    if (Nl != null) {
                        if (snsInfoFlip.nXa >= 0) {
                            long longValue = snsInfoFlip.nWC.containsKey(Integer.valueOf(snsInfoFlip.nXa)) ? ((Long) snsInfoFlip.nWC.get(Integer.valueOf(snsInfoFlip.nXa))).longValue() : 0;
                            if (longValue > 0) {
                                long longValue2 = snsInfoFlip.nWD.containsKey(Integer.valueOf(snsInfoFlip.nXa)) ? ((Long) snsInfoFlip.nWD.get(Integer.valueOf(snsInfoFlip.nXa))).longValue() : 0;
                                longValue = bi.bI(longValue);
                                longValue2 += longValue;
                                snsInfoFlip.nWD.put(Integer.valueOf(snsInfoFlip.nXa), Long.valueOf(longValue2));
                                x.i("MicroMsg.SnsInfoFlip", "lastSelectPosition " + snsInfoFlip.nXa + " curtime " + longValue2 + " passtime " + longValue);
                            }
                        }
                        e bBp = Nl.bBp();
                        StringBuffer stringBuffer = new StringBuffer();
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer.append("<desc>");
                        String str2 = "<item><id>%d</id><duration>%d</duration><count>%d</count></item>";
                        String str3 = "%d|%d|%d";
                        for (Integer num : snsInfoFlip.nWB.keySet()) {
                            int intValue = ((Integer) snsInfoFlip.nWB.get(num)).intValue();
                            int longValue3 = snsInfoFlip.nWD.containsKey(num) ? (int) (((Long) snsInfoFlip.nWD.get(num)).longValue() * 1) : 0;
                            stringBuffer.append(String.format(str2, new Object[]{num, Integer.valueOf(longValue3), Integer.valueOf(intValue)}));
                            stringBuffer2.append(String.format(str3, new Object[]{num, Integer.valueOf(longValue3), Integer.valueOf(intValue)}) + "&");
                        }
                        stringBuffer.append("</desc>");
                        str = stringBuffer2.toString();
                        str3 = str.endsWith("&") ? str.substring(0, str.length() - 1) : str;
                        if (Nl == null || !Nl.bzx()) {
                            i byi = af.byi();
                            Object[] objArr = new Object[1];
                            objArr[0] = com.tencent.mm.plugin.sns.a.b.f.a(Nl.field_snsId, new Object[]{com.tencent.mm.plugin.sns.data.i.eF(Nl.field_snsId), Nl.bBo(), Integer.valueOf(intExtra), Long.valueOf(snsInfoFlip.nWS), Long.valueOf(System.currentTimeMillis()), str3, Integer.valueOf(snsInfoFlip.getCount())});
                            byi.h(12014, objArr);
                        }
                        if (bBp.bAF().nzp != 1) {
                            c cVar = new c(Nl.bBn(), 6, intExtra, stringBuffer.toString(), Nl.bBr(), Nl.bAK());
                            g.Ek();
                            g.Eh().dpP.a(cVar, 0);
                        }
                        io = b.io(729);
                        io.nb(com.tencent.mm.plugin.sns.data.i.eF(Nl.field_snsId)).nb(Nl.bBo()).ir(intExtra).nb(snsInfoFlip.nWS).nb(System.currentTimeMillis()).nb(str3).ir(snsInfoFlip.getCount());
                        io.RD();
                    }
                }
            }
        }
        io = b.p(getIntent());
        if (io != null) {
            this.nTu.getSelectCount();
            io.ir(this.nTu.getCount()).ir(this.nTu.getNumOfFileExist());
            io.update();
            io.RD();
        }
        this.nTu.bDr();
        this.nTu.onDestroy();
        af.byl().H(this);
        if (this.nTx) {
            this.nTu.bDt();
        }
        if (this.nTA != null) {
            this.nTA.stop();
        }
        super.onDestroy();
    }

    protected void onPause() {
        if (this.nTu != null) {
            this.nTu.onPause();
        }
        super.onPause();
        m.Bk(2);
    }

    public void onResume() {
        super.onResume();
        if (this.nTu != null) {
            this.nTu.aKx();
        }
        m.Bk(1);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.sns.i.g.sns_browse_img;
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
                    this.nTu.getViewTreeObserver().addOnPreDrawListener(new 3(this));
                }
            }
        }
        super.onStart();
        x.d("MicroMsg.SnsPopMediasUI", "onStart ");
    }

    public final void aun() {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        x.d("MicroMsg.SnsPopMediasUI", "dispatchKeyEvent");
        setResult(-1, new Intent());
        ayH();
        return true;
    }

    protected final void initView() {
        this.hDi = new f(this.mController.tml);
        this.hDh = false;
        String aG = bi.aG(getIntent().getStringExtra("sns_gallery_userName"), "");
        this.bNH = bi.aG(getIntent().getStringExtra("sns_gallery_localId"), "");
        this.nTw = getIntent().getIntExtra("sns_gallery_position", 0);
        this.bPz = getIntent().getIntExtra("sns_position", 0);
        this.nTx = getIntent().getBooleanExtra("k_is_from_sns_main_timeline", false);
        this.nTy = getIntent().getBooleanExtra("k_is_from_sns_msg_ui", false);
        this.nTz = getIntent().getBooleanExtra("sns_soon_enter_photoedit_ui", false);
        n Nl = af.byo().Nl(this.bNH);
        this.jdG = (ImageView) findViewById(com.tencent.mm.plugin.sns.i.f.gallery_bg);
        this.jdG.setLayerType(2, null);
        this.nTu = new SnsInfoFlip(this);
        this.nTu.setLayerType(2, null);
        this.nTu.setIsFromMainTimeline(this.nTx);
        this.nTu.setNeedScanImage(true);
        List Mn = aj.Mn(this.bNH);
        this.nTu.setShowPageControl(true);
        this.nTu.setOreitaion(true);
        this.nTu.setTouchFinish(true);
        this.nTu.setInfoType(Nl.field_type);
        this.nTu.setIsSoonEnterPhotoEditUI(this.nTz);
        this.nTu.a(Mn, aG, this.nTw, this.nTp, this);
        SnsInfoFlip snsInfoFlip = this.nTu;
        av clT = av.clT();
        clT.time = Nl.field_createTime;
        snsInfoFlip.setFromScene(clT);
        addView(this.nTu);
        if (Nl != null && Nl.xb(32)) {
            this.nTu.setIsAd(true);
        }
        this.nTv = (Button) findViewById(com.tencent.mm.plugin.sns.i.f.game_more_button);
        bsu bAJ = Nl.bAJ();
        com.tencent.mm.protocal.c.av avVar = bAJ != null ? bAJ.nsB : null;
        ay ayVar = new ay();
        ag.a(this, ayVar, bAJ.nsB);
        if (ayVar.ofl) {
            this.nTv.setVisibility(0);
            this.nTv.setText(ayVar.ofm);
            this.nTv.setOnClickListener(new 2(this, avVar, bAJ));
        } else {
            this.nTv.setVisibility(8);
        }
        if (!com.tencent.mm.plugin.sns.lucky.a.m.h(Nl)) {
            x.e("MicroMsg.SnsPopMediasUI", "error see photo !! " + Nl.field_userName + " " + Nl.field_snsId);
            finish();
        } else if (Nl.field_type == 21 && !Nl.field_userName.equals(q.GF())) {
            this.nTA = new t(com.tencent.mm.compatible.util.e.bnC + "/Pictures/Screenshots/", new 1(this));
            this.nTA.start();
        }
    }

    public final void ayH() {
        int i = this.hDl;
        int i2 = this.hDm;
        int i3 = this.hDk;
        int i4 = this.hDj;
        if (!this.nTy) {
            gj gjVar = new gj();
            gjVar.bPx.bPA = this.nTu.getGallery().getSelectedItemPosition();
            gjVar.bPx.bPz = this.bPz;
            com.tencent.mm.sdk.b.a.sFg.m(gjVar);
            i = gjVar.bPy.bId;
            i2 = gjVar.bPy.bIe;
            i3 = gjVar.bPy.bIb;
            i4 = gjVar.bPy.bIc;
        }
        this.nTB = this.nTu.getWidth();
        this.nTC = this.nTu.getHeight();
        af.byl();
        String C = com.tencent.mm.plugin.sns.model.g.C(this.nTu.getCntMedia());
        if (C != null) {
            Options VZ = com.tencent.mm.sdk.platformtools.c.VZ(C);
            this.nTC = (int) (((float) VZ.outHeight) * (((float) this.nTB) / ((float) VZ.outWidth)));
            if (this.nTC > this.nTu.getHeight()) {
                if (((double) this.nTC) < ((double) this.nTu.getHeight()) * 2.5d) {
                    this.nTD = this.nTC - this.nTu.getHeight();
                    if (this.nTu.getCount() == 1) {
                        i2 = (i2 * this.nTu.getHeight()) / this.nTC;
                        this.nTD = 0;
                    }
                }
                this.nTC = this.nTu.getHeight();
            }
        }
        this.hDi.fh(this.nTB, this.nTC);
        this.hDi.u(i3, i4, i, i2);
        if (((double) this.nTE) != 1.0d) {
            this.hDi.uzR = 1.0f / this.nTE;
            if (!(this.nTF == 0 && this.nTG == 0)) {
                this.hDi.fi(((int) (((float) (this.nTu.getWidth() / 2)) * (1.0f - this.nTE))) + this.nTF, (int) (((float) ((this.nTu.getHeight() / 2) + this.nTG)) - (((float) (this.nTC / 2)) * this.nTE)));
            }
        }
        this.hDi.nJY = this.nTD;
        this.hDi.a(this.nTu, this.jdG, new 4(this), new f$a() {
            public final void v(int i, int i2, int i3, int i4) {
                if (SnsBrowseUI.this.nTu.getGallery() != null && VERSION.SDK_INT >= 18) {
                    SnsBrowseUI.this.nTu.getGallery().setClipBounds(new Rect(i, i2, i3, i4));
                }
            }
        });
    }

    public final void bCZ() {
        Gallery gallery = this.nTu.getGallery();
        if (gallery instanceof MMGestureGallery) {
            ((MMGestureGallery) gallery).setGalleryScaleListener(new 6(this, gallery));
        }
    }

    public final void ci(String str, int i) {
        x.i("MicroMsg.SnsPopMediasUI", "[notifyData] opType:%s reset:%s localId;%s", new Object[]{Integer.valueOf(i), Boolean.valueOf(true), str});
        if (this.nTu != null) {
            this.nTu.aKx();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.SnsPopMediasUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
        }
    }

    protected final int getForceOrientation() {
        return 2;
    }

    public final void cj(String str, int i) {
        this.nTw = i;
    }
}
