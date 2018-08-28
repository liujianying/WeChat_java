package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public class ahn extends bhp {
    public String ksB;
    public LinkedList<bno> rKL = new LinkedList();
    public int rKM;
    public int rKN;

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
            aVar.d(2, 8, this.rKL);
            if (this.ksB != null) {
                aVar.g(3, this.ksB);
            }
            aVar.fT(4, this.rKM);
            aVar.fT(5, this.rKN);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.c(2, 8, this.rKL);
            if (this.ksB != null) {
                fS += f.a.a.b.b.a.h(3, this.ksB);
            }
            return (fS + f.a.a.a.fQ(4, this.rKM)) + f.a.a.a.fQ(5, this.rKN);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rKL.clear();
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
            ahn ahn = (ahn) objArr[1];
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
                        ahn.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bno bno = new bno();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bno.a(aVar4, bno, bhp.a(aVar4))) {
                        }
                        ahn.rKL.add(bno);
                    }
                    return 0;
                case 3:
                    ahn.ksB = aVar3.vHC.readString();
                    return 0;
                case 4:
                    ahn.rKM = aVar3.vHC.rY();
                    return 0;
                case 5:
                    ahn.rKN = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
