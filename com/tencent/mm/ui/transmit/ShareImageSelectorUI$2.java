package com.tencent.mm.ui.transmit;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;

class ShareImageSelectorUI$2 extends ag {
    final /* synthetic */ ShareImageSelectorUI uET;

    ShareImageSelectorUI$2(ShareImageSelectorUI shareImageSelectorUI) {
        this.uET = shareImageSelectorUI;
    }

    public final void handleMessage(Message message) {
        this.uET.finish();
    }
}
