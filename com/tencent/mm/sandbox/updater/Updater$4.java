package com.tencent.mm.sandbox.updater;

import android.content.Intent;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bta;
import com.tencent.mm.protocal.c.op;
import com.tencent.mm.sdk.platformtools.bi;

class Updater$4 implements e {
    final /* synthetic */ Updater sEw;
    final /* synthetic */ TextView sEy;

    Updater$4(Updater updater, TextView textView) {
        this.sEw = updater;
        this.sEy = textView;
    }

    public final void a(int i, int i2, String str, l lVar) {
        au.DF().b(922, Updater.g(this.sEw));
        Updater.a(this.sEw, null);
        if (i == 0 && i2 == 0) {
            bta bta = ((op) ((b) lVar.dJd).dIE.dIL).rsS;
            e eVar = new e(bta);
            if (bta == null || bta.sqt != 3) {
                if (Updater.h(this.sEw).findViewById(R.h.mm_progress_dialog_icon) != null) {
                    Updater.h(this.sEw).findViewById(R.h.mm_progress_dialog_icon).setVisibility(8);
                }
                if (this.sEy != null) {
                    h.mEJ.a(405, 63, 1, true);
                    this.sEy.setText(R.l.update_noupdate);
                    return;
                }
                return;
            }
            Intent intent = new Intent(this.sEw.getContext(), AppUpdaterUI.class);
            if (e.EI(eVar.clientVersion)) {
                String str2 = bi.oW(eVar.kno) ? "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index" : eVar.kno;
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setClassName(this.sEw.getContext().getPackageName(), this.sEw.getContext().getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
                intent2.putExtra("rawUrl", str2);
                intent2.putExtra("useJs", true);
                intent2.putExtra("vertical_scroll", true);
                intent2.setFlags(872415232);
                this.sEw.getContext().startActivity(intent2);
            } else {
                this.sEw.a(intent, eVar);
                this.sEw.getContext().startActivity(intent);
            }
            if (Updater.h(this.sEw) != null) {
                Updater.h(this.sEw).cancel();
            }
            this.sEw.onStop();
            return;
        }
        if (Updater.h(this.sEw).findViewById(R.h.mm_progress_dialog_icon) != null) {
            Updater.h(this.sEw).findViewById(R.h.mm_progress_dialog_icon).setVisibility(8);
        }
        if (this.sEy != null) {
            h.mEJ.a(405, 63, 1, true);
            this.sEy.setText(R.l.update_noupdate);
        }
    }
}
