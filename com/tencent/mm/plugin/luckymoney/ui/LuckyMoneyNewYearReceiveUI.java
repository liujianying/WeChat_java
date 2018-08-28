package com.tencent.mm.plugin.luckymoney.ui;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.luckymoney.b.ad;
import com.tencent.mm.plugin.luckymoney.b.k;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.wallet_core.ui.e;
import java.io.File;

@a(3)
public class LuckyMoneyNewYearReceiveUI extends LuckyMoneyBaseUI {
    private TextView glY;
    private ImageView hVP;
    private String imagePath = "";
    private View kMK;
    private int kRj = 0;
    private String kUn;
    private LuckyMoneyAutoScrollView kVR;
    private TextView kVS;
    private TextView kVT;
    private LinearLayout kVU;
    private ImageView kVV;
    private ImageView kVW;
    private View kVX;
    private ImageView kVY;
    private boolean kVZ = false;
    private boolean kWa = false;
    private String kWb = "";
    private String kWc = "";
    private int kWd;
    private k kWe;
    private boolean kWf = false;
    private TextView klp;
    private ag mHandler = new ag();
    private p tipDialog = null;

    static /* synthetic */ void a(LuckyMoneyNewYearReceiveUI luckyMoneyNewYearReceiveUI) {
        x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:doPreviewImage");
        if (TextUtils.isEmpty(luckyMoneyNewYearReceiveUI.imagePath)) {
            x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "image path is empty!");
            return;
        }
        h.mEJ.h(13079, new Object[]{Integer.valueOf(7), Integer.valueOf(2)});
        new h(luckyMoneyNewYearReceiveUI, q.GF(), luckyMoneyNewYearReceiveUI.imagePath).m(true, 2);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_native_url");
        this.kWb = getIntent().getStringExtra("key_image_id");
        this.kWc = getIntent().getStringExtra("key_image_aes_key");
        this.kWd = getIntent().getIntExtra("key_image_length", 0);
        x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "imageId:" + this.kWb + ", imageLength:" + this.kWd);
        Uri parse = Uri.parse(bi.oV(stringExtra));
        try {
            this.kUn = parse.getQueryParameter("sendid");
        } catch (Exception e) {
        }
        initView();
        if (bi.oW(this.kUn)) {
            finish();
            x.w("MicroMsg.LuckyMoneyNewYearReceiveUI", "sendid null & finish");
            return;
        }
        b(new com.tencent.mm.plugin.luckymoney.b.ag(bi.getInt(parse.getQueryParameter("channelid"), 1), this.kUn, stringExtra, 1, "v1.0"), false);
        if (this.tipDialog != null) {
            this.tipDialog.show();
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.kWf) {
            finish();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
    }

    protected final void initView() {
        this.kMK = findViewById(f.lucky_money_newyear_receive_ll);
        this.kVR = (LuckyMoneyAutoScrollView) findViewById(f.lucky_money_newyear_receive_amount);
        this.kVS = (TextView) findViewById(f.lucky_money_amount_unit_title_tv);
        this.klp = (TextView) findViewById(f.lucky_money_newyear_receive_wishing);
        this.hVP = (ImageView) findViewById(f.lucky_money_newyear_receive_avatar);
        this.kVU = (LinearLayout) findViewById(f.lucky_money_newyear_receive_status_layout);
        this.glY = (TextView) findViewById(f.lucky_money_newyear_receive_status);
        this.kVV = (ImageView) findViewById(f.lucky_money_newyear_receive_status_icon);
        this.kVT = (TextView) findViewById(f.lucky_money_newyear_receive_title);
        this.kVW = (ImageView) findViewById(f.lucky_money_new_year_word);
        this.kVX = findViewById(f.lucky_money_new_year_picture_layout);
        this.kVY = (ImageView) findViewById(f.lucky_money_new_year_picture_img);
        this.kVY.setOnClickListener(new 1(this));
        ((ImageView) findViewById(f.lucky_money_newyear_receive_close_btn)).setOnClickListener(new 2(this));
        ux(8);
        this.tipDialog = com.tencent.mm.ui.base.h.a(this.mController.tml, getString(i.loading_tips), true, new 3(this));
    }

    private void bbz() {
        g.Em().H(new 5(this));
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (!(lVar instanceof com.tencent.mm.plugin.luckymoney.b.ag)) {
            if (lVar instanceof ad) {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.hide();
                }
                if (i == 0 && i2 == 0) {
                    ad adVar = (ad) lVar;
                    com.tencent.mm.plugin.luckymoney.b.f fVar = adVar.kQP;
                    this.glY.setText(adVar.kQP.kPJ);
                    this.kVR.setFinalText(e.A(((double) adVar.kQP.cfh) / 100.0d));
                    this.kVR.a(new 7(this, adVar));
                    if (fVar.ceS == 4 && !TextUtils.isEmpty(adVar.kQP.kPJ)) {
                        this.kVV.setVisibility(8);
                    }
                    ux(0);
                    o.a(this.kMK, null);
                    return true;
                } else if (i2 == 416) {
                    if (this.tipDialog != null && this.tipDialog.isShowing()) {
                        this.tipDialog.hide();
                    }
                    this.kWf = true;
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyNewYearReceiveUI");
                    bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                    return o.a(this, i2, lVar, bundle, true, 1004);
                }
            }
            return false;
        } else if (i == 0 && i2 == 0) {
            LayoutParams layoutParams;
            com.tencent.mm.plugin.luckymoney.b.ag agVar = (com.tencent.mm.plugin.luckymoney.b.ag) lVar;
            this.kRj = agVar.kRj;
            if (this.kRj == 1) {
                x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "download image data!");
                if (TextUtils.isEmpty(this.kWc)) {
                    x.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "imageaeskey is empty!");
                }
                if (TextUtils.isEmpty(this.kWb) || TextUtils.isEmpty(this.kWc) || this.kWd <= 0) {
                    x.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:doDownloadImage() the parameter is illegeal!");
                } else {
                    x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:doDownloadImage()!");
                    if (this.kWe == null) {
                        this.kWe = new k();
                    }
                    this.imagePath = o.Ge(this.kWb) + ".temp";
                    if (new File(this.imagePath).exists()) {
                        x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:imagePath file is exist! update image");
                        bbz();
                    } else {
                        x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "ljd:updateImageView() imagePath:" + this.imagePath + " is not exist!");
                        this.kWe.a(this.kWb, this.kWc, this.kWd, this.imagePath, new 4(this));
                    }
                }
            } else {
                x.e("MicroMsg.LuckyMoneyNewYearReceiveUI", "not to download image data!");
            }
            if (agVar.bba()) {
                this.kVZ = true;
                x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is Sender hb!");
                b.n(this.hVP, q.GF());
                findViewById(f.lucky_money_newyear_receive_senderdesc).setVisibility(8);
                findViewById(f.lucky_money_new_year_word).setVisibility(0);
            } else {
                x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "is receiver hb!");
                if (!TextUtils.isEmpty(getIntent().getStringExtra("key_username"))) {
                    b.n(this.hVP, getIntent().getStringExtra("key_username"));
                } else if (!TextUtils.isEmpty(agVar.kPM)) {
                    o.a(this.hVP, agVar.kPM, agVar.kQg);
                }
                o.a(this.mController.tml, this.kVT, agVar.kRy);
                this.kVZ = false;
            }
            if (agVar.bba() || agVar.ceT != 0 || agVar.ceS == 4 || agVar.ceS == 5 || agVar.ceS == 1) {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.hide();
                }
                if (agVar.ceS != 5) {
                    this.kVR.setFinalText(e.A(((double) agVar.kRz) / 100.0d));
                    LuckyMoneyAutoScrollView luckyMoneyAutoScrollView = this.kVR;
                    luckyMoneyAutoScrollView.kTU.setVisibility(8);
                    luckyMoneyAutoScrollView.kTV.setVisibility(8);
                    luckyMoneyAutoScrollView.kTW.setVisibility(8);
                    luckyMoneyAutoScrollView.kTX.setVisibility(0);
                    luckyMoneyAutoScrollView.kTY.setVisibility(0);
                    luckyMoneyAutoScrollView.kTZ.setVisibility(0);
                    o.a(this.mController.tml, this.klp, agVar.kLf);
                    this.glY.setText(agVar.kPJ);
                    if (agVar.ceS == 4 && !TextUtils.isEmpty(agVar.kPJ)) {
                        this.kVV.setVisibility(8);
                    }
                } else {
                    findViewById(f.lucky_money_newyear_receive_desc_area).setVisibility(8);
                    ((TextView) findViewById(f.lucky_money_newyear_receive_invalid_status)).setText(agVar.kPJ);
                    ((TextView) findViewById(f.lucky_money_newyear_receive_invalid_status)).setVisibility(0);
                }
                ux(0);
                o.a(this.kMK, null);
            } else if ("0".equals(agVar.kQU)) {
                new com.tencent.mm.plugin.wallet_core.id_verify.util.a().a(this, this.kUg, agVar.kQV, agVar.kQW, agVar.kQX, agVar.kQY, new 6(this, agVar), true, 1005);
            } else {
                a(agVar.msgType, agVar.bxk, agVar.kLZ, agVar.ceR, agVar.kRC);
            }
            x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "scenePicSwitch:" + this.kRj + ", imageId:" + this.kWb + ", imageLength:" + this.kWd);
            if (this.kRj != 1 || TextUtils.isEmpty(this.kWb) || TextUtils.isEmpty(this.kWc) || this.kWd <= 0) {
                this.kWa = false;
                x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "don't show the picture!");
            } else {
                this.kWa = true;
                x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "show the picture!");
            }
            boolean z = true;
            if (agVar.ceS == 5 || agVar.ceS == 1) {
                z = false;
            }
            x.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "receiveScene.hbStatus is " + agVar.ceS + ", isValidStatus is " + z);
            if (this.kWa && z) {
                this.kVX.setVisibility(0);
                this.kVW.setVisibility(8);
            } else {
                this.kVX.setVisibility(8);
                this.kVW.setVisibility(0);
            }
            if (this.kWa && z) {
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
            } else {
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
            }
            if (this.kVZ) {
                layoutParams = (LayoutParams) this.kVU.getLayoutParams();
                if (this.kWa) {
                    layoutParams.topMargin = getResources().getDimensionPixelOffset(d.lucky_money_newyear_receive_status_layout_top_margin_for_sender_has_pic);
                } else {
                    layoutParams.topMargin = getResources().getDimensionPixelOffset(d.lucky_money_newyear_receive_status_layout_top_margin_for_sender_no_pic);
                }
                this.kVU.setLayoutParams(layoutParams);
                this.kVU.invalidate();
                this.glY.setTextSize(1, 18.0f);
            } else {
                layoutParams = (LayoutParams) this.kVU.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelOffset(d.lucky_money_newyear_receive_status_layout_top_margin_for_receiver);
                this.kVU.setLayoutParams(layoutParams);
                this.kVU.invalidate();
                this.glY.setTextSize(1, 12.0f);
            }
            return true;
        } else {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.hide();
            }
            return false;
        }
    }

    private void a(int i, int i2, String str, String str2, String str3) {
        b(new ad(i, i2, str, str2, o.baX(), q.GH(), getIntent().getStringExtra("key_username"), "v1.0", str3), false);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.lucky_money_newyear_receive_ui;
    }
}
