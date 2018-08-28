package com.tencent.mm.pluginsdk.g.a.c;

import android.database.Cursor;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

class p$1 implements Runnable {
    p$1() {
    }

    public final void run() {
        List list = null;
        q ccH = a.ccH();
        int networkType = p.getNetworkType();
        x.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, networkType = %d", new Object[]{Integer.valueOf(networkType)});
        if (networkType == 0) {
            x.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, networkType is unavailable");
        } else if (ccH.fAQ) {
            if (ccH.fAQ) {
                long VF = bi.VF();
                Cursor axc = ccH.qDu.axc();
                if (axc != null) {
                    if (axc.getCount() <= 0) {
                        axc.close();
                    } else {
                        list = new LinkedList();
                        axc.moveToFirst();
                        do {
                            s sVar = new s();
                            sVar.d(axc);
                            list.add(sVar);
                        } while (axc.moveToNext());
                        axc.close();
                    }
                }
                x.i("MicroMsg.ResDownloaderCore", "queryAll: cost = %d", new Object[]{Long.valueOf(bi.bH(VF))});
            }
            if (bi.cX(list)) {
                x.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, no record stored, skip this resumeAll-op");
                return;
            }
            for (s sVar2 : list) {
                if (!bi.oW(sVar2.field_groupId1)) {
                    int hashCode = sVar2.field_groupId1.hashCode();
                    for (g gVar : r.ccI()) {
                        if (hashCode == bi.oV(gVar.aca()).hashCode()) {
                            gVar.bUP().a(sVar2, networkType);
                        }
                    }
                }
            }
        } else {
            x.e("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, core can not work");
        }
    }
}
