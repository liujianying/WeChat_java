package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wallet_core.model.mall.b;

class BannerActView$1 implements OnClickListener {
    final /* synthetic */ BannerActView kYq;

    BannerActView$1(BannerActView bannerActView) {
        this.kYq = bannerActView;
    }

    public final void onClick(View view) {
        this.kYq.setVisibility(8);
        b.cF(BannerActView.a(this.kYq));
        if (BannerActView.a(this.kYq) != null && BannerActView.a(this.kYq).size() > 0) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", ((a) BannerActView.a(this.kYq).get(0)).prR);
            d.b(this.kYq.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        }
    }
}
