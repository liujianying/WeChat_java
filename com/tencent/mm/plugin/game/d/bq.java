package com.tencent.mm.plugin.game.d;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public final class bq extends a {
    public String desc;
    public LinkedList<by> hyy = new LinkedList();
    public String summary;
    public String title;
    public String url;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.summary != null) {
                aVar.g(1, this.summary);
            }
            if (this.desc != null) {
                aVar.g(2, this.desc);
            }
            aVar.d(3, 8, this.hyy);
            if (this.url != null) {
                aVar.g(4, this.url);
            }
            if (this.title == null) {
                return 0;
            }
            aVar.g(5, this.title);
            return 0;
        } else if (i == 1) {
            if (this.summary != null) {
                h = f.a.a.b.b.a.h(1, this.summary) + 0;
            } else {
                h = 0;
            }
            if (this.desc != null) {
                h += f.a.a.b.b.a.h(2, this.desc);
            }
            h += f.a.a.a.c(3, 8, this.hyy);
            if (this.url != null) {
                h += f.a.a.b.b.a.h(4, this.url);
            }
            if (this.title != null) {
                h += f.a.a.b.b.a.h(5, this.title);
            }
            return h;
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.hyy.clear();
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
            bq bqVar = (bq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bqVar.summary = aVar3.vHC.readString();
                    return 0;
                case 2:
                    bqVar.desc = aVar3.vHC.readString();
                    return 0;
                case 3:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) IC.get(intValue);
                        by byVar = new by();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = byVar.a(aVar4, byVar, a.a(aVar4))) {
                        }
                        bqVar.hyy.add(byVar);
                    }
                    return 0;
                case 4:
                    bqVar.url = aVar3.vHC.readString();
                    return 0;
                case 5:
                    bqVar.title = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
