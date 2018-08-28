package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.text.TextUtils;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.plugin.sns.storage.c;
import com.tencent.mm.protocal.c.yx;
import com.tencent.mm.sdk.platformtools.x;

class i$2 implements a {
    final /* synthetic */ i nIV;
    final /* synthetic */ long nIW;
    final /* synthetic */ int nIX;
    final /* synthetic */ c nIY;

    i$2(i iVar, long j, int i, c cVar) {
        this.nIV = iVar;
        this.nIW = j;
        this.nIX = i;
        this.nIY = cVar;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        if (i == 0 && i2 == 0) {
            yx yxVar = (yx) bVar.dIE.dIL;
            x.i("OpenCanvasMgr", "getCanvasInfo pageid %d ,xml %s", Long.valueOf(this.nIW), yxVar.rFa);
            if (!TextUtils.isEmpty(yxVar.rFa)) {
                i.b(this.nIV).put(Long.valueOf(this.nIW), yxVar.rFa);
                this.nIY.field_canvasXml = yxVar.rFa;
                i.c(this.nIV).a(this.nIY);
            }
        } else {
            x.e("OpenCanvasMgr", "cgi fail page id %d,preLoad %d, errType %d,errCode %d", Long.valueOf(this.nIW), Integer.valueOf(this.nIX), Integer.valueOf(i), Integer.valueOf(i2));
        }
        return 0;
    }
}
