package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.h.d;

class e$1 implements d {
    final /* synthetic */ String uYX;
    final /* synthetic */ Context val$context;

    e$1(Context context, String str) {
        this.val$context = context;
        this.uYX = str;
    }

    public final void bx(int i, int i2) {
        Intent intent = new Intent();
        switch (i) {
            case 0:
                intent.putExtra("rawUrl", this.val$context.getString(i.wallet_agreemnet_user, new Object[]{w.chP()}));
                break;
            case 1:
                if (this.uYX != null) {
                    intent.putExtra("rawUrl", this.val$context.getString(i.wallet_agreemnet_bank, new Object[]{w.chP(), this.uYX}));
                    break;
                }
                break;
            case 2:
                if (this.uYX != null) {
                    intent.putExtra("rawUrl", this.val$context.getString(i.wallet_agreemnet_wxcredit_bank, new Object[]{w.chP(), this.uYX}));
                    break;
                }
                break;
            case 3:
                if (this.uYX != null) {
                    intent.putExtra("rawUrl", this.val$context.getString(i.wallet_agreemnet_wxcredit_get, new Object[]{w.chP(), this.uYX}));
                    break;
                }
                break;
        }
        intent.putExtra("showShare", false);
        com.tencent.mm.bg.d.b(this.val$context, "webview", ".ui.tools.WebViewUI", intent);
    }
}
