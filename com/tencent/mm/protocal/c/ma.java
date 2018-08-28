package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class ma extends a {
    public lz rqj;
    public lz rqk;
    public lz rql;
    public lz rqm;
    public lz rqn;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rqj != null) {
                aVar.fV(1, this.rqj.boi());
                this.rqj.a(aVar);
            }
            if (this.rqk != null) {
                aVar.fV(2, this.rqk.boi());
                this.rqk.a(aVar);
            }
            if (this.rql != null) {
                aVar.fV(3, this.rql.boi());
                this.rql.a(aVar);
            }
            if (this.rqm != null) {
                aVar.fV(4, this.rqm.boi());
                this.rqm.a(aVar);
            }
            if (this.rqn == null) {
                return 0;
            }
            aVar.fV(5, this.rqn.boi());
            this.rqn.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.rqj != null) {
                fS = f.a.a.a.fS(1, this.rqj.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rqk != null) {
                fS += f.a.a.a.fS(2, this.rqk.boi());
            }
            if (this.rql != null) {
                fS += f.a.a.a.fS(3, this.rql.boi());
            }
            if (this.rqm != null) {
                fS += f.a.a.a.fS(4, this.rqm.boi());
            }
            if (this.rqn != null) {
                fS += f.a.a.a.fS(5, this.rqn.boi());
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
            ma maVar = (ma) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            lz lzVar;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        lzVar = new lz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lzVar.a(aVar4, lzVar, a.a(aVar4))) {
                        }
                        maVar.rqj = lzVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        lzVar = new lz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lzVar.a(aVar4, lzVar, a.a(aVar4))) {
                        }
                        maVar.rqk = lzVar;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        lzVar = new lz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lzVar.a(aVar4, lzVar, a.a(aVar4))) {
                        }
                        maVar.rql = lzVar;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        lzVar = new lz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lzVar.a(aVar4, lzVar, a.a(aVar4))) {
                        }
                        maVar.rqm = lzVar;
                    }
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        lzVar = new lz();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lzVar.a(aVar4, lzVar, a.a(aVar4))) {
                        }
                        maVar.rqn = lzVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
