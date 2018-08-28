package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.widget.QFadeImageView;

class at$d extends at$a {
    TextView nDf;
    final /* synthetic */ at nZP;
    MaskImageView oab;
    QFadeImageView oac;
    QFadeImageView oad;
    QFadeImageView oae;
    TextView oaf;
    TextView oag;
    TextView oah;
    TextView oai;
    View oaj;
    TextView oak;
    TextView oal;
    TextView oam;
    TextView oan;
    TextView oao;
    TextView oap;
    MaskLinearLayout oaq;

    at$d(at atVar) {
        this.nZP = atVar;
        super(atVar);
    }

    public final void init() {
        super.init();
        this.oab.setVisibility(8);
        this.oad.setVisibility(8);
        this.oae.setVisibility(8);
        this.nDf.setVisibility(8);
        this.oaf.setVisibility(8);
        this.oag.setVisibility(8);
        this.oah.setVisibility(8);
        this.oai.setVisibility(8);
        this.oaj.setVisibility(8);
        this.oac.setVisibility(8);
        this.oak.setVisibility(8);
        this.oal.setVisibility(8);
        this.oam.setVisibility(8);
        this.oan.setVisibility(8);
        this.oao.setVisibility(8);
        this.oap.setVisibility(8);
        if (ah.fe(at.a(this.nZP)) > 1.0f) {
            this.nDf.setMaxLines(2);
        }
    }
}
