package com.tencent.mm.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.neattextview.textview.view.NeatTextView;

public class MMNeatTextView extends NeatTextView {
    private static boolean BA = true;
    public static boolean uGn = false;
    private static final String uGo = "^[\\u0001-\\u00b7\\u4E00-\\u9FA5\\ue001-\\ue537\\u2005-\\u2027\\u3001-\\u3011\\uff01-\\uffe5\\u2100-\\u2900[\\ud83c\\udc00-\\ud83c\\udfff]|[\\ud83d\\udc00-\\ud83d\\udfff]]+$".substring(1, 149);
    private GestureDetector gbw = new GestureDetector(getContext(), new SimpleOnGestureListener() {
        public final boolean onDoubleTap(MotionEvent motionEvent) {
            if (MMNeatTextView.this.getOnDoubleClickListener() == null) {
                return false;
            }
            return MMNeatTextView.this.getOnDoubleClickListener().dK(MMNeatTextView.this);
        }
    });
    private OnLongClickListener uGp;
    private a uGq;
    private b uGr;

    public interface a {
        void P(CharSequence charSequence);
    }

    public interface b {
        void a(Exception exception, String str, String str2);
    }

    static /* synthetic */ String abs(String str) {
        String replaceAll = str.replaceAll(uGo, "*");
        StringBuilder stringBuilder = new StringBuilder(replaceAll);
        stringBuilder.append(10);
        stringBuilder.append('[');
        char[] toCharArray = replaceAll.toCharArray();
        for (char c : toCharArray) {
            if (c != '*') {
                stringBuilder.append("{\\u").append(String.format("%x", new Object[]{Integer.valueOf(toCharArray[r0])})).append("}");
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public MMNeatTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public float getVerticalOffset() {
        if (!uGn) {
            return super.getVerticalOffset();
        }
        float measuredHeight = (float) getMeasuredHeight();
        x.i("MicroMsg.MMNeatTextView_changelcai", "text:%s [getVerticalOffset] offset:%s height:%s ,layout height:%s", this.mText, Float.valueOf(super.getVerticalOffset()), Float.valueOf(measuredHeight), Float.valueOf(getLayout().cEh()[1]));
        return super.getVerticalOffset();
    }

    @SuppressLint({"GetContentDescriptionOverride"})
    public CharSequence getContentDescription() {
        int i;
        x.d("MicroMsg.MMNeatTextView", "[isOpen] %s", Boolean.valueOf(false));
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        boolean isEnabled = accessibilityManager.isEnabled();
        boolean isTouchExplorationEnabled = accessibilityManager.isTouchExplorationEnabled();
        if (isEnabled && isTouchExplorationEnabled) {
            i = 1;
        } else {
            isTouchExplorationEnabled = false;
        }
        if (i != 0 || com.tencent.mm.sdk.a.b.chp()) {
            return this.mText;
        }
        return "";
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!BA || (this.vbj && this.gbw != null)) {
            this.gbw.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public final boolean cAs() {
        return BA;
    }

    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Exception e) {
            x.e("MicroMsg.MMNeatTextView", "[onDraw] replaceContent:%s exception:%s", this.mText.toString().replaceAll(uGo, "*"), e);
            if (this.uGr != null) {
                this.uGr.a(e, r1, "onDraw");
                return;
            }
            throw e;
        }
    }

    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (Exception e) {
            x.e("MicroMsg.MMNeatTextView", "[onMeasure] replaceContent:%s exception:%s", this.mText.toString().replaceAll(uGo, "*"), e);
            if (this.uGr != null) {
                this.uGr.a(e, r1, "onMeasure");
                return;
            }
            throw e;
        }
    }

    public final void Q(CharSequence charSequence) {
        try {
            super.Q(charSequence);
            if (this.vbj && this.uGr != null) {
                charSequence.toString();
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMNeatTextView", "[_setText] replaceContent:%s exception:%s", this.mText.toString().replaceAll(uGo, "*"), e);
            if (this.uGr != null) {
                this.uGr.a(e, r1, "_setText");
            } else {
                throw e;
            }
        }
        if (this.uGq != null) {
            a aVar = this.uGq;
            BufferType bufferType;
            if (charSequence instanceof Spannable) {
                bufferType = BufferType.SPANNABLE;
            } else {
                bufferType = BufferType.NORMAL;
            }
            aVar.P(charSequence);
        }
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.uGp = onLongClickListener;
        super.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                if (MMNeatTextView.uGn) {
                    Toast.makeText(MMNeatTextView.this.getContext(), MMNeatTextView.abs(MMNeatTextView.this.mText.toString()), 1).show();
                }
                if (MMNeatTextView.this.uGp != null) {
                    return MMNeatTextView.this.uGp.onLongClick(view);
                }
                return false;
            }
        });
    }

    public void setIsOpen(boolean z) {
        BA = z;
    }

    public void setTextListener(a aVar) {
        this.uGq = aVar;
    }

    public void setTextCrashListener(b bVar) {
        this.uGr = bVar;
    }
}
