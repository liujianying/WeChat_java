package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class afi extends bhp {
    public int hbF;
    public LinkedList<ars> jTa = new LinkedList();
    public String rwt;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            aVar.fT(2, this.hbF);
            aVar.d(3, 8, this.jTa);
            if (this.rwt == null) {
                return 0;
            }
            aVar.g(4, this.rwt);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = (fS + f.a.a.a.fQ(2, this.hbF)) + f.a.a.a.c(3, 8, this.jTa);
            if (this.rwt != null) {
                fS += f.a.a.b.b.a.h(4, this.rwt);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jTa.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = com.tencent.mm.bk.a.a(aVar2); fS > 0; fS = com.tencent.mm.bk.a.a(aVar2)) {
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
            afi afi = (afi) objArr[1];
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
                        afi.six = flVar;
                    }
                    return 0;
                case 2:
                    afi.hbF = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ars ars = new ars();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ars.a(aVar4, ars, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        afi.jTa.add(ars);
                    }
                    return 0;
                case 4:
                    afi.rwt = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
