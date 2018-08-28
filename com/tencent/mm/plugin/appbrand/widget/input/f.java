package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.r$b;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.page.z.a;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.widget.b.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"ViewConstructor"})
public final class f extends AbsoluteLayout implements r$b, w, z, e {
    private final p fJQ;
    public final com.tencent.mm.plugin.appbrand.widget.b.f gGA;
    private final AbsoluteLayout gGB;
    private final List<a> gGz = new LinkedList();

    public f(Context context, p pVar) {
        super(context);
        super.setId(g.app_brand_page_input_container);
        this.fJQ = pVar;
        this.gGB = this;
        this.gGA = new com.tencent.mm.plugin.appbrand.widget.b.f(this.gGB);
    }

    public final void setId(int i) {
    }

    public final <Input extends View & z> boolean a(t tVar, Input input, int i, int i2, int i3, int i4) {
        if (tVar == null || tVar.getView() == null || input == null) {
            return false;
        }
        m(tVar);
        this.gGB.addView(input, new LayoutParams(i, i2, i3, i4));
        ((z) input).r(this.fJQ);
        return true;
    }

    private void m(t tVar) {
        if (!(this.gGB.getWidth() == tVar.getWidth() && this.gGB.getHeight() == tVar.getHeight())) {
            ViewGroup.LayoutParams layoutParams = this.gGB.getLayoutParams();
            layoutParams.width = tVar.getWidth();
            layoutParams.height = tVar.getHeight();
            this.gGB.setLayoutParams(layoutParams);
        }
        if (this.gGB.getScrollX() != tVar.getWebScrollX() || this.gGB.getScrollY() != tVar.getWebScrollY()) {
            this.gGB.scrollTo(tVar.getWebScrollX(), tVar.getWebScrollY());
        }
    }

    public final <Input extends View & z> boolean b(t tVar, Input input, int i, int i2, int i3, int i4) {
        if (tVar == null || tVar.getView() == null || input == null) {
            return false;
        }
        boolean z;
        if (!(input == null || this.gGB == null)) {
            for (int i5 = 0; i5 < this.gGB.getChildCount(); i5++) {
                if (input == this.gGB.getChildAt(i5)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (!z) {
            return false;
        }
        m(tVar);
        if (input.getLayoutParams() == null || !(input.getLayoutParams() instanceof LayoutParams)) {
            return false;
        }
        if (!(input.getWidth() == i && input.getHeight() == i2 && input.getLeft() == i3 && input.getTop() == i4)) {
            LayoutParams layoutParams = (LayoutParams) input.getLayoutParams();
            layoutParams.x = i3;
            layoutParams.y = i4;
            layoutParams.width = i;
            layoutParams.height = i2;
            input.setLayoutParams(layoutParams);
        }
        return true;
    }

    public final <Input extends View & z> void bU(Input input) {
        if (input != null) {
            input.setVisibility(8);
            this.gGB.removeView(input);
            ((z) input).s(this.fJQ);
        }
    }

    public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        int i5 = 0;
        x.v("MicroMsg.AppBrandInputContainer", "onScrollChanged, left = %d, top = %d, oldLeft = %d, oldTop = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        if (this.gGB != null) {
            ViewGroup.LayoutParams layoutParams = this.gGB.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(view.getWidth(), view.getHeight());
                this.gGB.setLayoutParams(layoutParams);
            }
            if (!(view.getWidth() == layoutParams.width && view.getHeight() == layoutParams.height)) {
                layoutParams.width = view.getWidth();
                layoutParams.height = view.getHeight();
                this.gGB.setLayoutParams(layoutParams);
            }
            this.gGB.scrollTo(i, i2);
        }
        while (i5 < this.gGz.size()) {
            ((a) this.gGz.get(i5)).bP(i, i2);
            i5++;
        }
    }

    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public final void lp(int i) {
        setTranslationY((float) i);
    }

    public final boolean apd() {
        if (getChildCount() <= 0) {
            return false;
        }
        for (int i = 0; i <= getChildCount(); i++) {
            if (com.tencent.mm.plugin.appbrand.widget.b.a.bR(getChildAt(i))) {
                return true;
            }
        }
        return false;
    }

    public final boolean D(MotionEvent motionEvent) {
        if (motionEvent == null || motionEvent.getActionMasked() != 0) {
            return false;
        }
        com.tencent.mm.plugin.appbrand.widget.b.f fVar = this.gGA;
        if (motionEvent != null && motionEvent.getActionMasked() == 0 && fVar.gFI != null && motionEvent.getDownTime() == fVar.gFI.gFJ && motionEvent.getEventTime() == fVar.gFI.gFK) {
            return true;
        }
        return false;
    }

    public final void a(a aVar) {
        if (aVar != null && !this.gGz.contains(aVar)) {
            this.gGz.add(aVar);
        }
    }

    public final void b(a aVar) {
        if (aVar != null) {
            this.gGz.remove(aVar);
        }
    }
}
