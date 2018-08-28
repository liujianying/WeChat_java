package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class aoy extends bhp {
    public String eJK;
    public String jSv;
    public String qZf;
    public String qZs;
    public LinkedList<bio> rEI = new LinkedList();
    public aof rRd;
    public String rRf;
    public String rRg;
    public String rRh;
    public int rRi;
    public String rbh;

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
            if (this.rRd != null) {
                aVar.fV(2, this.rRd.boi());
                this.rRd.a(aVar);
            }
            if (this.rRg != null) {
                aVar.g(3, this.rRg);
            }
            aVar.d(4, 8, this.rEI);
            if (this.jSv != null) {
                aVar.g(5, this.jSv);
            }
            if (this.rbh != null) {
                aVar.g(6, this.rbh);
            }
            if (this.qZs != null) {
                aVar.g(7, this.qZs);
            }
            if (this.qZf != null) {
                aVar.g(8, this.qZf);
            }
            if (this.rRh != null) {
                aVar.g(9, this.rRh);
            }
            aVar.fT(10, this.rRi);
            if (this.rRf != null) {
                aVar.g(11, this.rRf);
            }
            if (this.eJK == null) {
                return 0;
            }
            aVar.g(12, this.eJK);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rRd != null) {
                fS += f.a.a.a.fS(2, this.rRd.boi());
            }
            if (this.rRg != null) {
                fS += f.a.a.b.b.a.h(3, this.rRg);
            }
            fS += f.a.a.a.c(4, 8, this.rEI);
            if (this.jSv != null) {
                fS += f.a.a.b.b.a.h(5, this.jSv);
            }
            if (this.rbh != null) {
                fS += f.a.a.b.b.a.h(6, this.rbh);
            }
            if (this.qZs != null) {
                fS += f.a.a.b.b.a.h(7, this.qZs);
            }
            if (this.qZf != null) {
                fS += f.a.a.b.b.a.h(8, this.qZf);
            }
            if (this.rRh != null) {
                fS += f.a.a.b.b.a.h(9, this.rRh);
            }
            fS += f.a.a.a.fQ(10, this.rRi);
            if (this.rRf != null) {
                fS += f.a.a.b.b.a.h(11, this.rRf);
            }
            if (this.eJK != null) {
                fS += f.a.a.b.b.a.h(12, this.eJK);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rEI.clear();
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
            aoy aoy = (aoy) objArr[1];
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
                        aoy.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aof aof = new aof();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aof.a(aVar4, aof, bhp.a(aVar4))) {
                        }
                        aoy.rRd = aof;
                    }
                    return 0;
                case 3:
                    aoy.rRg = aVar3.vHC.readString();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bio bio = new bio();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bio.a(aVar4, bio, bhp.a(aVar4))) {
                        }
                        aoy.rEI.add(bio);
                    }
                    return 0;
                case 5:
                    aoy.jSv = aVar3.vHC.readString();
                    return 0;
                case 6:
                    aoy.rbh = aVar3.vHC.readString();
                    return 0;
                case 7:
                    aoy.qZs = aVar3.vHC.readString();
                    return 0;
                case 8:
                    aoy.qZf = aVar3.vHC.readString();
                    return 0;
                case 9:
                    aoy.rRh = aVar3.vHC.readString();
                    return 0;
                case 10:
                    aoy.rRi = aVar3.vHC.rY();
                    return 0;
                case 11:
                    aoy.rRf = aVar3.vHC.readString();
                    return 0;
                case 12:
                    aoy.eJK = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
