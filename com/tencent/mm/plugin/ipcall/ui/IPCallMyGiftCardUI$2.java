package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;

class IPCallMyGiftCardUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ IPCallMyGiftCardUI kwG;

    IPCallMyGiftCardUI$2(IPCallMyGiftCardUI iPCallMyGiftCardUI) {
        this.kwG = iPCallMyGiftCardUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.kwG.getString(R.l.ip_call_exchange_coupon_url));
        intent.putExtra("showShare", false);
        d.b(this.kwG, "webview", ".ui.tools.WebViewUI", intent);
        return true;
    }
}
