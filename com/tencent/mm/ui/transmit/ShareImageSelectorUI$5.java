package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ShareImageSelectorUI$5 implements OnClickListener {
    final /* synthetic */ ShareImageSelectorUI uET;

    ShareImageSelectorUI$5(ShareImageSelectorUI shareImageSelectorUI) {
        this.uET = shareImageSelectorUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (ShareImageSelectorUI.uw() == 1) {
            ShareImageSelectorUI.c(this.uET);
        }
    }
}
