package com.tencent.mm.protocal.c;

import com.tencent.mm.plugin.sns.i$l;
import f.a.a.c.a;
import java.util.LinkedList;

public final class abi extends bhp {
    public String content;
    public String dxh;
    public String huU;
    public String hvV;
    public String hvW;
    public String qZX;
    public String qZY;
    public String qZZ;
    public String raa;
    public String rab;
    public String rac;
    public String rad;
    public String rae;
    public String raf;
    public String rag;
    public String rah;
    public String rai;
    public boolean raj = false;
    public int rak;
    public int ral;
    public int ram;
    public String ran;
    public String rao;
    public int rap;
    public String raq;
    public String rar;
    public String ras;
    public String rat;
    public String rau;
    public String rav;
    public String raw;
    public String rax;

    protected final int a(int i, Object... objArr) {
        int fS;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.six != null) {
                aVar.fV(1, this.six.boi());
                this.six.a(aVar);
            }
            if (this.qZX != null) {
                aVar.g(2, this.qZX);
            }
            if (this.qZY != null) {
                aVar.g(3, this.qZY);
            }
            if (this.qZZ != null) {
                aVar.g(4, this.qZZ);
            }
            if (this.content != null) {
                aVar.g(5, this.content);
            }
            if (this.raa != null) {
                aVar.g(6, this.raa);
            }
            if (this.rab != null) {
                aVar.g(7, this.rab);
            }
            if (this.rac != null) {
                aVar.g(8, this.rac);
            }
            if (this.rad != null) {
                aVar.g(9, this.rad);
            }
            if (this.rae != null) {
                aVar.g(10, this.rae);
            }
            if (this.raf != null) {
                aVar.g(11, this.raf);
            }
            if (this.rag != null) {
                aVar.g(12, this.rag);
            }
            if (this.rah != null) {
                aVar.g(13, this.rah);
            }
            if (this.hvV != null) {
                aVar.g(14, this.hvV);
            }
            if (this.hvW != null) {
                aVar.g(15, this.hvW);
            }
            if (this.rai != null) {
                aVar.g(16, this.rai);
            }
            aVar.av(17, this.raj);
            aVar.fT(18, this.rak);
            aVar.fT(19, this.ral);
            aVar.fT(20, this.ram);
            if (this.dxh != null) {
                aVar.g(21, this.dxh);
            }
            if (this.ran != null) {
                aVar.g(22, this.ran);
            }
            if (this.rao != null) {
                aVar.g(23, this.rao);
            }
            aVar.fT(24, this.rap);
            if (this.raq != null) {
                aVar.g(25, this.raq);
            }
            if (this.rar != null) {
                aVar.g(26, this.rar);
            }
            if (this.ras != null) {
                aVar.g(27, this.ras);
            }
            if (this.rat != null) {
                aVar.g(28, this.rat);
            }
            if (this.rau != null) {
                aVar.g(29, this.rau);
            }
            if (this.rav != null) {
                aVar.g(30, this.rav);
            }
            if (this.raw != null) {
                aVar.g(31, this.raw);
            }
            if (this.huU != null) {
                aVar.g(32, this.huU);
            }
            if (this.rax == null) {
                return 0;
            }
            aVar.g(33, this.rax);
            return 0;
        } else if (i == 1) {
            if (this.six != null) {
                fS = f.a.a.a.fS(1, this.six.boi()) + 0;
            } else {
                fS = 0;
            }
            if (this.qZX != null) {
                fS += f.a.a.b.b.a.h(2, this.qZX);
            }
            if (this.qZY != null) {
                fS += f.a.a.b.b.a.h(3, this.qZY);
            }
            if (this.qZZ != null) {
                fS += f.a.a.b.b.a.h(4, this.qZZ);
            }
            if (this.content != null) {
                fS += f.a.a.b.b.a.h(5, this.content);
            }
            if (this.raa != null) {
                fS += f.a.a.b.b.a.h(6, this.raa);
            }
            if (this.rab != null) {
                fS += f.a.a.b.b.a.h(7, this.rab);
            }
            if (this.rac != null) {
                fS += f.a.a.b.b.a.h(8, this.rac);
            }
            if (this.rad != null) {
                fS += f.a.a.b.b.a.h(9, this.rad);
            }
            if (this.rae != null) {
                fS += f.a.a.b.b.a.h(10, this.rae);
            }
            if (this.raf != null) {
                fS += f.a.a.b.b.a.h(11, this.raf);
            }
            if (this.rag != null) {
                fS += f.a.a.b.b.a.h(12, this.rag);
            }
            if (this.rah != null) {
                fS += f.a.a.b.b.a.h(13, this.rah);
            }
            if (this.hvV != null) {
                fS += f.a.a.b.b.a.h(14, this.hvV);
            }
            if (this.hvW != null) {
                fS += f.a.a.b.b.a.h(15, this.hvW);
            }
            if (this.rai != null) {
                fS += f.a.a.b.b.a.h(16, this.rai);
            }
            fS = (((fS + (f.a.a.b.b.a.ec(17) + 1)) + f.a.a.a.fQ(18, this.rak)) + f.a.a.a.fQ(19, this.ral)) + f.a.a.a.fQ(20, this.ram);
            if (this.dxh != null) {
                fS += f.a.a.b.b.a.h(21, this.dxh);
            }
            if (this.ran != null) {
                fS += f.a.a.b.b.a.h(22, this.ran);
            }
            if (this.rao != null) {
                fS += f.a.a.b.b.a.h(23, this.rao);
            }
            fS += f.a.a.a.fQ(24, this.rap);
            if (this.raq != null) {
                fS += f.a.a.b.b.a.h(25, this.raq);
            }
            if (this.rar != null) {
                fS += f.a.a.b.b.a.h(26, this.rar);
            }
            if (this.ras != null) {
                fS += f.a.a.b.b.a.h(27, this.ras);
            }
            if (this.rat != null) {
                fS += f.a.a.b.b.a.h(28, this.rat);
            }
            if (this.rau != null) {
                fS += f.a.a.b.b.a.h(29, this.rau);
            }
            if (this.rav != null) {
                fS += f.a.a.b.b.a.h(30, this.rav);
            }
            if (this.raw != null) {
                fS += f.a.a.b.b.a.h(31, this.raw);
            }
            if (this.huU != null) {
                fS += f.a.a.b.b.a.h(32, this.huU);
            }
            if (this.rax != null) {
                fS += f.a.a.b.b.a.h(33, this.rax);
            }
            return fS;
        } else if (i == 2) {
            f.a.a.a.a aVar2 = new f.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fS = bhp.a(aVar2); fS > 0; fS = bhp.a(aVar2)) {
                if (!super.a(aVar2, this, fS)) {
                    aVar2.cJS();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            f.a.a.a.a aVar3 = (f.a.a.a.a) objArr[0];
            abi abi = (abi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList IC = aVar3.IC(intValue);
                    int size = IC.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) IC.get(intValue);
                        fl flVar = new fl();
                        f.a.a.a.a aVar4 = new f.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = flVar.a(aVar4, flVar, bhp.a(aVar4))) {
                        }
                        abi.six = flVar;
                    }
                    return 0;
                case 2:
                    abi.qZX = aVar3.vHC.readString();
                    return 0;
                case 3:
                    abi.qZY = aVar3.vHC.readString();
                    return 0;
                case 4:
                    abi.qZZ = aVar3.vHC.readString();
                    return 0;
                case 5:
                    abi.content = aVar3.vHC.readString();
                    return 0;
                case 6:
                    abi.raa = aVar3.vHC.readString();
                    return 0;
                case 7:
                    abi.rab = aVar3.vHC.readString();
                    return 0;
                case 8:
                    abi.rac = aVar3.vHC.readString();
                    return 0;
                case 9:
                    abi.rad = aVar3.vHC.readString();
                    return 0;
                case 10:
                    abi.rae = aVar3.vHC.readString();
                    return 0;
                case 11:
                    abi.raf = aVar3.vHC.readString();
                    return 0;
                case 12:
                    abi.rag = aVar3.vHC.readString();
                    return 0;
                case 13:
                    abi.rah = aVar3.vHC.readString();
                    return 0;
                case 14:
                    abi.hvV = aVar3.vHC.readString();
                    return 0;
                case 15:
                    abi.hvW = aVar3.vHC.readString();
                    return 0;
                case 16:
                    abi.rai = aVar3.vHC.readString();
                    return 0;
                case 17:
                    abi.raj = aVar3.cJQ();
                    return 0;
                case 18:
                    abi.rak = aVar3.vHC.rY();
                    return 0;
                case 19:
                    abi.ral = aVar3.vHC.rY();
                    return 0;
                case 20:
                    abi.ram = aVar3.vHC.rY();
                    return 0;
                case 21:
                    abi.dxh = aVar3.vHC.readString();
                    return 0;
                case 22:
                    abi.ran = aVar3.vHC.readString();
                    return 0;
                case 23:
                    abi.rao = aVar3.vHC.readString();
                    return 0;
                case 24:
                    abi.rap = aVar3.vHC.rY();
                    return 0;
                case 25:
                    abi.raq = aVar3.vHC.readString();
                    return 0;
                case 26:
                    abi.rar = aVar3.vHC.readString();
                    return 0;
                case i$l.AppCompatTheme_actionModeStyle /*27*/:
                    abi.ras = aVar3.vHC.readString();
                    return 0;
                case i$l.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                    abi.rat = aVar3.vHC.readString();
                    return 0;
                case i$l.AppCompatTheme_actionModeBackground /*29*/:
                    abi.rau = aVar3.vHC.readString();
                    return 0;
                case i$l.AppCompatTheme_actionModeSplitBackground /*30*/:
                    abi.rav = aVar3.vHC.readString();
                    return 0;
                case i$l.AppCompatTheme_actionModeCloseDrawable /*31*/:
                    abi.raw = aVar3.vHC.readString();
                    return 0;
                case i$l.AppCompatTheme_actionModeCutDrawable /*32*/:
                    abi.huU = aVar3.vHC.readString();
                    return 0;
                case i$l.AppCompatTheme_actionModeCopyDrawable /*33*/:
                    abi.rax = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
