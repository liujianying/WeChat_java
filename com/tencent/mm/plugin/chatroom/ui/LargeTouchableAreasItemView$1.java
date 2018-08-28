package com.tencent.mm.plugin.chatroom.ui;

import android.view.View;
import android.view.View.OnClickListener;

class LargeTouchableAreasItemView$1 implements OnClickListener {
    final /* synthetic */ LargeTouchableAreasItemView hMO;

    LargeTouchableAreasItemView$1(LargeTouchableAreasItemView largeTouchableAreasItemView) {
        this.hMO = largeTouchableAreasItemView;
    }

    public final void onClick(View view) {
        this.hMO.setItemViewSelected(!LargeTouchableAreasItemView.a(this.hMO));
        if (LargeTouchableAreasItemView.b(this.hMO) != null) {
            LargeTouchableAreasItemView.b(this.hMO).dZ(LargeTouchableAreasItemView.a(this.hMO));
        }
    }
}
