package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bnm extends bhp {
    public String bLe;
    public String dxK;
    public String rZK;
    public eg skj;
    public String slA;
    public String slB;
    public ei slC;
    public LinkedList<ei> slD = new LinkedList();
    public byk slE;
    public boolean slF;
    public String slG;
    public int slw;
    public ef slx;
    public String sly;
    public LinkedList<eh> slz = new LinkedList();
    public String title;

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
            if (this.skj != null) {
                aVar.fV(2, this.skj.boi());
                this.skj.a(aVar);
            }
            aVar.fT(3, this.slw);
            if (this.slx != null) {
                aVar.fV(4, this.slx.boi());
                this.slx.a(aVar);
            }
            if (this.title != null) {
                aVar.g(5, this.title);
            }
            if (this.rZK != null) {
                aVar.g(6, this.rZK);
            }
            if (this.dxK != null) {
                aVar.g(7, this.dxK);
            }
            if (this.sly != null) {
                aVar.g(8, this.sly);
            }
            aVar.d(9, 8, this.slz);
            if (this.slA != null) {
                aVar.g(10, this.slA);
            }
            if (this.slB != null) {
                aVar.g(11, this.slB);
            }
            if (this.slC != null) {
                aVar.fV(12, this.slC.boi());
                this.slC.a(aVar);
            }
            aVar.d(13, 8, this.slD);
            if (this.bLe != null) {
                aVar.g(14, this.bLe);
            }
            if (this.slE != null) {
                aVar.fV(15, this.slE.boi());
                this.slE.a(aVar);
            }
            aVar.av(16, this.slF);
            if (this.slG == null) {
                return 0;
            }
            aVar.g(17, this.slG);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.skj != null) {
                fS += f.a.a.a.fS(2, this.skj.boi());
            }
            fS += f.a.a.a.fQ(3, this.slw);
            if (this.slx != null) {
                fS += f.a.a.a.fS(4, this.slx.boi());
            }
            if (this.title != null) {
                fS += f.a.a.b.b.a.h(5, this.title);
            }
            if (this.rZK != null) {
                fS += f.a.a.b.b.a.h(6, this.rZK);
            }
            if (this.dxK != null) {
                fS += f.a.a.b.b.a.h(7, this.dxK);
            }
            if (this.sly != null) {
                fS += f.a.a.b.b.a.h(8, this.sly);
            }
            fS += f.a.a.a.c(9, 8, this.slz);
            if (this.slA != null) {
                fS += f.a.a.b.b.a.h(10, this.slA);
            }
            if (this.slB != null) {
                fS += f.a.a.b.b.a.h(11, this.slB);
            }
            if (this.slC != null) {
                fS += f.a.a.a.fS(12, this.slC.boi());
            }
            fS += f.a.a.a.c(13, 8, this.slD);
            if (this.bLe != null) {
                fS += f.a.a.b.b.a.h(14, this.bLe);
            }
            if (this.slE != null) {
                fS += f.a.a.a.fS(15, this.slE.boi());
            }
            fS += f.a.a.b.b.a.ec(16) + 1;
            if (this.slG != null) {
                fS += f.a.a.b.b.a.h(17, this.slG);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.slz.clear();
            this.slD.clear();
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
            bnm bnm = (bnm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            ei eiVar;
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
                        bnm.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        eg egVar = new eg();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = egVar.a(aVar4, egVar, bhp.a(aVar4))) {
                        }
                        bnm.skj = egVar;
                    }
                    return 0;
                case 3:
                    bnm.slw = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ef efVar = new ef();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = efVar.a(aVar4, efVar, bhp.a(aVar4))) {
                        }
                        bnm.slx = efVar;
                    }
                    return 0;
                case 5:
                    bnm.title = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bnm.rZK = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bnm.dxK = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bnm.sly = aVar3.vHC.readString();
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        eh ehVar = new eh();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ehVar.a(aVar4, ehVar, bhp.a(aVar4))) {
                        }
                        bnm.slz.add(ehVar);
                    }
                    return 0;
                case 10:
                    bnm.slA = aVar3.vHC.readString();
                    return 0;
                case 11:
                    bnm.slB = aVar3.vHC.readString();
                    return 0;
                case 12:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        eiVar = new ei();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eiVar.a(aVar4, eiVar, bhp.a(aVar4))) {
                        }
                        bnm.slC = eiVar;
                    }
                    return 0;
                case 13:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        eiVar = new ei();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eiVar.a(aVar4, eiVar, bhp.a(aVar4))) {
                        }
                        bnm.slD.add(eiVar);
                    }
                    return 0;
                case 14:
                    bnm.bLe = aVar3.vHC.readString();
                    return 0;
                case 15:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        byk byk = new byk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = byk.a(aVar4, byk, bhp.a(aVar4))) {
                        }
                        bnm.slE = byk;
                    }
                    return 0;
                case 16:
                    bnm.slF = aVar3.cJQ();
                    return 0;
                case 17:
                    bnm.slG = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
