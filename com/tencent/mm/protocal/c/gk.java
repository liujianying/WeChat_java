package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class gk extends a {
    public String hbP;
    public int rfn;
    public String rgL;
    public String rgQ;
    public aue rgR;
    public alx rgS;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rfn);
            if (this.rgQ != null) {
                aVar.g(2, this.rgQ);
            }
            if (this.rgR != null) {
                aVar.fV(3, this.rgR.boi());
                this.rgR.a(aVar);
            }
            if (this.rgL != null) {
                aVar.g(4, this.rgL);
            }
            if (this.hbP != null) {
                aVar.g(5, this.hbP);
            }
            if (this.rgS != null) {
                aVar.fV(6, this.rgS.boi());
                this.rgS.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.rfn) + 0;
            if (this.rgQ != null) {
                fQ += f.a.a.b.b.a.h(2, this.rgQ);
            }
            if (this.rgR != null) {
                fQ += f.a.a.a.fS(3, this.rgR.boi());
            }
            if (this.rgL != null) {
                fQ += f.a.a.b.b.a.h(4, this.rgL);
            }
            if (this.hbP != null) {
                fQ += f.a.a.b.b.a.h(5, this.hbP);
            }
            if (this.rgS != null) {
                return fQ + f.a.a.a.fS(6, this.rgS.boi());
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
            gk gkVar = (gk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    gkVar.rfn = aVar3.vHC.rY();
                    return 0;
                case 2:
                    gkVar.rgQ = aVar3.vHC.readString();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aue aue = new aue();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aue.a(aVar4, aue, a.a(aVar4))) {
                        }
                        gkVar.rgR = aue;
                    }
                    return 0;
                case 4:
                    gkVar.rgL = aVar3.vHC.readString();
                    return 0;
                case 5:
                    gkVar.hbP = aVar3.vHC.readString();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        alx alx = new alx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = alx.a(aVar4, alx, a.a(aVar4))) {
                        }
                        gkVar.rgS = alx;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
