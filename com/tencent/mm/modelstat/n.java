package com.tencent.mm.modelstat;

import com.tencent.mm.network.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public final class n {
    static {
        bh.reset();
    }

    public static void aY(int i, int i2) {
        if (ab.bU(ad.getContext())) {
            x.i("MicroMsg.NetStatStorageLogic", "dknetflow wifi recv:%d send:%d type:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0)});
            z(i, i2, 0);
            return;
        }
        x.i("MicroMsg.NetStatStorageLogic", "dknetflow mobile recv:%d send:%d type:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0)});
        A(i, i2, 0);
    }

    public static void z(int i, int i2, int i3) {
        k kVar = new k();
        kVar.ejW = i;
        kVar.eki = i2;
        kVar.bWA = 8390656;
        c(kVar);
        a(kVar, i3);
        q.Sj().a(kVar);
    }

    public static void A(int i, int i2, int i3) {
        k kVar = new k();
        kVar.ejV = i;
        kVar.ekh = i2;
        kVar.bWA = 4195328;
        c(kVar);
        a(kVar, i3);
        q.Sj().a(kVar);
    }

    private static void c(k kVar) {
        bh.update();
        kVar.ejX = (int) bh.ciQ();
        kVar.ekj = (int) bh.ciP();
        kVar.ejY = (int) bh.ciO();
        kVar.ekk = (int) bh.ciN();
        kVar.ekl = (int) bh.ciU();
        kVar.ekn = (int) bh.ciT();
        kVar.ekm = (int) bh.ciS();
        kVar.eko = (int) bh.ciR();
        kVar.bWA = (((((((kVar.bWA | 8192) | 33554432) | Downloads.RECV_BUFFER_SIZE) | 16777216) | 134217728) | 536870912) | 67108864) | 268435456;
    }

    private static void a(k kVar, int i) {
        switch (i) {
            case 109:
            case TbsListener$ErrorCode.DOWNLOAD_RETRYTIMES302_EXCEED /*123*/:
                kVar.ejQ = kVar.ejV + kVar.ejW;
                kVar.bWA |= 32;
                return;
            case 110:
                kVar.ekc = kVar.ekh + kVar.eki;
                kVar.bWA |= 131072;
                return;
            case 127:
                kVar.eke = kVar.ekh + kVar.eki;
                kVar.bWA |= 524288;
                return;
            case 128:
                kVar.ejS = kVar.ejV + kVar.ejW;
                kVar.bWA |= 128;
                return;
            case 138:
            case 139:
                kVar.ejO = kVar.ejV + kVar.ejW;
                kVar.bWA |= 8;
                return;
            case 149:
                kVar.ekg = kVar.ekh + kVar.eki;
                kVar.bWA |= 2097152;
                return;
            case 150:
                kVar.ejU = kVar.ejV + kVar.ejW;
                kVar.bWA |= 512;
                return;
            case 522:
                kVar.eka = kVar.ekh + kVar.eki;
                kVar.bWA |= 32768;
                return;
            default:
                return;
        }
    }
}
