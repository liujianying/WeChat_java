package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.sdk.platformtools.ah;

class BankRemitBankcardInputUI$23 implements OnEditorActionListener {
    final /* synthetic */ BankRemitBankcardInputUI mve;

    BankRemitBankcardInputUI$23(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        this.mve = bankRemitBankcardInputUI;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 5) {
            this.mve.YC();
            if (!BankRemitBankcardInputUI.m(this.mve)) {
                ah.i(new Runnable() {
                    public final void run() {
                        BankRemitBankcardInputUI$23.this.mve.cDJ();
                    }
                }, 200);
            }
        }
        return false;
    }
}
