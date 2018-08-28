package com.tencent.mm.aq;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.b.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class p$1 implements a {
    final /* synthetic */ p ecq;

    p$1(p pVar) {
        this.ecq = pVar;
    }

    public final boolean vD() {
        x.d("MicroMsg.OplogService", "summeroplog pusherTry onTimerExpired tryStartNetscene");
        p pVar = this.ecq;
        long VF = bi.VF();
        if (pVar.dGS && VF - pVar.dHc > 10000) {
            pVar.dGS = false;
        }
        if (pVar.dGS) {
            x.d("MicroMsg.OplogService", "summeroplog tryStartNetscene netSceneRunning, return.");
        } else {
            i iVar = pVar.ecp;
            List arrayList = new ArrayList();
            Cursor b = iVar.dCZ.b("select oplog2.id,oplog2.inserTime,oplog2.cmdId,oplog2.buffer,oplog2.reserved1,oplog2.reserved2,oplog2.reserved3,oplog2.reserved4 from oplog2  order by inserTime asc limit ?", new String[]{"200"}, 0);
            List list;
            if (b == null) {
                list = arrayList;
            } else {
                int count = b.getCount();
                if (count > 0) {
                    for (int i = 0; i < count; i++) {
                        b.moveToPosition(i);
                        b bVar = new b(0);
                        bVar.id = b.getInt(0);
                        bVar.dSH = b.getLong(1);
                        bVar.cmdId = b.getInt(2);
                        bVar.buffer = b.getBlob(3);
                        bVar.lcD = b.getInt(4);
                        bVar.lcE = b.getLong(5);
                        bVar.lcF = b.getString(6);
                        bVar.lcG = b.getString(7);
                        arrayList.add(bVar);
                    }
                }
                b.close();
                list = arrayList;
            }
            if (list.size() == 0) {
                x.d("MicroMsg.OplogService", "summeroplog tryStartNetscene list null ret");
            } else {
                if (!pVar.dGS && list.size() > 0) {
                    pVar.dHc = VF;
                    pVar.dGS = true;
                    Object<b> linkedList = new LinkedList();
                    for (b bVar2 : list) {
                        if (bVar2.getCmdId() == 0 && bVar2.lcD > 0) {
                            linkedList.add(bVar2);
                        }
                    }
                    list.removeAll(linkedList);
                    for (b bVar22 : linkedList) {
                        if ("@openim".equals(bVar22.lcF)) {
                            g.Ek();
                            g.Eh().dpP.a(new d(bVar22), 0);
                        } else {
                            pVar.ecp.a(bVar22);
                        }
                    }
                    if (!list.isEmpty()) {
                        g.Ek();
                        g.Eh().dpP.a(new a(list), 0);
                    }
                }
                x.d("MicroMsg.OplogService", "summeroplog tryStartNetscene ret ok lastNetscene: %d,  netSceneRunning:%B, take:%d ms. ", new Object[]{Long.valueOf(pVar.dHc), Boolean.valueOf(pVar.dGS), Long.valueOf(System.currentTimeMillis() - VF)});
            }
        }
        return false;
    }

    public final String toString() {
        return super.toString() + "|pusherTry";
    }
}
