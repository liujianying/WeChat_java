package com.google.android.gms.wearable;

import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable;
import com.google.android.gms.wearable.internal.AncsNotificationParcelable;
import com.google.android.gms.wearable.internal.CapabilityInfoParcelable;
import com.google.android.gms.wearable.internal.ChannelEventParcelable;
import com.google.android.gms.wearable.internal.MessageEventParcelable;
import com.google.android.gms.wearable.internal.NodeParcelable;
import com.google.android.gms.wearable.internal.w.a;
import java.util.List;

class WearableListenerService$a extends a {
    boolean bdH = false;
    final /* synthetic */ WearableListenerService bdI;

    WearableListenerService$a(WearableListenerService wearableListenerService) {
        this.bdI = wearableListenerService;
        this.bdH = wearableListenerService instanceof zzj;
    }

    public final void a(DataHolder dataHolder) {
        if (Log.isLoggable("WearableLS", 3)) {
            new StringBuilder("onDataItemChanged: ").append(WearableListenerService.a(this.bdI)).append(": ").append(dataHolder);
        }
        WearableListenerService.b(this.bdI);
        synchronized (WearableListenerService.c(this.bdI)) {
            if (WearableListenerService.d(this.bdI)) {
                dataHolder.close();
                return;
            }
            WearableListenerService.e(this.bdI).post(new 1(this, dataHolder));
        }
    }

    public final void a(AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
        if (Log.isLoggable("WearableLS", 3)) {
            new StringBuilder("onEntityUpdate: ").append(amsEntityUpdateParcelable);
        }
        if (this.bdH) {
            WearableListenerService.b(this.bdI);
            zzj zzj = (zzj) this.bdI;
            synchronized (WearableListenerService.c(this.bdI)) {
                if (WearableListenerService.d(this.bdI)) {
                    return;
                }
                WearableListenerService.e(this.bdI).post(new 8(this, zzj, amsEntityUpdateParcelable));
            }
        }
    }

    public final void a(AncsNotificationParcelable ancsNotificationParcelable) {
        if (Log.isLoggable("WearableLS", 3)) {
            new StringBuilder("onNotificationReceived: ").append(ancsNotificationParcelable);
        }
        if (this.bdH) {
            WearableListenerService.b(this.bdI);
            zzj zzj = (zzj) this.bdI;
            synchronized (WearableListenerService.c(this.bdI)) {
                if (WearableListenerService.d(this.bdI)) {
                    return;
                }
                WearableListenerService.e(this.bdI).post(new 7(this, zzj, ancsNotificationParcelable));
            }
        }
    }

    public final void a(CapabilityInfoParcelable capabilityInfoParcelable) {
        if (Log.isLoggable("WearableLS", 3)) {
            new StringBuilder("onConnectedCapabilityChanged: ").append(capabilityInfoParcelable);
        }
        WearableListenerService.b(this.bdI);
        synchronized (WearableListenerService.c(this.bdI)) {
            if (WearableListenerService.d(this.bdI)) {
                return;
            }
            WearableListenerService.e(this.bdI).post(new 6(this, capabilityInfoParcelable));
        }
    }

    public final void a(ChannelEventParcelable channelEventParcelable) {
        if (Log.isLoggable("WearableLS", 3)) {
            new StringBuilder("onChannelEvent: ").append(channelEventParcelable);
        }
        WearableListenerService.b(this.bdI);
        synchronized (WearableListenerService.c(this.bdI)) {
            if (WearableListenerService.d(this.bdI)) {
                return;
            }
            WearableListenerService.e(this.bdI).post(new 9(this, channelEventParcelable));
        }
    }

    public final void a(MessageEventParcelable messageEventParcelable) {
        if (Log.isLoggable("WearableLS", 3)) {
            new StringBuilder("onMessageReceived: ").append(messageEventParcelable);
        }
        WearableListenerService.b(this.bdI);
        synchronized (WearableListenerService.c(this.bdI)) {
            if (WearableListenerService.d(this.bdI)) {
                return;
            }
            WearableListenerService.e(this.bdI).post(new 2(this, messageEventParcelable));
        }
    }

    public final void a(NodeParcelable nodeParcelable) {
        if (Log.isLoggable("WearableLS", 3)) {
            new StringBuilder("onPeerConnected: ").append(WearableListenerService.a(this.bdI)).append(": ").append(nodeParcelable);
        }
        WearableListenerService.b(this.bdI);
        synchronized (WearableListenerService.c(this.bdI)) {
            if (WearableListenerService.d(this.bdI)) {
                return;
            }
            WearableListenerService.e(this.bdI).post(new 3(this, nodeParcelable));
        }
    }

    public final void b(NodeParcelable nodeParcelable) {
        if (Log.isLoggable("WearableLS", 3)) {
            new StringBuilder("onPeerDisconnected: ").append(WearableListenerService.a(this.bdI)).append(": ").append(nodeParcelable);
        }
        WearableListenerService.b(this.bdI);
        synchronized (WearableListenerService.c(this.bdI)) {
            if (WearableListenerService.d(this.bdI)) {
                return;
            }
            WearableListenerService.e(this.bdI).post(new 4(this, nodeParcelable));
        }
    }

    public final void w(List<NodeParcelable> list) {
        if (Log.isLoggable("WearableLS", 3)) {
            new StringBuilder("onConnectedNodes: ").append(WearableListenerService.a(this.bdI)).append(": ").append(list);
        }
        WearableListenerService.b(this.bdI);
        synchronized (WearableListenerService.c(this.bdI)) {
            if (WearableListenerService.d(this.bdI)) {
                return;
            }
            WearableListenerService.e(this.bdI).post(new 5(this, list));
        }
    }
}
