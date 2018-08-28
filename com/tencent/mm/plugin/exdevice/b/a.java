package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.plugin.exdevice.i.e;
import com.tencent.mm.plugin.exdevice.i.f;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends com.tencent.mm.plugin.exdevice.service.i.a {
    private static a isx = null;

    private static class a implements Runnable {
        private long hjj = -1;
        private int isA;
        private byte[] isB = null;
        private int isy = -1;
        private int isz = -1;

        public a(int i, long j, int i2, int i3, byte[] bArr) {
            this.hjj = j;
            this.isy = i2;
            this.isz = i3;
            this.isB = bArr;
            this.isA = i;
        }

        public final void aGz() {
            if (this.hjj == -1 || this.isy == -1 || this.isz == -1) {
                x.e("MicroMsg.RequestProcessThread", "invalid arguments, do nothing");
                return;
            }
            switch (this.isz) {
                case 10001:
                    u.aHG().a(new e(this.isA, this.hjj, this.isy, this.isz, this.isB));
                    return;
                case 10002:
                    k aGF = k.aGF();
                    aGF.mHandler.obtainMessage(1, this.isA, 0, new f(this.hjj, this.isy, this.isz, this.isB)).sendToTarget();
                    return;
                case 10003:
                    u.aHG().a(new f(this.isA, this.hjj, this.isy, this.isz, this.isB));
                    return;
                default:
                    x.e("MicroMsg.RequestProcessThread", "unknown cmdId = %d, do nothing", new Object[]{Integer.valueOf(this.isz)});
                    return;
            }
        }

        public final void run() {
            aGz();
        }
    }

    private a() {
    }

    public static a aGy() {
        if (isx != null) {
            return isx;
        }
        a aVar = new a();
        isx = aVar;
        return aVar;
    }

    public final void a(int i, long j, int i2, int i3, byte[] bArr) {
        int i4;
        String str = "MicroMsg.exdevice.DeviceRequestManager";
        String str2 = "------onDeviceRequest------ errorCode = %d, deviceId = %d, seq = %d, cmdId = %d, datalength = %d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Long.valueOf(j);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(i3);
        objArr[4] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        x.i(str, str2, objArr);
        if (i == 0) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        com.tencent.mm.plugin.exdevice.g.a.l(j, i4);
        if (b.aq(bArr) == null) {
            x.e("MicroMsg.exdevice.DeviceRequestManager", "dataIn is null!!! Just leave without process data");
            return;
        }
        x.d("MicroMsg.exdevice.DeviceRequestManager", "data dump = %s", new Object[]{b.aq(bArr)});
        new a(i, j, i2, i3, bArr).aGz();
    }
}
