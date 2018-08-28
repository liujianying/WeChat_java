package com.tencent.mm.protocal.c;

import f.a.a.b;
import f.a.a.c.a;
import java.util.LinkedList;

public final class aha extends bhd {
    public int Height;
    public String URL;
    public int Width;
    public String rKq;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.URL == null) {
                throw new b("Not all required fields were included: URL");
            } else if (this.rKq == null) {
                throw new b("Not all required fields were included: UserAgent");
            } else {
                if (this.shX != null) {
                    aVar.fV(1, this.shX.boi());
                    this.shX.a(aVar);
                }
                if (this.URL != null) {
                    aVar.g(2, this.URL);
                }
                if (this.rKq != null) {
                    aVar.g(3, this.rKq);
                }
                aVar.fT(4, this.Width);
                aVar.fT(5, this.Height);
                return 0;
            }
        } else if (i == 1) {
            if (this.shX != null) {
                fS = f.a.a.a.fS(1, this.shX.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.URL != null) {
                fS += f.a.a.b.b.a.h(2, this.URL);
            }
            if (this.rKq != null) {
                fS += f.a.a.b.b.a.h(3, this.rKq);
            }
            return (fS + f.a.a.a.fQ(4, this.Width)) + f.a.a.a.fQ(5, this.Height);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhd.a(aVar2); fS > 0; fS = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.URL == null) {
                throw new b("Not all required fields were included: URL");
            } else if (this.rKq != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: UserAgent");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            aha aha = (aha) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fk fkVar = new fk();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fkVar.a(aVar4, fkVar, bhd.a(aVar4))) {
                        }
                        aha.shX = fkVar;
                    }
                    return 0;
                case 2:
                    aha.URL = aVar3.vHC.readString();
                    return 0;
                case 3:
                    aha.rKq = aVar3.vHC.readString();
                    return 0;
                case 4:
                    aha.Width = aVar3.vHC.rY();
                    return 0;
                case 5:
                    aha.Height = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
