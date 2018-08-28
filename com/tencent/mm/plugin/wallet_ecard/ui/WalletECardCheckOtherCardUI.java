package com.tencent.mm.plugin.wallet_ecard.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;

public class WalletECardCheckOtherCardUI extends WalletECardBaseUI implements a {
    private Button eWk;
    private String hYh;
    private WalletFormView muF;
    private WalletFormView pCr;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hYh = this.sy.getString(com.tencent.mm.plugin.wallet_ecard.a.a.pBP, "");
        setMMTitle(getString(i.ecard_check_other_card_title));
        this.uYO.jr(385);
        initView();
    }

    protected final void initView() {
        this.muF = (WalletFormView) findViewById(f.check_other_card_input_et);
        this.pCr = (WalletFormView) findViewById(f.check_other_card_mobile_input_et);
        this.eWk = (Button) findViewById(f.check_other_card_next_btn);
        com.tencent.mm.wallet_core.ui.formview.a.b(this.muF);
        com.tencent.mm.wallet_core.ui.formview.a.c(this, this.pCr);
        if (bi.oW(this.hYh)) {
            this.muF.setHint(getString(i.ecard_check_other_card_hint_without_name_text));
        } else {
            this.muF.setHint(getString(i.ecard_check_other_card_hint_text, new Object[]{this.hYh}));
        }
        this.pCr.setHint(getString(i.ecard_check_other_card_phone_hint_text));
        this.muF.setOnInputValidChangeListener(this);
        this.pCr.setOnInputValidChangeListener(this);
        d(this.muF, 0, false);
        d(this.pCr, 0, false);
        this.eWk.setEnabled(false);
        this.eWk.setClickable(false);
        this.eWk.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.i("MicroMsg.WalletECardCheckOtherCardUI", "do check card");
                if (WalletECardCheckOtherCardUI.this.muF.ZF() && WalletECardCheckOtherCardUI.this.pCr.ZF()) {
                    String text = WalletECardCheckOtherCardUI.this.muF.getText();
                    String text2 = WalletECardCheckOtherCardUI.this.pCr.getText();
                    WalletECardCheckOtherCardUI.this.cDL().m(new Object[]{text, text2});
                    return;
                }
                x.w("MicroMsg.WalletECardCheckOtherCardUI", "input invalid");
            }
        });
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    protected final int getLayoutId() {
        return g.ecard_check_other_card_ui;
    }

    public void onDestroy() {
        super.onDestroy();
        this.uYO.js(385);
    }

    public final void fE(boolean z) {
        x.d("MicroMsg.WalletECardCheckOtherCardUI", "is valid: %s", new Object[]{Boolean.valueOf(z)});
        if (this.muF.ZF() && this.pCr.ZF()) {
            this.eWk.setEnabled(true);
            this.eWk.setClickable(true);
            return;
        }
        this.eWk.setEnabled(false);
        this.eWk.setClickable(false);
    }
}
