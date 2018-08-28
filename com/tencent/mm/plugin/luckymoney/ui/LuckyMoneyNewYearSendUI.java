package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.model.q;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.plugin.luckymoney.b.ae;
import com.tencent.mm.plugin.luckymoney.b.af;
import com.tencent.mm.plugin.luckymoney.b.k;
import com.tencent.mm.plugin.luckymoney.b.l;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

@a(3)
public class LuckyMoneyNewYearSendUI extends LuckyMoneyBaseUI {
    private Dialog eXG = null;
    private OnClickListener eZF = new OnClickListener() {
        public final void onClick(View view) {
            if (view.getId() == f.lucky_money_new_year_send_btn) {
                h.mEJ.h(13079, new Object[]{Integer.valueOf(5), Integer.valueOf(1)});
                if (LuckyMoneyNewYearSendUI.this.kRj == 1 && LuckyMoneyNewYearSendUI.this.kWa && !TextUtils.isEmpty(LuckyMoneyNewYearSendUI.this.kWv) && !TextUtils.isEmpty(LuckyMoneyNewYearSendUI.this.kWb) && !TextUtils.isEmpty(LuckyMoneyNewYearSendUI.this.kWc) && LuckyMoneyNewYearSendUI.this.kWd > 0) {
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "to send HB with last post image data!");
                    LuckyMoneyNewYearSendUI.g(LuckyMoneyNewYearSendUI.this);
                } else if (LuckyMoneyNewYearSendUI.this.kRj == 1 && LuckyMoneyNewYearSendUI.this.kWa && !TextUtils.isEmpty(LuckyMoneyNewYearSendUI.this.kWv)) {
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "to send HB with new image data!");
                    LuckyMoneyNewYearSendUI.this.bbA();
                    if (LuckyMoneyNewYearSendUI.this.kWe == null) {
                        LuckyMoneyNewYearSendUI.this.kWe = new k();
                    }
                    k i = LuckyMoneyNewYearSendUI.this.kWe;
                    String c = LuckyMoneyNewYearSendUI.this.kWv;
                    1 1 = new 1(this);
                    i.ixo = k.baW();
                    i.kQx = 1;
                    i.kQy = c;
                    x.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: sendImg. imageId:%s", new Object[]{i.ixo});
                    i iVar = new i();
                    iVar.ceW = true;
                    iVar.dPV = i;
                    iVar.field_mediaId = r2;
                    iVar.field_fullpath = c;
                    iVar.field_thumbpath = "";
                    iVar.field_fileType = b.MediaType_FILE;
                    iVar.field_talker = "";
                    iVar.field_priority = b.dOk;
                    iVar.field_needStorage = false;
                    iVar.field_isStreamMedia = false;
                    iVar.field_appType = 0;
                    iVar.field_bzScene = 0;
                    if (!g.ND().c(iVar)) {
                        x.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: cdntra addSendTask failed. clientid:%s", new Object[]{r2});
                    }
                } else {
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "to send HB with not image data!");
                    LuckyMoneyNewYearSendUI.this.kWv = "";
                    LuckyMoneyNewYearSendUI.this.kWb = "";
                    LuckyMoneyNewYearSendUI.this.kWc = "";
                    LuckyMoneyNewYearSendUI.this.kWd = 0;
                    LuckyMoneyNewYearSendUI.g(LuckyMoneyNewYearSendUI.this);
                }
            } else if (view.getId() == f.lucky_money_new_year_close_btn) {
                LuckyMoneyNewYearSendUI.this.finish();
                h.mEJ.h(13079, new Object[]{Integer.valueOf(6), Integer.valueOf(1)});
            } else if (view.getId() == f.lucky_money_new_year_camera_btn || view.getId() == f.lucky_money_new_year_camera_tips) {
                LuckyMoneyNewYearSendUI.l(LuckyMoneyNewYearSendUI.this);
                h.mEJ.h(13079, new Object[]{Integer.valueOf(2), Integer.valueOf(1)});
            } else if (view.getId() == f.lucky_money_new_year_picture_del_btn) {
                LuckyMoneyNewYearSendUI.this.kWb = "";
                LuckyMoneyNewYearSendUI.this.kWc = "";
                LuckyMoneyNewYearSendUI.this.kWd = 0;
                LuckyMoneyNewYearSendUI.m(LuckyMoneyNewYearSendUI.this);
                h.mEJ.h(13079, new Object[]{Integer.valueOf(3), Integer.valueOf(1)});
            } else if (view.getId() == f.lucky_money_new_year_refresh_layout) {
                LuckyMoneyAutoScrollView n = LuckyMoneyNewYearSendUI.this.kVR;
                n.kUd = false;
                n.kTU.setVisibility(0);
                n.kTV.setVisibility(0);
                n.kTW.setVisibility(0);
                n.kTX.setVisibility(4);
                n.kTY.setVisibility(4);
                n.kTZ.setVisibility(4);
                LuckyMoneyNewYearSendUI.this.bbB();
                h.mEJ.h(13079, new Object[]{Integer.valueOf(4), Integer.valueOf(1)});
            } else if (view.getId() == f.lucky_money_new_year_picture_img) {
                LuckyMoneyNewYearSendUI.p(LuckyMoneyNewYearSendUI.this);
            }
        }
    };
    private Button iqN;
    private String kRc;
    private int kRe;
    private int kRj = 0;
    private LinkedList<l> kRk;
    private int kTr;
    private String kTv;
    private int kTw;
    private LuckyMoneyAutoScrollView kVR;
    private TextView kVS;
    private ImageView kVW;
    private View kVX;
    private ImageView kVY;
    private boolean kWa = false;
    private String kWb = "";
    private String kWc = "";
    private int kWd;
    private k kWe;
    private View kWn;
    private View kWo;
    private ImageView kWp;
    private TextView kWq;
    private ImageView kWr;
    private LinearLayout kWs;
    private String kWt;
    private boolean kWu = true;
    private String kWv = "";
    private int kWw = 0;
    private TextView klp;
    private Bitmap mBitmap;
    private ag mHandler = new ag();

    static /* synthetic */ void g(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSend()");
        h.mEJ.h(11701, new Object[]{Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1)});
        String GF = q.GF();
        luckyMoneyNewYearSendUI.b(new af(luckyMoneyNewYearSendUI.kRe, luckyMoneyNewYearSendUI.kRc, o.Gd(GF), luckyMoneyNewYearSendUI.kWt, GF, q.GH(), luckyMoneyNewYearSendUI.kTr, luckyMoneyNewYearSendUI.kWb, luckyMoneyNewYearSendUI.kWc, luckyMoneyNewYearSendUI.kWd), false);
        luckyMoneyNewYearSendUI.bbA();
    }

    static /* synthetic */ void l(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "doSelectPicture");
        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "galleryMode %s", new Object[]{luckyMoneyNewYearSendUI.mController.tml.getSharedPreferences(ad.chY(), 0).getString("gallery", "1")});
        if (luckyMoneyNewYearSendUI.mController.tml.getSharedPreferences(ad.chY(), 0).getString("gallery", "1").equalsIgnoreCase("0")) {
            com.tencent.mm.pluginsdk.ui.tools.l.a(luckyMoneyNewYearSendUI, 2, null);
        } else {
            com.tencent.mm.pluginsdk.ui.tools.l.R(luckyMoneyNewYearSendUI);
        }
    }

    static /* synthetic */ void m(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "doDeletePic");
        luckyMoneyNewYearSendUI.kWa = false;
        luckyMoneyNewYearSendUI.kWv = "";
        luckyMoneyNewYearSendUI.kWb = "";
        luckyMoneyNewYearSendUI.kWc = "";
        luckyMoneyNewYearSendUI.kWd = 0;
        luckyMoneyNewYearSendUI.aL();
    }

    static /* synthetic */ void p(LuckyMoneyNewYearSendUI luckyMoneyNewYearSendUI) {
        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:doPreviewImage");
        if (TextUtils.isEmpty(luckyMoneyNewYearSendUI.kWv)) {
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "image path is empty!");
            return;
        }
        h.mEJ.h(13079, new Object[]{Integer.valueOf(7), Integer.valueOf(1)});
        new h(luckyMoneyNewYearSendUI, q.GF(), luckyMoneyNewYearSendUI.kWv).m(false, 1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "lucky send ui create");
        this.kWt = getIntent().getStringExtra("key_username");
        this.kTr = getIntent().getIntExtra("key_way", 0);
        this.kTw = getIntent().getIntExtra("pay_channel", -1);
        if (bi.oW(this.kWt)) {
            x.w("MicroMsg.LuckyMoneyNewYearSendUI", "name null finish");
            finish();
        }
        initView();
        l(new com.tencent.mm.plugin.luckymoney.b.x("v1.0"));
        h.mEJ.h(13079, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
    }

    protected void onDestroy() {
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Ei().DT().a(aa.a.sSO, this.kWv);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Ei().DT().a(aa.a.sSP, this.kWb);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Ei().DT().a(aa.a.sSQ, this.kWc);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Ei().DT().a(aa.a.sSR, Integer.valueOf(this.kWd));
        super.onDestroy();
        if (this.eXG != null && this.eXG.isShowing()) {
            this.eXG.dismiss();
        }
    }

    protected final void initView() {
        ux(8);
        this.kWn = findViewById(f.lucky_money_newyear_send_ll);
        this.kVS = (TextView) findViewById(f.lucky_money_amount_unit_title_tv);
        this.kVR = (LuckyMoneyAutoScrollView) findViewById(f.lucky_money_new_year_amount);
        this.klp = (TextView) findViewById(f.lucky_money_new_year_wishing);
        this.iqN = (Button) findViewById(f.lucky_money_new_year_send_btn);
        this.iqN.setOnClickListener(this.eZF);
        ((ImageView) findViewById(f.lucky_money_new_year_close_btn)).setOnClickListener(this.eZF);
        this.kWo = findViewById(f.lucky_money_new_year_camera_layout);
        this.kWp = (ImageView) findViewById(f.lucky_money_new_year_camera_btn);
        this.kWp.setOnClickListener(this.eZF);
        this.kVW = (ImageView) findViewById(f.lucky_money_new_year_word);
        this.kWq = (TextView) findViewById(f.lucky_money_new_year_camera_tips);
        this.kWq.setOnClickListener(this.eZF);
        this.kVX = findViewById(f.lucky_money_new_year_picture_layout);
        this.kVY = (ImageView) findViewById(f.lucky_money_new_year_picture_img);
        this.kVY.setOnClickListener(this.eZF);
        this.kWr = (ImageView) findViewById(f.lucky_money_new_year_picture_del_btn);
        this.kWr.setOnClickListener(this.eZF);
        this.kWs = (LinearLayout) findViewById(f.lucky_money_new_year_refresh_layout);
        this.kWs.setOnClickListener(this.eZF);
        com.tencent.mm.kernel.g.Ek();
        this.kWv = (String) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sSO, "");
        com.tencent.mm.kernel.g.Ek();
        this.kWb = (String) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sSP, "");
        com.tencent.mm.kernel.g.Ek();
        this.kWc = (String) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sSQ, "");
        com.tencent.mm.kernel.g.Ek();
        this.kWd = ((Integer) com.tencent.mm.kernel.g.Ei().DT().get(aa.a.sSR, Integer.valueOf(0))).intValue();
        if (TextUtils.isEmpty(this.kWv) || TextUtils.isEmpty(this.kWb) || TextUtils.isEmpty(this.kWc) || this.kWd <= 0) {
            x.e("MicroMsg.LuckyMoneyNewYearSendUI", "count not fetch last post image data!");
        } else {
            this.kWa = true;
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "last post image data is valid");
        }
        if (!this.kWa || TextUtils.isEmpty(this.kWv)) {
            x.e("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:initPictureImage() mIsShowPic:" + this.kWa + ", mImagePath:" + this.kWv);
            return;
        }
        Bitmap aE = o.aE(this.kWv, false);
        if (aE != null) {
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:get crop new year picture is ok!");
            Bitmap bitmap = this.mBitmap;
            this.mBitmap = aE;
            this.kVY.setImageBitmap(this.mBitmap);
            if (bitmap != null && bitmap.isRecycled()) {
                bitmap.recycle();
                return;
            }
            return;
        }
        x.e("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:get crop new year picture failed!");
    }

    private void aL() {
        LayoutParams layoutParams;
        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:updateView");
        if (this.kWa && this.kRj == 1) {
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:show the picture!");
            this.kWo.setVisibility(8);
            this.kVX.setVisibility(0);
            this.kVW.setVisibility(8);
        } else if (this.kRj == 1) {
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:show the camera btn!");
            this.kWo.setVisibility(0);
            this.kVX.setVisibility(8);
            this.kVW.setVisibility(0);
        } else {
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:show the new year wording!");
            this.kWo.setVisibility(8);
            this.kVX.setVisibility(8);
            this.kVW.setVisibility(0);
        }
        if (this.kRk == null || this.kRk.size() <= 0) {
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is not valid!");
            this.kWs.setVisibility(8);
        } else {
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:year mess list is valid!");
            this.kWs.setVisibility(0);
        }
        if (this.kRj == 1) {
            layoutParams = (LayoutParams) this.kVW.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelOffset(d.lucky_money_new_year_word_top_margin_for_picture);
            layoutParams.bottomMargin = getResources().getDimensionPixelOffset(d.lucky_money_new_year_word_bottom_margin_for_picture);
            this.kVW.setLayoutParams(layoutParams);
            this.kVW.invalidate();
        } else {
            layoutParams = (LayoutParams) this.kVW.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelOffset(d.lucky_money_new_year_word_top_margin_for_normal);
            layoutParams.bottomMargin = getResources().getDimensionPixelOffset(d.lucky_money_new_year_word_bottom_margin_for_normal);
            this.kVW.setLayoutParams(layoutParams);
            this.kVW.invalidate();
        }
        if (this.kWa) {
            layoutParams = (LayoutParams) this.klp.getLayoutParams();
            layoutParams.bottomMargin = getResources().getDimensionPixelOffset(d.lucky_money_new_year_wishing_bottom_margin_for_picture);
            this.klp.setLayoutParams(layoutParams);
            this.klp.invalidate();
            this.klp.setTextSize(1, 17.0f);
            this.kVS.setTextSize(1, 16.0f);
            this.kVR.cO(getResources().getDimensionPixelOffset(d.lucky_money_newyear_num_width_for_picture), getResources().getDimensionPixelOffset(d.lucky_money_newyear_num_height_for_picture));
            layoutParams = (LayoutParams) this.kVR.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelOffset(d.lucky_money_new_year_amount_top_margin_for_picture);
            this.kVR.setLayoutParams(layoutParams);
            this.kVR.invalidate();
            layoutParams = (LayoutParams) this.kWs.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelOffset(d.lucky_money_new_year_refresh_layout_top_margin_for_picture);
            this.kWs.setLayoutParams(layoutParams);
            this.kWs.invalidate();
            return;
        }
        layoutParams = (LayoutParams) this.klp.getLayoutParams();
        layoutParams.bottomMargin = getResources().getDimensionPixelOffset(d.lucky_money_new_year_wishing_bottom_margin_for_normal);
        this.klp.setLayoutParams(layoutParams);
        this.klp.invalidate();
        this.klp.setTextSize(1, 20.0f);
        this.kVS.setTextSize(1, 18.0f);
        this.kVR.cO(getResources().getDimensionPixelOffset(d.lucky_money_newyear_num_width_for_normal), getResources().getDimensionPixelOffset(d.lucky_money_newyear_num_height_for_normal));
        layoutParams = (LayoutParams) this.kVR.getLayoutParams();
        layoutParams.topMargin = getResources().getDimensionPixelOffset(d.lucky_money_new_year_amount_top_margin_for_normal);
        this.kVR.setLayoutParams(layoutParams);
        this.kVR.invalidate();
        layoutParams = (LayoutParams) this.kWs.getLayoutParams();
        layoutParams.topMargin = getResources().getDimensionPixelOffset(d.lucky_money_new_year_refresh_layout_top_margin_for_normal);
        this.kWs.setLayoutParams(layoutParams);
        this.kWs.invalidate();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.lucky_money_new_year_send_ui;
    }

    private void bbA() {
        if (this.eXG == null) {
            this.eXG = com.tencent.mm.wallet_core.ui.g.a(this.mController.tml, true, new 2(this));
        } else if (!this.eXG.isShowing()) {
            this.eXG.show();
        }
    }

    private void bbB() {
        int i;
        if (this.kRk == null || this.kRk.size() <= 0) {
            x.e("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex yearMessList is empty!");
            i = -1;
        } else {
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eg();
            i = com.tencent.mm.kernel.a.Df();
            int size = this.kRk.size();
            i = (new Random((long) i).nextInt(size) + ((int) (System.currentTimeMillis() % ((long) size)))) % size;
            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "genRandomAmountIndex retRand:" + i);
        }
        this.kWw = i;
        if (this.kWw >= 0 && this.kWw < this.kRk.size()) {
            this.kRe = ((l) this.kRk.get(this.kWw)).kQA;
            this.kRc = ((l) this.kRk.get(this.kWw)).kQB;
        }
        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "mSelectIndex:" + this.kWw + " randomAmount:" + this.kRe + " randomWishing:" + this.kRc);
        this.kVR.setFinalText(e.A(((double) this.kRe) / 100.0d));
        this.kVR.a(new 3(this));
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "onSceneEnd() errType:" + i + " errCode:" + i2 + " errMsg:" + str + " netsceneType:" + lVar.getType());
        PayInfo payInfo;
        if (lVar instanceof com.tencent.mm.plugin.luckymoney.b.x) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.luckymoney.b.x xVar = (com.tencent.mm.plugin.luckymoney.b.x) lVar;
                this.kRe = xVar.kRe;
                this.kRc = xVar.kRc;
                this.kRj = xVar.kRj;
                this.kRk = xVar.kRk;
                if (this.kRj == 0) {
                    x.e("MicroMsg.LuckyMoneyNewYearSendUI", "scenePicSwitch is 0, clear local picture data!");
                } else {
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "cans how picture!");
                }
                bbB();
                aL();
                ux(0);
                o.a(this.kWn, null);
                return true;
            }
            finish();
        } else if (lVar instanceof ae) {
            if (this.eXG != null && this.eXG.isShowing()) {
                this.eXG.hide();
            }
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
                ae aeVar = (ae) lVar;
                this.kTv = aeVar.kRr;
                payInfo = new PayInfo();
                payInfo.bOd = aeVar.kRq;
                payInfo.bVY = 37;
                payInfo.bVU = this.kTw;
                com.tencent.mm.pluginsdk.wallet.h.a(this, payInfo, 1);
                return true;
            }
            x.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
        } else if (lVar instanceof af) {
            if (this.eXG != null && this.eXG.isShowing()) {
                this.eXG.hide();
            }
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.LuckyMoneyNewYearSendUI", "send hb success!");
                af afVar = (af) lVar;
                this.kTv = afVar.kRr;
                payInfo = new PayInfo();
                payInfo.bOd = afVar.kRq;
                payInfo.bVY = 37;
                payInfo.bVU = this.kTw;
                com.tencent.mm.pluginsdk.wallet.h.a(this, payInfo, 1);
                return true;
            }
            x.e("MicroMsg.LuckyMoneyNewYearSendUI", "send hb failed!");
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z = false;
        String str;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay success!");
                    h.mEJ.h(11701, new Object[]{Integer.valueOf(15), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2)});
                    if (intent != null && intent.hasExtra("key_realname_guide_helper")) {
                        RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
                        if (realnameGuideHelper != null) {
                            boolean z2;
                            if (realnameGuideHelper.b(this, null, new 4(this))) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            z = z2;
                        }
                    }
                    com.tencent.mm.ui.base.h.bA(this, getString(com.tencent.mm.plugin.wxpay.a.i.has_send));
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "sendLocalMsg() for hb!");
                    o.C(this.kTv, this.kWt, 3);
                    if (!z) {
                        finish();
                        return;
                    }
                    return;
                }
                x.i("MicroMsg.LuckyMoneyNewYearSendUI", "do pay cancel or failed!");
                return;
            case 2:
                if (intent == null) {
                    x.e("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() data is null for REQUEST_CODE_FROM_PIC");
                    return;
                } else if (i2 == -1) {
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:select picture is ok!");
                    CharSequence stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                    if (!TextUtils.isEmpty(stringExtra) || (stringArrayListExtra != null && stringArrayListExtra.size() > 0)) {
                        if (TextUtils.isEmpty(stringExtra)) {
                            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:imagePathList is valid!");
                            str = (String) stringArrayListExtra.get(0);
                        } else {
                            x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:imagePath is valid!");
                            str = stringExtra;
                        }
                        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "REQUEST_CODE_FROM_PIC filePath %s", new Object[]{stringExtra});
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 1);
                        intent2.putExtra("CropImage_OutputPath", com.tencent.mm.compatible.util.e.dgu + "temp.avatar");
                        intent2.putExtra("CropImage_ImgPath", str);
                        intent2.putExtra("CropImage_Filter", false);
                        intent2.putExtra("CropImage_from_scene", 1);
                        com.tencent.mm.plugin.luckymoney.a.ezn.a(this, intent2, 3);
                        return;
                    }
                    x.e("MicroMsg.LuckyMoneyNewYearSendUI", "do select picture failed, imagePath and imagePathList is null!");
                    return;
                } else {
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "do select picture cancel or failed!");
                    return;
                }
            case 3:
                if (intent == null) {
                    x.e("MicroMsg.LuckyMoneyNewYearSendUI", "onActivityResult() data is null for REQUEST_CODE_FROM_CROP");
                    return;
                } else if (i2 == -1) {
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:select picture is ok!");
                    str = intent.getStringExtra("CropImage_OutputPath");
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "new crop image path:" + str);
                    if (TextUtils.isEmpty(str) || !str.equals(this.kWv)) {
                        this.kWb = "";
                        this.kWc = "";
                        this.kWd = 0;
                    } else {
                        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "the path is same as last image");
                    }
                    this.kWv = str;
                    Bitmap aE = o.aE(this.kWv, false);
                    if (aE != null) {
                        x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:get crop new year picture is ok!");
                        Bitmap bitmap = this.mBitmap;
                        this.mBitmap = aE;
                        this.kVY.setImageBitmap(this.mBitmap);
                        this.kWa = true;
                        aL();
                        if (bitmap != null && bitmap.isRecycled()) {
                            bitmap.recycle();
                            return;
                        }
                        return;
                    }
                    x.e("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:get crop new year picture failed!");
                    return;
                } else {
                    x.i("MicroMsg.LuckyMoneyNewYearSendUI", "ljd:do crop image fail for REQUEST_CODE_FROM_CROP");
                    return;
                }
            default:
                return;
        }
    }
}
