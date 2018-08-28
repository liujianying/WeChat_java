package com.tencent.mm.plugin.hce.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class HCETransparentUI$4 implements OnCancelListener {
    final /* synthetic */ HCETransparentUI kjt;

    HCETransparentUI$4(HCETransparentUI hCETransparentUI) {
        this.kjt = hCETransparentUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.i("MicroMsg.HCETransparentUI", "alvinluo cancel by pressing back");
        HCETransparentUI.a(this.kjt, "system NFC switch not opened");
    }
}
