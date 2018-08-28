package com.tencent.mm.plugin.bbom;

import android.app.Service;
import android.content.IntentFilter;
import com.tencent.mm.booter.TrafficStatsReceiver;
import com.tencent.mm.modelfriend.AddrBookObserver;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.plugin.zero.a.a;

public final class g implements a {
    private AddrBookObserver hes;
    private WatchDogPushReceiver het;
    private TrafficStatsReceiver heu;

    public final void a(Service service) {
        this.hes = new AddrBookObserver(service);
        service.getContentResolver().registerContentObserver(com.tencent.mm.pluginsdk.a.cbh(), true, this.hes);
        this.het = new WatchDogPushReceiver();
        service.registerReceiver(this.het, new IntentFilter("com.tencent.mm.WatchDogPushReceiver"));
        this.heu = new TrafficStatsReceiver();
        service.registerReceiver(this.heu, new IntentFilter("com.tencent.mm.TrafficStatsReceiver"));
        TrafficStatsReceiver.bo(service);
    }

    public final void b(Service service) {
        service.getContentResolver().unregisterContentObserver(this.hes);
        service.unregisterReceiver(this.het);
        service.unregisterReceiver(this.heu);
        TrafficStatsReceiver.bp(service);
    }
}
