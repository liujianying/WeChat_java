package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;

class h$1 implements OnItemClickListener {
    final /* synthetic */ h kFD;

    h$1(h hVar) {
        this.kFD = hVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str = (String) view.getTag();
        if (!bi.oW(str)) {
            h.mEJ.h(10997, new Object[]{"15", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
            if (this.kFD.kFC != null) {
                this.kFD.kFC.FT(str);
            }
        }
    }
}
