package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class ayv extends a {
    public int hcD;
    public int hcy;
    public String jPe;
    public int jTt;
    public bhy rdp;
    public String rwQ;
    public String rwk;
    public bhy sbD;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.jTt);
            aVar.fT(2, this.hcD);
            if (this.jPe != null) {
                aVar.g(3, this.jPe);
            }
            aVar.fT(4, this.hcy);
            if (this.rdp != null) {
                aVar.fV(5, this.rdp.boi());
                this.rdp.a(aVar);
            }
            if (this.rwQ != null) {
                aVar.g(6, this.rwQ);
            }
            if (this.sbD != null) {
                aVar.fV(7, this.sbD.boi());
                this.sbD.a(aVar);
            }
            if (this.rwk != null) {
                aVar.g(8, this.rwk);
            }
            return 0;
        } else if (i == 1) {
            fQ = (f.a.a.a.fQ(1, this.jTt) + 0) + f.a.a.a.fQ(2, this.hcD);
            if (this.jPe != null) {
                fQ += f.a.a.b.b.a.h(3, this.jPe);
            }
            fQ += f.a.a.a.fQ(4, this.hcy);
            if (this.rdp != null) {
                fQ += f.a.a.a.fS(5, this.rdp.boi());
            }
            if (this.rwQ != null) {
                fQ += f.a.a.b.b.a.h(6, this.rwQ);
            }
            if (this.sbD != null) {
                fQ += f.a.a.a.fS(7, this.sbD.boi());
            }
            if (this.rwk != null) {
                return fQ + f.a.a.b.b.a.h(8, this.rwk);
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
            ayv ayv = (ayv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            a bhy;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    ayv.jTt = aVar3.vHC.rY();
                    return 0;
                case 2:
                    ayv.hcD = aVar3.vHC.rY();
                    return 0;
                case 3:
                    ayv.jPe = aVar3.vHC.readString();
                    return 0;
                case 4:
                    ayv.hcy = aVar3.vHC.rY();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        ayv.rdp = bhy;
                    }
                    return 0;
                case 6:
                    ayv.rwQ = aVar3.vHC.readString();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        ayv.sbD = bhy;
                    }
                    return 0;
                case 8:
                    ayv.rwk = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
