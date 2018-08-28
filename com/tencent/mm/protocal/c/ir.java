package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class ir extends a {
    public String rjR;
    public int rjS;
    public String rjT;
    public int rjU;
    public LinkedList<hn> rjV = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rjR != null) {
                aVar.g(1, this.rjR);
            }
            aVar.fT(2, this.rjS);
            if (this.rjT != null) {
                aVar.g(3, this.rjT);
            }
            aVar.fT(4, this.rjU);
            aVar.d(5, 8, this.rjV);
            return 0;
        } else if (i == 1) {
            if (this.rjR != null) {
                h = f.a.a.b.b.a.h(1, this.rjR) + 0;
            } else {
                h = 0;
            }
            h += f.a.a.a.fQ(2, this.rjS);
            if (this.rjT != null) {
                h += f.a.a.b.b.a.h(3, this.rjT);
            }
            return (h + f.a.a.a.fQ(4, this.rjU)) + f.a.a.a.c(5, 8, this.rjV);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rjV.clear();
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
            ir irVar = (ir) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    irVar.rjR = aVar3.vHC.readString();
                    return 0;
                case 2:
                    irVar.rjS = aVar3.vHC.rY();
                    return 0;
                case 3:
                    irVar.rjT = aVar3.vHC.readString();
                    return 0;
                case 4:
                    irVar.rjU = aVar3.vHC.rY();
                    return 0;
                case 5:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        hn hnVar = new hn();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = hnVar.a(aVar4, hnVar, a.a(aVar4))) {
                        }
                        irVar.rjV.add(hnVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
