package com.tencent.mm.plugin.game.d;

import com.tencent.mm.protocal.c.bhd;
import com.tencent.mm.protocal.c.fk;
import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bc extends bhd {
    public String eJQ;
    public LinkedList<String> jRK = new LinkedList();
    public r jRL;
    public int jRM;
    public boolean jRN;
    public String jRj;
    public int jRk;

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
            if (this.jRj != null) {
                aVar.g(2, this.jRj);
            }
            aVar.d(3, 1, this.jRK);
            if (this.eJQ != null) {
                aVar.g(4, this.eJQ);
            }
            if (this.jRL != null) {
                aVar.fV(5, this.jRL.boi());
                this.jRL.a(aVar);
            }
            aVar.fT(6, this.jRM);
            aVar.av(7, this.jRN);
            aVar.fT(8, this.jRk);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.jRj != null) {
                fS += f.a.a.b.b.a.h(2, this.jRj);
            }
            fS += f.a.a.a.c(3, 1, this.jRK);
            if (this.eJQ != null) {
                fS += f.a.a.b.b.a.h(4, this.eJQ);
            }
            if (this.jRL != null) {
                fS += f.a.a.a.fS(5, this.jRL.boi());
            }
            return ((fS + f.a.a.a.fQ(6, this.jRM)) + (f.a.a.b.b.a.ec(7) + 1)) + f.a.a.a.fQ(8, this.jRk);
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
            bc bcVar = (bc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        bcVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bcVar.jRj = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bcVar.jRK.add(aVar3.vHC.readString());
                    return 0;
                case 4:
                    bcVar.eJQ = aVar3.vHC.readString();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        r rVar = new r();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = rVar.a(aVar4, rVar, bhd.a(aVar4))) {
                        }
                        bcVar.jRL = rVar;
                    }
                    return 0;
                case 6:
                    bcVar.jRM = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bcVar.jRN = aVar3.cJQ();
                    return 0;
                case 8:
                    bcVar.jRk = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
