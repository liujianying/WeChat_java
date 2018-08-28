package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;

class d$b {
    final IntentFilter filter;
    final BroadcastReceiver rj;
    boolean rk;

    d$b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
        this.filter = intentFilter;
        this.rj = broadcastReceiver;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(MapRouteSectionWithName.kMaxRoadNameLength);
        stringBuilder.append("Receiver{");
        stringBuilder.append(this.rj);
        stringBuilder.append(" filter=");
        stringBuilder.append(this.filter);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
