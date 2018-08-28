package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class anw extends a {
    public String hbL;
    public int iwE;
    public int rQA;
    public bhz rQz;
    public String rhg;
    public String rul;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rQz == null) {
                throw new b("Not all required fields were included: NickName");
            }
            aVar.fT(1, this.iwE);
            if (this.rQz != null) {
                aVar.fV(2, this.rQz.boi());
                this.rQz.a(aVar);
            }
            if (this.rhg != null) {
                aVar.g(3, this.rhg);
            }
            if (this.rul != null) {
                aVar.g(4, this.rul);
            }
            if (this.hbL != null) {
                aVar.g(5, this.hbL);
            }
            aVar.fT(6, this.rQA);
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.iwE) + 0;
            if (this.rQz != null) {
                fQ += f.a.a.a.fS(2, this.rQz.boi());
            }
            if (this.rhg != null) {
                fQ += f.a.a.b.b.a.h(3, this.rhg);
            }
            if (this.rul != null) {
                fQ += f.a.a.b.b.a.h(4, this.rul);
            }
            if (this.hbL != null) {
                fQ += f.a.a.b.b.a.h(5, this.hbL);
            }
            return fQ + f.a.a.a.fQ(6, this.rQA);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.rQz != null) {
                return 0;
            }
            throw new b("Not all required fields were included: NickName");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            anw anw = (anw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    anw.iwE = aVar3.vHC.rY();
                    return 0;
                case 2:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        bhz bhz = new bhz();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        anw.rQz = bhz;
                    }
                    return 0;
                case 3:
                    anw.rhg = aVar3.vHC.readString();
                    return 0;
                case 4:
                    anw.rul = aVar3.vHC.readString();
                    return 0;
                case 5:
                    anw.hbL = aVar3.vHC.readString();
                    return 0;
                case 6:
                    anw.rQA = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
