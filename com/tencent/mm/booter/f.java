package com.tencent.mm.booter;

import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.a.k;
import com.tencent.mm.a.n;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.hc;
import com.tencent.mm.g.a.li;
import com.tencent.mm.g.a.ql;
import com.tencent.mm.modelmulti.c;
import com.tencent.mm.network.aa;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.s.b;
import com.tencent.mm.protocal.w;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class f {
    public static boolean a(int i, int i2, byte[] bArr, byte[] bArr2, long j) {
        x.i("MicroMsg.NotifySyncMgr", "dealWithNotify Here, MM should NOT bOotEd , opType:%d respType:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 1) {
            aH(2);
            return true;
        } else if (i != 2) {
            return false;
        } else {
            switch (i2) {
                case 138:
                    aH(bArr == null ? 7 : (long) n.r(bArr, 0));
                    break;
                case 268369921:
                    if (bi.bC(bArr) || bArr.length <= 8) {
                        x.e("MicroMsg.NotifySyncMgr", "dkpush dealWithNotify respBuf error ");
                        break;
                    }
                    int r = n.r(bArr, 0);
                    int r2 = n.r(bArr, 4);
                    x.d("MicroMsg.NotifySyncMgr", "dkpush: flag:" + r + " bufLen:" + r2 + " dump:" + bi.T(bArr, 8));
                    if (r2 != bArr.length - 8) {
                        x.e("MicroMsg.NotifySyncMgr", "dkpush: respBuf length error len:" + bArr.length);
                        break;
                    }
                    Object obj = new byte[r2];
                    System.arraycopy(bArr, 8, obj, 0, r2);
                    b bVar = new b();
                    PByteArray pByteArray = new PByteArray();
                    PByteArray pByteArray2 = new PByteArray();
                    PInt pInt = new PInt();
                    PInt pInt2 = new PInt();
                    PInt pInt3 = new PInt(0);
                    PInt pInt4 = new PInt(255);
                    try {
                        boolean unpack = MMProtocalJni.unpack(pByteArray2, obj, bArr2, pByteArray, pInt, pInt2, pInt3, pInt4);
                        if (pInt3.value != 0) {
                            hc hcVar = new hc();
                            hcVar.bQo.bQp = pInt3.value;
                            boolean m = a.sFg.m(hcVar);
                            x.i("MicroMsg.NotifySyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[]{Integer.valueOf(pInt3.value), Boolean.valueOf(m)});
                            pInt3.value = 0;
                        }
                        if (!unpack) {
                            x.e("MicroMsg.NotifySyncMgr", "unpack push resp failed");
                            break;
                        }
                        bVar.qWC = pInt4.value;
                        if (pInt.value != -13) {
                            r2 = bVar.G(pByteArray2.value);
                            x.d("MicroMsg.NotifySyncMgr", "bufToResp using protobuf ok");
                            bVar.qWB = r2;
                            bVar.bufferSize = (long) obj.length;
                            byte[] WP = bi.WP(ad.getContext().getSharedPreferences("notify_sync_pref", 4).getString("notify_sync_key_keybuf", ""));
                            byte[] a = ab.a(bVar.qWX.rny);
                            if (!bi.bC(a) && z.h(WP, a)) {
                                new c(bVar, r, j).a(aa.UZ(), new 1());
                                if (pInt3.value != 0) {
                                    hc hcVar2 = new hc();
                                    hcVar2.bQo.bQp = pInt3.value;
                                    boolean m2 = a.sFg.m(hcVar2);
                                    x.i("MicroMsg.NotifySyncMgr", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[]{Integer.valueOf(pInt3.value), Boolean.valueOf(m2)});
                                    pInt3.value = 0;
                                    break;
                                }
                            }
                            x.e("MicroMsg.NotifySyncMgr", "compareKeybuf syncKey failed");
                            break;
                        }
                        bVar.qWB = pInt.value;
                        x.e("MicroMsg.NotifySyncMgr", "unpack push resp failed session timeout");
                        break;
                    } catch (Throwable e) {
                        x.e("MicroMsg.NotifySyncMgr", "unpack push resp failed: %s", new Object[]{e});
                        x.printErrStackTrace("MicroMsg.NotifySyncMgr", e, "", new Object[0]);
                    }
                    break;
                case 1000000205:
                    w.b bVar2 = new w.b();
                    try {
                        bVar2.G(bArr);
                        aH(bVar2.qXc);
                        break;
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.NotifySyncMgr", e2, "", new Object[0]);
                        break;
                    }
                case 2147480001:
                    aH(7);
                    break;
            }
            return true;
        }
    }

    private static void aH(long j) {
        x.i("MicroMsg.NotifySyncMgr", "dealWithSelector, selector = " + j);
        if ((256 & j) != 0) {
            a.sFg.m(new ql());
        }
        if ((2097152 & j) != 0) {
            a.sFg.m(new li());
        }
        if ((((-257 & j) & -2097153) & 2) != 0) {
            new c().a(aa.UZ(), new 2());
        }
    }

    public static byte[] a(PInt pInt, int i) {
        String fo = fo(i);
        int eC = eC(fo);
        for (int i2 = 1; i2 <= eC; i2++) {
            String str = fo + "/syncResp.bin" + i2;
            if (e.cn(str)) {
                byte[] f = e.f(str, 0, -1);
                if (bi.bC(f)) {
                    x.w("MicroMsg.NotifySyncMgr", "readFile getdata null, read again");
                    f = e.f(str, 0, -1);
                }
                byte[] a = k.a(f, g.u((q.zy() + i).getBytes()).getBytes());
                x.i("MicroMsg.NotifySyncMgr", "readFile, index:[%d of %d], dump data:%s -> %s, key:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(eC), D(f), D(a), D(r6.getBytes())});
                if (!bi.bC(a)) {
                    pInt.value = i2;
                    return a;
                }
            }
        }
        return null;
    }

    public static void aO(int i, int i2) {
        String fo = fo(i2);
        int eC = eC(fo);
        e.deleteFile(fo + "/syncResp.bin" + i);
        x.i("MicroMsg.NotifySyncMgr", "consumeData delIndex:%d, total index:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(eC)});
        if (i == eC) {
            e.deleteFile(fo + "/syncResp.ini");
            x.i("MicroMsg.NotifySyncMgr", "consumeData: has consme all respdata");
        }
    }

    public static int eC(String str) {
        int i = 0;
        byte[] f = e.f(str + "/syncResp.ini", i, -1);
        if (bi.bC(f)) {
            return i;
        }
        try {
            return Integer.parseInt(new String(f));
        } catch (NumberFormatException e) {
            return i;
        }
    }

    public static String fo(int i) {
        String str = com.tencent.mm.storage.aa.duN + g.u(("mm" + i).getBytes()) + "/pushSyncResp";
        e.cr(str);
        return str;
    }

    public static String D(byte[] bArr) {
        if (bi.bC(bArr)) {
            return "buf is nullOrNil";
        }
        if (bArr.length == 1) {
            return "buf.len is 1: " + Integer.toHexString(bArr[0]);
        }
        return "buf last two[len:" + bArr.length + "]: %s, %s" + Integer.toHexString(bArr[bArr.length - 2] & 255) + ", " + Integer.toHexString(bArr[bArr.length - 1] & 255);
    }
}
