package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.support.v4.app.Fragment;
import android.support.v4.app.m;
import android.support.v4.app.o;
import java.util.ArrayList;
import java.util.List;

public final class c extends o {
    public List<Fragment> nB = new ArrayList();

    public c(m mVar, List<Fragment> list) {
        super(mVar);
        this.nB = list;
    }

    public final Fragment V(int i) {
        return (Fragment) this.nB.get(i);
    }

    public final int getCount() {
        return this.nB.size();
    }

    public final CharSequence cb() {
        return "";
    }

    public final void a(Fragment fragment, int i) {
        this.nB.remove(fragment);
        if (i >= this.nB.size()) {
            this.nB.add(fragment);
        } else {
            this.nB.add(i, fragment);
        }
    }
}
