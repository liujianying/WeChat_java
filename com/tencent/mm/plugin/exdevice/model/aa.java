package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.gk;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class aa extends com.tencent.mm.plugin.exdevice.service.j.a implements e {
    static Object dMd = new Object();
    private static final byte[] ivK = new byte[]{(byte) -2, (byte) 1, (byte) 1};
    private static aa ivL;
    static LinkedList<String> ivP = new LinkedList();
    private static HashMap<String, gk> ivQ = new HashMap(32);
    final al eVk = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean vD() {
            x.i("MicroMsg.exdevice.ScanDeviceLogic", "Restart scanning...");
            ad.aHl().a(0, aa.this);
            return true;
        }
    }, true);
    boolean iuY = false;
    volatile String ius;
    a ivM;
    HashMap<String, byte[]> ivN = new HashMap();
    LinkedList<l> ivO = new LinkedList();

    public interface a {
        void a(String str, byte[] bArr, boolean z);
    }

    public static aa aHb() {
        if (ivL != null) {
            return ivL;
        }
        aa aaVar = new aa();
        ivL = aaVar;
        return aaVar;
    }

    private aa() {
    }

    public final void pa(int i) {
        x.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice %s, stopTimer", new Object[]{Integer.valueOf(i)});
        this.eVk.SO();
        if (this.iuY) {
            d aHl = ad.aHl();
            x.i("MicroMsg.exdevice.ExdeviceConnectManager", "stopScanLogic, bluetooth version = %d", new Object[]{Integer.valueOf(i)});
            if (this == null) {
                x.e("MicroMsg.exdevice.ExdeviceConnectManager", "null == aCallback");
            } else if (aHl.itd == null) {
                x.i("MicroMsg.exdevice.ExdeviceConnectManager", "exdevice process is dead, just leave");
            } else if (u.aHG().isY == null) {
                x.e("MicroMsg.exdevice.ExdeviceConnectManager", "dispatcher is null.");
            } else if (!u.aHG().isY.c(i, aHl.itj)) {
                x.e("MicroMsg.exdevice.ExdeviceConnectManager", "stopScan failed!!!");
            }
            this.iuY = false;
            this.ius = null;
            this.ivN.clear();
            au.DF().b(542, this);
            Iterator it = this.ivO.iterator();
            while (it.hasNext()) {
                l lVar = (l) it.next();
                if (lVar != null) {
                    au.DF().c(lVar);
                }
            }
            this.ivO.clear();
            if (this.ivM != null) {
                this.ivM.a(null, null, true);
            }
            this.ivM = null;
        } else {
            x.i("MicroMsg.exdevice.ScanDeviceLogic", "stopScanDevice has been stoped");
        }
        synchronized (dMd) {
            ivP.clear();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r8, int r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, int r13, byte[] r14) {
        /*
        r7 = this;
        r0 = r7.ivN;
        r0 = r0.containsKey(r11);
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        if (r11 != 0) goto L_0x0015;
    L_0x000b:
        r0 = "MicroMsg.exdevice.ScanDeviceLogic";
        r1 = "deviceMac is null";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        goto L_0x0008;
    L_0x0015:
        r0 = ":";
        r1 = "";
        r1 = r11.replaceAll(r0, r1);
        r2 = ivK;
        r0 = com.tencent.mm.sdk.platformtools.bi.bC(r14);
        if (r0 != 0) goto L_0x0031;
    L_0x0027:
        r0 = com.tencent.mm.sdk.platformtools.bi.bC(r2);
        if (r0 != 0) goto L_0x0031;
    L_0x002d:
        r0 = r2.length;
        r3 = r14.length;
        if (r0 <= r3) goto L_0x009b;
    L_0x0031:
        r0 = -1;
    L_0x0032:
        r2 = -1;
        if (r0 == r2) goto L_0x00b1;
    L_0x0035:
        r2 = r0 + 9;
        r3 = r14.length;
        if (r2 > r3) goto L_0x00aa;
    L_0x003a:
        r0 = r0 + 9;
        r0 = new byte[r0];
        r2 = 0;
        r3 = 0;
        r4 = r0.length;
        java.lang.System.arraycopy(r14, r2, r0, r3, r4);
        r2 = "MicroMsg.exdevice.ScanDeviceLogic";
        r3 = "hakon, scanFound mac:%s, realAd:%s";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r1;
        r5 = 1;
        r6 = com.tencent.mm.plugin.exdevice.j.b.aq(r0);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r2 = r7.ivN;
        r2.put(r1, r0);
    L_0x005f:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r7.ius;
        r0 = r0.append(r1);
        r1 = "_";
        r0 = r0.append(r1);
        r0 = r0.append(r11);
        r0 = r0.toString();
        r1 = ivQ;
        r1 = r1.containsKey(r0);
        if (r1 != 0) goto L_0x00ed;
    L_0x0081:
        r1 = dMd;
        monitor-enter(r1);
        r2 = ivP;	 Catch:{ all -> 0x0098 }
        r2 = r2.contains(r0);	 Catch:{ all -> 0x0098 }
        if (r2 == 0) goto L_0x00b8;
    L_0x008c:
        r0 = "MicroMsg.exdevice.ScanDeviceLogic";
        r2 = "hakon, already doing";
        com.tencent.mm.sdk.platformtools.x.d(r0, r2);	 Catch:{ all -> 0x0098 }
        monitor-exit(r1);	 Catch:{ all -> 0x0098 }
        goto L_0x0008;
    L_0x0098:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0098 }
        throw r0;
    L_0x009b:
        r0 = 0;
    L_0x009c:
        r3 = r14.length;
        if (r0 >= r3) goto L_0x00a8;
    L_0x009f:
        r3 = com.tencent.mm.plugin.exdevice.j.b.a(r14, r0, r2);
        if (r3 != 0) goto L_0x0032;
    L_0x00a5:
        r0 = r0 + 1;
        goto L_0x009c;
    L_0x00a8:
        r0 = -1;
        goto L_0x0032;
    L_0x00aa:
        r0 = r7.ivN;
        r2 = 0;
        r0.put(r1, r2);
        goto L_0x005f;
    L_0x00b1:
        r0 = r7.ivN;
        r2 = 0;
        r0.put(r1, r2);
        goto L_0x005f;
    L_0x00b8:
        r2 = ivP;	 Catch:{ all -> 0x0098 }
        r2.add(r0);	 Catch:{ all -> 0x0098 }
        monitor-exit(r1);	 Catch:{ all -> 0x0098 }
        r1 = new com.tencent.mm.plugin.exdevice.model.k;
        r2 = 1;
        r2 = new java.lang.String[r2];
        r3 = 0;
        r2[r3] = r11;
        r3 = r7.ius;
        r1.<init>(r2, r3);
        r2 = com.tencent.mm.model.au.DF();
        r3 = 0;
        r2 = r2.a(r1, r3);
        if (r2 == 0) goto L_0x00dd;
    L_0x00d6:
        r0 = r7.ivO;
        r0.add(r1);
        goto L_0x0008;
    L_0x00dd:
        r1 = ivP;
        r1.remove(r0);
        r0 = "MicroMsg.exdevice.ScanDeviceLogic";
        r1 = "MMCore.getNetSceneQueue().doScene failed!!!";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x0008;
    L_0x00ed:
        r1 = "MicroMsg.exdevice.ScanDeviceLogic";
        r2 = "hakon, hit cache %s, %s";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = r7.ius;
        r3[r4] = r5;
        r4 = 1;
        r3[r4] = r11;
        com.tencent.mm.sdk.platformtools.x.d(r1, r2, r3);
        r1 = ivQ;
        r0 = r1.get(r0);
        r0 = (com.tencent.mm.protocal.c.gk) r0;
        r7.a(r0);
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.model.aa.a(int, int, java.lang.String, java.lang.String, java.lang.String, int, byte[]):void");
    }

    public final void a(int i, int i2, String str, l lVar) {
        String str2 = "MicroMsg.exdevice.ScanDeviceLogic";
        String str3 = "onSceneEnd, %s, errType=%d, errCode=%d, errMsg=%s";
        Object[] objArr = new Object[4];
        objArr[0] = lVar == null ? "" : Integer.valueOf(lVar.getType());
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = str;
        x.i(str2, str3, objArr);
        this.ivO.remove(lVar);
        if (i != 0 || i2 != 0 || lVar == null) {
            x.e("MicroMsg.exdevice.ScanDeviceLogic", "do scene failed!!!");
        } else if (542 == lVar.getType()) {
            Iterator it = ((k) lVar).aGW().rgP.iterator();
            while (it.hasNext()) {
                gk gkVar = (gk) it.next();
                if (bi.oW(gkVar.rgL)) {
                    x.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
                } else {
                    str3 = this.ius + "_" + gkVar.rgL;
                    synchronized (dMd) {
                        if (ivP.contains(str3)) {
                            ivP.remove(str3);
                        }
                    }
                    if (!ivQ.containsKey(str3)) {
                        x.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, put into cache, %s", new Object[]{str3});
                        ivQ.put(str3, gkVar);
                    }
                    a(gkVar);
                }
            }
        }
    }

    private void a(gk gkVar) {
        if (gkVar == null) {
            x.e("MicroMsg.exdevice.ScanDeviceLogic", "item null..");
        } else if (bi.oW(gkVar.rgL)) {
            x.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid mac(null or nil)");
        } else if (gkVar.rfn != 0) {
            x.e("MicroMsg.exdevice.ScanDeviceLogic", "device(%s) is invalid", new Object[]{gkVar.rgL});
        } else if (gkVar.rgS == null || bi.oW(gkVar.rgS.hbO)) {
            x.e("MicroMsg.exdevice.ScanDeviceLogic", "invalid device id(mac=%s)", new Object[]{gkVar.rgL});
        } else if (bi.oW(gkVar.rgS.reT) || !gkVar.rgS.reT.equals(this.ius)) {
            x.e("MicroMsg.exdevice.ScanDeviceLogic", "device type (%s) is not equal to brand name (%s)", new Object[]{gkVar.hbP, this.ius});
        } else {
            byte[] bArr = (byte[]) this.ivN.get(gkVar.rgL);
            String str = "MicroMsg.exdevice.ScanDeviceLogic";
            String str2 = "hakon, BatchSearch find mac=%s, deviceType=%s, deviceId=%s, %s, %s";
            Object[] objArr = new Object[5];
            objArr[0] = gkVar.rgL;
            objArr[1] = gkVar.rgS.reT;
            objArr[2] = gkVar.rgS.hbO;
            objArr[3] = gkVar.hbP;
            objArr[4] = Integer.valueOf(bArr == null ? 0 : bArr.length);
            x.i(str, str2, objArr);
            if (this.ivM != null) {
                if (bArr != null) {
                    bArr = ap(bArr);
                } else {
                    bArr = null;
                }
                this.ivM.a(gkVar.rgS.hbO, bArr, false);
                return;
            }
            x.e("MicroMsg.exdevice.ScanDeviceLogic", "mCallback null");
        }
    }

    private static byte[] ap(byte[] bArr) {
        byte[] bArr2 = null;
        int i = 0;
        int i2 = 0;
        while (i < bArr.length - 2) {
            try {
                int i3 = i + 1;
                byte b = bArr[i];
                if (b != (byte) 0) {
                    i = i3 + 1;
                    switch (bArr[i3]) {
                        case (byte) -1:
                            x.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data size = %s", new Object[]{Integer.valueOf(b)});
                            byte[] bArr3 = new byte[(b - 1)];
                            int i4 = b;
                            while (i4 > 1) {
                                int i5;
                                int i6;
                                if (i2 >= 32 || i2 >= bArr3.length) {
                                    i5 = i;
                                    i6 = i2;
                                } else {
                                    i6 = i2 + 1;
                                    i5 = i + 1;
                                    bArr3[i2] = bArr[i];
                                }
                                i4--;
                                i = i5;
                                i2 = i6;
                            }
                            x.i("MicroMsg.exdevice.ScanDeviceLogic", "hakon, Manufacturer Specific Data %s" + b.aq(bArr3));
                            bArr2 = bArr3;
                            break;
                        default:
                            i += b - 1;
                            break;
                    }
                }
                return bArr2;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.exdevice.ScanDeviceLogic", e, "", new Object[0]);
                x.e("MicroMsg.exdevice.ScanDeviceLogic", "EX in parseBroadcastPacket %s", new Object[]{e.getMessage()});
                return null;
            }
        }
        return bArr2;
    }
}
