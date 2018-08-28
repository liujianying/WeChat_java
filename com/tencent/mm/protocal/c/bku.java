package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class bku extends a {
    public String bKg;
    public int dwI;
    public int dwJ;
    public String dwK;
    public int emx;
    public int enM;
    public String nuY;
    public LinkedList<btc> ske = new LinkedList();
    public int skf;
    public String url;

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.nuY == null) {
                throw new b("Not all required fields were included: clientID");
            }
            aVar.d(1, 8, this.ske);
            if (this.nuY != null) {
                aVar.g(2, this.nuY);
            }
            if (this.bKg != null) {
                aVar.g(3, this.bKg);
            }
            if (this.dwK != null) {
                aVar.g(4, this.dwK);
            }
            if (this.url != null) {
                aVar.g(5, this.url);
            }
            aVar.fT(6, this.enM);
            aVar.fT(7, this.emx);
            aVar.fT(8, this.skf);
            aVar.fT(9, this.dwI);
            aVar.fT(10, this.dwJ);
            return 0;
        } else if (i == 1) {
            c = f.a.a.a.c(1, 8, this.ske) + 0;
            if (this.nuY != null) {
                c += f.a.a.b.b.a.h(2, this.nuY);
            }
            if (this.bKg != null) {
                c += f.a.a.b.b.a.h(3, this.bKg);
            }
            if (this.dwK != null) {
                c += f.a.a.b.b.a.h(4, this.dwK);
            }
            if (this.url != null) {
                c += f.a.a.b.b.a.h(5, this.url);
            }
            return ((((c + f.a.a.a.fQ(6, this.enM)) + f.a.a.a.fQ(7, this.emx)) + f.a.a.a.fQ(8, this.skf)) + f.a.a.a.fQ(9, this.dwI)) + f.a.a.a.fQ(10, this.dwJ);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.ske.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.a(aVar2); c > 0; c = a.a(aVar2)) {
                if (!super.a(aVar2, this, c)) {
                    aVar2.cJS();
                }
            }
            if (this.nuY != null) {
                return 0;
            }
            throw new b("Not all required fields were included: clientID");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bku bku = (bku) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        btc btc = new btc();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = btc.a(aVar4, btc, a.a(aVar4))) {
                        }
                        bku.ske.add(btc);
                    }
                    return 0;
                case 2:
                    bku.nuY = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bku.bKg = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bku.dwK = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bku.url = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bku.enM = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bku.emx = aVar3.vHC.rY();
                    return 0;
                case 8:
                    bku.skf = aVar3.vHC.rY();
                    return 0;
                case 9:
                    bku.dwI = aVar3.vHC.rY();
                    return 0;
                case 10:
                    bku.dwJ = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
