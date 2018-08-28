package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class aeb extends bhd {
    public String hbL;
    public int rIm;
    public int rIn;
    public String rIo;
    public int rIp;
    public int rdV;
    public int rdW;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.hbL != null) {
                aVar.g(2, this.hbL);
            }
            aVar.fT(3, this.rIm);
            aVar.fT(4, this.rIn);
            if (this.rIo != null) {
                aVar.g(5, this.rIo);
            }
            aVar.fT(6, this.rdV);
            aVar.fT(7, this.rdW);
            aVar.fT(8, this.rIp);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.hbL != null) {
                fS += f.a.a.b.b.a.h(2, this.hbL);
            }
            fS = (fS + f.a.a.a.fQ(3, this.rIm)) + f.a.a.a.fQ(4, this.rIn);
            if (this.rIo != null) {
                fS += f.a.a.b.b.a.h(5, this.rIo);
            }
            return ((fS + f.a.a.a.fQ(6, this.rdV)) + f.a.a.a.fQ(7, this.rdW)) + f.a.a.a.fQ(8, this.rIp);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = com.tencent.mm.bk.a.a(aVar2); fS > 0; fS = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            aeb aeb = (aeb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        com.tencent.mm.bk.a fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        aeb.shX = fkVar;
                    }
                    return 0;
                case 2:
                    aeb.hbL = aVar3.vHC.readString();
                    return 0;
                case 3:
                    aeb.rIm = aVar3.vHC.rY();
                    return 0;
                case 4:
                    aeb.rIn = aVar3.vHC.rY();
                    return 0;
                case 5:
                    aeb.rIo = aVar3.vHC.readString();
                    return 0;
                case 6:
                    aeb.rdV = aVar3.vHC.rY();
                    return 0;
                case 7:
                    aeb.rdW = aVar3.vHC.rY();
                    return 0;
                case 8:
                    aeb.rIp = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
