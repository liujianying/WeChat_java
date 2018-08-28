package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.x;

class n$7 implements Runnable {
    final /* synthetic */ String ljd;
    final /* synthetic */ n ljp;

    n$7(n nVar, String str) {
        this.ljp = nVar;
        this.ljd = str;
    }

    public final void run() {
        try {
            FileOp.deleteFile(this.ljd);
        } catch (Exception e) {
            x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, delete old file error: %s", new Object[]{e.getMessage()});
        }
    }
}
