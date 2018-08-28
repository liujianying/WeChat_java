package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class ack extends bhd {
    public int rGU;
    public int rGV;
    public LinkedList<bhz> rGW = new LinkedList();
    public int rGX;
    public LinkedList<bhz> rGY = new LinkedList();
    public int rGZ;
    public bhz rHa;
    public LinkedList<bhz> rgF = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.rGU);
            aVar.d(3, 8, this.rgF);
            aVar.fT(4, this.rGV);
            aVar.d(5, 8, this.rGW);
            aVar.fT(6, this.rGX);
            aVar.d(7, 8, this.rGY);
            aVar.fT(8, this.rGZ);
            if (this.rHa == null) {
                return 0;
            }
            aVar.fV(9, this.rHa.boi());
            this.rHa.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = ((((((fS + f.a.a.a.fQ(2, this.rGU)) + f.a.a.a.c(3, 8, this.rgF)) + f.a.a.a.fQ(4, this.rGV)) + f.a.a.a.c(5, 8, this.rGW)) + f.a.a.a.fQ(6, this.rGX)) + f.a.a.a.c(7, 8, this.rGY)) + f.a.a.a.fQ(8, this.rGZ);
            if (this.rHa != null) {
                fS += f.a.a.a.fS(9, this.rHa.boi());
            }
            return fS;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rgF.clear();
            this.rGW.clear();
            this.rGY.clear();
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
            ack ack = (ack) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            bhz bhz;
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
                        ack.shX = fkVar;
                    }
                    return 0;
                case 2:
                    ack.rGU = aVar3.vHC.rY();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        ack.rgF.add(bhz);
                    }
                    return 0;
                case 4:
                    ack.rGV = aVar3.vHC.rY();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        ack.rGW.add(bhz);
                    }
                    return 0;
                case 6:
                    ack.rGX = aVar3.vHC.rY();
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        ack.rGY.add(bhz);
                    }
                    return 0;
                case 8:
                    ack.rGZ = aVar3.vHC.rY();
                    return 0;
                case 9:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bhz = new bhz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bhz.a(aVar4, bhz, bhd.a(aVar4))) {
                        }
                        ack.rHa = bhz;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
