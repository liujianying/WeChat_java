package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bvy extends bhd {
    public String hbL;
    public int rIp;
    public int rdV;
    public int rdW;
    public bhy rtW;
    public String ssm;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rtW == null) {
                throw new b("Not all required fields were included: Data");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.rdV);
            aVar.fT(3, this.rdW);
            aVar.fT(4, this.rIp);
            if (this.rtW != null) {
                aVar.fV(5, this.rtW.boi());
                this.rtW.a(aVar);
            }
            if (this.ssm != null) {
                aVar.g(6, this.ssm);
            }
            if (this.hbL == null) {
                return 0;
            }
            aVar.g(7, this.hbL);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = ((fS + f.a.a.a.fQ(2, this.rdV)) + f.a.a.a.fQ(3, this.rdW)) + f.a.a.a.fQ(4, this.rIp);
            if (this.rtW != null) {
                fS += f.a.a.a.fS(5, this.rtW.boi());
            }
            if (this.ssm != null) {
                fS += f.a.a.b.b.a.h(6, this.ssm);
            }
            if (this.hbL != null) {
                fS += f.a.a.b.b.a.h(7, this.hbL);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = com.tencent.mm.bk.a.a(aVar2); fS > 0; fS = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rtW != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Data");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bvy bvy = (bvy) objArr[1];
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
                        bvy.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bvy.rdV = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bvy.rdW = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bvy.rIp = aVar3.vHC.rY();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fkVar = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        bvy.rtW = fkVar;
                    }
                    return 0;
                case 6:
                    bvy.ssm = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bvy.hbL = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
