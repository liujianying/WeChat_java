package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

final class f$a implements Runnable {
    final /* synthetic */ f pUs;

    private f$a(f fVar) {
        this.pUs = fVar;
    }

    /* synthetic */ f$a(f fVar, byte b) {
        this(fVar);
    }

    public final void run() {
        if (this.pUs.pUp != null) {
            int length = new File(this.pUs.pUp).getParentFile().listFiles(new 1(this)).length;
            for (int i = 0; i < length; i++) {
                x.i("MicroMsg.ViewCaptureHelper", "deleteFile result: %b", new Object[]{Boolean.valueOf(r2[i].delete())});
            }
            this.pUs.pUp = null;
        }
    }
}
