package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.ui.base.h;

class j$12 implements OnClickListener {
    final /* synthetic */ j tjf;

    j$12(j jVar) {
        this.tjf = jVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        String obj = this.tjf.mRz.getText().toString();
        this.tjf.mRz.setText("");
        this.tjf.mRz.clearFocus();
        ai.a(this.tjf.tiY, this.tjf.mRz);
        if (obj == null || obj.equals("")) {
            h.a(this.tjf.tiY, R.l.verify_password_null_tip, R.l.app_tip, new 1(this));
            return;
        }
        this.tjf.cpu();
        au.DF().a(384, this.tjf.tjb);
        ab abVar = new ab(obj, "", "", "");
        au.DF().a(abVar, 0);
        j jVar = this.tjf;
        Context context = this.tjf.tiY;
        this.tjf.getString(R.l.app_tip);
        jVar.eHw = h.a(context, this.tjf.getString(R.l.settings_loading), true, new 2(this, abVar));
    }
}
