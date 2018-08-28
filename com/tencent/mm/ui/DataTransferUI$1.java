package com.tencent.mm.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class DataTransferUI$1 extends ag {
    final /* synthetic */ DataTransferUI tie;

    DataTransferUI$1(DataTransferUI dataTransferUI) {
        this.tie = dataTransferUI;
    }

    public final void handleMessage(Message message) {
        if (DataTransferUI.a(this.tie) != null && DataTransferUI.a(this.tie).isShowing()) {
            x.e("MicroMsg.DataTransferUI", "dialog has shown for a long time, auto dismiss it...");
            DataTransferUI.a(this.tie).dismiss();
            this.tie.finish();
        }
    }
}
