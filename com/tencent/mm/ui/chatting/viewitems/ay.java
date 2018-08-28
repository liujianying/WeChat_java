package com.tencent.mm.ui.chatting.viewitems;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mm.ui.base.a.a;

final class ay extends LinkMovementMethod {
    private a ufO;

    ay() {
    }

    public final boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.ufO = a(textView, spannable, motionEvent);
            if (this.ufO != null) {
                this.ufO.kT(true);
                Selection.setSelection(spannable, spannable.getSpanStart(this.ufO), spannable.getSpanEnd(this.ufO));
            }
        } else if (motionEvent.getAction() == 2) {
            a a = a(textView, spannable, motionEvent);
            if (!(this.ufO == null || a == this.ufO)) {
                this.ufO.kT(false);
                this.ufO = null;
                Selection.removeSelection(spannable);
            }
        } else {
            if (this.ufO != null) {
                this.ufO.kT(false);
                super.onTouchEvent(textView, spannable, motionEvent);
            }
            this.ufO = null;
            Selection.removeSelection(spannable);
        }
        return true;
    }

    private static a a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int x = (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX();
        int y = (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY();
        Layout layout = textView.getLayout();
        x = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
        a[] aVarArr = (a[]) spannable.getSpans(x, x, a.class);
        if (aVarArr.length > 0) {
            return aVarArr[0];
        }
        return null;
    }
}
