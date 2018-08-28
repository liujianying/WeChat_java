package com.tencent.mm.plugin.game.d;

import com.tencent.mm.protocal.c.bhd;
import com.tencent.mm.protocal.c.fk;
import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bm extends bhd {
    public String eJQ;
    public String jRj;
    public int jSa;
    public int jSb;
    public int jSi;
    public int jSj;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.jRj == null) {
                throw new b("Not all required fields were included: Lang");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.jSa);
            aVar.fT(3, this.jSb);
            if (this.jRj != null) {
                aVar.g(4, this.jRj);
            }
            aVar.fT(5, this.jSi);
            aVar.fT(6, this.jSj);
            if (this.eJQ == null) {
                return 0;
            }
            aVar.g(7, this.eJQ);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.fQ(2, this.jSa)) + f.a.a.a.fQ(3, this.jSb);
            if (this.jRj != null) {
                fS += f.a.a.b.b.a.h(4, this.jRj);
            }
            fS = (fS + f.a.a.a.fQ(5, this.jSi)) + f.a.a.a.fQ(6, this.jSj);
            if (this.eJQ != null) {
                fS += f.a.a.b.b.a.h(7, this.eJQ);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.jRj != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Lang");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bm bmVar = (bm) objArr[1];
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
                        bmVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bmVar.jSa = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bmVar.jSb = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bmVar.jRj = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bmVar.jSi = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bmVar.jSj = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bmVar.eJQ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
