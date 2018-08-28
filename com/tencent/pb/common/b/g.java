package com.tencent.pb.common.b;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.d;

public final class g {
    private NetworkInfo cWU = null;
    private WifiInfo cWV = null;
    private int vcv = 1;

    public final synchronized boolean xy() {
        boolean z;
        WifiInfo wifiInfo = null;
        synchronized (this) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) d.oSX.getSystemService("connectivity");
                if (connectivityManager == null) {
                    c.x("NetworkChangeMgr", new Object[]{"can't get ConnectivityManager"});
                    this.vcv = 1;
                    this.cWV = null;
                    this.cWU = null;
                    z = true;
                } else {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        this.vcv = 1;
                        this.cWV = null;
                        this.cWU = null;
                        z = true;
                    } else {
                        int i;
                        c.d("NetworkChangeMgr", new Object[]{"NetworkChangeMgr ", activeNetworkInfo});
                        if (!activeNetworkInfo.isConnected()) {
                            i = 1;
                        } else if (activeNetworkInfo.getType() == 1) {
                            wifiInfo = ((WifiManager) d.oSX.getSystemService(TencentExtraKeys.LOCATION_SOURCE_WIFI)).getConnectionInfo();
                            i = 2;
                        } else {
                            i = 3;
                        }
                        if (i == this.vcv) {
                            if (i == 1) {
                                z = false;
                            } else if (i == 2) {
                                if (wifiInfo != null && this.cWV != null && this.cWV.getBSSID().equals(wifiInfo.getBSSID()) && this.cWV.getSSID().equals(wifiInfo.getSSID()) && this.cWV.getNetworkId() == wifiInfo.getNetworkId()) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                            } else if (this.cWU != null && this.cWU.getExtraInfo() != null && activeNetworkInfo.getExtraInfo() != null && this.cWU.getExtraInfo().equals(activeNetworkInfo.getExtraInfo()) && this.cWU.getSubtype() == activeNetworkInfo.getSubtype() && this.cWU.getType() == activeNetworkInfo.getType()) {
                                z = false;
                            } else if (this.cWU != null && this.cWU.getExtraInfo() == null && activeNetworkInfo.getExtraInfo() == null && this.cWU.getSubtype() == activeNetworkInfo.getSubtype() && this.cWU.getType() == activeNetworkInfo.getType()) {
                                z = false;
                            }
                            this.vcv = i;
                            this.cWV = wifiInfo;
                            this.cWU = activeNetworkInfo;
                        }
                        z = true;
                        this.vcv = i;
                        this.cWV = wifiInfo;
                        this.cWU = activeNetworkInfo;
                    }
                }
            } catch (Exception e) {
                c.x("NetworkChangeMgr", new Object[]{e});
                this.vcv = 1;
                this.cWV = null;
                this.cWU = null;
                z = true;
            }
        }
        return z;
    }
}
