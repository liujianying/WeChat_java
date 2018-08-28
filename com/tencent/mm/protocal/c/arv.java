package com.tencent.mm.protocal.c;

import com.tencent.mm.bk.a;
import com.tencent.mm.plugin.appbrand.jsapi.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.f.m;
import com.tencent.mm.plugin.appbrand.jsapi.share.g;
import com.tencent.mm.plugin.sns.i$l;

public final class arv extends a {
    public String bPS;
    public int group_id;
    public String rTZ;
    public String rUa;
    public String rUb;
    public String rUc;
    public int rUd;
    public int rUe;
    public String rUf;
    public int rUg;
    public int rUh;
    public String rUi;
    public int rUj;
    public int rUk;
    public String rUl;
    public int rUm;
    public int rUn;
    public String rUo;
    public String rUp;
    public String rUq;
    public String rUr;
    public String rqK;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            f.a.a.c.a aVar = (f.a.a.c.a) objArr[0];
            if (this.bPS != null) {
                aVar.g(1, this.bPS);
            }
            if (this.rTZ != null) {
                aVar.g(20, this.rTZ);
            }
            if (this.rUa != null) {
                aVar.g(21, this.rUa);
            }
            if (this.rUb != null) {
                aVar.g(22, this.rUb);
            }
            if (this.rUc != null) {
                aVar.g(23, this.rUc);
            }
            if (this.rqK != null) {
                aVar.g(31, this.rqK);
            }
            aVar.fT(32, this.rUd);
            aVar.fT(33, this.rUe);
            if (this.rUf != null) {
                aVar.g(34, this.rUf);
            }
            aVar.fT(35, this.rUg);
            aVar.fT(36, this.rUh);
            if (this.rUi != null) {
                aVar.g(37, this.rUi);
            }
            aVar.fT(38, this.rUj);
            aVar.fT(39, this.rUk);
            if (this.rUl != null) {
                aVar.g(41, this.rUl);
            }
            aVar.fT(m.CTRL_INDEX, this.rUm);
            aVar.fT(201, this.rUn);
            aVar.fT(g.CTRL_INDEX, this.group_id);
            if (this.rUo != null) {
                aVar.g(203, this.rUo);
            }
            if (this.rUp != null) {
                aVar.g(d.CTRL_INDEX, this.rUp);
            }
            if (this.rUq != null) {
                aVar.g(205, this.rUq);
            }
            if (this.rUr == null) {
                return 0;
            }
            aVar.g(206, this.rUr);
            return 0;
        } else if (i == 1) {
            if (this.bPS != null) {
                h = f.a.a.b.b.a.h(1, this.bPS) + 0;
            } else {
                h = 0;
            }
            if (this.rTZ != null) {
                h += f.a.a.b.b.a.h(20, this.rTZ);
            }
            if (this.rUa != null) {
                h += f.a.a.b.b.a.h(21, this.rUa);
            }
            if (this.rUb != null) {
                h += f.a.a.b.b.a.h(22, this.rUb);
            }
            if (this.rUc != null) {
                h += f.a.a.b.b.a.h(23, this.rUc);
            }
            if (this.rqK != null) {
                h += f.a.a.b.b.a.h(31, this.rqK);
            }
            h = (h + f.a.a.a.fQ(32, this.rUd)) + f.a.a.a.fQ(33, this.rUe);
            if (this.rUf != null) {
                h += f.a.a.b.b.a.h(34, this.rUf);
            }
            h = (h + f.a.a.a.fQ(35, this.rUg)) + f.a.a.a.fQ(36, this.rUh);
            if (this.rUi != null) {
                h += f.a.a.b.b.a.h(37, this.rUi);
            }
            h = (h + f.a.a.a.fQ(38, this.rUj)) + f.a.a.a.fQ(39, this.rUk);
            if (this.rUl != null) {
                h += f.a.a.b.b.a.h(41, this.rUl);
            }
            h = ((h + f.a.a.a.fQ(m.CTRL_INDEX, this.rUm)) + f.a.a.a.fQ(201, this.rUn)) + f.a.a.a.fQ(g.CTRL_INDEX, this.group_id);
            if (this.rUo != null) {
                h += f.a.a.b.b.a.h(203, this.rUo);
            }
            if (this.rUp != null) {
                h += f.a.a.b.b.a.h(d.CTRL_INDEX, this.rUp);
            }
            if (this.rUq != null) {
                h += f.a.a.b.b.a.h(205, this.rUq);
            }
            if (this.rUr != null) {
                h += f.a.a.b.b.a.h(206, this.rUr);
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
            arv arv = (arv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    arv.bPS = aVar3.vHC.readString();
                    return 0;
                case 20:
                    arv.rTZ = aVar3.vHC.readString();
                    return 0;
                case 21:
                    arv.rUa = aVar3.vHC.readString();
                    return 0;
                case 22:
                    arv.rUb = aVar3.vHC.readString();
                    return 0;
                case 23:
                    arv.rUc = aVar3.vHC.readString();
                    return 0;
                case i$l.AppCompatTheme_actionModeCloseDrawable /*31*/:
                    arv.rqK = aVar3.vHC.readString();
                    return 0;
                case i$l.AppCompatTheme_actionModeCutDrawable /*32*/:
                    arv.rUd = aVar3.vHC.rY();
                    return 0;
                case i$l.AppCompatTheme_actionModeCopyDrawable /*33*/:
                    arv.rUe = aVar3.vHC.rY();
                    return 0;
                case i$l.AppCompatTheme_actionModePasteDrawable /*34*/:
                    arv.rUf = aVar3.vHC.readString();
                    return 0;
                case i$l.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                    arv.rUg = aVar3.vHC.rY();
                    return 0;
                case i$l.AppCompatTheme_actionModeShareDrawable /*36*/:
                    arv.rUh = aVar3.vHC.rY();
                    return 0;
                case i$l.AppCompatTheme_actionModeFindDrawable /*37*/:
                    arv.rUi = aVar3.vHC.readString();
                    return 0;
                case i$l.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
                    arv.rUj = aVar3.vHC.rY();
                    return 0;
                case i$l.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                    arv.rUk = aVar3.vHC.rY();
                    return 0;
                case i$l.AppCompatTheme_textAppearanceSmallPopupMenu /*41*/:
                    arv.rUl = aVar3.vHC.readString();
                    return 0;
                case m.CTRL_INDEX /*200*/:
                    arv.rUm = aVar3.vHC.rY();
                    return 0;
                case 201:
                    arv.rUn = aVar3.vHC.rY();
                    return 0;
                case g.CTRL_INDEX /*202*/:
                    arv.group_id = aVar3.vHC.rY();
                    return 0;
                case 203:
                    arv.rUo = aVar3.vHC.readString();
                    return 0;
                case d.CTRL_INDEX /*204*/:
                    arv.rUp = aVar3.vHC.readString();
                    return 0;
                case 205:
                    arv.rUq = aVar3.vHC.readString();
                    return 0;
                case 206:
                    arv.rUr = aVar3.vHC.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
