package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class ShareImageSelectorUI$7 implements OnCancelListener {
    final /* synthetic */ ShareImageSelectorUI uET;

    ShareImageSelectorUI$7(ShareImageSelectorUI shareImageSelectorUI) {
        this.uET = shareImageSelectorUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ShareImageSelectorUI.b(this.uET);
    }
}
