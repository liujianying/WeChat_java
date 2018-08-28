package com.tencent.mm.plugin.recharge.ui;

import android.content.Intent;
import android.provider.ContactsContract.Contacts;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;

class PhoneRechargeUI$15 implements OnClickListener {
    final /* synthetic */ PhoneRechargeUI mqa;

    PhoneRechargeUI$15(PhoneRechargeUI phoneRechargeUI) {
        this.mqa = phoneRechargeUI;
    }

    public final void onClick(View view) {
        if (this.mqa.getPackageManager().checkPermission("android.permission.READ_CONTACTS", ad.getPackageName()) == 0) {
            Intent intent = new Intent("android.intent.action.PICK", Contacts.CONTENT_URI);
            if (bi.k(this.mqa, intent)) {
                this.mqa.startActivityForResult(intent, 1);
                return;
            }
            return;
        }
        h.b(this.mqa, this.mqa.getString(i.wallet_recharge_no_permission), "", true);
    }
}
