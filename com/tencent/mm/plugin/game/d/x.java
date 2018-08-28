package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class x extends a {
    public String jPA;
    public dl jQi;
    public aa jQj;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jQi != null) {
                aVar.fV(1, this.jQi.boi());
                this.jQi.a(aVar);
            }
            if (this.jQj != null) {
                aVar.fV(2, this.jQj.boi());
                this.jQj.a(aVar);
            }
            if (this.jPA == null) {
                return 0;
            }
            aVar.g(3, this.jPA);
            return 0;
        } else if (i == 1) {
            if (this.jQi != null) {
                fS = f.a.a.a.fS(1, this.jQi.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.jQj != null) {
                fS += f.a.a.a.fS(2, this.jQj.boi());
            }
            if (this.jPA != null) {
                fS += f.a.a.b.b.a.h(3, this.jPA);
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
            x xVar = (x) objArr[1];
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
                        dl dlVar = new dl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dlVar.a(aVar4, dlVar, a.a(aVar4))) {
                        }
                        xVar.jQi = dlVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aa aaVar = new aa();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aaVar.a(aVar4, aaVar, a.a(aVar4))) {
                        }
                        xVar.jQj = aaVar;
                    }
                    return 0;
                case 3:
                    xVar.jPA = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
