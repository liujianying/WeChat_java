package com.tencent.mm.plugin.fts.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;

class FTSBaseUI$3 extends ag {
    final /* synthetic */ FTSBaseUI jwn;

    FTSBaseUI$3(FTSBaseUI fTSBaseUI) {
        this.jwn = fTSBaseUI;
    }

    public final void handleMessage(Message message) {
        if (message.what == 1 && !bi.oW(FTSBaseUI.b(this.jwn))) {
            this.jwn.aQy();
        }
    }
}
