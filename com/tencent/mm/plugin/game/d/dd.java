package com.tencent.mm.plugin.game.d;

import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.protocal.c.fl;
import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class dd extends bhp {
    public String bHD;
    public String jPH;
    public boolean jPk;
    public l jTs;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.bHD == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.jPH == null) {
                throw new b("Not all required fields were included: Message");
            } else {
                if (this.six != null) {
                    aVar.fV(1, this.six.boi());
                    this.six.a(aVar);
                }
                aVar.av(2, this.jPk);
                if (this.bHD != null) {
                    aVar.g(3, this.bHD);
                }
                if (this.jPH != null) {
                    aVar.g(4, this.jPH);
                }
                if (this.jTs == null) {
                    return 0;
                }
                aVar.fV(5, this.jTs.boi());
                this.jTs.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            fS += f.a.a.b.b.a.ec(2) + 1;
            if (this.bHD != null) {
                fS += f.a.a.b.b.a.h(3, this.bHD);
            }
            if (this.jPH != null) {
                fS += f.a.a.b.b.a.h(4, this.jPH);
            }
            if (this.jTs != null) {
                fS += f.a.a.a.fS(5, this.jTs.boi());
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.six == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.bHD == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.jPH != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Message");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            dd ddVar = (dd) objArr[1];
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
                        ddVar.six = flVar;
                    }
                    return 0;
                case 2:
                    ddVar.jPk = aVar3.cJQ();
                    return 0;
                case 3:
                    ddVar.bHD = aVar3.vHC.readString();
                    return 0;
                case 4:
                    ddVar.jPH = aVar3.vHC.readString();
                    return 0;
                case 5:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        l lVar = new l();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lVar.a(aVar4, lVar, bhp.a(aVar4))) {
                        }
                        ddVar.jTs = lVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
