package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class he extends bhd {
    public int rfe;
    public int rhm;
    public String rhn;
    public String rho;
    public String rhp;
    public String rhq;
    public String rhr;
    public String rhs;
    public String rht;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.rfe);
            aVar.fT(3, this.rhm);
            if (this.rhn != null) {
                aVar.g(4, this.rhn);
            }
            if (this.rho != null) {
                aVar.g(5, this.rho);
            }
            if (this.rhp != null) {
                aVar.g(6, this.rhp);
            }
            if (this.rhq != null) {
                aVar.g(7, this.rhq);
            }
            if (this.rhr != null) {
                aVar.g(8, this.rhr);
            }
            if (this.rhs != null) {
                aVar.g(9, this.rhs);
            }
            if (this.rht == null) {
                return 0;
            }
            aVar.g(10, this.rht);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.fQ(2, this.rfe)) + f.a.a.a.fQ(3, this.rhm);
            if (this.rhn != null) {
                fS += f.a.a.b.b.a.h(4, this.rhn);
            }
            if (this.rho != null) {
                fS += f.a.a.b.b.a.h(5, this.rho);
            }
            if (this.rhp != null) {
                fS += f.a.a.b.b.a.h(6, this.rhp);
            }
            if (this.rhq != null) {
                fS += f.a.a.b.b.a.h(7, this.rhq);
            }
            if (this.rhr != null) {
                fS += f.a.a.b.b.a.h(8, this.rhr);
            }
            if (this.rhs != null) {
                fS += f.a.a.b.b.a.h(9, this.rhs);
            }
            if (this.rht != null) {
                fS += f.a.a.b.b.a.h(10, this.rht);
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
            he heVar = (he) objArr[1];
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
                        heVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    heVar.rfe = aVar3.vHC.rY();
                    return 0;
                case 3:
                    heVar.rhm = aVar3.vHC.rY();
                    return 0;
                case 4:
                    heVar.rhn = aVar3.vHC.readString();
                    return 0;
                case 5:
                    heVar.rho = aVar3.vHC.readString();
                    return 0;
                case 6:
                    heVar.rhp = aVar3.vHC.readString();
                    return 0;
                case 7:
                    heVar.rhq = aVar3.vHC.readString();
                    return 0;
                case 8:
                    heVar.rhr = aVar3.vHC.readString();
                    return 0;
                case 9:
                    heVar.rhs = aVar3.vHC.readString();
                    return 0;
                case 10:
                    heVar.rht = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
