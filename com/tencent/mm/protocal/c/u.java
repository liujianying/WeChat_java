package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class u extends bhd {
    public String qYc;
    public String qYd;
    public int scene;
    public String sign;
    public int ver;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.qYc != null) {
                aVar.g(2, this.qYc);
            }
            aVar.fT(3, this.scene);
            if (this.qYd != null) {
                aVar.g(4, this.qYd);
            }
            if (this.sign != null) {
                aVar.g(5, this.sign);
            }
            aVar.fT(6, this.ver);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.qYc != null) {
                fS += f.a.a.b.b.a.h(2, this.qYc);
            }
            fS += f.a.a.a.fQ(3, this.scene);
            if (this.qYd != null) {
                fS += f.a.a.b.b.a.h(4, this.qYd);
            }
            if (this.sign != null) {
                fS += f.a.a.b.b.a.h(5, this.sign);
            }
            return fS + f.a.a.a.fQ(6, this.ver);
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
            u uVar = (u) objArr[1];
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
                        uVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    uVar.qYc = aVar3.vHC.readString();
                    return 0;
                case 3:
                    uVar.scene = aVar3.vHC.rY();
                    return 0;
                case 4:
                    uVar.qYd = aVar3.vHC.readString();
                    return 0;
                case 5:
                    uVar.sign = aVar3.vHC.readString();
                    return 0;
                case 6:
                    uVar.ver = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
