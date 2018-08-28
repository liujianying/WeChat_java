package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.p;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public class a implements c {
    private long iyn = -1;
    protected c izu = null;
    protected d izv = null;
    private m izw = null;

    public a(c cVar, d dVar) {
        this.izu = cVar;
        this.izv = dVar;
    }

    public final void a(d dVar) {
        this.izv = dVar;
    }

    public final boolean b(m mVar) {
        if (mVar == null) {
            x.e("MicroMsg.exdevice.ExDeviceTask", "dispatcher is null");
            return false;
        } else if (this.izw != null) {
            x.e("MicroMsg.exdevice.ExDeviceTask", "Prev task is still working!!!");
            return false;
        } else {
            x.i("MicroMsg.exdevice.ExDeviceTask", "------startTask begin------cmdReqId = %d, cmdRespId = %d, deviceId = %d", new Object[]{Short.valueOf(this.izu.aGA()), Short.valueOf(this.izu.isC), Long.valueOf(this.izu.hjj)});
            m mVar2 = new m(this.izu, this);
            long a = mVar.a(mVar2);
            if (-1 == a) {
                x.e("MicroMsg.exdevice.ExDeviceTask", "dispatcher.startTask Failed!!!");
                return false;
            }
            this.izw = mVar2;
            this.iyn = a;
            mVar2 = this.izw;
            Assert.assertNotNull(mVar2.izR);
            l lVar = mVar2.izR;
            lVar.izK = false;
            lVar.izL = false;
            au.Em().cil().postDelayed(lVar.izM, 15000);
            return true;
        }
    }

    public final void a(long j, int i, int i2, String str, p pVar) {
        int i3 = 1;
        x.i("MicroMsg.exdevice.ExDeviceTask", "------onTaskEnd------ taskId = %d, errType = %d, errCode = %d, errMsg = %s, deviceId = %d, reqCmdId = %d, respCmdId = %d", new Object[]{Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str, Long.valueOf(this.izu.hjj), Short.valueOf(this.izu.aGA()), Short.valueOf(this.izu.isC)});
        com.tencent.mm.plugin.exdevice.g.a.l(this.izu.hjj, i == 0 ? 1 : 0);
        if (pVar == null || pVar == this.izw) {
            if (-1 == i && -2 == i2) {
                x.e("MicroMsg.exdevice.ExDeviceTask", "Time Out in local!!!");
            }
            int i4 = this.izu.isD != null ? this.izu.isD.iwS : 0;
            if (-5 == i4 || -3 == i4 || -4 == i4) {
                x.w("MicroMsg.exdevice.ExDeviceTask", "ErrorCode = %d, destroy channel(deviceId = %d)", new Object[]{Integer.valueOf(this.izu.isD.iwS), Long.valueOf(this.izu.hjj)});
                if (u.aHG().isY == null || !u.aHG().isY.cT(this.izu.hjj)) {
                    i3 = 0;
                }
                if (i3 == 0) {
                    x.e("MicroMsg.exdevice.ExDeviceTask", "stopChannel Failed!!!");
                }
            }
            if (this.izv != null) {
                this.izv.a(j, i, i2, str);
            }
            this.izw = null;
            return;
        }
        x.e("MicroMsg.exdevice.ExDeviceTask", "netCmd != mRemoteTask");
    }
}
