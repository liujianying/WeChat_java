package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class btw extends bhd {
    public String reT;
    public String ruf;
    public amw srn;
    public int sro;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.ruf != null) {
                aVar.g(2, this.ruf);
            }
            if (this.reT != null) {
                aVar.g(3, this.reT);
            }
            if (this.srn != null) {
                aVar.fV(4, this.srn.boi());
                this.srn.a(aVar);
            }
            aVar.fT(5, this.sro);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.ruf != null) {
                fS += f.a.a.b.b.a.h(2, this.ruf);
            }
            if (this.reT != null) {
                fS += f.a.a.b.b.a.h(3, this.reT);
            }
            if (this.srn != null) {
                fS += f.a.a.a.fS(4, this.srn.boi());
            }
            return fS + f.a.a.a.fQ(5, this.sro);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            btw btw = (btw) objArr[1];
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
                        com.tencent.mm.bk.a fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        btw.shX = fkVar;
                    }
                    return 0;
                case 2:
                    btw.ruf = aVar3.vHC.readString();
                    return 0;
                case 3:
                    btw.reT = aVar3.vHC.readString();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        amw amw = new amw();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = amw.a(aVar4, amw, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        btw.srn = amw;
                    }
                    return 0;
                case 5:
                    btw.sro = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
