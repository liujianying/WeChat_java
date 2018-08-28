package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public class if extends a {
    public long bIZ;
    public int cancel;
    public int pos;
    public String rjm;
    public LinkedList<Integer> rjn = new LinkedList();
    public int rjo;
    public int rjp;
    public int rjq;
    public int rjr;
    public int rjs;
    public int rjt;
    public int rju;
    public int rjv;
    public int rjw;
    public int rjx;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rjm != null) {
                aVar.g(1, this.rjm);
            }
            aVar.T(2, this.bIZ);
            aVar.fT(3, this.pos);
            aVar.d(4, 2, this.rjn);
            aVar.fT(5, this.rjo);
            aVar.fT(6, this.rjp);
            aVar.fT(7, this.rjq);
            aVar.fT(8, this.rjr);
            aVar.fT(9, this.rjs);
            aVar.fT(10, this.rjt);
            aVar.fT(11, this.rju);
            aVar.fT(12, this.rjv);
            aVar.fT(13, this.rjw);
            aVar.fT(14, this.cancel);
            aVar.fT(15, this.rjx);
            return 0;
        } else if (i == 1) {
            if (this.rjm != null) {
                h = f.a.a.b.b.a.h(1, this.rjm) + 0;
            } else {
                h = 0;
            }
            return (((((((((((((h + f.a.a.a.S(2, this.bIZ)) + f.a.a.a.fQ(3, this.pos)) + f.a.a.a.c(4, 2, this.rjn)) + f.a.a.a.fQ(5, this.rjo)) + f.a.a.a.fQ(6, this.rjp)) + f.a.a.a.fQ(7, this.rjq)) + f.a.a.a.fQ(8, this.rjr)) + f.a.a.a.fQ(9, this.rjs)) + f.a.a.a.fQ(10, this.rjt)) + f.a.a.a.fQ(11, this.rju)) + f.a.a.a.fQ(12, this.rjv)) + f.a.a.a.fQ(13, this.rjw)) + f.a.a.a.fQ(14, this.cancel)) + f.a.a.a.fQ(15, this.rjx);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.rjn.clear();
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
            if ifVar = (if) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ifVar.rjm = aVar3.vHC.readString();
                    return 0;
                case 2:
                    ifVar.bIZ = aVar3.vHC.rZ();
                    return 0;
                case 3:
                    ifVar.pos = aVar3.vHC.rY();
                    return 0;
                case 4:
                    ifVar.rjn.add(Integer.valueOf(aVar3.vHC.rY()));
                    return 0;
                case 5:
                    ifVar.rjo = aVar3.vHC.rY();
                    return 0;
                case 6:
                    ifVar.rjp = aVar3.vHC.rY();
                    return 0;
                case 7:
                    ifVar.rjq = aVar3.vHC.rY();
                    return 0;
                case 8:
                    ifVar.rjr = aVar3.vHC.rY();
                    return 0;
                case 9:
                    ifVar.rjs = aVar3.vHC.rY();
                    return 0;
                case 10:
                    ifVar.rjt = aVar3.vHC.rY();
                    return 0;
                case 11:
                    ifVar.rju = aVar3.vHC.rY();
                    return 0;
                case 12:
                    ifVar.rjv = aVar3.vHC.rY();
                    return 0;
                case 13:
                    ifVar.rjw = aVar3.vHC.rY();
                    return 0;
                case 14:
                    ifVar.cancel = aVar3.vHC.rY();
                    return 0;
                case 15:
                    ifVar.rjx = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
