package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class q extends a {
    public String jPS;
    public String jPT;
    public String jPU;
    public dm jPV;
    public int jPW;
    public int jPX;
    public String jPY;
    public int jPZ;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.jPS == null) {
                throw new b("Not all required fields were included: DownloadURL");
            }
            if (this.jPS != null) {
                aVar.g(1, this.jPS);
            }
            if (this.jPT != null) {
                aVar.g(2, this.jPT);
            }
            if (this.jPU != null) {
                aVar.g(4, this.jPU);
            }
            if (this.jPV != null) {
                aVar.fV(5, this.jPV.boi());
                this.jPV.a(aVar);
            }
            aVar.fT(6, this.jPW);
            aVar.fT(7, this.jPX);
            if (this.jPY != null) {
                aVar.g(8, this.jPY);
            }
            aVar.fT(9, this.jPZ);
            return 0;
        } else if (i == 1) {
            if (this.jPS != null) {
                h = f.a.a.b.b.a.h(1, this.jPS) + 0;
            } else {
                h = 0;
            }
            if (this.jPT != null) {
                h += f.a.a.b.b.a.h(2, this.jPT);
            }
            if (this.jPU != null) {
                h += f.a.a.b.b.a.h(4, this.jPU);
            }
            if (this.jPV != null) {
                h += f.a.a.a.fS(5, this.jPV.boi());
            }
            h = (h + f.a.a.a.fQ(6, this.jPW)) + f.a.a.a.fQ(7, this.jPX);
            if (this.jPY != null) {
                h += f.a.a.b.b.a.h(8, this.jPY);
            }
            return h + f.a.a.a.fQ(9, this.jPZ);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.jPS != null) {
                return 0;
            }
            throw new b("Not all required fields were included: DownloadURL");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            q qVar = (q) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    qVar.jPS = aVar3.vHC.readString();
                    return 0;
                case 2:
                    qVar.jPT = aVar3.vHC.readString();
                    return 0;
                case 4:
                    qVar.jPU = aVar3.vHC.readString();
                    return 0;
                case 5:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        dm dmVar = new dm();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dmVar.a(aVar4, dmVar, a.a(aVar4))) {
                        }
                        qVar.jPV = dmVar;
                    }
                    return 0;
                case 6:
                    qVar.jPW = aVar3.vHC.rY();
                    return 0;
                case 7:
                    qVar.jPX = aVar3.vHC.rY();
                    return 0;
                case 8:
                    qVar.jPY = aVar3.vHC.readString();
                    return 0;
                case 9:
                    qVar.jPZ = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
