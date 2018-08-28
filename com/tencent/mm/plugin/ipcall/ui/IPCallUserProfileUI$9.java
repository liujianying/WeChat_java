package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;

class IPCallUserProfileUI$9 implements OnClickListener {
    final /* synthetic */ IPCallUserProfileUI kzx;

    IPCallUserProfileUI$9(IPCallUserProfileUI iPCallUserProfileUI) {
        this.kzx = iPCallUserProfileUI;
    }

    public final void onClick(View view) {
        IPCallUserProfileUI.d(this.kzx).start();
        IPCallUserProfileUI.d(this.kzx).krP = 1;
        IPCallUserProfileUI.d(this.kzx).krQ = 5;
        IPCallUserProfileUI.d(this.kzx).finish();
        h.mEJ.h(12766, new Object[]{Integer.valueOf(3)});
        Intent intent;
        if (!bi.oW(IPCallUserProfileUI.e(this.kzx))) {
            intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + IPCallUserProfileUI.Fi(IPCallUserProfileUI.e(this.kzx))));
            intent.putExtra("sms_body", this.kzx.getString(R.l.ip_call_invite_wechat_friend_sms, new Object[]{q.Hl().BK()}));
            this.kzx.startActivity(intent);
        } else if (!bi.oW(IPCallUserProfileUI.f(this.kzx))) {
            intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + IPCallUserProfileUI.f(this.kzx)));
            intent.putExtra("sms_body", this.kzx.getString(R.l.ip_call_invite_wechat_friend_sms, new Object[]{q.Hl().BK()}));
            this.kzx.startActivity(intent);
        }
    }
}
