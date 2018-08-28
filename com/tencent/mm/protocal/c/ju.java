package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class ju extends a {
    public String bHD;
    public int hcf;
    public LinkedList<jz> jQF = new LinkedList();
    public int rjC;
    public long rll;
    public int rlm;
    public LinkedList<String> rln = new LinkedList();
    public String rlo;

    protected final int a(int i, Object... objArr) {
        int S;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rlo == null) {
                throw new b("Not all required fields were included: SearchID");
            }
            aVar.T(1, this.rll);
            aVar.fT(2, this.rlm);
            if (this.bHD != null) {
                aVar.g(3, this.bHD);
            }
            aVar.d(4, 1, this.rln);
            aVar.d(5, 8, this.jQF);
            aVar.fT(6, this.hcf);
            if (this.rlo != null) {
                aVar.g(7, this.rlo);
            }
            aVar.fT(8, this.rjC);
            return 0;
        } else if (i == 1) {
            S = (f.a.a.a.S(1, this.rll) + 0) + f.a.a.a.fQ(2, this.rlm);
            if (this.bHD != null) {
                S += f.a.a.b.b.a.h(3, this.bHD);
            }
            S = ((S + f.a.a.a.c(4, 1, this.rln)) + f.a.a.a.c(5, 8, this.jQF)) + f.a.a.a.fQ(6, this.hcf);
            if (this.rlo != null) {
                S += f.a.a.b.b.a.h(7, this.rlo);
            }
            return S + f.a.a.a.fQ(8, this.rjC);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rln.clear();
            this.jQF.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (S = a.a(aVar2); S > 0; S = a.a(aVar2)) {
                if (!super.a(aVar2, this, S)) {
                    aVar2.cJS();
                }
            }
            if (this.rlo != null) {
                return 0;
            }
            throw new b("Not all required fields were included: SearchID");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ju juVar = (ju) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    juVar.rll = aVar3.vHC.rZ();
                    return 0;
                case 2:
                    juVar.rlm = aVar3.vHC.rY();
                    return 0;
                case 3:
                    juVar.bHD = aVar3.vHC.readString();
                    return 0;
                case 4:
                    juVar.rln.add(aVar3.vHC.readString());
                    return 0;
                case 5:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        jz jzVar = new jz();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = jzVar.a(aVar4, jzVar, a.a(aVar4))) {
                        }
                        juVar.jQF.add(jzVar);
                    }
                    return 0;
                case 6:
                    juVar.hcf = aVar3.vHC.rY();
                    return 0;
                case 7:
                    juVar.rlo = aVar3.vHC.readString();
                    return 0;
                case 8:
                    juVar.rjC = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
