package com.tencent.mm.wallet_core.ui.formview;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.a.9;

class a$9$1 implements OnClickListener {
    final /* synthetic */ 9 uZk;

    a$9$1(9 9) {
        this.uZk = 9;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        e.l(this.uZk.ixt, "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/payunregshow?operation=1", false);
        a.sFg.m(new sx());
    }
}
