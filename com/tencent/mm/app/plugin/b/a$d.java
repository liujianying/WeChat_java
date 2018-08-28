package com.tencent.mm.app.plugin.b;

import com.tencent.mm.e.a.a;
import com.tencent.mm.g.a.fc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class a$d extends c<fc> {
    a bAW;
    String fileName;

    public a$d() {
        this.sFo = fc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fc fcVar = (fc) bVar;
        if (bi.oW(fcVar.bNi.fileName) && fcVar.bNi.op == 1) {
            x.e("MicroMsg.SubCoreExtAgent", "fileName(%s) is null or nil.", fcVar.bNi.fileName);
        } else if (fcVar.bNi.op == 1) {
            if (this.bAW == null) {
                this.bAW = new a(ad.getContext());
            } else if (!fcVar.bNi.fileName.equals(this.fileName)) {
                if (this.bAW.isPlaying()) {
                    this.bAW.aJ(false);
                }
                this.fileName = fcVar.bNi.fileName;
            } else if (this.bAW.wc()) {
                fcVar.bNj.bJm = this.bAW.vY();
            } else if (this.bAW.isPlaying()) {
                fcVar.bNj.bJm = false;
            }
            this.bAW.bCU = fcVar.bNi.bNl;
            this.bAW.bCT = fcVar.bNi.bNm;
            fcVar.bNj.bJm = this.bAW.a(fcVar.bNi.fileName, fcVar.bNi.bCH, fcVar.bNi.bNk, -1);
        } else if (fcVar.bNi.op == 2) {
            if (this.bAW != null) {
                this.bAW.aJ(false);
            }
        } else if (fcVar.bNi.op == 4 && this.bAW != null && this.bAW.isPlaying()) {
            fcVar.bNj.bJm = this.bAW.aI(true);
        }
        return true;
    }
}
