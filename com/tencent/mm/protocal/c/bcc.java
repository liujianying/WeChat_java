package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bcc extends bhp {
    public int kpF;
    public int kpG;
    public int kpH;
    public b kpI;
    public int kpK;
    public int kpN;
    public int kpu;
    public String kpv;
    public int kpz;
    public LinkedList<bbu> rfi = new LinkedList();
    public int rxG;
    public long rxH;
    public long seh;
    public int seq;
    public int ser;
    public LinkedList<bbu> ses = new LinkedList();
    public String set;
    public b seu;
    public int sev;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new f.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            aVar.fT(2, this.rxG);
            aVar.T(3, this.rxH);
            aVar.fT(4, this.seq);
            aVar.d(5, 8, this.rfi);
            aVar.fT(6, this.ser);
            aVar.fT(7, this.kpF);
            aVar.fT(8, this.kpG);
            aVar.T(9, this.seh);
            aVar.fT(10, this.kpH);
            if (this.kpI != null) {
                aVar.b(11, this.kpI);
            }
            aVar.fT(12, this.kpz);
            aVar.fT(13, this.kpu);
            if (this.kpv != null) {
                aVar.g(14, this.kpv);
            }
            aVar.fT(15, this.kpK);
            aVar.d(16, 8, this.ses);
            aVar.fT(17, this.kpN);
            if (this.set != null) {
                aVar.g(18, this.set);
            }
            if (this.seu != null) {
                aVar.b(19, this.seu);
            }
            aVar.fT(20, this.sev);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = ((((((((fS + f.a.a.a.fQ(2, this.rxG)) + f.a.a.a.S(3, this.rxH)) + f.a.a.a.fQ(4, this.seq)) + f.a.a.a.c(5, 8, this.rfi)) + f.a.a.a.fQ(6, this.ser)) + f.a.a.a.fQ(7, this.kpF)) + f.a.a.a.fQ(8, this.kpG)) + f.a.a.a.S(9, this.seh)) + f.a.a.a.fQ(10, this.kpH);
            if (this.kpI != null) {
                fS += f.a.a.a.a(11, this.kpI);
            }
            fS = (fS + f.a.a.a.fQ(12, this.kpz)) + f.a.a.a.fQ(13, this.kpu);
            if (this.kpv != null) {
                fS += f.a.a.b.b.a.h(14, this.kpv);
            }
            fS = ((fS + f.a.a.a.fQ(15, this.kpK)) + f.a.a.a.c(16, 8, this.ses)) + f.a.a.a.fQ(17, this.kpN);
            if (this.set != null) {
                fS += f.a.a.b.b.a.h(18, this.set);
            }
            if (this.seu != null) {
                fS += f.a.a.a.a(19, this.seu);
            }
            return fS + f.a.a.a.fQ(20, this.sev);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rfi.clear();
            this.ses.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six != null) {
                return 0;
            }
            throw new f.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bcc bcc = (bcc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            bbu bbu;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fl flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        bcc.six = flVar;
                    }
                    return 0;
                case 2:
                    bcc.rxG = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bcc.rxH = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    bcc.seq = aVar3.vHC.rY();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bbu = new bbu();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbu.a(aVar4, bbu, bhp.a(aVar4))) {
                        }
                        bcc.rfi.add(bbu);
                    }
                    return 0;
                case 6:
                    bcc.ser = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bcc.kpF = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bcc.kpG = aVar3.vHC.rY();
                    return 0;
                case 9:
                    bcc.seh = aVar3.vHC.rZ();
                    return 0;
                case 10:
                    bcc.kpH = aVar3.vHC.rY();
                    return 0;
                case 11:
                    bcc.kpI = aVar3.cJR();
                    return 0;
                case 12:
                    bcc.kpz = aVar3.vHC.rY();
                    return 0;
                case 13:
                    bcc.kpu = aVar3.vHC.rY();
                    return 0;
                case 14:
                    bcc.kpv = aVar3.vHC.readString();
                    return 0;
                case 15:
                    bcc.kpK = aVar3.vHC.rY();
                    return 0;
                case 16:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bbu = new bbu();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbu.a(aVar4, bbu, bhp.a(aVar4))) {
                        }
                        bcc.ses.add(bbu);
                    }
                    return 0;
                case 17:
                    bcc.kpN = aVar3.vHC.rY();
                    return 0;
                case 18:
                    bcc.set = aVar3.vHC.readString();
                    return 0;
                case 19:
                    bcc.seu = aVar3.cJR();
                    return 0;
                case 20:
                    bcc.sev = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
