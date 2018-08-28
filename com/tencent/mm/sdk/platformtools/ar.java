package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import java.util.LinkedList;
import java.util.List;

public final class ar {
    static boolean cdG;
    private TelephonyManager sIc;
    private PhoneStateListener sId;
    List<a> sIe = new LinkedList();

    public interface a {
        void fn(int i);
    }

    public final void a(a aVar) {
        this.sIe.add(aVar);
    }

    public final void ciy() {
        this.sIe.clear();
    }

    public static boolean vZ() {
        x.i("MicroMsg.PhoneStatusWatcher", "alvinluo isCalling: %b", Boolean.valueOf(cdG));
        return cdG;
    }

    public final void fN(Context context) {
        x.i("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher begin");
        if (this.sIc == null) {
            this.sIc = (TelephonyManager) context.getSystemService("phone");
        }
        if (this.sId == null) {
            this.sId = new PhoneStateListener() {
                public final void onCallStateChanged(int i, String str) {
                    x.i("MicroMsg.PhoneStatusWatcher", "alvinluo onCallStateChanged state: %d, incomingNumber: %s", Integer.valueOf(i), str);
                    if (ar.this.sIe.size() > 0) {
                        for (a fn : (a[]) ar.this.sIe.toArray(new a[ar.this.sIe.size()])) {
                            fn.fn(i);
                        }
                    }
                    super.onCallStateChanged(i, str);
                    switch (i) {
                        case 0:
                            ar.cdG = false;
                            return;
                        case 1:
                        case 2:
                            ar.cdG = true;
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        this.sIc.listen(this.sId, 32);
    }

    public final void end() {
        x.i("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher end");
        if (this.sIc != null) {
            this.sIc.listen(this.sId, 0);
            this.sId = null;
        }
    }
}
