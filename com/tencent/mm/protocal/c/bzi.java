package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bzi extends bhp {
    public int kpF;
    public int kpG;
    public int kpK;
    public int kpz;
    public LinkedList<bzc> rfi = new LinkedList();
    public long rxH;
    public b seu;
    public int svA;
    public LinkedList<bzc> svB = new LinkedList();
    public long svs;
    public int svx;
    public int svy;
    public int svz;

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
            aVar.T(2, this.svs);
            aVar.T(3, this.rxH);
            aVar.d(4, 8, this.rfi);
            aVar.fT(5, this.svx);
            aVar.fT(6, this.kpF);
            aVar.fT(7, this.kpG);
            aVar.fT(8, this.kpz);
            aVar.fT(9, this.kpK);
            aVar.fT(10, this.svy);
            aVar.fT(11, this.svz);
            if (this.seu != null) {
                aVar.b(12, this.seu);
            }
            aVar.fT(13, this.svA);
            aVar.d(14, 8, this.svB);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (((((((((fS + f.a.a.a.S(2, this.svs)) + f.a.a.a.S(3, this.rxH)) + f.a.a.a.c(4, 8, this.rfi)) + f.a.a.a.fQ(5, this.svx)) + f.a.a.a.fQ(6, this.kpF)) + f.a.a.a.fQ(7, this.kpG)) + f.a.a.a.fQ(8, this.kpz)) + f.a.a.a.fQ(9, this.kpK)) + f.a.a.a.fQ(10, this.svy)) + f.a.a.a.fQ(11, this.svz);
            if (this.seu != null) {
                fS += f.a.a.a.a(12, this.seu);
            }
            return (fS + f.a.a.a.fQ(13, this.svA)) + f.a.a.a.c(14, 8, this.svB);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rfi.clear();
            this.svB.clear();
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
            bzi bzi = (bzi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            bzc bzc;
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
                        bzi.six = flVar;
                    }
                    return 0;
                case 2:
                    bzi.svs = aVar3.vHC.rZ();
                    return 0;
                case 3:
                    bzi.rxH = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bzc = new bzc();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzc.a(aVar4, bzc, bhp.a(aVar4))) {
                        }
                        bzi.rfi.add(bzc);
                    }
                    return 0;
                case 5:
                    bzi.svx = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bzi.kpF = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bzi.kpG = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bzi.kpz = aVar3.vHC.rY();
                    return 0;
                case 9:
                    bzi.kpK = aVar3.vHC.rY();
                    return 0;
                case 10:
                    bzi.svy = aVar3.vHC.rY();
                    return 0;
                case 11:
                    bzi.svz = aVar3.vHC.rY();
                    return 0;
                case 12:
                    bzi.seu = aVar3.cJR();
                    return 0;
                case 13:
                    bzi.svA = aVar3.vHC.rY();
                    return 0;
                case 14:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bzc = new bzc();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzc.a(aVar4, bzc, bhp.a(aVar4))) {
                        }
                        bzi.svB.add(bzc);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
