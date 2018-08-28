package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bi;

class IPCallUserProfileUI$3 implements OnClickListener {
    final /* synthetic */ IPCallUserProfileUI kzx;

    IPCallUserProfileUI$3(IPCallUserProfileUI iPCallUserProfileUI) {
        this.kzx = iPCallUserProfileUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.kzx, IPCallAllRecordUI.class);
        if (!bi.oW(IPCallUserProfileUI.e(this.kzx))) {
            intent.putExtra("IPCallAllRecordUI_contactId", IPCallUserProfileUI.e(this.kzx));
        } else if (!bi.oW(IPCallUserProfileUI.f(this.kzx))) {
            intent.putExtra("IPCallAllRecordUI_phoneNumber", IPCallUserProfileUI.f(this.kzx));
        }
        intent.putExtra("IPCallAllRecordUI_isSinglePhoneNumber", IPCallUserProfileUI.g(this.kzx));
        this.kzx.startActivity(intent);
    }
}
