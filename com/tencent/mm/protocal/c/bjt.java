package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bjt extends bhp {
    public int rJK;
    public int rTp;
    public int sjG;
    public LinkedList<bju> sjH = new LinkedList();
    public bhy sjl;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.sjl == null) {
                throw new b("Not all required fields were included: ResBuf");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                aVar.fT(2, this.sjG);
                aVar.d(3, 8, this.sjH);
                aVar.fT(4, this.rTp);
                aVar.fT(5, this.rJK);
                if (this.sjl == null) {
                    return 0;
                }
                aVar.fV(6, this.sjl.boi());
                this.sjl.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (((fS + f.a.a.a.fQ(2, this.sjG)) + f.a.a.a.c(3, 8, this.sjH)) + f.a.a.a.fQ(4, this.rTp)) + f.a.a.a.fQ(5, this.rJK);
            if (this.sjl != null) {
                fS += f.a.a.a.fS(6, this.sjl.boi());
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.sjH.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.sjl != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ResBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bjt bjt = (bjt) objArr[1];
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
                        bjt.six = flVar;
                    }
                    return 0;
                case 2:
                    bjt.sjG = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bju bju = new bju();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bju.a(aVar4, bju, bhp.a(aVar4))) {
                        }
                        bjt.sjH.add(bju);
                    }
                    return 0;
                case 4:
                    bjt.rTp = aVar3.vHC.rY();
                    return 0;
                case 5:
                    bjt.rJK = aVar3.vHC.rY();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, bhp.a(aVar4))) {
                        }
                        bjt.sjl = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
