package com.tencent.mm.protocal.c;

import d.a.a.a;
import d.a.a.g;
import java.util.LinkedList;

public final class ul extends bhp {
    public int hwV;
    public String hwW;
    public LinkedList<g> rxS = new LinkedList();
    public int rxT;
    public a rxU;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            aVar.fT(2, this.hwV);
            if (this.hwW != null) {
                aVar.g(3, this.hwW);
            }
            aVar.d(4, 8, this.rxS);
            aVar.fT(5, this.rxT);
            if (this.rxU == null) {
                return 0;
            }
            aVar.fV(6, this.rxU.boi());
            this.rxU.a(aVar);
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
            fS = (fS + f.a.a.a.c(4, 8, this.rxS)) + f.a.a.a.fQ(5, this.rxT);
            if (this.rxU != null) {
                fS += f.a.a.a.fS(6, this.rxU.boi());
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rxS.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = com.tencent.mm.bk.a.a(aVar2); fS > 0; fS = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ul ulVar = (ul) objArr[1];
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
                        com.tencent.mm.bk.a flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        ulVar.six = flVar;
                    }
                    return 0;
                case 2:
                    ulVar.hwV = aVar3.vHC.rY();
                    return 0;
                case 3:
                    ulVar.hwW = aVar3.vHC.readString();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        g gVar = new g();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = gVar.a(aVar4, gVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        ulVar.rxS.add(gVar);
                    }
                    return 0;
                case 5:
                    ulVar.rxT = aVar3.vHC.rY();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        a aVar5 = new a();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aVar5.a(aVar4, aVar5, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        ulVar.rxU = aVar5;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
