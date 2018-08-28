package com.tencent.tencentmap.mapsdk.a;

import android.view.View;
import android.view.View.OnClickListener;

class lj$2 implements OnClickListener {
    final /* synthetic */ lj a;

    lj$2(lj ljVar) {
        this.a = ljVar;
    }

    public void onClick(View view) {
        lj.a(this.a).getMap().b(null);
    }
}
