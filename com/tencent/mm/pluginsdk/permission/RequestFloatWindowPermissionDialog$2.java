package com.tencent.mm.pluginsdk.permission;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class RequestFloatWindowPermissionDialog$2 implements OnClickListener {
    final /* synthetic */ RequestFloatWindowPermissionDialog qBi;

    RequestFloatWindowPermissionDialog$2(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
        this.qBi = requestFloatWindowPermissionDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (d.fR(23)) {
            try {
                if (!bi.oW((String) Settings.class.getField("ACTION_MANAGE_OVERLAY_PERMISSION").get(Settings.class))) {
                    this.qBi.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + ad.getPackageName())), RequestFloatWindowPermissionDialog.qBg);
                    return;
                }
            } catch (Exception e) {
                x.e("MicroMsg.RequestFloatWindowPermissionDialog", "getField:ACTION_MANAGE_OVERLAY_PERMISSION! Error:%s, etype:%s", new Object[]{e.getMessage(), e.getClass().getCanonicalName()});
            }
        }
        String string = this.qBi.getString(h.floating_window_permission_url);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", string);
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        com.tencent.mm.bg.d.b(this.qBi, "webview", ".ui.tools.WebViewUI", intent);
        this.qBi.finish();
    }
}
