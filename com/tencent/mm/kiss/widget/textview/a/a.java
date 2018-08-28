package com.tencent.mm.kiss.widget.textview.a;

import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;

public final class a {
    public Typeface boi = null;
    public Alignment dtV = Alignment.ALIGN_NORMAL;
    public TruncateAt dtW = null;
    public TextDirectionHeuristic dtY = null;
    public float dtZ = 0.0f;
    public float dua = 1.0f;
    public boolean dub = false;
    public TextPaint dug = null;
    public int duy = -1;
    public float duz = -1.0f;
    public int fontStyle = -1;
    public int gravity = 51;
    public int linkColor = -1;
    public int maxLength = -1;
    public int maxLines = -1;
    public int minLines = -1;
    public int textColor = -1;

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(String.format("maxLines: %d ", new Object[]{Integer.valueOf(this.maxLines)}));
        stringBuilder.append(String.format("maxLength: %d ", new Object[]{Integer.valueOf(this.maxLength)}));
        stringBuilder.append(String.format("textPaint: %s ", new Object[]{this.dug}));
        stringBuilder.append(String.format("alignment: %s ", new Object[]{this.dtV}));
        stringBuilder.append(String.format("ellipsize: %s ", new Object[]{this.dtW}));
        stringBuilder.append(String.format("gravity: %s ", new Object[]{Integer.valueOf(this.gravity)}));
        stringBuilder.append(String.format("ellipsizeWidth: %s ", new Object[]{Integer.valueOf(this.duy)}));
        stringBuilder.append(String.format("textDirection: %s ", new Object[]{this.dtY}));
        stringBuilder.append(String.format("spacingAdd: %s spacingMult: %s ", new Object[]{Float.valueOf(this.dtZ), Float.valueOf(this.dua)}));
        stringBuilder.append(String.format("includedPad: %b ", new Object[]{Boolean.valueOf(this.dub)}));
        stringBuilder.append(String.format("typeface: %s ", new Object[]{this.boi}));
        stringBuilder.append(String.format("fontStyle: %d ", new Object[]{Integer.valueOf(this.fontStyle)}));
        stringBuilder.append(String.format("textSize: %s ", new Object[]{Float.valueOf(this.duz)}));
        stringBuilder.append(String.format("textColor: %d", new Object[]{Integer.valueOf(this.textColor)}));
        stringBuilder.append(String.format("linkColor: %d", new Object[]{Integer.valueOf(this.linkColor)}));
        return stringBuilder.toString();
    }

    public final int hashCode() {
        int i = ((this.maxLines * 31) + 0) + (this.maxLength * 31);
        if (this.dug != null) {
            i += this.dug.hashCode() * 31;
        }
        i += this.dtV.hashCode() * 31;
        if (this.dtW != null) {
            i += this.dtW.hashCode() * 31;
        }
        i = (i + (this.gravity * 31)) + (this.duy * 31);
        if (this.dtY != null) {
            i += this.dtY.hashCode() * 31;
        }
        i = ((this.dub ? 1 : 0) * 31) + ((int) (((float) ((int) (((float) i) + (this.dtZ * 31.0f)))) + (this.dua * 31.0f)));
        if (this.boi != null) {
            i += this.boi.hashCode() * 31;
        }
        return (((int) (((float) (i + (this.fontStyle * 31))) + (this.duz * 31.0f))) + (this.textColor * 31)) + (this.linkColor * 31);
    }
}
