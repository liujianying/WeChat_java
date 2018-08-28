package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.g;
import java.util.ArrayList;

class WalletOfflineCoinPurseUI$a extends BaseAdapter {
    ArrayList<String> gBc = new ArrayList();
    ArrayList<Boolean> lMB = new ArrayList();
    final /* synthetic */ WalletOfflineCoinPurseUI lMe;

    public WalletOfflineCoinPurseUI$a(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.lMe = walletOfflineCoinPurseUI;
    }

    public final int getCount() {
        return this.gBc.size();
    }

    public final Object getItem(int i) {
        return this.gBc.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final boolean isEnabled(int i) {
        return ((Boolean) this.lMB.get(i)).booleanValue();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        CheckedTextView checkedTextView = (CheckedTextView) View.inflate(this.lMe, g.wallet_list_dialog_item_singlechoice, null);
        checkedTextView.setText((String) this.gBc.get(i));
        if (WalletOfflineCoinPurseUI.blw() == i) {
            checkedTextView.setChecked(true);
        } else {
            checkedTextView.setChecked(false);
        }
        if (isEnabled(i)) {
            checkedTextView.setTextColor(this.lMe.getResources().getColor(c.normal_text_color));
            checkedTextView.setEnabled(true);
        } else {
            checkedTextView.setTextColor(this.lMe.getResources().getColor(c.hint_text_color));
            checkedTextView.setEnabled(false);
        }
        return checkedTextView;
    }
}
