package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class mo extends bhp {
    public String desc;
    public int hUm;
    public String hUn;
    public String mwO;
    public String rqa;
    public int rqb;
    public LinkedList<Integer> rqc = new LinkedList();
    public int rqf;

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
            if (this.mwO != null) {
                aVar.g(4, this.mwO);
            }
            if (this.rqa != null) {
                aVar.g(5, this.rqa);
            }
            aVar.fT(6, this.rqb);
            aVar.d(7, 2, this.rqc);
            if (this.desc != null) {
                aVar.g(8, this.desc);
            }
            aVar.fT(9, this.rqf);
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
            if (this.mwO != null) {
                fS += f.a.a.b.b.a.h(4, this.mwO);
            }
            if (this.rqa != null) {
                fS += f.a.a.b.b.a.h(5, this.rqa);
            }
            fS = (fS + f.a.a.a.fQ(6, this.rqb)) + f.a.a.a.c(7, 2, this.rqc);
            if (this.desc != null) {
                fS += f.a.a.b.b.a.h(8, this.desc);
            }
            return fS + f.a.a.a.fQ(9, this.rqf);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rqc.clear();
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
            mo moVar = (mo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fl flVar = new fl();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        moVar.six = flVar;
                    }
                    return 0;
                case 2:
                    moVar.hUm = aVar3.vHC.rY();
                    return 0;
                case 3:
                    moVar.hUn = aVar3.vHC.readString();
                    return 0;
                case 4:
                    moVar.mwO = aVar3.vHC.readString();
                    return 0;
                case 5:
                    moVar.rqa = aVar3.vHC.readString();
                    return 0;
                case 6:
                    moVar.rqb = aVar3.vHC.rY();
                    return 0;
                case 7:
                    moVar.rqc.add(Integer.valueOf(aVar3.vHC.rY()));
                    return 0;
                case 8:
                    moVar.desc = aVar3.vHC.readString();
                    return 0;
                case 9:
                    moVar.rqf = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
