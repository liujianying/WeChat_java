package com.tencent.mm.ak;

import android.graphics.Bitmap;
import com.tencent.mm.a.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.report.service.g.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class n {
    private static n dVV;
    ConcurrentHashMap<Long, d> dVT = new ConcurrentHashMap();
    public c dVU = new c();
    public ConcurrentHashMap<Long, e> dVW = new ConcurrentHashMap();
    private ArrayList<Long> dVX = new ArrayList();
    ArrayList<e> dVY = new ArrayList();

    public static class c {
        public LinkedList<b> dWi = new LinkedList();
        public LinkedList<b> dWj = new LinkedList();

        public final synchronized void OZ() {
            int i = 0;
            synchronized (this) {
                int size = this.dWi.size();
                if (size <= 0) {
                    int i2 = 5 - size;
                    for (size = 0; size < i2; size++) {
                        this.dWi.add(lS(null));
                    }
                    x.i("MicroMsg.SendImgSpeeder", "add big File pool added size %d , all size %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(this.dWi.size())});
                    Pa();
                }
                size = this.dWj.size();
                if (size <= 0) {
                    size = 5 - size;
                    while (i < size) {
                        this.dWj.add(lT(null));
                        i++;
                    }
                    Pb();
                    x.i("MicroMsg.SendImgSpeeder", "add big thumb pool added size %d , all size %d", new Object[]{Integer.valueOf(size), Integer.valueOf(this.dWj.size())});
                }
            }
        }

        public static b lS(String str) {
            b bVar = new b((byte) 0);
            if (bi.oW(str)) {
                bVar.dWh = g.OQ();
            } else {
                bVar.dWh = str;
            }
            String b = o.Pf().b(bVar.dWh, "", ".jpg", false);
            if (!lU(b)) {
                return null;
            }
            bVar.dWg = new b(b);
            return bVar;
        }

        public static b lT(String str) {
            b bVar = new b((byte) 0);
            if (bi.oW(str)) {
                bVar.dWh = g.OQ();
            } else {
                bVar.dWh = str;
            }
            String b = o.Pf().b("THUMBNAIL_DIRPATH://th_" + bVar.dWh, "th_", "", false);
            if (!lU(b)) {
                return null;
            }
            bVar.dWg = new b(b);
            return bVar;
        }

        private static boolean lU(String str) {
            if (FileOp.mI(str) <= 0) {
                return true;
            }
            x.e("MicroMsg.SendImgSpeeder", "file has exist %s", new Object[]{str});
            return false;
        }

        public final synchronized b hX(int i) {
            b bVar = null;
            synchronized (this) {
                if (i == 1) {
                    if (this.dWi.size() > 0) {
                        bVar = (b) this.dWi.remove();
                        Pa();
                    } else {
                        bVar = lS(null);
                    }
                } else if (i == 2) {
                    if (this.dWj.size() > 0) {
                        bVar = (b) this.dWj.remove();
                        Pb();
                    } else {
                        bVar = lT(null);
                    }
                }
                OZ();
            }
            return bVar;
        }

        private synchronized void Pa() {
            int i = 0;
            synchronized (this) {
                StringBuilder stringBuilder = new StringBuilder();
                while (true) {
                    int i2 = i;
                    if (i2 < this.dWi.size()) {
                        stringBuilder.append(((b) this.dWi.get(i2)).dWh);
                        if (i2 != this.dWi.size() - 1) {
                            stringBuilder.append("-");
                        }
                        i = i2 + 1;
                    } else {
                        x.d("MicroMsg.SendImgSpeeder", "sync big des to file %s ", new Object[]{stringBuilder.toString()});
                        g.Ei().DT().set(348176, stringBuilder.toString());
                    }
                }
            }
        }

        private synchronized void Pb() {
            int i = 0;
            synchronized (this) {
                StringBuilder stringBuilder = new StringBuilder();
                while (true) {
                    int i2 = i;
                    if (i2 < this.dWj.size()) {
                        stringBuilder.append(((b) this.dWj.get(i2)).dWh);
                        if (i2 != this.dWj.size() - 1) {
                            stringBuilder.append("-");
                        }
                        i = i2 + 1;
                    } else {
                        x.d("MicroMsg.SendImgSpeeder", "sync thumb des to file %s ", new Object[]{stringBuilder.toString()});
                        g.Ei().DT().set(348177, stringBuilder.toString());
                    }
                }
            }
        }
    }

    public static n OW() {
        if (dVV == null) {
            synchronized (n.class) {
                if (dVV == null) {
                    dVV = new n();
                }
            }
        }
        return dVV;
    }

    public final ArrayList<String> lP(String str) {
        ArrayList<String> arrayList = new ArrayList();
        if (!bi.oW(str)) {
            for (e eVar : this.dVW.values()) {
                if (str.equals(eVar.toUserName)) {
                    arrayList.add(eVar.dWk);
                }
            }
        }
        return arrayList;
    }

    public final ArrayList<Integer> lQ(String str) {
        Collection<e> values = this.dVW.values();
        for (e eVar : values) {
            PString pString = new PString();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            eVar.dWn = o.Pf().a(eVar.dWk, eVar.dTO, eVar.source, eVar.bRV, pString, pInt, pInt2, eVar.dWl, eVar.dWm, eVar.bJC, eVar.dWr, eVar.dWs, eVar.dWt);
            bd dW = ((i) g.l(i.class)).bcY().dW(eVar.bJC);
            if (bi.oW(dW.field_imgPath)) {
                dW.eq(pString.value);
                dW.fh(pInt.value);
                dW.fi(pInt2.value);
                ((i) g.l(i.class)).bcY().a(eVar.bJC, dW);
            }
        }
        if (!bi.oW(str)) {
            for (e eVar2 : values) {
                if (!str.equals(eVar2.toUserName)) {
                    this.dVW.remove(Long.valueOf(eVar2.bJC));
                    this.dVX.remove(Long.valueOf(eVar2.bJC));
                    x.e("MicroMsg.SendImgSpeeder", "fatal!! Send user mis-match, want:%s, fact:%s", new Object[]{str, eVar2.toUserName});
                }
            }
        }
        ArrayList<Integer> arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.dVX.size()) {
                arrayList.add(Integer.valueOf((int) ((e) this.dVW.get(this.dVX.get(i2))).dWn));
                i = i2 + 1;
            } else {
                this.dVW.clear();
                this.dVX.clear();
                x.i("MicroMsg.SendImgSpeeder", "syncImgData, id size %d", new Object[]{Integer.valueOf(arrayList.size())});
                return arrayList;
            }
        }
    }

    public final boolean bt(long j) {
        return this.dVT.containsKey(Long.valueOf(j));
    }

    public final d bu(long j) {
        return (d) this.dVT.get(Long.valueOf(j));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.ArrayList<java.lang.String> r15, boolean r16, int r17, int r18, java.lang.String r19, int r20) {
        /*
        r14 = this;
        r2 = "MicroMsg.SendImgSpeeder";
        r3 = "summersafecdn sendThumbImg fileSize:%d, compressImg[%b], source[%d], user:%s";
        r4 = 4;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = r15.size();
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        r5 = 1;
        r6 = java.lang.Boolean.valueOf(r16);
        r4[r5] = r6;
        r5 = 2;
        r6 = java.lang.Integer.valueOf(r17);
        r4[r5] = r6;
        r5 = 3;
        r4[r5] = r19;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r2 = r14.dVY;
        r3 = r2.iterator();
    L_0x002e:
        r2 = r3.hasNext();
        if (r2 == 0) goto L_0x0075;
    L_0x0034:
        r2 = r3.next();
        r2 = (com.tencent.mm.ak.n.e) r2;
        r4 = r2.dWk;
        r4 = r15.contains(r4);
        if (r4 == 0) goto L_0x0064;
    L_0x0042:
        r4 = r2.toUserName;
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r4);
        if (r4 != 0) goto L_0x0054;
    L_0x004a:
        r4 = r2.toUserName;
        r0 = r19;
        r4 = r4.equalsIgnoreCase(r0);
        if (r4 == 0) goto L_0x0064;
    L_0x0054:
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r19);
        if (r4 != 0) goto L_0x0068;
    L_0x005a:
        r4 = r2.toUserName;
        r0 = r19;
        r4 = r0.equalsIgnoreCase(r4);
        if (r4 != 0) goto L_0x0068;
    L_0x0064:
        r3.remove();
        goto L_0x002e;
    L_0x0068:
        r4 = r2.dWk;
        r0 = r19;
        r1 = r16;
        r4 = b(r4, r0, r1);
        r2.dTO = r4;
        goto L_0x002e;
    L_0x0075:
        r4 = new java.util.ArrayList;
        r4.<init>();
        r5 = r15.iterator();
    L_0x007e:
        r2 = r5.hasNext();
        if (r2 == 0) goto L_0x00a9;
    L_0x0084:
        r2 = r5.next();
        r3 = r2;
        r3 = (java.lang.String) r3;
        r2 = r14.dVY;
        r6 = r2.iterator();
    L_0x0091:
        r2 = r6.hasNext();
        if (r2 == 0) goto L_0x007e;
    L_0x0097:
        r2 = r6.next();
        r2 = (com.tencent.mm.ak.n.e) r2;
        r7 = r2.dWk;
        r7 = r7.equals(r3);
        if (r7 == 0) goto L_0x0091;
    L_0x00a5:
        r4.add(r2);
        goto L_0x0091;
    L_0x00a9:
        r2 = r14.dVY;
        r2.clear();
        r2 = r14.dVY;
        r2.addAll(r4);
        r3 = new java.util.ArrayList;
        r3.<init>();
        r2 = r15.size();
        r4 = 9;
        if (r2 != r4) goto L_0x00f0;
    L_0x00c0:
        r2 = 18;
        com.tencent.mm.plugin.report.service.g.vu(r2);
    L_0x00c5:
        r4 = r15.iterator();
    L_0x00c9:
        r2 = r4.hasNext();
        if (r2 == 0) goto L_0x0155;
    L_0x00cf:
        r2 = r4.next();
        r2 = (java.lang.String) r2;
        if (r2 == 0) goto L_0x00e6;
    L_0x00d7:
        r5 = "";
        r5 = r2.equals(r5);
        if (r5 != 0) goto L_0x00e6;
    L_0x00e0:
        r5 = com.tencent.mm.a.e.cn(r2);
        if (r5 != 0) goto L_0x0129;
    L_0x00e6:
        r2 = "MicroMsg.SendImgSpeeder";
        r5 = " doSendImage : filePath is null or empty";
        com.tencent.mm.sdk.platformtools.x.d(r2, r5);
        goto L_0x00c9;
    L_0x00f0:
        r2 = r15.size();
        r4 = 1;
        if (r2 != r4) goto L_0x0123;
    L_0x00f7:
        r2 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r2 = com.tencent.mm.sdk.platformtools.ao.isWifi(r2);
        r4 = 25;
        com.tencent.mm.plugin.report.service.g.vu(r4);
        if (r2 == 0) goto L_0x00c5;
    L_0x0106:
        r2 = 0;
        r2 = r15.get(r2);
        r2 = (java.lang.String) r2;
        r0 = r19;
        r1 = r16;
        r2 = com.tencent.mm.model.q.a(r2, r0, r1);
        if (r2 == 0) goto L_0x011d;
    L_0x0117:
        r2 = 23;
        com.tencent.mm.plugin.report.service.g.vu(r2);
        goto L_0x00c5;
    L_0x011d:
        r2 = 21;
        com.tencent.mm.plugin.report.service.g.vu(r2);
        goto L_0x00c5;
    L_0x0123:
        r2 = 24;
        com.tencent.mm.plugin.report.service.g.vu(r2);
        goto L_0x00c5;
    L_0x0129:
        r5 = com.tencent.mm.sdk.platformtools.o.Wf(r2);
        if (r5 == 0) goto L_0x014a;
    L_0x012f:
        r5 = "MicroMsg.SendImgSpeeder";
        r6 = "[cpan] is gif coutinue. did not add filePath:%s filesize:%d";
        r7 = 2;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r7[r8] = r2;
        r8 = 1;
        r2 = com.tencent.mm.a.e.cm(r2);
        r2 = java.lang.Integer.valueOf(r2);
        r7[r8] = r2;
        com.tencent.mm.sdk.platformtools.x.i(r5, r6, r7);
        goto L_0x00c9;
    L_0x014a:
        r5 = r14.lR(r2);
        if (r5 != 0) goto L_0x00c9;
    L_0x0150:
        r3.add(r2);
        goto L_0x00c9;
    L_0x0155:
        r9 = r3.iterator();
    L_0x0159:
        r2 = r9.hasNext();
        if (r2 == 0) goto L_0x0174;
    L_0x015f:
        r5 = r9.next();
        r5 = (java.lang.String) r5;
        r2 = r14;
        r3 = r17;
        r4 = r18;
        r6 = r19;
        r7 = r16;
        r8 = r20;
        r2.a(r3, r4, r5, r6, r7, r8);
        goto L_0x0159;
    L_0x0174:
        r6 = new java.util.ArrayList;
        r6.<init>();
        r2 = com.tencent.mm.kernel.g.Ei();
        r2 = r2.dqq;
        r3 = java.lang.Thread.currentThread();
        r4 = r3.getId();
        r8 = r2.dO(r4);
        r2 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r2 = com.tencent.mm.kernel.g.l(r2);
        r2 = (com.tencent.mm.plugin.messenger.foundation.a.i) r2;
        r2 = r2.bcY();
        r3 = "SendImgSpeeder";
        r2.Gz(r3);
        r3 = 1;
        r2 = 0;
        r5 = r2;
    L_0x01a0:
        r2 = r14.dVY;
        r2 = r2.size();
        if (r5 >= r2) goto L_0x0257;
    L_0x01a8:
        r2 = r14.dVY;
        r2 = r2.get(r5);
        r2 = (com.tencent.mm.ak.n.e) r2;
        r4 = r2.dWk;
        r4 = com.tencent.mm.sdk.platformtools.o.Wf(r4);
        if (r4 == 0) goto L_0x01c7;
    L_0x01b8:
        r2 = "MicroMsg.SendImgSpeeder";
        r4 = "[cpan] is gif coutinue. did not add to msg table";
        com.tencent.mm.sdk.platformtools.x.i(r2, r4);
        r2 = r3;
    L_0x01c2:
        r4 = r5 + 1;
        r5 = r4;
        r3 = r2;
        goto L_0x01a0;
    L_0x01c7:
        r4 = 0;
        r7 = new com.tencent.mm.storage.bd;
        r7.<init>();
        r3 = com.tencent.mm.model.s.hR(r19);
        r7.setType(r3);
        r0 = r19;
        r7.ep(r0);
        r3 = 1;
        r7.eX(r3);
        r3 = 1;
        r7.setStatus(r3);
        r3 = r2.dWo;
        r3 = r3.value;
        r7.eq(r3);
        r3 = r2.dWp;
        r3 = r3.value;
        r7.fh(r3);
        r3 = r2.dWq;
        r3 = r3.value;
        r7.fi(r3);
        r3 = com.tencent.mm.model.bf.Ir();
        if (r3 == 0) goto L_0x0204;
    L_0x01fc:
        r10 = r7.cqb;
        r10 = r3.equals(r10);
        if (r10 == 0) goto L_0x020a;
    L_0x0204:
        if (r3 != 0) goto L_0x020d;
    L_0x0206:
        r10 = r7.cqb;
        if (r10 == 0) goto L_0x020d;
    L_0x020a:
        r7.dt(r3);
    L_0x020d:
        r3 = com.tencent.mm.j.a.a.yw();
        r3.c(r7);
        r3 = r7.field_talker;
        r10 = com.tencent.mm.model.bd.iD(r3);
        r7.ay(r10);
        r6.add(r7);
        r3 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r3 = com.tencent.mm.kernel.g.l(r3);
        r3 = (com.tencent.mm.plugin.messenger.foundation.a.i) r3;
        r3 = r3.bcY();
        r10 = r3.T(r7);
        r12 = 0;
        r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r3 < 0) goto L_0x0255;
    L_0x0236:
        r3 = 1;
    L_0x0237:
        junit.framework.Assert.assertTrue(r3);
        r2.bJC = r10;
        r3 = r14.dVW;
        r10 = r2.bJC;
        r7 = java.lang.Long.valueOf(r10);
        r3.put(r7, r2);
        r3 = r14.dVX;
        r10 = r2.bJC;
        r2 = java.lang.Long.valueOf(r10);
        r3.add(r2);
        r2 = r4;
        goto L_0x01c2;
    L_0x0255:
        r3 = 0;
        goto L_0x0237;
    L_0x0257:
        r2 = r14.dVY;
        r2.clear();
        r4 = 0;
        r2 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x026b;
    L_0x0262:
        r2 = com.tencent.mm.kernel.g.Ei();
        r2 = r2.dqq;
        r2.gp(r8);
    L_0x026b:
        if (r3 == 0) goto L_0x027f;
    L_0x026d:
        r2 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r2 = com.tencent.mm.kernel.g.l(r2);
        r2 = (com.tencent.mm.plugin.messenger.foundation.a.i) r2;
        r2 = r2.bcY();
        r3 = "SendImgSpeeder";
        r2.GA(r3);
    L_0x027f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ak.n.a(java.util.ArrayList, boolean, int, int, java.lang.String, int):void");
    }

    private boolean lR(String str) {
        Iterator it = this.dVY.iterator();
        while (it.hasNext()) {
            if (((e) it.next()).dWk.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean OX() {
        if (this.dVY.size() <= 0 || a.brT().mEF > 2) {
            return true;
        }
        x.i("MicroMsg.SendImgSpeeder", "cpu core is low ,do not use multi mode");
        return false;
    }

    public final void a(int i, int i2, String str, String str2, boolean z, int i3) {
        if (!lR(str)) {
            b bVar;
            b bVar2;
            String str3;
            String str4;
            int b = b(str, str2, z);
            PString pString = new PString();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            if (OX()) {
                b hX = this.dVU.hX(1);
                b hX2 = this.dVU.hX(2);
                b bVar3 = hX.dWg;
                bVar = hX2.dWg;
                bVar2 = bVar3;
                str3 = hX2.dWh;
                str4 = hX.dWh;
            } else {
                bVar = null;
                bVar2 = null;
                str3 = null;
                str4 = null;
            }
            g Pf = o.Pf();
            if (FileOp.cn(str)) {
                String str5 = "THUMBNAIL_DIRPATH://th_" + (bi.oW(str3) ? g.OQ() : str3);
                String b2 = Pf.b(str5, "th_", "", false);
                pString.value = str5;
                long VG = bi.VG();
                Bitmap a = Pf.a(str, b, i2, pInt, pInt2, false, null, null);
                str5 = (String) Pf.dUs.get(str);
                Object obj = str5 != null ? (Bitmap) Pf.dUr.get(str5) : null;
                if (obj == null || obj.isRecycled()) {
                    obj = Pf.a(str, true, com.tencent.mm.bp.a.getDensity(ad.getContext()), false, false, true, i3, true, a);
                    Pf.dUs.put(str, b2);
                }
                if (obj != null) {
                    Pf.dUr.m(b2, obj);
                }
                x.i("MicroMsg.ImgInfoStorage", "test decode thumb img:%d", new Object[]{Long.valueOf(bi.bI(VG))});
            } else {
                x.e("MicroMsg.ImgInfoStorage", "file not exit:%s", new Object[]{str});
            }
            e eVar = new e();
            eVar.dWk = str;
            eVar.dTO = b;
            eVar.source = i;
            eVar.bRV = i2;
            eVar.dWl = str3;
            eVar.dWo = pString;
            eVar.dWq = pInt2;
            eVar.dWp = pInt;
            eVar.dWm = str4;
            eVar.dWs = bVar;
            eVar.dWr = bVar2;
            if (dVV.OX()) {
                a.a(eVar);
            }
            eVar.toUserName = str2;
            this.dVY.add(eVar);
            x.i("MicroMsg.SendImgSpeeder", "summersafecdn img path %s has prebuild, user:%s", new Object[]{str, str2});
        }
    }

    private static int b(String str, String str2, boolean z) {
        return q.a(str, str2, z) ? 1 : 0;
    }
}
