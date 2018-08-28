package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class cg extends a {
    public LinkedList<b> jSI = new LinkedList();
    public cp jSJ;
    public LinkedList<m> jSK = new LinkedList();
    public cl jSL;
    public LinkedList<da> jSM = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int c;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.jSI);
            if (this.jSJ != null) {
                aVar.fV(2, this.jSJ.boi());
                this.jSJ.a(aVar);
            }
            aVar.d(3, 8, this.jSK);
            if (this.jSL != null) {
                aVar.fV(4, this.jSL.boi());
                this.jSL.a(aVar);
            }
            aVar.d(5, 8, this.jSM);
            return 0;
        } else if (i == 1) {
            c = f.a.a.a.c(1, 8, this.jSI) + 0;
            if (this.jSJ != null) {
                c += f.a.a.a.fS(2, this.jSJ.boi());
            }
            c += f.a.a.a.c(3, 8, this.jSK);
            if (this.jSL != null) {
                c += f.a.a.a.fS(4, this.jSL.boi());
            }
            return c + f.a.a.a.c(5, 8, this.jSM);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jSI.clear();
            this.jSK.clear();
            this.jSM.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (c = a.a(aVar2); c > 0; c = a.a(aVar2)) {
                if (!super.a(aVar2, this, c)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cg cgVar = (cg) objArr[1];
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
                        b bVar = new b();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bVar.a(aVar4, bVar, a.a(aVar4))) {
                        }
                        cgVar.jSI.add(bVar);
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cp cpVar = new cp();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cpVar.a(aVar4, cpVar, a.a(aVar4))) {
                        }
                        cgVar.jSJ = cpVar;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        m mVar = new m();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mVar.a(aVar4, mVar, a.a(aVar4))) {
                        }
                        cgVar.jSK.add(mVar);
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cl clVar = new cl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = clVar.a(aVar4, clVar, a.a(aVar4))) {
                        }
                        cgVar.jSL = clVar;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        da daVar = new da();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = daVar.a(aVar4, daVar, a.a(aVar4))) {
                        }
                        cgVar.jSM.add(daVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
