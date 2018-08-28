package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.i.a;
import com.tencent.mm.plugin.appbrand.widget.input.z;

public final class c {
    final z gJU;
    final e gJV;
    public final a gKh = new 1(this);
    public p gKi;
    int gKj = Integer.MIN_VALUE;
    boolean gKk = false;

    c(z zVar, e eVar) {
        this.gJU = zVar;
        this.gJV = eVar;
    }

    final void mj(final int i) {
        final AutoFillListPopupWindowBase.a aVar = this.gJV.gKo;
        if (aVar != null && this.gJV.eZB.isShowing()) {
            if (1 == i && this.gKk) {
                this.gKj = Integer.MIN_VALUE;
                this.gKk = false;
            }
            aVar.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                public final boolean onPreDraw() {
                    aVar.getViewTreeObserver().removeOnPreDrawListener(this);
                    c cVar = c.this;
                    if (cVar.gJV.eZB.isShowing() && cVar.gJV.gKo != null && cVar.gJV.gKo.getAdapter() != null && cVar.gJV.gKo.getAdapter().getCount() > 0) {
                        View inputPanel = cVar.gJU.getInputPanel();
                        if (inputPanel != null) {
                            int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(cVar.gJU.getContext(), 8);
                            int height = cVar.gJV.gKo.getChildAt(0).getHeight();
                            int count = cVar.gJV.gKo.getAdapter().getCount() * height;
                            int i = count + (fromDPToPix * 2);
                            int i2 = (height * 3) + (fromDPToPix * 2);
                            if (i > i2) {
                                count = i2 - (fromDPToPix * 2);
                            } else {
                                i2 = i;
                            }
                            cVar.gJV.PM = i2;
                            int[] iArr = new int[2];
                            cVar.gJU.getView().getLocationInWindow(iArr);
                            int height2 = cVar.gJU.getView().getHeight() + iArr[1];
                            inputPanel.getLocationInWindow(iArr);
                            i = iArr[1];
                            i2 = height;
                            c cVar2 = cVar;
                            while (true) {
                                if ((cVar2.gKj == Integer.MIN_VALUE || cVar2.gKj >= 0 - fromDPToPix) && i - height2 >= count + fromDPToPix) {
                                    cVar2.gJV.PW = cVar2.gJU.getView();
                                    cVar2.gJV.PM = (fromDPToPix * 2) + count;
                                    cVar2.gJV.setVerticalOffset(0 - fromDPToPix);
                                    break;
                                } else if (height2 - cVar2.gJU.getView().getHeight() >= count) {
                                    cVar2.gJV.PW = cVar2.gJU.getView();
                                    cVar2.gJV.PM = (fromDPToPix * 2) + count;
                                    cVar2.gJV.setVerticalOffset((-(count + fromDPToPix)) - cVar2.gJU.getView().getHeight());
                                    break;
                                } else if (count <= i2) {
                                    cVar2.gJV.PM = i2;
                                    cVar2.gJV.PW = cVar2.gJU.getView();
                                    if (cVar2.gKj < 0 - fromDPToPix) {
                                        cVar2.gJV.setVerticalOffset((-(count + fromDPToPix)) - cVar2.gJU.getView().getHeight());
                                    } else {
                                        cVar2.gJV.setVerticalOffset(0 - fromDPToPix);
                                    }
                                } else {
                                    count -= i2;
                                }
                            }
                            cVar.gJV.show();
                            e eVar = cVar.gJV;
                            cVar.gKj = !eVar.PQ ? 0 : eVar.PO;
                        }
                    }
                    return true;
                }
            });
        }
    }
}
