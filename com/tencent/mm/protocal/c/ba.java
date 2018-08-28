package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class ba extends a {
    public String jPT;
    public String jPc;
    public String jSv;
    public String rbf;
    public String rbg;
    public String rbh;
    public String rbi;
    public String rbj;
    public String rbk;
    public cib rbl;
    public String rbm;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jPc != null) {
                aVar.g(1, this.jPc);
            }
            if (this.rbf != null) {
                aVar.g(2, this.rbf);
            }
            if (this.rbg != null) {
                aVar.g(3, this.rbg);
            }
            if (this.jPT != null) {
                aVar.g(4, this.jPT);
            }
            if (this.jSv != null) {
                aVar.g(5, this.jSv);
            }
            if (this.rbh != null) {
                aVar.g(6, this.rbh);
            }
            if (this.rbi != null) {
                aVar.g(7, this.rbi);
            }
            if (this.rbj != null) {
                aVar.g(8, this.rbj);
            }
            if (this.rbk != null) {
                aVar.g(9, this.rbk);
            }
            if (this.rbl != null) {
                aVar.fV(10, this.rbl.boi());
                this.rbl.a(aVar);
            }
            if (this.rbm == null) {
                return 0;
            }
            aVar.g(11, this.rbm);
            return 0;
        } else if (i == 1) {
            if (this.jPc != null) {
                h = f.a.a.b.b.a.h(1, this.jPc) + 0;
            } else {
                h = 0;
            }
            if (this.rbf != null) {
                h += f.a.a.b.b.a.h(2, this.rbf);
            }
            if (this.rbg != null) {
                h += f.a.a.b.b.a.h(3, this.rbg);
            }
            if (this.jPT != null) {
                h += f.a.a.b.b.a.h(4, this.jPT);
            }
            if (this.jSv != null) {
                h += f.a.a.b.b.a.h(5, this.jSv);
            }
            if (this.rbh != null) {
                h += f.a.a.b.b.a.h(6, this.rbh);
            }
            if (this.rbi != null) {
                h += f.a.a.b.b.a.h(7, this.rbi);
            }
            if (this.rbj != null) {
                h += f.a.a.b.b.a.h(8, this.rbj);
            }
            if (this.rbk != null) {
                h += f.a.a.b.b.a.h(9, this.rbk);
            }
            if (this.rbl != null) {
                h += f.a.a.a.fS(10, this.rbl.boi());
            }
            if (this.rbm != null) {
                h += f.a.a.b.b.a.h(11, this.rbm);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            ba baVar = (ba) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    baVar.jPc = aVar3.vHC.readString();
                    return 0;
                case 2:
                    baVar.rbf = aVar3.vHC.readString();
                    return 0;
                case 3:
                    baVar.rbg = aVar3.vHC.readString();
                    return 0;
                case 4:
                    baVar.jPT = aVar3.vHC.readString();
                    return 0;
                case 5:
                    baVar.jSv = aVar3.vHC.readString();
                    return 0;
                case 6:
                    baVar.rbh = aVar3.vHC.readString();
                    return 0;
                case 7:
                    baVar.rbi = aVar3.vHC.readString();
                    return 0;
                case 8:
                    baVar.rbj = aVar3.vHC.readString();
                    return 0;
                case 9:
                    baVar.rbk = aVar3.vHC.readString();
                    return 0;
                case 10:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        cib cib = new cib();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cib.a(aVar4, cib, a.a(aVar4))) {
                        }
                        baVar.rbl = cib;
                    }
                    return 0;
                case 11:
                    baVar.rbm = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
