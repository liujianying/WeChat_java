package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;
import java.util.LinkedList;

public final class q extends a {
    public String lNT;
    public String pdS;
    public String pdT;
    public String pdU;
    public int peI;
    public int peJ;
    public long peK;
    public String peL;
    public String peM;
    public String peN;
    public double peO;
    public double peP;
    public int peQ;
    public String peR;
    public String peS;
    public LinkedList<b> peT = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.peI);
            aVar.fT(2, this.peJ);
            aVar.T(3, this.peK);
            if (this.peL != null) {
                aVar.g(4, this.peL);
            }
            if (this.pdS != null) {
                aVar.g(5, this.pdS);
            }
            if (this.peM != null) {
                aVar.g(6, this.peM);
            }
            if (this.peN != null) {
                aVar.g(7, this.peN);
            }
            if (this.pdT != null) {
                aVar.g(8, this.pdT);
            }
            if (this.pdU != null) {
                aVar.g(9, this.pdU);
            }
            aVar.c(10, this.peO);
            aVar.c(11, this.peP);
            aVar.fT(12, this.peQ);
            if (this.peR != null) {
                aVar.g(13, this.peR);
            }
            if (this.lNT != null) {
                aVar.g(14, this.lNT);
            }
            if (this.peS != null) {
                aVar.g(16, this.peS);
            }
            aVar.d(17, 6, this.peT);
            return 0;
        } else if (i == 1) {
            fQ = ((f.a.a.a.fQ(1, this.peI) + 0) + f.a.a.a.fQ(2, this.peJ)) + f.a.a.a.S(3, this.peK);
            if (this.peL != null) {
                fQ += f.a.a.b.b.a.h(4, this.peL);
            }
            if (this.pdS != null) {
                fQ += f.a.a.b.b.a.h(5, this.pdS);
            }
            if (this.peM != null) {
                fQ += f.a.a.b.b.a.h(6, this.peM);
            }
            if (this.peN != null) {
                fQ += f.a.a.b.b.a.h(7, this.peN);
            }
            if (this.pdT != null) {
                fQ += f.a.a.b.b.a.h(8, this.pdT);
            }
            if (this.pdU != null) {
                fQ += f.a.a.b.b.a.h(9, this.pdU);
            }
            fQ = ((fQ + (f.a.a.b.b.a.ec(10) + 8)) + (f.a.a.b.b.a.ec(11) + 8)) + f.a.a.a.fQ(12, this.peQ);
            if (this.peR != null) {
                fQ += f.a.a.b.b.a.h(13, this.peR);
            }
            if (this.lNT != null) {
                fQ += f.a.a.b.b.a.h(14, this.lNT);
            }
            if (this.peS != null) {
                fQ += f.a.a.b.b.a.h(16, this.peS);
            }
            return fQ + f.a.a.a.c(17, 6, this.peT);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.peT.clear();
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
            q qVar = (q) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qVar.peI = aVar3.vHC.rY();
                    return 0;
                case 2:
                    qVar.peJ = aVar3.vHC.rY();
                    return 0;
                case 3:
                    qVar.peK = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    qVar.peL = aVar3.vHC.readString();
                    return 0;
                case 5:
                    qVar.pdS = aVar3.vHC.readString();
                    return 0;
                case 6:
                    qVar.peM = aVar3.vHC.readString();
                    return 0;
                case 7:
                    qVar.peN = aVar3.vHC.readString();
                    return 0;
                case 8:
                    qVar.pdT = aVar3.vHC.readString();
                    return 0;
                case 9:
                    qVar.pdU = aVar3.vHC.readString();
                    return 0;
                case 10:
                    qVar.peO = aVar3.vHC.readDouble();
                    return 0;
                case 11:
                    qVar.peP = aVar3.vHC.readDouble();
                    return 0;
                case 12:
                    qVar.peQ = aVar3.vHC.rY();
                    return 0;
                case 13:
                    qVar.peR = aVar3.vHC.readString();
                    return 0;
                case 14:
                    qVar.lNT = aVar3.vHC.readString();
                    return 0;
                case 16:
                    qVar.peS = aVar3.vHC.readString();
                    return 0;
                case 17:
                    qVar.peT.add(aVar3.cJR());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
