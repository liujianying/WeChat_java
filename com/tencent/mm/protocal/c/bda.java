package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bda extends a {
    public String cac;
    public int sff;
    public boolean sfg;
    public String sfh;
    public int sfi;
    public int sfj;
    public LinkedList<bcz> sfk = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.cac != null) {
                aVar.g(1, this.cac);
            }
            aVar.fT(2, this.sff);
            aVar.av(3, this.sfg);
            if (this.sfh != null) {
                aVar.g(4, this.sfh);
            }
            aVar.fT(5, this.sfi);
            aVar.fT(6, this.sfj);
            aVar.d(7, 8, this.sfk);
            return 0;
        } else if (i == 1) {
            if (this.cac != null) {
                h = f.a.a.b.b.a.h(1, this.cac) + 0;
            } else {
                h = 0;
            }
            h = (h + f.a.a.a.fQ(2, this.sff)) + (f.a.a.b.b.a.ec(3) + 1);
            if (this.sfh != null) {
                h += f.a.a.b.b.a.h(4, this.sfh);
            }
            return ((h + f.a.a.a.fQ(5, this.sfi)) + f.a.a.a.fQ(6, this.sfj)) + f.a.a.a.c(7, 8, this.sfk);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.sfk.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bda bda = (bda) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bda.cac = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bda.sff = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bda.sfg = aVar3.cJQ();
                    return 0;
                case 4:
                    bda.sfh = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bda.sfi = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bda.sfj = aVar3.vHC.rY();
                    return 0;
                case 7:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bcz bcz = new bcz();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bcz.a(aVar4, bcz, a.a(aVar4))) {
                        }
                        bda.sfk.add(bcz);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
