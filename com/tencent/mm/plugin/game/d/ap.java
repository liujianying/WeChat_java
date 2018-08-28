package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class ap extends a {
    public e jOV;
    public String jOZ;
    public String jPA;
    public LinkedList<aq> jQX = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jOV == null) {
                throw new b("Not all required fields were included: AppItem");
            }
            if (this.jOV != null) {
                aVar.fV(1, this.jOV.boi());
                this.jOV.a(aVar);
            }
            if (this.jOZ != null) {
                aVar.g(2, this.jOZ);
            }
            aVar.d(3, 8, this.jQX);
            if (this.jPA == null) {
                return 0;
            }
            aVar.g(4, this.jPA);
            return 0;
        } else if (i == 1) {
            if (this.jOV != null) {
                fS = f.a.a.a.fS(1, this.jOV.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.jOZ != null) {
                fS += f.a.a.b.b.a.h(2, this.jOZ);
            }
            fS += f.a.a.a.c(3, 8, this.jQX);
            if (this.jPA != null) {
                fS += f.a.a.b.b.a.h(4, this.jPA);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jQX.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
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
            ap apVar = (ap) objArr[1];
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
                        e eVar = new e();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        apVar.jOV = eVar;
                    }
                    return 0;
                case 2:
                    apVar.jOZ = aVar3.vHC.readString();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aq aqVar = new aq();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aqVar.a(aVar4, aqVar, a.a(aVar4))) {
                        }
                        apVar.jQX.add(aqVar);
                    }
                    return 0;
                case 4:
                    apVar.jPA = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
