package com.tencent.mm.plugin.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;

final class BKGLoaderManager$ConnectivityReceiver extends BroadcastReceiver {
    final /* synthetic */ BKGLoaderManager ijK;

    public BKGLoaderManager$ConnectivityReceiver(BKGLoaderManager bKGLoaderManager) {
        this.ijK = bKGLoaderManager;
    }

    public final void onReceive(Context context, Intent intent) {
        int netType = ao.getNetType(context);
        if (this.ijK.mNetWorkType != netType) {
            x.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] network change type:%d", new Object[]{Integer.valueOf(netType)});
            if (BKGLoaderManager.aDK()) {
                this.ijK.aEW();
            } else if (BKGLoaderManager.aEY()) {
                this.ijK.aEV();
            } else if (ao.isConnected(ad.getContext())) {
                this.ijK.aEX();
            } else {
                this.ijK.aEW();
            }
            this.ijK.mNetWorkType = netType;
        }
    }
}
