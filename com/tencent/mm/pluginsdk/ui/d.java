package com.tencent.mm.pluginsdk.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class d implements OnScrollListener {
    private OnScrollListener qEM;
    private ArrayList<WeakReference<a>> qEN;

    public interface a {
        void onScrollStateChanged(boolean z);
    }

    public d() {
        this(null);
    }

    public d(OnScrollListener onScrollListener) {
        this.qEN = new ArrayList();
        this.qEM = onScrollListener;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.qEM != null) {
            this.qEM.onScroll(absListView, i, i2, i3);
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            kC(true);
        } else {
            kC(false);
        }
        if (this.qEM != null) {
            this.qEM.onScrollStateChanged(absListView, i);
        }
    }

    public final void a(a aVar) {
        this.qEN.add(new WeakReference(aVar));
    }

    private void kC(boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.qEN.size()) {
                WeakReference weakReference = (WeakReference) this.qEN.get(i2);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.onScrollStateChanged(z);
                    } else {
                        this.qEN.remove(i2);
                    }
                } else {
                    this.qEN.remove(i2);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
