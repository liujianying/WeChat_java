package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView$t;
import android.text.Editable;
import android.text.Layout;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ParagraphStyle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView.BufferType;
import com.tencent.mm.br.g;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.plugin.wenote.model.nativenote.b.c;
import com.tencent.mm.plugin.wenote.model.nativenote.c.b;
import com.tencent.mm.plugin.wenote.model.nativenote.c.d;
import com.tencent.mm.plugin.wenote.model.nativenote.c.e;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.i;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.m;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.n;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.edittext.PasterEditText;
import java.util.ArrayList;

public class WXRTEditText extends PasterEditText implements SpanWatcher {
    private al eOf = null;
    public int jDz = 0;
    public boolean qoP = false;
    public int qoR = 0;
    private int qqA = -1;
    private int qqB = -1;
    private boolean qqC = false;
    private boolean qqD;
    private int qqE;
    private int qqF;
    private String qqG;
    public String qqH = "";
    private Spannable qqI;
    int qqJ = 0;
    private WXRTEditText qqK = null;
    public RecyclerView$t qqL;
    private boolean qqM;
    private boolean qqN;
    private boolean qqO;
    private boolean qqP;
    private boolean qqQ;
    private boolean qqR = false;
    private boolean qqS;
    private j qqT;
    public boolean qqU = false;
    public boolean qqV = false;
    private int qqW = -1;
    private Paint qqX = null;
    private b qqY = null;
    private boolean qqZ = false;
    c qqz;
    private Path qra = null;
    private int qrb = -1;
    private int qrc = -1;
    private int qrd = -1;
    private boolean qre = false;
    TextWatcher qrf = new 2(this);
    int qrg = 0;

    public WXRTEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public WXRTEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void setMaxHeight(int i) {
        super.setMaxHeight(i);
    }

    private void init() {
        this.qqK = this;
        removeTextChangedListener(this.qrf);
        addTextChangedListener(this.qrf);
        setMovementMethod(i.caI());
        this.qqW = -1;
        this.qqX = new Paint(1);
        this.qqX.setColor(1347529272);
        this.qqY = new b();
        this.qra = new Path();
        this.qrb = -1;
        this.qrc = -1;
        this.qrd = -1;
        if (e.isEnabled()) {
            setHighlightColor(0);
            setCustomSelectionActionModeCallback(new 1(this));
        }
    }

    public void setRichTextEditing(String str) {
        cab();
        if (bi.oW(str)) {
            setText("");
        } else {
            setSpannableText(a.Sk(str));
        }
        cac();
    }

    public void setSpannableText(Spanned spanned) {
        cab();
        cad();
        super.setText(spanned, BufferType.EDITABLE);
        cae();
        caf();
        u.a(this, new t[0]);
        cac();
    }

    public void setText(String str) {
        cab();
        super.setText(str);
        cac();
    }

    public void setTextWithoutIgnore(String str) {
        super.setText(str);
    }

