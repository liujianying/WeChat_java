package com.tencent.neattextview.textview.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;
import android.util.LruCache;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.neattextview.textview.layout.NeatLayout;

public class NeatTextView extends View implements a {
    private static final LruCache<String, Boolean> vbe = new LruCache(500);
    private static final LruCache<a, com.tencent.neattextview.textview.layout.b> vbf = new LruCache(500);
    private static final HandlerThread vbg;
    private static Handler vbh;
    private int HB = 0;
    private ColorStateList bv;
    private TextPaint dG;
    private int gg = Integer.MAX_VALUE;
    private CharSequence iq;
    private int kgE = Integer.MAX_VALUE;
    public CharSequence mText;
    private int qMj = Integer.MAX_VALUE;
    private int tzM;
    private Factory tzO = Factory.getInstance();
    private TruncateAt tzP;
    private float tzV = 0.0f;
    private com.tencent.neattextview.textview.layout.b vaO;
    private boolean vbi = false;
    public boolean vbj;
    private TextView vbk;
    private ColorStateList vbl;
    private ColorStateList vbm;
    private int vbn;
    private int vbo = 0;
    private BufferType vbp = BufferType.NORMAL;
    private b vbq;
    private boolean vbr = true;
    private b vbs;
    private int vbt = 8388659;
    private boolean vbu = true;
    private d vbv;

    private static class a {
        float duz;
        float fontScale;
        int orientation;
        CharSequence text;
        int vbw = 1;
        FontMetricsInt vbx;
        int[] vby;

        a(CharSequence charSequence, int[] iArr, float f, FontMetricsInt fontMetricsInt, float f2, int i) {
            int i2 = 0;
            this.vby = iArr;
            this.text = TextUtils.isEmpty(charSequence) ? "" : charSequence;
            this.duz = f;
            this.vbx = fontMetricsInt;
            this.fontScale = f2;
            this.orientation = i;
            if (charSequence instanceof Spannable) {
                CharacterStyle[] characterStyleArr = (CharacterStyle[]) ((Spannable) charSequence).getSpans(0, charSequence.length(), CharacterStyle.class);
                int length = characterStyleArr.length;
                while (i2 < length) {
                    this.vbw = characterStyleArr[i2].hashCode() + this.vbw;
                    i2++;
                }
            }
        }

