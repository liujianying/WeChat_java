package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Rect;
import android.view.View;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.c.e;
import com.tencent.mm.plugin.appbrand.widget.input.c.h;
import com.tencent.mm.plugin.appbrand.widget.input.t.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

final class d extends c<q> {
    final int gGq;
    int gGr = 0;
    q gGs;
    t gGt;
    h gGu;
    boolean gGv;
    boolean gGw;

    final /* bridge */ /* synthetic */ EditText aph() {
        return this.gGs;
    }

    d(String str, p pVar, e eVar) {
        super(str, pVar);
        this.gGs = new q(pVar.mContext);
        this.gGq = eVar.gGq;
        this.gGr = bi.a((Integer) m.gHq.get(str), 0);
    }

    final int getInputId() {
        return this.gGq;
    }

    public final View getInputPanel() {
        findNumberKeyboard();
        return this.gGt;
    }

    public final boolean adjustPositionOnFocused() {
        return this.gGu != null && af.f(this.gGu.gLZ);
    }

    public final int getInputPanelMarginBottom() {
        return (this.gGu == null || this.gGu.gLW == null) ? 0 : this.gGu.gLW.intValue();
    }

    final Rect api() {
        return new Rect(this.gGu.gLE.intValue(), this.gGu.gLD.intValue(), this.gGu.gLE.intValue() + this.gGu.gLB.intValue(), this.gGu.gLD.intValue() + this.gGu.gLC.intValue());
    }

    public final h b(h hVar) {
        if (this.gGu == null) {
            this.gGu = hVar;
            if (af.f(hVar.gMh) && this.gGs != null) {
                this.gGs.setPasswordMode(true);
            }
        } else {
            this.gGu.a(hVar);
        }
        if (this.gGs == null) {
            return null;
        }
        b.a(this.gGs, this.gGu);
        return this.gGu;
    }

    public final boolean wh(String str) {
        if (this.gGs == null) {
            return false;
        }
        this.gGs.q(str);
        return true;
    }

    public final boolean showKeyboard(int i, int i2) {
        if (this.gGs == null) {
            return false;
        }
        this.gGt = t.ca(((p) this.gGm.get()).getContentView());
        if (this.gGt == null) {
            return false;
        }
        this.gGw = true;
        p pVar = (p) this.gGm.get();
        if (!(pVar == null || pVar.gns == null)) {
            g.apm().o(pVar.gns);
        }
        this.gGt.setXMode(this.gGr);
        t tVar = this.gGt;
        q qVar = this.gGs;
        if (qVar != null) {
            if (tVar.im != qVar) {
                tVar.apB();
            }
            tVar.setInputEditText(qVar);
            tVar.setVisibility(0);
        }
        this.gGt.setOnDoneListener(new a() {
            public final void onDone() {
                d.this.a(d.this.apk());
                d.this.dm(false);
            }
        });
        setInputSelection(i, i2);
        i.a(this.gGm).apo();
        this.gGw = false;
        return true;
    }

    public final boolean hideKeyboard() {
        if (findNumberKeyboard() == null || !isFocused()) {
            return false;
        }
        t tVar = this.gGt;
        tVar.setVisibility(8);
        tVar.apB();
        x.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] disableInputFocus %s", new Object[]{this.gGs});
        if (this.gGs != null) {
            this.gGs.setFocusable(false);
            this.gGs.setFocusableInTouchMode(false);
            this.gGs.setEnabled(false);
        }
        p pVar = (p) this.gGm.get();
        if (!(pVar == null || pVar.gns == null)) {
            g.apm().p(pVar.gns);
        }
        i.a(this.gGm).app();
        return true;
    }

    private boolean isFocused() {
        if (this.gGs == null) {
            return false;
        }
        if (this.gGs.isFocused()) {
            return true;
        }
        if (findNumberKeyboard() != null && findNumberKeyboard().isShown() && this.gGt.getAttachedEditText() == this.gGs) {
            return true;
        }
        return false;
    }

    protected final boolean dm(boolean z) {
        x.d("MicroMsg.AppBrandInputComponentAsNumber", "[input_switch] onFocusChanged hasFocus %b, isFocused %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(isFocused())});
        if (z) {
            if (!(this.gGw || isFocused())) {
                this.gGw = true;
                showKeyboard(-2, -2);
                this.gGw = false;
            }
        } else if (!this.gGv && isFocused()) {
            this.gGv = true;
            a(apk());
            hideKeyboard();
            apj();
            this.gGv = false;
            this.gGs = null;
        }
        return true;
    }

    private t findNumberKeyboard() {
        if (this.gGt != null) {
            return this.gGt;
        }
        t tVar = (t) this.gGs.getInputPanel();
        this.gGt = tVar;
        return tVar;
    }
}
