package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.g;

class WalletCardImportUI$9 extends BaseAdapter {
    final /* synthetic */ WalletCardImportUI puv;

    WalletCardImportUI$9(WalletCardImportUI walletCardImportUI) {
        this.puv = walletCardImportUI;
    }

    public final int getCount() {
        return WalletCardImportUI.c(this.puv).bOF() != null ? WalletCardImportUI.c(this.puv).bOF().size() : 0;
    }

    private Integer zq(int i) {
        return (Integer) WalletCardImportUI.c(this.puv).bOF().get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        CheckedTextView checkedTextView = (CheckedTextView) View.inflate(this.puv, g.wallet_list_dialog_item_singlechoice, null);
        checkedTextView.setText(o.bPe().Q(this.puv, zq(i).intValue()));
        if (WalletCardImportUI.f(this.puv) == zq(i).intValue()) {
            checkedTextView.setChecked(true);
        } else {
            checkedTextView.setChecked(false);
        }
        checkedTextView.setBackgroundResource(e.comm_list_item_selector);
        return checkedTextView;
    }
}
