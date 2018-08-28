package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Layout.Alignment;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.style.AlignmentSpan.Standard;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.s.f;
import com.tencent.mm.plugin.appbrand.widget.b.d;
import com.tencent.mm.plugin.appbrand.widget.input.z.b;
import com.tencent.mm.plugin.appbrand.widget.input.z.c;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;
import java.util.Map;

@SuppressLint({"AppCompatCustomView"})
public abstract class w extends EditText implements d, z {
    InputConnection gHZ;
    private final Map<c, Object> gIA = new android.support.v4.e.a();
    private final a gIB = new a(this, (byte) 0);
    private final PasswordTransformationMethod gIC = new k();
    private final x gID = new x(this);
    private boolean gIE;
    private int gIF = 0;
    private boolean gIG = false;
    private final int[] gIH = new int[2];
    private b gII;
    char gIJ = 0;
    boolean gIw = false;
    private final com.tencent.mm.plugin.appbrand.widget.input.autofill.b gIx;
    private final Map<com.tencent.mm.plugin.appbrand.widget.input.z.a, Object> gIy = new android.support.v4.e.a();
    private final Map<OnFocusChangeListener, Object> gIz = new android.support.v4.e.a();
    private volatile int mInputId = -1;

    private final class a implements TextWatcher {
        final Map<TextWatcher, Object> gIL;

        private a() {
            this.gIL = new android.support.v4.e.a();
        }

