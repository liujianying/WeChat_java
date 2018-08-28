package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bk.a;
import f.a.a.b;

public class TableInfo extends a {
    public long count_;
    public String name_;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.name_ == null) {
                throw new b("Not all required fields were included: name_");
            }
            if (this.name_ != null) {
                aVar.g(1, this.name_);
            }
            aVar.T(2, this.count_);
            return 0;
        } else if (i == 1) {
            if (this.name_ != null) {
                h = f.a.a.b.b.a.h(1, this.name_) + 0;
            } else {
                h = 0;
            }
            return h + f.a.a.a.S(2, this.count_);
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            if (this.name_ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: name_");
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            TableInfo tableInfo = (TableInfo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tableInfo.name_ = aVar3.vHC.readString();
                    return 0;
                case 2:
                    tableInfo.count_ = aVar3.vHC.rZ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
