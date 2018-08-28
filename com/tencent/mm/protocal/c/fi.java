package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class fi extends a {
    public String reE;
    public bhy rey;
    public bhy rez;
    public bhy rgk;
    public ccn rgl;
    public cge rgm;
    public int rgn;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rgk != null) {
                aVar.fV(1, this.rgk.boi());
                this.rgk.a(aVar);
            }
            if (this.rgl != null) {
                aVar.fV(2, this.rgl.boi());
                this.rgl.a(aVar);
            }
            if (this.rgm != null) {
                aVar.fV(3, this.rgm.boi());
                this.rgm.a(aVar);
            }
            if (this.rey != null) {
                aVar.fV(4, this.rey.boi());
                this.rey.a(aVar);
            }
            if (this.rez != null) {
                aVar.fV(5, this.rez.boi());
                this.rez.a(aVar);
            }
            aVar.fT(6, this.rgn);
            if (this.reE == null) {
                return 0;
            }
            aVar.g(7, this.reE);
            return 0;
        } else if (i == 1) {
            if (this.rgk != null) {
                fS = f.a.a.a.fS(1, this.rgk.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rgl != null) {
                fS += f.a.a.a.fS(2, this.rgl.boi());
            }
            if (this.rgm != null) {
                fS += f.a.a.a.fS(3, this.rgm.boi());
            }
            if (this.rey != null) {
                fS += f.a.a.a.fS(4, this.rey.boi());
            }
            if (this.rez != null) {
                fS += f.a.a.a.fS(5, this.rez.boi());
            }
            fS += f.a.a.a.fQ(6, this.rgn);
            if (this.reE != null) {
                fS += f.a.a.b.b.a.h(7, this.reE);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            fi fiVar = (fi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            a bhy;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        fiVar.rgk = bhy;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new ccn();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        fiVar.rgl = bhy;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new cge();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        fiVar.rgm = bhy;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhy = new bhy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        fiVar.rey = bhy;
                    }
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
                        fiVar.rez = bhy;
                    }
                    return 0;
                case 6:
                    fiVar.rgn = aVar3.vHC.rY();
                    return 0;
                case 7:
                    fiVar.reE = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
