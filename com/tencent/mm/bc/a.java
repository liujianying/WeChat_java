package com.tencent.mm.bc;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mm.sdk.platformtools.x;

@TargetApi(3)
public final class a extends OrientationEventListener {
    private a euK = a.euN;
    private int euL = 45;
    private b euM;

    public interface b {
        void a(a aVar, a aVar2);
    }

    public a(Context context, b bVar) {
        super(context);
        this.euM = bVar;
    }

    public final void enable() {
        super.enable();
    }

    public final void disable() {
        super.disable();
        this.euK = a.euN;
    }

    public final void onOrientationChanged(int i) {
        if (i != -1) {
            a aVar = this.euK;
            if ((i >= 360 - this.euL && i < 360) || (i >= 0 && i <= this.euL + 0)) {
                aVar = a.euO;
            } else if (i >= 270 - this.euL && i <= this.euL + 270) {
                aVar = a.euP;
            } else if (i >= 180 - this.euL && i <= this.euL + 180) {
                aVar = a.euQ;
            } else if (i >= 90 - this.euL && i <= this.euL + 90) {
                aVar = a.euR;
            }
            if (aVar != this.euK) {
                if (!(this.euM == null || this.euK == a.euN)) {
                    this.euM.a(this.euK, aVar);
                }
                this.euK = aVar;
            }
            x.i("MicroMsg.OrientationListenerHelper", "OrientationListener onOrientationChanged:" + i);
        }
    }
}
