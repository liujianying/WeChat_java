package com.tencent.mm.plugin.fts.ui;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;

class FTSBaseVoiceSearchUI$3 extends ag {
    final /* synthetic */ FTSBaseVoiceSearchUI jwp;

    FTSBaseVoiceSearchUI$3(FTSBaseVoiceSearchUI fTSBaseVoiceSearchUI) {
        this.jwp = fTSBaseVoiceSearchUI;
    }

    public final void handleMessage(Message message) {
        if (message.what == 1 && !bi.oW(FTSBaseVoiceSearchUI.b(this.jwp))) {
            this.jwp.aQy();
        }
    }
}
