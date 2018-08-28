package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.scanner.a.a.a;
import com.tencent.mm.plugin.scanner.a.h;
import com.tencent.mm.plugin.scanner.ui.h.b;
import com.tencent.mm.sdk.platformtools.bi;

class h$b$1 implements OnClickListener {
    final /* synthetic */ String igj;
    final /* synthetic */ a mIN;
    final /* synthetic */ b mIO;

    h$b$1(b bVar, String str, a aVar) {
        this.mIO = bVar;
        this.igj = str;
        this.mIN = aVar;
    }

    public final void onClick(View view) {
        au.DF().a(new h(this.igj, this.mIN.mFy, this.mIN.type, this.igj, this.mIO.getCount(), this.mIN.showType), 0);
        if (!bi.oW(this.igj)) {
            Intent intent = new Intent();
            intent.putExtra("key_Product_ID", this.igj);
            d.b(this.mIO.mIM.mContext, "scanner", ".ui.ProductUI", intent);
        }
    }
}
