package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.model.a.l.a;
import com.tencent.mm.sdk.platformtools.x;

class l$a$3 implements Runnable {
    final /* synthetic */ a ljc;
    final /* synthetic */ String ljd;

    l$a$3(a aVar, String str) {
        this.ljc = aVar;
        this.ljd = str;
    }

    public final void run() {
        try {
            FileOp.deleteFile(this.ljd);
        } catch (Exception e) {
            x.e("MicroMsg.MMSightFFMpegRecorder", "stop, delete old file error: %s", new Object[]{e.getMessage()});
        }
    }
}
