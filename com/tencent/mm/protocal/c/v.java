package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class v extends bhp {
    public int hUm = 268513600;
    public String hUn = "请求不成功，请稍候再试";
    public String qYB;
    public long qYC;
    public int qYD;
    public long qYE;
    public int qYF;
    public int qYG;
    public int qYH;
    public int qYI;
    public long qYJ;
    public long qYK;
    public long qYL;
    public int qYM;
    public String qYN;
    public int qYO;
    public long qYP;
    public String qYc;
    public LinkedList<t> qYh = new LinkedList();
    public int qYn;
    public String qYx;
    public int state;
    public String title;
    public int type;

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
            if (this.qYc != null) {
                aVar.g(4, this.qYc);
            }
            if (this.title != null) {
                aVar.g(5, this.title);
            }
            aVar.fT(6, this.type);
            if (this.qYB != null) {
                aVar.g(7, this.qYB);
            }
            aVar.T(8, this.qYC);
            aVar.fT(9, this.qYD);
            aVar.T(10, this.qYE);
            aVar.fT(11, this.qYF);
            aVar.fT(12, this.state);
            aVar.fT(13, this.qYG);
            aVar.fT(14, this.qYH);
            aVar.fT(15, this.qYn);
            aVar.fT(16, this.qYI);
            aVar.T(17, this.qYJ);
            aVar.T(18, this.qYK);
            aVar.T(19, this.qYL);
            aVar.fT(20, this.qYM);
            if (this.qYx != null) {
                aVar.g(21, this.qYx);
            }
            aVar.d(22, 8, this.qYh);
            if (this.qYN != null) {
                aVar.g(23, this.qYN);
            }
            aVar.fT(24, this.qYO);
            aVar.T(25, this.qYP);
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
            if (this.qYc != null) {
                fS += f.a.a.b.b.a.h(4, this.qYc);
            }
            if (this.title != null) {
                fS += f.a.a.b.b.a.h(5, this.title);
            }
            fS += f.a.a.a.fQ(6, this.type);
            if (this.qYB != null) {
                fS += f.a.a.b.b.a.h(7, this.qYB);
            }
            fS = ((((((((((((fS + f.a.a.a.S(8, this.qYC)) + f.a.a.a.fQ(9, this.qYD)) + f.a.a.a.S(10, this.qYE)) + f.a.a.a.fQ(11, this.qYF)) + f.a.a.a.fQ(12, this.state)) + f.a.a.a.fQ(13, this.qYG)) + f.a.a.a.fQ(14, this.qYH)) + f.a.a.a.fQ(15, this.qYn)) + f.a.a.a.fQ(16, this.qYI)) + f.a.a.a.S(17, this.qYJ)) + f.a.a.a.S(18, this.qYK)) + f.a.a.a.S(19, this.qYL)) + f.a.a.a.fQ(20, this.qYM);
            if (this.qYx != null) {
                fS += f.a.a.b.b.a.h(21, this.qYx);
            }
            fS += f.a.a.a.c(22, 8, this.qYh);
            if (this.qYN != null) {
                fS += f.a.a.b.b.a.h(23, this.qYN);
            }
            return (fS + f.a.a.a.fQ(24, this.qYO)) + f.a.a.a.S(25, this.qYP);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.qYh.clear();
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
            v vVar = (v) objArr[1];
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
                        vVar.six = flVar;
                    }
                    return 0;
                case 2:
                    vVar.hUm = aVar3.vHC.rY();
                    return 0;
                case 3:
                    vVar.hUn = aVar3.vHC.readString();
                    return 0;
                case 4:
                    vVar.qYc = aVar3.vHC.readString();
                    return 0;
                case 5:
                    vVar.title = aVar3.vHC.readString();
                    return 0;
                case 6:
                    vVar.type = aVar3.vHC.rY();
                    return 0;
                case 7:
                    vVar.qYB = aVar3.vHC.readString();
                    return 0;
                case 8:
                    vVar.qYC = aVar3.vHC.rZ();
                    return 0;
                case 9:
                    vVar.qYD = aVar3.vHC.rY();
                    return 0;
                case 10:
                    vVar.qYE = aVar3.vHC.rZ();
                    return 0;
                case 11:
                    vVar.qYF = aVar3.vHC.rY();
                    return 0;
                case 12:
                    vVar.state = aVar3.vHC.rY();
                    return 0;
                case 13:
                    vVar.qYG = aVar3.vHC.rY();
                    return 0;
                case 14:
                    vVar.qYH = aVar3.vHC.rY();
                    return 0;
                case 15:
                    vVar.qYn = aVar3.vHC.rY();
                    return 0;
                case 16:
                    vVar.qYI = aVar3.vHC.rY();
                    return 0;
                case 17:
                    vVar.qYJ = aVar3.vHC.rZ();
                    return 0;
                case 18:
                    vVar.qYK = aVar3.vHC.rZ();
                    return 0;
                case 19:
                    vVar.qYL = aVar3.vHC.rZ();
                    return 0;
                case 20:
                    vVar.qYM = aVar3.vHC.rY();
                    return 0;
                case 21:
                    vVar.qYx = aVar3.vHC.readString();
                    return 0;
                case 22:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        t tVar = new t();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tVar.a(aVar4, tVar, bhp.a(aVar4))) {
                        }
                        vVar.qYh.add(tVar);
                    }
                    return 0;
                case 23:
                    vVar.qYN = aVar3.vHC.readString();
                    return 0;
                case 24:
                    vVar.qYO = aVar3.vHC.rY();
                    return 0;
                case 25:
                    vVar.qYP = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
