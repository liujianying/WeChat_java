package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class amw extends a {
    public int rPC;
    public amz rPD;
    public amy rPE;
    public amx rPF;
    public amv rPG;
    public ana rPH;
    public anb rPI;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.fT(1, this.rPC);
            if (this.rPD != null) {
                aVar.fV(2, this.rPD.boi());
                this.rPD.a(aVar);
            }
            if (this.rPE != null) {
                aVar.fV(3, this.rPE.boi());
                this.rPE.a(aVar);
            }
            if (this.rPF != null) {
                aVar.fV(4, this.rPF.boi());
                this.rPF.a(aVar);
            }
            if (this.rPG != null) {
                aVar.fV(5, this.rPG.boi());
                this.rPG.a(aVar);
            }
            if (this.rPH != null) {
                aVar.fV(6, this.rPH.boi());
                this.rPH.a(aVar);
            }
            if (this.rPI != null) {
                aVar.fV(7, this.rPI.boi());
                this.rPI.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fQ = f.a.a.a.fQ(1, this.rPC) + 0;
            if (this.rPD != null) {
                fQ += f.a.a.a.fS(2, this.rPD.boi());
            }
            if (this.rPE != null) {
                fQ += f.a.a.a.fS(3, this.rPE.boi());
            }
            if (this.rPF != null) {
                fQ += f.a.a.a.fS(4, this.rPF.boi());
            }
            if (this.rPG != null) {
                fQ += f.a.a.a.fS(5, this.rPG.boi());
            }
            if (this.rPH != null) {
                fQ += f.a.a.a.fS(6, this.rPH.boi());
            }
            if (this.rPI != null) {
                return fQ + f.a.a.a.fS(7, this.rPI.boi());
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            amw amw = (amw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    amw.rPC = aVar3.vHC.rY();
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        amz amz = new amz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = amz.a(aVar4, amz, a.a(aVar4))) {
                        }
                        amw.rPD = amz;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        amy amy = new amy();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = amy.a(aVar4, amy, a.a(aVar4))) {
                        }
                        amw.rPE = amy;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        amx amx = new amx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = amx.a(aVar4, amx, a.a(aVar4))) {
                        }
                        amw.rPF = amx;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        amv amv = new amv();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = amv.a(aVar4, amv, a.a(aVar4))) {
                        }
                        amw.rPG = amv;
                    }
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ana ana = new ana();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ana.a(aVar4, ana, a.a(aVar4))) {
                        }
                        amw.rPH = ana;
                    }
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        anb anb = new anb();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = anb.a(aVar4, anb, a.a(aVar4))) {
                        }
                        amw.rPI = anb;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
