package com.tencent.mm.plugin.sns;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.storage.av;

public final class o implements m {
    public final bsu ng(String str) {
        return e.ng(str);
    }

    public final boolean ew(long j) {
        n fi = af.byo().fi(j);
        if (fi != null && fi.bAJ().sqc.ruA.size() > 0) {
            return true;
        }
        return false;
    }

    public final void a(long j, ImageView imageView, int i) {
        n fi = af.byo().fi(j);
        if (fi != null) {
            bsu bAJ = fi.bAJ();
            if (bAJ.sqc.ruA.size() > 0) {
                ate ate = (ate) bAJ.sqc.ruA.get(0);
                Bitmap b = af.byl().b(ate);
                if (b != null) {
                    imageView.setImageBitmap(b);
                } else {
                    af.byl().b(ate, imageView, i, av.tbu);
                }
            }
        }
    }
}
