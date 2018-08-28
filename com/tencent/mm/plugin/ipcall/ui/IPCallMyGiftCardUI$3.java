package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.x;

class IPCallMyGiftCardUI$3 implements OnCancelListener {
    final /* synthetic */ IPCallMyGiftCardUI kwG;

    IPCallMyGiftCardUI$3(IPCallMyGiftCardUI iPCallMyGiftCardUI) {
        this.kwG = iPCallMyGiftCardUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        try {
            if (IPCallMyGiftCardUI.a(this.kwG) != null) {
                au.DF().c(IPCallMyGiftCardUI.a(this.kwG));
            }
            this.kwG.finish();
        } catch (Exception e) {
            x.e("MicroMsg.IPCallMyGiftCardUI", "cancel getProductListScene error: %s", new Object[]{e.getMessage()});
        }
    }
}
