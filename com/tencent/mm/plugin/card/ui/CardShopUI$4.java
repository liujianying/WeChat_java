package com.tencent.mm.plugin.card.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class CardShopUI$4 extends BroadcastReceiver {
    final /* synthetic */ CardShopUI hGu;

    CardShopUI$4(CardShopUI cardShopUI) {
        this.hGu = cardShopUI;
    }

    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null && action.equals("android.intent.action.LOCALE_CHANGED") && CardShopUI.ayY()) {
            CardShopUI.e(this.hGu);
        }
    }
}
