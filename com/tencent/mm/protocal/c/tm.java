package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class tm extends a {
    public int hbF;
    public LinkedList<aqi> hbG = new LinkedList();
    public String rwk;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rwk != null) {
                aVar.g(1, this.rwk);
            }
            aVar.fT(2, this.hbF);
            aVar.d(3, 8, this.hbG);
            return 0;
        } else if (i == 1) {
            if (this.rwk != null) {
                h = f.a.a.b.b.a.h(1, this.rwk) + 0;
            } else {
                h = 0;
            }
            return (h + f.a.a.a.fQ(2, this.hbF)) + f.a.a.a.c(3, 8, this.hbG);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.hbG.clear();
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
            tm tmVar = (tm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    tmVar.rwk = aVar3.vHC.readString();
                    return 0;
                case 2:
                    tmVar.hbF = aVar3.vHC.rY();
                    return 0;
                case 3:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aqi aqi = new aqi();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = aqi.a(aVar4, aqi, a.a(aVar4))) {
                        }
                        tmVar.hbG.add(aqi);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
