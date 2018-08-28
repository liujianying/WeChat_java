package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.l;

public final class MenuDelegate_SendToDesktop extends a {
    public MenuDelegate_SendToDesktop() {
        super(l.gjE - 1);
    }

    public final void a(Context context, p pVar, l lVar, String str) {
        if (pVar.fdO.fcE.scene != 1023) {
            lVar.e(this.gjO, context.getString(j.app_brand_send_to_desktop));
        }
    }

    public final void a(Context context, p pVar, String str, k kVar) {
        AppBrandSysConfig appBrandSysConfig = pVar.fdO.fcu;
        Object obj = appBrandSysConfig.bGy;
        if (context == null || TextUtils.isEmpty(obj)) {
            x.i("MicroMsg.MenuDelegate_SendToDesktop", "performItemClick failed, context or username is null or nil.");
            return;
        }
        AppBrandMainProcessService.a(new SendShortcutToDesktopTask(context, obj, str, appBrandSysConfig.frm.fih));
        com.tencent.mm.plugin.appbrand.report.a.a(str, pVar.getURL(), 14, "", bi.VE(), 1, 0);
    }
}
