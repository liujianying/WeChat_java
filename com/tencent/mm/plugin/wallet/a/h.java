package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;
import java.util.LinkedList;

public final class h extends a {
    public double pdX;
    public LinkedList<q> pdZ = new LinkedList();
    public double pee;
    public double pef;
    public int peg;
    public String peh;
    public String pei;
    public b pel;
    public String pem;
    public double pen;
    public LinkedList<e> peo = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.pem != null) {
                aVar.g(1, this.pem);
            }
            aVar.c(2, this.pen);
            aVar.c(3, this.pdX);
            aVar.d(4, 8, this.peo);
            aVar.d(5, 8, this.pdZ);
            aVar.c(6, this.pee);
            aVar.c(7, this.pef);
            aVar.fT(8, this.peg);
            if (this.peh != null) {
                aVar.g(9, this.peh);
            }
            if (this.pei != null) {
                aVar.g(10, this.pei);
            }
            if (this.pel == null) {
                return 0;
            }
            aVar.b(11, this.pel);
            return 0;
        } else if (i == 1) {
            if (this.pem != null) {
                h = f.a.a.b.b.a.h(1, this.pem) + 0;
            } else {
                h = 0;
            }
            h = ((((((h + (f.a.a.b.b.a.ec(2) + 8)) + (f.a.a.b.b.a.ec(3) + 8)) + f.a.a.a.c(4, 8, this.peo)) + f.a.a.a.c(5, 8, this.pdZ)) + (f.a.a.b.b.a.ec(6) + 8)) + (f.a.a.b.b.a.ec(7) + 8)) + f.a.a.a.fQ(8, this.peg);
            if (this.peh != null) {
                h += f.a.a.b.b.a.h(9, this.peh);
            }
            if (this.pei != null) {
                h += f.a.a.b.b.a.h(10, this.pei);
            }
            if (this.pel != null) {
                h += f.a.a.a.a(11, this.pel);
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.peo.clear();
            this.pdZ.clear();
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
            h hVar = (h) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    hVar.pem = aVar3.vHC.readString();
                    return 0;
                case 2:
                    hVar.pen = aVar3.vHC.readDouble();
                    return 0;
                case 3:
                    hVar.pdX = aVar3.vHC.readDouble();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        e eVar = new e();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        hVar.peo.add(eVar);
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        q qVar = new q();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qVar.a(aVar4, qVar, a.a(aVar4))) {
                        }
                        hVar.pdZ.add(qVar);
                    }
                    return 0;
                case 6:
                    hVar.pee = aVar3.vHC.readDouble();
                    return 0;
                case 7:
                    hVar.pef = aVar3.vHC.readDouble();
                    return 0;
                case 8:
                    hVar.peg = aVar3.vHC.rY();
                    return 0;
                case 9:
                    hVar.peh = aVar3.vHC.readString();
                    return 0;
                case 10:
                    hVar.pei = aVar3.vHC.readString();
                    return 0;
                case 11:
                    hVar.pel = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
