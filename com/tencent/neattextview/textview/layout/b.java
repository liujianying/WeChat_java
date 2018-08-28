package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.LineBackgroundSpan;
import android.text.style.RelativeSizeSpan;
import com.tencent.neattextview.textview.b.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class b {
    private static final char[] vac = new char[]{8230};
    private static final String vad = new String(vac);
    protected TextPaint dG;
    protected CharSequence mText;
    private float qta;
    d<LineBackgroundSpan> vaA = new d(LineBackgroundSpan.class);
    private float vaB = 0.0f;
    public LinkedList<c> vaC;
    protected boolean[] vaD;
    protected String vae;
    protected char[] vaf;
    protected float[] vag;
    protected float[] vah;
    protected float[] vai = new float[com.tencent.neattextview.textview.a.a.uZY.length];
    protected float[] vaj = new float[com.tencent.neattextview.textview.a.a.uZZ.length];
    protected HashMap<Character, Float> vak = new HashMap(com.tencent.neattextview.textview.a.a.uZY.length);
    public ArrayList<a> val = new ArrayList();
    public LinkedList<com.tencent.neattextview.textview.b.b> vam = new LinkedList();
    private float van;
    private float vao;
    private float vap;
    private float vaq;
    private int var = 0;
    private TextPaint vas = new TextPaint();
    private float[] vat;
    d<ImageSpan> vau = new d(ImageSpan.class);
    d<AbsoluteSizeSpan> vav = new d(AbsoluteSizeSpan.class);
    d<RelativeSizeSpan> vaw = new d(RelativeSizeSpan.class);
    d<BackgroundColorSpan> vax = new d(BackgroundColorSpan.class);
    d<ForegroundColorSpan> vay = new d(ForegroundColorSpan.class);
    d<ClickableSpan> vaz = new d(ClickableSpan.class);

    /* renamed from: com.tencent.neattextview.textview.layout.b$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] vaE = new int[a.cEk().length];

        static {
            try {
                vaE[a.vaF - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                vaE[a.vaG - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                vaE[a.vaJ - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                vaE[a.vaH - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                vaE[a.vaI - 1] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                vaE[a.vaK - 1] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public enum a {
        ;

        public static int[] cEk() {
            return (int[]) vaL.clone();
        }

        static {
            vaF = 1;
            vaG = 2;
            vaH = 3;
            vaI = 4;
            vaJ = 5;
            vaK = 6;
            vaL = new int[]{vaF, vaG, vaH, vaI, vaJ, vaK};
        }
    }

    protected abstract void a(TextPaint textPaint, float f, int i, boolean z);

    public b(CharSequence charSequence, float[] fArr) {
        this.mText = charSequence;
        this.vae = charSequence.toString();
        this.vaf = this.vae.toCharArray();
        if (fArr != null) {
            this.vag = new float[fArr.length];
            System.arraycopy(fArr, 0, this.vag, 0, fArr.length);
        }
    }

    public final void a(TextPaint textPaint, float f, float f2, float f3, float f4, float f5, int i, TruncateAt truncateAt, boolean z) {
        this.dG = new TextPaint(textPaint);
        this.van = f2;
        this.qta = f;
        this.vao = f3;
        this.vap = f4;
        this.var = i;
        this.vaq = f5;
        this.vat = null;
        int length = this.mText.length();
        if (this.vag == null) {
            this.vag = new float[length];
            textPaint.getTextWidths(this.vae, this.vag);
        }
        this.vaD = new boolean[length];
        a(this.mText, textPaint, this.vaD);
        c(textPaint);
        a(textPaint, f, i, z);
        a(truncateAt, textPaint);
    }

    public final void a(Canvas canvas, float f, float f2) {
        canvas.save();
        canvas.translate(f, f2);
        float f3 = 0.0f;
        Iterator it = this.vam.iterator();
        while (it.hasNext()) {
            ((com.tencent.neattextview.textview.b.b) it.next()).a(canvas, this.dG, this.val);
        }
        it = this.val.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            aVar.a(canvas, this.dG, f3);
            f3 = aVar.getHeight() + f3;
        }
        canvas.restore();
    }

    protected final void a(char[] cArr, int i, int i2, float f, float[] fArr, int i3, float f2, boolean z) {
        FontMetrics fontMetrics = this.dG.getFontMetrics();
        float f3 = fontMetrics.bottom - fontMetrics.top;
        if (this.vah != null) {
            for (int i4 = i; i4 < i2; i4++) {
                if (f3 < this.vah[i4]) {
                    f3 = this.vah[i4];
                }
            }
        }
        float f4 = f3 + this.vaq;
        c cVar = new c(this, cArr, i, i2, this.vaB, fArr, f, f4, f2, this.dG, z, i3);
        this.vaB += f4;
        this.val.add(cVar);
    }

    public final CharSequence getText() {
        return this.mText;
    }

    public int cEg() {
        return this.val.size();
    }

    private void a(CharSequence charSequence, TextPaint textPaint, boolean[] zArr) {
        int length;
        int i;
        int i2;
        int i3;
        Object obj;
        int i4 = 0;
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            length = charSequence.length();
            this.vau.a(spanned, length);
            this.vav.a(spanned, length);
            this.vaw.a(spanned, length);
            this.vay.a(spanned, length);
            this.vax.a(spanned, length);
            this.vaz.a(spanned, length);
            this.vaA.a(spanned, length);
        }
        this.vas.set(textPaint);
        for (length = 0; length < this.vav.vaZ; length++) {
            ((AbsoluteSizeSpan[]) this.vav.vba)[length].updateMeasureState(this.vas);
            i = this.vav.vbb[length];
            i2 = this.vav.vbc[length];
            i3 = i2 - i;
            obj = new float[i3];
            this.vas.getTextWidths(charSequence, i, i2, obj);
            System.arraycopy(obj, 0, this.vag, i, i3);
            if (this.vah == null) {
                this.vah = new float[charSequence.length()];
            }
            this.vah[i] = this.vas.getTextSize();
        }
        for (length = 0; length < this.vaw.vaZ; length++) {
            ((RelativeSizeSpan[]) this.vaw.vba)[length].updateMeasureState(this.vas);
            i = this.vaw.vbb[length];
            i2 = this.vaw.vbc[length];
            i3 = i2 - i;
            obj = new float[i3];
            this.vas.getTextWidths(charSequence, i, i2, obj);
            System.arraycopy(obj, 0, this.vag, i, i3);
            if (this.vah == null) {
                this.vah = new float[charSequence.length()];
            }
            this.vah[i] = this.vas.getTextSize();
        }
        for (length = 0; length < this.vau.vaZ; length++) {
            ImageSpan imageSpan = ((ImageSpan[]) this.vau.vba)[length];
            i2 = this.vau.vbb[length];
            i3 = this.vau.vbc[length] - i2;
            Drawable drawable = imageSpan.getDrawable();
            Rect rect = new Rect();
            if (drawable != null) {
                rect.set(drawable.getBounds());
            }
            this.vag[i2] = (float) rect.width();
            zArr[i2] = true;
            for (i = i2 + 1; i < i2 + i3; i++) {
                this.vag[i] = 0.0f;
                zArr[i] = true;
            }
            if (this.vah == null) {
                this.vah = new float[charSequence.length()];
            }
            this.vah[i2] = (float) rect.height();
        }
        for (length = 0; length < this.vax.vaZ; length++) {
            CharacterStyle characterStyle = ((BackgroundColorSpan[]) this.vax.vba)[length];
            this.vam.add(new com.tencent.neattextview.textview.b.a(this.vax.vbb[length], this.vax.vbc[length], characterStyle));
        }
        while (i4 < this.vaz.vaZ) {
            ClickableSpan clickableSpan = ((ClickableSpan[]) this.vaz.vba)[i4];
            this.vam.add(new c(this.vaz.vbb[i4], this.vaz.vbc[i4], clickableSpan));
            i4++;
        }
    }

    public final float[] cEh() {
        float f = 0.0f;
        if (this.vat == null) {
            float f2;
            Iterator it = this.val.iterator();
            float f3 = 0.0f;
            while (true) {
                f2 = f;
                if (!it.hasNext()) {
                    break;
                }
                a aVar = (a) it.next();
                if (f3 < aVar.getWidth()) {
                    f3 = aVar.getWidth();
                }
                f = aVar.getHeight() + f2;
            }
            this.vat = new float[]{f3, f2};
        }
        return this.vat;
    }

    public final TextPaint cEi() {
        return this.dG;
    }

    private void c(Paint paint) {
        this.vak.clear();
        Rect rect = new Rect();
        int i = 0;
        for (char c : com.tencent.neattextview.textview.a.a.uZY) {
            float measureText = paint.measureText(String.valueOf(c));
            paint.getTextBounds(String.valueOf(c), 0, 1, rect);
            this.vai[i] = measureText - ((float) rect.right);
            i++;
        }
        int i2 = 0;
        for (char valueOf : com.tencent.neattextview.textview.a.a.uZZ) {
            paint.getTextBounds(String.valueOf(valueOf), 0, 1, rect);
            float f = rect.left > 0 ? (float) rect.left : 0.0f;
            this.vaj[i2] = f;
            this.vak.put(Character.valueOf(com.tencent.neattextview.textview.a.a.uZZ[i2]), Float.valueOf(f));
            i2++;
        }
    }

    public final HashMap<Character, Float> cEj() {
        return this.vak;
    }

    private void a(TruncateAt truncateAt, TextPaint textPaint) {
        if (truncateAt != null && truncateAt != TruncateAt.MARQUEE) {
            char c = (this.mText == null || this.val.size() <= 0 || this.mText.length() <= ((a) this.val.get(this.val.size() - 1)).getEnd()) ? 0 : 1;
            if (c != 0) {
                int start;
                float measureText = textPaint.measureText(vad);
                if (this.var == 1 && truncateAt == TruncateAt.MIDDLE) {
                    a aVar = (a) this.val.get(0);
                    start = aVar.getStart();
                    float f = 0.0f;
                    while (start < aVar.getEnd()) {
                        f += this.vag[start];
                        if (f >= this.qta / 2.0f) {
                            break;
                        }
                        start++;
                    }
                    start = 0;
                } else if (truncateAt == TruncateAt.END) {
                    start = ((a) this.val.get(this.val.size() - 1)).getEnd() - 1;
                } else {
                    start = 0;
                }
                float f2 = 0.0f;
                while (start >= 0) {
                    f2 += this.vag[start];
                    if (f2 >= measureText) {
                        break;
                    }
                    this.vag[start] = 0.0f;
                    this.vaf[start] = 0;
                    start--;
                }
                this.vag[start] = measureText;
                this.vaf[start] = vac[0];
            }
        }
    }
}
