package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bwx extends a {
    public LinkedList<bsf> stj = new LinkedList();
    public LinkedList<bsf> stk = new LinkedList();
    public LinkedList<pr> stl = new LinkedList();
    public String title;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            aVar.d(2, 8, this.stj);
            aVar.d(3, 8, this.stk);
            aVar.d(4, 8, this.stl);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                h = f.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                h = 0;
            }
            return ((h + f.a.a.a.c(2, 8, this.stj)) + f.a.a.a.c(3, 8, this.stk)) + f.a.a.a.c(4, 8, this.stl);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.stj.clear();
            this.stk.clear();
            this.stl.clear();
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
            bwx bwx = (bwx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            bsf bsf;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bwx.title = aVar3.vHC.readString();
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bsf = new bsf();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bsf.a(aVar4, bsf, a.a(aVar4))) {
                        }
                        bwx.stj.add(bsf);
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bsf = new bsf();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bsf.a(aVar4, bsf, a.a(aVar4))) {
                        }
                        bwx.stk.add(bsf);
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        pr prVar = new pr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = prVar.a(aVar4, prVar, a.a(aVar4))) {
                        }
                        bwx.stl.add(prVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
