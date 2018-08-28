package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class c extends a {
    public int hcE;
    public e jOV;
    public b jOY;
    public String jOZ;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.hcE);
            if (this.jOV != null) {
                aVar.fV(2, this.jOV.boi());
                this.jOV.a(aVar);
            }
            if (this.jOY != null) {
                aVar.fV(3, this.jOY.boi());
                this.jOY.a(aVar);
            }
            if (this.jOZ != null) {
                aVar.g(4, this.jOZ);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.hcE) + 0;
            if (this.jOV != null) {
                fQ += f.a.a.a.fS(2, this.jOV.boi());
            }
            if (this.jOY != null) {
                fQ += f.a.a.a.fS(3, this.jOY.boi());
            }
            if (this.jOZ != null) {
                return fQ + f.a.a.b.b.a.h(4, this.jOZ);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cVar.hcE = aVar3.vHC.rY();
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        e eVar = new e();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        cVar.jOV = eVar;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        b bVar = new b();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bVar.a(aVar4, bVar, a.a(aVar4))) {
                        }
                        cVar.jOY = bVar;
                    }
                    return 0;
                case 4:
                    cVar.jOZ = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
