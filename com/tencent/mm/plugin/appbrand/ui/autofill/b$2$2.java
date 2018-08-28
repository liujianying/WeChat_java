package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.MenuItem;
import com.tencent.mm.plugin.appbrand.ui.autofill.b.2;
import com.tencent.mm.protocal.c.ej;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;

class b$2$2 implements d {
    final /* synthetic */ 2 gxJ;

    b$2$2(2 2) {
        this.gxJ = 2;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        ej ejVar = (ej) this.gxJ.gxI.gxx.reO.get(menuItem.getItemId());
        if (ejVar == null) {
            x.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "not find phone_id, menuItem id :%d", new Object[]{Integer.valueOf(menuItem.getItemId())});
            return;
        }
        x.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "select menuItem id:%d, phone_id:%s, show_phone:%s, bank_type:%s", new Object[]{Integer.valueOf(menuItem.getItemId()), ejVar.reM, ejVar.reN, ejVar.lMV});
        this.gxJ.gxI.gxF = ejVar;
        this.gxJ.gxI.gxG.setText(ejVar.reN);
    }
}
