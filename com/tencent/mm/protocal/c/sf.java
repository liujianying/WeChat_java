package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;

public final class sf extends a {
    public String deviceBrand;
    public String deviceModel;
    public String osName;
    public String osVersion;
    public String rvD;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.deviceModel != null) {
                aVar.g(1, this.deviceModel);
            }
            if (this.deviceBrand != null) {
                aVar.g(2, this.deviceBrand);
            }
            if (this.osName != null) {
                aVar.g(3, this.osName);
            }
            if (this.osVersion != null) {
                aVar.g(4, this.osVersion);
            }
            if (this.rvD == null) {
                return 0;
            }
            aVar.g(5, this.rvD);
            return 0;
        } else if (i == 1) {
            if (this.deviceModel != null) {
                h = f.a.a.b.b.a.h(1, this.deviceModel) + 0;
            } else {
                h = 0;
            }
            if (this.deviceBrand != null) {
                h += f.a.a.b.b.a.h(2, this.deviceBrand);
            }
            if (this.osName != null) {
                h += f.a.a.b.b.a.h(3, this.osName);
            }
            if (this.osVersion != null) {
                h += f.a.a.b.b.a.h(4, this.osVersion);
            }
            if (this.rvD != null) {
                h += f.a.a.b.b.a.h(5, this.rvD);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            sf sfVar = (sf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    sfVar.deviceModel = aVar3.vHC.readString();
                    return 0;
                case 2:
                    sfVar.deviceBrand = aVar3.vHC.readString();
                    return 0;
                case 3:
                    sfVar.osName = aVar3.vHC.readString();
                    return 0;
                case 4:
                    sfVar.osVersion = aVar3.vHC.readString();
                    return 0;
                case 5:
                    sfVar.rvD = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
