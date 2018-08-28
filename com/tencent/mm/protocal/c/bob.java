package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bob extends a {
    public int rdq;
    public bhz slT;
    public bhz slV;
    public int slW;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.slT != null) {
                aVar.fV(1, this.slT.boi());
                this.slT.a(aVar);
            }
            aVar.fT(2, this.rdq);
            if (this.slV != null) {
                aVar.fV(3, this.slV.boi());
                this.slV.a(aVar);
            }
            aVar.fT(4, this.slW);
            return 0;
        } else if (i == 1) {
            if (this.slT != null) {
                fS = f.a.a.a.fS(1, this.slT.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.rdq);
            if (this.slV != null) {
                fS += f.a.a.a.fS(3, this.slV.boi());
            }
            return fS + f.a.a.a.fQ(4, this.slW);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bob bob = (bob) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            bhz bhz;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        bob.slT = bhz;
                    }
                    return 0;
                case 2:
                    bob.rdq = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        bob.slV = bhz;
                    }
                    return 0;
                case 4:
                    bob.slW = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
