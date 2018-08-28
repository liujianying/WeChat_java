package com.tencent.mm.plugin.appbrand.menu;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.ui.base.l;

public final class MenuDelegate_EnableDebug extends a {
    public MenuDelegate_EnableDebug() {
        super(l.gjy - 1);
    }

    public final void a(Context context, p pVar, l lVar, String str) {
        if (h.rO(str)) {
            CharSequence string;
            if (pVar.fdO.fcu.fqL) {
                string = context.getString(j.app_brand_disable_debug);
            } else {
                string = context.getString(j.app_brand_enable_debug);
            }
            lVar.e(l.gjy - 1, string);
        }
    }

    public final void a(Context context, p pVar, String str, k kVar) {
        e(context, str, !pVar.fdO.fcu.fqL);
    }

    public static void e(final Context context, String str, boolean z) {
        String string;
        SetAppDebugModeTask setAppDebugModeTask = new SetAppDebugModeTask((byte) 0);
        setAppDebugModeTask.appId = str;
        setAppDebugModeTask.bKe = z;
        AppBrandMainProcessService.a(setAppDebugModeTask);
        if (setAppDebugModeTask.bKe) {
            string = context.getString(j.app_brand_debug_enabled_toast);
        } else {
            string = context.getString(j.app_brand_debug_disabled_toast);
        }
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(new Runnable() {
                public final void run() {
                    Toast.makeText(context, string, 0).show();
                    ((Activity) context).finish();
                }
            });
        }
    }
}
