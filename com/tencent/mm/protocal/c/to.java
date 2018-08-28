package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class to extends a {
    public int hcD;
    public String jPG;
    public String rem;
    public String rwQ;
    public String rwR;
    public String rwS;
    public String rwT;
    public int rwU;
    public int rwV;
    public int rwW;
    public LinkedList<bhz> rwX = new LinkedList();
    public String rwY;
    public int rwZ;
    public String rxa;
    public String rxb;
    public String rxc;
    public String rxd;
    public String rxe;
    public int rxf;
    public LinkedList<ayu> rxg = new LinkedList();
    public String rxh;
    public String rxi;
    public String rxj;
    public tn rxk;
    public bap rxl;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rem != null) {
                aVar.g(1, this.rem);
            }
            if (this.jPG != null) {
                aVar.g(2, this.jPG);
            }
            if (this.rwQ != null) {
                aVar.g(3, this.rwQ);
            }
            if (this.rwR != null) {
                aVar.g(4, this.rwR);
            }
            if (this.rwS != null) {
                aVar.g(5, this.rwS);
            }
            if (this.rwT != null) {
                aVar.g(6, this.rwT);
            }
            aVar.fT(7, this.rwU);
            aVar.fT(8, this.rwV);
            aVar.fT(9, this.rwW);
            aVar.d(10, 8, this.rwX);
            if (this.rwY != null) {
                aVar.g(11, this.rwY);
            }
            aVar.fT(12, this.rwZ);
            if (this.rxa != null) {
                aVar.g(13, this.rxa);
            }
            if (this.rxb != null) {
                aVar.g(14, this.rxb);
            }
            if (this.rxc != null) {
                aVar.g(15, this.rxc);
            }
            if (this.rxd != null) {
                aVar.g(16, this.rxd);
            }
            if (this.rxe != null) {
                aVar.g(17, this.rxe);
            }
            aVar.fT(18, this.rxf);
            aVar.d(19, 8, this.rxg);
            aVar.fT(20, this.hcD);
            if (this.rxh != null) {
                aVar.g(21, this.rxh);
            }
            if (this.rxi != null) {
                aVar.g(22, this.rxi);
            }
            if (this.rxj != null) {
                aVar.g(23, this.rxj);
            }
            if (this.rxk != null) {
                aVar.fV(24, this.rxk.boi());
                this.rxk.a(aVar);
            }
            if (this.rxl == null) {
                return 0;
            }
            aVar.fV(25, this.rxl.boi());
            this.rxl.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.rem != null) {
                h = f.a.a.b.b.a.h(1, this.rem) + 0;
            } else {
                h = 0;
            }
            if (this.jPG != null) {
                h += f.a.a.b.b.a.h(2, this.jPG);
            }
            if (this.rwQ != null) {
                h += f.a.a.b.b.a.h(3, this.rwQ);
            }
            if (this.rwR != null) {
                h += f.a.a.b.b.a.h(4, this.rwR);
            }
            if (this.rwS != null) {
                h += f.a.a.b.b.a.h(5, this.rwS);
            }
            if (this.rwT != null) {
                h += f.a.a.b.b.a.h(6, this.rwT);
            }
            h = (((h + f.a.a.a.fQ(7, this.rwU)) + f.a.a.a.fQ(8, this.rwV)) + f.a.a.a.fQ(9, this.rwW)) + f.a.a.a.c(10, 8, this.rwX);
            if (this.rwY != null) {
                h += f.a.a.b.b.a.h(11, this.rwY);
            }
            h += f.a.a.a.fQ(12, this.rwZ);
            if (this.rxa != null) {
                h += f.a.a.b.b.a.h(13, this.rxa);
            }
            if (this.rxb != null) {
                h += f.a.a.b.b.a.h(14, this.rxb);
            }
            if (this.rxc != null) {
                h += f.a.a.b.b.a.h(15, this.rxc);
            }
            if (this.rxd != null) {
                h += f.a.a.b.b.a.h(16, this.rxd);
            }
            if (this.rxe != null) {
                h += f.a.a.b.b.a.h(17, this.rxe);
            }
            h = ((h + f.a.a.a.fQ(18, this.rxf)) + f.a.a.a.c(19, 8, this.rxg)) + f.a.a.a.fQ(20, this.hcD);
            if (this.rxh != null) {
                h += f.a.a.b.b.a.h(21, this.rxh);
            }
            if (this.rxi != null) {
                h += f.a.a.b.b.a.h(22, this.rxi);
            }
            if (this.rxj != null) {
                h += f.a.a.b.b.a.h(23, this.rxj);
            }
            if (this.rxk != null) {
                h += f.a.a.a.fS(24, this.rxk.boi());
            }
            if (this.rxl != null) {
                h += f.a.a.a.fS(25, this.rxl.boi());
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rwX.clear();
            this.rxg.clear();
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
            to toVar = (to) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    toVar.rem = aVar3.vHC.readString();
                    return 0;
                case 2:
                    toVar.jPG = aVar3.vHC.readString();
                    return 0;
                case 3:
                    toVar.rwQ = aVar3.vHC.readString();
                    return 0;
                case 4:
                    toVar.rwR = aVar3.vHC.readString();
                    return 0;
                case 5:
                    toVar.rwS = aVar3.vHC.readString();
                    return 0;
                case 6:
                    toVar.rwT = aVar3.vHC.readString();
                    return 0;
                case 7:
                    toVar.rwU = aVar3.vHC.rY();
                    return 0;
                case 8:
                    toVar.rwV = aVar3.vHC.rY();
                    return 0;
                case 9:
                    toVar.rwW = aVar3.vHC.rY();
                    return 0;
                case 10:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, a.a(aVar4))) {
                        }
                        toVar.rwX.add(bhz);
                    }
                    return 0;
                case 11:
                    toVar.rwY = aVar3.vHC.readString();
                    return 0;
                case 12:
                    toVar.rwZ = aVar3.vHC.rY();
                    return 0;
                case 13:
                    toVar.rxa = aVar3.vHC.readString();
                    return 0;
                case 14:
                    toVar.rxb = aVar3.vHC.readString();
                    return 0;
                case 15:
                    toVar.rxc = aVar3.vHC.readString();
                    return 0;
                case 16:
                    toVar.rxd = aVar3.vHC.readString();
                    return 0;
                case 17:
                    toVar.rxe = aVar3.vHC.readString();
                    return 0;
                case 18:
                    toVar.rxf = aVar3.vHC.rY();
                    return 0;
                case 19:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ayu ayu = new ayu();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ayu.a(aVar4, ayu, a.a(aVar4))) {
                        }
                        toVar.rxg.add(ayu);
                    }
                    return 0;
                case 20:
                    toVar.hcD = aVar3.vHC.rY();
                    return 0;
                case 21:
                    toVar.rxh = aVar3.vHC.readString();
                    return 0;
                case 22:
                    toVar.rxi = aVar3.vHC.readString();
                    return 0;
                case 23:
                    toVar.rxj = aVar3.vHC.readString();
                    return 0;
                case 24:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        tn tnVar = new tn();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tnVar.a(aVar4, tnVar, a.a(aVar4))) {
                        }
                        toVar.rxk = tnVar;
                    }
                    return 0;
                case 25:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bap bap = new bap();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bap.a(aVar4, bap, a.a(aVar4))) {
                        }
                        toVar.rxl = bap;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
