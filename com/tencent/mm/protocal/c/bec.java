package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bec extends bhp {
    public int hUm;
    public String hUn;
    public String rec;
    public LinkedList<bty> sgb = new LinkedList();
    public LinkedList<bty> sgc = new LinkedList();

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
            aVar.fT(2, this.hUm);
            if (this.hUn != null) {
                aVar.g(3, this.hUn);
            }
            aVar.d(4, 8, this.sgb);
            aVar.d(5, 8, this.sgc);
            if (this.rec == null) {
                return 0;
            }
            aVar.g(6, this.rec);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.hUm);
            if (this.hUn != null) {
                fS += f.a.a.b.b.a.h(3, this.hUn);
            }
            fS = (fS + f.a.a.a.c(4, 8, this.sgb)) + f.a.a.a.c(5, 8, this.sgc);
            if (this.rec != null) {
                fS += f.a.a.b.b.a.h(6, this.rec);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.sgb.clear();
            this.sgc.clear();
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
            bec bec = (bec) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            bty bty;
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
                        bec.six = flVar;
                    }
                    return 0;
                case 2:
                    bec.hUm = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bec.hUn = aVar3.vHC.readString();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bty = new bty();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bty.a(aVar4, bty, bhp.a(aVar4))) {
                        }
                        bec.sgb.add(bty);
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bty = new bty();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bty.a(aVar4, bty, bhp.a(aVar4))) {
                        }
                        bec.sgc.add(bty);
                    }
                    return 0;
                case 6:
                    bec.rec = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
