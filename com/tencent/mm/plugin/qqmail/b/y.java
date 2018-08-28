package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class y extends a {
    public long mea;
    public String meb;
    public String name;
    public String path;
    public long size;
    public int state;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.path == null) {
                throw new b("Not all required fields were included: path");
            } else if (this.name == null) {
                throw new b("Not all required fields were included: name");
            } else {
                if (this.path != null) {
                    aVar.g(1, this.path);
                }
                if (this.name != null) {
                    aVar.g(2, this.name);
                }
                aVar.T(3, this.size);
                aVar.fT(4, this.state);
                aVar.T(5, this.mea);
                if (this.meb == null) {
                    return 0;
                }
                aVar.g(6, this.meb);
                return 0;
            }
        } else if (i == 1) {
            if (this.path != null) {
                h = f.a.a.b.b.a.h(1, this.path) + 0;
            } else {
                h = 0;
            }
            if (this.name != null) {
                h += f.a.a.b.b.a.h(2, this.name);
            }
            h = ((h + f.a.a.a.S(3, this.size)) + f.a.a.a.fQ(4, this.state)) + f.a.a.a.S(5, this.mea);
            if (this.meb != null) {
                h += f.a.a.b.b.a.h(6, this.meb);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.path == null) {
                throw new b("Not all required fields were included: path");
            } else if (this.name != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: name");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            y yVar = (y) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    yVar.path = aVar3.vHC.readString();
                    return 0;
                case 2:
                    yVar.name = aVar3.vHC.readString();
                    return 0;
                case 3:
                    yVar.size = aVar3.vHC.rZ();
                    return 0;
                case 4:
                    yVar.state = aVar3.vHC.rY();
                    return 0;
                case 5:
                    yVar.mea = aVar3.vHC.rZ();
                    return 0;
                case 6:
                    yVar.meb = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
