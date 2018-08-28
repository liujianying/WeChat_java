package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bom extends bhp {
    public int rXE;
    public String rej;
    public LinkedList<boy> rgH = new LinkedList();
    public bpp smA;
    public String smu;
    public int smy;
    public int smz;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.smA == null) {
                throw new b("Not all required fields were included: ServerConfig");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                if (this.smu != null) {
                    aVar.g(2, this.smu);
                }
                aVar.fT(3, this.rXE);
                aVar.d(4, 8, this.rgH);
                aVar.fT(5, this.smy);
                if (this.rej != null) {
                    aVar.g(6, this.rej);
                }
                aVar.fT(7, this.smz);
                if (this.smA == null) {
                    return 0;
                }
                aVar.fV(8, this.smA.boi());
                this.smA.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.smu != null) {
                fS += f.a.a.b.b.a.h(2, this.smu);
            }
            fS = ((fS + f.a.a.a.fQ(3, this.rXE)) + f.a.a.a.c(4, 8, this.rgH)) + f.a.a.a.fQ(5, this.smy);
            if (this.rej != null) {
                fS += f.a.a.b.b.a.h(6, this.rej);
            }
            fS += f.a.a.a.fQ(7, this.smz);
            if (this.smA != null) {
                fS += f.a.a.a.fS(8, this.smA.boi());
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rgH.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.smA != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ServerConfig");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bom bom = (bom) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
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
                        bom.six = flVar;
                    }
                    return 0;
                case 2:
                    bom.smu = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bom.rXE = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        boy boy = new boy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = boy.a(aVar4, boy, bhp.a(aVar4))) {
                        }
                        bom.rgH.add(boy);
                    }
                    return 0;
                case 5:
                    bom.smy = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bom.rej = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bom.smz = aVar3.vHC.rY();
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bpp bpp = new bpp();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bpp.a(aVar4, bpp, bhp.a(aVar4))) {
                        }
                        bom.smA = bpp;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
