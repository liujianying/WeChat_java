package com.tencent.mm.plugin.game.d;

import com.tencent.mm.protocal.c.bhd;
import com.tencent.mm.protocal.c.fk;
import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bk extends bhd {
    public String eJQ;
    public LinkedList<String> jRK = new LinkedList();
    public String jRj;
    public int jSa;
    public int jSb;
    public int jSc;
    public boolean jSd;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
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
            aVar.d(5, 1, this.jRK);
            if (this.eJQ != null) {
                aVar.g(6, this.eJQ);
            }
            aVar.fT(7, this.jSc);
            aVar.av(8, this.jSd);
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
            fS += f.a.a.a.c(5, 1, this.jRK);
            if (this.eJQ != null) {
                fS += f.a.a.b.b.a.h(6, this.eJQ);
            }
            return (fS + f.a.a.a.fQ(7, this.jSc)) + (f.a.a.b.b.a.ec(8) + 1);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jRK.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
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
            bk bkVar = (bk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        bkVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bkVar.jSa = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bkVar.jSb = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bkVar.jRj = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bkVar.jRK.add(aVar3.vHC.readString());
                    return 0;
                case 6:
                    bkVar.eJQ = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bkVar.jSc = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bkVar.jSd = aVar3.cJQ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
