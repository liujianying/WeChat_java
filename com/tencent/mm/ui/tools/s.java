package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class s {
    String gEw;
    List<b> uCw;
    WeakReference<EditText> uCx;
    ArrayList<String> uCy;
    boolean uCz;

    public static class a extends Drawable {
        private static int uvu;
        private RectF cP;
        private Paint dnB = new Paint(1);
        private String gEw;
        private float uCA;
        private float uCB;
        private Paint uvt;
        private float uvv;
        private float uvw;

        public a(Context context, String str, Paint paint) {
            this.dnB.setColor(-7829368);
            this.uvt = paint;
            uvu = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(context, 2.0f);
            this.uCA = (float) uvu;
            this.uCB = (float) uvu;
            this.gEw = str;
            this.uvv = this.uvt.measureText(this.gEw);
            FontMetrics fontMetrics = this.uvt.getFontMetrics();
            this.uvw = (float) Math.ceil((double) (fontMetrics.bottom - fontMetrics.top));
            setBounds(0, 0, (int) ((this.uvv + ((float) (uvu * 2))) + ((float) (uvu * 2))), (int) this.uvw);
            x.i("MicroMsg.TextDrawable", "setText(%s).", str);
        }

        public final void draw(Canvas canvas) {
            canvas.drawRoundRect(this.cP, this.uCA, this.uCB, this.dnB);
            Rect bounds = getBounds();
            int i = (int) (((((float) (bounds.right - bounds.left)) - (this.cP.right - this.cP.left)) + ((float) (uvu * 2))) / 2.0f);
            FontMetricsInt fontMetricsInt = this.uvt.getFontMetricsInt();
            canvas.drawText(this.gEw, (float) i, (float) ((((((bounds.bottom - bounds.top) - fontMetricsInt.bottom) + fontMetricsInt.top) / 2) + bounds.top) - fontMetricsInt.top), this.uvt);
        }

        public final void setAlpha(int i) {
            if (i != this.dnB.getAlpha()) {
                this.dnB.setAlpha(i);
                invalidateSelf();
            }
        }

        public final void setColorFilter(ColorFilter colorFilter) {
            this.dnB.setColorFilter(colorFilter);
            invalidateSelf();
        }

        public final int getOpacity() {
            return this.dnB.getAlpha() < 255 ? -3 : -1;
        }

        public final void setBounds(int i, int i2, int i3, int i4) {
            super.setBounds(i, i2, i3, i4);
            FontMetrics fontMetrics = this.uvt.getFontMetrics();
            this.cP = new RectF((float) (uvu + i), (fontMetrics.ascent - fontMetrics.top) + ((float) i2), (float) (i3 - uvu), (float) i4);
            invalidateSelf();
        }
    }

    private static class b {
        int length;
        int start;
        boolean uCC;

        b(int i, int i2, boolean z) {
            this.start = i;
            this.length = i2;
            this.uCC = z;
        }
    }

    public s(EditText editText) {
        this.uCx = new WeakReference(editText);
    }

    final b Gg(int i) {
        if (this.uCw != null) {
            for (b bVar : this.uCw) {
                if (i <= bVar.start + bVar.length && i > bVar.start) {
                    return bVar;
                }
            }
        }
        return null;
    }

    static boolean a(EditText editText, ArrayList<String> arrayList) {
        String obj = editText.getText().toString();
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        List<b> k = k(obj, arrayList);
        if (k == null || k.size() <= 0) {
            return false;
        }
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        Context context = editText.getContext();
        Paint paint = editText.getPaint();
        for (b bVar : k) {
            int i = bVar.start;
            int i2 = bVar.length;
            if (i < 0 || i2 <= 0 || i + i2 > obj.length()) {
                x.i("MicroMsg.WordsChecker", "start : %d, length : %d.", Integer.valueOf(i), Integer.valueOf(i2));
            } else if (bVar.uCC) {
                String substring = obj.substring(i, i + i2);
                CharSequence spannableString = new SpannableString(substring);
                spannableString.setSpan(new ImageSpan(new a(context, substring, paint), 0), 0, substring.length(), 33);
                spannableStringBuilder.append(spannableString);
            } else {
                spannableStringBuilder.append(obj.substring(i, i + i2));
            }
        }
        if (spannableStringBuilder.length() > 0) {
            editText.setText(spannableStringBuilder);
            editText.setTextKeepState(spannableStringBuilder);
            if (selectionStart == selectionEnd && selectionStart >= 0) {
                editText.setSelection(selectionStart);
            }
        }
        return true;
    }

    static List<b> k(String str, ArrayList<String> arrayList) {
        if (bi.oW(str) || arrayList == null || arrayList.size() == 0) {
            return null;
        }
        List<b> arrayList2 = new ArrayList();
        int length = str.length();
        int i = 0;
        while (i <= length) {
            Iterator it = arrayList.iterator();
            int i2 = 0;
            int i3 = length;
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (!bi.oW(str2)) {
                    int i4;
                    int indexOf = str.indexOf(str2, i);
                    if (indexOf < 0 || (indexOf >= i3 && (indexOf != i3 || str2.length() <= i2))) {
                        i4 = i2;
                    } else {
                        i4 = str2.length();
                        i3 = indexOf;
                    }
                    i2 = i4;
                }
            }
            if (i3 < length) {
                if (i3 > i) {
                    arrayList2.add(new b(i, i3 - i, false));
                }
                arrayList2.add(new b(i3, i2, true));
                i = i3 + i2;
            } else {
                if (i3 > i) {
                    arrayList2.add(new b(i, i3 - i, false));
                }
                return arrayList2;
            }
        }
        return arrayList2;
    }
}
