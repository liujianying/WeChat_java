package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bdt extends bhp {
    public int amount;
    public int hUm;
    public String hUn;
    public String jyK;
    public String muC;
    public String muD;
    public String sfU;
    public int sfV;
    public String sfW;
    public String sfX;
    public String sfY;
    public String sfZ;
    public int state;

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
            aVar.fT(4, this.state);
            if (this.sfU != null) {
                aVar.g(5, this.sfU);
            }
            aVar.fT(6, this.amount);
            aVar.fT(7, this.sfV);
            if (this.muC != null) {
                aVar.g(8, this.muC);
            }
            if (this.sfW != null) {
                aVar.g(9, this.sfW);
            }
            if (this.muD != null) {
                aVar.g(10, this.muD);
            }
            if (this.sfX != null) {
                aVar.g(11, this.sfX);
            }
            if (this.sfY != null) {
                aVar.g(12, this.sfY);
            }
            if (this.sfZ != null) {
                aVar.g(14, this.sfZ);
            }
            if (this.jyK == null) {
                return 0;
            }
            aVar.g(15, this.jyK);
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
            fS += f.a.a.a.fQ(4, this.state);
            if (this.sfU != null) {
                fS += f.a.a.b.b.a.h(5, this.sfU);
            }
            fS = (fS + f.a.a.a.fQ(6, this.amount)) + f.a.a.a.fQ(7, this.sfV);
            if (this.muC != null) {
                fS += f.a.a.b.b.a.h(8, this.muC);
            }
            if (this.sfW != null) {
                fS += f.a.a.b.b.a.h(9, this.sfW);
            }
            if (this.muD != null) {
                fS += f.a.a.b.b.a.h(10, this.muD);
            }
            if (this.sfX != null) {
                fS += f.a.a.b.b.a.h(11, this.sfX);
            }
            if (this.sfY != null) {
                fS += f.a.a.b.b.a.h(12, this.sfY);
            }
            if (this.sfZ != null) {
                fS += f.a.a.b.b.a.h(14, this.sfZ);
            }
            if (this.jyK != null) {
                fS += f.a.a.b.b.a.h(15, this.jyK);
            }
            return fS;
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
            bdt bdt = (bdt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fl flVar = new fl();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        bdt.six = flVar;
                    }
                    return 0;
                case 2:
                    bdt.hUm = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bdt.hUn = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bdt.state = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bdt.sfU = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bdt.amount = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bdt.sfV = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bdt.muC = aVar3.vHC.readString();
                    return 0;
                case 9:
                    bdt.sfW = aVar3.vHC.readString();
                    return 0;
                case 10:
                    bdt.muD = aVar3.vHC.readString();
                    return 0;
                case 11:
                    bdt.sfX = aVar3.vHC.readString();
                    return 0;
                case 12:
                    bdt.sfY = aVar3.vHC.readString();
                    return 0;
                case 14:
                    bdt.sfZ = aVar3.vHC.readString();
                    return 0;
                case 15:
                    bdt.jyK = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
