package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class bks extends bhd {
    public String jPH;
    public String jPe;
    public String lCN;
    public String rej;
    public String skc;
    public String skd;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.jPH != null) {
                aVar.g(2, this.jPH);
            }
            if (this.skc != null) {
                aVar.g(3, this.skc);
            }
            if (this.lCN != null) {
                aVar.g(5, this.lCN);
            }
            if (this.jPe != null) {
                aVar.g(4, this.jPe);
            }
            if (this.rej != null) {
                aVar.g(6, this.rej);
            }
            if (this.skd == null) {
                return 0;
            }
            aVar.g(7, this.skd);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.jPH != null) {
                fS += f.a.a.b.b.a.h(2, this.jPH);
            }
            if (this.skc != null) {
                fS += f.a.a.b.b.a.h(3, this.skc);
            }
            if (this.lCN != null) {
                fS += f.a.a.b.b.a.h(5, this.lCN);
            }
            if (this.jPe != null) {
                fS += f.a.a.b.b.a.h(4, this.jPe);
            }
            if (this.rej != null) {
                fS += f.a.a.b.b.a.h(6, this.rej);
            }
            if (this.skd != null) {
                fS += f.a.a.b.b.a.h(7, this.skd);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = com.tencent.mm.bk.a.a(aVar2); fS > 0; fS = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bks bks = (bks) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        com.tencent.mm.bk.a fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, com.tencent.mm.bk.a.a(aVar4))) {
                        }
                        bks.shX = fkVar;
                    }
                    return 0;
                case 2:
                    bks.jPH = aVar3.vHC.readString();
                    return 0;
                case 3:
                    bks.skc = aVar3.vHC.readString();
                    return 0;
                case 4:
                    bks.jPe = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bks.lCN = aVar3.vHC.readString();
                    return 0;
                case 6:
                    bks.rej = aVar3.vHC.readString();
                    return 0;
                case 7:
                    bks.skd = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
