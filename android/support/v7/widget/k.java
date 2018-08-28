package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

final class k extends j {
    private static final int[] HN = new int[]{16843074};
    private final SeekBar MN;

    k(SeekBar seekBar, h hVar) {
        super(seekBar, hVar);
        this.MN = seekBar;
    }

    final void b(AttributeSet attributeSet, int i) {
        super.b(attributeSet, i);
        ap a = ap.a(this.MN.getContext(), attributeSet, HN, i);
        Drawable bP = a.bP(0);
        if (bP != null) {
            this.MN.setThumb(bP);
        }
        a.Ww.recycle();
    }
}
