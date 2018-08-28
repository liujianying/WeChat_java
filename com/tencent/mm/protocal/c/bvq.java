package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bvq extends bhd {
    public String bKv;
    public int blZ;
    public String byN;
    public String dxK;
    public String sjf;
    public int ssb;
    public int ssc;
    public String ssd;
    public int sse;
    public String ssf;
    public LinkedList<bqr> ssg = new LinkedList();
    public int ssh;
    public int ssi;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.byN != null) {
                aVar.g(2, this.byN);
            }
            if (this.bKv != null) {
                aVar.g(3, this.bKv);
            }
            aVar.fT(4, this.ssb);
            aVar.fT(5, this.ssc);
            aVar.fT(6, this.blZ);
            if (this.ssd != null) {
                aVar.g(7, this.ssd);
            }
            if (this.sjf != null) {
                aVar.g(8, this.sjf);
            }
            if (this.dxK != null) {
                aVar.g(9, this.dxK);
            }
            aVar.fT(10, this.sse);
            if (this.ssf != null) {
                aVar.g(11, this.ssf);
            }
            aVar.d(12, 8, this.ssg);
            aVar.fT(13, this.ssh);
            aVar.fT(14, this.ssi);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.byN != null) {
                fS += f.a.a.b.b.a.h(2, this.byN);
            }
            if (this.bKv != null) {
                fS += f.a.a.b.b.a.h(3, this.bKv);
            }
            fS = ((fS + f.a.a.a.fQ(4, this.ssb)) + f.a.a.a.fQ(5, this.ssc)) + f.a.a.a.fQ(6, this.blZ);
            if (this.ssd != null) {
                fS += f.a.a.b.b.a.h(7, this.ssd);
            }
            if (this.sjf != null) {
                fS += f.a.a.b.b.a.h(8, this.sjf);
            }
            if (this.dxK != null) {
                fS += f.a.a.b.b.a.h(9, this.dxK);
            }
            fS += f.a.a.a.fQ(10, this.sse);
            if (this.ssf != null) {
                fS += f.a.a.b.b.a.h(11, this.ssf);
            }
            return ((fS + f.a.a.a.c(12, 8, this.ssg)) + f.a.a.a.fQ(13, this.ssh)) + f.a.a.a.fQ(14, this.ssi);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ssg.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bvq bvq = (bvq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        bvq.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bvq.byN = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bvq.bKv = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bvq.ssb = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bvq.ssc = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bvq.blZ = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bvq.ssd = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bvq.sjf = aVar3.vHC.readString();
                    return 0;
                case 9:
                    bvq.dxK = aVar3.vHC.readString();
                    return 0;
                case 10:
                    bvq.sse = aVar3.vHC.rY();
                    return 0;
                case 11:
                    bvq.ssf = aVar3.vHC.readString();
                    return 0;
                case 12:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bqr bqr = new bqr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqr.a(aVar4, bqr, bhd.a(aVar4))) {
                        }
                        bvq.ssg.add(bqr);
                    }
                    return 0;
                case 13:
                    bvq.ssh = aVar3.vHC.rY();
                    return 0;
                case 14:
                    bvq.ssi = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
