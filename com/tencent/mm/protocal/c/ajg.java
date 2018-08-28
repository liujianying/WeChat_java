package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class ajg extends bhd {
    public String dxc;
    public String iEL;
    public boolean rLZ;
    public String rMa;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.iEL == null) {
                throw new b("Not all required fields were included: appusername");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.av(2, this.rLZ);
            if (this.dxc != null) {
                aVar.g(3, this.dxc);
            }
            if (this.iEL != null) {
                aVar.g(4, this.iEL);
            }
            if (this.rMa == null) {
                return 0;
            }
            aVar.g(5, this.rMa);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.b.b.a.ec(2) + 1;
            if (this.dxc != null) {
                fS += f.a.a.b.b.a.h(3, this.dxc);
            }
            if (this.iEL != null) {
                fS += f.a.a.b.b.a.h(4, this.iEL);
            }
            if (this.rMa != null) {
                fS += f.a.a.b.b.a.h(5, this.rMa);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.iEL != null) {
                return 0;
            }
            throw new b("Not all required fields were included: appusername");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ajg ajg = (ajg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        ajg.shX = fkVar;
                    }
                    return 0;
                case 2:
                    ajg.rLZ = aVar3.cJQ();
                    return 0;
                case 3:
                    ajg.dxc = aVar3.vHC.readString();
                    return 0;
                case 4:
                    ajg.iEL = aVar3.vHC.readString();
                    return 0;
                case 5:
                    ajg.rMa = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
