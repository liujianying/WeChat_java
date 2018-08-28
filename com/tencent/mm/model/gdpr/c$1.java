package com.tencent.mm.model.gdpr;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.model.gdpr.MPGdprPolicyUtil.1.1;
import com.tencent.mm.model.gdpr.ui.MPGdprPolicyUI;
import com.tencent.mm.vending.c.a;

class c$1 implements a<Void, Boolean> {
    final /* synthetic */ String bAj;
    final /* synthetic */ b dEh;
    final /* synthetic */ a dEi;
    final /* synthetic */ Context val$context;

    c$1(b bVar, Context context, a aVar, String str) {
        this.dEh = bVar;
        this.val$context = context;
        this.dEi = aVar;
        this.bAj = str;
    }

    public final /* synthetic */ Object call(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            Intent putExtra = new Intent(this.val$context, MPGdprPolicyUI.class).putExtra("MPGdprPolicyUI_KEY_BUSINESS", this.dEi.dEe).putExtra("MPGdprPolicyUI_KEY_APPID", this.bAj).putExtra("MPGdprPolicyUI_KEY_RECEIVER", new 1(this, new Handler(Looper.getMainLooper())));
            if (!(this.val$context instanceof Activity)) {
                putExtra.addFlags(268435456);
            }
            this.val$context.startActivity(putExtra);
        }
        return null;
    }
}
