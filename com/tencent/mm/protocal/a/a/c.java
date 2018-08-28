package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class c extends a {
    public int qXj;
    public int qXk;
    public o qXl;
    public o qXm;
    public int qXn;
    public int qXo;
    public int ret;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.ret);
            aVar.fT(2, this.qXj);
            aVar.fT(3, this.qXk);
            if (this.qXl != null) {
                aVar.fV(4, this.qXl.boi());
                this.qXl.a(aVar);
            }
            if (this.qXm != null) {
                aVar.fV(5, this.qXm.boi());
                this.qXm.a(aVar);
            }
            aVar.fT(6, this.qXn);
            aVar.fT(7, this.qXo);
            return 0;
        } else if (i == 1) {
            fQ = ((f.a.a.a.fQ(1, this.ret) + 0) + f.a.a.a.fQ(2, this.qXj)) + f.a.a.a.fQ(3, this.qXk);
            if (this.qXl != null) {
                fQ += f.a.a.a.fS(4, this.qXl.boi());
            }
            if (this.qXm != null) {
                fQ += f.a.a.a.fS(5, this.qXm.boi());
            }
            return (fQ + f.a.a.a.fQ(6, this.qXn)) + f.a.a.a.fQ(7, this.qXo);
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
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            o oVar;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cVar.ret = aVar3.vHC.rY();
                    return 0;
                case 2:
                    cVar.qXj = aVar3.vHC.rY();
                    return 0;
                case 3:
                    cVar.qXk = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        oVar = new o();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = oVar.a(aVar4, oVar, a.a(aVar4))) {
                        }
                        cVar.qXl = oVar;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        oVar = new o();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = oVar.a(aVar4, oVar, a.a(aVar4))) {
                        }
                        cVar.qXm = oVar;
                    }
                    return 0;
                case 6:
                    cVar.qXn = aVar3.vHC.rY();
                    return 0;
                case 7:
                    cVar.qXo = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
