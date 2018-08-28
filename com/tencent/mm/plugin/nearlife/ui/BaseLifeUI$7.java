package com.tencent.mm.plugin.nearlife.ui;

import com.tencent.mm.modelgeo.a$a;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class BaseLifeUI$7 implements a$a {
    final /* synthetic */ BaseLifeUI lDH;

    BaseLifeUI$7(BaseLifeUI baseLifeUI) {
        this.lDH = baseLifeUI;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (this.lDH.dJO) {
            return false;
        }
        if (this.lDH.cXo) {
            return false;
        }
        if (!z) {
            return true;
        }
        o.a(2003, f, f2, (int) d2);
        this.lDH.cXo = true;
        x.i("MicroMsg.BaseLifeUI", "on get location %f %f " + System.currentTimeMillis(), new Object[]{Float.valueOf(f2), Float.valueOf(f)});
        this.lDH.lDs = new aqr();
        this.lDH.lDs.ryX = "";
        this.lDH.lDs.ryY = 0;
        this.lDH.lDs.rms = f2;
        this.lDH.lDs.rmr = f;
        this.lDH.lDs.ryW = "";
        this.lDH.lDs.ryV = (int) d2;
        this.lDH.lDt = f2;
        this.lDH.lDu = f;
        this.lDH.lDv = i;
        this.lDH.lDw = (float) d2;
        this.lDH.dSc = BaseLifeUI.j(this.lDH) == null ? false : BaseLifeUI.j(this.lDH).dSc;
        ArrayList arrayList = BaseLifeUI.f(this.lDH).lDa;
        if (arrayList == null || arrayList.size() <= 0) {
            this.lDH.p((double) f2, (double) f);
        } else {
            LatLongData latLongData = (LatLongData) arrayList.get(arrayList.size() - 1);
            this.lDH.p((double) latLongData.bSx, (double) latLongData.dVI);
            this.lDH.lDD = BaseLifeUI.f(latLongData.bSx, latLongData.dVI, f2, f);
        }
        BaseLifeUI.f(this.lDH).lDe = new LatLongData(this.lDH.lDs.rms, this.lDH.lDs.rmr);
        BaseLifeUI.b(this.lDH).lDe = new LatLongData(this.lDH.lDs.rms, this.lDH.lDs.rmr);
        BaseLifeUI.a(this.lDH, this.lDH.eMT ? BaseLifeUI.b(this.lDH) : BaseLifeUI.f(this.lDH));
        BaseLifeUI.k(this.lDH);
        this.lDH.a(BaseLifeUI.i(this.lDH));
        return false;
    }
}
