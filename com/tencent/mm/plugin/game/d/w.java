package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class w extends a {
    public String jOS;
    public e jOV;
    public LinkedList<String> jQg = new LinkedList();
    public String jQh;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jOV != null) {
                aVar.fV(1, this.jOV.boi());
                this.jOV.a(aVar);
            }
            aVar.d(2, 1, this.jQg);
            if (this.jQh != null) {
                aVar.g(3, this.jQh);
            }
            if (this.jOS == null) {
                return 0;
            }
            aVar.g(4, this.jOS);
            return 0;
        } else if (i == 1) {
            if (this.jOV != null) {
                fS = f.a.a.a.fS(1, this.jOV.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.a.c(2, 1, this.jQg);
            if (this.jQh != null) {
                fS += f.a.a.b.b.a.h(3, this.jQh);
            }
            if (this.jOS != null) {
                fS += f.a.a.b.b.a.h(4, this.jOS);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jQg.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
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
            w wVar = (w) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        e eVar = new e();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        wVar.jOV = eVar;
                    }
                    return 0;
                case 2:
                    wVar.jQg.add(aVar3.vHC.readString());
                    return 0;
                case 3:
                    wVar.jQh = aVar3.vHC.readString();
                    return 0;
                case 4:
                    wVar.jOS = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
