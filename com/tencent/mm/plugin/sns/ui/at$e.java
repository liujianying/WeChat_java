package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.ui.at.a;
import com.tencent.mm.ui.ah;

class at$e extends a {
    TextView nDf;
    final /* synthetic */ at nZP;
    MaskImageView oab;
    View oaj;
    TextView oak;
    MaskLinearLayout oaq;

    at$e(at atVar) {
        this.nZP = atVar;
        super(atVar);
    }

    public final void init() {
        super.init();
        this.oab.setVisibility(8);
        this.nDf.setVisibility(8);
        this.oak.setVisibility(8);
        this.oaj.setVisibility(8);
        if (ah.fe(at.a(this.nZP)) > 1.0f) {
            this.nDf.setMaxLines(2);
        }
    }
}
