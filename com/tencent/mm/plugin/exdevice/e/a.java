package com.tencent.mm.plugin.exdevice.e;

import com.tencent.mm.bk.b;
import java.util.LinkedList;

public final class a extends i {
    public String hbP;
    public b iwI;
    public int iwJ;
    public int iwK;
    public int iwL;
    public b iwM;
    public b iwN;
    public String iwO;
    public String iwP;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.ixi != null) {
                aVar.fV(1, this.ixi.boi());
                this.ixi.a(aVar);
            }
            if (this.iwI != null) {
                aVar.b(2, this.iwI);
            }
            aVar.fT(3, this.iwJ);
            aVar.fT(4, this.iwK);
            aVar.fT(5, this.iwL);
            if (this.iwM != null) {
                aVar.b(6, this.iwM);
            }
            if (this.iwN != null) {
                aVar.b(7, this.iwN);
            }
            if (this.iwO != null) {
                aVar.g(10, this.iwO);
            }
            if (this.iwP != null) {
                aVar.g(11, this.iwP);
            }
            if (this.hbP == null) {
                return 0;
            }
            aVar.g(12, this.hbP);
            return 0;
        } else if (i == 1) {
            if (this.ixi != null) {
                fS = f.a.a.a.fS(1, this.ixi.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.iwI != null) {
                fS += f.a.a.a.a(2, this.iwI);
            }
            fS = ((fS + f.a.a.a.fQ(3, this.iwJ)) + f.a.a.a.fQ(4, this.iwK)) + f.a.a.a.fQ(5, this.iwL);
            if (this.iwM != null) {
                fS += f.a.a.a.a(6, this.iwM);
            }
            if (this.iwN != null) {
                fS += f.a.a.a.a(7, this.iwN);
            }
            if (this.iwO != null) {
                fS += f.a.a.b.b.a.h(10, this.iwO);
            }
            if (this.iwP != null) {
                fS += f.a.a.b.b.a.h(11, this.iwP);
            }
            if (this.hbP != null) {
                fS += f.a.a.b.b.a.h(12, this.hbP);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = i.a(aVar2); fS > 0; fS = i.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        d dVar = new d();
                        f.a.a.a.a aVar5 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dVar.a(aVar5, dVar, i.a(aVar5))) {
                        }
                        aVar4.ixi = dVar;
                    }
                    return 0;
                case 2:
                    aVar4.iwI = aVar3.cJR();
                    return 0;
                case 3:
                    aVar4.iwJ = aVar3.vHC.rY();
                    return 0;
                case 4:
                    aVar4.iwK = aVar3.vHC.rY();
                    return 0;
                case 5:
                    aVar4.iwL = aVar3.vHC.rY();
                    return 0;
                case 6:
                    aVar4.iwM = aVar3.cJR();
                    return 0;
                case 7:
                    aVar4.iwN = aVar3.cJR();
                    return 0;
                case 10:
                    aVar4.iwO = aVar3.vHC.readString();
                    return 0;
                case 11:
                    aVar4.iwP = aVar3.vHC.readString();
                    return 0;
                case 12:
                    aVar4.hbP = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
