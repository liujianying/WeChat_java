package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class cgw extends a {
    public int riv;
    public LinkedList<li> rvb = new LinkedList();
    public int sBb;
    public String sBc;
    public String sBd;
    public int sBe;
    public dg sBf;

    protected final int a(int i, Object... objArr) {
        int fQ;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.riv);
            aVar.fT(2, this.sBb);
            if (this.sBc != null) {
                aVar.g(3, this.sBc);
            }
            if (this.sBd != null) {
                aVar.g(4, this.sBd);
            }
            aVar.fT(5, this.sBe);
            aVar.d(6, 8, this.rvb);
            if (this.sBf != null) {
                aVar.fV(7, this.sBf.boi());
                this.sBf.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = (f.a.a.a.fQ(1, this.riv) + 0) + f.a.a.a.fQ(2, this.sBb);
            if (this.sBc != null) {
                fQ += f.a.a.b.b.a.h(3, this.sBc);
            }
            if (this.sBd != null) {
                fQ += f.a.a.b.b.a.h(4, this.sBd);
            }
            fQ = (fQ + f.a.a.a.fQ(5, this.sBe)) + f.a.a.a.c(6, 8, this.rvb);
            if (this.sBf != null) {
                return fQ + f.a.a.a.fS(7, this.sBf.boi());
            }
            return fQ;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rvb.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
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
            cgw cgw = (cgw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cgw.riv = aVar3.vHC.rY();
                    return 0;
                case 2:
                    cgw.sBb = aVar3.vHC.rY();
                    return 0;
                case 3:
                    cgw.sBc = aVar3.vHC.readString();
                    return 0;
                case 4:
                    cgw.sBd = aVar3.vHC.readString();
                    return 0;
                case 5:
                    cgw.sBe = aVar3.vHC.rY();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        li liVar = new li();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = liVar.a(aVar4, liVar, a.a(aVar4))) {
                        }
                        cgw.rvb.add(liVar);
                    }
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        dg dgVar = new dg();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dgVar.a(aVar4, dgVar, a.a(aVar4))) {
                        }
                        cgw.sBf = dgVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
