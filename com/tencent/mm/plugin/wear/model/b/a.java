package com.tencent.mm.plugin.wear.model.b;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.ad;

public final class a {
    public static void L(Bundle bundle) {
        Intent intent = new Intent();
        intent.setPackage(ad.getContext().getPackageName());
        intent.setAction("com.tencent.mm.wear.message");
        intent.putExtras(bundle);
        ad.getContext().sendBroadcast(intent);
    }
}
