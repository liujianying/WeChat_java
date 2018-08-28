package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class nf extends bhd {
    public String ecE;
    public String jTu;
    public String jTv;
    public int rdY;
    public String rmy;
    public long rri;
    public String rrj;
    public String rrk;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.jTv != null) {
                aVar.g(2, this.jTv);
            }
            if (this.jTu != null) {
                aVar.g(3, this.jTu);
            }
            aVar.T(4, this.rri);
            if (this.rmy != null) {
                aVar.g(5, this.rmy);
            }
            if (this.rrj != null) {
                aVar.g(6, this.rrj);
            }
            aVar.fT(7, this.rdY);
            if (this.rrk != null) {
                aVar.g(8, this.rrk);
            }
            if (this.ecE == null) {
                return 0;
            }
            aVar.g(9, this.ecE);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.jTv != null) {
                fS += f.a.a.b.b.a.h(2, this.jTv);
            }
            if (this.jTu != null) {
                fS += f.a.a.b.b.a.h(3, this.jTu);
            }
            fS += f.a.a.a.S(4, this.rri);
            if (this.rmy != null) {
                fS += f.a.a.b.b.a.h(5, this.rmy);
            }
            if (this.rrj != null) {
                fS += f.a.a.b.b.a.h(6, this.rrj);
            }
            fS += f.a.a.a.fQ(7, this.rdY);
            if (this.rrk != null) {
                fS += f.a.a.b.b.a.h(8, this.rrk);
            }
            if (this.ecE != null) {
                fS += f.a.a.b.b.a.h(9, this.ecE);
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
            nf nfVar = (nf) objArr[1];
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
                        nfVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    nfVar.jTv = aVar3.vHC.readString();
                    return 0;
                case 3:
                    nfVar.jTu = aVar3.vHC.readString();
                    return 0;
                case 4:
                    nfVar.rri = aVar3.vHC.rZ();
                    return 0;
                case 5:
                    nfVar.rmy = aVar3.vHC.readString();
                    return 0;
                case 6:
                    nfVar.rrj = aVar3.vHC.readString();
                    return 0;
                case 7:
                    nfVar.rdY = aVar3.vHC.rY();
                    return 0;
                case 8:
                    nfVar.rrk = aVar3.vHC.readString();
                    return 0;
                case 9:
                    nfVar.ecE = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
