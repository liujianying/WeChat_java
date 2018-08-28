package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bqa extends bhp {
    public int rXE;
    public LinkedList<boy> rgH = new LinkedList();
    public bhy slZ;
    public bpp smA;
    public String smu;
    public int smy;
    public int smz;
    public int snV;
    public int snW;
    public LinkedList<cg> snX = new LinkedList();
    public int snY;
    public LinkedList<bfl> snZ = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            if (this.smu != null) {
                aVar.g(2, this.smu);
            }
            aVar.fT(3, this.rXE);
            aVar.d(4, 8, this.rgH);
            aVar.fT(5, this.snV);
            aVar.fT(6, this.smy);
            aVar.fT(7, this.smz);
            if (this.smA != null) {
                aVar.fV(8, this.smA.boi());
                this.smA.a(aVar);
            }
            aVar.fT(9, this.snW);
            aVar.d(10, 8, this.snX);
            if (this.slZ != null) {
                aVar.fV(11, this.slZ.boi());
                this.slZ.a(aVar);
            }
            aVar.fT(12, this.snY);
            aVar.d(13, 8, this.snZ);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.smu != null) {
                fS += f.a.a.b.b.a.h(2, this.smu);
            }
            fS = ((((fS + f.a.a.a.fQ(3, this.rXE)) + f.a.a.a.c(4, 8, this.rgH)) + f.a.a.a.fQ(5, this.snV)) + f.a.a.a.fQ(6, this.smy)) + f.a.a.a.fQ(7, this.smz);
            if (this.smA != null) {
                fS += f.a.a.a.fS(8, this.smA.boi());
            }
            fS = (fS + f.a.a.a.fQ(9, this.snW)) + f.a.a.a.c(10, 8, this.snX);
            if (this.slZ != null) {
                fS += f.a.a.a.fS(11, this.slZ.boi());
            }
            return (fS + f.a.a.a.fQ(12, this.snY)) + f.a.a.a.c(13, 8, this.snZ);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rgH.clear();
            this.snX.clear();
            this.snZ.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
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
            bqa bqa = (bqa) objArr[1];
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
                        bqa.six = flVar;
                    }
                    return 0;
                case 2:
                    bqa.smu = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bqa.rXE = aVar3.vHC.rY();
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
                        bqa.rgH.add(boy);
                    }
                    return 0;
                case 5:
                    bqa.snV = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bqa.smy = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bqa.smz = aVar3.vHC.rY();
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
                        bqa.smA = bpp;
                    }
                    return 0;
                case 9:
                    bqa.snW = aVar3.vHC.rY();
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cg cgVar = new cg();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cgVar.a(aVar4, cgVar, bhp.a(aVar4))) {
                        }
                        bqa.snX.add(cgVar);
                    }
                    return 0;
                case 11:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        bqa.slZ = bhy;
                    }
                    return 0;
                case 12:
                    bqa.snY = aVar3.vHC.rY();
                    return 0;
                case 13:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bfl bfl = new bfl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bfl.a(aVar4, bfl, bhp.a(aVar4))) {
                        }
                        bqa.snZ.add(bfl);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
