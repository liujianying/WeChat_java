package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import com.tencent.mm.plugin.backup.a.f.b;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class a implements com.tencent.mm.plugin.backup.b.b.a {
    public long gTv;
    private LinkedList<b> gTw = null;
    private LinkedList<b> gTx = null;
    private LinkedList<b> gTy = null;
    public boolean gTz = false;
    com.tencent.mm.plugin.backup.b.b gUv;
    public boolean gWn = false;
    public com.tencent.mm.plugin.backup.b.b.a gWo;
    private Object lock = new Object();

    private static long B(LinkedList<b> linkedList) {
        long j = 0;
        if (linkedList != null && linkedList.size() > 0) {
            long j2 = ((b) linkedList.get(0)).gRJ;
            Iterator it = linkedList.iterator();
            while (true) {
                j = j2;
                if (!it.hasNext()) {
                    break;
                }
                b bVar = (b) it.next();
                if (j > bVar.gRJ) {
                    j2 = bVar.gRJ;
                } else {
                    j2 = j;
                }
            }
        }
        return j;
    }

    public final LinkedList<b> arq() {
        if (this.gTw == null) {
            this.gTw = new LinkedList();
        }
        return this.gTw;
    }

    public final LinkedList<b> arr() {
        if (this.gTx == null) {
            this.gTx = new LinkedList();
        }
        return this.gTx;
    }

    public final void a(int i, long j, long j2, LinkedList<b> linkedList) {
        if (i == 0) {
            this.gTx = new LinkedList(linkedList);
            return;
        }
        if (this.gTx == null) {
            this.gTx = new LinkedList();
        } else {
            this.gTx.clear();
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (d.asG().asH().FT().r(bVar.gRI, j, j2) > 0) {
                this.gTx.add(bVar);
            }
        }
    }

    public final void C(LinkedList<b> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            this.gTy = new LinkedList();
            return;
        }
        this.gTy = new LinkedList(linkedList.subList((linkedList.size() * 3) / 4, linkedList.size()));
        this.gTy.addAll(linkedList.subList(0, (linkedList.size() * 3) / 4));
    }

    private LinkedList<b> ars() {
        if (this.gTy == null) {
            this.gTy = new LinkedList();
        }
        return this.gTy;
    }

    public final void dy(boolean z) {
        x.i("MicroMsg.BackupPcChooseServer", "calculateToChoose, isChooseAllRecords[%b]", new Object[]{Boolean.valueOf(z)});
        this.gWn = z;
        d.asG().asJ();
        e.post(new 1(this), "BackupPcChooseServer.calculateToChoose");
    }

    public final void y(LinkedList<b> linkedList) {
        String str = "MicroMsg.BackupPcChooseServer";
        String str2 = "onCalcuConvFinish, conv size[%d]";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
        x.i(str, str2, objArr);
        this.gTz = true;
        if (linkedList == null || linkedList.size() == 0) {
            if (this.gWo != null) {
                this.gWo.y(linkedList);
            }
            if (this.gWn) {
                e arX = b.arV().arX();
                e.gWQ = true;
                arX.gUw.ard();
                b.arV().arw().stop();
                b.arV().aqP().gRC = -23;
                b.arV().arX().mH(-23);
                return;
            }
            return;
        }
        this.gTw = new LinkedList(linkedList);
        this.gTv = B(this.gTw);
        b.arV();
        SharedPreferences aqU = com.tencent.mm.plugin.backup.a.d.aqU();
        a(aqU.getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0), aqU.getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0), aqU.getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0), arq());
        x.i("MicroMsg.BackupPcChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", new Object[]{Integer.valueOf(linkedList.size()), Integer.valueOf(arr().size())});
        if (this.gWn) {
            C(arr());
            b.arV().arX().D(g.x(ars()));
            b.arV().arX().bV((long) ars().size());
        }
        if (this.gWo != null) {
            this.gWo.y(arr());
        }
    }

    public final void art() {
        this.gTw = null;
        this.gTy = null;
        this.gTx = null;
        this.gTz = false;
    }

    public final void cancel() {
        x.i("MicroMsg.BackupPcChooseServer", "cancel, stack:%s", new Object[]{bi.cjd()});
        synchronized (this.lock) {
            if (this.gUv != null) {
                this.gUv.cancel();
                this.gUv = null;
            }
            this.gTz = false;
        }
    }
}
