package com.tencent.mm.plugin.readerapp.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.readerapp.a.g;
import com.tencent.mm.plugin.readerapp.ui.ReaderAppSubscribeUI.a;
import com.tencent.mm.ui.base.h;

class ReaderAppSubscribeUI$1 implements OnItemClickListener {
    final /* synthetic */ ReaderAppSubscribeUI mnG;

    ReaderAppSubscribeUI$1(ReaderAppSubscribeUI readerAppSubscribeUI) {
        this.mnG = readerAppSubscribeUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2 = 1;
        a a = ReaderAppSubscribeUI.a(this.mnG);
        if ((a.mnI & a.mnH[i]) != 0) {
            a.mnI &= a.mnH[i] ^ -1;
            a.mnK--;
            if (a.mnK < 0) {
                a.mnK = 0;
            }
            a.notifyDataSetChanged();
        } else if (a.mnK < 3) {
            a.mnI |= a.mnH[i];
            a.mnK++;
            if (a.mnK > a.mnH.length) {
                a.mnK = a.mnH.length;
            }
            a.notifyDataSetChanged();
        } else {
            i2 = 0;
        }
        if (i2 == 0) {
            h.i(this.mnG, g.contact_info_readerappnews_subscribe_limit, g.app_tip);
        }
    }
}
