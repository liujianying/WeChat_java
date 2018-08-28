package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class afh extends bhd {
    public int jRb;
    public int otY;
    public int rJn;
    public LinkedList<atu> rJo = new LinkedList();
    public int rJp;
    public LinkedList<arr> rJq = new LinkedList();
    public String rwt;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.jRb);
            if (this.rwt != null) {
                aVar.g(3, this.rwt);
            }
            aVar.fT(4, this.rJn);
            aVar.d(5, 8, this.rJo);
            aVar.fT(6, this.rJp);
            aVar.d(7, 8, this.rJq);
            aVar.fT(8, this.otY);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.jRb);
            if (this.rwt != null) {
                fS += f.a.a.b.b.a.h(3, this.rwt);
            }
            return ((((fS + f.a.a.a.fQ(4, this.rJn)) + f.a.a.a.c(5, 8, this.rJo)) + f.a.a.a.fQ(6, this.rJp)) + f.a.a.a.c(7, 8, this.rJq)) + f.a.a.a.fQ(8, this.otY);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rJo.clear();
            this.rJq.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = com.tencent.mm.bk.a.a(aVar2); fS > 0; fS = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            afh afh = (afh) objArr[1];
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
                        com.tencent.mm.bk.a fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        afh.shX = fkVar;
                    }
                    return 0;
                case 2:
                    afh.jRb = aVar3.vHC.rY();
                    return 0;
                case 3:
                    afh.rwt = aVar3.vHC.readString();
                    return 0;
                case 4:
                    afh.rJn = aVar3.vHC.rY();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        atu atu = new atu();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = atu.a(aVar4, atu, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        afh.rJo.add(atu);
                    }
                    return 0;
                case 6:
                    afh.rJp = aVar3.vHC.rY();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        arr arr = new arr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = arr.a(aVar4, arr, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        afh.rJq.add(arr);
                    }
                    return 0;
                case 8:
                    afh.otY = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
