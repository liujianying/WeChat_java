package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class aaf extends bhd {
    public LinkedList<ane> rFH = new LinkedList();
    public ang rFJ;
    public long rFK;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.d(2, 8, this.rFH);
            if (this.rFJ != null) {
                aVar.fV(4, this.rFJ.boi());
                this.rFJ.a(aVar);
            }
            aVar.T(5, this.rFK);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.c(2, 8, this.rFH);
            if (this.rFJ != null) {
                fS += f.a.a.a.fS(4, this.rFJ.boi());
            }
            return fS + f.a.a.a.S(5, this.rFK);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rFH.clear();
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
            aaf aaf = (aaf) objArr[1];
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
                        aaf.shX = fkVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ane ane = new ane();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ane.a(aVar4, ane, bhd.a(aVar4))) {
                        }
                        aaf.rFH.add(ane);
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ang ang = new ang();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ang.a(aVar4, ang, bhd.a(aVar4))) {
                        }
                        aaf.rFJ = ang;
                    }
                    return 0;
                case 5:
                    aaf.rFK = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
