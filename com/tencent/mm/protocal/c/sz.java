package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class sz extends bhp {
    public bnp reD;
    public amt rhJ;
    public iz rhK;
    public avs rhL;
    public String rwj;

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
            if (this.rwj != null) {
                aVar.g(2, this.rwj);
            }
            if (this.rhK != null) {
                aVar.fV(3, this.rhK.boi());
                this.rhK.a(aVar);
            }
            if (this.rhJ != null) {
                aVar.fV(4, this.rhJ.boi());
                this.rhJ.a(aVar);
            }
            if (this.reD != null) {
                aVar.fV(5, this.reD.boi());
                this.reD.a(aVar);
            }
            if (this.rhL == null) {
                return 0;
            }
            aVar.fV(6, this.rhL.boi());
            this.rhL.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rwj != null) {
                fS += f.a.a.b.b.a.h(2, this.rwj);
            }
            if (this.rhK != null) {
                fS += f.a.a.a.fS(3, this.rhK.boi());
            }
            if (this.rhJ != null) {
                fS += f.a.a.a.fS(4, this.rhJ.boi());
            }
            if (this.reD != null) {
                fS += f.a.a.a.fS(5, this.reD.boi());
            }
            if (this.rhL != null) {
                fS += f.a.a.a.fS(6, this.rhL.boi());
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
            sz szVar = (sz) objArr[1];
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
                        szVar.six = flVar;
                    }
                    return 0;
                case 2:
                    szVar.rwj = aVar3.vHC.readString();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        iz izVar = new iz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = izVar.a(aVar4, izVar, bhp.a(aVar4))) {
                        }
                        szVar.rhK = izVar;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        amt amt = new amt();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = amt.a(aVar4, amt, bhp.a(aVar4))) {
                        }
                        szVar.rhJ = amt;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bnp bnp = new bnp();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bnp.a(aVar4, bnp, bhp.a(aVar4))) {
                        }
                        szVar.reD = bnp;
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        avs avs = new avs();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = avs.a(aVar4, avs, bhp.a(aVar4))) {
                        }
                        szVar.rhL = avs;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
