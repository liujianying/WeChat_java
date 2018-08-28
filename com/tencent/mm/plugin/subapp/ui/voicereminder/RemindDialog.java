package com.tencent.mm.plugin.subapp.ui.voicereminder;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.model.am.d;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.a.c;
import java.util.ArrayList;
import java.util.List;

@a(3)
public class RemindDialog extends Activity {
    private static boolean bIq = false;
    private static List<String> otR = new ArrayList();
    private c eIW;
    private ag handler = new ag();
    private List<String> otQ = new ArrayList();
    private d otS = new 1(this);
    private String talker = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        c.a aVar = new c.a(this);
        aVar.Gq(R.l.voice_reminder_dialog_title);
        aVar.abu(" ");
        aVar.Gt(R.l.voice_reminder_dialog_check).a(new 2(this));
        aVar.Gu(R.l.voice_reminder_dialog_ignore).b(new 3(this));
        aVar.a(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                RemindDialog.this.finish();
            }
        });
        this.talker = getIntent().getStringExtra("_RemindDialog_User");
        String stringExtra = getIntent().getStringExtra("_RemindDialog_Remind");
        this.otQ.clear();
        this.otQ.add(stringExtra);
        for (String stringExtra2 : otR) {
            this.otQ.add(stringExtra2);
        }
        this.eIW = aVar.anj();
        this.eIW.setCanceledOnTouchOutside(false);
        this.eIW.show();
        bGB();
    }

    private void bGB() {
        this.handler.post(new 5(this));
    }

    public void onResume() {
        bIq = true;
        com.tencent.mm.plugin.subapp.c.d bGs = com.tencent.mm.plugin.subapp.c.d.bGs();
        if (bGs != null) {
            bGs.a(this.otS);
        }
        super.onResume();
    }

    public void onPause() {
        bIq = false;
        com.tencent.mm.plugin.subapp.c.d bGs = com.tencent.mm.plugin.subapp.c.d.bGs();
        if (bGs != null) {
            bGs.b(this.otS);
        }
        super.onPause();
    }

    public static void w(Context context, String str, String str2) {
        x.d("MicroMsg.RemindDialog", "show " + bIq + " remind " + str2);
        if (bIq) {
            otR.add(str2);
            return;
        }
        otR.clear();
        bIq = true;
        Intent intent;
        if (au.DF().foreground) {
            intent = new Intent(context, RemindDialog.class);
            intent.putExtra("_RemindDialog_User", str);
            intent.putExtra("_RemindDialog_Remind", str2);
            intent.setFlags(603979776);
            intent.addFlags(268435456);
            context.startActivity(intent);
            return;
        }
        intent = new Intent(context, RemindDialog.class);
        intent.putExtra("_RemindDialog_User", str);
        intent.putExtra("_RemindDialog_Remind", str2);
        intent.setFlags(604012544);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }
}
