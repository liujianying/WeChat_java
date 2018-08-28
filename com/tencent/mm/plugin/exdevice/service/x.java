package com.tencent.mm.plugin.exdevice.service;

public final class x implements m {
    private h iyT;

    public x(h hVar) {
        this.iyT = hVar;
    }

    public final boolean b(int i, j jVar) {
        boolean z = false;
        try {
            return this.iyT.b(i, jVar);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "scan failed!!! %s", new Object[]{e.getMessage()});
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            return z;
        }
    }

    public final boolean c(int i, j jVar) {
        boolean z = false;
        try {
            return this.iyT.c(i, jVar);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "stopScan failed!!! %s", new Object[]{e.getMessage()});
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            return z;
        }
    }

    public final long[] aHt() {
        try {
            return this.iyT.aHt();
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "getDeviceList failed!!! %s", new Object[]{e.getMessage()});
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[0]);
            return null;
        }
    }

    public final boolean a(long j, int i, k kVar) {
        boolean z = false;
        u.aHF().cQ(j);
        try {
            return this.iyT.a(j, i, kVar);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "startChannel failed!!! %s", new Object[]{e.getMessage()});
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            return z;
        }
    }

    public final boolean cT(long j) {
        boolean z = false;
        u.aHF().cQ(j);
        try {
            return this.iyT.cT(j);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "stopChannel failed!!! %s", new Object[]{e.getMessage()});
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            return z;
        }
    }

    public final long a(p pVar) {
        try {
            return this.iyT.a(pVar);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "startTask failed!!! %s", new Object[]{e.getMessage()});
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[0]);
            return -1;
        }
    }

    public final boolean a(i iVar) {
        boolean z = false;
        try {
            return this.iyT.a(iVar);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "registOnDeviceRequest failed!!! %s", new Object[]{e.getMessage()});
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            return z;
        }
    }

    public final void setChannelSessionKey(long j, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.exdevice.RDeviceTaskDispatcher", "------setChannelSessionKey------ deviceId = %d", new Object[]{Long.valueOf(j)});
        try {
            this.iyT.setChannelSessionKey(j, bArr);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[0]);
        }
    }

    public final boolean a(String str, boolean z, q qVar) {
        boolean z2 = false;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.exdevice.RDeviceTaskDispatcher", "ranging, uuid = %s, op = %s", new Object[]{str, String.valueOf(z)});
        try {
            return this.iyT.a(str, z, qVar);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "mDispatcher.ranging failed!!!(%s)", new Object[]{e.getMessage()});
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z2]);
            return z2;
        }
    }

    public final boolean b(n nVar) {
        try {
            this.iyT.a(nVar);
            return true;
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.exdevice.RDeviceTaskDispatcher", "mDispatcher.registExDeviceInvokerHandler failed!!, %s", new Object[]{e.getMessage()});
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[0]);
            return false;
        }
    }

    public final boolean a(j jVar) {
        boolean z = false;
        try {
            return this.iyT.d(0, jVar);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            return z;
        }
    }

    public final boolean b(j jVar) {
        boolean z = false;
        try {
            return this.iyT.e(0, jVar);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            return z;
        }
    }

    public final boolean a(long j, k kVar) {
        boolean z = false;
        try {
            return this.iyT.b(j, 0, kVar);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            return z;
        }
    }

    public final boolean cW(long j) {
        boolean z = false;
        try {
            return this.iyT.cW(j);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            return z;
        }
    }

    public final boolean a(s sVar) {
        boolean z = false;
        try {
            return this.iyT.a(sVar);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            return z;
        }
    }

    public final boolean b(long j, byte[] bArr, t tVar) {
        boolean z = false;
        try {
            return this.iyT.b(j, bArr, tVar);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.exdevice.RDeviceTaskDispatcher", e, "", new Object[z]);
            return z;
        }
    }
}
