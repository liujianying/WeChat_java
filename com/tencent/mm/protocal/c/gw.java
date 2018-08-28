package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class gw extends bhd {
    public int bVB;
    public String pqM;
    public String rhb;
    public String rhc;
    public String rhd;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.rhb != null) {
                aVar.g(2, this.rhb);
            }
            if (this.rhc != null) {
                aVar.g(3, this.rhc);
            }
            if (this.pqM != null) {
                aVar.g(4, this.pqM);
            }
            if (this.rhd != null) {
                aVar.g(5, this.rhd);
            }
            aVar.fT(7, this.bVB);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rhb != null) {
                fS += f.a.a.b.b.a.h(2, this.rhb);
            }
            if (this.rhc != null) {
                fS += f.a.a.b.b.a.h(3, this.rhc);
            }
            if (this.pqM != null) {
                fS += f.a.a.b.b.a.h(4, this.pqM);
            }
            if (this.rhd != null) {
                fS += f.a.a.b.b.a.h(5, this.rhd);
            }
            return fS + f.a.a.a.fQ(7, this.bVB);
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
            gw gwVar = (gw) objArr[1];
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
                        gwVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    gwVar.rhb = aVar3.vHC.readString();
                    return 0;
                case 3:
                    gwVar.rhc = aVar3.vHC.readString();
                    return 0;
                case 4:
                    gwVar.pqM = aVar3.vHC.readString();
                    return 0;
                case 5:
                    gwVar.rhd = aVar3.vHC.readString();
                    return 0;
                case 7:
                    gwVar.bVB = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
