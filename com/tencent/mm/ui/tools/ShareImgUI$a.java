package com.tencent.mm.ui.tools;

import android.net.Uri;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.tools.ShareImgUI.c;
import java.io.File;

class ShareImgUI$a implements Runnable {
    private Uri aMJ;
    final /* synthetic */ ShareImgUI uBN;
    private c uBW;

    public ShareImgUI$a(ShareImgUI shareImgUI, Uri uri, c cVar) {
        this.uBN = shareImgUI;
        this.aMJ = uri;
        this.uBW = cVar;
    }

    public final void run() {
        this.uBN.filePath = ShareImgUI.a(this.uBN, this.aMJ);
        if (bi.oW(this.uBN.filePath) || !new File(this.uBN.filePath).exists()) {
            if (ShareImgUI.abf(this.uBN.getContentResolver().getType(this.aMJ)) == 3) {
                this.uBN.filePath = d.a(this.uBN.getContentResolver(), this.aMJ);
            } else {
                this.uBN.filePath = d.a(this.uBN.getContentResolver(), this.aMJ, 1);
            }
        }
        if (this.uBW != null) {
            this.uBW.czz();
        }
    }
}
