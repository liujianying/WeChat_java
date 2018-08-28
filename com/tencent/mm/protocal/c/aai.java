package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class aai extends bhp {
    public long rFP;
    public b rFQ;
    public avt rFR;
    public lj rFS;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new f.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            aVar.T(2, this.rFP);
            if (this.rFQ != null) {
                aVar.b(3, this.rFQ);
            }
            if (this.rFR != null) {
                aVar.fV(4, this.rFR.boi());
                this.rFR.a(aVar);
            }
            if (this.rFS == null) {
                return 0;
            }
            aVar.fV(5, this.rFS.boi());
            this.rFS.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.S(2, this.rFP);
            if (this.rFQ != null) {
                fS += f.a.a.a.a(3, this.rFQ);
            }
            if (this.rFR != null) {
                fS += f.a.a.a.fS(4, this.rFR.boi());
            }
            if (this.rFS != null) {
                fS += f.a.a.a.fS(5, this.rFS.boi());
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
            throw new f.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            aai aai = (aai) objArr[1];
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
                        aai.six = flVar;
                    }
                    return 0;
                case 2:
                    aai.rFP = aVar3.vHC.rZ();
                    return 0;
                case 3:
                    aai.rFQ = aVar3.cJR();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        avt avt = new avt();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = avt.a(aVar4, avt, bhp.a(aVar4))) {
                        }
                        aai.rFR = avt;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        lj ljVar = new lj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ljVar.a(aVar4, ljVar, bhp.a(aVar4))) {
                        }
                        aai.rFS = ljVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
