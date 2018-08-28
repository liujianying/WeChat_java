package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class lo extends bhd {
    public int amount;
    public String hyG;
    public String mxM;
    public String mxX;
    public String mxY;
    public String myl;
    public String myo;
    public String nickname;
    public String rpI;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.amount);
            if (this.hyG != null) {
                aVar.g(3, this.hyG);
            }
            if (this.myl != null) {
                aVar.g(4, this.myl);
            }
            if (this.rpI != null) {
                aVar.g(5, this.rpI);
            }
            if (this.mxX != null) {
                aVar.g(6, this.mxX);
            }
            if (this.mxY != null) {
                aVar.g(7, this.mxY);
            }
            if (this.myo != null) {
                aVar.g(8, this.myo);
            }
            if (this.nickname != null) {
                aVar.g(9, this.nickname);
            }
            if (this.mxM == null) {
                return 0;
            }
            aVar.g(10, this.mxM);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.amount);
            if (this.hyG != null) {
                fS += f.a.a.b.b.a.h(3, this.hyG);
            }
            if (this.myl != null) {
                fS += f.a.a.b.b.a.h(4, this.myl);
            }
            if (this.rpI != null) {
                fS += f.a.a.b.b.a.h(5, this.rpI);
            }
            if (this.mxX != null) {
                fS += f.a.a.b.b.a.h(6, this.mxX);
            }
            if (this.mxY != null) {
                fS += f.a.a.b.b.a.h(7, this.mxY);
            }
            if (this.myo != null) {
                fS += f.a.a.b.b.a.h(8, this.myo);
            }
            if (this.nickname != null) {
                fS += f.a.a.b.b.a.h(9, this.nickname);
            }
            if (this.mxM != null) {
                fS += f.a.a.b.b.a.h(10, this.mxM);
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
            lo loVar = (lo) objArr[1];
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
                        loVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    loVar.amount = aVar3.vHC.rY();
                    return 0;
                case 3:
                    loVar.hyG = aVar3.vHC.readString();
                    return 0;
                case 4:
                    loVar.myl = aVar3.vHC.readString();
                    return 0;
                case 5:
                    loVar.rpI = aVar3.vHC.readString();
                    return 0;
                case 6:
                    loVar.mxX = aVar3.vHC.readString();
                    return 0;
                case 7:
                    loVar.mxY = aVar3.vHC.readString();
                    return 0;
                case 8:
                    loVar.myo = aVar3.vHC.readString();
                    return 0;
                case 9:
                    loVar.nickname = aVar3.vHC.readString();
                    return 0;
                case 10:
                    loVar.mxM = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
