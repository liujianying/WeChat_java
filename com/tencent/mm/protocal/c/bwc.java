package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bwc extends bhd {
    public String hbL;
    public LinkedList<atu> rTA = new LinkedList();
    public int rfe;
    public String rhu;
    public int sss;
    public int sst;
    public LinkedList<arr> ssu = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.hbL != null) {
                aVar.g(2, this.hbL);
            }
            aVar.fT(3, this.rfe);
            if (this.rhu != null) {
                aVar.g(4, this.rhu);
            }
            aVar.fT(5, this.sss);
            aVar.d(6, 8, this.rTA);
            aVar.fT(7, this.sst);
            aVar.d(8, 8, this.ssu);
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
            fS += f.a.a.a.fQ(3, this.rfe);
            if (this.rhu != null) {
                fS += f.a.a.b.b.a.h(4, this.rhu);
            }
            return (((fS + f.a.a.a.fQ(5, this.sss)) + f.a.a.a.c(6, 8, this.rTA)) + f.a.a.a.fQ(7, this.sst)) + f.a.a.a.c(8, 8, this.ssu);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rTA.clear();
            this.ssu.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
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
            bwc bwc = (bwc) objArr[1];
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
                        fk fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        bwc.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bwc.hbL = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bwc.rfe = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bwc.rhu = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bwc.sss = aVar3.vHC.rY();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        atu atu = new atu();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = atu.a(aVar4, atu, bhd.a(aVar4))) {
                        }
                        bwc.rTA.add(atu);
                    }
                    return 0;
                case 7:
                    bwc.sst = aVar3.vHC.rY();
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        arr arr = new arr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = arr.a(aVar4, arr, bhd.a(aVar4))) {
                        }
                        bwc.ssu.add(arr);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
