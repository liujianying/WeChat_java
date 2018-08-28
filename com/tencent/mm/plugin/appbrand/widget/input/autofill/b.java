package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Filter.FilterListener;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase.a;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.c.2;
import com.tencent.mm.plugin.appbrand.widget.input.z;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.widget.f;

public final class b {
    final z gJU;
    public final e gJV;
    private final FilterListener gJW;
    public final c gJX;
    final a gJY;
    int gJZ = f.gKw;
    public a gKa;
    private int gKb;
    private int gKc;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.autofill.b$7 */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] gKf = new int[f.aqb().length];

        static {
            try {
                gKf[f.gKv - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                gKf[f.gKw - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public b(z zVar) {
        this.gJU = zVar;
        this.gJV = new e(zVar.getContext());
        this.gJX = new c(zVar, this.gJV);
        this.gJU.a(new 1(this));
        this.gJU.a(new 2(this));
        this.gJU.a(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    b.this.apZ();
                    return;
                }
                b bVar = b.this;
                if (bVar.gJV.eZB.isShowing()) {
                    g gVar = (g) bVar.gJV.gKo.getAdapter();
                    bVar.gJV.dismiss();
                    gVar.apX();
                }
            }
        });
        this.gJU.addTextChangedListener(new f() {
            private boolean gKe = false;

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.gKe = b.this.gJV.eZB.isShowing();
            }

            public final void afterTextChanged(Editable editable) {
                if (!this.gKe || b.this.gJV.eZB.isShowing()) {
                    if (!b.this.gJV.eZB.isShowing()) {
                        b.this.apZ();
                    }
                    b.this.t(editable);
                }
            }
        });
        this.gJW = new FilterListener() {
            public final void onFilterComplete(int i) {
                if (i <= 0) {
                    b.this.gJV.dismiss();
                } else if (b.this.gJV.eZB.isShowing()) {
                    b.this.gJV.show();
                }
            }
        };
        this.gJY = new 6(this);
    }

    final void t(CharSequence charSequence) {
        if (this.gKa != null) {
            this.gKa.getFilter().filter(charSequence, this.gJW);
        }
    }

    final void apY() {
        switch (AnonymousClass7.gKf[this.gJZ - 1]) {
            case 1:
                this.gJV.MU = j.anG()[0];
                break;
            case 2:
                this.gJV.MU = this.gJU.getView().getMeasuredWidth();
                break;
        }
        if (this.gKb != 0) {
            this.gJV.PN = this.gKb;
            this.gJV.MU -= this.gKb;
        }
        if (this.gKc != 0) {
            this.gJV.MU -= this.gKc;
        }
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        this.gJV.eZB.setOnDismissListener(onDismissListener);
    }

    final void apZ() {
        if (this.gKa != null) {
            CharSequence text = this.gJU.getText();
            if (!bi.K(text)) {
                t(text);
            }
            this.gJV.PW = this.gJU.getView();
            this.gJV.show();
            ((g) this.gJV.gKo.getAdapter()).a(this);
            c cVar = this.gJX;
            cVar.mj(2);
            cVar.gKj = Integer.MIN_VALUE;
            if (!bi.K(text)) {
                cVar.gKk = true;
            }
            a aVar = cVar.gJV.gKo;
            if (aVar != null) {
                aVar.getAdapter().registerDataSetObserver(new 2(cVar));
            }
        }
    }
}
