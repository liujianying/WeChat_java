package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.plugin.backup.h.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class f {
    public static int gXV = 10000;
    public static int gXW = 5000;
    a gUp;
    private int gXX = 0;
    private long gXY = 0;
    private long gXZ = 0;
    private boolean gYa = false;
    Boolean gYb = null;

    public f(a aVar) {
        this.gUp = aVar;
    }

    public final void asB() {
        this.gXY = bi.VF();
        x.d("MicroMsg.BackupHeartBeatHandler", "updateHeartBeatTimeStamp[%d]", new Object[]{Long.valueOf(this.gXY)});
        this.gYa = false;
        if (this.gXX != 0) {
            this.gXX = 0;
            this.gUp.mC(0);
        }
    }

    public final void asC() {
        this.gXZ = this.gXZ == Long.MAX_VALUE ? 0 : this.gXZ + 1;
        e eVar = new e();
        eVar.gXZ = this.gXZ;
        try {
            x.i("MicroMsg.BackupHeartBeatHandler", "sendBackupHeartBeatRequest send heartbeat req, ack:%d", new Object[]{Long.valueOf(eVar.gXZ)});
            b.J(eVar.toByteArray(), 9);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupHeartBeatHandler", e, "buf to BackupHeartBeatRequest err.", new Object[0]);
        }
    }
}
