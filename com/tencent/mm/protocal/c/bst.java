package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bst extends bhp {
    public int rGc;
    public int rGd;
    public int rdV;
    public int rdW;
    public int sdg;
    public int spX;
    public LinkedList<bhz> spY = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            aVar.fT(2, this.rdW);
            aVar.fT(3, this.rdV);
            aVar.fT(4, this.rGc);
            aVar.fT(5, this.rGd);
            aVar.fT(6, this.spX);
            aVar.d(7, 8, this.spY);
            aVar.fT(8, this.sdg);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            return ((((((fS + f.a.a.a.fQ(2, this.rdW)) + f.a.a.a.fQ(3, this.rdV)) + f.a.a.a.fQ(4, this.rGc)) + f.a.a.a.fQ(5, this.rGd)) + f.a.a.a.fQ(6, this.spX)) + f.a.a.a.c(7, 8, this.spY)) + f.a.a.a.fQ(8, this.sdg);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.spY.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bst bst = (bst) objArr[1];
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
                        fl flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        bst.six = flVar;
                    }
                    return 0;
                case 2:
                    bst.rdW = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bst.rdV = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bst.rGc = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bst.rGd = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bst.spX = aVar3.vHC.rY();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhp.a(aVar4))) {
                        }
                        bst.spY.add(bhz);
                    }
                    return 0;
                case 8:
                    bst.sdg = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
