package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class cn extends a {
    public String jQe;
    public co jST;
    public co jSU;
    public co jSV;
    public co jSW;
    public co jSX;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jST != null) {
                aVar.fV(1, this.jST.boi());
                this.jST.a(aVar);
            }
            if (this.jSU != null) {
                aVar.fV(2, this.jSU.boi());
                this.jSU.a(aVar);
            }
            if (this.jSV != null) {
                aVar.fV(3, this.jSV.boi());
                this.jSV.a(aVar);
            }
            if (this.jSW != null) {
                aVar.fV(4, this.jSW.boi());
                this.jSW.a(aVar);
            }
            if (this.jSX != null) {
                aVar.fV(6, this.jSX.boi());
                this.jSX.a(aVar);
            }
            if (this.jQe == null) {
                return 0;
            }
            aVar.g(5, this.jQe);
            return 0;
        } else if (i == 1) {
            if (this.jST != null) {
                fS = f.a.a.a.fS(1, this.jST.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.jSU != null) {
                fS += f.a.a.a.fS(2, this.jSU.boi());
            }
            if (this.jSV != null) {
                fS += f.a.a.a.fS(3, this.jSV.boi());
            }
            if (this.jSW != null) {
                fS += f.a.a.a.fS(4, this.jSW.boi());
            }
            if (this.jSX != null) {
                fS += f.a.a.a.fS(6, this.jSX.boi());
            }
            if (this.jQe != null) {
                fS += f.a.a.b.b.a.h(5, this.jQe);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cn cnVar = (cn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            co coVar;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        coVar = new co();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = coVar.a(aVar4, coVar, a.a(aVar4))) {
                        }
                        cnVar.jST = coVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        coVar = new co();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = coVar.a(aVar4, coVar, a.a(aVar4))) {
                        }
                        cnVar.jSU = coVar;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        coVar = new co();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = coVar.a(aVar4, coVar, a.a(aVar4))) {
                        }
                        cnVar.jSV = coVar;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        coVar = new co();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = coVar.a(aVar4, coVar, a.a(aVar4))) {
                        }
                        cnVar.jSW = coVar;
                    }
                    return 0;
                case 5:
                    cnVar.jQe = aVar3.vHC.readString();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        coVar = new co();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = coVar.a(aVar4, coVar, a.a(aVar4))) {
                        }
                        cnVar.jSX = coVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
