package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class ia extends a {
    public String riK;
    public int riU;
    public int riV;
    public int riW;
    public int riX;
    public long riY;
    public long riZ;
    public int rja;
    public boolean rjb;
    public int rjc;
    public boolean rjd;
    public fh rje;
    public boolean rjf;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.riK == null) {
                throw new b("Not all required fields were included: brand_user_name");
            }
            if (this.riK != null) {
                aVar.g(1, this.riK);
            }
            aVar.fT(2, this.riU);
            aVar.fT(3, this.riV);
            aVar.fT(4, this.riW);
            aVar.fT(5, this.riX);
            aVar.T(6, this.riY);
            aVar.T(7, this.riZ);
            aVar.fT(8, this.rja);
            aVar.av(9, this.rjb);
            aVar.fT(10, this.rjc);
            aVar.av(11, this.rjd);
            if (this.rje != null) {
                aVar.fV(12, this.rje.boi());
                this.rje.a(aVar);
            }
            aVar.av(13, this.rjf);
            return 0;
        } else if (i == 1) {
            if (this.riK != null) {
                h = f.a.a.b.b.a.h(1, this.riK) + 0;
            } else {
                h = 0;
            }
            h = (((((((((h + f.a.a.a.fQ(2, this.riU)) + f.a.a.a.fQ(3, this.riV)) + f.a.a.a.fQ(4, this.riW)) + f.a.a.a.fQ(5, this.riX)) + f.a.a.a.S(6, this.riY)) + f.a.a.a.S(7, this.riZ)) + f.a.a.a.fQ(8, this.rja)) + (f.a.a.b.b.a.ec(9) + 1)) + f.a.a.a.fQ(10, this.rjc)) + (f.a.a.b.b.a.ec(11) + 1);
            if (this.rje != null) {
                h += f.a.a.a.fS(12, this.rje.boi());
            }
            return h + (f.a.a.b.b.a.ec(13) + 1);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.riK != null) {
                return 0;
            }
            throw new b("Not all required fields were included: brand_user_name");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ia iaVar = (ia) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    iaVar.riK = aVar3.vHC.readString();
                    return 0;
                case 2:
                    iaVar.riU = aVar3.vHC.rY();
                    return 0;
                case 3:
                    iaVar.riV = aVar3.vHC.rY();
                    return 0;
                case 4:
                    iaVar.riW = aVar3.vHC.rY();
                    return 0;
                case 5:
                    iaVar.riX = aVar3.vHC.rY();
                    return 0;
                case 6:
                    iaVar.riY = aVar3.vHC.rZ();
                    return 0;
                case 7:
                    iaVar.riZ = aVar3.vHC.rZ();
                    return 0;
                case 8:
                    iaVar.rja = aVar3.vHC.rY();
                    return 0;
                case 9:
                    iaVar.rjb = aVar3.cJQ();
                    return 0;
                case 10:
                    iaVar.rjc = aVar3.vHC.rY();
                    return 0;
                case 11:
                    iaVar.rjd = aVar3.cJQ();
                    return 0;
                case 12:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fh fhVar = new fh();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fhVar.a(aVar4, fhVar, a.a(aVar4))) {
                        }
                        iaVar.rje = fhVar;
                    }
                    return 0;
                case 13:
                    iaVar.rjf = aVar3.cJQ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
