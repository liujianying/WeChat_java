package com.tencent.mm.kiss.widget.textview;

import android.annotation.TargetApi;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.InputFilter.LengthFilter;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.text.style.MetricAffectingSpan;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    private static e dtO = new e();
    private static final SpannableString dtP = new SpannableString("");
    CharSequence dtQ = null;
    CharSequence dtR = null;
    int dtS = 0;
    int dtT = 0;
    TextPaint dtU = null;
    Alignment dtV = Alignment.ALIGN_NORMAL;
    TruncateAt dtW = null;
    int dtX = -1;
    TextDirectionHeuristic dtY = null;
    float dtZ = 0.0f;
    float dua = 1.0f;
    boolean dub = false;
    LengthFilter duc = null;
    int gravity = 51;
    int maxLength = -1;
    int maxLines = Integer.MAX_VALUE;
    int width = 0;

    public static d a(CharSequence charSequence, int i, a aVar) {
        boolean z = false;
        if (charSequence == null) {
            charSequence = "";
        }
        int length = charSequence.length();
        if (charSequence == null) {
            charSequence = "";
        }
        d Fb = dtO.Fb();
        if (Fb == null) {
            Fb = new d();
        }
        Fb.dtQ = charSequence.toString();
        Fb.dtR = charSequence;
        Fb.dtS = 0;
        Fb.dtT = length;
        Fb.width = i;
        Fb.dtU = new TextPaint();
        if (aVar.maxLines != -1) {
            length = aVar.maxLines;
            if (length >= 0) {
                Fb.maxLines = length;
            }
        }
        if (aVar.maxLength != -1) {
            length = aVar.maxLength;
            if (length >= 0) {
                Fb.maxLength = length;
                Fb.duc = new LengthFilter(Fb.maxLength);
            }
        }
        Alignment alignment = aVar.dtV;
        if (alignment != null) {
            Fb.dtV = alignment;
        }
        if (aVar.dtW != null) {
            TruncateAt truncateAt = aVar.dtW;
            if (truncateAt != null) {
                Fb.dtW = truncateAt;
            }
        }
        Fb.gravity = aVar.gravity;
        if (aVar.duy != -1) {
            length = aVar.duy;
            if (length >= 0) {
                Fb.dtX = length;
            }
        }
        if (aVar.dtY != null) {
            TextDirectionHeuristic textDirectionHeuristic = aVar.dtY;
            if (VERSION.SDK_INT >= 18) {
                Fb.dtY = textDirectionHeuristic;
            }
        }
        float f = aVar.dtZ;
        float f2 = aVar.dua;
        Fb.dtZ = f;
        Fb.dua = f2;
        Fb.dub = aVar.dub;
        if (aVar.boi != null) {
            if (aVar.fontStyle != -1) {
                Typeface typeface = aVar.boi;
                int i2 = aVar.fontStyle;
                if (i2 > 0) {
                    typeface = typeface == null ? Typeface.defaultFromStyle(i2) : Typeface.create(typeface, i2);
                    Fb.b(typeface);
                    length = ((typeface != null ? typeface.getStyle() : 0) ^ -1) & i2;
                    TextPaint textPaint = Fb.dtU;
                    if ((length & 1) != 0) {
                        z = true;
                    }
                    textPaint.setFakeBoldText(z);
                    Fb.dtU.setTextSkewX((length & 2) != 0 ? -0.25f : 0.0f);
                } else {
                    Fb.dtU.setFakeBoldText(false);
                    Fb.dtU.setTextSkewX(0.0f);
                    Fb.b(typeface);
                }
            } else {
                Fb.b(aVar.boi);
            }
        }
        if (aVar.duz != -1.0f) {
            Fb.dtU.setTextSize(aVar.duz);
        }
        if (aVar.textColor != -1) {
            Fb.dtU.setColor(aVar.textColor);
        }
        if (aVar.linkColor != -1) {
            Fb.dtU.linkColor = aVar.linkColor;
        }
        if (aVar.dug != null) {
            Fb.dtU = aVar.dug;
        }
        return Fb;
    }

    private d b(Typeface typeface) {
        this.dtU.setTypeface(typeface);
        return this;
    }

    @TargetApi(18)
    public final f Fa() {
        int i;
        boolean z;
        StaticLayout a;
        if (this.dtW == null || this.dtX <= 0) {
            i = this.width;
        } else {
            i = this.dtX;
        }
        if (this.dtW == null && this.maxLines == 1) {
            this.dtW = TruncateAt.END;
        }
        if (this.maxLength > 0 && this.duc != null) {
            CharSequence filter = this.duc.filter(this.dtR, 0, this.dtR.length(), dtP, 0, 0);
            if (filter != null) {
                this.dtR = filter;
                if (this.dtT > this.dtR.length()) {
                    this.dtT = this.dtR.length();
                }
            }
        }
        if (h.DEBUG) {
            x.i("StaticTextView.StaticLayoutBuilder", "StaticLayoutWrapper build " + this.dtR + " " + this.width);
        }
        if (this.dtV == Alignment.ALIGN_NORMAL) {
            switch (this.gravity & 8388615) {
                case 1:
                    this.dtV = Alignment.ALIGN_CENTER;
                    break;
                case 3:
                case 8388611:
                    this.dtV = Alignment.ALIGN_NORMAL;
                    break;
                case 5:
                case 8388613:
                    this.dtV = Alignment.ALIGN_OPPOSITE;
                    break;
                default:
                    this.dtV = Alignment.ALIGN_NORMAL;
                    break;
            }
        }
        this.dtU.setAntiAlias(true);
        StaticLayout staticLayout = null;
        if ((this.dtY == null || (com.tencent.mm.compatible.util.d.fR(18) && this.dtY == TextDirectionHeuristics.FIRSTSTRONG_LTR)) && (this.maxLines == Integer.MAX_VALUE || this.maxLines == -1)) {
            z = true;
        } else {
            z = false;
        }
        try {
            a = a(this.dtR, z, i);
        } catch (Exception e) {
            x.i("StaticTextView.StaticLayoutBuilder", "build static layout error: %s", e.getMessage());
            int i2 = 0;
            while (i2 < 3) {
                try {
                    CharSequence spannableStringBuilder = new SpannableStringBuilder(this.dtR);
                    MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), MetricAffectingSpan.class);
                    if (metricAffectingSpanArr == null || metricAffectingSpanArr.length <= 0) {
                        i2 = 100;
                    } else {
                        spannableStringBuilder.insert(spannableStringBuilder.getSpanStart(metricAffectingSpanArr[0]) - 1, " ");
                        i2++;
                    }
                    this.dtR = spannableStringBuilder;
                    staticLayout = a(this.dtR, z, i);
                    x.i("StaticTextView.StaticLayoutBuilder", "fix from build static layout, fixCount: %s", Integer.valueOf(i2));
                    a = staticLayout;
                } catch (Exception e2) {
                    x.i("StaticTextView.StaticLayoutBuilder", "fix, build static layout error: %s, fixCount: %s", e2.getMessage(), Integer.valueOf(i2));
                }
            }
            a = staticLayout;
        }
        if (a == null) {
            this.dtR = this.dtR.toString();
            a = a(this.dtR, z, i);
        }
        f fVar = new f(a);
        fVar.duf = this.dtQ;
        fVar.text = this.dtR;
        fVar.maxLength = this.maxLength;
        fVar.maxLines = this.maxLines;
        fVar.dtV = this.dtV;
        fVar.dtW = this.dtW;
        fVar.dug = this.dtU;
        fVar.gravity = this.gravity;
        dtO.a(this);
        return fVar;
    }

    private StaticLayout a(CharSequence charSequence, boolean z, int i) {
        if (z) {
            return new StaticLayout(charSequence, this.dtS, this.dtT, this.dtU, this.width, this.dtV, this.dua, this.dtZ, this.dub, this.dtW, i);
        } else if (VERSION.SDK_INT >= 18) {
            if (this.dtY == null) {
                this.dtY = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }
            return com.tencent.mm.kiss.widget.textview.b.a.a(charSequence, this.dtS, this.dtT, this.dtU, this.width, this.dtV, this.dtY, this.dua, this.dtZ, this.dub, this.dtW, i, this.maxLines);
        } else {
            return com.tencent.mm.kiss.widget.textview.b.a.a(charSequence, this.dtS, this.dtT, this.dtU, this.width, this.dtV, this.dua, this.dtZ, this.dub, this.dtW, i, this.maxLines);
        }
    }
}
