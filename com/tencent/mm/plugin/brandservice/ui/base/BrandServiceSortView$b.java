package com.tencent.mm.plugin.brandservice.ui.base;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ac.m;
import com.tencent.mm.ac.m.a.a;
import com.tencent.mm.ac.z;
import com.tencent.mm.plugin.brandservice.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class BrandServiceSortView$b implements a {
    static Bitmap hqv = null;
    public View contentView;
    ImageView eCl;
    TextView eTm;
    public TextView hoc;
    ImageView hpA;
    View hpB;
    String iconUrl;
    String username;

    public BrandServiceSortView$b() {
        z.Ni().a(this);
    }

    public final void ave() {
        if (this.eCl != null) {
            Bitmap d = m.d(this.username, this.iconUrl, 0);
            if (d == null) {
                this.eCl.setImageResource(c.brand_default_head);
            } else if (bi.oW(this.username) || this.eCl.getTag() == null) {
                x.e("MicroMsg.BrandServiceSortView", "error in refreshAvatar, %s", new Object[]{this.username});
            } else if (this.username.equals(this.eCl.getTag())) {
                this.eCl.setImageBitmap(d);
            }
        }
    }

    public final void kX(String str) {
        if (str != null && str.equals(this.username)) {
            ah.A(new 1(this));
        }
    }
}
