package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.sdk.platformtools.bi;

class SnsInfoFlip$5 implements OnItemLongClickListener {
    final /* synthetic */ SnsInfoFlip nXg;

    SnsInfoFlip$5(SnsInfoFlip snsInfoFlip) {
        this.nXg = snsInfoFlip;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!SnsInfoFlip.i(this.nXg)) {
            return true;
        }
        String str = ((b) SnsInfoFlip.d(this.nXg).getItem(i)).nuP;
        if (bi.oW(str)) {
            return false;
        }
        String str2 = ((b) SnsInfoFlip.d(this.nXg).getItem(i)).caK.ksA;
        this.nXg.f(an.s(af.getAccSnsPath(), str2) + i.l(((b) SnsInfoFlip.d(this.nXg).getItem(i)).caK), str, str2, true);
        return true;
    }
}
