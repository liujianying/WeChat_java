package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.e;

class a$3 implements OnClickListener {
    final /* synthetic */ Activity ews;
    final /* synthetic */ Bundle fZl;
    final /* synthetic */ int plc;
    final /* synthetic */ boolean plf = false;

    a$3(Bundle bundle, int i, Activity activity) {
        this.fZl = bundle;
        this.plc = i;
        this.ews = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click OK");
        x.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog click OK");
        Bundle bundle = this.fZl;
        if (this.fZl == null) {
            bundle = new Bundle();
        }
        bundle.putInt("real_name_verify_mode", 0);
        bundle.putInt("entry_scene", this.plc);
        bundle.putBoolean("key_from_set_pwd", true);
        a.a(this.ews, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle);
        e.a(19, bi.VE(), this.plc);
        dialogInterface.dismiss();
        if (this.plf) {
            this.ews.finish();
        }
    }
}
