package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.backup.a.f.a;
import com.tencent.mm.plugin.backup.b.c;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.f.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

class e$2 implements e {
    final /* synthetic */ e gWV;

    e$2(e eVar) {
        this.gWV = eVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        b.b(11, this.gWV.gWT);
        if (i == 0 && i2 == 0) {
            h hVar = (h) lVar;
            LinkedList linkedList = hVar.gYj.hbH;
            LinkedList linkedList2 = hVar.gYj.hbI;
            LinkedList linkedList3 = new LinkedList();
            HashSet hashSet = new HashSet();
            Iterator it = linkedList2.iterator();
            long j = 0;
            long j2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < linkedList.size()) {
                    if (it.hasNext()) {
                        j = ((Long) it.next()).longValue();
                        if (it.hasNext()) {
                            j2 = ((Long) it.next()).longValue();
                        }
                    }
                    hashSet.add(linkedList.get(i4));
                    linkedList3.add(new a(hashSet.size() - 1, (String) linkedList.get(i4), j, j2));
                    i3 = i4 + 1;
                } else {
                    x.i("MicroMsg.BackupPcServer", "requestSessionSceneEnd receive requestsessionResp, backupSessionList size[%d]", new Object[]{Integer.valueOf(linkedList3.size())});
                    c b = e.b(this.gWV);
                    b.arV().arW();
                    b.a(linkedList3, b.arV().aqP().gRF, e.access$100());
                    return;
                }
            }
        }
        x.e("MicroMsg.BackupPcServer", "requestSessionSceneEnd sessionName or timeInterval null or request session resp number error, errType[%d], errCode[%d], errMsg[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        com.tencent.mm.plugin.report.service.h.mEJ.a(400, 119, 1, false);
        this.gWV.an(false);
        b.arV().aqP().gRC = -5;
        this.gWV.mH(-5);
    }
}
