package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bet extends a {
    public String jPT;
    public String jPc;
    public int jPj;
    public String jSv;
    public int rYO;
    public String rbf;
    public String rbg;
    public String rbh;
    public String rbi;
    public String rbj;
    public String rbk;
    public cib rbl;
    public String rit;
    public String sgg;
    public String sgh;
    public int sgi;
    public LinkedList<bhz> sgj = new LinkedList();
    public String sgk;
    public String sgl;
    public String sgm;
    public String sgn;
    public String sgo;
    public String sgp;
    public String sgq;
    public int sgr;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jPc != null) {
                aVar.g(1, this.jPc);
            }
            if (this.jSv != null) {
                aVar.g(2, this.jSv);
            }
            if (this.rbh != null) {
                aVar.g(3, this.rbh);
            }
            if (this.sgg != null) {
                aVar.g(4, this.sgg);
            }
            if (this.rbg != null) {
                aVar.g(5, this.rbg);
            }
            if (this.rbf != null) {
                aVar.g(6, this.rbf);
            }
            if (this.sgh != null) {
                aVar.g(7, this.sgh);
            }
            aVar.fT(8, this.sgi);
            aVar.d(9, 8, this.sgj);
            if (this.rbi != null) {
                aVar.g(10, this.rbi);
            }
            if (this.sgk != null) {
                aVar.g(11, this.sgk);
            }
            if (this.sgl != null) {
                aVar.g(12, this.sgl);
            }
            aVar.fT(13, this.rYO);
            if (this.rit != null) {
                aVar.g(14, this.rit);
            }
            if (this.jPT != null) {
                aVar.g(15, this.jPT);
            }
            if (this.rbj != null) {
                aVar.g(16, this.rbj);
            }
            if (this.sgm != null) {
                aVar.g(17, this.sgm);
            }
            if (this.sgn != null) {
                aVar.g(18, this.sgn);
            }
            if (this.rbk != null) {
                aVar.g(19, this.rbk);
            }
            if (this.sgo != null) {
                aVar.g(20, this.sgo);
            }
            if (this.sgp != null) {
                aVar.g(21, this.sgp);
            }
            if (this.rbl != null) {
                aVar.fV(22, this.rbl.boi());
                this.rbl.a(aVar);
            }
            if (this.sgq != null) {
                aVar.g(23, this.sgq);
            }
            aVar.fT(24, this.sgr);
            aVar.fT(25, this.jPj);
            return 0;
        } else if (i == 1) {
            if (this.jPc != null) {
                h = f.a.a.b.b.a.h(1, this.jPc) + 0;
            } else {
                h = 0;
            }
            if (this.jSv != null) {
                h += f.a.a.b.b.a.h(2, this.jSv);
            }
            if (this.rbh != null) {
                h += f.a.a.b.b.a.h(3, this.rbh);
            }
            if (this.sgg != null) {
                h += f.a.a.b.b.a.h(4, this.sgg);
            }
            if (this.rbg != null) {
                h += f.a.a.b.b.a.h(5, this.rbg);
            }
            if (this.rbf != null) {
                h += f.a.a.b.b.a.h(6, this.rbf);
            }
            if (this.sgh != null) {
                h += f.a.a.b.b.a.h(7, this.sgh);
            }
            h = (h + f.a.a.a.fQ(8, this.sgi)) + f.a.a.a.c(9, 8, this.sgj);
            if (this.rbi != null) {
                h += f.a.a.b.b.a.h(10, this.rbi);
            }
            if (this.sgk != null) {
                h += f.a.a.b.b.a.h(11, this.sgk);
            }
            if (this.sgl != null) {
                h += f.a.a.b.b.a.h(12, this.sgl);
            }
            h += f.a.a.a.fQ(13, this.rYO);
            if (this.rit != null) {
                h += f.a.a.b.b.a.h(14, this.rit);
            }
            if (this.jPT != null) {
                h += f.a.a.b.b.a.h(15, this.jPT);
            }
            if (this.rbj != null) {
                h += f.a.a.b.b.a.h(16, this.rbj);
            }
            if (this.sgm != null) {
                h += f.a.a.b.b.a.h(17, this.sgm);
            }
            if (this.sgn != null) {
                h += f.a.a.b.b.a.h(18, this.sgn);
            }
            if (this.rbk != null) {
                h += f.a.a.b.b.a.h(19, this.rbk);
            }
            if (this.sgo != null) {
                h += f.a.a.b.b.a.h(20, this.sgo);
            }
            if (this.sgp != null) {
                h += f.a.a.b.b.a.h(21, this.sgp);
            }
            if (this.rbl != null) {
                h += f.a.a.a.fS(22, this.rbl.boi());
            }
            if (this.sgq != null) {
                h += f.a.a.b.b.a.h(23, this.sgq);
            }
            return (h + f.a.a.a.fQ(24, this.sgr)) + f.a.a.a.fQ(25, this.jPj);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.sgj.clear();
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
            bet bet = (bet) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bet.jPc = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bet.jSv = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bet.rbh = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bet.sgg = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bet.rbg = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bet.rbf = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bet.sgh = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bet.sgi = aVar3.vHC.rY();
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        bet.sgj.add(bhz);
                    }
                    return 0;
                case 10:
                    bet.rbi = aVar3.vHC.readString();
                    return 0;
                case 11:
                    bet.sgk = aVar3.vHC.readString();
                    return 0;
                case 12:
                    bet.sgl = aVar3.vHC.readString();
                    return 0;
                case 13:
                    bet.rYO = aVar3.vHC.rY();
                    return 0;
                case 14:
                    bet.rit = aVar3.vHC.readString();
                    return 0;
                case 15:
                    bet.jPT = aVar3.vHC.readString();
                    return 0;
                case 16:
                    bet.rbj = aVar3.vHC.readString();
                    return 0;
                case 17:
                    bet.sgm = aVar3.vHC.readString();
                    return 0;
                case 18:
                    bet.sgn = aVar3.vHC.readString();
                    return 0;
                case 19:
                    bet.rbk = aVar3.vHC.readString();
                    return 0;
                case 20:
                    bet.sgo = aVar3.vHC.readString();
                    return 0;
                case 21:
                    bet.sgp = aVar3.vHC.readString();
                    return 0;
                case 22:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cib cib = new cib();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cib.a(aVar4, cib, a.a(aVar4))) {
                        }
                        bet.rbl = cib;
                    }
                    return 0;
                case 23:
                    bet.sgq = aVar3.vHC.readString();
                    return 0;
                case 24:
                    bet.sgr = aVar3.vHC.rY();
                    return 0;
                case 25:
                    bet.jPj = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
