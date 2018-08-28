package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class ShowQRCodeStep1UI$3 implements OnClickListener {
    final /* synthetic */ ShowQRCodeStep1UI mPK;

    ShowQRCodeStep1UI$3(ShowQRCodeStep1UI showQRCodeStep1UI) {
        this.mPK = showQRCodeStep1UI;
    }

    public final void onClick(View view) {
        Intent intent;
        if (ShowQRCodeStep1UI.a(this.mPK) == 3) {
            byte[] DE = g.Eh().DE();
            x.d("MicroMsg.ShowQRCodeStep1UI", "sessionKey[%s], userName[%s], style[%d]", new Object[]{bi.Xf(bi.bE(DE)), q.GF(), Integer.valueOf(bi.f((Integer) g.Ei().DT().get(66561, null)))});
            x.d("MicroMsg.ShowQRCodeStep1UI", "[%s]", new Object[]{"http://weixin.qq.com/cgi-bin/rweibourl?sid=" + com.tencent.mm.a.g.u(DE) + "&u=" + r2 + "&qr=" + r0 + "&device=" + d.DEVICE_TYPE + "&version=" + d.qVN});
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", r0);
            intent2.putExtra("title", this.mPK.getString(i.self_qrcode_show_to_sina));
            com.tencent.mm.bg.d.b(this.mPK, "webview", ".ui.tools.WebViewUI", intent2);
            this.mPK.finish();
        } else if (ShowQRCodeStep1UI.a(this.mPK) == 4) {
            if (q.Hg()) {
                intent = new Intent(this.mPK, ShareToQQUI.class);
                intent.putExtra("show_to", 4);
                this.mPK.startActivity(intent);
            } else {
                ShowQRCodeStep1UI.a(this.mPK, FacebookAuthUI.class);
            }
            this.mPK.finish();
        } else if (ShowQRCodeStep1UI.a(this.mPK) == 2) {
            intent = new Intent(this.mPK, ShareToQQUI.class);
            intent.putExtra("show_to", 2);
            this.mPK.startActivity(intent);
            this.mPK.finish();
        } else {
            intent = new Intent(this.mPK, ShareToQQUI.class);
            intent.putExtra("show_to", 1);
            this.mPK.startActivity(intent);
            this.mPK.finish();
        }
    }
}
