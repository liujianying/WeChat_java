package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class jz extends a {
    public int hcE;
    public jt rlB;
    public js rlC;
    public long rlD;
    public jy rlE;
    public kb rlF;
    public jx rlG;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.hcE);
            if (this.rlB != null) {
                aVar.fV(2, this.rlB.boi());
                this.rlB.a(aVar);
            }
            if (this.rlC != null) {
                aVar.fV(3, this.rlC.boi());
                this.rlC.a(aVar);
            }
            aVar.T(4, this.rlD);
            if (this.rlE != null) {
                aVar.fV(5, this.rlE.boi());
                this.rlE.a(aVar);
            }
            if (this.rlF != null) {
                aVar.fV(6, this.rlF.boi());
                this.rlF.a(aVar);
            }
            if (this.rlG != null) {
                aVar.fV(7, this.rlG.boi());
                this.rlG.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.hcE) + 0;
            if (this.rlB != null) {
                fQ += f.a.a.a.fS(2, this.rlB.boi());
            }
            if (this.rlC != null) {
                fQ += f.a.a.a.fS(3, this.rlC.boi());
            }
            fQ += f.a.a.a.S(4, this.rlD);
            if (this.rlE != null) {
                fQ += f.a.a.a.fS(5, this.rlE.boi());
            }
            if (this.rlF != null) {
                fQ += f.a.a.a.fS(6, this.rlF.boi());
            }
            if (this.rlG != null) {
                return fQ + f.a.a.a.fS(7, this.rlG.boi());
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            jz jzVar = (jz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    jzVar.hcE = aVar3.vHC.rY();
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        jt jtVar = new jt();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jtVar.a(aVar4, jtVar, a.a(aVar4))) {
                        }
                        jzVar.rlB = jtVar;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        js jsVar = new js();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jsVar.a(aVar4, jsVar, a.a(aVar4))) {
                        }
                        jzVar.rlC = jsVar;
                    }
                    return 0;
                case 4:
                    jzVar.rlD = aVar3.vHC.rZ();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        jy jyVar = new jy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jyVar.a(aVar4, jyVar, a.a(aVar4))) {
                        }
                        jzVar.rlE = jyVar;
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        kb kbVar = new kb();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kbVar.a(aVar4, kbVar, a.a(aVar4))) {
                        }
                        jzVar.rlF = kbVar;
                    }
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        jx jxVar = new jx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jxVar.a(aVar4, jxVar, a.a(aVar4))) {
                        }
                        jzVar.rlG = jxVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
