package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class dl extends a {
    public String jQb;
    public int qZc;
    public int rdH;
    public int rdI;
    public dq rdJ;
    public dk rdK;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jQb == null) {
                throw new b("Not all required fields were included: AppId");
            }
            aVar.fT(1, this.qZc);
            if (this.jQb != null) {
                aVar.g(2, this.jQb);
            }
            aVar.fT(3, this.rdH);
            aVar.fT(4, this.rdI);
            if (this.rdJ != null) {
                aVar.fV(5, this.rdJ.boi());
                this.rdJ.a(aVar);
            }
            if (this.rdK != null) {
                aVar.fV(6, this.rdK.boi());
                this.rdK.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.qZc) + 0;
            if (this.jQb != null) {
                fQ += f.a.a.b.b.a.h(2, this.jQb);
            }
            fQ = (fQ + f.a.a.a.fQ(3, this.rdH)) + f.a.a.a.fQ(4, this.rdI);
            if (this.rdJ != null) {
                fQ += f.a.a.a.fS(5, this.rdJ.boi());
            }
            if (this.rdK != null) {
                return fQ + f.a.a.a.fS(6, this.rdK.boi());
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.jQb != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AppId");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            dl dlVar = (dl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    dlVar.qZc = aVar3.vHC.rY();
                    return 0;
                case 2:
                    dlVar.jQb = aVar3.vHC.readString();
                    return 0;
                case 3:
                    dlVar.rdH = aVar3.vHC.rY();
                    return 0;
                case 4:
                    dlVar.rdI = aVar3.vHC.rY();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        dq dqVar = new dq();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dqVar.a(aVar4, dqVar, a.a(aVar4))) {
                        }
                        dlVar.rdJ = dqVar;
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        dk dkVar = new dk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dkVar.a(aVar4, dkVar, a.a(aVar4))) {
                        }
                        dlVar.rdK = dkVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
