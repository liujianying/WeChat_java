package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class caw extends bhd {
    public int rnx;
    public bhy rny;
    public int rxG;
    public long rxH;
    public String seC;
    public long suO;
    public bzu sxh;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rny == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else if (this.sxh == null) {
                throw new b("Not all required fields were included: OpLog");
            } else {
                if (this.shX != null) {
                    aVar.fV(1, this.shX.boi());
                    this.shX.a(aVar);
                }
                if (this.seC != null) {
                    aVar.g(2, this.seC);
                }
                aVar.fT(3, this.rxG);
                if (this.rny != null) {
                    aVar.fV(4, this.rny.boi());
                    this.rny.a(aVar);
                }
                if (this.sxh != null) {
                    aVar.fV(5, this.sxh.boi());
                    this.sxh.a(aVar);
                }
                aVar.T(6, this.rxH);
                aVar.fT(7, this.rnx);
                aVar.T(8, this.suO);
                return 0;
            }
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.seC != null) {
                fS += f.a.a.b.b.a.h(2, this.seC);
            }
            fS += f.a.a.a.fQ(3, this.rxG);
            if (this.rny != null) {
                fS += f.a.a.a.fS(4, this.rny.boi());
            }
            if (this.sxh != null) {
                fS += f.a.a.a.fS(5, this.sxh.boi());
            }
            return ((fS + f.a.a.a.S(6, this.rxH)) + f.a.a.a.fQ(7, this.rnx)) + f.a.a.a.S(8, this.suO);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rny == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else if (this.sxh != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: OpLog");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            caw caw = (caw) objArr[1];
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
                        caw.shX = fkVar;
                    }
                    return 0;
                case 2:
                    caw.seC = aVar3.vHC.readString();
                    return 0;
                case 3:
                    caw.rxG = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        caw.rny = bhy;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bzu bzu = new bzu();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bzu.a(aVar4, bzu, bhd.a(aVar4))) {
                        }
                        caw.sxh = bzu;
                    }
                    return 0;
                case 6:
                    caw.rxH = aVar3.vHC.rZ();
                    return 0;
                case 7:
                    caw.rnx = aVar3.vHC.rY();
                    return 0;
                case 8:
                    caw.suO = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
