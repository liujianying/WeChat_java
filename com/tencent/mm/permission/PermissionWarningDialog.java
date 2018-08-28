package com.tencent.mm.permission;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.x;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;
import com.tencent.mm.ui.widget.a.e;

public class PermissionWarningDialog extends MMBaseActivity {
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
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.PermissionWarningDialog", "Intent is null");
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.PermissionWarningDialog", "invalid params");
            return;
        }
        int i = extras.getInt("warning_type", 0);
        a aVar;
        if (1 == i) {
            aVar = new a(this);
            aVar.abt(extras.getString("warning_title"));
            aVar.abu(extras.getString("warning_content"));
            aVar.Gt(R.l.app_i_known).a(new 1(this));
            this.evj = aVar.anj();
            this.evj.setCanceledOnTouchOutside(false);
            this.evj.show();
        } else if (2 == i) {
            aVar = new a(this);
            boolean z = extras.getBoolean("warning_filter", false);
            boolean z2 = extras.getBoolean("warning_due2Exception", false);
            aVar.Gq(R.l.app_permission_tips_upload_title);
            aVar.abu(getString(R.l.app_permission_tips_policy_tips));
            aVar.Gu(R.l.app_cancel).b(new 2(this, z2));
            aVar.Gt(R.l.app_permission_allow_upload).a(new 3(this, z, z2));
            this.evj = aVar.anj();
            this.evj.setCanceledOnTouchOutside(false);
            this.evj.show();
        } else if (3 == i) {
            e.a abA = new e.a(this).abA(getString(R.l.app_microphone_mute_dlg_message));
            abA.uKu = getString(R.l.app_ignore);
            abA.uKt = getString(R.l.app_microphone_mute_dlg_ok);
            abA.a(new 4(this)).eIW.show();
        }
    }

    public static void m(Context context, String str, String str2) {
        Intent intent = new Intent(context, PermissionWarningDialog.class);
        intent.putExtra("warning_type", 1);
        intent.putExtra("warning_title", str);
        intent.putExtra("warning_content", str2);
        intent.addFlags(805306368);
        context.startActivity(intent);
    }

    public static void b(Context context, boolean z, boolean z2) {
        Intent intent = new Intent(context, PermissionWarningDialog.class);
        intent.putExtra("warning_type", 2);
        intent.putExtra("warning_filter", z);
        intent.putExtra("warning_due2Exception", z2);
        intent.addFlags(805306368);
        context.startActivity(intent);
    }

    public static void bV(Context context) {
        Intent intent = new Intent(context, PermissionWarningDialog.class);
        intent.putExtra("warning_type", 3);
        intent.addFlags(805306368);
        context.startActivity(intent);
    }
}
