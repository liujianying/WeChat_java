package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class ve extends bhp {
    public int amount;
    public int bJL;
    public int ceS;
    public int ceT;
    public int hUm;
    public String hUn;
    public String kLZ;
    public int kNg;
    public String kNh;
    public String kNi;
    public String kNj;
    public int kNk;
    public String kQg;
    public bfi ryB;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            aVar.fT(2, this.hUm);
            if (this.hUn != null) {
                aVar.g(3, this.hUn);
            }
            aVar.fT(4, this.bJL);
            if (this.kLZ != null) {
                aVar.g(5, this.kLZ);
            }
            aVar.fT(6, this.ceS);
            aVar.fT(7, this.ceT);
            if (this.kQg != null) {
                aVar.g(8, this.kQg);
            }
            aVar.fT(9, this.amount);
            if (this.ryB != null) {
                aVar.fV(10, this.ryB.boi());
                this.ryB.a(aVar);
            }
            aVar.fT(11, this.kNg);
            if (this.kNh != null) {
                aVar.g(12, this.kNh);
            }
            if (this.kNi != null) {
                aVar.g(13, this.kNi);
            }
            if (this.kNj != null) {
                aVar.g(14, this.kNj);
            }
            aVar.fT(15, this.kNk);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.hUm);
            if (this.hUn != null) {
                fS += f.a.a.b.b.a.h(3, this.hUn);
            }
            fS += f.a.a.a.fQ(4, this.bJL);
            if (this.kLZ != null) {
                fS += f.a.a.b.b.a.h(5, this.kLZ);
            }
            fS = (fS + f.a.a.a.fQ(6, this.ceS)) + f.a.a.a.fQ(7, this.ceT);
            if (this.kQg != null) {
                fS += f.a.a.b.b.a.h(8, this.kQg);
            }
            fS += f.a.a.a.fQ(9, this.amount);
            if (this.ryB != null) {
                fS += f.a.a.a.fS(10, this.ryB.boi());
            }
            fS += f.a.a.a.fQ(11, this.kNg);
            if (this.kNh != null) {
                fS += f.a.a.b.b.a.h(12, this.kNh);
            }
            if (this.kNi != null) {
                fS += f.a.a.b.b.a.h(13, this.kNi);
            }
            if (this.kNj != null) {
                fS += f.a.a.b.b.a.h(14, this.kNj);
            }
            return fS + f.a.a.a.fQ(15, this.kNk);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ve veVar = (ve) objArr[1];
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
                        fl flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        veVar.six = flVar;
                    }
                    return 0;
                case 2:
                    veVar.hUm = aVar3.vHC.rY();
                    return 0;
                case 3:
                    veVar.hUn = aVar3.vHC.readString();
                    return 0;
                case 4:
                    veVar.bJL = aVar3.vHC.rY();
                    return 0;
                case 5:
                    veVar.kLZ = aVar3.vHC.readString();
                    return 0;
                case 6:
                    veVar.ceS = aVar3.vHC.rY();
                    return 0;
                case 7:
                    veVar.ceT = aVar3.vHC.rY();
                    return 0;
                case 8:
                    veVar.kQg = aVar3.vHC.readString();
                    return 0;
                case 9:
                    veVar.amount = aVar3.vHC.rY();
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bfi bfi = new bfi();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bfi.a(aVar4, bfi, bhp.a(aVar4))) {
                        }
                        veVar.ryB = bfi;
                    }
                    return 0;
                case 11:
                    veVar.kNg = aVar3.vHC.rY();
                    return 0;
                case 12:
                    veVar.kNh = aVar3.vHC.readString();
                    return 0;
                case 13:
                    veVar.kNi = aVar3.vHC.readString();
                    return 0;
                case 14:
                    veVar.kNj = aVar3.vHC.readString();
                    return 0;
                case 15:
                    veVar.kNk = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
