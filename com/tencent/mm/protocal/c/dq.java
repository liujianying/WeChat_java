package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;
import java.util.LinkedList;

public final class dq extends a {
    public dr rdN;
    public ds rdT;
    public b rdU;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rdT == null) {
                throw new f.a.a.b("Not all required fields were included: VoiceAttr");
            } else if (this.rdN == null) {
                throw new f.a.a.b("Not all required fields were included: UploadCtx");
            } else if (this.rdU == null) {
                throw new f.a.a.b("Not all required fields were included: VoiceData");
            } else {
                if (this.rdT != null) {
                    aVar.fV(1, this.rdT.boi());
                    this.rdT.a(aVar);
                }
                if (this.rdN != null) {
                    aVar.fV(2, this.rdN.boi());
                    this.rdN.a(aVar);
                }
                if (this.rdU == null) {
                    return 0;
                }
                aVar.b(3, this.rdU);
                return 0;
            }
        } else if (i == 1) {
            if (this.rdT != null) {
                fS = f.a.a.a.fS(1, this.rdT.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.rdN != null) {
                fS += f.a.a.a.fS(2, this.rdN.boi());
            }
            if (this.rdU != null) {
                fS += f.a.a.a.a(3, this.rdU);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = a.a(aVar2); fS > 0; fS = a.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            if (this.rdT == null) {
                throw new f.a.a.b("Not all required fields were included: VoiceAttr");
            } else if (this.rdN == null) {
                throw new f.a.a.b("Not all required fields were included: UploadCtx");
            } else if (this.rdU != null) {
                return 0;
            } else {
                throw new f.a.a.b("Not all required fields were included: VoiceData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            dq dqVar = (dq) objArr[1];
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
                        ds dsVar = new ds();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dsVar.a(aVar4, dsVar, a.a(aVar4))) {
                        }
                        dqVar.rdT = dsVar;
                    }
                    return 0;
                case 2:
                    IC = aVar3.IC(intValue);
                    size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        dr drVar = new dr();
                        aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = drVar.a(aVar4, drVar, a.a(aVar4))) {
                        }
                        dqVar.rdN = drVar;
                    }
                    return 0;
                case 3:
                    dqVar.rdU = aVar3.cJR();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
