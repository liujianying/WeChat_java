package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class ag extends a {
    public String jPA;
    public String jPB;
    public LinkedList<cv> jQF = new LinkedList();
    public String jQG;
    public String jQH;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jPB != null) {
                aVar.g(1, this.jPB);
            }
            aVar.d(2, 8, this.jQF);
            if (this.jQG != null) {
                aVar.g(3, this.jQG);
            }
            if (this.jQH != null) {
                aVar.g(4, this.jQH);
            }
            if (this.jPA == null) {
                return 0;
            }
            aVar.g(5, this.jPA);
            return 0;
        } else if (i == 1) {
            if (this.jPB != null) {
                h = f.a.a.b.b.a.h(1, this.jPB) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.c(2, 8, this.jQF);
            if (this.jQG != null) {
                h += f.a.a.b.b.a.h(3, this.jQG);
            }
            if (this.jQH != null) {
                h += f.a.a.b.b.a.h(4, this.jQH);
            }
            if (this.jPA != null) {
                h += f.a.a.b.b.a.h(5, this.jPA);
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.jQF.clear();
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
            ag agVar = (ag) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    agVar.jPB = aVar3.vHC.readString();
                    return 0;
                case 2:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        cv cvVar = new cv();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cvVar.a(aVar4, cvVar, a.a(aVar4))) {
                        }
                        agVar.jQF.add(cvVar);
                    }
                    return 0;
                case 3:
                    agVar.jQG = aVar3.vHC.readString();
                    return 0;
                case 4:
                    agVar.jQH = aVar3.vHC.readString();
                    return 0;
                case 5:
                    agVar.jPA = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
