package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class BankRemitHistoryUI$2 implements OnScrollListener {
    final /* synthetic */ BankRemitHistoryUI mvI;

    BankRemitHistoryUI$2(BankRemitHistoryUI bankRemitHistoryUI) {
        this.mvI = bankRemitHistoryUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (BankRemitHistoryUI.b(this.mvI).getLastVisiblePosition() == BankRemitHistoryUI.b(this.mvI).getCount() - 1 && BankRemitHistoryUI.b(this.mvI).getCount() > 0 && !BankRemitHistoryUI.c(this.mvI) && !BankRemitHistoryUI.d(this.mvI)) {
            BankRemitHistoryUI.e(this.mvI);
        }
    }
}
