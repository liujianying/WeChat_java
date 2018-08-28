package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class aop extends bhd {
    public String bJT;
    public String bPS;
    public String rQC;
    public String rQE;
    public String rQF;
    public b rQG;
    public int rQH;
    public LinkedList<apd> rQL = new LinkedList();
    public String signature;
    public String url;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.url != null) {
                aVar.g(2, this.url);
            }
            if (this.bPS != null) {
                aVar.g(3, this.bPS);
            }
            if (this.rQC != null) {
                aVar.g(4, this.rQC);
            }
            if (this.bJT != null) {
                aVar.g(5, this.bJT);
            }
            if (this.rQE != null) {
                aVar.g(6, this.rQE);
            }
            if (this.signature != null) {
                aVar.g(7, this.signature);
            }
            if (this.rQF != null) {
                aVar.g(8, this.rQF);
            }
            if (this.rQG != null) {
                aVar.b(9, this.rQG);
            }
            aVar.fT(10, this.rQH);
            aVar.d(11, 8, this.rQL);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.url != null) {
                fS += f.a.a.b.b.a.h(2, this.url);
            }
            if (this.bPS != null) {
                fS += f.a.a.b.b.a.h(3, this.bPS);
            }
            if (this.rQC != null) {
                fS += f.a.a.b.b.a.h(4, this.rQC);
            }
            if (this.bJT != null) {
                fS += f.a.a.b.b.a.h(5, this.bJT);
            }
            if (this.rQE != null) {
                fS += f.a.a.b.b.a.h(6, this.rQE);
            }
            if (this.signature != null) {
                fS += f.a.a.b.b.a.h(7, this.signature);
            }
            if (this.rQF != null) {
                fS += f.a.a.b.b.a.h(8, this.rQF);
            }
            if (this.rQG != null) {
                fS += f.a.a.a.a(9, this.rQG);
            }
            return (fS + f.a.a.a.fQ(10, this.rQH)) + f.a.a.a.c(11, 8, this.rQL);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rQL.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            aop aop = (aop) objArr[1];
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
                        fk fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        aop.shX = fkVar;
                    }
                    return 0;
                case 2:
                    aop.url = aVar3.vHC.readString();
                    return 0;
                case 3:
                    aop.bPS = aVar3.vHC.readString();
                    return 0;
                case 4:
                    aop.rQC = aVar3.vHC.readString();
                    return 0;
                case 5:
                    aop.bJT = aVar3.vHC.readString();
                    return 0;
                case 6:
                    aop.rQE = aVar3.vHC.readString();
                    return 0;
                case 7:
                    aop.signature = aVar3.vHC.readString();
                    return 0;
                case 8:
                    aop.rQF = aVar3.vHC.readString();
                    return 0;
                case 9:
                    aop.rQG = aVar3.cJR();
                    return 0;
                case 10:
                    aop.rQH = aVar3.vHC.rY();
                    return 0;
                case 11:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        apd apd = new apd();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = apd.a(aVar4, apd, bhd.a(aVar4))) {
                        }
                        aop.rQL.add(apd);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
