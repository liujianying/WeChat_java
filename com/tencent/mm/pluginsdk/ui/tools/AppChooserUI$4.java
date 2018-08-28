package com.tencent.mm.pluginsdk.ui.tools;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI.f;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class AppChooserUI$4 implements OnClickListener {
    final /* synthetic */ AppChooserUI qRB;

    AppChooserUI$4(AppChooserUI appChooserUI) {
        this.qRB = appChooserUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.AppChooserUI", "mDownloadOnClickListener");
        if (AppChooserUI.a(this.qRB) != null) {
            int i = AppChooserUI.a(this.qRB).qRC;
            if (i == f.qRN) {
                if (AppChooserUI.b(this.qRB) != null && AppChooserUI.b(this.qRB).fad.isShowing()) {
                    AppChooserUI.a(this.qRB).qRC = f.qRO;
                    AppChooserUI.a(this.qRB).notifyDataSetChanged();
                }
                a aVar = new a();
                if (AppChooserUI.f(this.qRB) == 1) {
                    aVar.yQ("http://mdc.html5.qq.com/d/directdown.jsp?channel_id=10375");
                } else {
                    aVar.yQ(AppChooserUI.h(this.qRB).Vw());
                }
                aVar.yS(AppChooserUI.h(this.qRB).cbq());
                aVar.ox(1);
                aVar.ef(true);
                d.aCU().a(aVar.ick);
                s.cbA();
                s.BH(AppChooserUI.g(this.qRB));
                if (AppChooserUI.g(this.qRB) == 0) {
                    if (AppChooserUI.i(this.qRB)) {
                        h.mEJ.h(11168, new Object[]{Integer.valueOf(4), Integer.valueOf(AppChooserUI.f(this.qRB))});
                    } else {
                        h.mEJ.h(11168, new Object[]{Integer.valueOf(3), Integer.valueOf(AppChooserUI.f(this.qRB))});
                    }
                }
                if (AppChooserUI.g(this.qRB) == 1) {
                    h.mEJ.h(12809, new Object[]{Integer.valueOf(5), ""});
                }
            } else if (i == f.qRP) {
                AppChooserUI appChooserUI = this.qRB;
                long j = AppChooserUI.j(this.qRB);
                x.i("MicroMsg.AppChooserUI", "installRecommendApp");
                x.d("MicroMsg.AppChooserUI", "filepath:%s", new Object[]{d.aCU().cm(j).path});
                if (!q.g(appChooserUI.mController.tml, Uri.fromFile(new File(r1)))) {
                    g.Ei().DT().set(appChooserUI.Ct(274560), Long.valueOf(0));
                    if (appChooserUI.qRe != null) {
                        appChooserUI.qRe.qRC = f.qRN;
                        appChooserUI.qRe.notifyDataSetChanged();
                    }
                } else if (appChooserUI.qRe != null) {
                    appChooserUI.qRe.qRC = f.qRP;
                    appChooserUI.qRe.notifyDataSetChanged();
                }
            }
        }
    }
}
