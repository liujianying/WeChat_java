package com.tencent.mm.plugin.location.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.map.a.a;
import com.tencent.mm.plugin.map.a.h;

class LocationExtUI$2 implements OnClickListener {
    final /* synthetic */ LocationExtUI kEB;

    LocationExtUI$2(LocationExtUI locationExtUI) {
        this.kEB = locationExtUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.kEB.mController.tml, RemarkUI.class);
        intent.putExtra("key_nullable", true);
        intent.putExtra("key_value", this.kEB.getIntent().getStringExtra("key_value"));
        intent.putExtra("key_hint", this.kEB.getString(h.location_remark_hint));
        intent.putExtra("Kwebmap_locaion", this.kEB.getIntent().getStringExtra("Kwebmap_locaion"));
        intent.putExtra("MMActivity.OverrideExitAnimation", a.push_down_out);
        intent.putExtra("MMActivity.OverrideEnterAnimation", a.fast_faded_in);
        intent.putExtra("kFavInfoLocalId", this.kEB.getIntent().getLongExtra("kFavInfoLocalId", -1));
        intent.putExtra("kRemark", this.kEB.getIntent().getStringExtra("kRemark"));
        this.kEB.startActivityForResult(intent, 4097);
    }
}
