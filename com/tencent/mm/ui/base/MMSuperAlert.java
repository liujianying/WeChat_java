package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.w.a.h;

@a(3)
public class MMSuperAlert extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(h.mm_super_alert_empty);
        new ag().postDelayed(new 1(this, getIntent().getIntExtra("MMSuperAlert_msg", 0), getIntent().getIntExtra("MMSuperAlert_title", 0), getIntent().getBooleanExtra("MMSuperAlert_cancelable", true)), 50);
    }

    public static void j(Context context, int i, int i2) {
        Intent intent = new Intent(context, MMSuperAlert.class);
        intent.putExtra("MMSuperAlert_title", i);
        intent.putExtra("MMSuperAlert_msg", i2);
        intent.putExtra("MMSuperAlert_cancelable", false);
        context.startActivity(intent);
    }

    public Resources getResources() {
        if (getAssets() == null || ad.getResources() == null) {
            return super.getResources();
        }
        return ad.getResources();
    }
}
