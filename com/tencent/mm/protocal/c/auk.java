package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class auk extends bhd {
    public int otY;
    public int rXC;
    public LinkedList<auj> rXD = new LinkedList();
    public int rXE;
    public String rXF;
    public int rbY;
    public LinkedList<aum> rgH = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int fS;
        byte[] bArr;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.shX != null) {
                aVar.fV(1, this.shX.boi());
                this.shX.a(aVar);
            }
            aVar.fT(2, this.rbY);
            aVar.fT(3, this.rXC);
            aVar.d(4, 8, this.rXD);
            aVar.fT(5, this.rXE);
            aVar.d(6, 8, this.rgH);
            if (this.rXF != null) {
                aVar.g(7, this.rXF);
            }
            aVar.fT(8, this.otY);
            return 0;
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            fS = ((((fS + f.a.a.a.fQ(2, this.rbY)) + f.a.a.a.fQ(3, this.rXC)) + f.a.a.a.c(4, 8, this.rXD)) + f.a.a.a.fQ(5, this.rXE)) + f.a.a.a.c(6, 8, this.rgH);
            if (this.rXF != null) {
                fS += f.a.a.b.b.a.h(7, this.rXF);
            }
            return fS + f.a.a.a.fQ(8, this.otY);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rXD.clear();
            this.rgH.clear();
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
            auk auk = (auk) objArr[1];
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
                        auk.shX = fkVar;
                    }
                    return 0;
                case 2:
                    auk.rbY = aVar3.vHC.rY();
                    return 0;
                case 3:
                    auk.rXC = aVar3.vHC.rY();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        auj auj = new auj();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = auj.a(aVar4, auj, bhd.a(aVar4))) {
                        }
                        auk.rXD.add(auj);
                    }
                    return 0;
                case 5:
                    auk.rXE = aVar3.vHC.rY();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aum aum = new aum();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aum.a(aVar4, aum, bhd.a(aVar4))) {
                        }
                        auk.rgH.add(aum);
                    }
                    return 0;
                case 7:
                    auk.rXF = aVar3.vHC.readString();
                    return 0;
                case 8:
                    auk.otY = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
