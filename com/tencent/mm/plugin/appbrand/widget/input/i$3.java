package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.view.z;
import android.view.View;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class i$3 implements Runnable {
    final /* synthetic */ i gHa;

    i$3(i iVar) {
        this.gHa = iVar;
    }

    public final void run() {
        x.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] offsetRunner enter");
        y q = m.q(i.a(this.gHa));
        if (q != null && i.a(this.gHa).isRunning()) {
            i.a(this.gHa, 0);
            if (q.getInputPanel() != null && q.getWidget() != null) {
                View widget = q.getWidget();
                View inputPanel = q.getInputPanel();
                if (j.bM(widget)) {
                    a(q, 0);
                    return;
                }
                if (inputPanel.getHeight() <= inputPanel.getMinimumHeight()) {
                    x.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panel height %d, tryCount %d", new Object[]{Integer.valueOf(inputPanel.getHeight()), Integer.valueOf(i.e(this.gHa))});
                    if (i.f(this.gHa) < 5) {
                        i.g(this.gHa);
                        return;
                    }
                }
                i.h(this.gHa);
                x.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp], panelHeight %d", new Object[]{Integer.valueOf(inputPanel.getHeight())});
                a(q, inputPanel.getHeight());
                if (q.adjustPositionOnFocused()) {
                    int[] iArr = new int[2];
                    widget.getLocationOnScreen(iArr);
                    int i = iArr[1];
                    x.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] inputHeight %d, inputTop %d, inputAttached %B", new Object[]{Integer.valueOf(widget.getHeight()), Integer.valueOf(i), Boolean.valueOf(z.ak(widget))});
                    if (i <= i.i(this.gHa)) {
                        int i2;
                        int i3;
                        int height = widget.getHeight() + i;
                        inputPanel.getLocationOnScreen(iArr);
                        int i4 = iArr[1];
                        if (!((z) widget).apv() || widget.getLayout() == null) {
                            i2 = height;
                            i3 = i;
                        } else {
                            i2 = i + ((z) widget).mf(widget.getLayout().getLineForOffset(widget.getSelectionStart()));
                            int mf = i + ((z) widget).mf(widget.getLayout().getLineForOffset(widget.getSelectionStart()) + 1);
                            i3 = i2 - i >= widget.getHeight() ? height - widget.getLineHeight() : i2;
                            i2 = mf - i >= widget.getHeight() ? height : mf;
                        }
                        i2 += q.getInputPanelMarginBottom();
                        if (i4 < i2) {
                            i2 = Math.max(0, Math.min(i2 - i4, i3 - i.j(this.gHa)));
                            t tVar = i.a(this.gHa).gns;
                            if (tVar != null) {
                                View view = tVar.getView();
                                if (view != null && widget != null) {
                                    if (((z) widget).apz() || !((z) widget).apv()) {
                                        lX(apq() + i2);
                                        return;
                                    }
                                    i3 = tVar.getHeight();
                                    i = view.getScrollY();
                                    height = f.lP(tVar.getContentHeight());
                                    widget.getHeight();
                                    widget.getTop();
                                    i3 = Math.max(0, Math.min((height - i) - i3, i2));
                                    view.scrollBy(view.getScrollX(), i3);
                                    i.a(this.gHa, i3);
                                    lX((i2 - i3) + apq());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                x.v("MicroMsg.AppBrandInputPageOffsetHelper", "[scrollUp] beginOffset, no need adjust position, notify height %d", new Object[]{Integer.valueOf(inputPanel.getHeight())});
            }
        }
    }

    private void a(y yVar, int i) {
        ah.A(new 1(this, yVar, i));
    }

    private int apq() {
        View b = i.b(this.gHa);
        if (b != null) {
            return b.getScrollY();
        }
        return 0;
    }

    private void lX(int i) {
        x.d("MicroMsg.AppBrandInputPageOffsetHelper", "[TextAreaHeight] offsetRoot %d", new Object[]{Integer.valueOf(i)});
        View b = i.b(this.gHa);
        if (b != null) {
            b.scrollTo(0, i);
            i.k(this.gHa);
        }
    }
}
