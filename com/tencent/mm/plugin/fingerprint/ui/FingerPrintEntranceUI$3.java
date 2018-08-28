package com.tencent.mm.plugin.fingerprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.x;

class FingerPrintEntranceUI$3 implements OnClickListener {
    final /* synthetic */ FingerPrintEntranceUI jhw;

    FingerPrintEntranceUI$3(FingerPrintEntranceUI fingerPrintEntranceUI) {
        this.jhw = fingerPrintEntranceUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.FingerPrintEntranceUI", "user click the button to open fingerprint pay");
        d.A(this.jhw, "wallet", ".pwd.ui.WalletPasswordSettingUI");
        this.jhw.finish();
    }
}
