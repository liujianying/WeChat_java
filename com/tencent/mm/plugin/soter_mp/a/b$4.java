package com.tencent.mm.plugin.soter_mp.a;

import com.tencent.d.b.c.b;
import com.tencent.mm.R;
import com.tencent.mm.plugin.soter_mp.a.b.7;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.c.a;

class b$4 implements b {
    final /* synthetic */ b oom;

    b$4(b bVar) {
        this.oom = bVar;
    }

    public final void aNF() {
        x.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onStartAuthencation");
        this.oom.ood = true;
    }

    public final void onAuthenticationHelp(int i, CharSequence charSequence) {
        x.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen help errCode: %d, errMsg:%s", new Object[]{Integer.valueOf(i), charSequence});
    }

    public final void aNG() {
        x.i("MicroMsg.SoterControllerFingerprint", "hy: mp on authen success");
        this.oom.ood = false;
        this.oom.jgQ = null;
        b bVar = this.oom;
        bVar.glY.removeCallbacks(bVar.ool);
        bVar.oof.setImageResource(R.k.fingerprint_icon_succes);
        bVar.glY.setTextColor(bVar.glY.getResources().getColor(R.e.success_color));
        bVar.glY.setText(bVar.glY.getResources().getString(R.l.soter_mp_fingerprint_success));
    }

    public final void onAuthenticationFailed() {
        x.w("MicroMsg.SoterControllerFingerprint", "hy: mp user trying failed");
        b bVar = this.oom;
        CharSequence string = ad.getContext().getString(R.l.soter_fingerprint_unidentified);
        if (bVar.ooj == null) {
            bVar.ooj = a.gz(bVar.oof.getContext());
        }
        if (bVar.ook == null) {
            bVar.ook = a.gz(bVar.oof.getContext());
        }
        bVar.ooj.setAnimationListener(new 7(bVar, string));
        bVar.glY.startAnimation(bVar.ooj);
        bVar.oof.startAnimation(bVar.ook);
        ah.i(new 1(this), 500);
    }

    public final void aNH() {
        x.v("MicroMsg.SoterControllerFingerprint", "alvinluo mp onAuthenticationCancelled");
        this.oom.jgQ = null;
    }

    public final void onAuthenticationError(int i, CharSequence charSequence) {
        x.e("MicroMsg.SoterControllerFingerprint", "hy: on mp authen error errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), charSequence});
    }
}
