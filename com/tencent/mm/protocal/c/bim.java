package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bim extends bhd {
    public int otY;
    public bbd sja;
    public float sjb;
    public float sjc;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.sja == null) {
                throw new b("Not all required fields were included: UserPos");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.sja != null) {
                aVar.fV(2, this.sja.boi());
                this.sja.a(aVar);
            }
            aVar.fT(3, this.otY);
            aVar.l(4, this.sjb);
            aVar.l(5, this.sjc);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.sja != null) {
                fS += f.a.a.a.fS(2, this.sja.boi());
            }
            return ((fS + f.a.a.a.fQ(3, this.otY)) + (f.a.a.b.b.a.ec(4) + 4)) + (f.a.a.b.b.a.ec(5) + 4);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.sja != null) {
                return 0;
            }
            throw new b("Not all required fields were included: UserPos");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bim bim = (bim) objArr[1];
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
                        bim.shX = fkVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bbd bbd = new bbd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbd.a(aVar4, bbd, bhd.a(aVar4))) {
                        }
                        bim.sja = bbd;
                    }
                    return 0;
                case 3:
                    bim.otY = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bim.sjb = aVar3.vHC.readFloat();
                    return 0;
                case 5:
                    bim.sjc = aVar3.vHC.readFloat();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
