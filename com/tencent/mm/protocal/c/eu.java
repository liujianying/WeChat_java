package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class eu extends bhd {
    public long hbZ;
    public int otY;
    public int rfh;
    public LinkedList<pw> rfi = new LinkedList();
    public String rfj;
    public String rfk;
    public String rfl;
    public String rfm;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.rfh);
            aVar.d(3, 8, this.rfi);
            if (this.rfj != null) {
                aVar.g(4, this.rfj);
            }
            if (this.rfk != null) {
                aVar.g(5, this.rfk);
            }
            aVar.fT(6, this.otY);
            aVar.T(7, this.hbZ);
            if (this.rfl != null) {
                aVar.g(8, this.rfl);
            }
            if (this.rfm == null) {
                return 0;
            }
            aVar.g(9, this.rfm);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.fQ(2, this.rfh)) + f.a.a.a.c(3, 8, this.rfi);
            if (this.rfj != null) {
                fS += f.a.a.b.b.a.h(4, this.rfj);
            }
            if (this.rfk != null) {
                fS += f.a.a.b.b.a.h(5, this.rfk);
            }
            fS = (fS + f.a.a.a.fQ(6, this.otY)) + f.a.a.a.S(7, this.hbZ);
            if (this.rfl != null) {
                fS += f.a.a.b.b.a.h(8, this.rfl);
            }
            if (this.rfm != null) {
                fS += f.a.a.b.b.a.h(9, this.rfm);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rfi.clear();
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
            eu euVar = (eu) objArr[1];
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
                        euVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    euVar.rfh = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        pw pwVar = new pw();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = pwVar.a(aVar4, pwVar, bhd.a(aVar4))) {
                        }
                        euVar.rfi.add(pwVar);
                    }
                    return 0;
                case 4:
                    euVar.rfj = aVar3.vHC.readString();
                    return 0;
                case 5:
                    euVar.rfk = aVar3.vHC.readString();
                    return 0;
                case 6:
                    euVar.otY = aVar3.vHC.rY();
                    return 0;
                case 7:
                    euVar.hbZ = aVar3.vHC.rZ();
                    return 0;
                case 8:
                    euVar.rfl = aVar3.vHC.readString();
                    return 0;
                case 9:
                    euVar.rfm = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
