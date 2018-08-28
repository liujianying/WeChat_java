package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class hk extends bhd {
    public String mac;
    public String rie;
    public String rif;
    public long rig;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.rie != null) {
                aVar.g(2, this.rie);
            }
            if (this.rif != null) {
                aVar.g(3, this.rif);
            }
            if (this.mac != null) {
                aVar.g(4, this.mac);
            }
            aVar.T(5, this.rig);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rie != null) {
                fS += f.a.a.b.b.a.h(2, this.rie);
            }
            if (this.rif != null) {
                fS += f.a.a.b.b.a.h(3, this.rif);
            }
            if (this.mac != null) {
                fS += f.a.a.b.b.a.h(4, this.mac);
            }
            return fS + f.a.a.a.S(5, this.rig);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            hk hkVar = (hk) objArr[1];
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
                        hkVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    hkVar.rie = aVar3.vHC.readString();
                    return 0;
                case 3:
                    hkVar.rif = aVar3.vHC.readString();
                    return 0;
                case 4:
                    hkVar.mac = aVar3.vHC.readString();
                    return 0;
                case 5:
                    hkVar.rig = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
