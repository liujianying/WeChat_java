package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class zr extends bhd {
    public String appId;
    public String bJT;
    public String jkW;
    public String jkX;
    public String jkY;
    public String qZf;
    public int qZg;
    public cr rFz;
    public String sign;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.appId != null) {
                aVar.g(2, this.appId);
            }
            if (this.jkW != null) {
                aVar.g(3, this.jkW);
            }
            if (this.jkX != null) {
                aVar.g(4, this.jkX);
            }
            if (this.jkY != null) {
                aVar.g(5, this.jkY);
            }
            if (this.bJT != null) {
                aVar.g(6, this.bJT);
            }
            if (this.sign != null) {
                aVar.g(7, this.sign);
            }
            if (this.rFz != null) {
                aVar.fV(8, this.rFz.boi());
                this.rFz.a(aVar);
            }
            if (this.qZf != null) {
                aVar.g(9, this.qZf);
            }
            aVar.fT(10, this.qZg);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.appId != null) {
                fS += f.a.a.b.b.a.h(2, this.appId);
            }
            if (this.jkW != null) {
                fS += f.a.a.b.b.a.h(3, this.jkW);
            }
            if (this.jkX != null) {
                fS += f.a.a.b.b.a.h(4, this.jkX);
            }
            if (this.jkY != null) {
                fS += f.a.a.b.b.a.h(5, this.jkY);
            }
            if (this.bJT != null) {
                fS += f.a.a.b.b.a.h(6, this.bJT);
            }
            if (this.sign != null) {
                fS += f.a.a.b.b.a.h(7, this.sign);
            }
            if (this.rFz != null) {
                fS += f.a.a.a.fS(8, this.rFz.boi());
            }
            if (this.qZf != null) {
                fS += f.a.a.b.b.a.h(9, this.qZf);
            }
            return fS + f.a.a.a.fQ(10, this.qZg);
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
            zr zrVar = (zr) objArr[1];
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
                        com.tencent.mm.bk.a fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        zrVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    zrVar.appId = aVar3.vHC.readString();
                    return 0;
                case 3:
                    zrVar.jkW = aVar3.vHC.readString();
                    return 0;
                case 4:
                    zrVar.jkX = aVar3.vHC.readString();
                    return 0;
                case 5:
                    zrVar.jkY = aVar3.vHC.readString();
                    return 0;
                case 6:
                    zrVar.bJT = aVar3.vHC.readString();
                    return 0;
                case 7:
                    zrVar.sign = aVar3.vHC.readString();
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cr crVar = new cr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = crVar.a(aVar4, crVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        zrVar.rFz = crVar;
                    }
                    return 0;
                case 9:
                    zrVar.qZf = aVar3.vHC.readString();
                    return 0;
                case 10:
                    zrVar.qZg = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
