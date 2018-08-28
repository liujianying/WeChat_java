package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ar.j;
import com.tencent.mm.ar.k;
import com.tencent.mm.ar.m;
import com.tencent.mm.ar.r;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

public final class d implements e {
    private static d kol = null;
    private boolean dFt = false;
    c kom = new 1(this);
    private int retryCount = 0;

    private d() {
    }

    public static d aXf() {
        if (kol == null) {
            kol = new d();
        }
        return kol;
    }

    public final void fN(boolean z) {
        if (!au.HX()) {
            x.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, acc not ready");
        } else if (this.dFt) {
            x.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate updating");
        } else {
            x.d("MicroMsg.IPCallCoutryConfigUpdater", "tryupdate, isForce: %b", new Object[]{Boolean.valueOf(z)});
            if (!z) {
                au.HU();
                long longValue = ((Long) com.tencent.mm.model.c.DT().get(a.sQQ, Long.valueOf(0))).longValue();
                long currentTimeMillis = System.currentTimeMillis();
                if (longValue != 0 && Math.abs(currentTimeMillis - longValue) < 86400000) {
                    x.i("MicroMsg.IPCallCoutryConfigUpdater", "tryUpdate, not reach the update time limit");
                    return;
                }
            }
            x.i("MicroMsg.IPCallCoutryConfigUpdater", "try update now");
            this.dFt = true;
            au.DF().a(159, this);
            au.DF().a(160, this);
            aXg();
        }
    }

    private static void aXg() {
        boolean z;
        m[] ik = r.Qp().ik(26);
        if (ik == null || ik.length <= 0) {
            z = false;
        } else {
            z = true;
        }
        au.DF().a(new k(z), 0);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.dFt)});
        if (this.dFt) {
            boolean z;
            if (i == 0 || i2 == 0) {
                z = true;
            } else {
                z = false;
            }
            x.d("MicroMsg.IPCallCoutryConfigUpdater", "onSceneEnd, isSuccess: %b", new Object[]{Boolean.valueOf(z)});
            if (lVar.getType() == 159) {
                if (z) {
                    x.d("MicroMsg.IPCallCoutryConfigUpdater", "get package list success, start download");
                    m[] ik = r.Qp().ik(26);
                    if (ik == null || ik.length == 0) {
                        x.d("MicroMsg.IPCallCoutryConfigUpdater", "do not exist package info");
                        aXh();
                        return;
                    }
                    x.d("MicroMsg.IPCallCoutryConfigUpdater", "infos.length: %d", new Object[]{Integer.valueOf(ik.length)});
                    m mVar = ik[0];
                    x.d("MicroMsg.IPCallCoutryConfigUpdater", "stored info type: %d, id: %d, version: %d, status: %d, name: %s", new Object[]{Integer.valueOf(mVar.bPh), Integer.valueOf(mVar.id), Integer.valueOf(mVar.version), Integer.valueOf(mVar.status), mVar.Ql()});
                    if (mVar.status == 3) {
                        x.d("MicroMsg.IPCallCoutryConfigUpdater", "downloading this package, ignore");
                    } else if (mVar.status != 5) {
                        x.d("MicroMsg.IPCallCoutryConfigUpdater", "already download this package");
                        c.aXb().fM(true);
                        aXh();
                    } else {
                        au.DF().a(new j(mVar.id, 26), 0);
                    }
                } else if (this.retryCount < 3) {
                    this.retryCount++;
                    aXg();
                    x.d("MicroMsg.IPCallCoutryConfigUpdater", "retry get package list, retryCount: %d", new Object[]{Integer.valueOf(this.retryCount)});
                } else {
                    x.e("MicroMsg.IPCallCoutryConfigUpdater", "reach retry limit");
                }
            } else if (lVar.getType() == 160 && z) {
                x.d("MicroMsg.IPCallCoutryConfigUpdater", "download package success");
                c.aXb().fM(true);
                aXh();
            }
        }
    }

    private void aXh() {
        this.dFt = false;
        this.retryCount = 0;
        long currentTimeMillis = System.currentTimeMillis();
        au.HU();
        com.tencent.mm.model.c.DT().a(a.sQQ, Long.valueOf(currentTimeMillis));
    }
}
