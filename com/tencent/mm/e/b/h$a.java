package com.tencent.mm.e.b;

import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

final class h$a implements Runnable {
    final /* synthetic */ h bFa;
    ag handler;

    public h$a(h hVar) {
        this.bFa = hVar;
        this.handler = new 1(this, hVar);
    }

    public final void run() {
        boolean z = true;
        synchronized (this.bFa) {
            if (this.bFa.bEK == null) {
                x.e("MicroMsg.SceneVoice.Recorder", "Stop Record Failed recorder == null");
                return;
            }
            String str = this.bFa.mFileName;
            if (this.bFa.bET) {
                z = false;
            }
            x.d("MicroMsg.SceneVoice.Recorder", "Thread Started Record, fullPath: %s, useSpeex: %s", new Object[]{q.O(str, z), Boolean.valueOf(this.bFa.bET)});
            if (this.bFa.bEK.dc(q.O(str, z))) {
                this.bFa.bEL.requestFocus();
            } else {
                q.op(this.bFa.mFileName);
                this.bFa.mFileName = null;
                this.bFa.bEK = null;
                x.e("MicroMsg.SceneVoice.Recorder", "Thread Start Record  Error fileName[" + this.bFa.mFileName + "]");
            }
            this.bFa.mRecordStartTime = bi.VG();
            x.d("MicroMsg.SceneVoice.Recorder", "Thread Started Record fileName[" + this.bFa.mFileName + "] time:" + bi.bI(this.bFa.bEQ));
            this.handler.sendEmptyMessageDelayed(0, 1);
        }
    }
}
