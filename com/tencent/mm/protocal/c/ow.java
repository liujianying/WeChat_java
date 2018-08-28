package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class ow extends bhd {
    public String jTu;
    public String jTv;
    public int otY;
    public int rci;
    public long rcq;
    public int rdV;
    public String rsZ;
    public byo rta;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.rsZ != null) {
                aVar.g(2, this.rsZ);
            }
            aVar.fT(3, this.rdV);
            aVar.fT(4, this.rci);
            if (this.rta != null) {
                aVar.fV(5, this.rta.boi());
                this.rta.a(aVar);
            }
            aVar.T(6, this.rcq);
            aVar.fT(7, this.otY);
            if (this.jTv != null) {
                aVar.g(8, this.jTv);
            }
            if (this.jTu == null) {
                return 0;
            }
            aVar.g(9, this.jTu);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rsZ != null) {
                fS += f.a.a.b.b.a.h(2, this.rsZ);
            }
            fS = (fS + f.a.a.a.fQ(3, this.rdV)) + f.a.a.a.fQ(4, this.rci);
            if (this.rta != null) {
                fS += f.a.a.a.fS(5, this.rta.boi());
            }
            fS = (fS + f.a.a.a.S(6, this.rcq)) + f.a.a.a.fQ(7, this.otY);
            if (this.jTv != null) {
                fS += f.a.a.b.b.a.h(8, this.jTv);
            }
            if (this.jTu != null) {
                fS += f.a.a.b.b.a.h(9, this.jTu);
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
            ow owVar = (ow) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
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
                        owVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    owVar.rsZ = aVar3.vHC.readString();
                    return 0;
                case 3:
                    owVar.rdV = aVar3.vHC.rY();
                    return 0;
                case 4:
                    owVar.rci = aVar3.vHC.rY();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        byo byo = new byo();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = byo.a(aVar4, byo, bhd.a(aVar4))) {
                        }
                        owVar.rta = byo;
                    }
                    return 0;
                case 6:
                    owVar.rcq = aVar3.vHC.rZ();
                    return 0;
                case 7:
                    owVar.otY = aVar3.vHC.rY();
                    return 0;
                case 8:
                    owVar.jTv = aVar3.vHC.readString();
                    return 0;
                case 9:
                    owVar.jTu = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
