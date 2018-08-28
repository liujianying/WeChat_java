package com.tencent.mm.aw;

import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

class e$1 implements IdleHandler {
    final /* synthetic */ e ehE;

    public e$1(e eVar) {
        this.ehE = eVar;
    }

    public final boolean queueIdle() {
        if (g.DF().foreground) {
            x.w("MicroMsg.SpeexUploadCore", "skiped resume speex uploader, not foreground");
        } else {
            x.d("MicroMsg.SpeexUploadCore", "now resume speex uploader");
            e.a(this.ehE).lh(false);
        }
        return false;
    }
}
