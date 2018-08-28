package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class btf extends a {
    public String bWP;
    public String bWQ;
    public int csE;
    public long eiD;
    public int pLn;
    public int pMm;
    public int pMn;
    public int pMo;
    public long sqE;
    public int sqF;
    public long sqG;
    public String text;
    public int type;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bWQ != null) {
                aVar.g(1, this.bWQ);
            }
            aVar.fT(2, this.pMm);
            aVar.fT(3, this.pMn);
            aVar.T(4, this.eiD);
            aVar.fT(5, this.pLn);
            aVar.fT(6, this.type);
            if (this.text != null) {
                aVar.g(7, this.text);
            }
            if (this.bWP != null) {
                aVar.g(8, this.bWP);
            }
            aVar.T(9, this.sqE);
            aVar.fT(10, this.pMo);
            aVar.fT(11, this.sqF);
            aVar.T(12, this.sqG);
            aVar.fT(13, this.csE);
            return 0;
        } else if (i == 1) {
            if (this.bWQ != null) {
                h = f.a.a.b.b.a.h(1, this.bWQ) + 0;
            } else {
                h = 0;
            }
            h = ((((h + f.a.a.a.fQ(2, this.pMm)) + f.a.a.a.fQ(3, this.pMn)) + f.a.a.a.S(4, this.eiD)) + f.a.a.a.fQ(5, this.pLn)) + f.a.a.a.fQ(6, this.type);
            if (this.text != null) {
                h += f.a.a.b.b.a.h(7, this.text);
            }
            if (this.bWP != null) {
                h += f.a.a.b.b.a.h(8, this.bWP);
            }
            return ((((h + f.a.a.a.S(9, this.sqE)) + f.a.a.a.fQ(10, this.pMo)) + f.a.a.a.fQ(11, this.sqF)) + f.a.a.a.S(12, this.sqG)) + f.a.a.a.fQ(13, this.csE);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            btf btf = (btf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    btf.bWQ = aVar3.vHC.readString();
                    return 0;
                case 2:
                    btf.pMm = aVar3.vHC.rY();
                    return 0;
                case 3:
                    btf.pMn = aVar3.vHC.rY();
                    return 0;
                case 4:
                    btf.eiD = aVar3.vHC.rZ();
                    return 0;
                case 5:
                    btf.pLn = aVar3.vHC.rY();
                    return 0;
                case 6:
                    btf.type = aVar3.vHC.rY();
                    return 0;
                case 7:
                    btf.text = aVar3.vHC.readString();
                    return 0;
                case 8:
                    btf.bWP = aVar3.vHC.readString();
                    return 0;
                case 9:
                    btf.sqE = aVar3.vHC.rZ();
                    return 0;
                case 10:
                    btf.pMo = aVar3.vHC.rY();
                    return 0;
                case 11:
                    btf.sqF = aVar3.vHC.rY();
                    return 0;
                case 12:
                    btf.sqG = aVar3.vHC.rZ();
                    return 0;
                case 13:
                    btf.csE = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
