package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bwo extends bhd {
    public double altitude;
    public int bjj;
    public double latitude;
    public double longitude;
    public double ssO;
    public double ssP;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.c(2, this.latitude);
            aVar.c(3, this.longitude);
            aVar.c(4, this.altitude);
            aVar.c(5, this.ssO);
            aVar.c(6, this.ssP);
            aVar.fT(7, this.bjj);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            return (((((fS + (f.a.a.b.b.a.ec(2) + 8)) + (f.a.a.b.b.a.ec(3) + 8)) + (f.a.a.b.b.a.ec(4) + 8)) + (f.a.a.b.b.a.ec(5) + 8)) + (f.a.a.b.b.a.ec(6) + 8)) + f.a.a.a.fQ(7, this.bjj);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            bwo bwo = (bwo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        bwo.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bwo.latitude = aVar3.vHC.readDouble();
                    return 0;
                case 3:
                    bwo.longitude = aVar3.vHC.readDouble();
                    return 0;
                case 4:
                    bwo.altitude = aVar3.vHC.readDouble();
                    return 0;
                case 5:
                    bwo.ssO = aVar3.vHC.readDouble();
                    return 0;
                case 6:
                    bwo.ssP = aVar3.vHC.readDouble();
                    return 0;
                case 7:
                    bwo.bjj = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
