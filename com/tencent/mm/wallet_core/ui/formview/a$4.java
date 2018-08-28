package com.tencent.mm.wallet_core.ui.formview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.v;

class a$4 implements OnClickListener {
    final /* synthetic */ MMActivity ixt;
    final /* synthetic */ WalletFormView uZj;

    a$4(WalletFormView walletFormView, MMActivity mMActivity) {
        this.uZj = walletFormView;
        this.ixt = mMActivity;
    }

    public final void onClick(View view) {
        this.uZj.getContext();
        int cDn = v.cDn();
        this.uZj.getContext();
        b.a(this.ixt, cDn, v.cDo());
    }
}
