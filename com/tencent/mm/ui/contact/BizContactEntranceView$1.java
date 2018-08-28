package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;

class BizContactEntranceView$1 implements OnClickListener {
    final /* synthetic */ BizContactEntranceView uil;

    BizContactEntranceView$1(BizContactEntranceView bizContactEntranceView) {
        this.uil = bizContactEntranceView;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("intent_service_type", 251658241);
        d.b(view.getContext(), "brandservice", ".ui.BrandServiceIndexUI", intent);
    }
}
