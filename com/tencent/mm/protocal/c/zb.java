package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class zb extends bhp {
    public int bQO;
    public String bQP;
    public anm rFh;
    public ann rFi;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            aVar.fT(2, this.bQO);
            if (this.bQP != null) {
                aVar.g(3, this.bQP);
            }
            if (this.rFh != null) {
                aVar.fV(4, this.rFh.boi());
                this.rFh.a(aVar);
            }
            if (this.rFi == null) {
                return 0;
            }
            aVar.fV(5, this.rFi.boi());
            this.rFi.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.bQO);
            if (this.bQP != null) {
                fS += f.a.a.b.b.a.h(3, this.bQP);
            }
            if (this.rFh != null) {
                fS += f.a.a.a.fS(4, this.rFh.boi());
            }
            if (this.rFi != null) {
                fS += f.a.a.a.fS(5, this.rFi.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            zb zbVar = (zb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
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
                        zbVar.six = flVar;
                    }
                    return 0;
                case 2:
                    zbVar.bQO = aVar3.vHC.rY();
                    return 0;
                case 3:
                    zbVar.bQP = aVar3.vHC.readString();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        anm anm = new anm();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = anm.a(aVar4, anm, bhp.a(aVar4))) {
                        }
                        zbVar.rFh = anm;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ann ann = new ann();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ann.a(aVar4, ann, bhp.a(aVar4))) {
                        }
                        zbVar.rFi = ann;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
