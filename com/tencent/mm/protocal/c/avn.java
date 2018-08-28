package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class avn extends a {
    public String content;
    public String lang;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.lang == null) {
                throw new b("Not all required fields were included: lang");
            } else if (this.content == null) {
                throw new b("Not all required fields were included: content");
            } else {
                if (this.lang != null) {
                    aVar.g(1, this.lang);
                }
                if (this.content == null) {
                    return 0;
                }
                aVar.g(2, this.content);
                return 0;
            }
        } else if (i == 1) {
            if (this.lang != null) {
                h = f.a.a.b.b.a.h(1, this.lang) + 0;
            } else {
                h = 0;
            }
            if (this.content != null) {
                h += f.a.a.b.b.a.h(2, this.content);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.lang == null) {
                throw new b("Not all required fields were included: lang");
            } else if (this.content != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: content");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            avn avn = (avn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    avn.lang = aVar3.vHC.readString();
                    return 0;
                case 2:
                    avn.content = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
