package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class ad extends a {
    public String jOS;
    public e jOV;
    public af jQD;
    public ae jQE;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jOV == null) {
                throw new b("Not all required fields were included: AppItem");
            }
            if (this.jOV != null) {
                aVar.fV(1, this.jOV.boi());
                this.jOV.a(aVar);
            }
            if (this.jQD != null) {
                aVar.fV(2, this.jQD.boi());
                this.jQD.a(aVar);
            }
            if (this.jQE != null) {
                aVar.fV(3, this.jQE.boi());
                this.jQE.a(aVar);
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
            if (this.jQD != null) {
                fS += f.a.a.a.fS(2, this.jQD.boi());
            }
            if (this.jQE != null) {
                fS += f.a.a.a.fS(3, this.jQE.boi());
            }
            if (this.jOS != null) {
                fS += f.a.a.b.b.a.h(4, this.jOS);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.jOV != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AppItem");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ad adVar = (ad) objArr[1];
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
                        e eVar = new e();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        adVar.jOV = eVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        af afVar = new af();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = afVar.a(aVar4, afVar, a.a(aVar4))) {
                        }
                        adVar.jQD = afVar;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ae aeVar = new ae();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aeVar.a(aVar4, aeVar, a.a(aVar4))) {
                        }
                        adVar.jQE = aeVar;
                    }
                    return 0;
                case 4:
                    adVar.jOS = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
