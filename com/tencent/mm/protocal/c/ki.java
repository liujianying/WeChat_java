package com.tencent.mm.protocal.c;

import f.a.a.c.a;
import java.util.LinkedList;

public final class ki extends bhd {
    public String jQb;
    public String jTu;
    public String jTv;
    public int otY;
    public String raM;
    public String raN;
    public String raO;
    public String rco;
    public int rdq;
    public int rmA;
    public int rmB;
    public String rmn;
    public int rmo;
    public int rmp;
    public bhy rmq;
    public float rmr;
    public float rms;
    public String rmt;
    public int rmu;
    public int rmv;
    public int rmw;
    public int rmx;
    public String rmy;
    public int rmz;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.rmn != null) {
                aVar.g(1, this.rmn);
            }
            if (this.jTv != null) {
                aVar.g(2, this.jTv);
            }
            if (this.jTu != null) {
                aVar.g(3, this.jTu);
            }
            aVar.fT(4, this.rmo);
            aVar.fT(5, this.rmp);
            if (this.rco != null) {
                aVar.g(6, this.rco);
            }
            if (this.rmq != null) {
                aVar.fV(7, this.rmq.boi());
                this.rmq.a(aVar);
            }
            aVar.fT(8, this.otY);
            aVar.l(9, this.rmr);
            aVar.l(10, this.rms);
            if (this.rmt != null) {
                aVar.g(11, this.rmt);
            }
            aVar.fT(12, this.rmu);
            aVar.fT(13, this.rmv);
            aVar.fT(14, this.rmw);
            aVar.fT(15, this.rmx);
            if (this.rmy != null) {
                aVar.g(16, this.rmy);
            }
            aVar.fT(17, this.rmz);
            aVar.fT(18, this.rmA);
            aVar.fT(19, this.rmB);
            aVar.fT(20, this.rdq);
            if (this.jQb != null) {
                aVar.g(21, this.jQb);
            }
            if (this.raO != null) {
                aVar.g(22, this.raO);
            }
            if (this.raN != null) {
                aVar.g(23, this.raN);
            }
            if (this.raM == null) {
                return 0;
            }
            aVar.g(24, this.raM);
            return 0;
        } else if (i == 1) {
            if (this.rmn != null) {
                h = f.a.a.b.b.a.h(1, this.rmn) + 0;
            } else {
                h = 0;
            }
            if (this.jTv != null) {
                h += f.a.a.b.b.a.h(2, this.jTv);
            }
            if (this.jTu != null) {
                h += f.a.a.b.b.a.h(3, this.jTu);
            }
            h = (h + f.a.a.a.fQ(4, this.rmo)) + f.a.a.a.fQ(5, this.rmp);
            if (this.rco != null) {
                h += f.a.a.b.b.a.h(6, this.rco);
            }
            if (this.rmq != null) {
                h += f.a.a.a.fS(7, this.rmq.boi());
            }
            h = ((h + f.a.a.a.fQ(8, this.otY)) + (f.a.a.b.b.a.ec(9) + 4)) + (f.a.a.b.b.a.ec(10) + 4);
            if (this.rmt != null) {
                h += f.a.a.b.b.a.h(11, this.rmt);
            }
            h = (((h + f.a.a.a.fQ(12, this.rmu)) + f.a.a.a.fQ(13, this.rmv)) + f.a.a.a.fQ(14, this.rmw)) + f.a.a.a.fQ(15, this.rmx);
            if (this.rmy != null) {
                h += f.a.a.b.b.a.h(16, this.rmy);
            }
            h = (((h + f.a.a.a.fQ(17, this.rmz)) + f.a.a.a.fQ(18, this.rmA)) + f.a.a.a.fQ(19, this.rmB)) + f.a.a.a.fQ(20, this.rdq);
            if (this.jQb != null) {
                h += f.a.a.b.b.a.h(21, this.jQb);
            }
            if (this.raO != null) {
                h += f.a.a.b.b.a.h(22, this.raO);
            }
            if (this.raN != null) {
                h += f.a.a.b.b.a.h(23, this.raN);
            }
            if (this.raM != null) {
                h += f.a.a.b.b.a.h(24, this.raM);
            }
            return h;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = bhd.a(aVar2); h > 0; h = bhd.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            ki kiVar = (ki) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    kiVar.rmn = aVar3.vHC.readString();
                    return 0;
                case 2:
                    kiVar.jTv = aVar3.vHC.readString();
                    return 0;
                case 3:
                    kiVar.jTu = aVar3.vHC.readString();
                    return 0;
                case 4:
                    kiVar.rmo = aVar3.vHC.rY();
                    return 0;
                case 5:
                    kiVar.rmp = aVar3.vHC.rY();
                    return 0;
                case 6:
                    kiVar.rco = aVar3.vHC.readString();
                    return 0;
                case 7:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        bhy bhy = new bhy();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bhy.a(aVar4, bhy, bhd.a(aVar4))) {
                        }
                        kiVar.rmq = bhy;
                    }
                    return 0;
                case 8:
                    kiVar.otY = aVar3.vHC.rY();
                    return 0;
                case 9:
                    kiVar.rmr = aVar3.vHC.readFloat();
                    return 0;
                case 10:
                    kiVar.rms = aVar3.vHC.readFloat();
                    return 0;
                case 11:
                    kiVar.rmt = aVar3.vHC.readString();
                    return 0;
                case 12:
                    kiVar.rmu = aVar3.vHC.rY();
                    return 0;
                case 13:
                    kiVar.rmv = aVar3.vHC.rY();
                    return 0;
                case 14:
                    kiVar.rmw = aVar3.vHC.rY();
                    return 0;
                case 15:
                    kiVar.rmx = aVar3.vHC.rY();
                    return 0;
                case 16:
                    kiVar.rmy = aVar3.vHC.readString();
                    return 0;
                case 17:
                    kiVar.rmz = aVar3.vHC.rY();
                    return 0;
                case 18:
                    kiVar.rmA = aVar3.vHC.rY();
                    return 0;
                case 19:
                    kiVar.rmB = aVar3.vHC.rY();
                    return 0;
                case 20:
                    kiVar.rdq = aVar3.vHC.rY();
                    return 0;
                case 21:
                    kiVar.jQb = aVar3.vHC.readString();
                    return 0;
                case 22:
                    kiVar.raO = aVar3.vHC.readString();
                    return 0;
                case 23:
                    kiVar.raN = aVar3.vHC.readString();
                    return 0;
                case 24:
                    kiVar.raM = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
