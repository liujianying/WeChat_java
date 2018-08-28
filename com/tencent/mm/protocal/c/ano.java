package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class ano extends a {
    public bhz rQp;
    public bhy rcn;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rcn == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else if (this.rQp == null) {
                throw new b("Not all required fields were included: Username");
            } else {
                if (this.rcn != null) {
                    aVar.fV(1, this.rcn.boi());
                    this.rcn.a(aVar);
                }
                if (this.rQp == null) {
                    return 0;
                }
                aVar.fV(2, this.rQp.boi());
                this.rQp.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.rcn != null) {
                fS = f.a.a.a.fS(1, this.rcn.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rQp != null) {
                fS += f.a.a.a.fS(2, this.rQp.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rcn == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else if (this.rQp != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Username");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ano ano = (ano) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            a bhy;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        ano.rcn = bhy;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        ano.rQp = bhy;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
