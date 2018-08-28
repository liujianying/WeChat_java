package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class df extends a {
    public int hcE;
    public String jQb;
    public String jSA;
    public String jTu;
    public String jTv;
    public int lOH;
    public String rco;
    public int rdn;
    public String rdo;
    public bhy rdp;
    public int rdq;
    public int rdr;
    public String rds;
    public String rdt;
    public String rdu;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jTv != null) {
                aVar.g(1, this.jTv);
            }
            if (this.jQb != null) {
                aVar.g(2, this.jQb);
            }
            aVar.fT(3, this.rdn);
            if (this.jTu != null) {
                aVar.g(4, this.jTu);
            }
            aVar.fT(5, this.hcE);
            if (this.jSA != null) {
                aVar.g(6, this.jSA);
            }
            aVar.fT(7, this.lOH);
            if (this.rdo != null) {
                aVar.g(8, this.rdo);
            }
            if (this.rdp != null) {
                aVar.fV(9, this.rdp.boi());
                this.rdp.a(aVar);
            }
            aVar.fT(10, this.rdq);
            aVar.fT(11, this.rdr);
            if (this.rco != null) {
                aVar.g(12, this.rco);
            }
            if (this.rds != null) {
                aVar.g(13, this.rds);
            }
            if (this.rdt != null) {
                aVar.g(14, this.rdt);
            }
            if (this.rdu == null) {
                return 0;
            }
            aVar.g(15, this.rdu);
            return 0;
        } else if (i == 1) {
            if (this.jTv != null) {
                h = f.a.a.b.b.a.h(1, this.jTv) + 0;
            } else {
                h = 0;
            }
            if (this.jQb != null) {
                h += f.a.a.b.b.a.h(2, this.jQb);
            }
            h += f.a.a.a.fQ(3, this.rdn);
            if (this.jTu != null) {
                h += f.a.a.b.b.a.h(4, this.jTu);
            }
            h += f.a.a.a.fQ(5, this.hcE);
            if (this.jSA != null) {
                h += f.a.a.b.b.a.h(6, this.jSA);
            }
            h += f.a.a.a.fQ(7, this.lOH);
            if (this.rdo != null) {
                h += f.a.a.b.b.a.h(8, this.rdo);
            }
            if (this.rdp != null) {
                h += f.a.a.a.fS(9, this.rdp.boi());
            }
            h = (h + f.a.a.a.fQ(10, this.rdq)) + f.a.a.a.fQ(11, this.rdr);
            if (this.rco != null) {
                h += f.a.a.b.b.a.h(12, this.rco);
            }
            if (this.rds != null) {
                h += f.a.a.b.b.a.h(13, this.rds);
            }
            if (this.rdt != null) {
                h += f.a.a.b.b.a.h(14, this.rdt);
            }
            if (this.rdu != null) {
                h += f.a.a.b.b.a.h(15, this.rdu);
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
            df dfVar = (df) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dfVar.jTv = aVar3.vHC.readString();
                    return 0;
                case 2:
                    dfVar.jQb = aVar3.vHC.readString();
                    return 0;
                case 3:
                    dfVar.rdn = aVar3.vHC.rY();
                    return 0;
                case 4:
                    dfVar.jTu = aVar3.vHC.readString();
                    return 0;
                case 5:
                    dfVar.hcE = aVar3.vHC.rY();
                    return 0;
                case 6:
                    dfVar.jSA = aVar3.vHC.readString();
                    return 0;
                case 7:
                    dfVar.lOH = aVar3.vHC.rY();
                    return 0;
                case 8:
                    dfVar.rdo = aVar3.vHC.readString();
                    return 0;
                case 9:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        dfVar.rdp = bhy;
                    }
                    return 0;
                case 10:
                    dfVar.rdq = aVar3.vHC.rY();
                    return 0;
                case 11:
                    dfVar.rdr = aVar3.vHC.rY();
                    return 0;
                case 12:
                    dfVar.rco = aVar3.vHC.readString();
                    return 0;
                case 13:
                    dfVar.rds = aVar3.vHC.readString();
                    return 0;
                case 14:
                    dfVar.rdt = aVar3.vHC.readString();
                    return 0;
                case 15:
                    dfVar.rdu = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
