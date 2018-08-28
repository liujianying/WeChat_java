package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.q;

class ExdeviceProfileAffectedUserView$2 implements OnClickListener {
    final /* synthetic */ ExdeviceProfileAffectedUserView iDP;

    ExdeviceProfileAffectedUserView$2(ExdeviceProfileAffectedUserView exdeviceProfileAffectedUserView) {
        this.iDP = exdeviceProfileAffectedUserView;
    }

    public final void onClick(View view) {
        String GF = q.GF();
        if (GF != null && GF.equals(ExdeviceProfileAffectedUserView.a(this.iDP))) {
            ExdeviceProfileAffectedUserView.b(this.iDP).setVisibility(ExdeviceProfileAffectedUserView.b(this.iDP).getVisibility() == 0 ? 8 : 0);
        }
    }
}
