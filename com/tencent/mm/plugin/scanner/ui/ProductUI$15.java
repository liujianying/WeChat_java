package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.scanner.util.n.a;

class ProductUI$15 implements OnClickListener {
    final /* synthetic */ ProductUI mJt;
    final /* synthetic */ a mJu;

    ProductUI$15(ProductUI productUI, a aVar) {
        this.mJt = productUI;
        this.mJu = aVar;
    }

    public final void onClick(View view) {
        ProductUI.a(this.mJt, 10003, this.mJu.field_introlink);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.mJu.field_introlink);
        intent.putExtra("geta8key_scene", ProductUI.k(this.mJt));
        d.b(this.mJt.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
    }
}
