package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import f.a.a.b;

public final class bqt extends a {
    public int egR;
    public int egS;
    public int egT;
    public int egU;
    public int opType;
    public String soR;
    public String soS;
    public String soT;
    public String soU;
    public long timeStamp;

    protected final int a(int i, Object... objArr) {
        int fQ;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.soR == null) {
                throw new b("Not all required fields were included: StatusDesc1");
            } else if (this.soS == null) {
                throw new b("Not all required fields were included: StatusDesc2");
            } else if (this.soT == null) {
                throw new b("Not all required fields were included: DataFlowSourceInfo");
            } else if (this.soU == null) {
                throw new b("Not all required fields were included: DataFlowResultInfo");
            } else {
                aVar.fT(1, this.opType);
                aVar.fT(2, this.egU);
                aVar.fT(3, this.egR);
                aVar.T(4, this.timeStamp);
                aVar.fT(5, this.egS);
                aVar.fT(6, this.egT);
                if (this.soR != null) {
                    aVar.g(7, this.soR);
                }
                if (this.soS != null) {
                    aVar.g(8, this.soS);
                }
                if (this.soT != null) {
                    aVar.g(9, this.soT);
                }
                if (this.soU != null) {
                    aVar.g(10, this.soU);
                }
                return 0;
            }
        } else if (i == 1) {
            fQ = (((((f.a.a.a.fQ(1, this.opType) + 0) + f.a.a.a.fQ(2, this.egU)) + f.a.a.a.fQ(3, this.egR)) + f.a.a.a.S(4, this.timeStamp)) + f.a.a.a.fQ(5, this.egS)) + f.a.a.a.fQ(6, this.egT);
            if (this.soR != null) {
                fQ += f.a.a.b.b.a.h(7, this.soR);
            }
            if (this.soS != null) {
                fQ += f.a.a.b.b.a.h(8, this.soS);
            }
            if (this.soT != null) {
                fQ += f.a.a.b.b.a.h(9, this.soT);
            }
            if (this.soU != null) {
                return fQ + f.a.a.b.b.a.h(10, this.soU);
            }
            return fQ;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fQ = a.a(aVar2); fQ > 0; fQ = a.a(aVar2)) {
                if (!super.a(aVar2, this, fQ)) {
                    aVar2.cJS();
                }
            }
            if (this.soR == null) {
                throw new b("Not all required fields were included: StatusDesc1");
            } else if (this.soS == null) {
                throw new b("Not all required fields were included: StatusDesc2");
            } else if (this.soT == null) {
                throw new b("Not all required fields were included: DataFlowSourceInfo");
            } else if (this.soU != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: DataFlowResultInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            bqt bqt = (bqt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bqt.opType = aVar3.vHC.rY();
                    return 0;
                case 2:
                    bqt.egU = aVar3.vHC.rY();
                    return 0;
                case 3:
                    bqt.egR = aVar3.vHC.rY();
                    return 0;
                case 4:
                    bqt.timeStamp = aVar3.vHC.rZ();
                    return 0;
                case 5:
                    bqt.egS = aVar3.vHC.rY();
                    return 0;
                case 6:
                    bqt.egT = aVar3.vHC.rY();
                    return 0;
                case 7:
                    bqt.soR = aVar3.vHC.readString();
                    return 0;
                case 8:
                    bqt.soS = aVar3.vHC.readString();
                    return 0;
                case 9:
                    bqt.soT = aVar3.vHC.readString();
                    return 0;
                case 10:
                    bqt.soU = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
