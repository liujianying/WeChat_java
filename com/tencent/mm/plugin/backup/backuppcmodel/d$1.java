package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.f.b.d;
import com.tencent.mm.plugin.backup.h.c;
import com.tencent.mm.plugin.backup.h.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class d$1 implements d {
    final /* synthetic */ d gWN;

    d$1(d dVar) {
        this.gWN = dVar;
    }

    public final void a(boolean z, int i, byte[] bArr, int i2) {
        String str = "MicroMsg.BackupPcRecoverServer";
        String str2 = "onBackupPcRecoverServerNotify isLocal[%b], type[%d], seq[%d], buflen[%d]";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        x.i(str, str2, objArr);
        if (z && 10011 == i) {
            d.a(this.gWN);
        } else if (i == 5) {
            x.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive cancelReq.");
            this.gWN.a(true, false, -100);
            h.mEJ.a(400, 52, 1, false);
            this.gWN.mG(5);
        } else {
            int i3 = b.arV().arW().gWw;
            if (2 != i3 && 4 != i3) {
                x.e("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify cmdmode error[%d]", Integer.valueOf(b.arV().arW().gWw));
            } else if (i == 10) {
                f fVar = (f) g.a(new f(), bArr);
                str2 = "MicroMsg.BackupPcRecoverServer";
                String str3 = "onBackupPcRecoverServerNotify receive heartbeatResp, ack[%d]";
                Object[] objArr2 = new Object[1];
                objArr2[0] = Long.valueOf(fVar != null ? fVar.gXZ : -1);
                x.i(str2, str3, objArr2);
            } else if (i == 18) {
                c cVar = new c();
                try {
                    cVar.aG(bArr);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "onBackupPcRecoverServerNotify buf to BackupCommandResponse error.", new Object[0]);
                }
                x.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandResp, cmd[%d]", Integer.valueOf(cVar.hbr));
                if (cVar.hbr == 9) {
                    if (b.asr() == 1) {
                        b.mJ(2);
                        x.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify reconnect success");
                        this.gWN.mG(20);
                        b.asq();
                        b.arV().aqP().gRC = 23;
                        this.gWN.mw(23);
                        b.mJ(0);
                        return;
                    }
                    x.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify reconnect is started, ignore. state[%d]", Integer.valueOf(b.asr()));
                }
            } else if (i == 17) {
                com.tencent.mm.plugin.backup.h.b bVar = new com.tencent.mm.plugin.backup.h.b();
                try {
                    bVar.aG(bArr);
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e2, "onBackupPcRecoverServerNotify buf to BackupCommandRequest error.", new Object[0]);
                }
                x.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify receive commandReq, cmd[%d]", Integer.valueOf(bVar.hbr));
                if (bVar.hbr == 10) {
                    i3 = b.arV().aqP().gRC;
                    x.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify pc request disconnect, backupPcState[%d]", Integer.valueOf(i3));
                    if (i3 == 22 || i3 == 23) {
                        this.gWN.a(true, false, -4);
                        b.arV().arw().stop();
                        h.mEJ.a(400, 52, 1, false);
                        this.gWN.mG(5);
                        long j = 0;
                        if (d.b(this.gWN) != 0) {
                            j = bi.bH(d.b(this.gWN));
                        }
                        h.mEJ.h(13737, Integer.valueOf(3), Long.valueOf(d.c(this.gWN)), Long.valueOf(j), Integer.valueOf(2));
                        x.i("MicroMsg.BackupPcRecoverServer", "onBackupPcRecoverServerNotify recover transfer disconnect, recoverDataSize:%d, recoverCostTime:%d", Long.valueOf(d.c(this.gWN)), Long.valueOf(j));
                    }
                }
            } else {
                au.Em().H(new 1(this, i, bArr, i2));
            }
        }
    }
}
