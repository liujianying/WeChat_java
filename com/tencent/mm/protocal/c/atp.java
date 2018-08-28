package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class atp extends bhp {
    public int hcE;
    public int lOH;
    public int rWU;
    public int rWV;
    public int rci;
    public bhz rck;
    public long rcq;
    public int rfn;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rck == null) {
                throw new b("Not all required fields were included: ToUserName");
            }
            aVar.fT(1, this.rfn);
            if (this.rck != null) {
                aVar.fV(2, this.rck.boi());
                this.rck.a(aVar);
            }
            aVar.fT(3, this.rci);
            aVar.fT(4, this.rWU);
            aVar.fT(5, this.lOH);
            aVar.fT(6, this.rWV);
            aVar.fT(7, this.hcE);
            aVar.T(8, this.rcq);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.rfn) + 0;
            if (this.rck != null) {
                fQ += f.a.a.a.fS(2, this.rck.boi());
            }
            return (((((fQ + f.a.a.a.fQ(3, this.rci)) + f.a.a.a.fQ(4, this.rWU)) + f.a.a.a.fQ(5, this.lOH)) + f.a.a.a.fQ(6, this.rWV)) + f.a.a.a.fQ(7, this.hcE)) + f.a.a.a.S(8, this.rcq);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = bhp.a(aVar2); fQ > 0; fQ = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
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
            atp atp = (atp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    atp.rfn = aVar3.vHC.rY();
                    return 0;
                case 2:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        bhz bhz = new bhz();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bhz.a(aVar4, bhz, bhp.a(aVar4))) {
                        }
                        atp.rck = bhz;
                    }
                    return 0;
                case 3:
                    atp.rci = aVar3.vHC.rY();
                    return 0;
                case 4:
                    atp.rWU = aVar3.vHC.rY();
                    return 0;
                case 5:
                    atp.lOH = aVar3.vHC.rY();
                    return 0;
                case 6:
                    atp.rWV = aVar3.vHC.rY();
                    return 0;
                case 7:
                    atp.hcE = aVar3.vHC.rY();
                    return 0;
                case 8:
                    atp.rcq = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
