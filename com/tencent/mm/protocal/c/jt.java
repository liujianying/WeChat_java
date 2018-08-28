package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class jt extends a {
    public String hcS;
    public String jOU;
    public jv rlg;
    public bjv rlj;
    public ka rlk;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.hcS == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.rlj == null) {
                throw new b("Not all required fields were included: ContactItem");
            } else {
                if (this.hcS != null) {
                    aVar.g(1, this.hcS);
                }
                if (this.rlg != null) {
                    aVar.fV(2, this.rlg.boi());
                    this.rlg.a(aVar);
                }
                if (this.rlj != null) {
                    aVar.fV(3, this.rlj.boi());
                    this.rlj.a(aVar);
                }
                if (this.rlk != null) {
                    aVar.fV(4, this.rlk.boi());
                    this.rlk.a(aVar);
                }
                if (this.jOU == null) {
                    return 0;
                }
                aVar.g(5, this.jOU);
                return 0;
            }
        } else if (i == 1) {
            if (this.hcS != null) {
                h = f.a.a.b.b.a.h(1, this.hcS) + 0;
            } else {
                h = 0;
            }
            if (this.rlg != null) {
                h += f.a.a.a.fS(2, this.rlg.boi());
            }
            if (this.rlj != null) {
                h += f.a.a.a.fS(3, this.rlj.boi());
            }
            if (this.rlk != null) {
                h += f.a.a.a.fS(4, this.rlk.boi());
            }
            if (this.jOU != null) {
                h += f.a.a.b.b.a.h(5, this.jOU);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.hcS == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.rlj != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ContactItem");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            jt jtVar = (jt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList IC;
            int size;
            byte[] bArr;
            f.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    jtVar.hcS = aVar3.vHC.readString();
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        jv jvVar = new jv();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = jvVar.a(aVar4, jvVar, a.a(aVar4))) {
                        }
                        jtVar.rlg = jvVar;
                    }
                    return 0;
                case 3:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        bjv bjv = new bjv();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bjv.a(aVar4, bjv, a.a(aVar4))) {
                        }
                        jtVar.rlj = bjv;
                    }
                    return 0;
                case 4:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        ka kaVar = new ka();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = kaVar.a(aVar4, kaVar, a.a(aVar4))) {
                        }
                        jtVar.rlk = kaVar;
                    }
                    return 0;
                case 5:
                    jtVar.jOU = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
