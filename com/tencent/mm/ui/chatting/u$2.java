package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.u.3;
import com.tencent.mm.ui.chatting.u.5;
import com.tencent.mm.ui.chatting.u.8;

class u$2 implements OnClickListener {
    final /* synthetic */ u tKV;

    u$2(u uVar) {
        this.tKV = uVar;
    }

    public final void onClick(View view) {
        u uVar;
        switch (8.tKX[this.tKV.tKN.ordinal()]) {
            case 1:
                h.mEJ.h(11288, new Object[]{Integer.valueOf(7)});
                uVar = this.tKV;
                x.i("MicroMsg.ChattingQQMailFooterHandler", "dz[installQQMail]");
                bi.j(uVar.tKQ, uVar.mContext);
                return;
            case 2:
                uVar = this.tKV;
                x.i("MicroMsg.ChattingQQMailFooterHandler", "dz[cancelDownload]");
                d.aCU().cl(uVar.iyn);
                uVar.ctT();
                return;
            case 3:
                h.mEJ.h(11288, new Object[]{Integer.valueOf(6)});
                u uVar2 = this.tKV;
                if (!ao.isConnected(uVar2.mContext)) {
                    com.tencent.mm.ui.base.h.a(uVar2.mContext, a.af(uVar2.mContext, R.l.chatfooter_mail_offline_tip), "", a.af(uVar2.mContext, R.l.chatfooter_mail_i_know), null);
                    return;
                } else if (ao.isWifi(uVar2.mContext)) {
                    com.tencent.mm.ui.base.h.a(uVar2.mContext, R.l.chatfooter_mail_install_tip, 0, R.l.chatfooter_mail_download, R.l.chatfooter_mail_cancel, new u$4(uVar2), null);
                    return;
                } else {
                    com.tencent.mm.ui.base.h.a(uVar2.mContext, R.l.chatfooter_mail_install_mobile_tip, 0, R.l.chatfooter_mail_download, R.l.chatfooter_mail_cancel, new 3(uVar2), null);
                    return;
                }
            case 4:
                Intent launchIntentForPackage;
                h.mEJ.h(11288, new Object[]{Integer.valueOf(5)});
                u uVar3 = this.tKV;
                x.i("MicroMsg.ChattingQQMailFooterHandler", "dz[openQQMail]");
                x.i("MicroMsg.ChattingQQMailFooterHandler", "mQQMailScheme = %s", new Object[]{uVar3.tKR});
                if (bi.oW(uVar3.tKR)) {
                    launchIntentForPackage = uVar3.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
                } else {
                    launchIntentForPackage = new Intent();
                    launchIntentForPackage.setData(Uri.parse(uVar3.tKR));
                    launchIntentForPackage.addFlags(268435456);
                    if (VERSION.SDK_INT >= 11) {
                        launchIntentForPackage.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
                    }
                    if (!bi.k(uVar3.mContext, launchIntentForPackage)) {
                        launchIntentForPackage = uVar3.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
                    }
                }
                x.i("MicroMsg.ChattingQQMailFooterHandler", "intent = %s", new Object[]{launchIntentForPackage});
                com.tencent.mm.bu.a.post(new 5(uVar3, launchIntentForPackage));
                return;
            case 5:
                if (this.tKV.tKP) {
                    u.a(this.tKV);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