        /* synthetic */ a(w wVar, byte b) {
            this();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!w.a(w.this) && !this.gIL.isEmpty()) {
                for (TextWatcher beforeTextChanged : (TextWatcher[]) this.gIL.keySet().toArray(new TextWatcher[this.gIL.size()])) {
                    beforeTextChanged.beforeTextChanged(charSequence, i, i2, i3);
                }
            }
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!w.a(w.this) && !this.gIL.isEmpty()) {
                for (TextWatcher onTextChanged : (TextWatcher[]) this.gIL.keySet().toArray(new TextWatcher[this.gIL.size()])) {
                    onTextChanged.onTextChanged(charSequence, i, i2, i3);
                }
            }
        }

        public final void afterTextChanged(Editable editable) {
            if (e.apl()) {
                PBool pBool = new PBool();
                PInt pInt = new PInt();
                String a = w.a(editable, pBool, pInt);
                int i = pInt.value;
                if (pBool.value && !bi.oW(a)) {
                    w.this.post(new 1(this, w.a(w.this), a, Selection.getSelectionEnd(editable), i));
                    return;
                }
            }
            if (!w.a(w.this)) {
                w.this.gIF = 0;
                if (!this.gIL.isEmpty()) {
                    for (TextWatcher afterTextChanged : (TextWatcher[]) this.gIL.keySet().toArray(new TextWatcher[this.gIL.size()])) {
                        afterTextChanged.afterTextChanged(editable);
                    }
                }
            }
        }
    }

    protected abstract void apx();

    static /* synthetic */ String a(Editable editable, PBool pBool, PInt pInt) {
        pInt.value = 0;
        pBool.value = false;
        if (editable == null || editable.length() <= 0) {
            return null;
        }
        String obj = editable.toString();
        int length = editable.length();
        int i = 0;
        while (i < length) {
            String str;
            int codePointAt = obj.codePointAt(i);
            com.tencent.mm.br.c Dg = com.tencent.mm.br.b.cjC().Dg(codePointAt);
            if (Dg == null || Dg.sLL == 0) {
                str = obj;
            } else {
                str = obj.replace(new String(Character.toChars(codePointAt)), Character.toChars(Dg.sLL) + (Dg.sLM != 0 ? Character.toChars(Dg.sLM) : ""));
                pBool.value = true;
                pInt.value++;
            }
            i++;
            obj = str;
        }
        return obj;
    }

    public int getInputId() {
        return this.mInputId;
    }

    public void setInputId(int i) {
        this.mInputId = i;
    }

    public String toString() {
        return String.format(Locale.US, "[%s|%s]", new Object[]{getClass().getSimpleName(), Integer.valueOf(getInputId())});
    }

    public final View getView() {
        return this;
    }

    public boolean apw() {
        return true;
    }

    public com.tencent.mm.plugin.appbrand.widget.input.autofill.b getAutoFillController() {
        return this.gIx;
    }

    public void D(float f, float f2) {
        throw new IllegalStateException("Should implement performClick(float, float) in this class!");
    }

    public final void a(com.tencent.mm.plugin.appbrand.widget.input.z.a aVar) {
        this.gIy.put(aVar, this);
    }

    public final void a(OnFocusChangeListener onFocusChangeListener) {
        if (onFocusChangeListener != null) {
            this.gIz.put(onFocusChangeListener, this);
        }
    }

    public final void b(OnFocusChangeListener onFocusChangeListener) {
        if (onFocusChangeListener != null) {
            this.gIz.remove(onFocusChangeListener);
        }
    }

    public final void a(c cVar) {
        this.gIA.put(cVar, this);
    }

    public void setOnComposingDismissedListener(com.tencent.mm.plugin.appbrand.widget.input.a.b bVar) {
        this.gID.gIR = bVar;
    }

    public w(Context context) {
        super(context);
        setBackgroundDrawable(null);
        setIncludeFontPadding(false);
        me(3);
        setSingleLine(true);
        setTextCursorDrawable(f.app_brand_web_edit_text_cursor);
        setTextIsSelectable(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (VERSION.SDK_INT >= 16) {
            setLineSpacing(0.0f, 1.0f);
        }
        setTypeface(Typeface.SANS_SERIF);
        super.addTextChangedListener(this.gIB);
        super.setPadding(0, 0, 0, 0);
        super.setEditableFactory(new 1(this));
        if (apw()) {
            this.gIx = new com.tencent.mm.plugin.appbrand.widget.input.autofill.b(this);
        } else {
            this.gIx = null;
        }
        this.gIE = true;
    }

    public boolean apd() {
        return false;
    }

    private void me(int i) {
        setGravity(((getGravity() & -8388612) & -8388614) | i);
        int gravity = getGravity();
        CharSequence hint = getHint();
        if (!TextUtils.isEmpty(hint)) {
            Alignment alignment;
            hint = af.r(hint);
            switch (gravity & 7) {
                case 1:
                    alignment = Alignment.ALIGN_CENTER;
                    break;
                case 5:
                    alignment = Alignment.ALIGN_OPPOSITE;
                    break;
                default:
                    alignment = Alignment.ALIGN_NORMAL;
                    break;
            }
            hint.setSpan(new Standard(alignment), 0, getHint().length(), 18);
            super.setHint(hint);
            if (VERSION.SDK_INT >= 17) {
                switch (3.azD[alignment.ordinal()]) {
                    case 1:
                        gravity = 4;
                        break;
                    case 2:
                        gravity = 6;
                        break;
                    default:
                        gravity = 5;
                        break;
                }
                super.setTextAlignment(gravity);
            }
        }
    }

    Editable c(Editable editable) {
        return this.gID.c(editable);
    }

    public final int mf(int i) {
        x.d("MicroMsg.AppBrand.WebEditText", "calculateLinePosition, lineNumber %d, returnHeight %d, layout %s", new Object[]{Integer.valueOf(i), Integer.valueOf(getPaddingTop() + ((int) (((float) i) * (((float) getLineHeight()) + getLineSpacingExtra())))), getLayout()});
        return getPaddingTop() + ((int) (((float) i) * (((float) getLineHeight()) + getLineSpacingExtra())));
    }

    public final int apL() {
        return mf(getLineCount()) + getPaddingBottom();
    }

    public final void apM() {
        me(3);
    }

    public final void apN() {
        me(5);
    }

    public final void apO() {
        me(1);
    }

    public void setSelection(int i) {
        if (getEditableText() != null) {
            super.setSelection(Math.min(i, getEditableText().length()));
        }
    }

    public void setSelection(int i, int i2) {
        super.setSelection(i, i2);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        this.gHZ = new 2(this, super.onCreateInputConnection(editorInfo));
        return this.gHZ;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        if (onKeyDown && i == 66) {
            this.gIJ = 10;
        }
        return onKeyDown;
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText(charSequence, bufferType);
    }

    public void setMinHeight(int i) {
        if (getMinHeight() != i) {
            super.setMinHeight(i);
        }
    }

    public void setMaxHeight(int i) {
        if (getMaxHeight() != i) {
            super.setMaxHeight(i);
        }
    }

    protected final void onMeasure(int i, int i2) {
        x.v("MicroMsg.AppBrand.WebEditText", "[scrollUp] input onMeasure");
        super.onMeasure(i, i2);
        if (!this.gIA.isEmpty()) {
            for (Object obj : this.gIA.keySet().toArray()) {
                c cVar = (c) obj;
                getMeasuredWidth();
                getMeasuredHeight();
                cVar.apy();
            }
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        x.v("MicroMsg.AppBrand.WebEditText", "[scrollUp] input onLayout");
        super.onLayout(z, i, i2, i3, i4);
    }

    final void apP() {
        this.gIF++;
    }

    final void apQ() {
        this.gIF = Math.max(0, this.gIF - 1);
    }

    public final void q(CharSequence charSequence) {
        apP();
        Editable editableText = getEditableText();
        if (editableText == null) {
            setText(charSequence, BufferType.EDITABLE);
        } else {
            clearComposingText();
            if (TextUtils.isEmpty(charSequence)) {
                editableText.clear();
            } else {
                editableText.replace(0, editableText.length(), charSequence);
            }
        }
        apQ();
    }

    public final void r(p pVar) {
        if (this.gIx != null) {
            com.tencent.mm.plugin.appbrand.widget.input.autofill.c cVar = this.gIx.gJX;
            cVar.gKi = pVar;
            i l = i.l(pVar);
            i$a i_a = cVar.gKh;
            if (i_a != null && !l.gGQ.containsKey(i_a)) {
                l.gGQ.put(i_a, l);
            }
        }
    }

    public final void s(p pVar) {
        if (this.gIx != null) {
            i.l(pVar).a(this.gIx.gJX.gKh);
        }
    }

    public void setFixed(boolean z) {
        this.gIG = z;
    }

    public boolean apz() {
        return this.gIG;
    }

    public final void setTextCursorDrawable(int i) {
        try {
            new com.tencent.mm.compatible.loader.c(this, "mCursorDrawableRes", TextView.class.getName()).set(Integer.valueOf(i));
        } catch (Throwable e) {
            x.d("MicroMsg.AppBrand.WebEditText", "setTextCursorDrawable, exp = %s", new Object[]{bi.i(e)});
        }
    }

    public void setPasswordMode(boolean z) {
        apP();
        this.gIw = z;
        setTransformationMethod(z ? this.gIC : null);
        apQ();
    }

    public void setInputType(int i) {
        if (getInputType() != i) {
            super.setInputType(i);
        }
    }

    public void setSingleLine(boolean z) {
    }

    public final void setTextSize(float f) {
        setTextSize(0, f);
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
    }

    public void setTypeface(Typeface typeface) {
        super.setTypeface(typeface);
    }

    public void setTypeface(Typeface typeface, int i) {
        super.setTypeface(typeface, i);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        a aVar = this.gIB;
        if (textWatcher != null) {
            aVar.gIL.put(textWatcher, aVar);
        }
    }

    public void removeTextChangedListener(TextWatcher textWatcher) {
        a aVar = this.gIB;
        if (textWatcher != null) {
            aVar.gIL.remove(textWatcher);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.gIy.isEmpty()) {
            for (com.tencent.mm.plugin.appbrand.widget.input.z.a apR : (com.tencent.mm.plugin.appbrand.widget.input.z.a[]) this.gIy.keySet().toArray(new com.tencent.mm.plugin.appbrand.widget.input.z.a[this.gIy.size()])) {
                apR.apR();
            }
        }
    }

    public void setOnKeyUpPostImeListener(b bVar) {
        this.gII = bVar;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.gII == null || !this.gII.lV(i)) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    public char getLastKeyPressed() {
        return this.gIJ;
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (!z) {
            clearComposingText();
        }
        if (z) {
            apx();
        }
        if (!this.gIz.isEmpty()) {
            for (OnFocusChangeListener onFocusChange : (OnFocusChangeListener[]) this.gIz.keySet().toArray(new OnFocusChangeListener[this.gIz.size()])) {
                onFocusChange.onFocusChange(this, z);
            }
        }
    }

    public void clearFocus() {
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setFocusableInTouchMode(true);
            ((ViewGroup) getParent()).setDescendantFocusability(131072);
        }
        super.clearFocus();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (130 == i && rect == null && (getParent() instanceof ViewGroup)) {
            ((ViewGroup) getParent()).setDescendantFocusability(262144);
            ((ViewGroup) getParent()).setFocusableInTouchMode(false);
        }
        return super.requestFocus(i, rect);
    }

    @Deprecated
    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        super.setOnFocusChangeListener(onFocusChangeListener);
    }

    public final void destroy() {
        this.gIy.clear();
        this.gIA.clear();
        this.gIz.clear();
        this.gIB.gIL.clear();
        if (this.gIx != null) {
            com.tencent.mm.plugin.appbrand.widget.input.autofill.b bVar = this.gIx;
            com.tencent.mm.plugin.appbrand.widget.input.autofill.c cVar = bVar.gJX;
            i.l(cVar.gKi).a(cVar.gKh);
            bVar.gKa = null;
            bVar.gJV.dismiss();
        }
        super.setOnFocusChangeListener(null);
    }
}
