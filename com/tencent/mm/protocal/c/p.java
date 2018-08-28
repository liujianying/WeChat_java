package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class p extends bhd {
    public String myq;
    public String qYc;
    public String qYd;
    public long qYv;
    public String qYx;
    public int scene;

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
            aVar.T(3, this.qYv);
            aVar.fT(4, this.scene);
            if (this.qYd != null) {
                aVar.g(5, this.qYd);
            }
            if (this.qYx != null) {
                aVar.g(6, this.qYx);
            }
            if (this.myq == null) {
                return 0;
            }
            aVar.g(7, this.myq);
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
            fS = (fS + f.a.a.a.S(3, this.qYv)) + f.a.a.a.fQ(4, this.scene);
            if (this.qYd != null) {
                fS += f.a.a.b.b.a.h(5, this.qYd);
            }
            if (this.qYx != null) {
                fS += f.a.a.b.b.a.h(6, this.qYx);
            }
            if (this.myq != null) {
                fS += f.a.a.b.b.a.h(7, this.myq);
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
            p pVar = (p) objArr[1];
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
                        pVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    pVar.qYc = aVar3.vHC.readString();
                    return 0;
                case 3:
                    pVar.qYv = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    pVar.scene = aVar3.vHC.rY();
                    return 0;
                case 5:
                    pVar.qYd = aVar3.vHC.readString();
                    return 0;
                case 6:
                    pVar.qYx = aVar3.vHC.readString();
                    return 0;
                case 7:
                    pVar.myq = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
