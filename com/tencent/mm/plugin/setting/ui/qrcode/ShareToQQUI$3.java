package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;

class ShareToQQUI$3 implements OnClickListener {
    final /* synthetic */ ShareToQQUI mPF;

    ShareToQQUI$3(ShareToQQUI shareToQQUI) {
        this.mPF = shareToQQUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(this.mPF.mController.tml, FacebookAuthUI.class);
        intent.putExtra("is_force_unbind", true);
        this.mPF.mController.tml.startActivity(intent);
        this.mPF.YC();
        this.mPF.finish();
    }
}
