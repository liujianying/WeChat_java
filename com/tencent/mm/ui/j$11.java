package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.w.a;

class j$11 implements e {
    final /* synthetic */ j tjf;

    j$11(j jVar) {
        this.tjf = jVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + lVar.getType());
        if (this.tjf.eHw != null) {
            this.tjf.eHw.dismiss();
            this.tjf.eHw = null;
        }
        if (lVar.getType() == 255) {
            au.DF().b(255, this.tjf.tjb);
            if (i == 0 && i2 == 0) {
                this.tjf.lx(true);
            } else if (!a.a(this.tjf.tiY, i, i2, str, 4)) {
                this.tjf.lx(false);
            }
        } else if (lVar.getType() != 384) {
        } else {
            if (i == 0 && i2 == 0) {
                au.HU();
                c.DT().set(77830, ((ab) lVar).Oj());
                Intent intent = new Intent(this.tjf.tiY, RegByMobileSetPwdUI.class);
                intent.putExtra("kintent_hint", this.tjf.getString(R.l.settings_modify_password_tip));
                this.tjf.tiY.startActivity(intent);
                return;
            }
            this.tjf.mRA = true;
            h.a(this.tjf.tiY, R.l.settings_password_error, R.l.app_tip, new 1(this));
        }
    }
}
