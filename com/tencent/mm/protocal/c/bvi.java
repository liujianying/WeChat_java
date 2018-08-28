package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bvi extends bhd {
    public int aAk;
    public int rka;
    public int scene;
    public int srW;
    public int srX;
    public int srY;
    public String srZ;
    public String username;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.scene);
            aVar.fT(3, this.srW);
            aVar.fT(4, this.rka);
            aVar.fT(5, this.srX);
            aVar.fT(6, this.srY);
            if (this.username != null) {
                aVar.g(7, this.username);
            }
            aVar.fT(8, this.aAk);
            if (this.srZ == null) {
                return 0;
            }
            aVar.g(9, this.srZ);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = ((((fS + f.a.a.a.fQ(2, this.scene)) + f.a.a.a.fQ(3, this.srW)) + f.a.a.a.fQ(4, this.rka)) + f.a.a.a.fQ(5, this.srX)) + f.a.a.a.fQ(6, this.srY);
            if (this.username != null) {
                fS += f.a.a.b.b.a.h(7, this.username);
            }
            fS += f.a.a.a.fQ(8, this.aAk);
            if (this.srZ != null) {
                fS += f.a.a.b.b.a.h(9, this.srZ);
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
            bvi bvi = (bvi) objArr[1];
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
                        bvi.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bvi.scene = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bvi.srW = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bvi.rka = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bvi.srX = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bvi.srY = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bvi.username = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bvi.aAk = aVar3.vHC.rY();
                    return 0;
                case 9:
                    bvi.srZ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
