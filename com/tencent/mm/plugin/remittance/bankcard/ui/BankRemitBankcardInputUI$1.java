package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.TextView;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.e;

class BankRemitBankcardInputUI$1 implements Runnable {
    final /* synthetic */ sy hYO;
    final /* synthetic */ BankRemitBankcardInputUI mve;

    BankRemitBankcardInputUI$1(BankRemitBankcardInputUI bankRemitBankcardInputUI, sy syVar) {
        this.mve = bankRemitBankcardInputUI;
        this.hYO = syVar;
    }

    public final void run() {
        if (!bi.oW(this.hYO.cdP.cdQ)) {
            e.a((TextView) this.mve.findViewById(f.banner_tips), this.hYO.cdP.cdQ, this.hYO.cdP.content, this.hYO.cdP.url);
        }
    }
}
