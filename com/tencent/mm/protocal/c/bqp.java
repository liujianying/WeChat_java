package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bqp extends a {
    public int rth;
    public int rxG;
    public int soA;
    public int soB;
    public int soC;
    public int soD;
    public LinkedList<Integer> soE = new LinkedList();
    public int soF;
    public int soG;
    public LinkedList<Integer> soH = new LinkedList();
    public int soI;
    public int soJ;
    public int soz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rxG);
            aVar.fT(2, this.soz);
            aVar.fT(3, this.rth);
            aVar.fT(4, this.soA);
            aVar.fT(5, this.soB);
            aVar.fT(6, this.soC);
            aVar.fT(7, this.soD);
            aVar.d(8, 2, this.soE);
            aVar.fT(9, this.soF);
            aVar.fT(10, this.soG);
            aVar.d(11, 2, this.soH);
            aVar.fT(12, this.soI);
            aVar.fT(13, this.soJ);
            return 0;
        } else if (i == 1) {
            return ((((((((((((f.a.a.a.fQ(1, this.rxG) + 0) + f.a.a.a.fQ(2, this.soz)) + f.a.a.a.fQ(3, this.rth)) + f.a.a.a.fQ(4, this.soA)) + f.a.a.a.fQ(5, this.soB)) + f.a.a.a.fQ(6, this.soC)) + f.a.a.a.fQ(7, this.soD)) + f.a.a.a.c(8, 2, this.soE)) + f.a.a.a.fQ(9, this.soF)) + f.a.a.a.fQ(10, this.soG)) + f.a.a.a.c(11, 2, this.soH)) + f.a.a.a.fQ(12, this.soI)) + f.a.a.a.fQ(13, this.soJ);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.soE.clear();
                this.soH.clear();
                f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJS();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
                bqp bqp = (bqp) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bqp.rxG = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        bqp.soz = aVar3.vHC.rY();
                        return 0;
                    case 3:
                        bqp.rth = aVar3.vHC.rY();
                        return 0;
                    case 4:
                        bqp.soA = aVar3.vHC.rY();
                        return 0;
                    case 5:
                        bqp.soB = aVar3.vHC.rY();
                        return 0;
                    case 6:
                        bqp.soC = aVar3.vHC.rY();
                        return 0;
                    case 7:
                        bqp.soD = aVar3.vHC.rY();
                        return 0;
                    case 8:
                        bqp.soE.add(Integer.valueOf(aVar3.vHC.rY()));
                        return 0;
                    case 9:
                        bqp.soF = aVar3.vHC.rY();
                        return 0;
                    case 10:
                        bqp.soG = aVar3.vHC.rY();
                        return 0;
                    case 11:
                        bqp.soH.add(Integer.valueOf(aVar3.vHC.rY()));
                        return 0;
                    case 12:
                        bqp.soI = aVar3.vHC.rY();
                        return 0;
                    case 13:
                        bqp.soJ = aVar3.vHC.rY();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
