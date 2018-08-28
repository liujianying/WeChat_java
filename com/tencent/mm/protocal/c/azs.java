package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class azs extends bhp {
    public int bMH;
    public String bMI;
    public int kYc;
    public String pru;
    public ccv scl;
    public ccs scm;
    public ccp scn;
    public cct sco;
    public boolean scp;
    public LinkedList<String> scq = new LinkedList();
    public ccr scr;

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
            aVar.fT(2, this.bMH);
            if (this.bMI != null) {
                aVar.g(3, this.bMI);
            }
            if (this.scl != null) {
                aVar.fV(4, this.scl.boi());
                this.scl.a(aVar);
            }
            if (this.scm != null) {
                aVar.fV(5, this.scm.boi());
                this.scm.a(aVar);
            }
            if (this.scn != null) {
                aVar.fV(6, this.scn.boi());
                this.scn.a(aVar);
            }
            if (this.sco != null) {
                aVar.fV(7, this.sco.boi());
                this.sco.a(aVar);
            }
            aVar.fT(8, this.kYc);
            aVar.av(9, this.scp);
            if (this.pru != null) {
                aVar.g(10, this.pru);
            }
            aVar.d(11, 1, this.scq);
            if (this.scr == null) {
                return 0;
            }
            aVar.fV(12, this.scr.boi());
            this.scr.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.bMH);
            if (this.bMI != null) {
                fS += f.a.a.b.b.a.h(3, this.bMI);
            }
            if (this.scl != null) {
                fS += f.a.a.a.fS(4, this.scl.boi());
            }
            if (this.scm != null) {
                fS += f.a.a.a.fS(5, this.scm.boi());
            }
            if (this.scn != null) {
                fS += f.a.a.a.fS(6, this.scn.boi());
            }
            if (this.sco != null) {
                fS += f.a.a.a.fS(7, this.sco.boi());
            }
            fS = (fS + f.a.a.a.fQ(8, this.kYc)) + (f.a.a.b.b.a.ec(9) + 1);
            if (this.pru != null) {
                fS += f.a.a.b.b.a.h(10, this.pru);
            }
            fS += f.a.a.a.c(11, 1, this.scq);
            if (this.scr != null) {
                fS += f.a.a.a.fS(12, this.scr.boi());
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.scq.clear();
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
            azs azs = (azs) objArr[1];
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
                        azs.six = flVar;
                    }
                    return 0;
                case 2:
                    azs.bMH = aVar3.vHC.rY();
                    return 0;
                case 3:
                    azs.bMI = aVar3.vHC.readString();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ccv ccv = new ccv();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccv.a(aVar4, ccv, bhp.a(aVar4))) {
                        }
                        azs.scl = ccv;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ccs ccs = new ccs();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccs.a(aVar4, ccs, bhp.a(aVar4))) {
                        }
                        azs.scm = ccs;
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ccp ccp = new ccp();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccp.a(aVar4, ccp, bhp.a(aVar4))) {
                        }
                        azs.scn = ccp;
                    }
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cct cct = new cct();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cct.a(aVar4, cct, bhp.a(aVar4))) {
                        }
                        azs.sco = cct;
                    }
                    return 0;
                case 8:
                    azs.kYc = aVar3.vHC.rY();
                    return 0;
                case 9:
                    azs.scp = aVar3.cJQ();
                    return 0;
                case 10:
                    azs.pru = aVar3.vHC.readString();
                    return 0;
                case 11:
                    azs.scq.add(aVar3.vHC.readString());
                    return 0;
                case 12:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ccr ccr = new ccr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccr.a(aVar4, ccr, bhp.a(aVar4))) {
                        }
                        azs.scr = ccr;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
