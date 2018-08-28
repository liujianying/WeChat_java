package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bde extends bhp {
    public String huW;
    public int hwV;
    public String hwW;
    public String lMV;
    public String lMW;
    public String sfo;
    public String sfp;
    public kl sfq;
    public String sfr;
    public String sfs;
    public btq sft;

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
            aVar.fT(2, this.hwV);
            if (this.hwW != null) {
                aVar.g(3, this.hwW);
            }
            if (this.sfo != null) {
                aVar.g(4, this.sfo);
            }
            if (this.huW != null) {
                aVar.g(5, this.huW);
            }
            if (this.sfp != null) {
                aVar.g(6, this.sfp);
            }
            if (this.sfq != null) {
                aVar.fV(7, this.sfq.boi());
                this.sfq.a(aVar);
            }
            if (this.sfr != null) {
                aVar.g(8, this.sfr);
            }
            if (this.lMW != null) {
                aVar.g(9, this.lMW);
            }
            if (this.lMV != null) {
                aVar.g(10, this.lMV);
            }
            if (this.sfs != null) {
                aVar.g(11, this.sfs);
            }
            if (this.sft == null) {
                return 0;
            }
            aVar.fV(12, this.sft.boi());
            this.sft.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.hwV);
            if (this.hwW != null) {
                fS += f.a.a.b.b.a.h(3, this.hwW);
            }
            if (this.sfo != null) {
                fS += f.a.a.b.b.a.h(4, this.sfo);
            }
            if (this.huW != null) {
                fS += f.a.a.b.b.a.h(5, this.huW);
            }
            if (this.sfp != null) {
                fS += f.a.a.b.b.a.h(6, this.sfp);
            }
            if (this.sfq != null) {
                fS += f.a.a.a.fS(7, this.sfq.boi());
            }
            if (this.sfr != null) {
                fS += f.a.a.b.b.a.h(8, this.sfr);
            }
            if (this.lMW != null) {
                fS += f.a.a.b.b.a.h(9, this.lMW);
            }
            if (this.lMV != null) {
                fS += f.a.a.b.b.a.h(10, this.lMV);
            }
            if (this.sfs != null) {
                fS += f.a.a.b.b.a.h(11, this.sfs);
            }
            if (this.sft != null) {
                fS += f.a.a.a.fS(12, this.sft.boi());
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
            bde bde = (bde) objArr[1];
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
                        bde.six = flVar;
                    }
                    return 0;
                case 2:
                    bde.hwV = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bde.hwW = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bde.sfo = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bde.huW = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bde.sfp = aVar3.vHC.readString();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        kl klVar = new kl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = klVar.a(aVar4, klVar, bhp.a(aVar4))) {
                        }
                        bde.sfq = klVar;
                    }
                    return 0;
                case 8:
                    bde.sfr = aVar3.vHC.readString();
                    return 0;
                case 9:
                    bde.lMW = aVar3.vHC.readString();
                    return 0;
                case 10:
                    bde.lMV = aVar3.vHC.readString();
                    return 0;
                case 11:
                    bde.sfs = aVar3.vHC.readString();
                    return 0;
                case 12:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        btq btq = new btq();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = btq.a(aVar4, btq, bhp.a(aVar4))) {
                        }
                        bde.sft = btq;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
