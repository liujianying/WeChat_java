package com.tencent.mm.pluginsdk.permission;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.x;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;

public class RequestFloatWindowPermissionDialog extends MMBaseActivity {
    public static int qBg = 1234;
    private static a qBh;
    private c evj = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        Vl();
    }

    protected void onResume() {
        super.onResume();
        x.b(true, null);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (this.evj != null) {
            this.evj.dismiss();
            this.evj = null;
        }
        Vl();
    }

    protected void onPause() {
        super.onPause();
        x.b(false, null);
    }

    private void Vl() {
        if (getIntent() == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.RequestFloatWindowPermissionDialog", "Intent is null");
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.RequestFloatWindowPermissionDialog", "invalid params");
            return;
        }
        a aVar = new a(this);
        aVar.Gq(h.float_window_permission_alert_title);
        aVar.abu(extras.getString("warning_content"));
        aVar.e(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                RequestFloatWindowPermissionDialog.this.finish();
            }
        });
        aVar.Gt(d.fR(23) ? h.float_window_permission_alert_ok_M : h.float_window_permission_alert_ok).a(new 2(this));
        this.evj = aVar.anj();
        this.evj.setCanceledOnTouchOutside(false);
        this.evj.show();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (qBh != null) {
            if (i != qBg) {
                qBh.b(this);
            } else if (b.bv(ad.getContext())) {
                qBh.a(this);
            } else {
                qBh.b(this);
            }
        }
    }

    public static void a(Context context, String str, a aVar) {
        qBh = aVar;
        Intent intent = new Intent(context, RequestFloatWindowPermissionDialog.class);
        intent.putExtra("warning_content", str);
        intent.addFlags(805306368);
        context.startActivity(intent);
    }
}
