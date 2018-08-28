package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.q;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.luckymoney.b.ag;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import java.io.IOException;

@a(3)
public class LuckyMoneyReceiveUI extends LuckyMoneyBaseUI {
    private TextView hXT;
    private long hmf = 0;
    private String jNl;
    private ImageView kLO;
    private TextView kMF;
    Button kMG;
    private View kMH;
    private ImageView kMI;
    private TextView kMJ;
    private View kMK;
    private ImageView kOI;
    ag kRG;
    private String kUn;
    private String kUp;
    private y kXq = null;
    private TextView klp;
    private int maxSize = 0;
    private int textSize = 0;
    private p tipDialog = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kUp = getIntent().getStringExtra("key_native_url");
        x.i("MicroMsg.LuckyMoneyReceiveUI", "nativeUrl= " + bi.oV(this.kUp));
        initView();
        Uri parse = Uri.parse(bi.oV(this.kUp));
        try {
            this.kUn = parse.getQueryParameter("sendid");
        } catch (Exception e) {
        }
        this.kXq = o.bOT().Pk(this.kUp);
        if (this.kXq != null && this.kXq.field_receiveAmount > 0 && bi.bH(this.kXq.field_receiveTime) < 86400000) {
            x.i("MicroMsg.LuckyMoneyReceiveUI", "use cache this item %s %s", new Object[]{Long.valueOf(this.kXq.field_receiveTime), bi.oV(this.kUp)});
            Intent intent = new Intent();
            intent.setClass(this.mController.tml, LuckyMoneyDetailUI.class);
            intent.putExtra("key_native_url", this.kXq.field_mNativeUrl);
            intent.putExtra("key_sendid", this.kUn);
            startActivity(intent);
            finish();
        } else if (bi.oW(this.kUn)) {
            finish();
            x.w("MicroMsg.LuckyMoneyReceiveUI", "sendid null & finish");
        } else {
            int i = bi.getInt(parse.getQueryParameter("channelid"), 1);
            this.jNl = parse.getQueryParameter("sendusername");
            b(new ag(i, this.kUn, this.kUp, getIntent().getIntExtra("key_way", 0), "v1.0"), false);
            if (this.tipDialog != null) {
                this.tipDialog.show();
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
    }

    protected void onResume() {
        super.onResume();
        this.hmf = bi.VE();
    }

    protected void onPause() {
        super.onPause();
        d.h("LuckyMoneyReceiveUI", this.hmf, bi.VE());
    }

    protected final void initView() {
        this.kMK = findViewById(f.lucky_money_receive_ll);
        this.kLO = (ImageView) findViewById(f.lucky_money_receive_sender_avatar);
        this.kMF = (TextView) findViewById(f.lucky_money_receive_sender_nickname);
        this.hXT = (TextView) findViewById(f.lucky_money_receive_tips);
        this.klp = (TextView) findViewById(f.lucky_money_receive_wishing);
        this.kMG = (Button) findViewById(f.lucky_money_recieve_open);
        this.kMJ = (TextView) findViewById(f.lucky_money_recieve_check_detail);
        this.kMH = findViewById(f.lucky_money_recieve_check_detail_ll);
        this.kMI = (ImageView) findViewById(f.lucky_money_bottom_decoration);
        this.kOI = (ImageView) findViewById(f.lucky_money_recieve_close_btn);
        this.kOI.setOnClickListener(new 1(this));
        this.maxSize = (int) (((float) com.tencent.mm.bp.a.ae(this.mController.tml, com.tencent.mm.plugin.wxpay.a.d.lucky_money_goldstyle_envelop_wishing_textsize)) * 1.375f);
        this.textSize = com.tencent.mm.bp.a.ad(this.mController.tml, com.tencent.mm.plugin.wxpay.a.d.lucky_money_goldstyle_envelop_wishing_textsize);
        this.textSize = this.textSize > this.maxSize ? this.maxSize : this.textSize;
        this.klp.setTextSize(0, (float) this.textSize);
        this.mController.contentView.setVisibility(8);
        this.tipDialog = h.a(this.mController.tml, getString(i.loading_tips), true, new 2(this));
        if (this.kMG != null) {
            b.lFJ.uc(this.kMG.getId());
            String d = w.d(ad.getContext().getSharedPreferences(ad.chY(), 0));
            if (d == null || d.length() <= 0 || !(d.equals("zh_CN") || d.equals("zh_TW") || d.equals("zh_HK"))) {
                this.kMG.setBackgroundResource(a$e.lucky_money_send_btn);
                this.kMG.setText(i.lucky_money_open_title);
            }
        }
    }

    protected final int getLayoutId() {
        return g.lucky_money_receive_ui;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        LayoutParams layoutParams;
        if (!(lVar instanceof ag)) {
            if (lVar instanceof com.tencent.mm.plugin.luckymoney.b.ad) {
                com.tencent.mm.plugin.luckymoney.b.o.c(this.kMG);
                if (i == 0 && i2 == 0) {
                    com.tencent.mm.plugin.luckymoney.b.ad adVar = (com.tencent.mm.plugin.luckymoney.b.ad) lVar;
                    com.tencent.mm.plugin.luckymoney.b.f fVar = adVar.kQP;
                    if (fVar.ceT == 2) {
                        Intent intent = new Intent();
                        intent.setClass(this.mController.tml, LuckyMoneyDetailUI.class);
                        try {
                            intent.putExtra("key_detail_info", adVar.kQP.toByteArray());
                            intent.putExtra("key_jump_from", 2);
                        } catch (IOException e) {
                            x.w("MicroMsg.LuckyMoneyReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e.getLocalizedMessage());
                        }
                        intent.putExtra("key_native_url", adVar.ceR);
                        intent.putExtra("key_sendid", adVar.kLZ);
                        if (com.tencent.mm.k.g.AT().getInt("PlayCoinSound", 0) > 0) {
                            intent.putExtra("play_sound", true);
                        }
                        if (adVar.kMP != null) {
                            intent.putExtra("key_realname_guide_helper", adVar.kMP);
                        }
                        startActivity(intent);
                        y yVar = new y();
                        yVar.field_mNativeUrl = this.kUp;
                        yVar.field_hbType = fVar.kPI;
                        yVar.field_receiveAmount = fVar.cfh;
                        yVar.field_receiveTime = System.currentTimeMillis();
                        yVar.field_hbStatus = fVar.ceS;
                        yVar.field_receiveStatus = fVar.ceT;
                        if (yVar.field_receiveAmount > 0) {
                            o.bOT().a(yVar);
                        }
                        finish();
                        return true;
                    }
                    this.kMG.setBackgroundResource(a$e.lucky_money_receive_open_disabled_btn);
                    this.kMG.setText(i.lucky_money_open);
                    this.kMG.setOnClickListener(null);
                    this.kMG.setVisibility(8);
                    if (bi.oW(fVar.kNj)) {
                        this.hXT.setVisibility(8);
                    } else {
                        this.hXT.setText(fVar.kNj);
                        this.hXT.setVisibility(0);
                    }
                    this.klp.setText(fVar.kPJ);
                    layoutParams = (LayoutParams) this.kMH.getLayoutParams();
                    layoutParams.bottomMargin = BackwardSupportUtil.b.b(this.mController.tml, 30.0f);
                    this.kMH.setLayoutParams(layoutParams);
                    if (q.GF().equals(this.jNl) || fVar.kPI == 1) {
                        this.kMH.setVisibility(0);
                        this.kMH.setOnClickListener(new 6(this, adVar));
                        this.kMI.setVisibility(8);
                        return true;
                    }
                    this.kMH.setVisibility(8);
                    this.kMI.setVisibility(0);
                    return true;
                } else if (i2 == 416) {
                    if (this.tipDialog != null && this.tipDialog.isShowing()) {
                        this.tipDialog.hide();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".ui.LuckyMoneyReceiveUI");
                    bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                    this.kMG.setBackgroundResource(a$e.festival_lucky_money_open_btn);
                    7 7 = new 7(this);
                    return com.tencent.mm.plugin.luckymoney.b.o.a(this, i2, lVar, bundle, false, 1003);
                }
            } else if (lVar instanceof com.tencent.mm.plugin.luckymoney.b.w) {
                if (this.tipDialog != null && this.tipDialog.isShowing()) {
                    this.tipDialog.hide();
                }
                if (i == 0 && i2 == 0) {
                    com.tencent.mm.plugin.luckymoney.b.w wVar = (com.tencent.mm.plugin.luckymoney.b.w) lVar;
                    Intent intent2 = new Intent();
                    intent2.setClass(this.mController.tml, LuckyMoneyDetailUI.class);
                    try {
                        intent2.putExtra("key_detail_info", wVar.kQP.toByteArray());
                        intent2.putExtra("key_jump_from", 2);
                    } catch (IOException e2) {
                        x.w("MicroMsg.LuckyMoneyReceiveUI", "luckyMoneyDetail.toByteArray() fail! " + e2.getLocalizedMessage());
                    }
                    intent2.putExtra("key_native_url", this.kUp);
                    intent2.putExtra("key_sendid", this.kUn);
                    startActivity(intent2);
                    finish();
                    return true;
                }
                h.bA(this, str);
                finish();
                return true;
            }
            return false;
        } else if (i == 0 && i2 == 0) {
            this.kRG = (ag) lVar;
            com.tencent.mm.plugin.report.service.h.mEJ.h(11701, new Object[]{Integer.valueOf(5), Integer.valueOf(sn(this.kRG.kPI)), Integer.valueOf(bbC()), Integer.valueOf(0), Integer.valueOf(1)});
            y yVar2 = new y();
            yVar2.field_mNativeUrl = this.kUp;
            yVar2.field_hbType = this.kRG.kPI;
            yVar2.field_hbStatus = this.kRG.ceS;
            yVar2.field_receiveStatus = this.kRG.ceT;
            o.bOT().a(yVar2);
            if (this.kRG.ceT == 2) {
                b(new com.tencent.mm.plugin.luckymoney.b.w(this.kUn, 11, 0, this.kUp, "v1.0"), false);
                return true;
            }
            boolean z;
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.hide();
            }
            com.tencent.mm.plugin.luckymoney.b.o.a(this.kLO, this.kRG.kPM, this.kRG.kQg);
            com.tencent.mm.plugin.luckymoney.b.o.a(this.mController.tml, this.kMF, this.kRG.kRy);
            if (this.kRG.ceT == 1 || this.kRG.ceS == 4 || this.kRG.ceS == 5 || this.kRG.ceS == 1) {
                this.kMG.setBackgroundResource(a$e.lucky_money_receive_open_disabled_btn);
                this.kMG.setText(i.lucky_money_open);
                this.kMG.setOnClickListener(null);
                this.kMG.setVisibility(8);
                if (bi.oW(this.kRG.kNj)) {
                    this.hXT.setVisibility(8);
                } else {
                    this.hXT.setText(this.kRG.kNj);
                    this.hXT.setVisibility(0);
                }
                this.klp.setText(this.kRG.kPJ);
                layoutParams = (LayoutParams) this.kMH.getLayoutParams();
                layoutParams.bottomMargin = BackwardSupportUtil.b.b(this.mController.tml, 30.0f);
                this.kMH.setLayoutParams(layoutParams);
                z = true;
            } else {
                if (!bi.oW(this.kRG.kPJ)) {
                    this.hXT.setText(this.kRG.kPJ);
                    this.hXT.setVisibility(0);
                }
                if (!bi.oW(this.kRG.kLf)) {
                    com.tencent.mm.plugin.luckymoney.b.o.a(this.mController.tml, this.klp, this.kRG.kLf);
                    this.klp.setVisibility(0);
                }
                this.kMG.setOnClickListener(new 3(this));
                z = false;
            }
            if (q.GF().equals(this.jNl) || (this.kRG.kPI == 1 && z)) {
                if (this.kRG.kPI == 1) {
                    this.kMJ.setText(i.lucky_money_detail_luck);
                }
                this.kMH.setVisibility(0);
                this.kMH.setOnClickListener(new 4(this, z));
                this.kMI.setVisibility(8);
            } else {
                this.kMH.setVisibility(8);
                this.kMI.setVisibility(0);
            }
            com.tencent.mm.plugin.luckymoney.b.o.a(this.kMK, null);
            this.mController.contentView.setVisibility(0);
            if (this.kRG.ceS != 5 || yVar2.field_receiveAmount <= 0) {
                return true;
            }
            this.kMI.setVisibility(8);
            this.kMH.setVisibility(0);
            this.hXT.setVisibility(0);
            this.hXT.setText(i.lucky_money_send_for_you);
            this.klp.setVisibility(8);
            findViewById(f.lucky_money_receive_money).setVisibility(0);
            ((WalletTextView) findViewById(f.lucky_money_detail_amount)).setText(e.A(((double) yVar2.field_receiveAmount) / 100.0d));
            this.kMH.setOnClickListener(new 5(this));
            return true;
        } else {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.hide();
            }
            return false;
        }
    }

    private int bbC() {
        if (q.GF().equals(this.jNl)) {
            return 1;
        }
        return 0;
    }

    private static int sn(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 0) {
            return 2;
        }
        return 0;
    }
}
