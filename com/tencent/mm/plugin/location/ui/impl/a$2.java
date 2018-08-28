package com.tencent.mm.plugin.location.ui.impl;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.fav.a.b;

class a$2 implements OnClickListener {
    final /* synthetic */ a kIc;

    a$2(a aVar) {
        this.kIc = aVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("key_fav_item_id", this.kIc.activity.getIntent().getLongExtra("kFavInfoLocalId", -1));
        intent.putExtra("key_fav_result_list", this.kIc.activity.getIntent().getStringArrayListExtra("kTags"));
        b.a(this.kIc.activity, ".ui.FavTagEditUI", intent, 4100);
    }
}
