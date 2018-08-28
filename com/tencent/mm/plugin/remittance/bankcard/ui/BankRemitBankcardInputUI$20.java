package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class BankRemitBankcardInputUI$20 implements OnClickListener {
    final /* synthetic */ BankRemitBankcardInputUI mve;

    BankRemitBankcardInputUI$20(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        this.mve = bankRemitBankcardInputUI;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.BankRemitBankcardInputUI", "name iv click");
        if (BankRemitBankcardInputUI.G(this.mve) || !BankRemitBankcardInputUI.H(this.mve)) {
            BankRemitBankcardInputUI.I(this.mve);
        } else {
            Intent intent = new Intent(this.mve.mController.tml, BankRemitSelectPayeeUI.class);
            if (BankRemitBankcardInputUI.B(this.mve) != null) {
                intent.putParcelableArrayListExtra("key_self_transfer_record_list", BankRemitBankcardInputUI.B(this.mve));
            }
            if (BankRemitBankcardInputUI.C(this.mve) != null) {
                intent.putParcelableArrayListExtra("key_freq_transfer_record_list", BankRemitBankcardInputUI.C(this.mve));
            }
            this.mve.startActivityForResult(intent, 1);
        }
        h.mEJ.h(14673, new Object[]{Integer.valueOf(3)});
    }
}
