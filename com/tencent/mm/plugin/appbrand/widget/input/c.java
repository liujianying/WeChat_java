package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.Rect;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.c.h;
import com.tencent.mm.ui.tools.a.c.a;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.widget.f;
import java.lang.ref.WeakReference;

public abstract class c<Input extends EditText & z> extends f implements y {
    public ab gGj;
    public aa gGk;
    final String gGl;
    public final WeakReference<p> gGm;
    public final OnFocusChangeListener gGn = new OnFocusChangeListener() {
        public final void onFocusChange(View view, boolean z) {
            c.this.dm(z);
            if (z) {
                m.a((p) c.this.gGm.get(), (z) c.this.aph());
                ((z) c.this.aph()).setInputId(c.this.getInputId());
                m.a(c.this.getInputId(), c.this);
            }
        }
    };
    private final a inputExceedMaxLengthCallback = new n.a() {
        public final void YY() {
            if (c.this.aph() != null) {
                c.this.b(c.this.aph().getEditableText());
            }
        }
    };

    public abstract Input aph();

    public abstract Rect api();

    protected abstract h b(h hVar);

    protected abstract boolean dm(boolean z);

    public abstract int getInputId();

    public abstract boolean wh(String str);

    c(String str, p pVar) {
        this.gGl = str;
        this.gGm = new WeakReference(pVar);
    }

    public boolean removeSelf() {
        return apj();
    }

    public Input getWidget() {
        return aph();
    }

    public final boolean apj() {
        View aph = aph();
        if (aph == null) {
            return false;
        }
        ((z) aph).b(this.gGn);
        aph.removeTextChangedListener(this);
        ((z) aph).destroy();
        p pVar = (p) this.gGm.get();
        if (pVar == null) {
            return false;
        }
        f fVar = pVar.gnr;
        if (fVar == null) {
            return false;
        }
        fVar.bU(aph);
        return true;
    }

    public boolean isAttachedTo(p pVar) {
        return pVar != null && pVar == this.gGm.get();
    }

    final void a(Editable editable) {
        if (this.gGj != null) {
            this.gGj.a(editable == null ? "" : editable.toString(), Selection.getSelectionEnd(editable), ab.a.gIU);
        }
    }

    public final void kL(int i) {
        if (this.gGk != null) {
            this.gGk.lW(i);
        }
    }

    public final void afterTextChanged(Editable editable) {
        b(editable);
    }

    private void b(Editable editable) {
        if (this.gGj != null) {
            this.gGj.a(editable == null ? "" : editable.toString(), Selection.getSelectionEnd(editable), ab.a.gIW);
        }
    }

    public final boolean a(h hVar) {
        h b = b(hVar);
        if (b == null) {
            return false;
        }
        if (b.gLL == null) {
            b.gLL = Integer.valueOf(140);
        } else if (b.gLL.intValue() <= 0) {
            b.gLL = Integer.valueOf(Integer.MAX_VALUE);
        }
        if (aph() == null) {
            return false;
        }
        com.tencent.mm.ui.tools.a.c Gi = n.a(aph()).Gi(b.gLL.intValue());
        Gi.uCR = false;
        Gi.gHz = g.a.uzY;
        Gi.a(this.inputExceedMaxLengthCallback);
        return true;
    }

    public final void updateValue(String str, Integer num) {
        wh(str);
        Integer valueOf = Integer.valueOf(num == null ? -1 : num.intValue());
        setInputSelection(valueOf.intValue(), valueOf.intValue());
    }

    public final Editable apk() {
        return aph() == null ? null : aph().getEditableText();
    }

    protected final void setInputSelection(int i, int i2) {
        b.a(aph(), i, i2);
    }
}
