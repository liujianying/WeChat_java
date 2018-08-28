package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.ui.BaseActivity.b;

class BaseActivity$5 implements OnLongClickListener {
    final /* synthetic */ BaseActivity tgA;
    final /* synthetic */ b tgB;

    BaseActivity$5(BaseActivity baseActivity, b bVar) {
        this.tgA = baseActivity;
        this.tgB = bVar;
    }

    public final boolean onLongClick(View view) {
        return BaseActivity.a(view, this.tgB);
    }
}
