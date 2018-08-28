package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.ui.base.h;

public final class j {
    public static boolean eY(final Context context) {
        if (!af.Wp("network_doctor_shown")) {
            return false;
        }
        h.a(context, R.l.network_doctor, R.l.app_tip, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                context.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
            }
        }, null);
        return true;
    }
}
