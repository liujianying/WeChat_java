package com.tencent.mm.plugin.cdndownloader.c;

import android.os.RemoteException;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class a$3 implements a {
    final /* synthetic */ a hKi;

    a$3(a aVar) {
        this.hKi = aVar;
    }

    public final boolean vD() {
        boolean z;
        x.d("MicroMsg.CDNDownloadClient", "checkProcessTimer");
        if (this.hKi.hKc.size() == 0) {
            return false;
        }
        if (this.hKi.hKb != null) {
            try {
                x.d("MicroMsg.CDNDownloadClient", "checkActive");
                this.hKi.hKb.aAi();
            } catch (RemoteException e) {
                x.e("MicroMsg.CDNDownloadClient", "check process active false");
                h.mEJ.a(710, 3, 1, false);
                if (System.currentTimeMillis() - this.hKi.hKa > 120000) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    this.hKi.hKa = System.currentTimeMillis();
                    for (CDNTaskInfo cDNTaskInfo : this.hKi.hKc) {
                        cDNTaskInfo.hKp = true;
                    }
                    this.hKi.aAl();
                    return true;
                }
                x.i("MicroMsg.CDNDownloadClient", "dead twice in 1 min, something wrong must be happened");
                h.mEJ.a(710, 4, 1, false);
                for (CDNTaskInfo cDNTaskInfo2 : this.hKi.hKc) {
                    this.hKi.hKd.f(cDNTaskInfo2.downloadUrl, 4, com.tencent.mm.plugin.downloader.a.a.ibj, null);
                }
                this.hKi.hKc.clear();
                return false;
            }
        }
        return true;
    }
}
