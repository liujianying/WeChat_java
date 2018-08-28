package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.sdk.platformtools.bi;

class k$1 implements OnClickListener {
    final /* synthetic */ MobileInputUI eSB;
    final /* synthetic */ k eSG;

    k$1(k kVar, MobileInputUI mobileInputUI) {
        this.eSG = kVar;
        this.eSB = mobileInputUI;
    }

    public final void onClick(View view) {
        bi.L(this.eSB, this.eSB.getString(j.url_agreement));
    }
}
