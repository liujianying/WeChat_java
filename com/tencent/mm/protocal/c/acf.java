package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class acf extends a implements bnu {
    public int rGN;
    public int rGO;
    public int rGP;
    public LinkedList<brg> rGQ = new LinkedList();
    public LinkedList<brg> rGR = new LinkedList();
    public LinkedList<brg> rGS = new LinkedList();
    public int rfn;
    public int rto;
    public int rtp;
    public int rtq;
    public LinkedList<brg> rtr = new LinkedList();
    public LinkedList<brg> rts = new LinkedList();
    public LinkedList<brg> rtt = new LinkedList();
    public int rtu;
    public int rtv;
    public int rtw;
    public amj rtx;

    public final int getRet() {
        return this.rfn;
    }

    protected final int a(int i, Object... objArr) {
        int fQ;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rfn);
            aVar.fT(2, this.rto);
            aVar.fT(3, this.rtp);
            aVar.fT(4, this.rtq);
            aVar.d(5, 8, this.rtr);
            aVar.d(6, 8, this.rts);
            aVar.d(7, 8, this.rtt);
            aVar.fT(8, this.rtu);
            aVar.fT(9, this.rtv);
            aVar.fT(10, this.rtw);
            aVar.fT(11, this.rGN);
            aVar.fT(12, this.rGO);
            aVar.fT(13, this.rGP);
            aVar.d(14, 8, this.rGQ);
            aVar.d(15, 8, this.rGR);
            aVar.d(16, 8, this.rGS);
            if (this.rtx != null) {
                aVar.fV(17, this.rtx.boi());
                this.rtx.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = (((((((((((((((f.a.a.a.fQ(1, this.rfn) + 0) + f.a.a.a.fQ(2, this.rto)) + f.a.a.a.fQ(3, this.rtp)) + f.a.a.a.fQ(4, this.rtq)) + f.a.a.a.c(5, 8, this.rtr)) + f.a.a.a.c(6, 8, this.rts)) + f.a.a.a.c(7, 8, this.rtt)) + f.a.a.a.fQ(8, this.rtu)) + f.a.a.a.fQ(9, this.rtv)) + f.a.a.a.fQ(10, this.rtw)) + f.a.a.a.fQ(11, this.rGN)) + f.a.a.a.fQ(12, this.rGO)) + f.a.a.a.fQ(13, this.rGP)) + f.a.a.a.c(14, 8, this.rGQ)) + f.a.a.a.c(15, 8, this.rGR)) + f.a.a.a.c(16, 8, this.rGS);
            if (this.rtx != null) {
                return fQ + f.a.a.a.fS(17, this.rtx.boi());
            }
            return fQ;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rtr.clear();
            this.rts.clear();
            this.rtt.clear();
            this.rGQ.clear();
            this.rGR.clear();
            this.rGS.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            acf acf = (acf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            brg brg;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    acf.rfn = aVar3.vHC.rY();
                    return 0;
                case 2:
                    acf.rto = aVar3.vHC.rY();
                    return 0;
                case 3:
                    acf.rtp = aVar3.vHC.rY();
                    return 0;
                case 4:
                    acf.rtq = aVar3.vHC.rY();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        brg = new brg();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = brg.a(aVar4, brg, a.a(aVar4))) {
                        }
                        acf.rtr.add(brg);
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        brg = new brg();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = brg.a(aVar4, brg, a.a(aVar4))) {
                        }
                        acf.rts.add(brg);
                    }
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        brg = new brg();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = brg.a(aVar4, brg, a.a(aVar4))) {
                        }
                        acf.rtt.add(brg);
                    }
                    return 0;
                case 8:
                    acf.rtu = aVar3.vHC.rY();
                    return 0;
                case 9:
                    acf.rtv = aVar3.vHC.rY();
                    return 0;
                case 10:
                    acf.rtw = aVar3.vHC.rY();
                    return 0;
                case 11:
                    acf.rGN = aVar3.vHC.rY();
                    return 0;
                case 12:
                    acf.rGO = aVar3.vHC.rY();
                    return 0;
                case 13:
                    acf.rGP = aVar3.vHC.rY();
                    return 0;
                case 14:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        brg = new brg();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = brg.a(aVar4, brg, a.a(aVar4))) {
                        }
                        acf.rGQ.add(brg);
                    }
                    return 0;
                case 15:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        brg = new brg();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = brg.a(aVar4, brg, a.a(aVar4))) {
                        }
                        acf.rGR.add(brg);
                    }
                    return 0;
                case 16:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        brg = new brg();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = brg.a(aVar4, brg, a.a(aVar4))) {
                        }
                        acf.rGS.add(brg);
                    }
                    return 0;
                case 17:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        amj amj = new amj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = amj.a(aVar4, amj, a.a(aVar4))) {
                        }
                        acf.rtx = amj;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
