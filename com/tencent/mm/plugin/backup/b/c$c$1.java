package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.b.c.b;
import com.tencent.mm.plugin.backup.b.c.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.TimeUnit;

class c$c$1 implements Runnable {
    final /* synthetic */ c gSR;

    c$c$1(c cVar) {
        this.gSR = cVar;
    }

    public final void run() {
        while (!this.gSR.gSo.gSg) {
            ae aeVar = null;
            try {
                aeVar = this.gSR.gSN.poll(500, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
            }
            x.d("MicroMsg.BackupPackAndSend.TagQueueSucker", "TagQueue(%d)startNext obj:%s", new Object[]{Integer.valueOf(this.gSR.gSN.size()), aeVar});
            if (aeVar != null) {
                if (aeVar == this.gSR.gSO) {
                    this.gSR.gSO.open();
                    return;
                }
                b bVar = (b) aeVar;
                bVar.ftu = true;
                bVar.TAG = "MicroMsg.BackupPackAndSend.tag" + (bVar.ftu ? "S." : "W.") + bVar.gRH + "." + bVar.bgn;
                while (!this.gSR.gSo.gSg) {
                    Runnable runnable = null;
                    try {
                        runnable = (Runnable) bVar.gSs.poll(500, TimeUnit.MILLISECONDS);
                    } catch (Exception e2) {
                    }
                    if (runnable != null) {
                        long VF = bi.VF();
                        runnable.run();
                        String str = "MicroMsg.BackupPackAndSend.TagQueueSucker";
                        String str2 = "workerQueue poll q:%d mem:%s rt:%d [%s,%s,%s,%s]";
                        Object[] objArr = new Object[7];
                        objArr[0] = Integer.valueOf(bVar.gSs.size());
                        long j = this.gSR.gSt.gSp.get();
                        String str3 = "[%s,%s,%s]";
                        Object[] objArr2 = new Object[3];
                        objArr2[0] = Long.valueOf(j);
                        objArr2[1] = Integer.valueOf(j >= 8388608 ? 1 : 0);
                        objArr2[2] = Integer.valueOf(j >= 16777216 ? 1 : 0);
                        objArr[1] = String.format(str3, objArr2);
                        objArr[2] = Long.valueOf(bi.bH(VF));
                        objArr[3] = runnable;
                        objArr[4] = bVar;
                        objArr[5] = this.gSR.gSP;
                        objArr[6] = this.gSR.gSP != null ? Integer.valueOf(this.gSR.gSP.gSs.size()) : "null";
                        x.d(str, str2, objArr);
                        if (!bVar.ftu) {
                            break;
                        }
                    }
                }
                System.gc();
            }
        }
    }
}
