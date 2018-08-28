package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bwy extends a {
    public int apptype;
    public String bPS;
    public String dxK;
    public String hyz;
    public int rXP;
    public LinkedList<bwz> stm = new LinkedList();
    public String stn;
    public int sto;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bPS != null) {
                aVar.g(1, this.bPS);
            }
            if (this.dxK != null) {
                aVar.g(2, this.dxK);
            }
            aVar.fT(3, this.apptype);
            aVar.d(4, 8, this.stm);
            aVar.fT(5, this.rXP);
            if (this.stn != null) {
                aVar.g(6, this.stn);
            }
            if (this.hyz != null) {
                aVar.g(7, this.hyz);
            }
            aVar.fT(8, this.sto);
            return 0;
        } else if (i == 1) {
            if (this.bPS != null) {
                h = f.a.a.b.b.a.h(1, this.bPS) + 0;
            } else {
                h = 0;
            }
            if (this.dxK != null) {
                h += f.a.a.b.b.a.h(2, this.dxK);
            }
            h = ((h + f.a.a.a.fQ(3, this.apptype)) + f.a.a.a.c(4, 8, this.stm)) + f.a.a.a.fQ(5, this.rXP);
            if (this.stn != null) {
                h += f.a.a.b.b.a.h(6, this.stn);
            }
            if (this.hyz != null) {
                h += f.a.a.b.b.a.h(7, this.hyz);
            }
            return h + f.a.a.a.fQ(8, this.sto);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.stm.clear();
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
            bwy bwy = (bwy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bwy.bPS = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bwy.dxK = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bwy.apptype = aVar3.vHC.rY();
                    return 0;
                case 4:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bwz bwz = new bwz();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bwz.a(aVar4, bwz, a.a(aVar4))) {
                        }
                        bwy.stm.add(bwz);
                    }
                    return 0;
                case 5:
                    bwy.rXP = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bwy.stn = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bwy.hyz = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bwy.sto = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
