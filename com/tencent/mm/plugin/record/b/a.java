package com.tencent.mm.plugin.record.b;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.protocal.c.btr;
import com.tencent.mm.protocal.c.gp;
import com.tencent.mm.protocal.c.gq;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g$a;
import java.util.Iterator;

public final class a extends l implements k {
    private final b diG;
    private e diJ = null;
    private int iWL = 0;
    private int iWP = 0;
    String mrK = "";
    g mrL = null;
    private SparseArray<vx> mrM = new SparseArray();
    private SparseBooleanArray mrN = new SparseBooleanArray();

    public a(g gVar) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new gp();
        aVar.dIH = new gq();
        aVar.uri = "/cgi-bin/micromsg-bin/batchtranscdnitem";
        aVar.dIF = 632;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        this.mrL = gVar;
    }

    private void bqr() {
        this.mrK = g$a.a(h.a(this.mrL.field_title, this.mrL.field_desc, this.mrL.field_dataProto), null, null);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneTransCDN", "netId %d errType %d errCode %d localErrCode %d begIndex %d errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.iWP), Integer.valueOf(this.iWL), str});
        if (i2 == 3 && this.iWP == -100) {
            bqr();
            this.diJ.a(0, 0, str, this);
        } else if (i2 == 0 && i3 == 0) {
            Object obj;
            Iterator it = ((gq) ((b) qVar).dIE.dIL).hbG.iterator();
            while (it.hasNext()) {
                btr btr = (btr) it.next();
                vx vxVar = (vx) this.mrM.get(btr.sri);
                if (vxVar != null) {
                    if (this.mrN.get(btr.sri)) {
                        x.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[true], old thumb url[%s], new thumb url[%s], old size[%d], new size[%d]", new Object[]{Integer.valueOf(btr.sri), vxVar.jdM, vxVar.dwE, btr.rmC, Long.valueOf(vxVar.rzU), Long.valueOf(btr.srk)});
                        vxVar.UD(btr.rmC);
                        vxVar.UE(btr.rwn);
                        if (bi.oW(btr.rmC) || bi.oW(btr.rwn) || btr.srk <= 0) {
                            x.w("MicroMsg.NetSceneTransCDN", "match error server return");
                            i2 = 3;
                        } else {
                            vxVar.fP(btr.srk);
                        }
                    } else {
                        x.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[false], old url[%s], new url[%s], old size[%d], new size[%d]", new Object[]{Integer.valueOf(btr.sri), vxVar.jdM, vxVar.rzo, btr.rmC, Long.valueOf(vxVar.rzJ), Long.valueOf(btr.srk)});
                        vxVar.UF(btr.rmC);
                        vxVar.UG(btr.rwn);
                        if (bi.oW(btr.rmC) || bi.oW(btr.rwn) || btr.srk <= 0) {
                            x.w("MicroMsg.NetSceneTransCDN", "match error server return");
                            i2 = 3;
                        } else {
                            vxVar.fO(btr.srk);
                        }
                    }
                }
            }
            x.i("MicroMsg.NetSceneTransCDN", "check need continue, indexOK %B", new Object[]{Boolean.valueOf(this.iWL < this.mrL.field_dataProto.rBI.size())});
            if (this.iWL < this.mrL.field_dataProto.rBI.size()) {
                obj = a(this.dIX, this.diJ) == -100 ? 1 : null;
            } else {
                int obj2 = 1;
            }
            if (obj2 != null) {
                x.i("MicroMsg.NetSceneTransCDN", "do callback");
                bqr();
                this.diJ.a(i2, i3, str, this);
            }
        } else {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 632;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.tencent.mm.network.e r13, com.tencent.mm.ab.e r14) {
        /*
        r12 = this;
        r12.diJ = r14;
        r0 = r12.diG;
        r0 = r0.dID;
        r0 = r0.dIL;
        r0 = (com.tencent.mm.protocal.c.gp) r0;
        r1 = r12.mrM;
        r1.clear();
        r1 = r12.mrN;
        r1.clear();
        r1 = r12.mrL;
        r1 = r1.field_dataProto;
        r1 = r1.rBI;
        r1 = r1.size();
        if (r1 != 0) goto L_0x0030;
    L_0x0020:
        r0 = "MicroMsg.NetSceneTransCDN";
        r1 = "doScene data list null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = -100;
        r12.iWP = r0;
        r0 = -100;
    L_0x002f:
        return r0;
    L_0x0030:
        r3 = 1;
        r4 = new java.util.LinkedList;
        r4.<init>();
        r1 = r12.iWL;
        r2 = r1;
    L_0x0039:
        r1 = r12.mrL;
        r1 = r1.field_dataProto;
        r1 = r1.rBI;
        r1 = r1.size();
        if (r2 >= r1) goto L_0x01c9;
    L_0x0045:
        r1 = r12.mrL;
        r1 = r1.field_dataProto;
        r1 = r1.rBI;
        r1 = r1.get(r2);
        r1 = (com.tencent.mm.protocal.c.vx) r1;
        r5 = r1.rzG;
        if (r5 == 0) goto L_0x00bf;
    L_0x0055:
        r5 = r1.rzo;
        r5 = com.tencent.mm.sdk.platformtools.bi.oW(r5);
        if (r5 == 0) goto L_0x00bf;
    L_0x005d:
        r1 = 0;
    L_0x005e:
        r2 = r2 + 1;
        r12.iWL = r2;
        r2 = r4.size();
        r0.hbF = r2;
        r2 = r0.hbG;
        r2.clear();
        r2 = r0.hbG;
        r2.addAll(r4);
        r2 = "MicroMsg.NetSceneTransCDN";
        r3 = "ashutest::data list size %d, need check size %d, nextIndex %d";
        r4 = 3;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = r12.mrL;
        r6 = r6.field_dataProto;
        r6 = r6.rBI;
        r6 = r6.size();
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        r5 = 1;
        r6 = r12.mrM;
        r6 = r6.size();
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        r5 = 2;
        r6 = r12.iWL;
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
        r0 = r0.hbF;
        if (r0 <= 0) goto L_0x00ab;
    L_0x00a9:
        if (r1 != 0) goto L_0x01c1;
    L_0x00ab:
        r12.bqr();
        r0 = "MicroMsg.NetSceneTransCDN";
        r1 = "doScene no more data";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        r0 = -100;
        r12.iWP = r0;
        r0 = -100;
        goto L_0x002f;
    L_0x00bf:
        r5 = r1.rzo;
        r5 = com.tencent.mm.sdk.platformtools.bi.oW(r5);
        if (r5 != 0) goto L_0x0130;
    L_0x00c7:
        r5 = new com.tencent.mm.protocal.c.btr;
        r5.<init>();
        r6 = r1.rzo;
        r5.rmC = r6;
        r6 = r1.rzq;
        r5.rwn = r6;
        r6 = r1.bjS;
        r5.srj = r6;
        r6 = r1.rzJ;
        r6 = (int) r6;
        r6 = (long) r6;
        r5.srk = r6;
        r6 = r1.jdM;
        r7 = "";
        r6 = com.tencent.mm.sdk.platformtools.bi.aG(r6, r7);
        r6 = r6.hashCode();
        r5.sri = r6;
        r6 = "MicroMsg.NetSceneTransCDN";
        r7 = "add cdnitem, clientID[%d] dataID[%s] datatype[%d] dataurl[%s] size[%d]";
        r8 = 5;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r10 = r5.sri;
        r10 = java.lang.Integer.valueOf(r10);
        r8[r9] = r10;
        r9 = 1;
        r10 = r1.jdM;
        r8[r9] = r10;
        r9 = 2;
        r10 = r5.srj;
        r10 = java.lang.Integer.valueOf(r10);
        r8[r9] = r10;
        r9 = 3;
        r10 = r1.rzo;
        r8[r9] = r10;
        r9 = 4;
        r10 = r1.rzJ;
        r10 = java.lang.Long.valueOf(r10);
        r8[r9] = r10;
        com.tencent.mm.sdk.platformtools.x.d(r6, r7, r8);
        r4.add(r5);
        r6 = r12.mrM;
        r7 = r5.sri;
        r6.put(r7, r1);
        r6 = r12.mrN;
        r5 = r5.sri;
        r7 = 0;
        r6.put(r5, r7);
    L_0x0130:
        r5 = r1.dwE;
        r5 = com.tencent.mm.sdk.platformtools.bi.oW(r5);
        if (r5 != 0) goto L_0x01b4;
    L_0x0138:
        r5 = new com.tencent.mm.protocal.c.btr;
        r5.<init>();
        r6 = r1.dwE;
        r5.rmC = r6;
        r6 = r1.rzk;
        r5.rwn = r6;
        r6 = 2;
        r5.srj = r6;
        r6 = r1.rzU;
        r6 = (int) r6;
        r6 = (long) r6;
        r5.srk = r6;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = r1.jdM;
        r8 = "";
        r7 = com.tencent.mm.sdk.platformtools.bi.aG(r7, r8);
        r6 = r6.append(r7);
        r7 = "@thumb";
        r6 = r6.append(r7);
        r6 = r6.toString();
        r6 = r6.hashCode();
        r5.sri = r6;
        r6 = "MicroMsg.NetSceneTransCDN";
        r7 = "add cdnitem, clientID[%d] thumbID[%s_t] datatype[%d] thumburl[%s] size[%d]";
        r8 = 5;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r10 = r5.sri;
        r10 = java.lang.Integer.valueOf(r10);
        r8[r9] = r10;
        r9 = 1;
        r10 = r1.jdM;
        r8[r9] = r10;
        r9 = 2;
        r10 = r5.srj;
        r10 = java.lang.Integer.valueOf(r10);
        r8[r9] = r10;
        r9 = 3;
        r10 = r1.dwE;
        r8[r9] = r10;
        r9 = 4;
        r10 = r1.rzU;
        r10 = java.lang.Long.valueOf(r10);
        r8[r9] = r10;
        com.tencent.mm.sdk.platformtools.x.d(r6, r7, r8);
        r4.add(r5);
        r6 = r12.mrM;
        r7 = r5.sri;
        r6.put(r7, r1);
        r1 = r12.mrN;
        r5 = r5.sri;
        r6 = 1;
        r1.put(r5, r6);
    L_0x01b4:
        r1 = r4.size();
        r5 = 20;
        if (r1 >= r5) goto L_0x01c9;
    L_0x01bc:
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x0039;
    L_0x01c1:
        r0 = r12.diG;
        r0 = r12.a(r13, r0, r12);
        goto L_0x002f;
    L_0x01c9:
        r1 = r3;
        goto L_0x005e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.record.b.a.a(com.tencent.mm.network.e, com.tencent.mm.ab.e):int");
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }

    protected final int Cc() {
        return 10;
    }
}
