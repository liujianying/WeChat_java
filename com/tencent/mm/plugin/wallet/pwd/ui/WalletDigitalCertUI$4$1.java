package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI.4;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.c.r;

class WalletDigitalCertUI$4$1 implements OnClickListener {
    final /* synthetic */ 4 phA;
    final /* synthetic */ r phz;

    WalletDigitalCertUI$4$1(4 4, r rVar) {
        this.phA = 4;
        this.phz = rVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.WalletDigitalCertUI", "del crt %s", new Object[]{this.phz.spW});
        this.phA.phy.a(new f(this.phz.spW), true, true);
    }
}
