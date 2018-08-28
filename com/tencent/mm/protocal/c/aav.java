package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class aav extends bhd {
    public String data;
    public int nc;
    public String ruF;

    protected final int a(int i, Object... objArr) {
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ruF == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.data == null) {
                throw new b("Not all required fields were included: data");
            } else {
                if (this.shX != null) {
                    aVar.fV(1, this.shX.boi());
                    this.shX.a(aVar);
                }
                if (this.ruF != null) {
                    aVar.g(2, this.ruF);
                }
                aVar.fT(3, this.nc);
                if (this.data == null) {
                    return 0;
                }
                aVar.g(4, this.data);
                return 0;
            }
        } else if (i == 1) {
            int fS;
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.ruF != null) {
                fS += f.a.a.b.b.a.h(2, this.ruF);
            }
            fS += f.a.a.a.fQ(3, this.nc);
            if (this.data != null) {
                fS += f.a.a.b.b.a.h(4, this.data);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (int a = bhd.a(aVar2); a > 0; a = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, a)) {
                    aVar2.cJS();
                }
            }
            if (this.ruF == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (bArr != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            aav aav = (aav) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        aav.shX = fkVar;
                    }
                    return 0;
                case 2:
                    aav.ruF = aVar3.vHC.readString();
                    return 0;
                case 3:
                    aav.nc = aVar3.vHC.rY();
                    return 0;
                case 4:
                    aav.data = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
