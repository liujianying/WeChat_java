package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class ai extends a {
    public ca jQI;
    public ca jQJ;
    public ca jQK;
    public cx jQL;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jQI != null) {
                aVar.fV(1, this.jQI.boi());
                this.jQI.a(aVar);
            }
            if (this.jQJ != null) {
                aVar.fV(2, this.jQJ.boi());
                this.jQJ.a(aVar);
            }
            if (this.jQK != null) {
                aVar.fV(3, this.jQK.boi());
                this.jQK.a(aVar);
            }
            if (this.jQL == null) {
                return 0;
            }
            aVar.fV(4, this.jQL.boi());
            this.jQL.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.jQI != null) {
                fS = f.a.a.a.fS(1, this.jQI.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.jQJ != null) {
                fS += f.a.a.a.fS(2, this.jQJ.boi());
            }
            if (this.jQK != null) {
                fS += f.a.a.a.fS(3, this.jQK.boi());
            }
            if (this.jQL != null) {
                fS += f.a.a.a.fS(4, this.jQL.boi());
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
            ai aiVar = (ai) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            ca caVar;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        caVar = new ca();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = caVar.a(aVar4, caVar, a.a(aVar4))) {
                        }
                        aiVar.jQI = caVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        caVar = new ca();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = caVar.a(aVar4, caVar, a.a(aVar4))) {
                        }
                        aiVar.jQJ = caVar;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        caVar = new ca();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = caVar.a(aVar4, caVar, a.a(aVar4))) {
                        }
                        aiVar.jQK = caVar;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cx cxVar = new cx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cxVar.a(aVar4, cxVar, a.a(aVar4))) {
                        }
                        aiVar.jQL = cxVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
