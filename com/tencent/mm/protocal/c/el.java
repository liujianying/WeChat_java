package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class el extends bhd {
    public String dkY;
    public String eJK;
    public String hbP;
    public String iwO;
    public String iwP;
    public int qZe;
    public fi reP;
    public String reQ;
    public int reR;
    public String reS;
    public String reT;
    public bhy res;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.res == null) {
                throw new b("Not all required fields were included: AutoAuthKey");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.reP != null) {
                aVar.fV(2, this.reP.boi());
                this.reP.a(aVar);
            }
            if (this.res != null) {
                aVar.fV(3, this.res.boi());
                this.res.a(aVar);
            }
            if (this.dkY != null) {
                aVar.g(4, this.dkY);
            }
            if (this.reQ != null) {
                aVar.g(5, this.reQ);
            }
            aVar.fT(6, this.reR);
            if (this.reS != null) {
                aVar.g(7, this.reS);
            }
            if (this.eJK != null) {
                aVar.g(8, this.eJK);
            }
            if (this.hbP != null) {
                aVar.g(9, this.hbP);
            }
            if (this.reT != null) {
                aVar.g(10, this.reT);
            }
            if (this.iwP != null) {
                aVar.g(11, this.iwP);
            }
            if (this.iwO != null) {
                aVar.g(12, this.iwO);
            }
            aVar.fT(13, this.qZe);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.reP != null) {
                fS += f.a.a.a.fS(2, this.reP.boi());
            }
            if (this.res != null) {
                fS += f.a.a.a.fS(3, this.res.boi());
            }
            if (this.dkY != null) {
                fS += f.a.a.b.b.a.h(4, this.dkY);
            }
            if (this.reQ != null) {
                fS += f.a.a.b.b.a.h(5, this.reQ);
            }
            fS += f.a.a.a.fQ(6, this.reR);
            if (this.reS != null) {
                fS += f.a.a.b.b.a.h(7, this.reS);
            }
            if (this.eJK != null) {
                fS += f.a.a.b.b.a.h(8, this.eJK);
            }
            if (this.hbP != null) {
                fS += f.a.a.b.b.a.h(9, this.hbP);
            }
            if (this.reT != null) {
                fS += f.a.a.b.b.a.h(10, this.reT);
            }
            if (this.iwP != null) {
                fS += f.a.a.b.b.a.h(11, this.iwP);
            }
            if (this.iwO != null) {
                fS += f.a.a.b.b.a.h(12, this.iwO);
            }
            return fS + f.a.a.a.fQ(13, this.qZe);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = com.tencent.mm.bk.a.a(aVar2); fS > 0; fS = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.res != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AutoAuthKey");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            el elVar = (el) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            com.tencent.mm.bk.a fkVar;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        elVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fkVar = new fi();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        elVar.reP = fkVar;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fkVar = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        elVar.res = fkVar;
                    }
                    return 0;
                case 4:
                    elVar.dkY = aVar3.vHC.readString();
                    return 0;
                case 5:
                    elVar.reQ = aVar3.vHC.readString();
                    return 0;
                case 6:
                    elVar.reR = aVar3.vHC.rY();
                    return 0;
                case 7:
                    elVar.reS = aVar3.vHC.readString();
                    return 0;
                case 8:
                    elVar.eJK = aVar3.vHC.readString();
                    return 0;
                case 9:
                    elVar.hbP = aVar3.vHC.readString();
                    return 0;
                case 10:
                    elVar.reT = aVar3.vHC.readString();
                    return 0;
                case 11:
                    elVar.iwP = aVar3.vHC.readString();
                    return 0;
                case 12:
                    elVar.iwO = aVar3.vHC.readString();
                    return 0;
                case 13:
                    elVar.qZe = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
