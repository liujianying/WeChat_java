package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class bfp extends a {
    public bhz sgN;
    public int sgO;
    public LinkedList<bju> sgP = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sgN == null) {
                throw new b("Not all required fields were included: GroupName");
            }
            if (this.sgN != null) {
                aVar.fV(1, this.sgN.boi());
                this.sgN.a(aVar);
            }
            aVar.fT(2, this.sgO);
            aVar.d(3, 8, this.sgP);
            return 0;
        } else if (i == 1) {
            if (this.sgN != null) {
                fS = f.a.a.a.fS(1, this.sgN.boi()) + 0;
            } else {
                fS = 0;
            }
            return (fS + f.a.a.a.fQ(2, this.sgO)) + f.a.a.a.c(3, 8, this.sgP);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.sgP.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.sgN != null) {
                return 0;
            }
            throw new b("Not all required fields were included: GroupName");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bfp bfp = (bfp) objArr[1];
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
                        bhz bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        bfp.sgN = bhz;
                    }
                    return 0;
                case 2:
                    bfp.sgO = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bju bju = new bju();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bju.a(aVar4, bju, a.a(aVar4))) {
                        }
                        bfp.sgP.add(bju);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
