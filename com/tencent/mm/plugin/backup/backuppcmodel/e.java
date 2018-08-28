package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences.Editor;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.a.b.b;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.f.b.d;
import com.tencent.mm.plugin.backup.f.j;
import com.tencent.mm.plugin.backup.h.m;
import com.tencent.mm.plugin.backup.h.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class e {
    private static boolean gTb = false;
    private static boolean gUB = false;
    static boolean gWQ = false;
    private b gSh = new 5(this);
    final com.tencent.mm.ab.e gUl = new com.tencent.mm.ab.e() {
        public final void a(int i, int i2, String str, l lVar) {
            com.tencent.mm.plugin.backup.f.b.b(3, e.this.gUl);
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp success, errMsg[%s]", new Object[]{str});
                o oVar = ((j) lVar).gYv;
                if (b.arV().gRu.equals(oVar.ID)) {
                    b.arV().aqP().gRF = oVar.hbV;
                    x.i("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp BigDataSize[%d]", new Object[]{Long.valueOf(oVar.hbV)});
                    au.HU();
                    c.DT().a(a.sVe, Boolean.valueOf(false));
                    com.tencent.mm.plugin.backup.f.b.asl();
                    e.a(e.this);
                    return;
                }
                x.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd startResp not the same id");
                h.mEJ.a(400, 118, 1, false);
                b.arV().aqP().gRC = -5;
                e.this.mH(-5);
                return;
            }
            x.e("MicroMsg.BackupPcServer", "onSendStartRequestEnd receive startResp failed, errType[%d], errCode[%d], errMsg[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            h.mEJ.a(400, 117, 1, false);
            b.arV().aqP().gRC = -5;
            e.this.mH(-5);
        }
    };
    LinkedList<String> gUu;
    private com.tencent.mm.plugin.backup.b.b gUv;
    com.tencent.mm.plugin.backup.b.c gUw;
    private long gUx = 0;
    private long gUy = 0;
    public Set<com.tencent.mm.plugin.backup.a.b.c> gWI = new HashSet();
    public com.tencent.mm.plugin.backup.a.b.a gWJ;
    private boolean gWL = false;
    public boolean gWR = false;
    public boolean gWS = false;
    final com.tencent.mm.ab.e gWT = new 2(this);
    private final d gWU = new 3(this);

    static /* synthetic */ void a(e eVar) {
        com.tencent.mm.plugin.backup.f.b.a(11, eVar.gWT);
        com.tencent.mm.plugin.backup.f.h hVar = new com.tencent.mm.plugin.backup.f.h(eVar.gUu, eVar.gUx, eVar.gUy);
        x.i("MicroMsg.BackupPcServer", "backupPcSendRequestSession, chooseConvNames size[%d]", new Object[]{Integer.valueOf(eVar.gUu.size())});
        hVar.ass();
    }

    public static void asf() {
        gWQ = true;
    }

    public final void init() {
        x.i("MicroMsg.BackupPcServer", "BackupPcServer init.");
        gWQ = false;
        this.gWL = false;
        com.tencent.mm.plugin.backup.f.b.a(this.gWU);
        this.gUw = new com.tencent.mm.plugin.backup.b.c(b.arV(), 1, this.gSh);
    }

    public final void an(boolean z) {
        x.i("MicroMsg.BackupPcServer", "cancel, isSelf[%b], Caller:%s", new Object[]{Boolean.valueOf(z), aj.cin()});
        gWQ = true;
        if (!z) {
            b.arV().arW();
            c.arE();
        }
        this.gUw.cancel();
        if (this.gUv != null) {
            this.gUv.cancel();
            this.gUv = null;
        }
        com.tencent.mm.plugin.backup.f.b.asm();
        com.tencent.mm.plugin.backup.f.b.aso();
        com.tencent.mm.plugin.backup.f.b.asq();
    }

    public final void D(LinkedList<String> linkedList) {
        this.gUu = linkedList;
        b.arV();
        if (b.aqU().getInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0) == 1) {
            gUB = true;
        } else {
            gUB = false;
        }
        b.arV();
        this.gUx = b.aqU().getLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0);
        b.arV();
        this.gUy = b.aqU().getLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0);
        b.arV();
        if (b.aqU().getInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0) == 1) {
            gTb = true;
        } else {
            gTb = false;
        }
        String str = "MicroMsg.BackupPcServer";
        String str2 = "setBackupChooseData users size[%d], isSelectTime[%b], isQuickBackup[%b], selectStartTime[%d], selectEndTime[%d]";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
        objArr[1] = Boolean.valueOf(gUB);
        objArr[2] = Boolean.valueOf(gTb);
        objArr[3] = Long.valueOf(this.gUx);
        objArr[4] = Long.valueOf(this.gUy);
        x.i(str, str2, objArr);
        au.HU();
        c.DT().a(a.sUY, Boolean.valueOf(true));
        if (1 == b.arV().arW().gWw) {
            b.arV();
            Editor edit = b.aqU().edit();
            edit.putString("BACKUP_PC_CHOOSE_SESSION", g.a("", ",", linkedList == null ? new String[0] : (String[]) linkedList.toArray(new String[linkedList.size()])));
            edit.commit();
        }
    }

    public static void d(int i, long j, long j2, int i2) {
        x.i("MicroMsg.BackupPcServer", "setBackupSelectTimeData, timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)});
        if (i == 0) {
            j2 = 0;
            j = 0;
        }
        b.arV();
        Editor edit = b.aqU().edit();
        if (1 == b.arV().arW().gWw) {
            edit.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", i);
            edit.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", i2);
            edit.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", j);
            edit.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", j2);
        }
        edit.commit();
    }

    public final void bV(long j) {
        int i = 3;
        x.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest");
        com.tencent.mm.plugin.backup.f.b.a(3, this.gUl);
        j jVar = new j(b.arV().gRu);
        PLong pLong = new PLong();
        PLong pLong2 = new PLong();
        au.HU();
        g.a(pLong, pLong2, c.Gq());
        if (!gTb) {
            au.HU();
            if (((Boolean) c.DT().get(a.sVe, Boolean.valueOf(false))).booleanValue()) {
                i = 0;
            } else {
                i = 1;
            }
        }
        m bU = g.bU(pLong2.value);
        jVar.gYu.hbV = 0;
        jVar.gYu.hbW = j;
        jVar.gYu.hbX = 0;
        jVar.gYu.hbY = bU;
        jVar.gYu.hbZ = 0;
        jVar.gYu.hca = i;
        x.i("MicroMsg.BackupPcServer", "backupPcSendStartRequest sessionCount:%d, transferType:%d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
        jVar.ass();
    }

    public final void mG(int i) {
        long arc;
        long j;
        long j2 = 0;
        if (this.gUw != null) {
            if (this.gUw.gSk != 0) {
                j2 = bi.bH(this.gUw.gSk);
            }
            arc = this.gUw.arc();
            j = j2;
        } else {
            arc = 0;
            j = 0;
        }
        h.mEJ.h(13737, new Object[]{Integer.valueOf(i), Long.valueOf(arc), Long.valueOf(j / 1000), Integer.valueOf(1), Integer.valueOf(b.arV().arW().gWC)});
        x.i("MicroMsg.BackupPcServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], backupCostTime[%d s]", new Object[]{Integer.valueOf(13737), Integer.valueOf(i), Long.valueOf(arc), Long.valueOf(j / 1000)});
    }

    public final void aqN() {
        Set hashSet = new HashSet();
        hashSet.addAll(this.gWI);
        ah.A(new 4(this, hashSet));
    }

    public final void mH(int i) {
        this.gSh.mw(i);
    }
}
