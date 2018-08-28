package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mm.ui.widget.MMEditText;

public class SnsEditText extends MMEditText {
    private Context context;
    private boolean kCS = false;
    private ClipboardManager nVZ = null;
    private int nWa = 0;
    private int nWb = 0;
    private int nWc = 0;
    private int nWd = 10;
    private float y;

    public SnsEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.nVZ = (ClipboardManager) this.context.getSystemService("clipboard");
        addTextChangedListener(new 1(this));
    }

    public int getPasterLen() {
        return this.nWa;
    }

    public void setPasterLen(int i) {
        this.nWa = i;
    }

    public boolean onTextContextMenuItem(int i) {
        return super.onTextContextMenuItem(i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            if (Math.abs(this.y - motionEvent.getY()) > ((float) this.nWd)) {
                this.kCS = true;
            }
        } else if (motionEvent.getAction() != 1) {
            this.kCS = false;
        } else if (this.kCS) {
            this.kCS = false;
            return true;
        }
        this.y = motionEvent.getY();
        return super.onTouchEvent(motionEvent);
    }
}
