package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.kiss.widget.textview.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class g {
    protected f duj;
    public a duk;
    protected StaticLayout dul;
    protected boolean dum = false;
    int dun;
    int duo;
    private boolean dup = false;
    boolean duq = false;
    boolean dur = false;
    private boolean dus = false;
    private View dut;
    private int duu = 0;
    private int duv = 0;
    protected CharSequence text = null;

    public g(View view, a aVar) {
        this.dut = view;
        this.duk = aVar;
    }

    public final void init() {
        this.text = "";
        this.dut.setWillNotDraw(false);
    }

    public final void setSingleLine(boolean z) {
        int i;
        if (z) {
            i = 1;
        } else {
            i = Integer.MAX_VALUE;
        }
        if (this.duk.maxLines != i) {
            this.duk.maxLines = i;
            this.dum = true;
            Fd();
            this.dut.requestLayout();
            this.dut.invalidate();
        }
    }

    public final void setLines(int i) {
        if (this.duk.maxLines != i || this.duk.minLines != i) {
            this.dum = true;
            Fd();
            this.duk.maxLines = i;
            this.duk.minLines = i;
            this.dut.requestLayout();
            this.dut.invalidate();
            if (h.DEBUG) {
                x.i("MicroMsg.StaticTextViewHolder", "setLines isNeedRecreateLayout");
            }
        }
    }

    public final void setTextSize(int i, float f) {
        Resources system;
        Context context = ad.getContext();
        if (context == null) {
            system = Resources.getSystem();
        } else {
            system = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(i, f, system.getDisplayMetrics());
        if (applyDimension != 0.0f && this.duk != null && applyDimension != this.duk.duz) {
            this.duk.duz = applyDimension;
            this.dum = true;
            if (h.DEBUG) {
                x.i("MicroMsg.StaticTextViewHolder", "setRawTextSize isNeedRecreateLayout");
            }
        }
    }

    public final void setTextLayout(f fVar) {
        if (fVar == null || fVar.duh == null) {
            this.duj = null;
            return;
        }
        if (this.duk == null) {
            b bVar = new b();
            bVar.duk = new a();
            bVar.duk.maxLines = fVar.maxLines;
            bVar.duk.maxLength = fVar.maxLength;
            bVar.duk.dug = fVar.dug;
            bVar.duk.dtV = fVar.dtV;
            bVar.duk.dtW = fVar.dtW;
            bVar.duk.gravity = fVar.gravity;
            bVar.duk.duz = fVar.dug.getTextSize();
            bVar.duk.textColor = fVar.dug.getColor();
            this.duk = bVar.duk;
        }
        Fd();
        this.dut.setWillNotDraw(false);
        this.duj = fVar;
        this.dul = fVar.duh;
        this.text = fVar.text;
        this.dup = this.text instanceof Spannable;
        if (this.dup) {
            this.text = this.duj.text;
            com.tencent.mm.kiss.widget.textview.b.b.Fg();
            com.tencent.mm.kiss.widget.textview.b.b.a((Spannable) this.text);
        }
        this.dut.requestLayout();
        this.dut.invalidate();
    }

    public final void setTextColor(int i) {
        if (this.duk != null && i != this.duk.textColor) {
            this.duk.textColor = i;
            this.dum = true;
            if (h.DEBUG) {
                x.i("MicroMsg.StaticTextViewHolder", "setTextColor isNeedRecreateLayout");
            }
        }
    }

    public final void setGravity(int i) {
        if (this.duk != null && i != this.duk.gravity) {
            this.duk.gravity = i;
            this.dum = true;
            if (h.DEBUG) {
                x.i("MicroMsg.StaticTextViewHolder", "setGravity isNeedRecreateLayout");
            }
        }
    }

    public final void setMaxLines(int i) {
        if (this.duk != null && i != this.duk.maxLines) {
            this.duk.maxLines = i;
            this.dum = true;
            Fd();
            if (h.DEBUG) {
                x.i("MicroMsg.StaticTextViewHolder", "setMaxLines isNeedRecreateLayout");
            }
            this.dut.requestLayout();
            this.dut.invalidate();
        }
    }

    public final int getMaxLines() {
        if (this.duk != null) {
            return this.duk.maxLines;
        }
        return -1;
    }

    public final void setMinLines(int i) {
        if (this.duk.minLines != i) {
            this.duk.minLines = i;
            Fd();
            this.dut.requestLayout();
            this.dut.invalidate();
        }
    }

    public final int getLineHeight() {
        TextPaint paint = this.duj.duh.getPaint();
        if (paint == null) {
            paint = this.duk.dug;
        }
        return Math.round((((float) paint.getFontMetricsInt(null)) * this.duk.dua) + this.duk.dtZ);
    }

    public final void setText(CharSequence charSequence, boolean z) {
        if (charSequence != null) {
            if (this.text == null || !this.text.equals(charSequence) || z) {
                this.text = charSequence;
                this.dum = true;
                this.dut.requestLayout();
                this.dut.invalidate();
                if (h.DEBUG) {
                    x.i("MicroMsg.StaticTextViewHolder", "setText isNeedRecreateLayout " + charSequence + " hashcode " + hashCode() + " " + bi.cjd().toString());
                }
            }
        }
    }

    final void Fd() {
        this.duv = 0;
        this.duu = 0;
        this.dun = 0;
        this.duo = 0;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final float getTextSize() {
        if (this.duj != null) {
            return this.duj.dug.getTextSize();
        }
        if (this.duk != null) {
            return this.duk.duz;
        }
        return 0.0f;
    }

    public final int getTextColor() {
        if (this.duj != null) {
            return this.duj.dug.getColor();
        }
        if (this.duk != null) {
            return this.duk.textColor;
        }
        return 0;
    }

    public final Layout getTvLayout() {
        return this.dul;
    }

    public final f getLayoutWrapper() {
        return this.duj;
    }

    public final int getLineCount() {
        if (this.dul == null) {
            return 0;
        }
        return this.dul.getLineCount();
    }

    public final int getSelectionStart() {
        if (this.text == null) {
            return -1;
        }
        return Selection.getSelectionStart(this.text);
    }

    public final int getSelectionEnd() {
        if (this.text == null) {
            return -1;
        }
        return Selection.getSelectionEnd(this.text);
    }

    public final boolean v(MotionEvent motionEvent) {
        boolean z = motionEvent.getAction() == 1 || motionEvent.getAction() == 3;
        if (!this.dut.isEnabled() || !this.dup) {
            return false;
        }
        com.tencent.mm.kiss.widget.textview.b.b.Fg();
        boolean a = com.tencent.mm.kiss.widget.textview.b.b.a(this.dut, this.dul, (Spannable) this.text, motionEvent);
        this.dus = a;
        if (this.dur && z) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            boolean z2 = (x < ((float) this.dun) || x > ((float) (this.dul.getWidth() + this.dun))) ? false : y >= ((float) this.duo) && y <= ((float) (this.dul.getHeight() + this.duo));
            if (z2) {
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spannable) this.text).getSpans(getSelectionStart(), getSelectionEnd(), ClickableSpan.class);
                if (clickableSpanArr.length > 0) {
                    x.d("MicroMsg.StaticTextViewHolder", "perform clickable span click");
                    clickableSpanArr[0].onClick(this.dut);
                    return true;
                }
            }
        }
        return a;
    }

    public final boolean performClick() {
        if (this.dus || !this.duq) {
            return false;
        }
        return true;
    }

    protected final void onDraw(Canvas canvas) {
        if (this.dul == null || this.duj == null) {
            boolean gL = gL(this.dut.getMeasuredWidth());
            if (h.DEBUG) {
                x.d("MicroMsg.StaticTextViewHolder", "onDraw, textLayout==null:%b, layoutWrapper==null:%b recreate:%b", this.dul, this.duj, Boolean.valueOf(gL));
            }
            if (gL) {
                this.dut.requestLayout();
                this.dut.invalidate();
                return;
            }
            return;
        }
        long j = 0;
        if (h.DEBUG) {
            j = System.nanoTime();
        }
        canvas.save();
        canvas.clipRect(this.dut.getPaddingLeft(), this.dut.getPaddingTop(), (this.dut.getRight() - this.dut.getLeft()) - this.dut.getPaddingRight(), (this.dut.getBottom() - this.dut.getTop()) - this.dut.getPaddingBottom());
        if (this.dun == 0 || this.duo == 0) {
            int paddingLeft = this.dut.getPaddingLeft();
            int right = ((this.dut.getRight() - this.dut.getLeft()) - this.dut.getPaddingLeft()) - this.dut.getPaddingRight();
            int width = this.dul.getWidth();
            if (width > right) {
                right = paddingLeft;
            } else {
                switch (this.duj.gravity & 8388615) {
                    case 1:
                    case 17:
                        right = (right / 2) - (width / 2);
                        break;
                    case 3:
                    case 8388611:
                        right = 0;
                        break;
                    case 5:
                    case 8388613:
                        right -= width;
                        break;
                    default:
                        right = 0;
                        break;
                }
                right += paddingLeft;
            }
            this.dun = right;
            paddingLeft = this.dut.getPaddingTop();
            width = ((this.dut.getBottom() - this.dut.getTop()) - this.dut.getPaddingTop()) - this.dut.getPaddingBottom();
            right = 0;
            int height = this.dul.getHeight();
            if (height > width) {
                right = paddingLeft;
            } else {
                switch (this.duj.gravity & 112) {
                    case 16:
                        right = (width / 2) - (height / 2);
                        break;
                    case 48:
                        right = 0;
                        break;
                    case 80:
                        right = width - height;
                        break;
                }
                right += paddingLeft;
            }
            this.duo = right;
        }
        canvas.translate((float) this.dun, (float) this.duo);
        this.dul.draw(canvas, null, null, 0);
        canvas.restore();
        if (h.DEBUG) {
            x.d("MicroMsg.StaticTextViewHolder", "onDraw used: %fms, hashCode: %d, text: %s clipLeft:%d clipTop:%d clipRight:%d clipBottom:%d", Double.valueOf(((double) (System.nanoTime() - j)) / 1000000.0d), Integer.valueOf(hashCode()), this.text, Integer.valueOf(r4), Integer.valueOf(r5), Integer.valueOf(r6), Integer.valueOf(r7));
        }
    }

    private boolean gL(int i) {
        if (this.dum || this.duj == null || this.dul == null) {
            if (this.duk == null) {
                return false;
            }
            if (i > 0) {
                Fd();
                long j = 0;
                if (h.DEBUG) {
                    j = System.nanoTime();
                }
                this.duj = d.a(this.text, i, this.duk).Fa();
                this.dul = this.duj.duh;
                this.dum = false;
                if (h.DEBUG) {
                    long nanoTime = System.nanoTime();
                    x.d("MicroMsg.StaticTextViewHolder", "recreateLayoutIfNeed, width: %d, hasCode: %d, used: %fms, text: %s", Integer.valueOf(i), Integer.valueOf(hashCode()), Double.valueOf(((double) (nanoTime - j)) / 1000000.0d), this.text);
                }
                return true;
            }
        }
        return false;
    }

    public final Point aX(int i, int i2) {
        Point point;
        long j = 0;
        if (h.DEBUG) {
            j = System.nanoTime();
        }
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        gL(size);
        if (this.dul != null) {
            int i3;
            int i4;
            if (mode != 1073741824) {
                i3 = 0;
                if (this.duk.dtW == null) {
                    Layout layout = this.dul;
                    if (this.duu != 0) {
                        i3 = this.duu;
                    } else {
                        int lineCount = layout.getLineCount();
                        CharSequence text = layout.getText();
                        float f = 0.0f;
                        for (i4 = 0; i4 < lineCount - 1; i4++) {
                            if (text.charAt(layout.getLineEnd(i4) - 1) != 10) {
                                i3 = -1;
                                break;
                            }
                        }
                        for (i4 = 0; i4 < lineCount; i4++) {
                            f = Math.max(f, layout.getLineWidth(i4));
                        }
                        this.duu = (int) Math.ceil((double) f);
                        this.duu += this.dut.getPaddingLeft() + this.dut.getPaddingRight();
                        i3 = this.duu;
                    }
                }
                i4 = (int) Math.ceil((double) Layout.getDesiredWidth(this.dul.getText(), this.dul.getPaint()));
                if (i4 > i3) {
                    i3 = i4;
                }
                if (h.DEBUG) {
                    x.d("MicroMsg.StaticTextViewHolder", "onMeasure  hashCode: %d, des: %d newdes: %d", Integer.valueOf(hashCode()), Integer.valueOf(i3), Integer.valueOf(i4));
                }
                if (mode == Integer.MIN_VALUE) {
                    size = Math.min(size, i3);
                } else {
                    size = i3;
                }
            }
            if (mode2 == 1073741824) {
                i3 = size2;
            } else {
                Layout layout2 = this.dul;
                if (this.duv != 0) {
                    i3 = this.duv;
                } else {
                    i3 = layout2.getLineCount();
                    if (this.duj.maxLines > 0 && this.duj.maxLines < i3) {
                        i3 = this.duj.maxLines;
                    }
                    mode = this.dut.getPaddingTop() + this.dut.getPaddingBottom();
                    i4 = layout2.getLineTop(i3);
                    if (this.duk.minLines <= 0 || i3 >= this.duk.minLines) {
                        i3 = i4;
                    } else {
                        i3 = ((this.duk.minLines - i3) * getLineHeight()) + i4;
                    }
                    this.duv = i3 + mode;
                    i3 = this.duv;
                }
                if (mode2 == Integer.MIN_VALUE) {
                    i3 = Math.min(i3, size2);
                }
            }
            point = new Point(size, i3);
        } else {
            point = null;
        }
        if (h.DEBUG) {
            String str = "MicroMsg.StaticTextViewHolder";
            String str2 = "onMeasure used: %fms, hashCode: %d, text: %s result: %s";
            Object[] objArr = new Object[4];
            objArr[0] = Double.valueOf(((double) (System.nanoTime() - j)) / 1000000.0d);
            objArr[1] = Integer.valueOf(hashCode());
            objArr[2] = this.text;
            objArr[3] = point == null ? "" : point.toString();
            x.d(str, str2, objArr);
        }
        return point;
    }
}
