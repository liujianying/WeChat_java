package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;
import java.util.LinkedList;

public final class alu extends a {
    public b rOh;
    public int rOi;
    public LinkedList<alw> rOj = new LinkedList();
    public LinkedList<Integer> rOk = new LinkedList();

    protected final int a(int i, Object... objArr) {
        int a;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rOh == null) {
                throw new f.a.a.b("Not all required fields were included: RawBuf");
            }
            if (this.rOh != null) {
                aVar.b(1, this.rOh);
            }
            aVar.fT(2, this.rOi);
            aVar.d(3, 8, this.rOj);
            aVar.d(4, 2, this.rOk);
            return 0;
        } else if (i == 1) {
            if (this.rOh != null) {
                a = f.a.a.a.a(1, this.rOh) + 0;
            } else {
                a = 0;
            }
            return ((a + f.a.a.a.fQ(2, this.rOi)) + f.a.a.a.c(3, 8, this.rOj)) + f.a.a.a.c(4, 2, this.rOk);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rOj.clear();
            this.rOk.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                if (!super.a(aVar2, this, a)) {
                    aVar2.cJS();
                }
            }
            if (this.rOh != null) {
                return 0;
            }
            throw new f.a.a.b("Not all required fields were included: RawBuf");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            alu alu = (alu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    alu.rOh = aVar3.cJR();
                    return 0;
                case 2:
                    alu.rOi = aVar3.vHC.rY();
                    return 0;
                case 3:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        alw alw = new alw();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = alw.a(aVar4, alw, a.a(aVar4))) {
                        }
                        alu.rOj.add(alw);
                    }
                    return 0;
                case 4:
                    alu.rOk.add(Integer.valueOf(aVar3.vHC.rY()));
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
