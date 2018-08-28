package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class qr extends bhd {
    public int hbF;
    public String jPe;
    public String ruY;
    public String ruZ;
    public aqr rva;
    public LinkedList<bhz> rvb = new LinkedList();
    public String rvc;
    public String rvd;

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rva == null) {
                throw new b("Not all required fields were included: Loc");
            }
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            if (this.jPe != null) {
                aVar.g(2, this.jPe);
            }
            if (this.ruY != null) {
                aVar.g(3, this.ruY);
            }
            if (this.ruZ != null) {
                aVar.g(4, this.ruZ);
            }
            if (this.rva != null) {
                aVar.fV(5, this.rva.boi());
                this.rva.a(aVar);
            }
            aVar.fT(6, this.hbF);
            aVar.d(7, 8, this.rvb);
            if (this.rvc != null) {
                aVar.g(8, this.rvc);
            }
            if (this.rvd == null) {
                return 0;
            }
            aVar.g(9, this.rvd);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.jPe != null) {
                fS += f.a.a.b.b.a.h(2, this.jPe);
            }
            if (this.ruY != null) {
                fS += f.a.a.b.b.a.h(3, this.ruY);
            }
            if (this.ruZ != null) {
                fS += f.a.a.b.b.a.h(4, this.ruZ);
            }
            if (this.rva != null) {
                fS += f.a.a.a.fS(5, this.rva.boi());
            }
            fS = (fS + f.a.a.a.fQ(6, this.hbF)) + f.a.a.a.c(7, 8, this.rvb);
            if (this.rvc != null) {
                fS += f.a.a.b.b.a.h(8, this.rvc);
            }
            if (this.rvd != null) {
                fS += f.a.a.b.b.a.h(9, this.rvd);
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rvb.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rva != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Loc");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            qr qrVar = (qr) objArr[1];
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
                        qrVar.shX = fkVar;
                    }
                    return 0;
                case 2:
                    qrVar.jPe = aVar3.vHC.readString();
                    return 0;
                case 3:
                    qrVar.ruY = aVar3.vHC.readString();
                    return 0;
                case 4:
                    qrVar.ruZ = aVar3.vHC.readString();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aqr aqr = new aqr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aqr.a(aVar4, aqr, bhd.a(aVar4))) {
                        }
                        qrVar.rva = aqr;
                    }
                    return 0;
                case 6:
                    qrVar.hbF = aVar3.vHC.rY();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        qrVar.rvb.add(bhz);
                    }
                    return 0;
                case 8:
                    qrVar.rvc = aVar3.vHC.readString();
                    return 0;
                case 9:
                    qrVar.rvd = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
