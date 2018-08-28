package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.e;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.d;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends ae {
    private e izA;
    private a izB;
    private int mErrorCode;

    public f(int i, long j, int i2, int i3, byte[] bArr) {
        this.izA = new e(j, i2, i3, bArr);
        this.mErrorCode = i;
    }

    public final boolean a(m mVar, d dVar) {
        if (!u.aHF().cR(this.izA.hjj)) {
            x.e("MicroMsg.exdevice.MMInitTaskExcuter", "This device send other cmd before do auth, device id = %d", new Object[]{Long.valueOf(this.izA.hjj)});
            this.izA.a(-2, "", new byte[0], new byte[0], 0, 0);
            this.izB = new a(this.izA, dVar);
            x.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[]{Boolean.valueOf(this.izB.b(mVar))});
            return this.izB.b(mVar);
        } else if (-5 == this.mErrorCode || -3 == this.mErrorCode || -4 == this.mErrorCode) {
            x.e("MicroMsg.exdevice.MMInitTaskExcuter", "Error Code = %d, reply errorcode to device and close channel", new Object[]{Integer.valueOf(this.mErrorCode)});
            this.izA.a(-1, "", new byte[0], new byte[0], 0, 0);
            this.izB = new a(this.izA, dVar);
            x.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[]{Boolean.valueOf(this.izB.b(mVar))});
            return this.izB.b(mVar);
        } else {
            com.tencent.mm.plugin.exdevice.e.f fVar = (com.tencent.mm.plugin.exdevice.e.f) this.izA.aGD();
            if (fVar == null) {
                x.e("MicroMsg.exdevice.MMInitTaskExcuter", "Init Request parse failed, Tell device before stop this task");
                this.izA.a(-4, "", new byte[0], new byte[0], 0, 0);
                this.izB = new a(this.izA, dVar);
                x.i("MicroMsg.exdevice.MMInitTaskExcuter", "init start task : %b", new Object[]{Boolean.valueOf(this.izB.b(mVar))});
                return this.izB.b(mVar);
            }
            byte[] toByteArray;
            byte[] toByteArray2;
            if (fVar.iwV != null) {
                toByteArray = fVar.iwV.toByteArray();
            } else {
                toByteArray = null;
            }
            if (fVar.iwU != null) {
                toByteArray2 = fVar.iwU.toByteArray();
            } else {
                toByteArray2 = null;
            }
            ad.aHl();
            int aGM = d.aGM();
            switch (aGM) {
                case 1:
                case 2:
                    break;
                default:
                    x.e("MicroMsg.exdevice.MMInitTaskExcuter", "initScene = %d, Cannot start init response", new Object[]{Integer.valueOf(aGM)});
                    break;
            }
            this.izA.a(0, null, toByteArray2, toByteArray, aGM, (int) (b.aIs() / 1000));
            this.izB = new a(this.izA, dVar);
            return this.izB.b(mVar);
        }
    }
}
