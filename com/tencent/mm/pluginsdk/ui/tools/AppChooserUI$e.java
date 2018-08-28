package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.e.a.d;
import com.tencent.mm.plugin.e.a.f;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.widget.a.c;

class AppChooserUI$e {
    OnDismissListener DJ;
    String cZH;
    public c fad;
    BaseAdapter hAv;
    Context mContext;
    final /* synthetic */ AppChooserUI qRB;
    ListViewInScrollView qRK = ((ListViewInScrollView) View.inflate(this.mContext, d.app_choose_layout, null));
    OnItemClickListener qRL;
    OnClickListener qRM;
    OnClickListener qRy;

    public AppChooserUI$e(AppChooserUI appChooserUI, Context context) {
        this.qRB = appChooserUI;
        this.mContext = context;
    }

    public final void kU(boolean z) {
        if (this.fad == null) {
            return;
        }
        if (z) {
            this.fad.a(f.app_use_once, this.qRy);
            this.fad.b(f.app_use_always, this.qRM);
            return;
        }
        this.fad.a(f.app_use_once, null);
        this.fad.b(f.app_use_always, null);
    }
}
