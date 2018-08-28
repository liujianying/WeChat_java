package com.tencent.neattextview.textview.b;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.tencent.neattextview.textview.layout.c;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class b<T extends CharacterStyle> implements Serializable {
    private int Tw;
    private int tK;
    protected LinkedList<RectF> vaa;
    public CharacterStyle vab;

    public abstract void a(Canvas canvas, TextPaint textPaint, List<c> list);

    b(int i, int i2, CharacterStyle characterStyle) {
        this.Tw = i;
        this.tK = i2;
        this.vab = characterStyle;
    }

    final void ee(List<c> list) {
        if (this.vaa == null) {
            this.vaa = new LinkedList();
            for (c cVar : list) {
                if (cVar.Tw <= this.Tw && this.tK < cVar.tK) {
                    this.vaa.add(cVar.fz(this.Tw, this.tK));
                    return;
                } else if (cVar.Tw <= this.Tw && this.Tw < cVar.tK && cVar.tK <= this.tK) {
                    this.vaa.add(cVar.fz(this.Tw, cVar.tK));
                } else if (this.Tw < cVar.Tw && this.tK < cVar.tK && this.tK >= cVar.Tw) {
                    this.vaa.add(cVar.fz(cVar.Tw, this.tK));
                    return;
                } else if (this.Tw < cVar.Tw && this.tK >= cVar.tK) {
                    this.vaa.add(cVar.fz(cVar.Tw, cVar.tK));
                }
            }
        }
    }

    public final boolean W(float f, float f2) {
        if (this.vaa == null) {
            return false;
        }
        Iterator it = this.vaa.iterator();
        while (it.hasNext()) {
            if (((RectF) it.next()).contains(f, f2)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (bVar.Tw != this.Tw || bVar.tK != this.tK) {
            return false;
        }
        for (int i = 0; i < this.vaa.size(); i++) {
            if (!((RectF) this.vaa.get(i)).equals((RectF) bVar.vaa.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 >= this.vaa.size()) {
                return (this.Tw + this.tK) + i3;
            }
            i3 += ((RectF) this.vaa.get(i2)).hashCode();
            i = i2 + 1;
        }
    }

    public String toString() {
        return "CharacterBgStyle{mRectFList=" + this.vaa + ", mStart=" + this.Tw + ", mEnd=" + this.tK + '}';
    }
}
