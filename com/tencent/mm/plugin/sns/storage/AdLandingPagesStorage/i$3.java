package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.text.TextUtils;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.c.afm;

class i$3 implements a {
    final /* synthetic */ i nIV;
    final /* synthetic */ int nIX;
    final /* synthetic */ String nIZ;
    final /* synthetic */ x nJa;

    i$3(i iVar, String str, int i, x xVar) {
        this.nIV = iVar;
        this.nIZ = str;
        this.nIX = i;
        this.nJa = xVar;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        if (i == 0 && i2 == 0) {
            Object cfV = ((afm) bVar.dIE.dIL).rJu.cfV();
            com.tencent.mm.sdk.platformtools.x.i("OpenCanvasMgr", "getCanvasInfo pageid %s ,xml %s", this.nIZ, cfV);
            if (!TextUtils.isEmpty(cfV)) {
                i.d(this.nIV).put(this.nIZ, cfV);
                this.nJa.field_canvasXml = cfV;
                i.e(this.nIV).a(this.nJa);
            }
        } else {
            com.tencent.mm.sdk.platformtools.x.e("OpenCanvasMgr", "cgi fail pageid %s,preLoad %d, errType %d,errCode %d", this.nIZ, Integer.valueOf(this.nIX), Integer.valueOf(i), Integer.valueOf(i2));
        }
        return 0;
    }
}
