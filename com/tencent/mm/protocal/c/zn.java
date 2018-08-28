package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class zn extends bhd {
    public int hFj;
    public String hFk;
    public String hFl;
    public String hFm;
    public String hFn;
    public String huU;
    public String hva;
    public b hxt;
    public int rFt;
    public int time_stamp;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.hva != null) {
                aVar.g(2, this.hva);
            }
            aVar.fT(3, this.hFj);
            if (this.hFk != null) {
                aVar.g(4, this.hFk);
            }
            if (this.hFl != null) {
                aVar.g(5, this.hFl);
            }
            aVar.fT(6, this.time_stamp);
            if (this.hFm != null) {
                aVar.g(7, this.hFm);
            }
            if (this.huU != null) {
                aVar.g(8, this.huU);
            }
            if (this.hFn != null) {
                aVar.g(9, this.hFn);
            }
            if (this.hxt != null) {
                aVar.b(10, this.hxt);
            }
            aVar.fT(11, this.rFt);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.hva != null) {
                fS += f.a.a.b.b.a.h(2, this.hva);
            }
            fS += f.a.a.a.fQ(3, this.hFj);
            if (this.hFk != null) {
                fS += f.a.a.b.b.a.h(4, this.hFk);
            }
            if (this.hFl != null) {
                fS += f.a.a.b.b.a.h(5, this.hFl);
            }
            fS += f.a.a.a.fQ(6, this.time_stamp);
            if (this.hFm != null) {
                fS += f.a.a.b.b.a.h(7, this.hFm);
            }
            if (this.huU != null) {
                fS += f.a.a.b.b.a.h(8, this.huU);
            }
            if (this.hFn != null) {
                fS += f.a.a.b.b.a.h(9, this.hFn);
            }
            if (this.hxt != null) {
                fS += f.a.a.a.a(10, this.hxt);
            }
            return fS + f.a.a.a.fQ(11, this.rFt);
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
            zn znVar = (zn) objArr[1];
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
                        znVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    znVar.hva = aVar3.vHC.readString();
                    return 0;
                case 3:
                    znVar.hFj = aVar3.vHC.rY();
                    return 0;
                case 4:
                    znVar.hFk = aVar3.vHC.readString();
                    return 0;
                case 5:
                    znVar.hFl = aVar3.vHC.readString();
                    return 0;
                case 6:
                    znVar.time_stamp = aVar3.vHC.rY();
                    return 0;
                case 7:
                    znVar.hFm = aVar3.vHC.readString();
                    return 0;
                case 8:
                    znVar.huU = aVar3.vHC.readString();
                    return 0;
                case 9:
                    znVar.hFn = aVar3.vHC.readString();
                    return 0;
                case 10:
                    znVar.hxt = aVar3.cJR();
                    return 0;
                case 11:
                    znVar.rFt = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
