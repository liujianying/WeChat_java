package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class aj extends bhd {
    public String cac;
    public String cad;
    public int cae;
    public String hwf;
    public String qZN;
    public String qZO;
    public int qZP;
    public int qZQ;
    public bqs qZR;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.cac == null) {
                throw new b("Not all required fields were included: card_id");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.hwf != null) {
                aVar.g(2, this.hwf);
            }
            aVar.fT(3, this.cae);
            if (this.cac != null) {
                aVar.g(4, this.cac);
            }
            if (this.cad != null) {
                aVar.g(5, this.cad);
            }
            if (this.qZN != null) {
                aVar.g(6, this.qZN);
            }
            if (this.qZO != null) {
                aVar.g(7, this.qZO);
            }
            aVar.fT(8, this.qZP);
            aVar.fT(9, this.qZQ);
            if (this.qZR == null) {
                return 0;
            }
            aVar.fV(10, this.qZR.boi());
            this.qZR.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.hwf != null) {
                fS += f.a.a.b.b.a.h(2, this.hwf);
            }
            fS += f.a.a.a.fQ(3, this.cae);
            if (this.cac != null) {
                fS += f.a.a.b.b.a.h(4, this.cac);
            }
            if (this.cad != null) {
                fS += f.a.a.b.b.a.h(5, this.cad);
            }
            if (this.qZN != null) {
                fS += f.a.a.b.b.a.h(6, this.qZN);
            }
            if (this.qZO != null) {
                fS += f.a.a.b.b.a.h(7, this.qZO);
            }
            fS = (fS + f.a.a.a.fQ(8, this.qZP)) + f.a.a.a.fQ(9, this.qZQ);
            if (this.qZR != null) {
                fS += f.a.a.a.fS(10, this.qZR.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.cac != null) {
                return 0;
            }
            throw new b("Not all required fields were included: card_id");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            aj ajVar = (aj) objArr[1];
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
                        ajVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    ajVar.hwf = aVar3.vHC.readString();
                    return 0;
                case 3:
                    ajVar.cae = aVar3.vHC.rY();
                    return 0;
                case 4:
                    ajVar.cac = aVar3.vHC.readString();
                    return 0;
                case 5:
                    ajVar.cad = aVar3.vHC.readString();
                    return 0;
                case 6:
                    ajVar.qZN = aVar3.vHC.readString();
                    return 0;
                case 7:
                    ajVar.qZO = aVar3.vHC.readString();
                    return 0;
                case 8:
                    ajVar.qZP = aVar3.vHC.rY();
                    return 0;
                case 9:
                    ajVar.qZQ = aVar3.vHC.rY();
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bqs bqs = new bqs();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqs.a(aVar4, bqs, bhd.a(aVar4))) {
                        }
                        ajVar.qZR = bqs;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
