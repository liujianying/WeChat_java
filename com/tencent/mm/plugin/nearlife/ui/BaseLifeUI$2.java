package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class BaseLifeUI$2 implements OnClickListener {
    final /* synthetic */ BaseLifeUI lDH;

    BaseLifeUI$2(BaseLifeUI baseLifeUI) {
        this.lDH = baseLifeUI;
    }

    public final void onClick(View view) {
        if (this.lDH.lDs == null) {
            x.e("MicroMsg.BaseLifeUI", "Location is null");
            return;
        }
        h.mEJ.h(11138, new Object[]{"1", Integer.valueOf(BaseLifeUI.b(this.lDH).getCount() + 1), this.lDH.fuu});
        Intent intent = new Intent();
        intent.setClass(this.lDH, NearLifeCreatePoiUI.class);
        intent.putExtra("get_lat", this.lDH.lDs.rms);
        intent.putExtra("get_lng", this.lDH.lDs.rmr);
        intent.putExtra("get_preci", this.lDH.lDs.ryV);
        intent.putExtra("get_poi_name", BaseLifeUI.b(this.lDH).biZ());
        intent.putExtra("get_cur_lat", this.lDH.lDt);
        intent.putExtra("get_cur_lng", this.lDH.lDu);
        intent.putExtra("get_accuracy", this.lDH.lDw);
        intent.putExtra("get_loctype", this.lDH.lDv);
        intent.putExtra("search_id", this.lDH.fuu);
        intent.putExtra("get_is_mars", this.lDH.dSc);
        this.lDH.startActivityForResult(intent, 1);
    }
}
