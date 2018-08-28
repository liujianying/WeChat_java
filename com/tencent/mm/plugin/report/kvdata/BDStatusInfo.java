package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bk.a;
import java.util.LinkedList;

public class BDStatusInfo extends a {
    public long favDBSize_;
    public long mmDBSize_;
    public int mmDBTableCount_;
    public long snsDBSize_;
    public LinkedList<TableInfo> tableList_ = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            aVar.T(1, this.mmDBSize_);
            aVar.T(2, this.snsDBSize_);
            aVar.fT(3, this.mmDBTableCount_);
            aVar.d(4, 8, this.tableList_);
            aVar.T(5, this.favDBSize_);
            return 0;
        } else if (i == 1) {
            return ((((f.a.a.a.S(1, this.mmDBSize_) + 0) + f.a.a.a.S(2, this.snsDBSize_)) + f.a.a.a.fQ(3, this.mmDBTableCount_)) + f.a.a.a.c(4, 8, this.tableList_)) + f.a.a.a.S(5, this.favDBSize_);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.tableList_.clear();
                f.a.a.a.a aVar2 = new f.a.a.a.a(bArr, unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cJS();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
                BDStatusInfo bDStatusInfo = (BDStatusInfo) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        bDStatusInfo.mmDBSize_ = aVar3.vHC.rZ();
                        return 0;
                    case 2:
                        bDStatusInfo.snsDBSize_ = aVar3.vHC.rZ();
                        return 0;
                    case 3:
                        bDStatusInfo.mmDBTableCount_ = aVar3.vHC.rY();
                        return 0;
                    case 4:
                        LinkedList IC = aVar3.IC(intValue);
                        int size = IC.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) IC.get(intValue);
                            TableInfo tableInfo = new TableInfo();
                            f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = tableInfo.a(aVar4, tableInfo, a.a(aVar4))) {
                            }
                            bDStatusInfo.tableList_.add(tableInfo);
                        }
                        return 0;
                    case 5:
                        bDStatusInfo.favDBSize_ = aVar3.vHC.rZ();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
