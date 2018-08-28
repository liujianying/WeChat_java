package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class wt extends a implements bnu {
    public int rfn;
    public int rlm;
    public pn rnB;
    public bhy rny;

    public final int getRet() {
        return this.rfn;
    }

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rnB == null) {
                throw new b("Not all required fields were included: CmdList");
            } else if (this.rny == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else {
                aVar.fT(1, this.rfn);
                if (this.rnB != null) {
                    aVar.fV(2, this.rnB.boi());
                    this.rnB.a(aVar);
                }
                if (this.rny != null) {
                    aVar.fV(3, this.rny.boi());
                    this.rny.a(aVar);
                }
                aVar.fT(4, this.rlm);
                return 0;
            }
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.rfn) + 0;
            if (this.rnB != null) {
                fQ += f.a.a.a.fS(2, this.rnB.boi());
            }
            if (this.rny != null) {
                fQ += f.a.a.a.fS(3, this.rny.boi());
            }
            return fQ + f.a.a.a.fQ(4, this.rlm);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.rnB == null) {
                throw new b("Not all required fields were included: CmdList");
            } else if (this.rny != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: KeyBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            wt wtVar = (wt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    wtVar.rfn = aVar3.vHC.rY();
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        pn pnVar = new pn();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = pnVar.a(aVar4, pnVar, a.a(aVar4))) {
                        }
                        wtVar.rnB = pnVar;
                    }
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
                        wtVar.rny = bhy;
                    }
                    return 0;
                case 4:
                    wtVar.rlm = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
