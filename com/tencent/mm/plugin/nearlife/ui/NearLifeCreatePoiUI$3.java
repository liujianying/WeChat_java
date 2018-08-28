package com.tencent.mm.plugin.nearlife.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;

class NearLifeCreatePoiUI$3 implements OnClickListener {
    final /* synthetic */ NearLifeCreatePoiUI lEr;

    NearLifeCreatePoiUI$3(NearLifeCreatePoiUI nearLifeCreatePoiUI) {
        this.lEr = nearLifeCreatePoiUI;
    }

    public final void onClick(View view) {
        this.lEr.findViewById(R.h.tv_more_content).setVisibility(8);
        this.lEr.findViewById(R.h.ll_pos_category_ctn).setVisibility(0);
        this.lEr.findViewById(R.h.ll_pos_tel_container).setVisibility(0);
    }
}
