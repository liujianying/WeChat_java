package com.tencent.mm.plugin.voip;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;

public class HeadsetPlugReceiver extends BroadcastReceiver {
    private a oGW = null;

    public void onReceive(Context context, Intent intent) {
        x.d("MicroMsg.HeadsetPlugReceiver", "headset onReceive %s  %d", new Object[]{intent.getAction(), Integer.valueOf(intent.getIntExtra(DownloadInfoColumns.STATE, 0))});
        if (intent.getAction() != null && intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
            if (intent.getIntExtra(DownloadInfoColumns.STATE, 0) == 0) {
                if (this.oGW != null) {
                    this.oGW.fV(false);
                }
            } else if (intent.getIntExtra(DownloadInfoColumns.STATE, 0) == 1 && this.oGW != null) {
                this.oGW.fV(true);
            }
        }
    }

    public final void a(Context context, a aVar) {
        this.oGW = aVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        context.registerReceiver(this, intentFilter);
    }

    public final void ej(Context context) {
        try {
            context.unregisterReceiver(this);
        } catch (Exception e) {
            x.e("MicroMsg.HeadsetPlugReceiver", "unregisterReceiver(HeadsetPlugReceiver.this) error:%s", new Object[]{e.getMessage()});
        }
        this.oGW = null;
    }
}
