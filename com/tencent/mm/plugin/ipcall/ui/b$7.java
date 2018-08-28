package com.tencent.mm.plugin.ipcall.ui;

import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;

class b$7 implements OnClickListener {
    final /* synthetic */ b ktn;

    b$7(b bVar) {
        this.ktn = bVar;
    }

    public final void onClick(View view) {
        b bVar = this.ktn;
        bVar.ktc = bVar.ksU.getText().toString();
        bVar.ktd = bVar.ksV.getText().toString();
        String string;
        if (bi.oW(bVar.ktc) || bi.oW(bVar.ktd)) {
            string = ad.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputPhoneNumber", "");
            if (!bi.oW(string)) {
                bVar.ktd = b.dr(bVar.ksU.getText().toString().replace("+", ""), c.Fx(string));
                bVar.bx(bVar.ktd, -1);
                bVar.aYa();
                return;
            }
            return;
        }
        bVar.ktc = bVar.ksU.getText().toString().replace("+", "");
        bVar.kte = a.av(bVar.bGc, bVar.ktc + bVar.ktd);
        bVar.dCw = a.ax(bVar.bGc, bVar.kte);
        string = c.Fx(bVar.ktd);
        Editor edit = ad.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
        edit.putString("IPCall_LastInputPhoneNumber", string);
        edit.apply();
        String charSequence = bVar.ksU.getText().toString();
        string = bVar.ktb;
        if (!bi.oW(charSequence)) {
            if (bi.oW(string)) {
                string = "";
            }
            Editor edit2 = ad.getContext().getSharedPreferences("IPCall_LastInputPref", 0).edit();
            edit2.putString("IPCall_LastInputCountryCode", charSequence.replace("+", ""));
            edit2.putString("IPCall_LastInputCountryName", string);
            edit2.apply();
        }
        if (bVar.ksS != null) {
            bVar.ksS.l(bVar.ktc, c.Fx(bVar.ktd), bVar.kte, bVar.dCw);
        }
    }
}
