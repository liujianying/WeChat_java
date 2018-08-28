package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class b extends a {
    public e jOV;
    public String jOW;
    public String jOX;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jOW == null) {
                throw new f.a.a.b("Not all required fields were included: AdURL");
            }
            if (this.jOV != null) {
                aVar.fV(1, this.jOV.boi());
                this.jOV.a(aVar);
            }
            if (this.jOW != null) {
                aVar.g(2, this.jOW);
            }
            if (this.jOX == null) {
                return 0;
            }
            aVar.g(3, this.jOX);
            return 0;
        } else if (i == 1) {
            if (this.jOV != null) {
                fS = f.a.a.a.fS(1, this.jOV.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.jOW != null) {
                fS += f.a.a.b.b.a.h(2, this.jOW);
            }
            if (this.jOX != null) {
                fS += f.a.a.b.b.a.h(3, this.jOX);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.jOW != null) {
                return 0;
            }
            throw new f.a.a.b("Not all required fields were included: AdURL");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        e eVar = new e();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        bVar.jOV = eVar;
                    }
                    return 0;
                case 2:
                    bVar.jOW = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bVar.jOX = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
