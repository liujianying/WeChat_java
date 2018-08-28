package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.g.a.w;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(3)
public class AccountDeletedAlphaAlertUI extends MMActivity {
    private static AccountDeletedAlphaAlertUI uva = null;

    static /* synthetic */ void a(AccountDeletedAlphaAlertUI accountDeletedAlphaAlertUI) {
        accountDeletedAlphaAlertUI.finish();
        x.ca(accountDeletedAlphaAlertUI);
        Intent intent = new Intent(accountDeletedAlphaAlertUI.mController.tml, LauncherUI.class);
        intent.putExtra("Intro_Switch", true).addFlags(67108864);
        accountDeletedAlphaAlertUI.mController.tml.startActivity(intent);
    }

    public static AccountDeletedAlphaAlertUI czr() {
        return uva;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        uva = this;
        com.tencent.mm.sdk.b.a.sFg.m(new w());
        au.hold();
        com.tencent.mm.h.a eV = com.tencent.mm.h.a.eV(getIntent().getStringExtra("errmsg"));
        if (eV != null) {
            eV.a(this, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AccountDeletedAlphaAlertUI.a(AccountDeletedAlphaAlertUI.this);
                }
            }, null);
        } else {
            h.a(this, getString(R.l.main_err_account_delete), null, false, new 2(this));
        }
    }

    public void onDestroy() {
        if (equals(uva)) {
            uva = null;
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return -1;
    }
}
