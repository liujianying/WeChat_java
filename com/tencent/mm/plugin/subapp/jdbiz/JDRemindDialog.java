package com.tencent.mm.plugin.subapp.jdbiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.x;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;

public class JDRemindDialog extends MMBaseActivity {
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
        if (getIntent() != null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                a aVar = new a(this);
                aVar.abt("");
                aVar.abu(extras.getString("alertcontent"));
                aVar.abx(extras.getString("alertconfirm")).a(new 1(this));
                aVar.aby(extras.getString("alert_cancel")).b(new 2(this));
                this.evj = aVar.anj();
                this.evj.setCanceledOnTouchOutside(false);
                this.evj.show();
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent(context, JDRemindDialog.class);
        intent.putExtra("alertcontent", str);
        intent.putExtra("alertconfirm", str2);
        intent.putExtra("alert_cancel", str3);
        intent.putExtra("alertjumpurl", str4);
        intent.putExtra("alert_activityid", str5);
        intent.addFlags(805306368);
        context.startActivity(intent);
    }
}
