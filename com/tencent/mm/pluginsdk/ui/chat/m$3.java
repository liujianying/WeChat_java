package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.emotion.EmojiInfo;

class m$3 implements OnItemClickListener {
    final /* synthetic */ m qNl;

    m$3(m mVar) {
        this.qNl = mVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        EmojiInfo oO = this.qNl.qNh == null ? null : this.qNl.qNh.oO(i);
        if (!(oO == null || this.qNl.qNc == null || this.qNl.qLL == null)) {
            this.qNl.qNc.l(oO);
            this.qNl.qLL.clear();
            h.mEJ.h(10994, new Object[]{Integer.valueOf(1), this.qNl.qNd, "", Integer.valueOf(i), oO.Xh(), Integer.valueOf(this.qNl.qNh.getCount())});
        }
        this.qNl.qNa.dismiss();
    }
}
