package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class tc extends a {
    public int hcE;
    public String jTu;
    public String rco;
    public int rdV;
    public int rdW;
    public String rwt;
    public bhy rwu;
    public String rwv;
    public String rww;
    public String rwx;
    public int rwy;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rwu == null) {
                throw new b("Not all required fields were included: EmojiBuffer");
            }
            if (this.rwt != null) {
                aVar.g(1, this.rwt);
            }
            aVar.fT(2, this.rdW);
            aVar.fT(3, this.rdV);
            if (this.rwu != null) {
                aVar.fV(4, this.rwu.boi());
                this.rwu.a(aVar);
            }
            aVar.fT(5, this.hcE);
            if (this.jTu != null) {
                aVar.g(6, this.jTu);
            }
            if (this.rwv != null) {
                aVar.g(7, this.rwv);
            }
            if (this.rww != null) {
                aVar.g(8, this.rww);
            }
            if (this.rwx != null) {
                aVar.g(9, this.rwx);
            }
            if (this.rco != null) {
                aVar.g(10, this.rco);
            }
            aVar.fT(11, this.rwy);
            return 0;
        } else if (i == 1) {
            if (this.rwt != null) {
                h = f.a.a.b.b.a.h(1, this.rwt) + 0;
            } else {
                h = 0;
            }
            h = (h + f.a.a.a.fQ(2, this.rdW)) + f.a.a.a.fQ(3, this.rdV);
            if (this.rwu != null) {
                h += f.a.a.a.fS(4, this.rwu.boi());
            }
            h += f.a.a.a.fQ(5, this.hcE);
            if (this.jTu != null) {
                h += f.a.a.b.b.a.h(6, this.jTu);
            }
            if (this.rwv != null) {
                h += f.a.a.b.b.a.h(7, this.rwv);
            }
            if (this.rww != null) {
                h += f.a.a.b.b.a.h(8, this.rww);
            }
            if (this.rwx != null) {
                h += f.a.a.b.b.a.h(9, this.rwx);
            }
            if (this.rco != null) {
                h += f.a.a.b.b.a.h(10, this.rco);
            }
            return h + f.a.a.a.fQ(11, this.rwy);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.rwu != null) {
                return 0;
            }
            throw new b("Not all required fields were included: EmojiBuffer");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            tc tcVar = (tc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    tcVar.rwt = aVar3.vHC.readString();
                    return 0;
                case 2:
                    tcVar.rdW = aVar3.vHC.rY();
                    return 0;
                case 3:
                    tcVar.rdV = aVar3.vHC.rY();
                    return 0;
                case 4:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        a bhy = new bhy();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bhy.a(aVar4, bhy, a.a(aVar4))) {
                        }
                        tcVar.rwu = bhy;
                    }
                    return 0;
                case 5:
                    tcVar.hcE = aVar3.vHC.rY();
                    return 0;
                case 6:
                    tcVar.jTu = aVar3.vHC.readString();
                    return 0;
                case 7:
                    tcVar.rwv = aVar3.vHC.readString();
                    return 0;
                case 8:
                    tcVar.rww = aVar3.vHC.readString();
                    return 0;
                case 9:
                    tcVar.rwx = aVar3.vHC.readString();
                    return 0;
                case 10:
                    tcVar.rco = aVar3.vHC.readString();
                    return 0;
                case 11:
                    tcVar.rwy = aVar3.vHC.rY();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
