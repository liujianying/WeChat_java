package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bx extends a {
    public de jSx;
    public cn jSy;
    public s jSz;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jSx != null) {
                aVar.fV(1, this.jSx.boi());
                this.jSx.a(aVar);
            }
            if (this.jSy != null) {
                aVar.fV(2, this.jSy.boi());
                this.jSy.a(aVar);
            }
            if (this.jSz == null) {
                return 0;
            }
            aVar.fV(3, this.jSz.boi());
            this.jSz.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.jSx != null) {
                fS = f.a.a.a.fS(1, this.jSx.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.jSy != null) {
                fS += f.a.a.a.fS(2, this.jSy.boi());
            }
            if (this.jSz != null) {
                fS += f.a.a.a.fS(3, this.jSz.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bx bxVar = (bx) objArr[1];
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
                        de deVar = new de();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = deVar.a(aVar4, deVar, a.a(aVar4))) {
                        }
                        bxVar.jSx = deVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cn cnVar = new cn();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cnVar.a(aVar4, cnVar, a.a(aVar4))) {
                        }
                        bxVar.jSy = cnVar;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        s sVar = new s();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = sVar.a(aVar4, sVar, a.a(aVar4))) {
                        }
                        bxVar.jSz = sVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
