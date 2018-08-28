package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class ab extends bhp {
    public int qZc;
    public String qZi;
    public int qZj;
    public int qZk;
    public String qZl;
    public bnr qZm;
    public bfw qZn;
    public bnr qZo;
    public bdp qZp;
    public xq qZq;
    public ep qZr;
    public String qZs;
    public String qZt;
    public int qZu;

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
            if (this.qZi != null) {
                aVar.g(2, this.qZi);
            }
            aVar.fT(3, this.qZj);
            aVar.fT(4, this.qZk);
            if (this.qZl != null) {
                aVar.g(5, this.qZl);
            }
            if (this.qZm != null) {
                aVar.fV(6, this.qZm.boi());
                this.qZm.a(aVar);
            }
            aVar.fT(7, this.qZc);
            if (this.qZn != null) {
                aVar.fV(8, this.qZn.boi());
                this.qZn.a(aVar);
            }
            if (this.qZo != null) {
                aVar.fV(9, this.qZo.boi());
                this.qZo.a(aVar);
            }
            if (this.qZp != null) {
                aVar.fV(10, this.qZp.boi());
                this.qZp.a(aVar);
            }
            if (this.qZq != null) {
                aVar.fV(11, this.qZq.boi());
                this.qZq.a(aVar);
            }
            if (this.qZr != null) {
                aVar.fV(12, this.qZr.boi());
                this.qZr.a(aVar);
            }
            if (this.qZs != null) {
                aVar.g(13, this.qZs);
            }
            if (this.qZt != null) {
                aVar.g(14, this.qZt);
            }
            aVar.fT(15, this.qZu);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.qZi != null) {
                fS += f.a.a.b.b.a.h(2, this.qZi);
            }
            fS = (fS + f.a.a.a.fQ(3, this.qZj)) + f.a.a.a.fQ(4, this.qZk);
            if (this.qZl != null) {
                fS += f.a.a.b.b.a.h(5, this.qZl);
            }
            if (this.qZm != null) {
                fS += f.a.a.a.fS(6, this.qZm.boi());
            }
            fS += f.a.a.a.fQ(7, this.qZc);
            if (this.qZn != null) {
                fS += f.a.a.a.fS(8, this.qZn.boi());
            }
            if (this.qZo != null) {
                fS += f.a.a.a.fS(9, this.qZo.boi());
            }
            if (this.qZp != null) {
                fS += f.a.a.a.fS(10, this.qZp.boi());
            }
            if (this.qZq != null) {
                fS += f.a.a.a.fS(11, this.qZq.boi());
            }
            if (this.qZr != null) {
                fS += f.a.a.a.fS(12, this.qZr.boi());
            }
            if (this.qZs != null) {
                fS += f.a.a.b.b.a.h(13, this.qZs);
            }
            if (this.qZt != null) {
                fS += f.a.a.b.b.a.h(14, this.qZt);
            }
            return fS + f.a.a.a.fQ(15, this.qZu);
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
            ab abVar = (ab) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            bnr bnr;
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
                        abVar.six = flVar;
                    }
                    return 0;
                case 2:
                    abVar.qZi = aVar3.vHC.readString();
                    return 0;
                case 3:
                    abVar.qZj = aVar3.vHC.rY();
                    return 0;
                case 4:
                    abVar.qZk = aVar3.vHC.rY();
                    return 0;
                case 5:
                    abVar.qZl = aVar3.vHC.readString();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bnr = new bnr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bnr.a(aVar4, bnr, bhp.a(aVar4))) {
                        }
                        abVar.qZm = bnr;
                    }
                    return 0;
                case 7:
                    abVar.qZc = aVar3.vHC.rY();
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bfw bfw = new bfw();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bfw.a(aVar4, bfw, bhp.a(aVar4))) {
                        }
                        abVar.qZn = bfw;
                    }
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bnr = new bnr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bnr.a(aVar4, bnr, bhp.a(aVar4))) {
                        }
                        abVar.qZo = bnr;
                    }
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bdp bdp = new bdp();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bdp.a(aVar4, bdp, bhp.a(aVar4))) {
                        }
                        abVar.qZp = bdp;
                    }
                    return 0;
                case 11:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        xq xqVar = new xq();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = xqVar.a(aVar4, xqVar, bhp.a(aVar4))) {
                        }
                        abVar.qZq = xqVar;
                    }
                    return 0;
                case 12:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ep epVar = new ep();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = epVar.a(aVar4, epVar, bhp.a(aVar4))) {
                        }
                        abVar.qZr = epVar;
                    }
                    return 0;
                case 13:
                    abVar.qZs = aVar3.vHC.readString();
                    return 0;
                case 14:
                    abVar.qZt = aVar3.vHC.readString();
                    return 0;
                case 15:
                    abVar.qZu = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
