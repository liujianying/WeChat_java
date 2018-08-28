package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class bua extends bhp {
    public int bMH;
    public String bMI;
    public String srs;
    public String srt;
    public bnj sru;
    public int version;

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
            aVar.fT(2, this.bMH);
            if (this.bMI != null) {
                aVar.g(3, this.bMI);
            }
            if (this.srs != null) {
                aVar.g(4, this.srs);
            }
            if (this.srt != null) {
                aVar.g(5, this.srt);
            }
            if (this.sru != null) {
                aVar.fV(6, this.sru.boi());
                this.sru.a(aVar);
            }
            aVar.fT(7, this.version);
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
            if (this.srs != null) {
                fS += f.a.a.b.b.a.h(4, this.srs);
            }
            if (this.srt != null) {
                fS += f.a.a.b.b.a.h(5, this.srt);
            }
            if (this.sru != null) {
                fS += f.a.a.a.fS(6, this.sru.boi());
            }
            return fS + f.a.a.a.fQ(7, this.version);
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
            bua bua = (bua) objArr[1];
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
                        bua.six = flVar;
                    }
                    return 0;
                case 2:
                    bua.bMH = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bua.bMI = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bua.srs = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bua.srt = aVar3.vHC.readString();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bnj bnj = new bnj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bnj.a(aVar4, bnj, bhp.a(aVar4))) {
                        }
                        bua.sru = bnj;
                    }
                    return 0;
                case 7:
                    bua.version = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
