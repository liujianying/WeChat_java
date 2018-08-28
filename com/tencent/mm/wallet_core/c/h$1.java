package com.tencent.mm.wallet_core.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.MMActivity;

class h$1 implements OnClickListener {
    final /* synthetic */ MMActivity bAl;
    final /* synthetic */ h uXg;

    h$1(h hVar, MMActivity mMActivity) {
        this.uXg = hVar;
        this.bAl = mMActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.bAl.finish();
    }
}
