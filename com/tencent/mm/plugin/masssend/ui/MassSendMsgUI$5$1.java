package com.tencent.mm.plugin.masssend.ui;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.5;
import com.tencent.mm.sdk.platformtools.ah;

class MassSendMsgUI$5$1 implements Runnable {
    final /* synthetic */ int fXT;
    final /* synthetic */ String iRk;
    final /* synthetic */ String lbo;
    final /* synthetic */ 5 lbp;

    MassSendMsgUI$5$1(5 5, String str, String str2, int i) {
        this.lbp = 5;
        this.iRk = str;
        this.lbo = str2;
        this.fXT = i;
    }

    public final void run() {
        if (MassSendMsgUI.a(this.lbp.lbm, this.iRk, this.lbo)) {
            ah.A(new 1(this));
        } else {
            ah.A(new Runnable() {
                public final void run() {
                    Toast.makeText(MassSendMsgUI$5$1.this.lbp.lbm, MassSendMsgUI$5$1.this.lbp.lbm.getString(R.l.video_export_file_too_big), 0).show();
                    if (MassSendMsgUI.e(MassSendMsgUI$5$1.this.lbp.lbm) != null) {
                        MassSendMsgUI.e(MassSendMsgUI$5$1.this.lbp.lbm).dismiss();
                        MassSendMsgUI.f(MassSendMsgUI$5$1.this.lbp.lbm);
                    }
                }
            });
        }
    }
}
