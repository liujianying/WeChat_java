package com.tencent.mm.sandbox.updater;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.ao;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20141015", reviewer = 20, vComment = {EType.RECEIVERCHECK})
final class UpdaterService$a extends BroadcastReceiver {
    UpdaterService$a() {
    }

    public final void onReceive(Context context, Intent intent) {
        if (UpdaterService.chl() != null) {
            UpdaterService chl = UpdaterService.chl();
            boolean isWifi = ao.isWifi(context);
            if (chl.sET.size() > 0) {
                for (a la : chl.sET.values()) {
                    la.la(isWifi);
                }
            }
        }
    }
}
