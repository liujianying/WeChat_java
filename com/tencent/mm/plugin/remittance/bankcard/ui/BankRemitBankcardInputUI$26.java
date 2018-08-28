package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class BankRemitBankcardInputUI$26 implements OnClickListener {
    final /* synthetic */ BankRemitBankcardInputUI mve;

    BankRemitBankcardInputUI$26(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        this.mve = bankRemitBankcardInputUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.BankRemitBankcardInputUI", "click arrive time et");
        this.mve.YC();
        BankRemitBankcardInputUI.o(this.mve).bqm();
        if (!BankRemitBankcardInputUI.r(this.mve)) {
            Intent intent = new Intent(this.mve.mController.tml, BankRemitSelectArriveTimeUI.class);
            if (!(BankRemitBankcardInputUI.s(this.mve) == null || BankRemitBankcardInputUI.s(this.mve).mum == null)) {
                intent.putParcelableArrayListExtra("key_arrive_time_parcel_list", BankRemitBankcardInputUI.s(this.mve).mum);
            }
            if (BankRemitBankcardInputUI.t(this.mve) != null) {
                intent.putExtra("key_select_arrive_time", BankRemitBankcardInputUI.t(this.mve).mun);
            }
            this.mve.startActivityForResult(intent, 3);
        }
    }
}
