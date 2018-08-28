package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class f$1 implements Runnable {
    final /* synthetic */ f gYc;

    f$1(f fVar) {
        this.gYc = fVar;
    }

    public final void run() {
        while (!f.a(this.gYc).booleanValue()) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            if (f.a(this.gYc).booleanValue()) {
                x.i("MicroMsg.BackupHeartBeatHandler", "start BackupSendBackupHeartBeat thread stopped.");
                return;
            }
            long bH = bi.bH(f.b(this.gYc));
            x.d("MicroMsg.BackupHeartBeatHandler", "start heartBeatState[%d], heartBeatTimeStamp[%d], timeDiff[%d], hasSendHeartBeat[%b]", new Object[]{Integer.valueOf(f.c(this.gYc)), Long.valueOf(f.b(this.gYc)), Long.valueOf(bH), Boolean.valueOf(f.d(this.gYc))});
            if (f.d(this.gYc)) {
                if (bH >= ((long) f.gXW) && f.c(this.gYc) != 1) {
                    x.e("MicroMsg.BackupHeartBeatHandler", "start weak connect Timeout Now! heartBeatTimeStamp[%d], timeDiff[%d]", new Object[]{Long.valueOf(f.b(this.gYc)), Long.valueOf(bH)});
                    f.a(this.gYc, 1);
                    f.e(this.gYc).mC(1);
                }
            } else if (bH < ((long) f.gXV)) {
                f.a(this.gYc, 0);
                f.e(this.gYc).mC(0);
            } else {
                x.e("MicroMsg.BackupHeartBeatHandler", "start send heartbeat req, heartBeatTimeStamp[%d], timeDiff[%d]", new Object[]{Long.valueOf(f.b(this.gYc)), Long.valueOf(bH)});
                this.gYc.asC();
                this.gYc.asB();
                f.f(this.gYc);
            }
        }
    }
}
