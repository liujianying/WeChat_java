package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class c {
    public Activity activity;
    public WifiManager bnh;
    public Condition bvW;
    public boolean connected = false;
    public long dJH;
    public String eSH;
    public BroadcastReceiver jhC;
    public boolean jhG = false;
    public Lock jhz;
    public String ssid;

    public c(String str, Activity activity, String str2) {
        this.activity = activity;
        this.dJH = 30000;
        this.ssid = str;
        this.eSH = str2;
        this.jhz = new ReentrantLock();
        this.bvW = this.jhz.newCondition();
        this.bnh = (WifiManager) ad.getContext().getSystemService("wifi");
    }

    public final void aNO() {
        try {
            this.activity.unregisterReceiver(this.jhC);
        } catch (IllegalArgumentException e) {
        }
    }
}
