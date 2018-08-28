package com.tencent.mm.plugin.kitchen.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.kitchen.ui.KvInfoUI;

public final class a implements com.tencent.mm.plugin.kitchen.a.a {
    public final void s(Context context, Intent intent) {
        intent.setClass(context, KvInfoUI.class);
        context.startActivity(intent);
    }
}
