package com.tencent.mm.plugin.dbbackup;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.d;

class d$6 implements Runnable {
    final /* synthetic */ d iam;
    final /* synthetic */ String iax;

    d$6(d dVar, String str) {
        this.iam = dVar;
        this.iax = str;
    }

    public final void run() {
        if (!d.cn((this.iax + "corrupted/EnMicroMsg.db") + ".corrupt")) {
            long currentTimeMillis = System.currentTimeMillis();
            b bVar = new b(this.iax + "corrupted");
            if (bVar.isDirectory()) {
                b[] cBY = bVar.cBY();
                int length = cBY.length;
                int i = 0;
                while (i < length) {
                    if (currentTimeMillis - cBY[i].lastModified() >= 7776000000L) {
                        i++;
                    } else {
                        return;
                    }
                }
                if (d.I(bVar.aMJ.toString(), false)) {
                    x.i("MicroMsg.SubCoreDBBackup", "Corrupted databases removed.");
                }
            }
        }
    }
}
