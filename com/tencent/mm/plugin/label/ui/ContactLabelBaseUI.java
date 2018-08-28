package com.tencent.mm.plugin.label.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ContactLabelBaseUI extends MMActivity {
    private ProgressDialog eEX;

    protected int getLayoutId() {
        return 0;
    }

    public final void FE(String str) {
        getString(R.l.app_tip);
        this.eEX = h.a(this, str, true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                au.DF().cancel(636);
            }
        });
    }

    public final void aYM() {
        if (this.eEX != null && this.eEX.isShowing()) {
            this.eEX.dismiss();
        }
    }

    public final void zK(String str) {
        h.a(this, str, "", new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }
}
