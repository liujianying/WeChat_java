package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.qqmail.b.p;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Map;

class ReadMailUI$a$1 implements Runnable {
    final /* synthetic */ Map miM;
    final /* synthetic */ a miN;

    ReadMailUI$a$1(a aVar, Map map) {
        this.miN = aVar;
        this.miM = map;
    }

    public final void run() {
        if (ReadMailUI.b(this.miN.miD).equals(ReadMailUI.a(this.miN.miD))) {
            if (ReadMailUI.c(this.miN.miD).getSize() == 0) {
                ReadMailUI.c(this.miN.miD).a(ReadMailUI.b(this.miM, ".Response.result.tolist", bi.getInt((String) this.miM.get(".Response.result.tolistlen"), 0)), true);
            }
            if (ReadMailUI.d(this.miN.miD).getSize() == 0) {
                String[] b = ReadMailUI.b(this.miM, ".Response.result.cclist", bi.getInt((String) this.miM.get(".Response.result.cclistlen"), 0));
                LinearLayout e = ReadMailUI.e(this.miN.miD);
                int i = (b == null || b.length == 0) ? 8 : 0;
                e.setVisibility(i);
                ReadMailUI.d(this.miN.miD).a(b, true);
            }
            String str = (String) this.miM.get(".Response.result.content");
            ReadMailUI.a(this.miN.miD, this.miM);
            String str2 = (String) this.miM.get(".Response.result.tips.wording");
            if (!bi.oW(str2)) {
                if ("1".equals((String) this.miM.get(".Response.result.tips.color"))) {
                    ReadMailUI.f(this.miN.miD).setBackgroundColor(-13627);
                    ReadMailUI.f(this.miN.miD).setTextColor(-7515315);
                }
                ReadMailUI.f(this.miN.miD).setText(str2);
                ((View) ReadMailUI.f(this.miN.miD).getParent()).setVisibility(0);
            }
            ReadMailUI.g(this.miN.miD).loadDataWithBaseURL(p.bor() + "?pageWidth=" + ReadMailUI.bpl(), "<html style=\"margin-top:" + ReadMailUI.TE() + "px\">" + str + "</html>", "text/html", "utf-8", null);
        }
    }
}
