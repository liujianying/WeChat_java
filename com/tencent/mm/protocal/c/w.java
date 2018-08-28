package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class w extends bhd {
    public int limit;
    public int offset;
    public String qYQ;
    public int qYR;
    public int qYS;
    public String qYT;
    public int type;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.limit);
            aVar.fT(3, this.offset);
            aVar.fT(4, this.type);
            if (this.qYQ != null) {
                aVar.g(5, this.qYQ);
            }
            aVar.fT(6, this.qYR);
            aVar.fT(7, this.qYS);
            if (this.qYT == null) {
                return 0;
            }
            aVar.g(8, this.qYT);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = ((fS + f.a.a.a.fQ(2, this.limit)) + f.a.a.a.fQ(3, this.offset)) + f.a.a.a.fQ(4, this.type);
            if (this.qYQ != null) {
                fS += f.a.a.b.b.a.h(5, this.qYQ);
            }
            fS = (fS + f.a.a.a.fQ(6, this.qYR)) + f.a.a.a.fQ(7, this.qYS);
            if (this.qYT != null) {
                fS += f.a.a.b.b.a.h(8, this.qYT);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            w wVar = (w) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        wVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    wVar.limit = aVar3.vHC.rY();
                    return 0;
                case 3:
                    wVar.offset = aVar3.vHC.rY();
                    return 0;
                case 4:
                    wVar.type = aVar3.vHC.rY();
                    return 0;
                case 5:
                    wVar.qYQ = aVar3.vHC.readString();
                    return 0;
                case 6:
                    wVar.qYR = aVar3.vHC.rY();
                    return 0;
                case 7:
                    wVar.qYS = aVar3.vHC.rY();
                    return 0;
                case 8:
                    wVar.qYT = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
