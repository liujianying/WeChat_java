package com.tencent.mm.plugin.collect.reward.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

class QrRewardSetMoneyUI$a extends BaseAdapter {
    final /* synthetic */ QrRewardSetMoneyUI hWL;

    private QrRewardSetMoneyUI$a(QrRewardSetMoneyUI qrRewardSetMoneyUI) {
        this.hWL = qrRewardSetMoneyUI;
    }

    /* synthetic */ QrRewardSetMoneyUI$a(QrRewardSetMoneyUI qrRewardSetMoneyUI, byte b) {
        this(qrRewardSetMoneyUI);
    }

    public final int getCount() {
        return QrRewardSetMoneyUI.e(this.hWL).size();
    }

    public final Object getItem(int i) {
        return QrRewardSetMoneyUI.e(this.hWL).get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            return (View) QrRewardSetMoneyUI.f(this.hWL).get(i);
        }
        return view;
    }
}
