package com.tencent.mm.plugin.backup.c;

import android.content.SharedPreferences;
import com.tencent.mm.plugin.backup.a.f;
import com.tencent.mm.plugin.backup.b.b.b;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class a implements b {
    boolean gTA = false;
    public com.tencent.mm.plugin.backup.b.b gTt;
    public b gTu;
    public long gTv;
    private LinkedList<f.b> gTw = null;
    private LinkedList<f.b> gTx = null;
    public LinkedList<f.b> gTy = null;
    public boolean gTz = false;
    private Object lock = new Object();

    public final LinkedList<f.b> arq() {
        if (this.gTw == null) {
            this.gTw = new LinkedList();
        }
        return this.gTw;
    }

    private static long B(LinkedList<f.b> linkedList) {
        long j = 0;
        if (linkedList != null && linkedList.size() > 0) {
            long j2 = ((f.b) linkedList.get(0)).gRJ;
            Iterator it = linkedList.iterator();
            while (true) {
                j = j2;
                if (!it.hasNext()) {
                    break;
                }
                f.b bVar = (f.b) it.next();
                if (j > bVar.gRJ) {
                    j2 = bVar.gRJ;
                } else {
                    j2 = j;
                }
            }
        }
        return j;
    }

    public final LinkedList<f.b> arr() {
        if (this.gTx == null) {
            this.gTx = new LinkedList();
        }
        return this.gTx;
    }

    public final void a(int i, long j, long j2, LinkedList<f.b> linkedList) {
        if (i == 0) {
            this.gTx = new LinkedList(linkedList);
            return;
        }
        this.gTx = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            f.b bVar = (f.b) it.next();
            if (d.asG().asH().FT().r(bVar.gRI, j, j2) > 0) {
                this.gTx.add(bVar);
            }
        }
    }

    public final LinkedList<f.b> ars() {
        if (this.gTy == null) {
            this.gTy = new LinkedList();
        }
        return this.gTy;
    }

    public final void art() {
        this.gTw = null;
        this.gTy = null;
        this.gTx = null;
        this.gTA = false;
        this.gTz = false;
    }

    public final void cancel() {
        synchronized (this.lock) {
            if (this.gTt != null) {
                this.gTt.cancel();
                this.gTt = null;
            }
        }
    }

    public final void aru() {
        b.arv();
        SharedPreferences aqU = b.aqU();
        a(aqU.getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0), aqU.getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0), aqU.getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0), arq());
    }

    public final void y(LinkedList<f.b> linkedList) {
        x.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish.");
        this.gTz = true;
        this.gTw = new LinkedList(linkedList);
        this.gTv = B(this.gTw);
        aru();
        x.i("MicroMsg.BackupMoveChooseServer", "onCalcuConvFinish, calAllConvNames size[%d], showConvNames size[%d]", Integer.valueOf(arq().size()), Integer.valueOf(arr().size()));
        if (this.gTu != null) {
            this.gTu.y(arr());
        }
    }

    public final void a(LinkedList<f.b> linkedList, f.b bVar, int i) {
        x.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeProgress.");
        this.gTw = linkedList;
        if (this.gTx != null) {
            Iterator it = this.gTx.iterator();
            while (it.hasNext()) {
                f.b bVar2 = (f.b) it.next();
                if (bVar2.gRI.equals(bVar.gRI)) {
                    bVar2.gRL = bVar.gRL;
                    bVar2.gRM = bVar.gRM;
                    break;
                }
            }
        }
        if (b.arv().arx().gUz) {
            x.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
            b.arv().aqP().D(13, i, linkedList.size());
            b.arv().arx().mw(13);
        }
        if (this.gTu != null) {
            this.gTu.a(arr(), bVar, i);
        }
    }

    public final void z(LinkedList<f.b> linkedList) {
        x.i("MicroMsg.BackupMoveChooseServer", "onCalcuSizeFinish.");
        this.gTA = true;
        this.gTw = (LinkedList) linkedList.clone();
        aru();
        if (b.arv().arx().gUz) {
            x.i("MicroMsg.BackupMoveChooseServer", "onCalcuChooseSizeFinish startRequestNotify");
            b.arv().arx().arJ();
        } else if (this.gTu != null) {
            this.gTu.z(linkedList);
        }
    }
}
