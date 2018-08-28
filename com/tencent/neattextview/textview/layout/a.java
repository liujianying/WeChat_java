package com.tencent.neattextview.textview.layout;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import java.io.Serializable;

public interface a extends Serializable {
    void a(Canvas canvas, TextPaint textPaint, float f);

    float[] cEb();

    RectF cEc();

    float cEd();

    boolean cEe();

    float cEf();

    int getEnd();

    float getHeight();

    int getStart();

    float getWidth();
}
