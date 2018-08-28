package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import com.tencent.mm.plugin.brandservice.ui.base.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.bju;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.a$a;

public final class b extends a {
    private static com.tencent.mm.ui.base.sortview.a.b hoi;
    CharSequence eCh;
    protected CharSequence hnX;
    protected boolean hoa;
    protected boolean hob;
    protected String hoj;
    protected String iconUrl;
    protected String username;

    public b(Object obj, String str) {
        super(6, obj);
        this.hoj = str;
    }

    public final com.tencent.mm.ui.base.sortview.a.b auQ() {
        if (hoi == null) {
            hoi = new 1(this);
        }
        return hoi;
    }

    public final a$a auR() {
        return new a();
    }

    public final void a(Context context, a$a a_a, Object... objArr) {
        if (!this.tDC) {
            if (context == null || a_a == null || this.data == null) {
                x.e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            } else if (!(a_a instanceof a)) {
                x.e("MicroMsg.BizRecommDataItem", "The DataItem is not a instance of BizProductViewHolder.");
            } else if (this.data instanceof bju) {
                bju bju = (bju) this.data;
                try {
                    this.eCh = j.a(context, bju.rQz != null ? bju.rQz.toString() : "", ((a) a_a).eTm.getTextSize());
                } catch (Exception e) {
                    this.eCh = "";
                }
                this.iconUrl = bju.rra;
                this.username = bju.rvi.toString();
            } else {
                x.e("MicroMsg.BizRecommDataItem", "The data is not a instance of SearchOrRecommendItem.");
            }
        }
    }
}
