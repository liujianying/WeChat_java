package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class lx extends bhp {
    public String desc;
    public int hUm;
    public String hUn;
    public String hqp;
    public String hwH;
    public String mwO;
    public String plj;
    public boolean rpZ;
    public String rqa;
    public int rqb;
    public LinkedList<Integer> rqc = new LinkedList();
    public String rqd;
    public int rqe;
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
            aVar.av(4, this.rpZ);
            if (this.mwO != null) {
                aVar.g(5, this.mwO);
            }
            if (this.rqa != null) {
                aVar.g(6, this.rqa);
            }
            if (this.hqp != null) {
                aVar.g(7, this.hqp);
            }
            aVar.fT(8, this.rqb);
            if (this.desc != null) {
                aVar.g(9, this.desc);
            }
            if (this.plj != null) {
                aVar.g(10, this.plj);
            }
            aVar.d(11, 2, this.rqc);
            if (this.rqd != null) {
                aVar.g(12, this.rqd);
            }
            if (this.hwH != null) {
                aVar.g(13, this.hwH);
            }
            aVar.fT(14, this.rqe);
            aVar.fT(15, this.rqf);
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
            fS += f.a.a.b.b.a.ec(4) + 1;
            if (this.mwO != null) {
                fS += f.a.a.b.b.a.h(5, this.mwO);
            }
            if (this.rqa != null) {
                fS += f.a.a.b.b.a.h(6, this.rqa);
            }
            if (this.hqp != null) {
                fS += f.a.a.b.b.a.h(7, this.hqp);
            }
            fS += f.a.a.a.fQ(8, this.rqb);
            if (this.desc != null) {
                fS += f.a.a.b.b.a.h(9, this.desc);
            }
            if (this.plj != null) {
                fS += f.a.a.b.b.a.h(10, this.plj);
            }
            fS += f.a.a.a.c(11, 2, this.rqc);
            if (this.rqd != null) {
                fS += f.a.a.b.b.a.h(12, this.rqd);
            }
            if (this.hwH != null) {
                fS += f.a.a.b.b.a.h(13, this.hwH);
            }
            return (fS + f.a.a.a.fQ(14, this.rqe)) + f.a.a.a.fQ(15, this.rqf);
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
            lx lxVar = (lx) objArr[1];
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
                        lxVar.six = flVar;
                    }
                    return 0;
                case 2:
                    lxVar.hUm = aVar3.vHC.rY();
                    return 0;
                case 3:
                    lxVar.hUn = aVar3.vHC.readString();
                    return 0;
                case 4:
                    lxVar.rpZ = aVar3.cJQ();
                    return 0;
                case 5:
                    lxVar.mwO = aVar3.vHC.readString();
                    return 0;
                case 6:
                    lxVar.rqa = aVar3.vHC.readString();
                    return 0;
                case 7:
                    lxVar.hqp = aVar3.vHC.readString();
                    return 0;
                case 8:
                    lxVar.rqb = aVar3.vHC.rY();
                    return 0;
                case 9:
                    lxVar.desc = aVar3.vHC.readString();
                    return 0;
                case 10:
                    lxVar.plj = aVar3.vHC.readString();
                    return 0;
                case 11:
                    lxVar.rqc.add(Integer.valueOf(aVar3.vHC.rY()));
                    return 0;
                case 12:
                    lxVar.rqd = aVar3.vHC.readString();
                    return 0;
                case 13:
                    lxVar.hwH = aVar3.vHC.readString();
                    return 0;
                case 14:
                    lxVar.rqe = aVar3.vHC.rY();
                    return 0;
                case 15:
                    lxVar.rqf = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
