package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class anf extends a {
    public String fMk;
    public int major;
    public LinkedList<anh> rPU = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.fMk != null) {
                aVar.g(1, this.fMk);
            }
            aVar.fT(2, this.major);
            aVar.d(3, 8, this.rPU);
            return 0;
        } else if (i == 1) {
            if (this.fMk != null) {
                h = f.a.a.b.b.a.h(1, this.fMk) + 0;
            } else {
                h = 0;
            }
            return (h + f.a.a.a.fQ(2, this.major)) + f.a.a.a.c(3, 8, this.rPU);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rPU.clear();
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
            anf anf = (anf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    anf.fMk = aVar3.vHC.readString();
                    return 0;
                case 2:
                    anf.major = aVar3.vHC.rY();
                    return 0;
                case 3:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        anh anh = new anh();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = anh.a(aVar4, anh, a.a(aVar4))) {
                        }
                        anf.rPU.add(anh);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
