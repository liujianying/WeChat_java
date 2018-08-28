package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class afv extends bhp {
    public String jPK;
    public int qZc;
    public String qZs;
    public String rBM;
    public bhy rIW;
    public int rJI;
    public LinkedList<ays> rJJ = new LinkedList();
    public int rJK;
    public String rJf;
    public int rJg;
    public String rlo;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rIW == null) {
                throw new b("Not all required fields were included: Buff");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                aVar.fT(2, this.rJI);
                aVar.d(3, 8, this.rJJ);
                aVar.fT(4, this.qZc);
                aVar.fT(5, this.rJK);
                if (this.rIW != null) {
                    aVar.fV(6, this.rIW.boi());
                    this.rIW.a(aVar);
                }
                if (this.jPK != null) {
                    aVar.g(7, this.jPK);
                }
                if (this.rJf != null) {
                    aVar.g(8, this.rJf);
                }
                if (this.rBM != null) {
                    aVar.g(9, this.rBM);
                }
                if (this.qZs != null) {
                    aVar.g(10, this.qZs);
                }
                aVar.fT(11, this.rJg);
                if (this.rlo == null) {
                    return 0;
                }
                aVar.g(12, this.rlo);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (((fS + f.a.a.a.fQ(2, this.rJI)) + f.a.a.a.c(3, 8, this.rJJ)) + f.a.a.a.fQ(4, this.qZc)) + f.a.a.a.fQ(5, this.rJK);
            if (this.rIW != null) {
                fS += f.a.a.a.fS(6, this.rIW.boi());
            }
            if (this.jPK != null) {
                fS += f.a.a.b.b.a.h(7, this.jPK);
            }
            if (this.rJf != null) {
                fS += f.a.a.b.b.a.h(8, this.rJf);
            }
            if (this.rBM != null) {
                fS += f.a.a.b.b.a.h(9, this.rBM);
            }
            if (this.qZs != null) {
                fS += f.a.a.b.b.a.h(10, this.qZs);
            }
            fS += f.a.a.a.fQ(11, this.rJg);
            if (this.rlo != null) {
                fS += f.a.a.b.b.a.h(12, this.rlo);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rJJ.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.rIW != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Buff");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            afv afv = (afv) objArr[1];
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
                        afv.six = flVar;
                    }
                    return 0;
                case 2:
                    afv.rJI = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ays ays = new ays();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ays.a(aVar4, ays, bhp.a(aVar4))) {
                        }
                        afv.rJJ.add(ays);
                    }
                    return 0;
                case 4:
                    afv.qZc = aVar3.vHC.rY();
                    return 0;
                case 5:
                    afv.rJK = aVar3.vHC.rY();
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
                        afv.rIW = bhy;
                    }
                    return 0;
                case 7:
                    afv.jPK = aVar3.vHC.readString();
                    return 0;
                case 8:
                    afv.rJf = aVar3.vHC.readString();
                    return 0;
                case 9:
                    afv.rBM = aVar3.vHC.readString();
                    return 0;
                case 10:
                    afv.qZs = aVar3.vHC.readString();
                    return 0;
                case 11:
                    afv.rJg = aVar3.vHC.rY();
                    return 0;
                case 12:
                    afv.rlo = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
