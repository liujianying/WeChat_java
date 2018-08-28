package com.tencent.mm.permission;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.n;
import com.tencent.mm.ar.j;
import com.tencent.mm.ar.k;
import com.tencent.mm.ar.m;
import com.tencent.mm.ar.r;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements e {
    private static a euX;
    private boolean euY = false;
    private int mRetryTimes = 3;

    public static a Vj() {
        if (euX == null) {
            euX = new a();
        }
        return euX;
    }

    public final void Vk() {
        if (au.HX()) {
            if (!this.euY) {
                au.HU();
                if (c.isSDCardAvailable()) {
                    au.HU();
                    if (bi.VF() - ((Long) c.DT().get(327944, Long.valueOf(0))).longValue() >= 86400000) {
                        release();
                        this.euY = true;
                        au.DF().a(new k(23), 0);
                        au.DF().a(159, this);
                        au.DF().a(160, this);
                        return;
                    }
                    return;
                }
            }
            x.e("MicroMsg.PermissionConfigUpdater", "not to update, isUpdating: %s", new Object[]{Boolean.valueOf(this.euY)});
        }
    }

    private void release() {
        this.euY = false;
        au.DF().b(159, this);
        au.DF().b(160, this);
    }

    public final void a(int i, int i2, String str, l lVar) {
        if ((lVar instanceof n) && ((n) lVar).Lf() == 23) {
            int type = lVar.getType();
            if (159 == type) {
                if (i == 0 && i2 == 0) {
                    Qk();
                    m[] ik = r.Qp().ik(23);
                    if (ik == null || ik.length == 0) {
                        x.i("MicroMsg.PermissionConfigUpdater", "error no pkg found.");
                        release();
                        return;
                    }
                    m mVar = ik[0];
                    x.i("MicroMsg.PermissionConfigUpdater", "permission, pkgId: %d, version: %d, status: %d, type: %d", new Object[]{Integer.valueOf(mVar.id), Integer.valueOf(mVar.version), Integer.valueOf(mVar.status), Integer.valueOf(mVar.bPh)});
                    if (5 != mVar.status) {
                        release();
                        return;
                    }
                    au.DF().a(new j(mVar.id, 23), 0);
                    return;
                }
                type = this.mRetryTimes - 1;
                this.mRetryTimes = type;
                if (type <= 0) {
                    if (au.HX()) {
                        au.HU();
                        c.DT().set(327944, Long.valueOf((bi.VF() - 86400000) + 3600000));
                    }
                    this.mRetryTimes = 3;
                }
                release();
                return;
            } else if (160 == type) {
                if (i == 0 && i2 == 0) {
                    Qk();
                }
                release();
                return;
            } else {
                return;
            }
        }
        x.d("MicroMsg.PermissionConfigUpdater", "another scene");
    }

    private static void Qk() {
        if (au.HX()) {
            au.HU();
            c.DT().set(327944, Long.valueOf(bi.VF()));
        }
    }
}
