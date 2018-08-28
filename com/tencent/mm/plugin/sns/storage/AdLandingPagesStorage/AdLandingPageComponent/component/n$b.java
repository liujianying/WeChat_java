package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.io.Serializable;

class n$b extends BroadcastReceiver implements Serializable {
    final /* synthetic */ n nDS;

    private n$b(n nVar) {
        this.nDS = nVar;
    }

    /* synthetic */ n$b(n nVar, byte b) {
        this(nVar);
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            Object schemeSpecificPart;
            if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                if (!TextUtils.isEmpty(schemeSpecificPart) && schemeSpecificPart.equals(n.b(this.nDS).rU)) {
                    this.nDS.nDO.Dd(3);
                }
            } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                if (!TextUtils.isEmpty(schemeSpecificPart) && schemeSpecificPart.equals(n.b(this.nDS).rU)) {
                    this.nDS.nDO.Dd(4);
                }
            }
        }
    }
}
