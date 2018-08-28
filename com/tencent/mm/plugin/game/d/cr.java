package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class cr extends a {
    public String bHD;
    public String jOS;
    public String jOT;
    public e jOV;
    public String jQb;
    public String jQh;
    public String jRi;
    public LinkedList<v> jTa = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bHD != null) {
                aVar.g(1, this.bHD);
            }
            if (this.jQb != null) {
                aVar.g(2, this.jQb);
            }
            if (this.jOT != null) {
                aVar.g(3, this.jOT);
            }
            if (this.jOS != null) {
                aVar.g(4, this.jOS);
            }
            if (this.jRi != null) {
                aVar.g(5, this.jRi);
            }
            if (this.jOV != null) {
                aVar.fV(6, this.jOV.boi());
                this.jOV.a(aVar);
            }
            aVar.d(7, 8, this.jTa);
            if (this.jQh == null) {
                return 0;
            }
            aVar.g(8, this.jQh);
            return 0;
        } else if (i == 1) {
            if (this.bHD != null) {
                h = f.a.a.b.b.a.h(1, this.bHD) + 0;
            } else {
                h = 0;
            }
            if (this.jQb != null) {
                h += f.a.a.b.b.a.h(2, this.jQb);
            }
            if (this.jOT != null) {
                h += f.a.a.b.b.a.h(3, this.jOT);
            }
            if (this.jOS != null) {
                h += f.a.a.b.b.a.h(4, this.jOS);
            }
            if (this.jRi != null) {
                h += f.a.a.b.b.a.h(5, this.jRi);
            }
            if (this.jOV != null) {
                h += f.a.a.a.fS(6, this.jOV.boi());
            }
            h += f.a.a.a.c(7, 8, this.jTa);
            if (this.jQh != null) {
                h += f.a.a.b.b.a.h(8, this.jQh);
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jTa.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            cr crVar = (cr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    crVar.bHD = aVar3.vHC.readString();
                    return 0;
                case 2:
                    crVar.jQb = aVar3.vHC.readString();
                    return 0;
                case 3:
                    crVar.jOT = aVar3.vHC.readString();
                    return 0;
                case 4:
                    crVar.jOS = aVar3.vHC.readString();
                    return 0;
                case 5:
                    crVar.jRi = aVar3.vHC.readString();
                    return 0;
                case 6:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        e eVar = new e();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        crVar.jOV = eVar;
                    }
                    return 0;
                case 7:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        v vVar = new v();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vVar.a(aVar4, vVar, a.a(aVar4))) {
                        }
                        crVar.jTa.add(vVar);
                    }
                    return 0;
                case 8:
                    crVar.jQh = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
