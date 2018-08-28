package com.tencent.mm.plugin.wallet_payu.create.ui;

import android.support.v4.view.u;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_payu.create.a.d;
import com.tencent.mm.plugin.wxpay.a.f;

class WalletPayUOpenIntroView$a extends u {
    final /* synthetic */ WalletPayUOpenIntroView pEJ;

    private WalletPayUOpenIntroView$a(WalletPayUOpenIntroView walletPayUOpenIntroView) {
        this.pEJ = walletPayUOpenIntroView;
    }

    /* synthetic */ WalletPayUOpenIntroView$a(WalletPayUOpenIntroView walletPayUOpenIntroView, byte b) {
        this(walletPayUOpenIntroView);
    }

    public final int getCount() {
        return WalletPayUOpenIntroView.c(this.pEJ) == null ? 0 : WalletPayUOpenIntroView.c(this.pEJ).length;
    }

    public final Object b(ViewGroup viewGroup, int i) {
        View view = (View) WalletPayUOpenIntroView.d(this.pEJ).get(i);
        viewGroup.addView(view);
        d dVar = WalletPayUOpenIntroView.c(this.pEJ)[i];
        TextView textView = (TextView) view.findViewById(f.tip);
        TextView textView2 = (TextView) view.findViewById(f.hint);
        ((ImageView) view.findViewById(f.logo)).setImageResource(dVar.pED);
        textView.setText(dVar.titleRes);
        textView2.setText(dVar.pEE);
        return view;
    }

    public final boolean a(View view, Object obj) {
        return view == obj;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) WalletPayUOpenIntroView.d(this.pEJ).get(i));
    }
}
