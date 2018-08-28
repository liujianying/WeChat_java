package com.tencent.mm.performance.wxperformancetool;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import com.tencent.mm.bv.b;
import com.tencent.mm.performance.a.a;
import com.tencent.mm.sdk.platformtools.ag;

@TargetApi(17)
public class MemoryLeakActivity extends Activity {
    private AlertDialog euT;
    private ag mHandler = new 1(this);
    private String mKey;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.background_transparent);
        Builder builder = new Builder(this);
        builder.setTitle("memory leak");
        this.mKey = getIntent().getStringExtra("key");
        String stringExtra = getIntent().getStringExtra("tag");
        String stringExtra2 = getIntent().getStringExtra("class");
        if (stringExtra2.contains(" ")) {
            stringExtra2 = stringExtra2.substring(stringExtra2.indexOf(" "));
        }
        String replace = stringExtra2.replace(".", "_");
        builder.setMessage(stringExtra + stringExtra2 + "\n\npath:" + b.tfv + replace + ".zip");
        builder.setCancelable(true);
        builder.setPositiveButton("dumphprof", new 2(this, replace));
        builder.setNegativeButton("cancel", new 3(this));
        builder.setOnDismissListener(new 4(this));
        this.euT = builder.create();
        b.cos();
        this.mHandler.sendEmptyMessageDelayed(0, 200);
    }

    protected void onDestroy() {
        super.onDestroy();
        a.euW.remove(this.mKey);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.euT != null && this.euT.isShowing()) {
            this.euT.dismiss();
            this.euT = null;
        }
    }
}
