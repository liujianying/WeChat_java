package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bjp extends a {
    public int eJH;
    public String hbL;
    public String hcS;
    public String jQb;
    public String rEJ;
    public String rqZ;
    public String rra;
    public String ruh;
    public String rui;
    public axr sjA;
    public String sjB;
    public String sjC;
    public int sjj;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.hbL != null) {
                aVar.g(1, this.hbL);
            }
            if (this.hcS != null) {
                aVar.g(2, this.hcS);
            }
            if (this.ruh != null) {
                aVar.g(3, this.ruh);
            }
            if (this.rui != null) {
                aVar.g(4, this.rui);
            }
            aVar.fT(5, this.eJH);
            if (this.rqZ != null) {
                aVar.g(6, this.rqZ);
            }
            if (this.rra != null) {
                aVar.g(7, this.rra);
            }
            if (this.jQb != null) {
                aVar.g(8, this.jQb);
            }
            aVar.fT(9, this.sjj);
            if (this.sjA != null) {
                aVar.fV(10, this.sjA.boi());
                this.sjA.a(aVar);
            }
            if (this.rEJ != null) {
                aVar.g(11, this.rEJ);
            }
            if (this.sjB != null) {
                aVar.g(12, this.sjB);
            }
            if (this.sjC == null) {
                return 0;
            }
            aVar.g(13, this.sjC);
            return 0;
        } else if (i == 1) {
            if (this.hbL != null) {
                h = f.a.a.b.b.a.h(1, this.hbL) + 0;
            } else {
                h = 0;
            }
            if (this.hcS != null) {
                h += f.a.a.b.b.a.h(2, this.hcS);
            }
            if (this.ruh != null) {
                h += f.a.a.b.b.a.h(3, this.ruh);
            }
            if (this.rui != null) {
                h += f.a.a.b.b.a.h(4, this.rui);
            }
            h += f.a.a.a.fQ(5, this.eJH);
            if (this.rqZ != null) {
                h += f.a.a.b.b.a.h(6, this.rqZ);
            }
            if (this.rra != null) {
                h += f.a.a.b.b.a.h(7, this.rra);
            }
            if (this.jQb != null) {
                h += f.a.a.b.b.a.h(8, this.jQb);
            }
            h += f.a.a.a.fQ(9, this.sjj);
            if (this.sjA != null) {
                h += f.a.a.a.fS(10, this.sjA.boi());
            }
            if (this.rEJ != null) {
                h += f.a.a.b.b.a.h(11, this.rEJ);
            }
            if (this.sjB != null) {
                h += f.a.a.b.b.a.h(12, this.sjB);
            }
            if (this.sjC != null) {
                h += f.a.a.b.b.a.h(13, this.sjC);
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
            bjp bjp = (bjp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bjp.hbL = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bjp.hcS = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bjp.ruh = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bjp.rui = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bjp.eJH = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bjp.rqZ = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bjp.rra = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bjp.jQb = aVar3.vHC.readString();
                    return 0;
                case 9:
                    bjp.sjj = aVar3.vHC.rY();
                    return 0;
                case 10:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        axr axr = new axr();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = axr.a(aVar4, axr, a.a(aVar4))) {
                        }
                        bjp.sjA = axr;
                    }
                    return 0;
                case 11:
                    bjp.rEJ = aVar3.vHC.readString();
                    return 0;
                case 12:
                    bjp.sjB = aVar3.vHC.readString();
                    return 0;
                case 13:
                    bjp.sjC = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
