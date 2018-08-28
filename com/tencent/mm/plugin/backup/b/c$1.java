package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.a.f.a;
import com.tencent.mm.plugin.backup.b.c.c;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import junit.framework.Assert;

class c$1 implements Runnable {
    final /* synthetic */ LinkedList gSl;
    final /* synthetic */ long gSm;
    final /* synthetic */ boolean gSn;
    final /* synthetic */ c gSo;

    c$1(c cVar, LinkedList linkedList, long j, boolean z) {
        this.gSo = cVar;
        this.gSl = linkedList;
        this.gSm = j;
        this.gSn = z;
    }

    public final void run() {
        if (this.gSl == null) {
            x.e("MicroMsg.BackupPackAndSend", "backupChatRunnable backupSessionList is null.");
            if (this.gSo.gSh != null) {
                this.gSo.gSh.aqM();
                this.gSo.gSi.aqP().gRC = -21;
                this.gSo.gSh.mw(-21);
                return;
            }
            return;
        }
        int i;
        b.asn();
        LinkedList linkedList = this.gSl;
        HashSet hashSet = new HashSet();
        if (linkedList == null) {
            i = 0;
        } else {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                hashSet.add(((a) it.next()).gRG);
            }
            i = hashSet.size();
        }
        this.gSo.gSi.aqP().D(14, 1, i);
        this.gSo.gSh.mw(14);
        String str = (String) d.asG().asH().DT().get(2, null);
        this.gSo.gSk = bi.VF();
        c cVar = new c(this.gSo);
        for (int i2 = 0; i2 < this.gSl.size(); i2++) {
            this.gSo.a((a) this.gSl.get(i2), cVar, str, this.gSm, this.gSn);
            if (this.gSo.gSg) {
                break;
            }
        }
        if (this.gSo.gSg) {
            x.e("MicroMsg.BackupPackAndSend", "backupChatRunnable cancel!");
            return;
        }
        long VF = bi.VF();
        long VF2 = bi.VF();
        cVar.gSN.offer(cVar.gSO);
        cVar.gSO.block();
        x.i("MicroMsg.BackupPackAndSend.TagQueueSucker", "waitFinish Finish Now:%d", new Object[]{Long.valueOf(bi.bH(VF2))});
        Assert.assertTrue(cVar.gSN.isEmpty());
        x.i("MicroMsg.BackupPackAndSend", "backupChatRunnable finish, Session[%d], loopTime[%d], waitSendTime[%d]", new Object[]{Integer.valueOf(this.gSl.size()), Long.valueOf(bi.bH(this.gSo.gSk)), Long.valueOf(bi.bH(VF))});
        this.gSo.ard();
        this.gSo.gSi.aqP().D(15, i, i);
        this.gSo.gSh.mw(15);
        this.gSo.dt(true);
        b.asm();
        b.aso();
        this.gSo.gSh.aqL();
        x.i("MicroMsg.BackupPackAndSend", "backupChatRunnable backupfinish, backupDataSize[%d], backupCostTime[%d], backupStartTime[%d]", new Object[]{Long.valueOf(this.gSo.gSj), Long.valueOf(bi.bH(this.gSo.gSk)), Long.valueOf(this.gSo.gSk)});
    }
}
