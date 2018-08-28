package android.support.v7.widget;

import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.support.v4.view.a.b.k;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.q;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public final class ac extends a {
    final RecyclerView Sa;
    final a Tj = new 1(this);

    public ac(RecyclerView recyclerView) {
        this.Sa = recyclerView;
    }

    final boolean gk() {
        RecyclerView recyclerView = this.Sa;
        return !recyclerView.Rc || recyclerView.Rl || recyclerView.QP.eE();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean performAccessibilityAction(android.view.View r7, int r8, android.os.Bundle r9) {
        /*
        r6 = this;
        r5 = -1;
        r2 = 1;
        r1 = 0;
        r0 = super.performAccessibilityAction(r7, r8, r9);
        if (r0 == 0) goto L_0x000b;
    L_0x0009:
        r1 = r2;
    L_0x000a:
        return r1;
    L_0x000b:
        r0 = r6.gk();
        if (r0 != 0) goto L_0x000a;
    L_0x0011:
        r0 = r6.Sa;
        r0 = r0.getLayoutManager();
        if (r0 == 0) goto L_0x000a;
    L_0x0019:
        r0 = r6.Sa;
        r4 = r0.getLayoutManager();
        r0 = r4.Sa;
        r0 = r0.QN;
        r0 = r4.Sa;
        r0 = r0.RB;
        r0 = r4.Sa;
        if (r0 == 0) goto L_0x000a;
    L_0x002b:
        switch(r8) {
            case 4096: goto L_0x0066;
            case 8192: goto L_0x003b;
            default: goto L_0x002e;
        };
    L_0x002e:
        r3 = r1;
        r0 = r1;
    L_0x0030:
        if (r0 != 0) goto L_0x0034;
    L_0x0032:
        if (r3 == 0) goto L_0x000a;
    L_0x0034:
        r1 = r4.Sa;
        r1.scrollBy(r3, r0);
        r1 = r2;
        goto L_0x000a;
    L_0x003b:
        r0 = r4.Sa;
        r0 = android.support.v4.view.z.h(r0, r5);
        if (r0 == 0) goto L_0x0093;
    L_0x0043:
        r0 = r4.mHeight;
        r3 = r4.getPaddingTop();
        r0 = r0 - r3;
        r3 = r4.getPaddingBottom();
        r0 = r0 - r3;
        r0 = -r0;
    L_0x0050:
        r3 = r4.Sa;
        r3 = android.support.v4.view.z.g(r3, r5);
        if (r3 == 0) goto L_0x008f;
    L_0x0058:
        r3 = r4.mWidth;
        r5 = r4.getPaddingLeft();
        r3 = r3 - r5;
        r5 = r4.getPaddingRight();
        r3 = r3 - r5;
        r3 = -r3;
        goto L_0x0030;
    L_0x0066:
        r0 = r4.Sa;
        r0 = android.support.v4.view.z.h(r0, r2);
        if (r0 == 0) goto L_0x0091;
    L_0x006e:
        r0 = r4.mHeight;
        r3 = r4.getPaddingTop();
        r0 = r0 - r3;
        r3 = r4.getPaddingBottom();
        r0 = r0 - r3;
    L_0x007a:
        r3 = r4.Sa;
        r3 = android.support.v4.view.z.g(r3, r2);
        if (r3 == 0) goto L_0x008f;
    L_0x0082:
        r3 = r4.mWidth;
        r5 = r4.getPaddingLeft();
        r3 = r3 - r5;
        r5 = r4.getPaddingRight();
        r3 = r3 - r5;
        goto L_0x0030;
    L_0x008f:
        r3 = r1;
        goto L_0x0030;
    L_0x0091:
        r0 = r1;
        goto L_0x007a;
    L_0x0093:
        r0 = r1;
        goto L_0x0050;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ac.performAccessibilityAction(android.view.View, int, android.os.Bundle):boolean");
    }

    public final void a(View view, b bVar) {
        super.a(view, bVar);
        bVar.setClassName(RecyclerView.class.getName());
        if (!gk() && this.Sa.getLayoutManager() != null) {
            h layoutManager = this.Sa.getLayoutManager();
            m mVar = layoutManager.Sa.QN;
            q qVar = layoutManager.Sa.RB;
            if (z.h(layoutManager.Sa, -1) || z.g(layoutManager.Sa, -1)) {
                bVar.addAction(8192);
                bVar.setScrollable(true);
            }
            if (z.h(layoutManager.Sa, 1) || z.g(layoutManager.Sa, 1)) {
                bVar.addAction(4096);
                bVar.setScrollable(true);
            }
            b.xr.g(bVar.xs, new k(b.cp().r(layoutManager.a(mVar, qVar), layoutManager.b(mVar, qVar))).xs);
        }
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !gk()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }
    }
}