    public final void bZZ() {
        if (this.qqz != null) {
            this.qqz.e(true, 50);
            this.qqz.Bs(1);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        this.qre = false;
        this.qqA = -1;
        this.qqB = -1;
        super.onFocusChanged(z, i, rect);
        if (this.qqz != null) {
            this.qqz.a(this, z, getRecyclerItemPosition());
        }
        if (z && !this.qre) {
            onSelectionChanged(getSelectionStart(), getSelectionEnd());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onSelectionChanged(int r5, int r6) {
        /*
        r4 = this;
        r2 = 0;
        r1 = 1;
        monitor-enter(r4);
        r0 = r4.qqC;	 Catch:{ all -> 0x007a }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r4);	 Catch:{ all -> 0x007a }
    L_0x0008:
        return;
    L_0x0009:
        monitor-exit(r4);	 Catch:{ all -> 0x007a }
        r4.qre = r1;
        if (r5 < 0) goto L_0x0008;
    L_0x000e:
        r0 = r4.qqA;
        if (r0 != r5) goto L_0x0016;
    L_0x0012:
        r0 = r4.qqB;
        if (r0 == r6) goto L_0x0043;
    L_0x0016:
        r4.qqA = r5;
        r4.qqB = r6;
        super.onSelectionChanged(r5, r6);
        if (r6 <= r5) goto L_0x007d;
    L_0x001f:
        r0 = r1;
    L_0x0020:
        r4.qqN = r0;
        r0 = r4.qqO;
        if (r0 != 0) goto L_0x0036;
    L_0x0026:
        r0 = r4.qqP;
        if (r0 != 0) goto L_0x0036;
    L_0x002a:
        r4.qqQ = r1;
        r0 = new com.tencent.mm.plugin.wenote.model.nativenote.spans.t[r2];
        com.tencent.mm.plugin.wenote.model.nativenote.spans.u.a(r4, r0);
        r4.qqQ = r2;
        r4.setParagraphsAreUp2Date(r1);
    L_0x0036:
        r0 = r4.qqz;
        if (r0 == 0) goto L_0x0043;
    L_0x003a:
        r4.qqR = r1;
        r0 = r4.qqz;
        r0.a(r4, r5, r6);
        r4.qqR = r2;
    L_0x0043:
        r0 = com.tencent.mm.plugin.wenote.model.nativenote.c.e.isEnabled();
        if (r0 == 0) goto L_0x0008;
    L_0x0049:
        r0 = r4.qqZ;
        if (r0 != 0) goto L_0x0008;
    L_0x004d:
        r0 = r4.hasFocus();
        if (r0 == 0) goto L_0x0008;
    L_0x0053:
        r0 = r4.qqW;
        if (r0 < 0) goto L_0x0008;
    L_0x0057:
        r4.et(r5, r6);
        r0 = com.tencent.mm.plugin.wenote.model.nativenote.c.e.cap();
        r2 = r4.qqW;
        r0 = r0.Bx(r2);
        if (r0 != r1) goto L_0x0008;
    L_0x0066:
        r0 = com.tencent.mm.plugin.wenote.model.nativenote.c.e.cap();
        r2 = com.tencent.mm.plugin.wenote.model.nativenote.c.e.mHasInit;
        if (r2 == 0) goto L_0x0008;
    L_0x006e:
        r2 = 0;
        r0.f(r1, r2);
        r0.cax();
        r0.cav();
        goto L_0x0008;
    L_0x007a:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x007a }
        throw r0;
    L_0x007d:
        r0 = r2;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText.onSelectionChanged(int, int):void");
    }

    public final Spannable caa() {
        CharSequence text = super.getText();
        if (text == null) {
            text = "";
        }
        return new a(text);
    }

    public String getSelectedText() {
        Spannable text = getText();
        e selection = getSelection();
        if (selection.Tw < 0 || selection.tK < 0 || selection.tK > text.length()) {
            return null;
        }
        return text.subSequence(selection.Tw, selection.tK).toString();
    }

    public e getSelection() {
        return new e(getSelectionStart(), getSelectionEnd());
    }

    public final String a(i iVar) {
        if (iVar == i.qrj) {
            return getText().toString();
        }
        if (iVar == i.qrk) {
            return com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(getText());
        }
        return "";
    }

    public int getRecyclerItemPosition() {
        if (this.qqL.gl() == -1) {
            return 0;
        }
        return this.qqL.gl();
    }

    public int getEditTextType() {
        return this.qqJ;
    }

    public void setEditTextType(int i) {
        this.qqJ = i;
    }

    public boolean onTextContextMenuItem(int i) {
        if (i == 16908319) {
            this.qqz.bZz();
            return true;
        }
        if (i == 16908321 || i == 16908320) {
            f.acV();
        } else if (i == 16908322) {
            int eE = f.eE(getContext());
            if (eE == 2) {
                f.acV();
            } else if (eE == 3) {
                this.qqz.b(this);
                return true;
            }
        }
        try {
            boolean onTextContextMenuItem = super.onTextContextMenuItem(i);
            if (i == 16908322) {
                this.qrg = 0;
                try {
                    b(getText());
                } catch (IndexOutOfBoundsException e) {
                    x.e("noteeditor.WXRTEditText", "!!MMEditText Exception %d", new Object[]{Integer.valueOf(this.qrg)});
                    if (this.qrg < 3) {
                        this.qrg++;
                        b(new SpannableStringBuilder(TextUtils.concat(new CharSequence[]{" ", r3})));
                    } else {
                        throw e;
                    }
                }
            }
            if (i == 16908322 && this.qoP) {
                if (this.qqz != null) {
                    this.qqz.e(false, 0);
                    this.qqz.Bs(0);
                }
                this.qoP = false;
            }
            return onTextContextMenuItem;
        } catch (NullPointerException e2) {
            x.e("noteeditor.WXRTEditText", "!!MMEditText NullPointerException %s", new Object[]{e2});
            return false;
        }
    }

    private void b(Spannable spannable) {
        int selectionStart = getSelectionStart();
        g cjL = g.cjL();
        getContext();
        setSpannableText(cjL.a(spannable, getTextSize()));
        int length = getText().length() - spannable.length();
        if (length > 0) {
            selectionStart += length;
            if (selectionStart <= getText().length()) {
                setSelection(selectionStart);
                return;
            }
            return;
        }
        setSelection(selectionStart);
    }

    public final synchronized void cab() {
        this.qqD = true;
    }

    public final synchronized void cac() {
        this.qqD = false;
    }

    public final synchronized void cad() {
        this.qqC = true;
    }

    public final synchronized void cae() {
        this.qqC = false;
    }

    public void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
        this.qqM = true;
        if ((obj instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.g) && (obj instanceof ParagraphStyle)) {
            setParagraphsAreUp2Date(false);
        }
    }

    public void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
        this.qqM = true;
        if ((obj instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.g) && (obj instanceof ParagraphStyle)) {
            setParagraphsAreUp2Date(false);
        }
    }

    public void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
        this.qqM = true;
        if ((obj instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.g) && (obj instanceof ParagraphStyle)) {
            setParagraphsAreUp2Date(false);
        }
    }

    public final <V, C extends com.tencent.mm.plugin.wenote.model.nativenote.spans.g<V>> void a(t<V, C> tVar, V v) {
        if (!this.qqR && !this.qqO) {
            Spannable caa = this.qqD ? null : caa();
            tVar.a(this, v);
            synchronized (this) {
                if (!(this.qqz == null || this.qqD)) {
                    Spannable caa2 = caa();
                    c cVar = this.qqz;
                    getSelectionStart();
                    getSelectionEnd();
                    getSelectionStart();
                    cVar.a(this, caa, caa2, getSelectionEnd());
                }
                this.qqS = true;
            }
        }
    }

    private void caf() {
        Spannable text = getText();
        if (text.getSpans(0, text.length(), getClass()) != null) {
            text.setSpan(this, 0, text.length(), 18);
        }
    }

    private synchronized void setParagraphsAreUp2Date(boolean z) {
        if (!this.qqQ) {
            this.qqP = z;
        }
    }

    public e getParagraphsInSelection() {
        int i = 0;
        j rTLayout = getRTLayout();
        e eVar = new e(this);
        int lineForOffset = rTLayout.getLineForOffset(eVar.Tw);
        int lineForOffset2 = rTLayout.getLineForOffset(eVar.isEmpty() ? eVar.tK : eVar.tK - 1);
        lineForOffset = (rTLayout.qrm == 0 || lineForOffset < 0) ? 0 : lineForOffset < rTLayout.qrm ? ((n) rTLayout.qrn.get(lineForOffset)).Tw : ((n) rTLayout.qrn.get(rTLayout.qrm - 1)).tK - 1;
        if (rTLayout.qrm != 0 && lineForOffset2 >= 0) {
            i = lineForOffset2 < rTLayout.qrm ? ((n) rTLayout.qrn.get(lineForOffset2)).tK : ((n) rTLayout.qrn.get(rTLayout.qrm - 1)).tK - 1;
        }
        return new e(lineForOffset, i);
    }

    public ArrayList<n> getParagraphs() {
        return getRTLayout().qrn;
    }

    private j getRTLayout() {
        j jVar;
        synchronized (this) {
            if (this.qqT == null || this.qqS) {
                this.qqT = new j(getText());
                this.qqS = false;
            }
            jVar = this.qqT;
        }
        return jVar;
    }

    public String getCurrentEditorCursorParagraphStr() {
        e paragraphsInSelection = getParagraphsInSelection();
        return getText().subSequence(paragraphsInSelection.Tw, paragraphsInSelection.tK).toString().trim();
    }

    public m[] getCurrentEditorCursorNumberSpan() {
        e paragraphsInSelection = getParagraphsInSelection();
        return (m[]) getText().getSpans(paragraphsInSelection.Tw, paragraphsInSelection.tK, m.class);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onDraw(android.graphics.Canvas r17) {
        /*
        r16 = this;
        r1 = com.tencent.mm.plugin.wenote.model.nativenote.c.e.isEnabled();
        if (r1 == 0) goto L_0x0039;
    L_0x0006:
        r0 = r16;
        r1 = r0.qqJ;
        if (r1 != 0) goto L_0x0039;
    L_0x000c:
        r7 = r16.getText();
        if (r7 == 0) goto L_0x0039;
    L_0x0012:
        r1 = com.tencent.mm.plugin.wenote.model.nativenote.c.e.cap();
        r4 = r1.car();
        r5 = -1;
        r3 = 0;
        r2 = 0;
        r1 = 0;
        r6 = com.tencent.mm.plugin.wenote.model.nativenote.c.e.cap();
        r0 = r16;
        r8 = r0.qqW;
        r6 = r6.Bx(r8);
        switch(r6) {
            case 1: goto L_0x003d;
            case 2: goto L_0x004a;
            case 3: goto L_0x005e;
            case 4: goto L_0x0054;
            default: goto L_0x002d;
        };
    L_0x002d:
        r6 = r2;
        r4 = r3;
    L_0x002f:
        if (r5 < 0) goto L_0x0039;
    L_0x0031:
        r2 = r7.length();
        if (r4 > r2) goto L_0x0039;
    L_0x0037:
        if (r5 <= r4) goto L_0x0065;
    L_0x0039:
        super.onDraw(r17);
        return;
    L_0x003d:
        r3 = r4.startOffset;
        r5 = r4.qsa;
        if (r3 == r5) goto L_0x0039;
    L_0x0043:
        r5 = r4.startOffset;
        r3 = r4.qsa;
        r6 = r2;
        r4 = r3;
        goto L_0x002f;
    L_0x004a:
        r5 = 0;
        r3 = r7.length();
        r2 = 1;
        r1 = 1;
        r6 = r2;
        r4 = r3;
        goto L_0x002f;
    L_0x0054:
        r5 = r4.startOffset;
        r3 = r7.length();
        r1 = 1;
        r6 = r2;
        r4 = r3;
        goto L_0x002f;
    L_0x005e:
        r5 = 0;
        r3 = r4.qsa;
        r2 = 1;
        r6 = r2;
        r4 = r3;
        goto L_0x002f;
    L_0x0065:
        r7 = r16.getLayout();
        if (r7 == 0) goto L_0x0039;
    L_0x006b:
        r0 = r16;
        r2 = r0.qrb;
        r3 = -1;
        if (r2 != r3) goto L_0x007a;
    L_0x0072:
        r2 = r16.getPaddingLeft();
        r0 = r16;
        r0.qrb = r2;
    L_0x007a:
        r0 = r16;
        r2 = r0.qrc;
        r3 = -1;
        if (r2 != r3) goto L_0x0089;
    L_0x0081:
        r2 = r16.getPaddingTop();
        r0 = r16;
        r0.qrc = r2;
    L_0x0089:
        r0 = r16;
        r2 = r0.qrd;
        r3 = -1;
        if (r2 != r3) goto L_0x0098;
    L_0x0090:
        r2 = r16.getPaddingBottom();
        r0 = r16;
        r0.qrd = r2;
    L_0x0098:
        r0 = r16;
        r2 = r0.qra;
        if (r2 != 0) goto L_0x00a7;
    L_0x009e:
        r2 = new android.graphics.Path;
        r2.<init>();
        r0 = r16;
        r0.qra = r2;
    L_0x00a7:
        r0 = r16;
        r2 = r0.qra;
        r2.reset();
        r13 = r7.getLineForOffset(r5);	 Catch:{ Exception -> 0x014a }
        r14 = r7.getLineForOffset(r4);	 Catch:{ Exception -> 0x014a }
        if (r13 > r14) goto L_0x0039;
    L_0x00b8:
        r15 = r7.getWidth();	 Catch:{ Exception -> 0x014a }
        r2 = r7.getPrimaryHorizontal(r5);	 Catch:{ Exception -> 0x014a }
        r0 = r16;
        r3 = r0.qrb;	 Catch:{ Exception -> 0x014a }
        r3 = (float) r3;	 Catch:{ Exception -> 0x014a }
        r2 = r2 + r3;
        r3 = r7.getLineTop(r13);	 Catch:{ Exception -> 0x014a }
        r0 = r16;
        r5 = r0.qrc;	 Catch:{ Exception -> 0x014a }
        r3 = r3 + r5;
        r3 = (float) r3;	 Catch:{ Exception -> 0x014a }
        r5 = r7.getLineBottom(r13);	 Catch:{ Exception -> 0x014a }
        r0 = r16;
        r8 = r0.qrc;	 Catch:{ Exception -> 0x014a }
        r5 = r5 + r8;
        r10 = (float) r5;	 Catch:{ Exception -> 0x014a }
        r4 = r7.getPrimaryHorizontal(r4);	 Catch:{ Exception -> 0x014a }
        r0 = r16;
        r5 = r0.qrb;	 Catch:{ Exception -> 0x014a }
        r5 = (float) r5;	 Catch:{ Exception -> 0x014a }
        r4 = r4 + r5;
        r5 = r7.getLineTop(r14);	 Catch:{ Exception -> 0x014a }
        r0 = r16;
        r8 = r0.qrc;	 Catch:{ Exception -> 0x014a }
        r5 = r5 + r8;
        r12 = (float) r5;	 Catch:{ Exception -> 0x014a }
        r5 = r7.getLineBottom(r14);	 Catch:{ Exception -> 0x014a }
        r0 = r16;
        r7 = r0.qrc;	 Catch:{ Exception -> 0x014a }
        r5 = r5 + r7;
        r5 = (float) r5;	 Catch:{ Exception -> 0x014a }
        if (r6 == 0) goto L_0x015c;
    L_0x00fa:
        if (r1 == 0) goto L_0x015c;
    L_0x00fc:
        r0 = r16;
        r1 = r0.qra;	 Catch:{ Exception -> 0x014a }
        r0 = r16;
        r2 = r0.qrb;	 Catch:{ Exception -> 0x014a }
        r2 = (float) r2;	 Catch:{ Exception -> 0x014a }
        r3 = 0;
        r0 = r16;
        r4 = r0.qrb;	 Catch:{ Exception -> 0x014a }
        r4 = r4 + r15;
        r4 = (float) r4;	 Catch:{ Exception -> 0x014a }
        r0 = r16;
        r6 = r0.qrd;	 Catch:{ Exception -> 0x014a }
        r6 = (float) r6;	 Catch:{ Exception -> 0x014a }
        r5 = r5 + r6;
        r6 = android.graphics.Path.Direction.CW;	 Catch:{ Exception -> 0x014a }
        r1.addRect(r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x014a }
    L_0x0117:
        r0 = r16;
        r1 = r0.qra;	 Catch:{ Exception -> 0x014a }
        r1 = r1.isEmpty();	 Catch:{ Exception -> 0x014a }
        if (r1 != 0) goto L_0x0039;
    L_0x0121:
        r0 = r16;
        r1 = r0.qqX;	 Catch:{ Exception -> 0x014a }
        if (r1 != 0) goto L_0x013b;
    L_0x0127:
        r1 = new android.graphics.Paint;	 Catch:{ Exception -> 0x014a }
        r2 = 1;
        r1.<init>(r2);	 Catch:{ Exception -> 0x014a }
        r0 = r16;
        r0.qqX = r1;	 Catch:{ Exception -> 0x014a }
        r0 = r16;
        r1 = r0.qqX;	 Catch:{ Exception -> 0x014a }
        r2 = 1347529272; // 0x5051aa38 float:1.40703744E10 double:6.6576792E-315;
        r1.setColor(r2);	 Catch:{ Exception -> 0x014a }
    L_0x013b:
        r0 = r16;
        r1 = r0.qra;	 Catch:{ Exception -> 0x014a }
        r0 = r16;
        r2 = r0.qqX;	 Catch:{ Exception -> 0x014a }
        r0 = r17;
        r0.drawPath(r1, r2);	 Catch:{ Exception -> 0x014a }
        goto L_0x0039;
    L_0x014a:
        r1 = move-exception;
        r2 = "noteeditor.WXRTEditText";
        r3 = "tryDrawCover: ";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r1;
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);
        goto L_0x0039;
    L_0x015c:
        if (r13 != r14) goto L_0x0192;
    L_0x015e:
        if (r6 == 0) goto L_0x0170;
    L_0x0160:
        r0 = r16;
        r1 = r0.qra;	 Catch:{ Exception -> 0x014a }
        r0 = r16;
        r2 = r0.qrb;	 Catch:{ Exception -> 0x014a }
        r2 = (float) r2;	 Catch:{ Exception -> 0x014a }
        r3 = 0;
        r6 = android.graphics.Path.Direction.CW;	 Catch:{ Exception -> 0x014a }
        r1.addRect(r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x014a }
        goto L_0x0117;
    L_0x0170:
        if (r1 == 0) goto L_0x0188;
    L_0x0172:
        r0 = r16;
        r1 = r0.qra;	 Catch:{ Exception -> 0x014a }
        r0 = r16;
        r4 = r0.qrb;	 Catch:{ Exception -> 0x014a }
        r4 = r4 + r15;
        r4 = (float) r4;	 Catch:{ Exception -> 0x014a }
        r0 = r16;
        r6 = r0.qrd;	 Catch:{ Exception -> 0x014a }
        r6 = (float) r6;	 Catch:{ Exception -> 0x014a }
        r5 = r5 + r6;
        r6 = android.graphics.Path.Direction.CW;	 Catch:{ Exception -> 0x014a }
        r1.addRect(r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x014a }
        goto L_0x0117;
    L_0x0188:
        r0 = r16;
        r1 = r0.qra;	 Catch:{ Exception -> 0x014a }
        r6 = android.graphics.Path.Direction.CW;	 Catch:{ Exception -> 0x014a }
        r1.addRect(r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x014a }
        goto L_0x0117;
    L_0x0192:
        if (r6 == 0) goto L_0x01d3;
    L_0x0194:
        r0 = r16;
        r6 = r0.qra;	 Catch:{ Exception -> 0x014a }
        r0 = r16;
        r1 = r0.qrb;	 Catch:{ Exception -> 0x014a }
        r7 = (float) r1;	 Catch:{ Exception -> 0x014a }
        r8 = 0;
        r0 = r16;
        r1 = r0.qrb;	 Catch:{ Exception -> 0x014a }
        r1 = r1 + r15;
        r9 = (float) r1;	 Catch:{ Exception -> 0x014a }
        r11 = android.graphics.Path.Direction.CW;	 Catch:{ Exception -> 0x014a }
        r6.addRect(r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x014a }
        r0 = r16;
        r1 = r0.qra;	 Catch:{ Exception -> 0x014a }
        r0 = r16;
        r2 = r0.qrb;	 Catch:{ Exception -> 0x014a }
        r2 = (float) r2;	 Catch:{ Exception -> 0x014a }
        r6 = android.graphics.Path.Direction.CW;	 Catch:{ Exception -> 0x014a }
        r3 = r12;
        r1.addRect(r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x014a }
    L_0x01b8:
        r1 = r14 - r13;
        r2 = 1;
        if (r1 <= r2) goto L_0x0117;
    L_0x01bd:
        r0 = r16;
        r8 = r0.qra;	 Catch:{ Exception -> 0x014a }
        r0 = r16;
        r1 = r0.qrb;	 Catch:{ Exception -> 0x014a }
        r9 = (float) r1;	 Catch:{ Exception -> 0x014a }
        r0 = r16;
        r1 = r0.qrb;	 Catch:{ Exception -> 0x014a }
        r1 = r1 + r15;
        r11 = (float) r1;	 Catch:{ Exception -> 0x014a }
        r13 = android.graphics.Path.Direction.CW;	 Catch:{ Exception -> 0x014a }
        r8.addRect(r9, r10, r11, r12, r13);	 Catch:{ Exception -> 0x014a }
        goto L_0x0117;
    L_0x01d3:
        if (r1 == 0) goto L_0x0202;
    L_0x01d5:
        r0 = r16;
        r6 = r0.qra;	 Catch:{ Exception -> 0x014a }
        r0 = r16;
        r1 = r0.qrb;	 Catch:{ Exception -> 0x014a }
        r1 = r1 + r15;
        r9 = (float) r1;	 Catch:{ Exception -> 0x014a }
        r11 = android.graphics.Path.Direction.CW;	 Catch:{ Exception -> 0x014a }
        r7 = r2;
        r8 = r3;
        r6.addRect(r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x014a }
        r0 = r16;
        r1 = r0.qra;	 Catch:{ Exception -> 0x014a }
        r0 = r16;
        r2 = r0.qrb;	 Catch:{ Exception -> 0x014a }
        r2 = (float) r2;	 Catch:{ Exception -> 0x014a }
        r0 = r16;
        r3 = r0.qrb;	 Catch:{ Exception -> 0x014a }
        r3 = r3 + r15;
        r4 = (float) r3;	 Catch:{ Exception -> 0x014a }
        r0 = r16;
        r3 = r0.qrd;	 Catch:{ Exception -> 0x014a }
        r3 = (float) r3;	 Catch:{ Exception -> 0x014a }
        r5 = r5 + r3;
        r6 = android.graphics.Path.Direction.CW;	 Catch:{ Exception -> 0x014a }
        r3 = r12;
        r1.addRect(r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x014a }
        goto L_0x01b8;
    L_0x0202:
        r0 = r16;
        r6 = r0.qra;	 Catch:{ Exception -> 0x014a }
        r0 = r16;
        r1 = r0.qrb;	 Catch:{ Exception -> 0x014a }
        r1 = r1 + r15;
        r9 = (float) r1;	 Catch:{ Exception -> 0x014a }
        r11 = android.graphics.Path.Direction.CW;	 Catch:{ Exception -> 0x014a }
        r7 = r2;
        r8 = r3;
        r6.addRect(r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x014a }
        r0 = r16;
        r1 = r0.qra;	 Catch:{ Exception -> 0x014a }
        r0 = r16;
        r2 = r0.qrb;	 Catch:{ Exception -> 0x014a }
        r2 = (float) r2;	 Catch:{ Exception -> 0x014a }
        r6 = android.graphics.Path.Direction.CW;	 Catch:{ Exception -> 0x014a }
        r3 = r12;
        r1.addRect(r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x014a }
        goto L_0x01b8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText.onDraw(android.graphics.Canvas):void");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (e.isEnabled()) {
            Spannable text = getText();
            if (text == null) {
                cah();
                return true;
            }
            int length = text.length();
            int offsetForPosition = getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
            if (length < 0 || offsetForPosition < 0 || offsetForPosition > length) {
                cah();
                return true;
            }
            switch (motionEvent.getAction()) {
                case 0:
                    int x = (int) motionEvent.getX();
                    length = (int) motionEvent.getY();
                    Layout layout = getLayout();
                    length = layout.getOffsetForHorizontal(layout.getLineForVertical(length), (float) x);
                    k[] kVarArr = (k[]) getText().getSpans(length, length + 1, k.class);
                    if (!e.cap().isEditable() || x >= b.bZC() || kVarArr.length == 0) {
                        cah();
                        this.qqY.a(1, motionEvent.getRawX(), motionEvent.getRawY(), motionEvent.getX(), motionEvent.getY(), offsetForPosition);
                        cag();
                        this.eOf.J(500, 0);
                        return true;
                    }
                    x.i("noteeditor.WXRTEditText", "clicked todo");
                    this.qqz.bZx();
                    kVarArr[0].a(this, text, motionEvent, kVarArr[0]);
                    return true;
                case 1:
                    cag();
                    if (this.qqY == null) {
                        return true;
                    }
                    b bVar = this.qqY;
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    float x2 = motionEvent.getX();
                    float y = motionEvent.getY();
                    bVar.qrS = rawX;
                    bVar.qrT = rawY;
                    bVar.qrU = x2;
                    bVar.qrV = y;
                    if (bVar.hER == 1) {
                        bVar.qrW = offsetForPosition;
                    } else {
                        bVar.qrW = 0;
                    }
                    length = this.qqY.getType();
                    cah();
                    if (length != 2) {
                        return true;
                    }
                    if (e.cap().isEditable()) {
                        boolean z2;
                        boolean z3;
                        if (!hasFocus()) {
                            requestFocus();
                            z2 = false;
                            z3 = false;
                        } else if (getSelectionStart() == getSelectionEnd() && offsetForPosition == getSelectionStart()) {
                            z2 = true;
                            z3 = true;
                        } else {
                            z2 = false;
                            z3 = true;
                        }
                        setIgnoreSelectChangeByMultiSelect(true);
                        setSelection(offsetForPosition);
                        setIgnoreSelectChangeByMultiSelect(false);
                        if (this.qqz != null) {
                            this.qqz.e(true, 50);
                            this.qqz.Bs(1);
                        }
                        et(offsetForPosition, offsetForPosition);
                        e.cap().Q(z3, z2);
                        return true;
                    }
                    d car = e.cap().car();
                    if (e.cap().caw() && car.cao() == 1 && car.dHJ == this.qqW && car.startOffset == offsetForPosition) {
                        z = true;
                    }
                    et(offsetForPosition, offsetForPosition);
                    e cap = e.cap();
                    if (!e.mHasInit) {
                        return true;
                    }
                    cap.cax();
                    cap.cav();
                    cap.f(true, 50);
                    cap.ky(true);
                    cap.kx(z);
                    return true;
                case 3:
                    cah();
                    cag();
                    return true;
                default:
                    return true;
            }
        }
        if (motionEvent.getAction() == 1 && this.qqz != null) {
            this.qqz.e(true, 300);
            this.qqz.Bs(1);
        }
        return super.onTouchEvent(motionEvent);
    }

    private void cag() {
        if (this.eOf == null) {
            this.eOf = new al(new 3(this), false);
        } else {
            this.eOf.SO();
        }
    }

    public final void ae(int i, boolean z) {
        Editable text = getText();
        if (text != null) {
            Layout layout = getLayout();
            if (layout != null) {
                int length = text.length();
                if (i >= 0 && i <= length) {
                    int i2;
                    int i3;
                    if (length == 0) {
                        i2 = 0;
                        i3 = 0;
                    } else {
                        if (i < length) {
                            if (z || text.charAt(i) != 10) {
                                i2 = layout.getOffsetToRightOf(i);
                                i3 = i;
                            }
                        } else if (i == length && z) {
                            i3 = layout.getOffsetToLeftOf(i);
                            i2 = i;
                        }
                        i2 = i;
                        i3 = i;
                    }
                    if (i3 >= 0 && i3 <= length && i2 >= 0 && i2 <= length) {
                        if (e.cap().isEditable()) {
                            requestFocus();
                            setIgnoreSelectChangeByMultiSelect(true);
                            setSelection(i3, i2);
                            setIgnoreSelectChangeByMultiSelect(false);
                            if (this.qqz != null) {
                                this.qqz.e(true, 50);
                                this.qqz.Bs(1);
                            }
                        }
                        et(i3, i2);
                        e.cap().Q(true, true);
                    }
                }
            }
        }
    }

    private void cah() {
        if (this.qqY == null) {
            this.qqY = new b();
        } else {
            this.qqY.reset();
        }
    }

    private void et(int i, int i2) {
        if (this.qqJ == 2) {
            e.cap().w(this.qqW, 1, this.qqW, 1);
        } else if (this.qqJ == 1) {
            e.cap().w(this.qqW, 0, this.qqW, 0);
        } else {
            e.cap().w(this.qqW, i, this.qqW, i2);
        }
    }

    public int getPosInDataList() {
        return this.qqW;
    }

    public void setPosInDataList(int i) {
        this.qqW = i;
    }

    public void setIgnoreSelectChangeByMultiSelect(boolean z) {
        this.qqZ = z;
    }
}
