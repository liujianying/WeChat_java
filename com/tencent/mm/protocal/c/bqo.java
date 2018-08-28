package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class bqo extends a {
    public int som;
    public int son;
    public int soo;
    public byx sop;
    public int soq;
    public int sor;
    public int sos;
    public int sot;
    public LinkedList<Integer> sou = new LinkedList();
    public int sov;
    public LinkedList<Integer> sow = new LinkedList();
    public int sox;
    public LinkedList<Integer> soy = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fQ;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.sop == null) {
                throw new b("Not all required fields were included: Addr");
            }
            aVar.fT(1, this.som);
            aVar.fT(2, this.son);
            aVar.fT(3, this.soo);
            if (this.sop != null) {
                aVar.fV(4, this.sop.boi());
                this.sop.a(aVar);
            }
            aVar.fT(5, this.soq);
            aVar.fT(6, this.sor);
            aVar.fT(7, this.sos);
            aVar.fT(8, this.sot);
            aVar.c(9, this.sou);
            aVar.fT(10, this.sov);
            aVar.c(11, this.sow);
            aVar.fT(12, this.sox);
            aVar.c(13, this.soy);
            return 0;
        } else if (i == 1) {
            fQ = ((f.a.a.a.fQ(1, this.som) + 0) + f.a.a.a.fQ(2, this.son)) + f.a.a.a.fQ(3, this.soo);
            if (this.sop != null) {
                fQ += f.a.a.a.fS(4, this.sop.boi());
            }
            return ((((((((fQ + f.a.a.a.fQ(5, this.soq)) + f.a.a.a.fQ(6, this.sor)) + f.a.a.a.fQ(7, this.sos)) + f.a.a.a.fQ(8, this.sot)) + f.a.a.a.b(9, this.sou)) + f.a.a.a.fQ(10, this.sov)) + f.a.a.a.b(11, this.sow)) + f.a.a.a.fQ(12, this.sox)) + f.a.a.a.b(13, this.soy);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.sou.clear();
            this.sow.clear();
            this.soy.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.sop != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Addr");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bqo bqo = (bqo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bqo.som = aVar3.vHC.rY();
                    return 0;
                case 2:
                    bqo.son = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bqo.soo = aVar3.vHC.rY();
                    return 0;
                case 4:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        byx byx = new byx();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = byx.a(aVar4, byx, a.a(aVar4))) {
                        }
                        bqo.sop = byx;
                    }
                    return 0;
                case 5:
                    bqo.soq = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bqo.sor = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bqo.sos = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bqo.sot = aVar3.vHC.rY();
                    return 0;
                case 9:
                    bqo.sou = new f.a.a.a.a(aVar3.cJR().lR, unknownTagHandler).cJO();
                    return 0;
                case 10:
                    bqo.sov = aVar3.vHC.rY();
                    return 0;
                case 11:
                    bqo.sow = new f.a.a.a.a(aVar3.cJR().lR, unknownTagHandler).cJO();
                    return 0;
                case 12:
                    bqo.sox = aVar3.vHC.rY();
                    return 0;
                case 13:
                    bqo.soy = new f.a.a.a.a(aVar3.cJR().lR, unknownTagHandler).cJO();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
