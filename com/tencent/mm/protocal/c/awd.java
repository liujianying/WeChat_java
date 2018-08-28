package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class awd extends a {
    public int otY;
    public pn rZv;
    public int rZw;
    public String reT;
    public int rnx;
    public bhy rny;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rZv == null) {
                throw new b("Not all required fields were included: Oplog");
            } else if (this.rny == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else {
                if (this.rZv != null) {
                    aVar.fV(1, this.rZv.boi());
                    this.rZv.a(aVar);
                }
                aVar.fT(2, this.rnx);
                if (this.rny != null) {
                    aVar.fV(3, this.rny.boi());
                    this.rny.a(aVar);
                }
                aVar.fT(4, this.otY);
                if (this.reT != null) {
                    aVar.g(5, this.reT);
                }
                aVar.fT(6, this.rZw);
                return 0;
            }
        } else if (i == 1) {
            if (this.rZv != null) {
                fS = f.a.a.a.fS(1, this.rZv.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.fQ(2, this.rnx);
            if (this.rny != null) {
                fS += f.a.a.a.fS(3, this.rny.boi());
            }
            fS += f.a.a.a.fQ(4, this.otY);
            if (this.reT != null) {
                fS += f.a.a.b.b.a.h(5, this.reT);
            }
            return fS + f.a.a.a.fQ(6, this.rZw);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rZv == null) {
                throw new b("Not all required fields were included: Oplog");
            } else if (this.rny != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: KeyBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            awd awd = (awd) objArr[1];
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
                        pn pnVar = new pn();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = pnVar.a(aVar4, pnVar, a.a(aVar4))) {
                        }
                        awd.rZv = pnVar;
                    }
                    return 0;
                case 2:
                    awd.rnx = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        awd.rny = bhy;
                    }
                    return 0;
                case 4:
                    awd.otY = aVar3.vHC.rY();
                    return 0;
                case 5:
                    awd.reT = aVar3.vHC.readString();
                    return 0;
                case 6:
                    awd.rZw = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
