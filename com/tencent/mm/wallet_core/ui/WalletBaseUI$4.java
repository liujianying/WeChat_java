package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;

class WalletBaseUI$4 implements OnClickListener {
    final /* synthetic */ WalletBaseUI uYT;

    WalletBaseUI$4(WalletBaseUI walletBaseUI) {
        this.uYT = walletBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.uYT.cDH();
        c af = a.af(this.uYT);
        if (af == null) {
            this.uYT.finish();
        } else if (!af.h(this.uYT, this.uYT.sy)) {
            af.b(this.uYT, this.uYT.sy);
        }
    }
}
