package com.tencent.mm.plugin.location.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.fav.a.b;

class LocationExtUI$1 implements OnClickListener {
    final /* synthetic */ LocationExtUI kEB;

    LocationExtUI$1(LocationExtUI locationExtUI) {
        this.kEB = locationExtUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("key_fav_result_list", LocationExtUI.a(this.kEB));
        b.a(this.kEB.mController.tml, ".ui.FavTagEditUI", intent, 4098);
    }
}
