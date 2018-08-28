package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class wc extends a {
    public String appId;
    public String bGy;
    public String bSS;
    public wl bXO;
    public String desc;
    public String rBs;
    public LinkedList<String> rBt = new LinkedList();
    public String title;
    public int type;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.g(1, this.title);
            }
            if (this.desc != null) {
                aVar.g(2, this.desc);
            }
            if (this.bSS != null) {
                aVar.g(3, this.bSS);
            }
            if (this.rBs != null) {
                aVar.g(4, this.rBs);
            }
            if (this.appId != null) {
                aVar.g(5, this.appId);
            }
            if (this.bGy != null) {
                aVar.g(6, this.bGy);
            }
            aVar.d(7, 1, this.rBt);
            aVar.fT(8, this.type);
            if (this.bXO == null) {
                return 0;
            }
            aVar.fV(9, this.bXO.boi());
            this.bXO.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                h = f.a.a.b.b.a.h(1, this.title) + 0;
            } else {
                h = 0;
            }
            if (this.desc != null) {
                h += f.a.a.b.b.a.h(2, this.desc);
            }
            if (this.bSS != null) {
                h += f.a.a.b.b.a.h(3, this.bSS);
            }
            if (this.rBs != null) {
                h += f.a.a.b.b.a.h(4, this.rBs);
            }
            if (this.appId != null) {
                h += f.a.a.b.b.a.h(5, this.appId);
            }
            if (this.bGy != null) {
                h += f.a.a.b.b.a.h(6, this.bGy);
            }
            h = (h + f.a.a.a.c(7, 1, this.rBt)) + f.a.a.a.fQ(8, this.type);
            if (this.bXO != null) {
                h += f.a.a.a.fS(9, this.bXO.boi());
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.rBt.clear();
            f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
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
            wc wcVar = (wc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    wcVar.title = aVar3.vHC.readString();
                    return 0;
                case 2:
                    wcVar.desc = aVar3.vHC.readString();
                    return 0;
                case 3:
                    wcVar.bSS = aVar3.vHC.readString();
                    return 0;
                case 4:
                    wcVar.rBs = aVar3.vHC.readString();
                    return 0;
                case 5:
                    wcVar.appId = aVar3.vHC.readString();
                    return 0;
                case 6:
                    wcVar.bGy = aVar3.vHC.readString();
                    return 0;
                case 7:
                    wcVar.rBt.add(aVar3.vHC.readString());
                    return 0;
                case 8:
                    wcVar.type = aVar3.vHC.rY();
                    return 0;
                case 9:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        wl wlVar = new wl();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = wlVar.a(aVar4, wlVar, a.a(aVar4))) {
                        }
                        wcVar.bXO = wlVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
