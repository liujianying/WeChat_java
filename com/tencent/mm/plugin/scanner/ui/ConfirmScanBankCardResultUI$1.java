package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.om;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;

class ConfirmScanBankCardResultUI$1 implements OnClickListener {
    final /* synthetic */ ConfirmScanBankCardResultUI mIg;

    ConfirmScanBankCardResultUI$1(ConfirmScanBankCardResultUI confirmScanBankCardResultUI) {
        this.mIg = confirmScanBankCardResultUI;
    }

    public final void onClick(View view) {
        if (ConfirmScanBankCardResultUI.a(this.mIg) != null) {
            String obj = ConfirmScanBankCardResultUI.a(this.mIg).getEditableText().toString();
            if (!bi.oW(obj)) {
                om omVar = new om();
                omVar.bZq.action = 1;
                omVar.bZq.cardNum = obj;
                a.sFg.m(omVar);
                ConfirmScanBankCardResultUI.b(this.mIg);
            }
        }
    }
}
