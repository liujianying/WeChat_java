package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tenpay.android.wechat.TenpaySecureEditText;

class RemittanceBusiUI$a {
    private View gYR;
    private float mBB;
    private float mBC;
    private float mBD;
    private TenpaySecureEditText mBE;
    private TextView mBF;
    private View mBG;
    final /* synthetic */ RemittanceBusiUI mBt;

    RemittanceBusiUI$a(RemittanceBusiUI remittanceBusiUI, int i, int i2, float f) {
        this.mBt = remittanceBusiUI;
        this.mBB = (float) i;
        this.mBC = (float) i2;
        this.mBD = f;
    }

    final void update() {
        RemittanceBusiUI.b(this.mBt).setTextSize(1, RemittanceBusiUI.a(this.mBt).mBC);
        RemittanceBusiUI.c(this.mBt).setTextSize(1, RemittanceBusiUI.a(this.mBt).mBB);
        if (this.mBF == null) {
            this.mBF = (TextView) RemittanceBusiUI.d(this.mBt).findViewById(f.wallet_title);
        }
        if (this.mBF != null) {
            this.mBF.setTextSize(this.mBB);
        }
        if (this.mBE == null) {
            this.mBE = (TenpaySecureEditText) RemittanceBusiUI.d(this.mBt).findViewById(f.wallet_content);
        }
        if (this.mBE != null) {
            this.mBE.setTextSize(this.mBC);
        }
        if (this.gYR == null) {
            this.gYR = this.mBE.findViewById(f.money_et_layout);
        }
        if (this.gYR != null) {
            this.gYR.setMinimumHeight(b.b(this.mBt, RemittanceBusiUI.a(this.mBt).mBC));
        }
        if (this.mBG == null) {
            this.mBG = this.mBt.findViewById(f.walletformline);
        }
        if (this.mBG != null) {
            ((LayoutParams) this.mBG.getLayoutParams()).topMargin = b.b(this.mBt, this.mBD);
        }
    }
}
