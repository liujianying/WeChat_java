package com.tencent.mm.plugin.game.d;

import com.tencent.mm.protocal.c.bhd;
import com.tencent.mm.protocal.c.fk;
import f.a.a.c.a;
import java.util.LinkedList;

public final class at extends bhd {
    public String jPc;
    public int jRa;
    public int jRb;
    public int jRc;
    public String jRd;
    public String jRe;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.jPc != null) {
                aVar.g(2, this.jPc);
            }
            aVar.fT(3, this.jRa);
            aVar.fT(4, this.jRb);
            aVar.fT(5, this.jRc);
            if (this.jRd != null) {
                aVar.g(6, this.jRd);
            }
            if (this.jRe == null) {
                return 0;
            }
            aVar.g(7, this.jRe);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.jPc != null) {
                fS += f.a.a.b.b.a.h(2, this.jPc);
            }
            fS = ((fS + f.a.a.a.fQ(3, this.jRa)) + f.a.a.a.fQ(4, this.jRb)) + f.a.a.a.fQ(5, this.jRc);
            if (this.jRd != null) {
                fS += f.a.a.b.b.a.h(6, this.jRd);
            }
            if (this.jRe != null) {
                fS += f.a.a.b.b.a.h(7, this.jRe);
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
            at atVar = (at) objArr[1];
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
                        atVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    atVar.jPc = aVar3.vHC.readString();
                    return 0;
                case 3:
                    atVar.jRa = aVar3.vHC.rY();
                    return 0;
                case 4:
                    atVar.jRb = aVar3.vHC.rY();
                    return 0;
                case 5:
                    atVar.jRc = aVar3.vHC.rY();
                    return 0;
                case 6:
                    atVar.jRd = aVar3.vHC.readString();
                    return 0;
                case 7:
                    atVar.jRe = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
