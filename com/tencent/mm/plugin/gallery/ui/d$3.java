package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mm.plugin.gallery.model.j;
import com.tencent.mm.sdk.platformtools.at.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class d$3 implements a {
    final /* synthetic */ d jDw;
    private Bitmap jDx = null;
    final /* synthetic */ String jDy;

    d$3(d dVar, String str) {
        this.jDw = dVar;
        this.jDy = str;
    }

    public final boolean Ks() {
        this.jDw.jDv = false;
        if (this.jDw.jDp.containsKey(this.jDy)) {
            int intValue = ((Integer) this.jDw.jDp.get(this.jDy)).intValue();
            if (this.jDw.aRV()) {
                d.a(this.jDw, intValue, this.jDx);
            } else {
                this.jDw.jDr.put(intValue, this.jDx);
            }
        }
        this.jDw.jDs.m(this.jDy, this.jDx);
        this.jDx = null;
        this.jDw.ahW();
        return false;
    }

    public final boolean Kr() {
        if (this.jDw.jDu == null || TextUtils.isEmpty(this.jDy)) {
            return false;
        }
        String str = this.jDy;
        long VG = bi.VG();
        Bitmap CU = j.CU(str);
        x.v("MicroMsg.ImageAdapter", "test decode: %d filePath:%s", new Object[]{Long.valueOf(bi.bI(VG)), str});
        this.jDx = CU;
        return true;
    }
}
