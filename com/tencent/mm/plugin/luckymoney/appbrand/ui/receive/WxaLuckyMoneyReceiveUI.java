package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

@a(3)
public class WxaLuckyMoneyReceiveUI extends WxaLuckyMoneyBaseUI implements b {
    static final /* synthetic */ boolean $assertionsDisabled = (!WxaLuckyMoneyReceiveUI.class.desiredAssertionStatus());
    private TextView hXT;
    private int isA = -1;
    private ImageView kLO;
    private int kMD = -1;
    private a kME;
    private TextView kMF;
    private Button kMG;
    private View kMH;
    private ImageView kMI;
    private TextView kMJ;
    private View kMK;
    private TextView klp;
    private p tipDialog = null;

    static /* synthetic */ void c(WxaLuckyMoneyReceiveUI wxaLuckyMoneyReceiveUI) {
        if (wxaLuckyMoneyReceiveUI.kME != null) {
            wxaLuckyMoneyReceiveUI.kME.baF();
        }
    }

    public final MMActivity baA() {
        return this;
    }

    public final void baG() {
        o.c(this.kMG);
    }

    public final void baB() {
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
    }

    public final void Ga(String str) {
    }

    public final void a(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        baB();
        dz(str, str2);
        dA(str3, str4);
        this.kMG.setOnClickListener(new 1(this));
        this.kMG.setVisibility(0);
        x(z, z2);
        baH();
    }

    public final void a(String str, String str2, int i, String str3, boolean z, boolean z2) {
        this.isA = i;
        this.kMD = 1;
        baB();
        dz(str, str2);
        dA(null, str3);
        this.kMG.setOnClickListener(null);
        this.kMG.setVisibility(8);
        x(z, z2);
        baH();
    }

    private void baH() {
        o.a(this.kMK, null);
        this.mController.contentView.setVisibility(0);
    }

    private void dz(String str, String str2) {
        o.a(this.kLO, str2, null);
        o.a(this.mController.tml, this.kMF, str);
    }

    private void dA(String str, String str2) {
        if (bi.oW(str)) {
            this.hXT.setVisibility(8);
        } else {
            this.hXT.setText(str);
            this.hXT.setVisibility(0);
        }
        if (!bi.oW(str2)) {
            o.a(this.mController.tml, this.klp, str2);
            this.klp.setVisibility(0);
        }
    }

    private void x(boolean z, boolean z2) {
        if (z) {
            this.kMH.setVisibility(0);
            if (z2) {
                this.kMJ.setText(i.lucky_money_detail_luck);
            } else {
                this.kMJ.setText(i.lucky_money_check_detail);
            }
            this.kMI.setVisibility(8);
            this.kMH.setOnClickListener(new 2(this));
            return;
        }
        this.kMH.setVisibility(8);
        this.kMI.setVisibility(0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.WxaLuckyMoneyReceiveUI", "WxaLuckyMoneyReceiveUI.onCreate ");
        initView();
        getIntent();
        this.kME = new c();
        this.kME.a(this, getIntent());
    }

    protected void onResume() {
        super.onResume();
        o.c(this.kMG);
        this.kMG.setBackgroundResource(e.festival_lucky_money_open_btn);
        baI();
    }

    protected void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.WxaLuckyMoneyReceiveUI", "WxaLuckyMoneyReceiveUI.onDestroy ");
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (this.kME != null) {
            this.kME.onDestroy();
            this.kME = null;
        }
    }

    public void onBackPressed() {
        cL(this.kMD, this.isA);
        finish();
    }

    private void cL(int i, int i2) {
        x.i("MicroMsg.WxaLuckyMoneyReceiveUI", "setBackResult cgiType:[%d],errCode:[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 1) {
            setResult(0, new Intent().putExtra("result_error_code", 10001).putExtra("result_error_msg", "fail:no permission to receive the red packet"));
        } else if (i == 4) {
            setResult(0, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{user cancel}}"));
        }
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
        ImageView imageView = (ImageView) findViewById(f.lucky_money_recieve_close_btn);
        if ($assertionsDisabled || imageView != null) {
            imageView.setOnClickListener(new 3(this));
            e(this.kMF, d.lucky_money_goldstyle_envelop_nickname_textsize);
            e(this.hXT, d.lucky_money_goldstyle_envelop_tips_textsize);
            e(this.klp, d.lucky_money_goldstyle_envelop_wishing_textsize);
            this.mController.contentView.setVisibility(8);
            this.tipDialog = h.a(this.mController.tml, getString(i.loading_tips), true, new 4(this));
            this.tipDialog.show();
            baI();
            return;
        }
        throw new AssertionError();
    }

    private void e(TextView textView, int i) {
        int ae = (int) (((float) com.tencent.mm.bp.a.ae(this.mController.tml, i)) * 1.125f);
        int ad = com.tencent.mm.bp.a.ad(this.mController.tml, i);
        if (ad <= ae) {
            ae = ad;
        }
        textView.setTextSize(0, (float) ae);
    }

    private void baI() {
        if (this.kMG != null) {
            String d = w.d(ad.getContext().getSharedPreferences(ad.chY(), 0));
            if (d == null || d.length() <= 0 || !(d.equals("zh_CN") || d.equals("zh_TW") || d.equals("zh_HK"))) {
                this.kMG.setBackgroundResource(e.lucky_money_send_btn);
                this.kMG.setText(i.lucky_money_open_title);
            }
        }
    }

    protected final int getLayoutId() {
        return g.wxa_lucky_money_receive_ui;
    }
}
