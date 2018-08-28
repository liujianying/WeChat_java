package com.tencent.mm.ui.chatting.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.chatting.a.a.d;
import com.tencent.mm.ui.chatting.gallery.g.a;

class a$d$2 implements OnClickListener {
    final /* synthetic */ a tNQ;
    final /* synthetic */ d tNR;

    a$d$2(d dVar, a aVar) {
        this.tNR = dVar;
        this.tNQ = aVar;
    }

    public final void onClick(View view) {
        boolean z = !this.tNR.jBR.isChecked();
        if (a.cwU().tTJ.size() < 9) {
            this.tNR.jBR.setChecked(z);
            if (z) {
                this.tNR.tNO.setVisibility(0);
            } else {
                this.tNR.tNO.setVisibility(8);
            }
        } else if (!z) {
            this.tNR.jBR.setChecked(false);
        }
        if (this.tNR.tNI.tNG != null) {
            int intValue = ((Integer) view.getTag()).intValue();
            this.tNR.tNI.tNG.a(z, this.tNR.tNI.EY(intValue), intValue);
        }
    }
}
