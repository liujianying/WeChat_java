package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ShareImageSelectorUI$4 implements OnClickListener {
    final /* synthetic */ ShareImageSelectorUI uET;

    ShareImageSelectorUI$4(ShareImageSelectorUI shareImageSelectorUI) {
        this.uET = shareImageSelectorUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.uET.finish();
    }
}
