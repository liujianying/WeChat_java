package com.tencent.mm.plugin.exdevice.e;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class g extends j {
    public String hbQ;
    public int iwW;
    public int iwX;
    public int iwY;
    public int iwZ;
    public int ixa;
    public String ixb;
    public int ixc;
    public String ixd;
    public int ixe;
    public int ixf;
    public String ixg;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.ixj == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.ixj != null) {
                aVar.fV(1, this.ixj.boi());
                this.ixj.a(aVar);
            }
            aVar.fT(2, this.iwW);
            aVar.fT(3, this.iwX);
            aVar.fT(4, this.iwY);
            aVar.fT(5, this.iwZ);
            aVar.fT(6, this.ixa);
            if (this.ixb != null) {
                aVar.g(11, this.ixb);
            }
            aVar.fT(12, this.ixc);
            if (this.hbQ != null) {
                aVar.g(13, this.hbQ);
            }
            if (this.ixd != null) {
                aVar.g(14, this.ixd);
            }
            aVar.fT(15, this.ixe);
            aVar.fT(16, this.ixf);
            if (this.ixg == null) {
                return 0;
            }
            aVar.g(17, this.ixg);
            return 0;
        } else if (i == 1) {
            if (this.ixj != null) {
                fS = f.a.a.a.fS(1, this.ixj.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = ((((fS + f.a.a.a.fQ(2, this.iwW)) + f.a.a.a.fQ(3, this.iwX)) + f.a.a.a.fQ(4, this.iwY)) + f.a.a.a.fQ(5, this.iwZ)) + f.a.a.a.fQ(6, this.ixa);
            if (this.ixb != null) {
                fS += f.a.a.b.b.a.h(11, this.ixb);
            }
            fS += f.a.a.a.fQ(12, this.ixc);
            if (this.hbQ != null) {
                fS += f.a.a.b.b.a.h(13, this.hbQ);
            }
            if (this.ixd != null) {
                fS += f.a.a.b.b.a.h(14, this.ixd);
            }
            fS = (fS + f.a.a.a.fQ(15, this.ixe)) + f.a.a.a.fQ(16, this.ixf);
            if (this.ixg != null) {
                fS += f.a.a.b.b.a.h(17, this.ixg);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = j.a(aVar2); fS > 0; fS = j.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.ixj != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        e eVar = new e();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, j.a(aVar4))) {
                        }
                        gVar.ixj = eVar;
                    }
                    return 0;
                case 2:
                    gVar.iwW = aVar3.vHC.rY();
                    return 0;
                case 3:
                    gVar.iwX = aVar3.vHC.rY();
                    return 0;
                case 4:
                    gVar.iwY = aVar3.vHC.rY();
                    return 0;
                case 5:
                    gVar.iwZ = aVar3.vHC.rY();
                    return 0;
                case 6:
                    gVar.ixa = aVar3.vHC.rY();
                    return 0;
                case 11:
                    gVar.ixb = aVar3.vHC.readString();
                    return 0;
                case 12:
                    gVar.ixc = aVar3.vHC.rY();
                    return 0;
                case 13:
                    gVar.hbQ = aVar3.vHC.readString();
                    return 0;
                case 14:
                    gVar.ixd = aVar3.vHC.readString();
                    return 0;
                case 15:
                    gVar.ixe = aVar3.vHC.rY();
                    return 0;
                case 16:
                    gVar.ixf = aVar3.vHC.rY();
                    return 0;
                case 17:
                    gVar.ixg = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
