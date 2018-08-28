package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class aa extends bhd {
    public String SSID;
    public String URL;
    public String qYZ;
    public String qZa;
    public String qZb;
    public int qZc;
    public LinkedList<cr> qZd = new LinkedList();
    public int qZe;
    public String qZf;
    public int qZg;
    public String qZh;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.URL != null) {
                aVar.g(2, this.URL);
            }
            if (this.SSID != null) {
                aVar.g(3, this.SSID);
            }
            if (this.qYZ != null) {
                aVar.g(4, this.qYZ);
            }
            if (this.qZa != null) {
                aVar.g(5, this.qZa);
            }
            if (this.qZb != null) {
                aVar.g(6, this.qZb);
            }
            aVar.fT(7, this.qZc);
            aVar.d(8, 8, this.qZd);
            aVar.fT(9, this.qZe);
            if (this.qZf != null) {
                aVar.g(10, this.qZf);
            }
            aVar.fT(11, this.qZg);
            if (this.qZh == null) {
                return 0;
            }
            aVar.g(12, this.qZh);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.URL != null) {
                fS += f.a.a.b.b.a.h(2, this.URL);
            }
            if (this.SSID != null) {
                fS += f.a.a.b.b.a.h(3, this.SSID);
            }
            if (this.qYZ != null) {
                fS += f.a.a.b.b.a.h(4, this.qYZ);
            }
            if (this.qZa != null) {
                fS += f.a.a.b.b.a.h(5, this.qZa);
            }
            if (this.qZb != null) {
                fS += f.a.a.b.b.a.h(6, this.qZb);
            }
            fS = ((fS + f.a.a.a.fQ(7, this.qZc)) + f.a.a.a.c(8, 8, this.qZd)) + f.a.a.a.fQ(9, this.qZe);
            if (this.qZf != null) {
                fS += f.a.a.b.b.a.h(10, this.qZf);
            }
            fS += f.a.a.a.fQ(11, this.qZg);
            if (this.qZh != null) {
                fS += f.a.a.b.b.a.h(12, this.qZh);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.qZd.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            aa aaVar = (aa) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        aaVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    aaVar.URL = aVar3.vHC.readString();
                    return 0;
                case 3:
                    aaVar.SSID = aVar3.vHC.readString();
                    return 0;
                case 4:
                    aaVar.qYZ = aVar3.vHC.readString();
                    return 0;
                case 5:
                    aaVar.qZa = aVar3.vHC.readString();
                    return 0;
                case 6:
                    aaVar.qZb = aVar3.vHC.readString();
                    return 0;
                case 7:
                    aaVar.qZc = aVar3.vHC.rY();
                    return 0;
                case 8:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cr crVar = new cr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = crVar.a(aVar4, crVar, bhd.a(aVar4))) {
                        }
                        aaVar.qZd.add(crVar);
                    }
                    return 0;
                case 9:
                    aaVar.qZe = aVar3.vHC.rY();
                    return 0;
                case 10:
                    aaVar.qZf = aVar3.vHC.readString();
                    return 0;
                case 11:
                    aaVar.qZg = aVar3.vHC.rY();
                    return 0;
                case 12:
                    aaVar.qZh = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
