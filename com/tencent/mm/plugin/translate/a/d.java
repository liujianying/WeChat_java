package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.translate.a.c.c;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;

public final class d implements e {
    public int index;
    public boolean oEA = false;
    public b oEB;
    a oEC;
    public al oED = new al(new 1(this), false);
    public SparseArray<c> oEz = null;
    long start;

    public d(int i, a aVar) {
        this.index = i;
        this.oEC = aVar;
    }

    public final void bIS() {
        this.oEB = null;
        this.oEA = false;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (this.oEB != lVar) {
            x.e("MicroMsg.WorkingTranslate", "not my translate work");
            return;
        }
        int size;
        this.oED.SO();
        x.d("MicroMsg.WorkingTranslate", "translate take time : %s", new Object[]{Long.valueOf(System.currentTimeMillis() - this.start)});
        String str2 = "MicroMsg.WorkingTranslate";
        String str3 = "errType : %s, errCode : %s, errMsg : %s, translatedMsg.size() : %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = str;
        if (((b) lVar).oEq != null) {
            size = ((b) lVar).oEq.size();
        } else {
            size = 0;
        }
        objArr[3] = Integer.valueOf(size);
        x.d(str2, str3, objArr);
        bIS();
        this.oEC.a(i2, this.oEz, ((b) lVar).oEq);
    }
}
