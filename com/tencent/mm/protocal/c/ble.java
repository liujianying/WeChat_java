package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class ble extends bhd {
    public int rXf;
    public int skl;
    public LinkedList<cce> skm = new LinkedList();
    public int skn;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.rXf);
            aVar.fT(3, this.skl);
            aVar.d(4, 8, this.skm);
            aVar.fT(5, this.skn);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            return (((fS + f.a.a.a.fQ(2, this.rXf)) + f.a.a.a.fQ(3, this.skl)) + f.a.a.a.c(4, 8, this.skm)) + f.a.a.a.fQ(5, this.skn);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.skm.clear();
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
            ble ble = (ble) objArr[1];
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
                        ble.shX = fkVar;
                    }
                    return 0;
                case 2:
                    ble.rXf = aVar3.vHC.rY();
                    return 0;
                case 3:
                    ble.skl = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cce cce = new cce();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cce.a(aVar4, cce, bhd.a(aVar4))) {
                        }
                        ble.skm.add(cce);
                    }
                    return 0;
                case 5:
                    ble.skn = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
