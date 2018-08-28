package com.tencent.mm.plugin.z;

import com.tencent.mm.a.e;
import com.tencent.mm.a.p;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.opensdk.constants.ConstantsAPI$AppSupportContentFlag;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.plugin.backup.h.k;
import com.tencent.mm.plugin.backup.h.l;
import com.tencent.mm.plugin.z.c.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

class c$1 implements Runnable {
    final /* synthetic */ LinkedList lsC;
    final /* synthetic */ long lsD;
    final /* synthetic */ c lsE;

    c$1(c cVar, LinkedList linkedList, long j) {
        this.lsE = cVar;
        this.lsC = linkedList;
        this.lsD = j;
    }

    public final void run() {
        long VF = bi.VF();
        if (this.lsC == null) {
            x.e("MicroMsg.MsgSynchronizePack", "MsgSynchronizeSessionList is null.");
            if (this.lsE.lsB != null) {
                this.lsE.lsB.onCancel();
                return;
            }
            return;
        }
        e.k(new File(f.bfG()));
        e.k(new File(f.bfH()));
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        e.k(new File(stringBuilder.append(c.Gq()).append("msgsynchronize/").toString()));
        stringBuilder = new StringBuilder();
        au.HU();
        e.k(new File(stringBuilder.append(c.Gq()).append("msgsynchronize.zip").toString()));
        LinkedList linkedList = new LinkedList();
        String str = (String) d.asG().asH().DT().get(2, null);
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        PLong pLong = new PLong();
        Iterator it = this.lsC.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            ai Yq = d.asG().asH().FW().Yq(aVar.gRG);
            int i = Yq != null ? Yq.field_unReadCount : 0;
            if (pInt2.value >= b.lsy) {
                break;
            }
            k kVar = new k();
            kVar.hbL = aVar.gRG;
            kVar.hbJ = (int) (d.asG().asH().FT().GZ(aVar.gRG) / 1000);
            kVar.hbK = i;
            linkedList.add(kVar);
            pInt2.value++;
            if (pInt.value < b.lsw) {
                this.lsE.a(aVar, str, i, pInt, pLong, this.lsD);
            }
            if (this.lsE.lsA) {
                break;
            }
        }
        if (this.lsE.lsA) {
            x.e("MicroMsg.MsgSynchronizePack", "MsgSynchronizePack canceled!");
            return;
        }
        l lVar = new l();
        lVar.hbM = linkedList;
        lVar.hbN = com.tencent.mm.az.d.SF().clP();
        try {
            f.e(f.bfF(), "sessionlist", lVar.toByteArray());
            x.i("MicroMsg.MsgSynchronizePack", "BackupSessionInfoList pack finish.");
        } catch (Exception e) {
            x.e("MicroMsg.MsgSynchronizePack", "ERROR: BackupSessionInfoList to Buffer, list:%d :%s", new Object[]{Integer.valueOf(lVar.hbM.size()), e.getMessage()});
        }
        p.b(new File(f.bfG()), false, f.bfH());
        x.i("MicroMsg.MsgSynchronizePack", "synchronize finish, backupCostTime[%d]", new Object[]{Long.valueOf(bi.bH(VF))});
        long cm = (long) e.cm(f.bfH());
        if (this.lsE.lsB != null) {
            this.lsE.lsB.a(f.bfH(), this.lsC.size(), str, pInt.value, pLong.value, cm / ConstantsAPI$AppSupportContentFlag.MMAPP_SUPPORT_XLS);
        }
    }
}
