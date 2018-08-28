package com.tencent.mm.plugin.af.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.plugin.scanner.b;

class c$1 implements OnClickListener {
    final /* synthetic */ h mjb;
    final /* synthetic */ int mjc;
    final /* synthetic */ int mjd;
    final /* synthetic */ c$a mje;
    final /* synthetic */ Intent val$intent;

    c$1(Intent intent, h hVar, int i, int i2, c$a c_a) {
        this.val$intent = intent;
        this.mjb = hVar;
        this.mjc = i;
        this.mjd = i2;
        this.mje = c_a;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.val$intent.putExtra("title", this.mjb.getTitle());
        this.val$intent.putExtra("rawUrl", this.mjb.QL());
        if (this.mjc == 2) {
            this.val$intent.putExtra("stastic_scene", 13);
        } else if (this.mjc == 1) {
            this.val$intent.putExtra("stastic_scene", 14);
        } else {
            this.val$intent.putExtra("stastic_scene", 11);
        }
        this.val$intent.putExtra("pay_channel", c.vc(this.mjd));
        this.val$intent.putExtra("geta8key_session_id", this.mjb.QS());
        this.val$intent.putExtra("geta8key_cookie", this.mjb.QT());
        b.ezn.j(this.val$intent, this.mje.getContext());
    }
}
