package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bdc extends bhp {
    public int hwV;
    public String hwW;
    public String plj;
    public bbc rhe;
    public String sfl;
    public LinkedList<ff> sfm = new LinkedList();

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
            aVar.fT(2, this.hwV);
            if (this.hwW != null) {
                aVar.g(3, this.hwW);
            }
            if (this.sfl != null) {
                aVar.g(4, this.sfl);
            }
            aVar.d(5, 8, this.sfm);
            if (this.rhe != null) {
                aVar.fV(6, this.rhe.boi());
                this.rhe.a(aVar);
            }
            if (this.plj == null) {
                return 0;
            }
            aVar.g(7, this.plj);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.hwV);
            if (this.hwW != null) {
                fS += f.a.a.b.b.a.h(3, this.hwW);
            }
            if (this.sfl != null) {
                fS += f.a.a.b.b.a.h(4, this.sfl);
            }
            fS += f.a.a.a.c(5, 8, this.sfm);
            if (this.rhe != null) {
                fS += f.a.a.a.fS(6, this.rhe.boi());
            }
            if (this.plj != null) {
                fS += f.a.a.b.b.a.h(7, this.plj);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.sfm.clear();
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
            bdc bdc = (bdc) objArr[1];
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
                        bdc.six = flVar;
                    }
                    return 0;
                case 2:
                    bdc.hwV = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bdc.hwW = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bdc.sfl = aVar3.vHC.readString();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ff ffVar = new ff();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ffVar.a(aVar4, ffVar, bhp.a(aVar4))) {
                        }
                        bdc.sfm.add(ffVar);
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bbc bbc = new bbc();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bbc.a(aVar4, bbc, bhp.a(aVar4))) {
                        }
                        bdc.rhe = bbc;
                    }
                    return 0;
                case 7:
                    bdc.plj = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
