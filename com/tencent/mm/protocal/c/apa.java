package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class apa extends bhp {
    public b hbs;
    public String jSv;
    public aof rRd;
    public bio rRk;
    public String rbh;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new f.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            if (this.rRd != null) {
                aVar.fV(2, this.rRd.boi());
                this.rRd.a(aVar);
            }
            if (this.hbs != null) {
                aVar.b(3, this.hbs);
            }
            if (this.rRk != null) {
                aVar.fV(4, this.rRk.boi());
                this.rRk.a(aVar);
            }
            if (this.jSv != null) {
                aVar.g(5, this.jSv);
            }
            if (this.rbh == null) {
                return 0;
            }
            aVar.g(6, this.rbh);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rRd != null) {
                fS += f.a.a.a.fS(2, this.rRd.boi());
            }
            if (this.hbs != null) {
                fS += f.a.a.a.a(3, this.hbs);
            }
            if (this.rRk != null) {
                fS += f.a.a.a.fS(4, this.rRk.boi());
            }
            if (this.jSv != null) {
                fS += f.a.a.b.b.a.h(5, this.jSv);
            }
            if (this.rbh != null) {
                fS += f.a.a.b.b.a.h(6, this.rbh);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six != null) {
                return 0;
            }
            throw new f.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            apa apa = (apa) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        fl flVar = new fl();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        apa.six = flVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        aof aof = new aof();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aof.a(aVar4, aof, bhp.a(aVar4))) {
                        }
                        apa.rRd = aof;
                    }
                    return 0;
                case 3:
                    apa.hbs = aVar3.cJR();
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bio bio = new bio();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bio.a(aVar4, bio, bhp.a(aVar4))) {
                        }
                        apa.rRk = bio;
                    }
                    return 0;
                case 5:
                    apa.jSv = aVar3.vHC.readString();
                    return 0;
                case 6:
                    apa.rbh = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
