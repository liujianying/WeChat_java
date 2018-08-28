package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class akc extends bhp {
    public String bHD;
    public String jOS;
    public String ksB;
    public String rMH;
    public String rMI;
    public String rMJ;
    public String rMK;
    public String rML;
    public String rMM;
    public ccm rMN;
    public String rMO;
    public String rMP;
    public String rMQ;
    public String rMR;
    public String rMS;
    public int rMu;
    public LinkedList<ccg> rMv = new LinkedList();

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
            if (this.rMH != null) {
                aVar.g(2, this.rMH);
            }
            if (this.ksB != null) {
                aVar.g(3, this.ksB);
            }
            if (this.bHD != null) {
                aVar.g(4, this.bHD);
            }
            if (this.jOS != null) {
                aVar.g(5, this.jOS);
            }
            if (this.rMI != null) {
                aVar.g(6, this.rMI);
            }
            if (this.rMJ != null) {
                aVar.g(7, this.rMJ);
            }
            if (this.rMK != null) {
                aVar.g(8, this.rMK);
            }
            if (this.rML != null) {
                aVar.g(9, this.rML);
            }
            if (this.rMM != null) {
                aVar.g(10, this.rMM);
            }
            if (this.rMN != null) {
                aVar.fV(11, this.rMN.boi());
                this.rMN.a(aVar);
            }
            if (this.rMO != null) {
                aVar.g(12, this.rMO);
            }
            if (this.rMP != null) {
                aVar.g(13, this.rMP);
            }
            if (this.rMQ != null) {
                aVar.g(14, this.rMQ);
            }
            if (this.rMR != null) {
                aVar.g(15, this.rMR);
            }
            if (this.rMS != null) {
                aVar.g(16, this.rMS);
            }
            aVar.fT(17, this.rMu);
            aVar.d(18, 8, this.rMv);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rMH != null) {
                fS += f.a.a.b.b.a.h(2, this.rMH);
            }
            if (this.ksB != null) {
                fS += f.a.a.b.b.a.h(3, this.ksB);
            }
            if (this.bHD != null) {
                fS += f.a.a.b.b.a.h(4, this.bHD);
            }
            if (this.jOS != null) {
                fS += f.a.a.b.b.a.h(5, this.jOS);
            }
            if (this.rMI != null) {
                fS += f.a.a.b.b.a.h(6, this.rMI);
            }
            if (this.rMJ != null) {
                fS += f.a.a.b.b.a.h(7, this.rMJ);
            }
            if (this.rMK != null) {
                fS += f.a.a.b.b.a.h(8, this.rMK);
            }
            if (this.rML != null) {
                fS += f.a.a.b.b.a.h(9, this.rML);
            }
            if (this.rMM != null) {
                fS += f.a.a.b.b.a.h(10, this.rMM);
            }
            if (this.rMN != null) {
                fS += f.a.a.a.fS(11, this.rMN.boi());
            }
            if (this.rMO != null) {
                fS += f.a.a.b.b.a.h(12, this.rMO);
            }
            if (this.rMP != null) {
                fS += f.a.a.b.b.a.h(13, this.rMP);
            }
            if (this.rMQ != null) {
                fS += f.a.a.b.b.a.h(14, this.rMQ);
            }
            if (this.rMR != null) {
                fS += f.a.a.b.b.a.h(15, this.rMR);
            }
            if (this.rMS != null) {
                fS += f.a.a.b.b.a.h(16, this.rMS);
            }
            return (fS + f.a.a.a.fQ(17, this.rMu)) + f.a.a.a.c(18, 8, this.rMv);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rMv.clear();
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
            akc akc = (akc) objArr[1];
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
                        akc.six = flVar;
                    }
                    return 0;
                case 2:
                    akc.rMH = aVar3.vHC.readString();
                    return 0;
                case 3:
                    akc.ksB = aVar3.vHC.readString();
                    return 0;
                case 4:
                    akc.bHD = aVar3.vHC.readString();
                    return 0;
                case 5:
                    akc.jOS = aVar3.vHC.readString();
                    return 0;
                case 6:
                    akc.rMI = aVar3.vHC.readString();
                    return 0;
                case 7:
                    akc.rMJ = aVar3.vHC.readString();
                    return 0;
                case 8:
                    akc.rMK = aVar3.vHC.readString();
                    return 0;
                case 9:
                    akc.rML = aVar3.vHC.readString();
                    return 0;
                case 10:
                    akc.rMM = aVar3.vHC.readString();
                    return 0;
                case 11:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ccm ccm = new ccm();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccm.a(aVar4, ccm, bhp.a(aVar4))) {
                        }
                        akc.rMN = ccm;
                    }
                    return 0;
                case 12:
                    akc.rMO = aVar3.vHC.readString();
                    return 0;
                case 13:
                    akc.rMP = aVar3.vHC.readString();
                    return 0;
                case 14:
                    akc.rMQ = aVar3.vHC.readString();
                    return 0;
                case 15:
                    akc.rMR = aVar3.vHC.readString();
                    return 0;
                case 16:
                    akc.rMS = aVar3.vHC.readString();
                    return 0;
                case 17:
                    akc.rMu = aVar3.vHC.rY();
                    return 0;
                case 18:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ccg ccg = new ccg();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccg.a(aVar4, ccg, bhp.a(aVar4))) {
                        }
                        akc.rMv.add(ccg);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
