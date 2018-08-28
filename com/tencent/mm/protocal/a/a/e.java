package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class e extends a {
    public int nettype;
    public int qXh;
    public LinkedList<d> qXi = new LinkedList();
    public String qXr;
    public String qXs;
    public String qXt;
    public String qXu;
    public String qXv;
    public int qXw;
    public int uin;

    protected final int a(int i, Object... objArr) {
        int fQ;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.uin);
            aVar.fT(2, this.qXh);
            aVar.fT(3, this.nettype);
            aVar.d(4, 8, this.qXi);
            if (this.qXr != null) {
                aVar.g(5, this.qXr);
            }
            if (this.qXs != null) {
                aVar.g(6, this.qXs);
            }
            if (this.qXt != null) {
                aVar.g(7, this.qXt);
            }
            if (this.qXu != null) {
                aVar.g(8, this.qXu);
            }
            if (this.qXv != null) {
                aVar.g(9, this.qXv);
            }
            aVar.fT(10, this.qXw);
            return 0;
        } else if (i == 1) {
            fQ = (((f.a.a.a.fQ(1, this.uin) + 0) + f.a.a.a.fQ(2, this.qXh)) + f.a.a.a.fQ(3, this.nettype)) + f.a.a.a.c(4, 8, this.qXi);
            if (this.qXr != null) {
                fQ += f.a.a.b.b.a.h(5, this.qXr);
            }
            if (this.qXs != null) {
                fQ += f.a.a.b.b.a.h(6, this.qXs);
            }
            if (this.qXt != null) {
                fQ += f.a.a.b.b.a.h(7, this.qXt);
            }
            if (this.qXu != null) {
                fQ += f.a.a.b.b.a.h(8, this.qXu);
            }
            if (this.qXv != null) {
                fQ += f.a.a.b.b.a.h(9, this.qXv);
            }
            return fQ + f.a.a.a.fQ(10, this.qXw);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.qXi.clear();
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
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eVar.uin = aVar3.vHC.rY();
                    return 0;
                case 2:
                    eVar.qXh = aVar3.vHC.rY();
                    return 0;
                case 3:
                    eVar.nettype = aVar3.vHC.rY();
                    return 0;
                case 4:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        d dVar = new d();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        eVar.qXi.add(dVar);
                    }
                    return 0;
                case 5:
                    eVar.qXr = aVar3.vHC.readString();
                    return 0;
                case 6:
                    eVar.qXs = aVar3.vHC.readString();
                    return 0;
                case 7:
                    eVar.qXt = aVar3.vHC.readString();
                    return 0;
                case 8:
                    eVar.qXu = aVar3.vHC.readString();
                    return 0;
                case 9:
                    eVar.qXv = aVar3.vHC.readString();
                    return 0;
                case 10:
                    eVar.qXw = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
