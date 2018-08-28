package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class nz extends bhd {
    public String rsb;
    public String rsc;
    public String rsd;
    public String rse;
    public String rsf;
    public long rsg;
    public String rsh;
    public String rsi;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.rsb != null) {
                aVar.g(2, this.rsb);
            }
            if (this.rsc != null) {
                aVar.g(3, this.rsc);
            }
            if (this.rsd != null) {
                aVar.g(4, this.rsd);
            }
            if (this.rse != null) {
                aVar.g(5, this.rse);
            }
            if (this.rsf != null) {
                aVar.g(6, this.rsf);
            }
            aVar.T(7, this.rsg);
            if (this.rsh != null) {
                aVar.g(8, this.rsh);
            }
            if (this.rsi == null) {
                return 0;
            }
            aVar.g(9, this.rsi);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rsb != null) {
                fS += f.a.a.b.b.a.h(2, this.rsb);
            }
            if (this.rsc != null) {
                fS += f.a.a.b.b.a.h(3, this.rsc);
            }
            if (this.rsd != null) {
                fS += f.a.a.b.b.a.h(4, this.rsd);
            }
            if (this.rse != null) {
                fS += f.a.a.b.b.a.h(5, this.rse);
            }
            if (this.rsf != null) {
                fS += f.a.a.b.b.a.h(6, this.rsf);
            }
            fS += f.a.a.a.S(7, this.rsg);
            if (this.rsh != null) {
                fS += f.a.a.b.b.a.h(8, this.rsh);
            }
            if (this.rsi != null) {
                fS += f.a.a.b.b.a.h(9, this.rsi);
            }
            return fS;
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
            nz nzVar = (nz) objArr[1];
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
                        nzVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    nzVar.rsb = aVar3.vHC.readString();
                    return 0;
                case 3:
                    nzVar.rsc = aVar3.vHC.readString();
                    return 0;
                case 4:
                    nzVar.rsd = aVar3.vHC.readString();
                    return 0;
                case 5:
                    nzVar.rse = aVar3.vHC.readString();
                    return 0;
                case 6:
                    nzVar.rsf = aVar3.vHC.readString();
                    return 0;
                case 7:
                    nzVar.rsg = aVar3.vHC.rZ();
                    return 0;
                case 8:
                    nzVar.rsh = aVar3.vHC.readString();
                    return 0;
                case 9:
                    nzVar.rsi = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
