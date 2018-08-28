package com.tencent.mm.ui.tools;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class ShareImgUI$3 extends ag {
    final /* synthetic */ ShareImgUI uBN;

    ShareImgUI$3(ShareImgUI shareImgUI) {
        this.uBN = shareImgUI;
    }

    public final void handleMessage(Message message) {
        if (bi.oW(this.uBN.filePath)) {
            x.e("MicroMsg.ShareImgUI", "launch : fail, filePath is null");
            ShareImgUI.d(this.uBN);
            this.uBN.finish();
            return;
        }
        ShareImgUI.c(this.uBN);
    }
}
