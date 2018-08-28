package com.tencent.mm.plugin.h.a.c;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.UUID;
import junit.framework.Assert;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public final class a {
    public static final UUID hiF = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
    public static final UUID hiG = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
    public BluetoothAdapter heY;
    public HashMap<Long, b> hfF = new HashMap();
    public a hiH;
    public Context hiI;
    public final BroadcastReceiver hiJ = new 1(this);
    public ag mHandler;
    public boolean mIsInit = false;
    private Runnable mRunnable;

    public a(ah ahVar) {
        this.mHandler = new ag(ahVar.lnJ.getLooper());
        this.mRunnable = new 2(this);
    }

    public final boolean atW() {
        Assert.assertTrue(this.mIsInit);
        if (this.heY == null) {
            return false;
        }
        return true;
    }

    private boolean atX() {
        if (!this.heY.isDiscovering()) {
            return true;
        }
        if (this.heY.cancelDiscovery()) {
            this.mHandler.removeCallbacks(this.mRunnable);
            return true;
        }
        x.e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.cancelDiscovery Failed!!!");
        return false;
    }

    public final boolean dJ(boolean z) {
        x.i("MicroMsg.exdevice.BluetoothChatManager", "scanDevices" + (z ? "true" : "false"));
        Assert.assertTrue(this.mIsInit);
        if (!atW()) {
            x.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
            return false;
        } else if (!z) {
            return atX();
        } else {
            if (this.heY.isDiscovering() && !atX()) {
                return false;
            }
            if (this.heY.startDiscovery()) {
                this.mHandler.postDelayed(this.mRunnable, 10000);
                return true;
            }
            x.e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.startDiscovery() Failed");
            return false;
        }
    }
}
