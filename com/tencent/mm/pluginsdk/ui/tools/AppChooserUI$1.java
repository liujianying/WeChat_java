package com.tencent.mm.pluginsdk.ui.tools;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.report.service.h;

class AppChooserUI$1 implements OnItemClickListener {
    final /* synthetic */ AppChooserUI qRB;

    AppChooserUI$1(AppChooserUI appChooserUI) {
        this.qRB = appChooserUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (AppChooserUI.a(this.qRB) != null) {
            AppChooserUI.a(this.qRB, AppChooserUI.a(this.qRB).Cu(i));
            AppChooserUI.a(this.qRB).notifyDataSetChanged();
            if (AppChooserUI.b(this.qRB) != null && AppChooserUI.b(this.qRB).fad.isShowing()) {
                if (AppChooserUI.c(this.qRB) == null || !AppChooserUI.c(this.qRB).qRI || (AppChooserUI.c(this.qRB).knb && (AppChooserUI.c(this.qRB).oEK || AppChooserUI.d(this.qRB) >= AppChooserUI.e(this.qRB)))) {
                    AppChooserUI.b(this.qRB).kU(true);
                } else {
                    AppChooserUI.b(this.qRB).kU(false);
                }
            }
            if ((AppChooserUI.f(this.qRB) == 6 || AppChooserUI.g(this.qRB) == 2) && AppChooserUI.c(this.qRB) != null && AppChooserUI.c(this.qRB).qRF != null) {
                AppChooserUI.a(this.qRB, AppChooserUI.c(this.qRB).qRF.activityInfo.packageName, false);
                h.mEJ.h(12809, new Object[]{Integer.valueOf(4), AppChooserUI.c(this.qRB).qRF.activityInfo.packageName});
            }
        }
    }
}
