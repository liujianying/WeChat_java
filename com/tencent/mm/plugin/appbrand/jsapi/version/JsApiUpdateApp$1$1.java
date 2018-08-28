package com.tencent.mm.plugin.appbrand.jsapi.version;

import com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp.1;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.widget.c.b;

class JsApiUpdateApp$1$1 implements Runnable {
    final /* synthetic */ 1 fZH;

    JsApiUpdateApp$1$1(1 1) {
        this.fZH = 1;
    }

    public final void run() {
        b bVar = new b(this.fZH.fCl.getContext());
        bVar.setMessage(this.fZH.fCl.getContext().getString(this.fZH.fCl.fdO.aaq() ? j.app_brand_jsapi_update_app_need_reboot_wording_for_game : j.app_brand_jsapi_update_app_need_reboot_wording_for_normal, new Object[]{this.fZH.fCl.fdO.fct.bKC}));
        1 1 = new 1(this);
        if (this.fZH.fCl.fdO.fcu.frm.fih != 0) {
            bVar.a(j.app_brand_jsapi_update_app_dialog_confirm_for_debug, 1);
            bVar.b(j.app_brand_jsapi_update_app_dialog_cancel_for_debug, new 2(this));
        } else {
            bVar.a(j.app_brand_jsapi_update_app_dialog_confirm, 1);
        }
        this.fZH.fCl.fdO.a(bVar);
    }
}
