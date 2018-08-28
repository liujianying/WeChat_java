package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class ac extends bhd {
    public LinkedList<cr> qZd = new LinkedList();
    public int qZv;
    public sf qZw;
    public int qZx;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.qZv);
            aVar.d(3, 8, this.qZd);
            if (this.qZw != null) {
                aVar.fV(4, this.qZw.boi());
                this.qZw.a(aVar);
            }
            aVar.fT(5, this.qZx);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.fQ(2, this.qZv)) + f.a.a.a.c(3, 8, this.qZd);
            if (this.qZw != null) {
                fS += f.a.a.a.fS(4, this.qZw.boi());
            }
            return fS + f.a.a.a.fQ(5, this.qZx);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.qZd.clear();
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
            ac acVar = (ac) objArr[1];
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
                        acVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    acVar.qZv = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cr crVar = new cr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = crVar.a(aVar4, crVar, bhd.a(aVar4))) {
                        }
                        acVar.qZd.add(crVar);
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        sf sfVar = new sf();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sfVar.a(aVar4, sfVar, bhd.a(aVar4))) {
                        }
                        acVar.qZw = sfVar;
                    }
                    return 0;
                case 5:
                    acVar.qZx = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
