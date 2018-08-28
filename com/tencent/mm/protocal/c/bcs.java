package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bcs extends bhd {
    public long appid;
    public int bIH;
    public long riY;
    public int scene;
    public String scj;
    public int seR;
    public long seS;
    public int seT;
    public long seU;
    public long seV;
    public int seW;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.seR);
            aVar.T(3, this.seS);
            aVar.T(4, this.appid);
            aVar.T(5, this.riY);
            aVar.fT(6, this.seT);
            aVar.fT(7, this.scene);
            aVar.fT(8, this.bIH);
            aVar.T(9, this.seU);
            aVar.T(10, this.seV);
            aVar.fT(11, this.seW);
            if (this.scj == null) {
                return 0;
            }
            aVar.g(12, this.scj);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (((((((((fS + f.a.a.a.fQ(2, this.seR)) + f.a.a.a.S(3, this.seS)) + f.a.a.a.S(4, this.appid)) + f.a.a.a.S(5, this.riY)) + f.a.a.a.fQ(6, this.seT)) + f.a.a.a.fQ(7, this.scene)) + f.a.a.a.fQ(8, this.bIH)) + f.a.a.a.S(9, this.seU)) + f.a.a.a.S(10, this.seV)) + f.a.a.a.fQ(11, this.seW);
            if (this.scj != null) {
                fS += f.a.a.b.b.a.h(12, this.scj);
            }
            return fS;
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
            bcs bcs = (bcs) objArr[1];
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
                        bcs.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bcs.seR = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bcs.seS = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    bcs.appid = aVar3.vHC.rZ();
                    return 0;
                case 5:
                    bcs.riY = aVar3.vHC.rZ();
                    return 0;
                case 6:
                    bcs.seT = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bcs.scene = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bcs.bIH = aVar3.vHC.rY();
                    return 0;
                case 9:
                    bcs.seU = aVar3.vHC.rZ();
                    return 0;
                case 10:
                    bcs.seV = aVar3.vHC.rZ();
                    return 0;
                case 11:
                    bcs.seW = aVar3.vHC.rY();
                    return 0;
                case 12:
                    bcs.scj = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
