package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EllipsizingTextView extends TextView {
    private final List<Object> kgS = new ArrayList();
    private boolean kgT;
    private boolean kgU;
    private boolean kgV;
    private String kgW;
    private float kgX = 1.0f;
    private float kgY = 0.0f;
    private int maxLines = -1;

    public EllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.maxLines = i;
        this.kgU = true;
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    public void setLineSpacing(float f, float f2) {
        this.kgY = f;
        this.kgX = f2;
        super.setLineSpacing(f, f2);
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.kgV) {
            this.kgW = charSequence.toString();
            this.kgU = true;
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.kgU) {
            boolean z;
            super.setEllipsize(null);
            int maxLines = getMaxLines();
            CharSequence charSequence = this.kgW;
            if (maxLines != -1) {
                Layout Ez = Ez(charSequence);
                if (Ez.getLineCount() > maxLines) {
                    String trim = this.kgW.substring(0, Ez.getLineEnd(maxLines - 1)).trim();
                    if (!(trim.getBytes().length != trim.length())) {
                        while (Ez(trim + "...").getLineCount() > maxLines) {
                            int lastIndexOf = trim.lastIndexOf(32);
                            if (lastIndexOf == -1) {
                                break;
                            }
                            trim = trim.substring(0, lastIndexOf);
                        }
                    } else if (trim.length() >= 2) {
                        trim = trim.substring(0, (trim.length() - 1) - 1);
                    }
                    charSequence = trim + "...";
                    z = true;
                    if (!charSequence.equals(getText())) {
                        this.kgV = true;
                        try {
                            setText(charSequence);
                        } finally {
                            this.kgV = false;
                        }
                    }
                    this.kgU = false;
                    if (z != this.kgT) {
                        this.kgT = z;
                        Iterator it = this.kgS.iterator();
                        while (it.hasNext()) {
                            it.next();
                        }
                    }
                }
            }
            z = false;
            if (charSequence.equals(getText())) {
                this.kgV = true;
                try {
                    setText(charSequence);
                } finally {
                    this.kgV = false;
                }
            }
            this.kgU = false;
            if (z != this.kgT) {
                this.kgT = z;
                Iterator it2 = this.kgS.iterator();
                while (it2.hasNext()) {
                    it2.next();
                }
            }
        }
        super.onDraw(canvas);
    }

    private Layout Ez(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Alignment.ALIGN_NORMAL, this.kgX, this.kgY, false);
    }

    public void setEllipsize(TruncateAt truncateAt) {
    }
}
