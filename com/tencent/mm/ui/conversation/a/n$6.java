package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;

class n$6 implements OnClickListener {
    final /* synthetic */ n usU;
    final /* synthetic */ Intent val$intent;

    n$6(n nVar, Intent intent) {
        this.usU = nVar;
        this.val$intent = intent;
    }

    public final void onClick(View view) {
        d.b((Context) this.usU.qJS.get(), "webwx", ".ui.WebWXLogoutUI", this.val$intent);
    }
}
