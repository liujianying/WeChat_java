package com.tencent.mm.ui.base;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.k;

class s$a {
    private static Toast qNM = null;
    public static int tyr = 0;

    public static void aq(Context context, int i) {
        Context applicationContext = context.getApplicationContext();
        if (tyr != i) {
            qNM = null;
            tyr = i;
        }
        if (qNM == null) {
            qNM = Toast.makeText(applicationContext, "", 1);
        }
        View inflate = View.inflate(applicationContext, h.sdcard_eject_toast, null);
        if (i == 1) {
            ((TextView) inflate.findViewById(g.sdcard_toast_text)).setText(k.media_ejected);
        } else if (i == 3) {
            ((TextView) inflate.findViewById(g.sdcard_toast_text)).setText(k.media_ejected_readonly);
        } else {
            ((TextView) inflate.findViewById(g.sdcard_toast_text)).setText(k.media_full);
        }
        qNM.setView(inflate);
        qNM.show();
    }
}
