package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class cbt extends a {
    public cbp sxR;
    public cbf sxS;
    public String sxT;
    public String sxU;
    public String sxV;
    public int sxW;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sxR != null) {
                aVar.fV(1, this.sxR.boi());
                this.sxR.a(aVar);
            }
            if (this.sxS != null) {
                aVar.fV(2, this.sxS.boi());
                this.sxS.a(aVar);
            }
            if (this.sxT != null) {
                aVar.g(3, this.sxT);
            }
            if (this.sxU != null) {
                aVar.g(4, this.sxU);
            }
            if (this.sxV != null) {
                aVar.g(5, this.sxV);
            }
            aVar.fT(6, this.sxW);
            return 0;
        } else if (i == 1) {
            if (this.sxR != null) {
                fS = f.a.a.a.fS(1, this.sxR.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.sxS != null) {
                fS += f.a.a.a.fS(2, this.sxS.boi());
            }
            if (this.sxT != null) {
                fS += f.a.a.b.b.a.h(3, this.sxT);
            }
            if (this.sxU != null) {
                fS += f.a.a.b.b.a.h(4, this.sxU);
            }
            if (this.sxV != null) {
                fS += f.a.a.b.b.a.h(5, this.sxV);
            }
            return fS + f.a.a.a.fQ(6, this.sxW);
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
            cbt cbt = (cbt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cbp cbp = new cbp();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbp.a(aVar4, cbp, a.a(aVar4))) {
                        }
                        cbt.sxR = cbp;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cbf cbf = new cbf();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cbf.a(aVar4, cbf, a.a(aVar4))) {
                        }
                        cbt.sxS = cbf;
                    }
                    return 0;
                case 3:
                    cbt.sxT = aVar3.vHC.readString();
                    return 0;
                case 4:
                    cbt.sxU = aVar3.vHC.readString();
                    return 0;
                case 5:
                    cbt.sxV = aVar3.vHC.readString();
                    return 0;
                case 6:
                    cbt.sxW = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
