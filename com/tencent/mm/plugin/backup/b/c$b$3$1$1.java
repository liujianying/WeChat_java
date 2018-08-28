package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.b.c.b.3.1;
import com.tencent.mm.plugin.backup.e.h.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class c$b$3$1$1 implements Runnable {
    final /* synthetic */ LinkedList gSI;
    final /* synthetic */ 1 gSJ;

    c$b$3$1$1(1 1, LinkedList linkedList) {
        this.gSJ = 1;
        this.gSI = linkedList;
    }

    public final void run() {
        int i = 0;
        while (this.gSI != null && i < this.gSI.size()) {
            Long l = (Long) this.gSI.get(i);
            a aVar = (a) this.gSJ.gSH.gSD.gSy.get(l);
            String str = this.gSJ.gSH.gSD.TAG;
            String str2 = "backupBigDataFiles svrIdIndex:%d(%d), svrId:%d media:%s item:%s";
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(this.gSI.size());
            objArr[2] = l;
            objArr[3] = aVar == null ? "null" : aVar.gVU.mediaId;
            objArr[4] = aVar == null ? "null" : aVar.gVU.path;
            x.i(str, str2, objArr);
            if (aVar != null) {
                this.gSJ.gSH.gSD.gSw.add(aVar.gVU.mediaId);
                this.gSJ.gSH.gSD.f(aVar.gVU.mediaId, aVar.gVU.path, true);
            }
            i++;
        }
        this.gSJ.gSH.gSD.gSs.offer(this.gSJ.gSH.gSD.gSC);
    }
}
