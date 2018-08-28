package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.scanner.util.n.a;

class ProductUI$16 implements OnClickListener {
    final /* synthetic */ ProductUI mJt;
    final /* synthetic */ a mJu;

    ProductUI$16(ProductUI productUI, a aVar) {
        this.mJt = productUI;
        this.mJu = aVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse(this.mJu.field_playurl), "video/*");
        this.mJt.startActivity(intent);
    }
}