        public final int hashCode() {
            return (int) (((((float) (this.vbw + this.text.hashCode())) + ((this.duz * this.fontScale) * ((float) this.orientation))) + ((float) this.vby[0])) + ((float) this.vby[1]));
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.duz == aVar.duz && this.fontScale == aVar.fontScale && this.vby[0] == aVar.vby[0] && this.vby[1] == aVar.vby[1] && this.vbx.descent == aVar.vbx.descent && this.vbx.top == aVar.vbx.top && this.vbx.bottom == aVar.vbx.bottom && this.vbx.ascent == aVar.vbx.ascent && this.vbx.leading == aVar.vbx.leading && this.text.equals(aVar.text)) {
                return true;
            }
            return false;
        }
    }

    public interface b {
        boolean dK(View view);
    }

    public interface c extends OnTouchListener {
    }

    static final class d implements Runnable {
        volatile boolean dDR = false;
        TextPaint dtU = new TextPaint();
        String text;
        float[] vbz;

        d(String str, TextPaint textPaint) {
            this.dtU.set(textPaint);
            this.text = str;
        }

        public final float[] d(Paint paint) {
            if (paint.getTextSize() == this.dtU.getTextSize() && this.dDR) {
                return this.vbz;
            }
            return null;
        }

        public final void run() {
            this.vbz = new float[this.text.length()];
            this.dtU.getTextWidths(this.text, this.vbz);
            this.dDR = true;
        }
    }

    static {
        HandlerThread handlerThread = new HandlerThread("PreMeasuredThread", -8);
        vbg = handlerThread;
        handlerThread.start();
        Looper looper = vbg.getLooper();
        if (looper != null) {
            vbh = new Handler(looper);
        }
    }

    public NeatTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public NeatTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet, i);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        this.vbq = new b(getContext(), this);
        TextView textView = new TextView(context);
        textView.setClickable(true);
        textView.setFocusable(true);
        this.vbk = textView;
        this.dG = getWrappedTextView().getPaint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.neattextview.textview.a.a.NeatTextView, i, 0);
        int i2 = 15;
        int i3 = -16777216;
        int i4 = -7829368;
        int i5 = -16776961;
        int i6 = -1;
        CharSequence charSequence = null;
        try {
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = obtainStyledAttributes.getIndex(i7);
                if (index == com.tencent.neattextview.textview.a.a.NeatTextView_android_textSize) {
                    i2 = obtainStyledAttributes.getDimensionPixelSize(index, 15);
                } else if (index == com.tencent.neattextview.textview.a.a.NeatTextView_android_textColor) {
                    i3 = obtainStyledAttributes.getColor(index, -16777216);
                } else if (index == com.tencent.neattextview.textview.a.a.NeatTextView_android_singleLine) {
                    if (obtainStyledAttributes.getBoolean(index, false)) {
                        index = 1;
                    } else {
                        index = -1;
                    }
                    setMaxLines(index);
                } else if (index == com.tencent.neattextview.textview.a.a.NeatTextView_android_lines) {
                    setLines(obtainStyledAttributes.getInt(index, -1));
                } else if (index == com.tencent.neattextview.textview.a.a.NeatTextView_android_gravity) {
                    setTextGravity(obtainStyledAttributes.getInt(index, 16));
                } else if (index == com.tencent.neattextview.textview.a.a.NeatTextView_android_maxWidth) {
                    setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(index, -1));
                } else if (index == com.tencent.neattextview.textview.a.a.NeatTextView_android_lineSpacingExtra) {
                    setSpacingAdd(obtainStyledAttributes.getDimensionPixelSize(index, (int) this.tzV));
                } else if (index == com.tencent.neattextview.textview.a.a.NeatTextView_android_minWidth) {
                    setMinWidth(obtainStyledAttributes.getDimensionPixelSize(index, -1));
                } else if (index == com.tencent.neattextview.textview.a.a.NeatTextView_android_minHeight) {
                    setMinHeight(obtainStyledAttributes.getDimensionPixelSize(index, -1));
                } else if (index == com.tencent.neattextview.textview.a.a.NeatTextView_android_maxHeight) {
                    setMaxHeight(obtainStyledAttributes.getDimensionPixelSize(index, -1));
                } else if (index == com.tencent.neattextview.textview.a.a.NeatTextView_android_maxLines) {
                    setMaxLines(obtainStyledAttributes.getInt(index, -1));
                } else if (index == com.tencent.neattextview.textview.a.a.NeatTextView_android_text) {
                    charSequence = obtainStyledAttributes.getString(index);
                } else if (index == com.tencent.neattextview.textview.a.a.NeatTextView_android_width) {
                    setWidth(obtainStyledAttributes.getDimensionPixelSize(index, -1));
                } else if (index == com.tencent.neattextview.textview.a.a.NeatTextView_android_height) {
                    setHeight(obtainStyledAttributes.getDimensionPixelSize(index, -1));
                } else if (index == com.tencent.neattextview.textview.a.a.NeatTextView_android_hint) {
                    setHint(obtainStyledAttributes.getText(index));
                } else if (index == com.tencent.neattextview.textview.a.a.NeatTextView_android_textColorHint) {
                    i4 = obtainStyledAttributes.getColor(index, -7829368);
                } else if (index == com.tencent.neattextview.textview.a.a.NeatTextView_android_textColorLink) {
                    i5 = obtainStyledAttributes.getColor(index, -16776961);
                } else if (index == com.tencent.neattextview.textview.a.a.NeatTextView_android_ellipsize) {
                    i6 = obtainStyledAttributes.getInt(index, i6);
                } else if (index == com.tencent.neattextview.textview.a.a.NeatTextView_smartLetter) {
                    this.vbu = obtainStyledAttributes.getBoolean(index, true);
                }
            }
            setTextColor(i3);
            setRawTextSize((float) i2);
            setLinkTextColor(i5);
            setHintTextColor(i4);
            switch (i6) {
                case 1:
                    setEllipsize(TruncateAt.START);
                    break;
                case 2:
                    setEllipsize(TruncateAt.MIDDLE);
                    break;
                case 3:
                    setEllipsize(TruncateAt.END);
                    break;
            }
            if (!TextUtils.isEmpty(charSequence)) {
                Q(charSequence);
            }
            getWrappedTextView().setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public com.tencent.neattextview.textview.layout.b getLayout() {
        return this.vaO;
    }

    public b getOnDoubleClickListener() {
        return this.vbs;
    }

    public void setOnDoubleClickListener(b bVar) {
        this.vbs = bVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.vbq == null || !this.vbq.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void onMeasure(int i, int i2) {
        if (TextUtils.isEmpty(this.mText) && TextUtils.isEmpty(this.iq)) {
            super.onMeasure(i, i2);
        } else if (this.vbj) {
            getWrappedTextView().measure(i, i2);
            setMeasuredDimension(getWrappedTextView().getMeasuredWidth(), getWrappedTextView().getMeasuredHeight());
        } else {
            int i3;
            int i4;
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i);
            int size2 = MeasureSpec.getSize(i2);
            if (size <= 0 && mode2 == 0) {
                size = getResources().getDisplayMetrics().widthPixels;
            }
            if (size2 <= 0 && mode2 == 0) {
                size2 = Integer.MAX_VALUE;
            }
            if (this.gg <= 0 || this.gg >= size) {
                i3 = size;
            } else {
                i3 = this.gg;
            }
            if (this.qMj <= 0 || this.qMj >= size2) {
                i4 = size2;
            } else {
                i4 = this.qMj;
            }
            size2 = (i3 - getPaddingLeft()) - getPaddingRight();
            size = (i4 - getPaddingTop()) - getPaddingBottom();
            a aVar = new a(this.mText, new int[]{size2, size}, getTextSize(), getPaint().getFontMetricsInt(), getResources().getConfiguration().fontScale, getResources().getConfiguration().orientation);
            if (this.vbi) {
                this.vaO = null;
                this.vbi = false;
            } else {
                this.vaO = (com.tencent.neattextview.textview.layout.b) vbf.get(aVar);
            }
            if (this.vaO == null) {
                if (!TextUtils.isEmpty(this.mText) || TextUtils.isEmpty(this.iq)) {
                    this.vaO = new NeatLayout(this.mText, this.vbv == null ? null : this.vbv.d(this.dG));
                } else {
                    this.vaO = new NeatLayout(this.iq, this.vbv == null ? null : this.vbv.d(this.dG));
                }
                this.vaO.a(getPaint(), (float) aVar.vby[0], (float) aVar.vby[1], (float) getPaddingLeft(), (float) getPaddingTop(), this.tzV, this.kgE, this.tzP, this.vbu);
                vbf.put(aVar, this.vaO);
            }
            float[] cEh = this.vaO.cEh();
            if (mode != 1073741824) {
                i3 = (int) Math.min((cEh[0] + ((float) getPaddingLeft())) + ((float) getPaddingRight()), (float) this.gg);
            }
            if (mode2 != 1073741824) {
                i4 = (int) Math.min((cEh[1] + ((float) getPaddingTop())) + ((float) getPaddingBottom()), (float) this.qMj);
            }
            setMeasuredDimension(Math.max(i3, this.HB), Math.max(i4, this.vbo));
        }
    }

    public final com.tencent.neattextview.textview.layout.b Hg(int i) {
        if (TextUtils.isEmpty(this.mText)) {
            return null;
        }
        com.tencent.neattextview.textview.layout.b neatLayout = new NeatLayout(this.mText, null);
        neatLayout.a(getPaint(), (float) i, 2.14748365E9f, (float) getPaddingLeft(), (float) getPaddingTop(), this.tzV, this.kgE, this.tzP, this.vbu);
        return neatLayout;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.tzM;
        if (!(TextUtils.isEmpty(this.iq) || !TextUtils.isEmpty(this.mText) || this.vbl == null)) {
            i = this.vbn;
        }
        this.dG.setColor(i);
        this.dG.drawableState = getDrawableState();
        if (this.vbj) {
            canvas.save();
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            Layout layout = getWrappedTextView().getLayout();
            if (layout != null) {
                layout.draw(canvas);
            }
            canvas.restore();
        } else if (this.vaO != null) {
            if (this.vaO.cEi() != null) {
                this.vaO.cEi().set(this.dG);
            }
            this.vaO.a(canvas, (float) getPaddingLeft(), getVerticalOffset());
        }
    }

    public TextView getWrappedTextView() {
        return this.vbk;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void Q(java.lang.CharSequence r7) {
        /*
        r6 = this;
        r1 = 1;
        r2 = 0;
        r0 = android.widget.TextView.BufferType.NORMAL;
        r6.vbp = r0;
        if (r7 != 0) goto L_0x000b;
    L_0x0008:
        r7 = "";
    L_0x000b:
        r3 = android.widget.TextView.BufferType.NORMAL;
        if (r0 != r3) goto L_0x0064;
    L_0x000f:
        r7 = android.text.TextUtils.stringOrSpannedString(r7);
    L_0x0013:
        r6.mText = r7;
        r0 = r6.cAs();
        if (r0 == 0) goto L_0x003e;
    L_0x001b:
        r3 = r7.toString();
        r0 = vbe;
        r0 = r0.get(r3);
        r0 = (java.lang.Boolean) r0;
        if (r0 != 0) goto L_0x0071;
    L_0x0029:
        r0 = "^[\\u0001-\\u00b7\\u4E00-\\u9FA5\\ue001-\\ue537\\u2005-\\u2027\\u3001-\\u3011\\uff01-\\uffe5\\u2100-\\u2900[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]]+$";
        r0 = r3.matches(r0);
        if (r0 != 0) goto L_0x006f;
    L_0x0032:
        r0 = r1;
    L_0x0033:
        r4 = vbe;
        r5 = java.lang.Boolean.valueOf(r0);
        r4.put(r3, r5);
    L_0x003c:
        if (r0 == 0) goto L_0x003f;
    L_0x003e:
        r2 = r1;
    L_0x003f:
        r6.vbj = r2;
        r0 = r6.vbj;
        if (r0 == 0) goto L_0x0076;
    L_0x0045:
        r0 = r6.getLayoutParams();
        if (r0 == 0) goto L_0x0056;
    L_0x004b:
        r0 = r6.getWrappedTextView();
        r1 = r6.getLayoutParams();
        r0.setLayoutParams(r1);
    L_0x0056:
        r0 = r6.getWrappedTextView();
        r0.setText(r7);
        r6.requestLayout();
        r6.invalidate();
    L_0x0063:
        return;
    L_0x0064:
        r3 = android.widget.TextView.BufferType.SPANNABLE;
        if (r0 != r3) goto L_0x0013;
    L_0x0068:
        r0 = r6.tzO;
        r7 = r0.newSpannable(r7);
        goto L_0x0013;
    L_0x006f:
        r0 = r2;
        goto L_0x0033;
    L_0x0071:
        r0 = r0.booleanValue();
        goto L_0x003c;
    L_0x0076:
        r6.cEl();
        goto L_0x0063;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.neattextview.textview.view.NeatTextView.Q(java.lang.CharSequence):void");
    }

    public float getVerticalOffset() {
        if ((this.vbt & 112) == 48 || this.vaO == null) {
            return (float) getPaddingTop();
        }
        return (((float) getMeasuredHeight()) - this.vaO.cEh()[1]) / 2.0f;
    }

    public float getHorizontalOffset() {
        if ((this.vbt & 7) == 3 || this.vaO == null) {
            return (float) getPaddingLeft();
        }
        return (((float) getMeasuredHeight()) - this.vaO.cEh()[0]) / 2.0f;
    }

    public void setEllipsize(TruncateAt truncateAt) {
        if (this.tzP != truncateAt) {
            this.tzP = truncateAt;
            if (this.vaO != null) {
                this.vaO = null;
                requestLayout();
                invalidate();
            }
        }
    }

    public int getTextGravity() {
        return this.vbt;
    }

    public void setTextGravity(int i) {
        int i2;
        getWrappedTextView().setGravity(i);
        if ((8388615 & i) == 0) {
            i2 = 8388611 | i;
        } else {
            i2 = i;
        }
        if ((i2 & 112) == 0) {
            i2 |= 48;
        }
        this.vbt = i2;
        if (i2 != this.vbt) {
            invalidate();
        }
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (!(i == getPaddingLeft() && i3 == getPaddingRight() && i2 == getPaddingTop() && i4 == getPaddingBottom())) {
            this.vaO = null;
        }
        super.setPadding(i, i2, i3, i4);
        getWrappedTextView().setPadding(i, i2, i3, i4);
        invalidate();
    }

    public TextPaint getPaint() {
        return this.dG;
    }

    public int getLineCount() {
        return this.vaO != null ? this.vaO.val.size() : 0;
    }

    public CharSequence getHint() {
        return this.iq;
    }

    public final void setHint(int i) {
        setHint(getContext().getResources().getText(i));
    }

    public final void setHint(CharSequence charSequence) {
        this.iq = TextUtils.stringOrSpannedString(charSequence);
        getWrappedTextView().setHint(this.iq);
        if (TextUtils.isEmpty(this.mText)) {
            cEl();
        }
    }

    public boolean cAs() {
        return this.vbr;
    }

    public void setNeatEnable(boolean z) {
        this.vbr = z;
    }

    public void setSmartLetterEnable(boolean z) {
        this.vbu = z;
    }

    public void setWidth(int i) {
        this.vbi = true;
        this.gg = i;
        getWrappedTextView().setMaxWidth(i);
        requestLayout();
        invalidate();
    }

    public void setHeight(int i) {
        this.vbi = true;
        this.qMj = i;
        getWrappedTextView().setMaxHeight(i);
        requestLayout();
        invalidate();
    }

    public void setMinHeight(int i) {
        this.vbi = true;
        this.vbo = i;
        getWrappedTextView().setMinHeight(i);
        requestLayout();
        invalidate();
    }

    public void setMaxHeight(int i) {
        this.vbi = true;
        this.qMj = i;
        getWrappedTextView().setMaxHeight(i);
        requestLayout();
        invalidate();
    }

    public void setMaxWidth(int i) {
        this.vbi = true;
        this.gg = i;
        getWrappedTextView().setMaxWidth(i);
        requestLayout();
        invalidate();
    }

    public void setSpacingAdd(int i) {
        this.vbi = true;
        this.tzV = (float) i;
        getWrappedTextView().setLineSpacing((float) i, 1.0f);
        requestLayout();
        invalidate();
    }

    public void setMinWidth(int i) {
        this.vbi = true;
        this.HB = i;
        getWrappedTextView().setMinWidth(i);
        requestLayout();
        invalidate();
    }

    public void setMaxLines(int i) {
        this.vbi = true;
        this.kgE = i;
        getWrappedTextView().setMaxLines(i);
        requestLayout();
        invalidate();
    }

    public void setLines(int i) {
        this.vbi = true;
        this.kgE = i;
        getWrappedTextView().setLines(i);
        requestLayout();
        invalidate();
    }

    public void setTextColor(int i) {
        this.bv = ColorStateList.valueOf(i);
        getWrappedTextView().setTextColor(i);
        updateTextColors();
    }

    public final void setLinkTextColor(int i) {
        this.vbm = ColorStateList.valueOf(i);
        updateTextColors();
    }

    public final void setHintTextColor(int i) {
        this.vbl = ColorStateList.valueOf(i);
        getWrappedTextView().setHintTextColor(i);
        updateTextColors();
    }

    public final int getCurrentHintTextColor() {
        return this.vbl != null ? this.vbn : this.tzM;
    }

    public final int getCurrentTextColor() {
        return this.tzM;
    }

    private void cEl() {
        this.vaO = null;
        if (vbh != null) {
            Handler handler;
            Runnable dVar;
            if (this.mText == null && this.iq != null) {
                handler = vbh;
                dVar = new d(this.iq.toString(), this.dG);
                this.vbv = dVar;
                handler.post(dVar);
            } else if (this.mText != null) {
                handler = vbh;
                dVar = new d(this.mText.toString(), this.dG);
                this.vbv = dVar;
                handler.post(dVar);
            } else {
                return;
            }
        }
        requestLayout();
        invalidate();
    }

    private void updateTextColors() {
        int colorForState = this.bv.getColorForState(getDrawableState(), 0);
        if (colorForState != this.tzM) {
            this.tzM = colorForState;
            colorForState = 1;
        } else {
            colorForState = 0;
        }
        if (this.vbm != null) {
            int colorForState2 = this.vbm.getColorForState(getDrawableState(), 0);
            if (colorForState2 != this.dG.linkColor) {
                this.dG.linkColor = colorForState2;
                colorForState = 1;
            }
        }
        if (this.vbl != null) {
            int colorForState3 = this.vbl.getColorForState(getDrawableState(), 0);
            if (colorForState3 != this.vbn) {
                this.vbn = colorForState3;
                if (this.mText == null || this.mText.length() == 0) {
                    colorForState = 1;
                }
            }
        }
        if (colorForState != 0) {
            invalidate();
        }
    }

    public float getTextSize() {
        return getPaint().getTextSize();
    }

    public void setTextSize(float f) {
        setTextSize(2, f);
    }

    public final void setTextSize(int i, float f) {
        Resources system;
        Context context = getContext();
        if (context == null) {
            system = Resources.getSystem();
        } else {
            system = context.getResources();
        }
        setRawTextSize(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
    }

    private void setRawTextSize(float f) {
        if (f != this.dG.getTextSize()) {
            this.dG.setTextSize(f);
            if (this.vaO != null) {
                cEl();
                requestLayout();
                invalidate();
            }
        }
    }
}
