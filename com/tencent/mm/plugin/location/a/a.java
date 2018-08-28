package com.tencent.mm.plugin.location.a;

import f.a.a.b;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bk.a {
    public LinkedList<String> bUb = new LinkedList();
    public String kCs;
    public double latitude;
    public double longitude;
    public long timestamp;
    public String username;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.username == null) {
                throw new b("Not all required fields were included: username");
            }
            if (this.username != null) {
                aVar.g(1, this.username);
            }
            aVar.d(2, 1, this.bUb);
            aVar.c(3, this.longitude);
            aVar.c(4, this.latitude);
            if (this.kCs != null) {
                aVar.g(5, this.kCs);
            }
            aVar.T(6, this.timestamp);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                h = f.a.a.b.b.a.h(1, this.username) + 0;
            } else {
                h = 0;
            }
            h = ((h + f.a.a.a.c(2, 1, this.bUb)) + (f.a.a.b.b.a.ec(3) + 8)) + (f.a.a.b.b.a.ec(4) + 8);
            if (this.kCs != null) {
                h += f.a.a.b.b.a.h(5, this.kCs);
            }
            return h + f.a.a.a.S(6, this.timestamp);
        } else if (i == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.bUb.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
            for (h = com.tencent.mm.bk.a.a(aVar2); h > 0; h = com.tencent.mm.bk.a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.username != null) {
                return 0;
            }
            throw new b("Not all required fields were included: username");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.username = aVar3.vHC.readString();
                    return 0;
                case 2:
                    aVar4.bUb.add(aVar3.vHC.readString());
                    return 0;
                case 3:
                    aVar4.longitude = aVar3.vHC.readDouble();
                    return 0;
                case 4:
                    aVar4.latitude = aVar3.vHC.readDouble();
                    return 0;
                case 5:
                    aVar4.kCs = aVar3.vHC.readString();
                    return 0;
                case 6:
                    aVar4.timestamp = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
