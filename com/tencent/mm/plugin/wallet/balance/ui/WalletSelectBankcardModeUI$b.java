package com.tencent.mm.plugin.wallet.balance.ui;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet.balance.ui.WalletSelectBankcardModeUI.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;

@SuppressLint({"ViewHolder"})
class WalletSelectBankcardModeUI$b extends BaseAdapter {
    final /* synthetic */ WalletSelectBankcardModeUI paR;

    public final /* synthetic */ Object getItem(int i) {
        return (a) WalletSelectBankcardModeUI.b(this.paR).get(i);
    }

    WalletSelectBankcardModeUI$b(WalletSelectBankcardModeUI walletSelectBankcardModeUI) {
        this.paR = walletSelectBankcardModeUI;
    }

    public final int getCount() {
        return WalletSelectBankcardModeUI.b(this.paR).size();
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = View.inflate(this.paR, g.wallet_select_bankcard_item, null);
        a aVar = (a) WalletSelectBankcardModeUI.b(this.paR).get(i);
        TextView textView = (TextView) inflate.findViewById(f.bankcard_tips);
        ImageView imageView = (ImageView) inflate.findViewById(f.selected_icon);
        ((TextView) inflate.findViewById(f.bankcard_title)).setText(aVar.title);
        if (TextUtils.isEmpty(aVar.hyz)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(aVar.hyz);
        }
        if (WalletSelectBankcardModeUI.c(this.paR) == i) {
            imageView.setImageResource(h.radio_on);
        } else {
            imageView.setImageResource(h.radio_off);
        }
        return inflate;
    }
}
