package c.t.m.g;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import java.lang.ref.WeakReference;

class dg$c extends Handler {
    private /* synthetic */ dg a;

    public dg$c(dg dgVar, Looper looper) {
        this.a = dgVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        TencentLocationListener tencentLocationListener = null;
        Bundle data = message.getData();
        if (data != null) {
            int i;
            switch (message.what) {
                case 3101:
                case 3103:
                    TencentLocation tencentLocation;
                    i = data.getInt("error_code");
                    eb ebVar = eb.a;
                    if (i == 0) {
                        tencentLocation = (eb) data.getParcelable("tx_location");
                    } else {
                        tencentLocation = ebVar;
                    }
                    if (message.what == 3101) {
                        synchronized (dg.b(this.a)) {
                            if (dg.c(this.a) != null) {
                                tencentLocationListener = (TencentLocationListener) dg.c(this.a).get();
                            }
                        }
                        if (tencentLocationListener != null) {
                            tencentLocationListener.onLocationChanged(tencentLocation, i, (String) dg.c().get(i));
                            return;
                        }
                        return;
                    } else if (message.what == 3103 && dg.y(this.a) != null) {
                        for (WeakReference weakReference : dg.y(this.a)) {
                            TencentLocationListener tencentLocationListener2 = weakReference == null ? null : (TencentLocationListener) weakReference.get();
                            if (tencentLocationListener2 != null) {
                                tencentLocationListener2.onLocationChanged(tencentLocation, i, (String) dg.c().get(i));
                            }
                        }
                        dg.y(this.a).clear();
                        return;
                    } else {
                        return;
                    }
                case 3102:
                    TencentLocationListener tencentLocationListener3;
                    String string = data.getString("name");
                    i = data.getInt("status");
                    String string2 = data.getString("desc");
                    synchronized (dg.b(this.a)) {
                        if (dg.c(this.a) != null) {
                            tencentLocationListener3 = (TencentLocationListener) dg.c(this.a).get();
                        } else {
                            tencentLocationListener3 = null;
                        }
                    }
                    if (tencentLocationListener3 != null) {
                        tencentLocationListener3.onStatusUpdate(string, i, string2);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
