package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import java.util.ArrayList;

public class AutoResizeTextView extends TextView {
    private a kgz;

    public AutoResizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(attributeSet);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        e(attributeSet);
    }

    private void e(AttributeSet attributeSet) {
        a aVar = new a(this);
        if (attributeSet != null) {
            int i = (int) aVar.kgF;
            aVar.j(0, (float) i).ak(aVar.kgH);
        }
        aVar.fA(true);
        if (aVar.mListeners == null) {
            aVar.mListeners = new ArrayList();
        }
        aVar.mListeners.add(this);
        this.kgz = aVar;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.kgz != null) {
            this.kgz.aVD();
        }
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        if (this.kgz != null) {
            a aVar = this.kgz;
            if (!aVar.kgI) {
                Context context = aVar.ih.getContext();
                Resources system = Resources.getSystem();
                if (context != null) {
                    system = context.getResources();
                }
                aVar.setRawTextSize(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
            }
        }
    }

    public void setLines(int i) {
        super.setLines(i);
        if (this.kgz != null) {
            this.kgz.re(i);
        }
    }

    public void setMaxLines(int i) {
        super.setMaxLines(i);
        if (this.kgz != null) {
            this.kgz.re(i);
        }
    }

    public a getAutofitHelper() {
        return this.kgz;
    }

    public void setSizeToFit(boolean z) {
        this.kgz.fA(z);
    }

    public float getMaxTextSize() {
        return this.kgz.kgG;
    }

    public void setMaxTextSize(float f) {
        a aVar = this.kgz;
        Context context = aVar.ih.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(2, f, system.getDisplayMetrics());
        if (applyDimension != aVar.kgG) {
            aVar.kgG = applyDimension;
            aVar.aVD();
        }
    }

    public float getMinTextSize() {
        return this.kgz.kgF;
    }

    public void setMinTextSize(int i) {
        this.kgz.j(2, (float) i);
    }

    public float getPrecision() {
        return this.kgz.kgH;
    }

    public void setPrecision(float f) {
        this.kgz.ak(f);
    }
}
