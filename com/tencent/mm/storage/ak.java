package com.tencent.mm.storage;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class ak extends a {
    public int taJ;
    public LinkedList<Integer> taK = new LinkedList();
    public LinkedList<Integer> taL = new LinkedList();
    public LinkedList<Integer> taM = new LinkedList();
    public LinkedList<Long> taN = new LinkedList();
    public LinkedList<Long> taO = new LinkedList();
    public LinkedList<Long> taP = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.taJ);
            aVar.d(2, 2, this.taK);
            aVar.d(3, 2, this.taL);
            aVar.d(4, 2, this.taM);
            aVar.d(5, 3, this.taN);
            aVar.d(6, 3, this.taO);
            aVar.d(7, 3, this.taP);
            return 0;
        } else if (i == 1) {
            return ((((((f.a.a.a.fQ(1, this.taJ) + 0) + f.a.a.a.c(2, 2, this.taK)) + f.a.a.a.c(3, 2, this.taL)) + f.a.a.a.c(4, 2, this.taM)) + f.a.a.a.c(5, 3, this.taN)) + f.a.a.a.c(6, 3, this.taO)) + f.a.a.a.c(7, 3, this.taP);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.taK.clear();
                this.taL.clear();
                this.taM.clear();
                this.taN.clear();
                this.taO.clear();
                this.taP.clear();
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
                ak akVar = (ak) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        akVar.taJ = aVar3.vHC.rY();
                        return 0;
                    case 2:
                        akVar.taK.add(Integer.valueOf(aVar3.vHC.rY()));
                        return 0;
                    case 3:
                        akVar.taL.add(Integer.valueOf(aVar3.vHC.rY()));
                        return 0;
                    case 4:
                        akVar.taM.add(Integer.valueOf(aVar3.vHC.rY()));
                        return 0;
                    case 5:
                        akVar.taN.add(Long.valueOf(aVar3.vHC.rZ()));
                        return 0;
                    case 6:
                        akVar.taO.add(Long.valueOf(aVar3.vHC.rZ()));
                        return 0;
                    case 7:
                        akVar.taP.add(Long.valueOf(aVar3.vHC.rZ()));
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
