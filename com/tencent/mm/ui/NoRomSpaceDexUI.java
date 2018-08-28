package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;

public class NoRomSpaceDexUI extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.initLanguage(ad.getContext());
        setContentView(R.i.no_space_dex);
        CharSequence string = getString(R.l.check_db_size_tip_dangerous_message);
        q qVar = new q(this);
        qVar.setTitle(R.l.check_db_size_tip_dangerous_title);
        qVar.tlz.setVisibility(0);
        qVar.tlx.setVisibility(0);
        qVar.tlx.setText(string);
        string = getString(R.l.check_db_size_btn_dangerous_message);
        OnClickListener anonymousClass1 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                Process.killProcess(Process.myPid());
            }
        };
        if (qVar.pxh != null) {
            qVar.pxh.setVisibility(0);
            qVar.pxh.setText(string);
            qVar.pxh.setOnClickListener(new com.tencent.mm.ui.q.AnonymousClass1(anonymousClass1));
        }
        qVar.setCancelable(false);
        qVar.cpX();
        qVar.show();
    }
}
