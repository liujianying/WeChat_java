package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class qp extends bhd {
    public int huV;
    public String kLf;
    public String rrW;
    public String rsa;
    public String ruV;
    public long ruW;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.ruV != null) {
                aVar.g(2, this.ruV);
            }
            aVar.T(3, this.ruW);
            if (this.rrW != null) {
                aVar.g(4, this.rrW);
            }
            if (this.rsa != null) {
                aVar.g(5, this.rsa);
            }
            aVar.fT(6, this.huV);
            if (this.kLf == null) {
                return 0;
            }
            aVar.g(7, this.kLf);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.ruV != null) {
                fS += f.a.a.b.b.a.h(2, this.ruV);
            }
            fS += f.a.a.a.S(3, this.ruW);
            if (this.rrW != null) {
                fS += f.a.a.b.b.a.h(4, this.rrW);
            }
            if (this.rsa != null) {
                fS += f.a.a.b.b.a.h(5, this.rsa);
            }
            fS += f.a.a.a.fQ(6, this.huV);
            if (this.kLf != null) {
                fS += f.a.a.b.b.a.h(7, this.kLf);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = com.tencent.mm.bk.a.a(aVar2); fS > 0; fS = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            qp qpVar = (qp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        com.tencent.mm.bk.a fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        qpVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    qpVar.ruV = aVar3.vHC.readString();
                    return 0;
                case 3:
                    qpVar.ruW = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    qpVar.rrW = aVar3.vHC.readString();
                    return 0;
                case 5:
                    qpVar.rsa = aVar3.vHC.readString();
                    return 0;
                case 6:
                    qpVar.huV = aVar3.vHC.rY();
                    return 0;
                case 7:
                    qpVar.kLf = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
