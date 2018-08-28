package com.tencent.mm.ui.chatting.b;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.widget.AbsListView;
import com.tencent.mm.ui.chatting.b.b.j;
import java.util.HashSet;
import java.util.Iterator;

public final class l extends com.tencent.mm.ui.l implements j {
    private HashSet<com.tencent.mm.ui.l> sNB = new HashSet();

    public final void a(com.tencent.mm.ui.l lVar) {
        if (!this.sNB.contains(lVar)) {
            this.sNB.add(lVar);
        }
    }

    public final void b(com.tencent.mm.ui.l lVar) {
        this.sNB.remove(lVar);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        Iterator it = this.sNB.iterator();
        while (it.hasNext()) {
            ((com.tencent.mm.ui.l) it.next()).onActivityResult(i, i2, intent);
        }
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        Iterator it = this.sNB.iterator();
        while (it.hasNext()) {
            if (((com.tencent.mm.ui.l) it.next()).onKeyDown(i, keyEvent)) {
                return true;
            }
        }
        return false;
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        Iterator it = this.sNB.iterator();
        while (it.hasNext()) {
            ((com.tencent.mm.ui.l) it.next()).onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator it = this.sNB.iterator();
        while (it.hasNext()) {
            ((com.tencent.mm.ui.l) it.next()).onConfigurationChanged(configuration);
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
        Iterator it = this.sNB.iterator();
        while (it.hasNext()) {
            ((com.tencent.mm.ui.l) it.next()).onScroll(absListView, i, i2, i3);
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        Iterator it = this.sNB.iterator();
        while (it.hasNext()) {
            ((com.tencent.mm.ui.l) it.next()).onScrollStateChanged(absListView, i);
        }
    }
}
