package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class cj extends a {
    public String jRj;
    public dx rcL;
    public LinkedList<alh> rcM = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rcL == null) {
                throw new b("Not all required fields were included: ArtisAuthor");
            }
            if (this.rcL != null) {
                aVar.fV(1, this.rcL.boi());
                this.rcL.a(aVar);
            }
            aVar.d(2, 8, this.rcM);
            if (this.jRj == null) {
                return 0;
            }
            aVar.g(3, this.jRj);
            return 0;
        } else if (i == 1) {
            if (this.rcL != null) {
                fS = f.a.a.a.fS(1, this.rcL.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.c(2, 8, this.rcM);
            if (this.jRj != null) {
                fS += f.a.a.b.b.a.h(3, this.jRj);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rcM.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rcL != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ArtisAuthor");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cj cjVar = (cj) objArr[1];
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
                        dx dxVar = new dx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dxVar.a(aVar4, dxVar, a.a(aVar4))) {
                        }
                        cjVar.rcL = dxVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        alh alh = new alh();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = alh.a(aVar4, alh, a.a(aVar4))) {
                        }
                        cjVar.rcM.add(alh);
                    }
                    return 0;
                case 3:
                    cjVar.jRj = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
