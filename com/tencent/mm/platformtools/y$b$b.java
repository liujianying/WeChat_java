package com.tencent.mm.platformtools;

import android.graphics.Bitmap;
import com.tencent.mm.platformtools.y.b;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.at.a;
import com.tencent.mm.sdk.platformtools.x;

class y$b$b implements a {
    public Bitmap dHf = null;
    private w ewl;

    public y$b$b(w wVar) {
        if (y.c(wVar)) {
            this.ewl = wVar;
            return;
        }
        throw new IllegalArgumentException("from sdcard, picture strategy here must be validity");
    }

    public final boolean Kr() {
        boolean z = false;
        this.dHf = b.oQ(this.ewl.Vv());
        if (this.dHf != null) {
            this.dHf = b.ewd.a(this.ewl, this.dHf);
        }
        String str = "MicroMsg.MMPictureLogic";
        String str2 = "get url[%s] from[%s] result[%B]";
        Object[] objArr = new Object[3];
        objArr[0] = this.ewl.Vw();
        objArr[1] = this.ewl.Vv();
        if (this.dHf != null) {
            z = true;
        }
        objArr[2] = Boolean.valueOf(z);
        x.v(str, str2, objArr);
        return true;
    }

    public final boolean Ks() {
        if (this.dHf == null) {
            x.d("MicroMsg.MMPictureLogic", "can not find bitmap on sdCard, url=%s, try to download it", new Object[]{this.ewl.Vw()});
            if (b.a(b.ewd) == null || b.a(b.ewd).ciz()) {
                b.a(b.ewd, new at(1, "readerapp-pic-logic-download", 3));
            }
            b.a(b.ewd).c(new b.a(this.ewl));
        } else {
            b.a(b.ewd, this.ewl.Vw(), this.ewl.Vx(), this.dHf);
            this.dHf = null;
        }
        return false;
    }
}
