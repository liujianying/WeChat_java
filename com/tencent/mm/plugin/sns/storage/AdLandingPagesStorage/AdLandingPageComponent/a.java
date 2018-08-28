package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.d;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.x;

public abstract class a extends i {
    public boolean nzP;
    protected boolean nzQ = SnsAdNativeLandingPagesUI.nSm;
    public boolean nzR;
    private BroadcastReceiver rj = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if ("com.tencent.mm.adlanding.close_exposure_voice".equals(intent.getAction()) && !a.this.bzT().nAW.equals(intent.getStringExtra("para_id"))) {
                a aVar = a.this;
                if (aVar.nzR) {
                    aVar.bzy();
                }
            }
        }
    };

    public a(Context context, s sVar, ViewGroup viewGroup) {
        super(context, sVar, viewGroup);
        d.O(this.context).a(this.rj, new IntentFilter("com.tencent.mm.adlanding.close_exposure_voice"));
        x.v("AbsVideoPlayComp", "register receiver " + this.rj);
    }

    public void bzy() {
        this.nzP = false;
    }

    public void bzz() {
        super.bzz();
        d.O(this.context).unregisterReceiver(this.rj);
        this.nzR = true;
        x.v("AbsVideoPlayComp", "unregister receiver " + this.rj);
    }

    public void bzA() {
        super.bzA();
        this.nzR = true;
    }

    public void bzB() {
        super.bzB();
        this.nzR = false;
    }

    public void W(int i, int i2, int i3) {
        super.W(i, i2, i3);
    }

    public void bzC() {
        this.nzP = true;
    }

    public final void bzD() {
        Intent intent = new Intent("com.tencent.mm.adlanding.close_exposure_voice");
        intent.putExtra("para_id", bzT().nAW);
        d.O(this.context).a(intent);
    }

    protected final void bzE() {
        super.bzE();
        if (this.nzQ) {
            bzC();
        } else {
            bzy();
        }
    }
}
