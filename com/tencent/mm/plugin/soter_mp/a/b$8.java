package com.tencent.mm.plugin.soter_mp.a;

import com.tencent.mm.R;

class b$8 implements Runnable {
    final /* synthetic */ b oom;

    b$8(b bVar) {
        this.oom = bVar;
    }

    public final void run() {
        this.oom.glY.setTextColor(this.oom.glY.getResources().getColor(R.e.hint_color));
        this.oom.glY.setText(this.oom.glY.getResources().getString(R.l.soter_mp_fingerprint_hint));
        this.oom.oof.setImageResource(R.k.fingerprint_icon);
    }
}
