package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;
import java.util.LinkedList;

public final class dx extends a {
    public String bHD;
    public String jPe;
    public String rei;
    public String rej;
    public dy rek;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.rek == null) {
                throw new b("Not all required fields were included: ArtisIcon");
            }
            if (this.jPe != null) {
                aVar.g(1, this.jPe);
            }
            if (this.bHD != null) {
                aVar.g(2, this.bHD);
            }
            if (this.rei != null) {
                aVar.g(3, this.rei);
            }
            if (this.rej != null) {
                aVar.g(4, this.rej);
            }
            if (this.rek == null) {
                return 0;
            }
            aVar.fV(5, this.rek.boi());
            this.rek.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.jPe != null) {
                h = f.a.a.b.b.a.h(1, this.jPe) + 0;
            } else {
                h = 0;
            }
            if (this.bHD != null) {
                h += f.a.a.b.b.a.h(2, this.bHD);
            }
            if (this.rei != null) {
                h += f.a.a.b.b.a.h(3, this.rei);
            }
            if (this.rej != null) {
                h += f.a.a.b.b.a.h(4, this.rej);
            }
            if (this.rek != null) {
                h += f.a.a.a.fS(5, this.rek.boi());
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.rek != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ArtisIcon");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            dx dxVar = (dx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dxVar.jPe = aVar3.vHC.readString();
                    return 0;
                case 2:
                    dxVar.bHD = aVar3.vHC.readString();
                    return 0;
                case 3:
                    dxVar.rei = aVar3.vHC.readString();
                    return 0;
                case 4:
                    dxVar.rej = aVar3.vHC.readString();
                    return 0;
                case 5:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        dy dyVar = new dy();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = dyVar.a(aVar4, dyVar, a.a(aVar4))) {
                        }
                        dxVar.rek = dyVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
