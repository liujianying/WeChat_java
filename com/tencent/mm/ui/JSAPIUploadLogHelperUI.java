package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public class JSAPIUploadLogHelperUI extends MMBaseActivity {
    private static volatile boolean mIsRunning = false;
    private static byte[] tkf = new byte[0];

    protected void onCreate(Bundle bundle) {
        boolean z;
        x.i("MicroMsg.JSAPIUploadLogHelperUI", "onCreate called, isRunning:%b", new Object[]{Boolean.valueOf(mIsRunning)});
        super.onCreate(bundle);
        setContentView(R.i.background_transparent);
        synchronized (tkf) {
            if (mIsRunning) {
                x.w("MicroMsg.JSAPIUploadLogHelperUI", "reentered while last one is running, finish myself.");
                finish();
            }
        }
        String stringExtra = getIntent().getStringExtra("key_user");
        int intExtra = getIntent().getIntExtra("key_time", 0);
        String str = "MicroMsg.JSAPIUploadLogHelperUI";
        String str2 = "upload log from jsapi, in upload activity, username-recv-well:%b, time:%d";
        Object[] objArr = new Object[2];
        if (stringExtra == null || !stringExtra.equals(q.GF())) {
            z = false;
        } else {
            z = true;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(intExtra);
        x.i(str, str2, objArr);
        if (stringExtra == null) {
            x.e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: userName is null.");
            finish();
        } else if (intExtra < 0) {
            x.e("MicroMsg.JSAPIUploadLogHelperUI", "doUpload: illegal time value: %d", new Object[]{Integer.valueOf(intExtra)});
            finish();
        } else {
            getString(R.l.app_tip);
            p a = h.a(this, getString(R.l.wv_uploading), false, null);
            au.DF().a(new bg(new 1(this, stringExtra, intExtra)), 0);
            au.a(new 3(this, a, new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    if (!JSAPIUploadLogHelperUI.this.isFinishing()) {
                        JSAPIUploadLogHelperUI.this.finish();
                    }
                }
            }));
        }
    }

    protected void onDestroy() {
        x.i("MicroMsg.JSAPIUploadLogHelperUI", "onDestroy called, isRunning:%b", new Object[]{Boolean.valueOf(mIsRunning)});
        super.onDestroy();
    }
}
