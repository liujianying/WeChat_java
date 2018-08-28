package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

public final class a {
    private TextWatcher UE = new a(this, (byte) 0);
    private TextPaint gJA;
    TextView ih;
    private float kgD;
    private int kgE;
    float kgF;
    float kgG;
    float kgH;
    boolean kgI;
    ArrayList<Object> mListeners;
    private boolean yr;

    private static float a(CharSequence charSequence, TextPaint textPaint, float f, int i, float f2, float f3, float f4, DisplayMetrics displayMetrics) {
        TextPaint textPaint2 = textPaint;
        CharSequence charSequence2 = charSequence;
        while (true) {
            StaticLayout staticLayout;
            int lineCount;
            float f5 = (f2 + f3) / 2.0f;
            textPaint2.setTextSize(TypedValue.applyDimension(0, f5, displayMetrics));
            if (i != 1) {
                StaticLayout staticLayout2 = new StaticLayout(charSequence2, textPaint2, (int) f, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
                staticLayout = staticLayout2;
                lineCount = staticLayout2.getLineCount();
            } else {
                staticLayout = null;
                lineCount = 1;
            }
            if (lineCount > i) {
                if (f3 - f2 < f4) {
                    return f2;
                }
                f3 = f5;
            } else if (lineCount < i) {
                f2 = f5;
            } else {
                float f6 = 0.0f;
                if (i == 1) {
                    f6 = textPaint2.measureText(charSequence2, 0, charSequence2.length());
                } else {
                    for (int i2 = 0; i2 < lineCount; i2++) {
                        if (staticLayout.getLineWidth(i2) > f6) {
                            f6 = staticLayout.getLineWidth(i2);
                        }
                    }
                }
                if (f3 - f2 < f4) {
                    return f2;
                }
                if (f6 > f) {
                    f3 = f5;
                } else if (f6 >= f) {
                    return f5;
                } else {
                    f2 = f5;
                }
            }
        }
    }

    a(TextView textView) {
        float f = textView.getContext().getResources().getDisplayMetrics().scaledDensity;
        this.ih = textView;
        this.gJA = new TextPaint();
        setRawTextSize(textView.getTextSize());
        int i = -1;
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod != null && (transformationMethod instanceof SingleLineTransformationMethod)) {
            i = 1;
        } else if (VERSION.SDK_INT >= 16) {
            i = textView.getMaxLines();
        }
        this.kgE = i;
        this.kgF = 8.0f * f;
        this.kgG = this.kgD;
        this.kgH = 0.5f;
    }

    public final a ak(float f) {
        if (this.kgH != f) {
            this.kgH = f;
            aVD();
        }
        return this;
    }

    public final a j(int i, float f) {
        Context context = this.ih.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(i, f, system.getDisplayMetrics());
        if (applyDimension != this.kgF) {
            this.kgF = applyDimension;
            aVD();
        }
        return this;
    }

    public final a re(int i) {
        if (this.kgE != i) {
            this.kgE = i;
            aVD();
        }
        return this;
    }

    public final a fA(boolean z) {
        if (this.yr != z) {
            this.yr = z;
            if (z) {
                this.ih.addTextChangedListener(this.UE);
                aVD();
            } else {
                this.ih.removeTextChangedListener(this.UE);
                this.ih.setTextSize(0, this.kgD);
            }
        }
        return this;
    }

    final void setRawTextSize(float f) {
        if (this.kgD != f) {
            this.kgD = f;
        }
    }

    public final void aVD() {
        float textSize = this.ih.getTextSize();
        this.kgI = true;
        View view = this.ih;
        TextPaint textPaint = this.gJA;
        float f = this.kgF;
        float f2 = this.kgG;
        int i = this.kgE;
        float f3 = this.kgH;
        if (i > 0 && i != Integer.MAX_VALUE) {
            int width = (view.getWidth() - view.getPaddingLeft()) - view.getPaddingRight();
            if (width > 0) {
                float f4;
                CharSequence text = view.getText();
                TransformationMethod transformationMethod = view.getTransformationMethod();
                if (transformationMethod != null) {
                    text = transformationMethod.getTransformation(text, view);
                }
                Context context = view.getContext();
                Resources system = Resources.getSystem();
                if (context != null) {
                    system = context.getResources();
                }
                DisplayMetrics displayMetrics = system.getDisplayMetrics();
                textPaint.set(view.getPaint());
                textPaint.setTextSize(f2);
                if (i != 1 || textPaint.measureText(text, 0, text.length()) <= ((float) width)) {
                    float f5 = (float) width;
                    textPaint.setTextSize(TypedValue.applyDimension(0, f2, displayMetrics));
                    if (new StaticLayout(text, textPaint, (int) f5, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getLineCount() <= i) {
                        f4 = f2;
                        if (f4 < f) {
                            f4 = f;
                        }
                        view.setTextSize(0, f4);
                    }
                }
                f4 = a(text, textPaint, (float) width, i, 0.0f, f2, f3, displayMetrics);
                if (f4 < f) {
                    f4 = f;
                }
                view.setTextSize(0, f4);
            }
        }
        this.kgI = false;
        if (this.ih.getTextSize() != textSize) {
            aVE();
        }
    }

    private void aVE() {
        if (this.mListeners != null) {
            Iterator it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }
}
