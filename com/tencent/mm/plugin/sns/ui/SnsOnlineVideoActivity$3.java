package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.g.a.qr;
import com.tencent.mm.g.a.qr.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;

class SnsOnlineVideoActivity$3 implements d {
    final /* synthetic */ SnsOnlineVideoActivity nZl;

    SnsOnlineVideoActivity$3(SnsOnlineVideoActivity snsOnlineVideoActivity) {
        this.nZl = snsOnlineVideoActivity;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        boolean z = false;
        Intent intent;
        qr qrVar;
        switch (menuItem.getItemId()) {
            case 1:
                intent = new Intent();
                n Nl = af.byo().Nl(SnsOnlineVideoActivity.p(this.nZl));
                if (Nl != null) {
                    x.i("MicroMsg.SnsOnlineVideoActivity", "expose id " + Nl.bAK());
                }
                intent.putExtra("k_expose_msg_id", Nl == null ? Integer.valueOf(0) : Nl.bAK());
                intent.putExtra("k_username", Nl == null ? "" : Nl.field_userName);
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                com.tencent.mm.bg.d.b(this.nZl, "webview", ".ui.tools.WebViewUI", intent);
                return;
            case 2:
                qr qrVar2 = new qr();
                qrVar2.cbg.bOh = 2;
                qrVar2.cbg.cbh = 17;
                a aVar = qrVar2.cbg;
                if (SnsOnlineVideoActivity.q(this.nZl) == 0) {
                    z = true;
                }
                aVar.cbi = z;
                qrVar2.cbg.bNH = SnsOnlineVideoActivity.p(this.nZl);
                com.tencent.mm.sdk.b.a.sFg.m(qrVar2);
                return;
            case 3:
                SnsOnlineVideoActivity.r(this.nZl);
                qrVar = new qr();
                qrVar.cbg.bOh = 1;
                qrVar.cbg.cbj = 4097;
                qrVar.cbg.bNH = SnsOnlineVideoActivity.p(this.nZl);
                com.tencent.mm.sdk.b.a.sFg.m(qrVar);
                return;
            case 4:
                n Nl2 = af.byo().Nl(SnsOnlineVideoActivity.p(this.nZl));
                if (Nl2 != null) {
                    intent = new Intent();
                    if (Nl2.bAJ().sqc.ruz == 15 && ((ate) Nl2.bAJ().sqc.ruA.get(0)) == null) {
                        x.w("MicroMsg.SnsOnlineVideoActivity", "send sight fail, mediaObj is null");
                        return;
                    }
                    intent.putExtra("exdevice_open_scene_type", 2);
                    intent.putExtra("sns_local_id", SnsOnlineVideoActivity.p(this.nZl));
                    intent.putExtra("sns_send_data_ui_activity", true);
                    com.tencent.mm.bg.d.e(this.nZl, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
                    return;
                }
                return;
            case 5:
                qrVar = new qr();
                qrVar.cbg.bOh = 3;
                qrVar.cbg.bNH = SnsOnlineVideoActivity.p(this.nZl);
                com.tencent.mm.sdk.b.a.sFg.m(qrVar);
                return;
            default:
                return;
        }
    }
}
