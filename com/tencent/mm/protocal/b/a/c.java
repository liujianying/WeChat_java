package com.tencent.mm.protocal.b.a;

import com.tencent.mm.bk.a;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wf;
import java.util.LinkedList;

public final class c extends a {
    public String desc;
    public LinkedList<vx> dzs = new LinkedList();
    public String qXZ;
    public wf qYa;
    public long qYb;
    public String title;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            if (this.desc != null) {
                aVar.g(2, this.desc);
            }
            aVar.d(3, 8, this.dzs);
            if (this.qXZ != null) {
                aVar.g(4, this.qXZ);
            }
            if (this.qYa != null) {
                aVar.fV(5, this.qYa.boi());
                this.qYa.a(aVar);
            }
            aVar.T(6, this.qYb);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                h = f.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                h = 0;
            }
            if (this.desc != null) {
                h += f.a.a.b.b.a.h(2, this.desc);
            }
            h += f.a.a.a.c(3, 8, this.dzs);
            if (this.qXZ != null) {
                h += f.a.a.b.b.a.h(4, this.qXZ);
            }
            if (this.qYa != null) {
                h += f.a.a.a.fS(5, this.qYa.boi());
            }
            return h + f.a.a.a.S(6, this.qYb);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.dzs.clear();
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
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cVar.title = aVar3.vHC.readString();
                    return 0;
                case 2:
                    cVar.desc = aVar3.vHC.readString();
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        vx vxVar = new vx();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = vxVar.a(aVar4, vxVar, a.a(aVar4))) {
                        }
                        cVar.dzs.add(vxVar);
                    }
                    return 0;
                case 4:
                    cVar.qXZ = aVar3.vHC.readString();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        wf wfVar = new wf();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = wfVar.a(aVar4, wfVar, a.a(aVar4))) {
                        }
                        cVar.qYa = wfVar;
                    }
                    return 0;
                case 6:
                    cVar.qYb = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
