package com.tencent.mm.ui.tools;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class ShareScreenImgUI$1 extends ag {
    final /* synthetic */ ShareScreenImgUI uBX;

    ShareScreenImgUI$1(ShareScreenImgUI shareScreenImgUI) {
        this.uBX = shareScreenImgUI;
    }

    public final void handleMessage(Message message) {
        ShareScreenImgUI.a(this.uBX);
        if (bi.oW(this.uBX.filePath)) {
            x.e("MicroMsg.ShareScreenImgUI", "launch : fail, filePath is null");
            ShareScreenImgUI.b(this.uBX);
            this.uBX.finish();
            return;
        }
        ShareScreenImgUI.c(this.uBX);
    }
}
