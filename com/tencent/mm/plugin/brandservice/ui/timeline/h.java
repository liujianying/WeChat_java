package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.widget.BaseAdapter;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.n.a;

public final class h implements a {
    private n hsx;
    long hsy = 0;
    private BaseAdapter hsz;

    public h(BaseAdapter baseAdapter) {
        this.hsz = baseAdapter;
    }

    final n avp() {
        if (this.hsx == null) {
            this.hsx = new n();
        }
        return this.hsx;
    }

    public final boolean isPlaying() {
        return this.hsx != null && this.hsx.aLq();
    }

    public final void aW(String str, int i) {
        this.hsz.notifyDataSetChanged();
    }

    public final void onFinish() {
        this.hsy = 0;
        this.hsz.notifyDataSetChanged();
    }

    public final void onPause() {
        this.hsy = 0;
        this.hsz.notifyDataSetChanged();
    }
}
