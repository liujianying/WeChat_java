package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.shake.ui.ShakeItemListUI.a;

class ShakeItemListUI$a$a {
    TextView eIz;
    ImageView eKk;
    TextView eKl;
    TextView lCl;
    TextView lCm;
    ImageView lCn;
    final /* synthetic */ a mZD;
    View mZE;
    ImageView mZF;
    TextView mZG;
    LinearLayout mZH;
    TextView mZI;

    ShakeItemListUI$a$a(a aVar) {
        this.mZD = aVar;
    }

    public final void clear() {
        if (this.eKk != null) {
            this.eKk.setImageDrawable(null);
            this.eKk.setVisibility(8);
        }
        if (this.eIz != null) {
            this.eIz.setText("");
            this.eIz.setVisibility(8);
        }
        if (this.eKl != null) {
            this.eKl.setVisibility(8);
        }
        if (this.mZF != null) {
            this.mZF.setVisibility(8);
        }
        if (this.lCl != null) {
            this.lCl.setText("");
            this.lCl.setVisibility(8);
        }
        if (this.lCm != null) {
            this.lCm.setVisibility(8);
            this.mZE.setVisibility(8);
        }
        if (this.lCn != null) {
            this.lCn.setVisibility(8);
        }
        if (this.mZG != null) {
            this.mZG.setText("");
            this.mZG.setVisibility(8);
        }
    }
}
