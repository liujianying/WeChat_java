package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class cfl extends a {
    public String iwP;
    public int otY;
    public String rEx;
    public int rUH;
    public aqs rUI;
    public long rll;
    public LinkedList<String> szV = new LinkedList();
    public LinkedList<ps> szW = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 1, this.szV);
            aVar.fT(2, this.rUH);
            if (this.iwP != null) {
                aVar.g(3, this.iwP);
            }
            aVar.fT(4, this.otY);
            aVar.T(5, this.rll);
            if (this.rEx != null) {
                aVar.g(6, this.rEx);
            }
            if (this.rUI != null) {
                aVar.fV(7, this.rUI.boi());
                this.rUI.a(aVar);
            }
            aVar.d(8, 8, this.szW);
            return 0;
        } else if (i == 1) {
            c = (f.a.a.a.c(1, 1, this.szV) + 0) + f.a.a.a.fQ(2, this.rUH);
            if (this.iwP != null) {
                c += f.a.a.b.b.a.h(3, this.iwP);
            }
            c = (c + f.a.a.a.fQ(4, this.otY)) + f.a.a.a.S(5, this.rll);
            if (this.rEx != null) {
                c += f.a.a.b.b.a.h(6, this.rEx);
            }
            if (this.rUI != null) {
                c += f.a.a.a.fS(7, this.rUI.boi());
            }
            return c + f.a.a.a.c(8, 8, this.szW);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.szV.clear();
            this.szW.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.a(aVar2); c > 0; c = a.a(aVar2)) {
                if (!super.a(aVar2, this, c)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cfl cfl = (cfl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cfl.szV.add(aVar3.vHC.readString());
                    return 0;
                case 2:
                    cfl.rUH = aVar3.vHC.rY();
                    return 0;
                case 3:
                    cfl.iwP = aVar3.vHC.readString();
                    return 0;
                case 4:
                    cfl.otY = aVar3.vHC.rY();
                    return 0;
                case 5:
                    cfl.rll = aVar3.vHC.rZ();
                    return 0;
                case 6:
                    cfl.rEx = aVar3.vHC.readString();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aqs aqs = new aqs();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aqs.a(aVar4, aqs, a.a(aVar4))) {
                        }
                        cfl.rUI = aqs;
                    }
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ps psVar = new ps();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = psVar.a(aVar4, psVar, a.a(aVar4))) {
                        }
                        cfl.szW.add(psVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
