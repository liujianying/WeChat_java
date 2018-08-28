package com.tencent.mm.modelmulti;

import com.tencent.mm.g.a.hc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.s.b;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class l {
    public static boolean PJ() {
        boolean z;
        g.Ek();
        if (bi.oV((String) g.Ei().DT().get(8195, null)).length() > 0) {
            g.Ek();
            if (bi.f((Integer) g.Ei().DT().get(15, null)) != 0) {
                z = false;
                x.i("MicroMsg.NewSyncMgr", "summerinit needInit ret[%b]", new Object[]{Boolean.valueOf(z)});
                return z;
            }
        }
        z = true;
        x.i("MicroMsg.NewSyncMgr", "summerinit needInit ret[%b]", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    public static void a(int i, byte[] bArr, byte[] bArr2, long j) {
        b bVar = new b();
        PByteArray pByteArray = new PByteArray();
        PByteArray pByteArray2 = new PByteArray();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        PInt pInt3 = new PInt(0);
        PInt pInt4 = new PInt(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.CTRL_BYTE);
        try {
            x.i("MicroMsg.NewSyncMgr", "summerdiz dealWithPushResp unpack ret[%b], noticeid[%d]", new Object[]{Boolean.valueOf(MMProtocalJni.unpack(pByteArray2, bArr, bArr2, pByteArray, pInt, pInt2, pInt3, pInt4)), Integer.valueOf(pInt3.value)});
            if (pInt3.value != 0) {
                hc hcVar = new hc();
                hcVar.bQo.bQp = pInt3.value;
                boolean m = a.sFg.m(hcVar);
                x.i("MicroMsg.NewSyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[]{Integer.valueOf(pInt3.value), Boolean.valueOf(m)});
                pInt3.value = 0;
            }
            if (r3) {
                bVar.qWC = pInt4.value;
                if (pInt.value == -13) {
                    bVar.qWB = pInt.value;
                    x.e("MicroMsg.NewSyncMgr", "unpack push resp failed session timeout");
                    return;
                }
                int G = bVar.G(pByteArray2.value);
                x.d("MicroMsg.NewSyncMgr", "bufToResp using protobuf ok");
                bVar.qWB = G;
                bVar.bufferSize = (long) bArr.length;
                g.Ek();
                byte[] WP = bi.WP(bi.oV((String) g.Ei().DT().get(8195, null)));
                byte[] a = ab.a(bVar.qWX.rny);
                g.Ek();
                g.Eg().aW(bVar.qWX.hcd, bVar.qWX.rZx);
                com.tencent.mm.kernel.a.gH(bVar.qWX.hcd);
                if (bi.bC(a) || !z.h(WP, a)) {
                    x.e("MicroMsg.NewSyncMgr", "compareKeybuf syncKey failed");
                    return;
                }
                ((com.tencent.mm.plugin.zero.b.b) g.l(com.tencent.mm.plugin.zero.b.b.class)).PM().a(bVar, i, j);
                if (pInt3.value != 0) {
                    hc hcVar2 = new hc();
                    hcVar2.bQo.bQp = pInt3.value;
                    boolean m2 = a.sFg.m(hcVar2);
                    x.i("MicroMsg.NewSyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[]{Integer.valueOf(pInt3.value), Boolean.valueOf(m2)});
                    pInt3.value = 0;
                    return;
                }
                return;
            }
            x.e("MicroMsg.NewSyncMgr", "unpack push resp failed");
        } catch (Throwable e) {
            x.e("MicroMsg.NewSyncMgr", "unpack push resp failed: %s", new Object[]{e});
            x.printErrStackTrace("MicroMsg.NewSyncMgr", e, "", new Object[0]);
        }
    }
}
