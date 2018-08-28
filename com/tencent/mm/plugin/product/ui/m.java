package com.tencent.mm.plugin.product.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.platformtools.y.a;
import com.tencent.mm.plugin.product.b.n;
import com.tencent.mm.sdk.platformtools.bi;

public final class m implements a {
    public TextView eBO;
    public ImageView gxd;
    public n.a lTD;

    public final void m(String str, Bitmap bitmap) {
        if (this.lTD != null && !bi.oW(this.lTD.iconUrl) && str.equals(this.lTD.iconUrl)) {
            this.gxd.post(new 1(this, bitmap));
        }
    }
}
