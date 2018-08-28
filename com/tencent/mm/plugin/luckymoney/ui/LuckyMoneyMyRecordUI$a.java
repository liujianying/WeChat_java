package com.tencent.mm.plugin.luckymoney.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.mm.plugin.wxpay.a$g;
import java.util.List;

class LuckyMoneyMyRecordUI$a extends BaseAdapter {
    int atr;
    List<String> kVK;
    final /* synthetic */ LuckyMoneyMyRecordUI kVL;

    LuckyMoneyMyRecordUI$a(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
        this.kVL = luckyMoneyMyRecordUI;
    }

    public final int getCount() {
        return this.kVK.size();
    }

    /* renamed from: jl */
    public final String getItem(int i) {
        return (String) this.kVK.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        CheckedTextView checkedTextView = (CheckedTextView) LayoutInflater.from(this.kVL.mController.tml).inflate(a$g.wallet_list_dialog_item_singlechoice, viewGroup, false);
        checkedTextView.setText(getItem(i));
        if (i == this.atr) {
            checkedTextView.setChecked(true);
        } else {
            checkedTextView.setChecked(false);
        }
        return checkedTextView;
    }
}
