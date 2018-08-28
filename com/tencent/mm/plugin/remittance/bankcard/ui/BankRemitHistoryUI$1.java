package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.protocal.c.amk;
import com.tencent.mm.sdk.platformtools.x;

class BankRemitHistoryUI$1 implements OnItemLongClickListener {
    final /* synthetic */ BankRemitHistoryUI mvI;

    BankRemitHistoryUI$1(BankRemitHistoryUI bankRemitHistoryUI) {
        this.mvI = bankRemitHistoryUI;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.d("MicroMsg.BankRemitHistoryUI", "click item, %s", new Object[]{((amk) adapterView.getAdapter().getItem(i)).title});
        BankRemitHistoryUI.a(this.mvI).a(view, i, j, this.mvI, this.mvI);
        return false;
    }
}
