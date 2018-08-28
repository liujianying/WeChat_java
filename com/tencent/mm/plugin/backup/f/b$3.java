package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.plugin.backup.f.b.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map.Entry;

class b$3 implements Runnable {
    final /* synthetic */ b gXJ;

    b$3(b bVar) {
        this.gXJ = bVar;
    }

    public final void run() {
        int i = 0;
        synchronized (b.asw()) {
            long VF = bi.VF();
            for (Entry entry : b.asw().entrySet()) {
                int i2;
                if (entry != null) {
                    try {
                        PByteArray a = b.a((b) entry.getValue());
                        if (a != null) {
                            if (b.asx() != null) {
                                b.asx().k(((Integer) entry.getKey()).intValue(), a.value);
                                x.i("MicroMsg.BackupBaseScene", "resendSceneMap sceneSeq[%d], type[%d], sceneBuf[%d]", new Object[]{entry.getKey(), Integer.valueOf(((b) entry.getValue()).getType()), Integer.valueOf(a.value.length)});
                            } else {
                                x.e("MicroMsg.BackupBaseScene", "resendSceneMap engineSender null, sceneSeq[%d], type[%d], sceneBuf[%d]", new Object[]{entry.getKey(), Integer.valueOf(((b) entry.getValue()).getType()), Integer.valueOf(a.value.length)});
                            }
                            i2 = i + 1;
                        } else {
                            x.e("MicroMsg.BackupBaseScene", "resendSceneMap sceneBuf null, sceneSeq[%d]", new Object[]{entry.getKey()});
                            i2 = i + 1;
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.BackupBaseScene", e, "req to buf fail: " + e.toString(), new Object[0]);
                    }
                } else {
                    i2 = i;
                }
                if (i2 > 0) {
                    if (i2 % 5 == 0) {
                        this.gXJ.dz(false);
                    }
                }
                i = i2;
            }
            this.gXJ.dz(true);
            x.i("MicroMsg.BackupBaseScene", "resendSceneMap finish, sceneMap[%d], time[%d]", new Object[]{Integer.valueOf(b.asw().size()), Long.valueOf(bi.bH(VF))});
        }
    }
}
