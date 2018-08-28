package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.aq.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd.a;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.profile.ui.c.2;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

class c$2$1 implements OnClickListener {
    final /* synthetic */ 2 lVU;

    c$2$1(2 2) {
        this.lVU = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        c cVar = this.lVU.lVT;
        String str = cVar.guS.field_username;
        au.HU();
        bd GD = c.FT().GD(str);
        au.HU();
        c.FQ().b(new d(str, GD.field_msgSvrId));
        cVar.isDeleteCancel = false;
        MMActivity mMActivity = cVar.bGc;
        cVar.bGc.getString(R.l.app_tip);
        cVar.tipDialog = h.a(mMActivity, cVar.bGc.getString(R.l.app_waiting), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                c.this.isDeleteCancel = true;
            }
        });
        com.tencent.mm.model.bd.a(str, new a() {
            public final boolean Ip() {
                return c.this.isDeleteCancel;
            }

            public final void Io() {
                if (c.this.tipDialog != null) {
                    c.this.tipDialog.dismiss();
                    c.this.tipDialog = null;
                }
            }
        });
    }
}
