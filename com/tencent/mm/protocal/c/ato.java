package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class ato extends a {
    public int hcE;
    public String jSA;
    public int lOH;
    public int rWU;
    public bhz rck;
    public String rco;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rck == null) {
                throw new b("Not all required fields were included: ToUserName");
            }
            if (this.rck != null) {
                aVar.fV(1, this.rck.boi());
                this.rck.a(aVar);
            }
            if (this.jSA != null) {
                aVar.g(2, this.jSA);
            }
            aVar.fT(3, this.hcE);
            aVar.fT(4, this.lOH);
            aVar.fT(5, this.rWU);
            if (this.rco == null) {
                return 0;
            }
            aVar.g(6, this.rco);
            return 0;
        } else if (i == 1) {
            if (this.rck != null) {
                fS = f.a.a.a.fS(1, this.rck.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.jSA != null) {
                fS += f.a.a.b.b.a.h(2, this.jSA);
            }
            fS = ((fS + f.a.a.a.fQ(3, this.hcE)) + f.a.a.a.fQ(4, this.lOH)) + f.a.a.a.fQ(5, this.rWU);
            if (this.rco != null) {
                fS += f.a.a.b.b.a.h(6, this.rco);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rck != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ToUserName");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ato ato = (ato) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        bhz bhz = new bhz();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        ato.rck = bhz;
                    }
                    return 0;
                case 2:
                    ato.jSA = aVar3.vHC.readString();
                    return 0;
                case 3:
                    ato.hcE = aVar3.vHC.rY();
                    return 0;
                case 4:
                    ato.lOH = aVar3.vHC.rY();
                    return 0;
                case 5:
                    ato.rWU = aVar3.vHC.rY();
                    return 0;
                case 6:
                    ato.rco = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
