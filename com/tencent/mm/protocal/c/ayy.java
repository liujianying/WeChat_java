package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class ayy extends a {
    public bhy sbH;
    public int sbI;
    public bhy sbJ;
    public int uin;
    public int version;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.uin);
            aVar.fT(2, this.version);
            if (this.sbH != null) {
                aVar.fV(3, this.sbH.boi());
                this.sbH.a(aVar);
            }
            aVar.fT(4, this.sbI);
            if (this.sbJ != null) {
                aVar.fV(5, this.sbJ.boi());
                this.sbJ.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = (f.a.a.a.fQ(1, this.uin) + 0) + f.a.a.a.fQ(2, this.version);
            if (this.sbH != null) {
                fQ += f.a.a.a.fS(3, this.sbH.boi());
            }
            fQ += f.a.a.a.fQ(4, this.sbI);
            if (this.sbJ != null) {
                return fQ + f.a.a.a.fS(5, this.sbJ.boi());
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ayy ayy = (ayy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            bhy bhy;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    ayy.uin = aVar3.vHC.rY();
                    return 0;
                case 2:
                    ayy.version = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        ayy.sbH = bhy;
                    }
                    return 0;
                case 4:
                    ayy.sbI = aVar3.vHC.rY();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        ayy.sbJ = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
