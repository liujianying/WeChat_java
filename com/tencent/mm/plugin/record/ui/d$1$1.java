package com.tencent.mm.plugin.record.ui;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.d.1;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

class d$1$1 implements Runnable {
    final /* synthetic */ c msA;
    final /* synthetic */ 1 msB;

    d$1$1(1 1, c cVar) {
        this.msB = 1;
        this.msA = cVar;
    }

    public final void run() {
        View view = (View) com.tencent.mm.plugin.record.ui.b.c.mtG.get(this.msA.field_dataId);
        String str = "MicroMsg.FavRecordAdapter";
        String str2 = "view is null %s";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(view == null);
        x.d(str, str2, objArr);
        if (view != null) {
            b bVar = (b) view.getTag();
            str2 = com.tencent.mm.plugin.record.b.b.a(bVar);
            x.d("MicroMsg.FavRecordAdapter", "dataItemId: %s", new Object[]{bVar.bOz.jdM});
            if (bVar.bOz.jdM.equals(this.msA.field_dataId)) {
                x.d("MicroMsg.FavRecordAdapter", "change the sight status %s, dataId %s, progress %s cdnInfo %s", new Object[]{Integer.valueOf(this.msA.field_status), this.msA.field_dataId, Float.valueOf(this.msA.getProgress()), Boolean.valueOf(this.msA.isFinished())});
                ImageView imageView = (ImageView) view.findViewById(R.h.status_btn);
                MMPinProgressBtn mMPinProgressBtn = (MMPinProgressBtn) view.findViewById(R.h.progress);
                a aVar = (a) view.findViewById(R.h.image);
                imageView.setVisibility(8);
                mMPinProgressBtn.setVisibility(8);
                x.i("MicroMsg.FavRecordAdapter", "setVideoPath " + str2);
                aVar.setCanPlay(true);
                aVar.aO(str2, false);
            }
        }
    }
}
