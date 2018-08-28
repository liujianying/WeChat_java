package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class vm extends bhp {
    public LinkedList<aqe> rqi = new LinkedList();
    public bbt ryJ;
    public String ryK;
    public String ryL;
    public String ryM;
    public String ryN;

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
            aVar.d(2, 8, this.rqi);
            if (this.ryJ != null) {
                aVar.fV(3, this.ryJ.boi());
                this.ryJ.a(aVar);
            }
            if (this.ryK != null) {
                aVar.g(4, this.ryK);
            }
            if (this.ryL != null) {
                aVar.g(5, this.ryL);
            }
            if (this.ryM != null) {
                aVar.g(6, this.ryM);
            }
            if (this.ryN == null) {
                return 0;
            }
            aVar.g(7, this.ryN);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.c(2, 8, this.rqi);
            if (this.ryJ != null) {
                fS += f.a.a.a.fS(3, this.ryJ.boi());
            }
            if (this.ryK != null) {
                fS += f.a.a.b.b.a.h(4, this.ryK);
            }
            if (this.ryL != null) {
                fS += f.a.a.b.b.a.h(5, this.ryL);
            }
            if (this.ryM != null) {
                fS += f.a.a.b.b.a.h(6, this.ryM);
            }
            if (this.ryN != null) {
                fS += f.a.a.b.b.a.h(7, this.ryN);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rqi.clear();
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
            vm vmVar = (vm) objArr[1];
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
                        vmVar.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aqe aqe = new aqe();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aqe.a(aVar4, aqe, bhp.a(aVar4))) {
                        }
                        vmVar.rqi.add(aqe);
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bbt bbt = new bbt();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbt.a(aVar4, bbt, bhp.a(aVar4))) {
                        }
                        vmVar.ryJ = bbt;
                    }
                    return 0;
                case 4:
                    vmVar.ryK = aVar3.vHC.readString();
                    return 0;
                case 5:
                    vmVar.ryL = aVar3.vHC.readString();
                    return 0;
                case 6:
                    vmVar.ryM = aVar3.vHC.readString();
                    return 0;
                case 7:
                    vmVar.ryN = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
