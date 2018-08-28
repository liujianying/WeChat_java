package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.sdk.platformtools.x;

class BankRemitSelectPayeeUI$1 implements OnItemClickListener {
    final /* synthetic */ BankRemitSelectPayeeUI mwE;

    BankRemitSelectPayeeUI$1(BankRemitSelectPayeeUI bankRemitSelectPayeeUI) {
        this.mwE = bankRemitSelectPayeeUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.d("MicroMsg.BankRemitSelectPayeeUI", "item click: %s", new Object[]{Integer.valueOf(i)});
        TransferRecordParcel transferRecordParcel = (TransferRecordParcel) adapterView.getAdapter().getItem(i);
        if (transferRecordParcel != null) {
            BankRemitSelectPayeeUI.a(this.mwE).putExtra("key_bank_card_seqno", transferRecordParcel.muA);
            this.mwE.setResult(-1, BankRemitSelectPayeeUI.a(this.mwE));
            this.mwE.finish();
        }
    }
}
