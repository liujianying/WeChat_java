package com.tencent.mm.plugin.backup.f;

import android.os.Looper;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.Queue;

public final class i {
    private static int gYk = 300000;
    private a gUq;
    long gYl = 0;
    long gYm;
    long gYn;
    long gYo;
    long gYp;
    int gYq = 0;
    Queue<Long> gYr = new LinkedList();
    al gYs = new al(Looper.getMainLooper(), new a() {
        public final boolean vD() {
            long j = 0;
            long bH = bi.bH(i.this.gYo);
            if (bH != 0) {
                i.this.gYm = (i.this.gYn / bH) * 1000;
                i.this.gYr.offer(Long.valueOf(i.this.gYm));
                try {
                    bH = ((Long) i.this.gYr.poll()).longValue();
                } catch (Exception e) {
                    bH = 0;
                }
                i.this.gYm = (((i.this.gYl * 10) - bH) + i.this.gYm) / 10;
                i iVar = i.this;
                if (i.this.gYm > 0) {
                    j = i.this.gYm;
                }
                iVar.gYm = j;
                i.this.gYl = i.this.gYm;
                i.this.gYn = 0;
                i.this.gYo = bi.VF();
                i.this.gUq.arG();
                if (i.this.gYm < 2) {
                    if (i.this.gYq == 0) {
                        i.this.gYq = 1;
                        i.this.gUq.mB(1);
                        i.this.gYp = bi.VF();
                        x.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is low speed! backupLowSpeedStartTime[%d]", new Object[]{Long.valueOf(i.this.gYp)});
                    } else if (i.this.gYq == 1 && bi.bH(i.this.gYp) > ((long) i.gYk)) {
                        x.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler low speed overtime, overtime[%d]", new Object[]{Long.valueOf(bi.bH(i.this.gYp))});
                        i.this.gYq = 2;
                        i.this.gUq.arH();
                    }
                } else if (i.this.gYq != 0) {
                    i.this.gYq = 0;
                    i.this.gUq.mB(0);
                    x.i("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is not low speed now.");
                }
            }
            return true;
        }
    }, true);

    public i(a aVar) {
        this.gUq = aVar;
        if (b.chp()) {
            gYk = 60000;
        }
    }

    static String bW(long j) {
        if ((j >> 30) > 0) {
            return bi.b(j, 100.0d);
        }
        if ((j >> 20) > 0) {
            return bi.a(j, 100.0d);
        }
        if ((j >> 9) <= 0) {
            return j + " B";
        }
        return Math.round(((float) j) / 1024.0f) + " KB";
    }
}
