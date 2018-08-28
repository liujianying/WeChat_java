package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.widget.EditText;
import java.io.Serializable;

public class e implements Serializable {
    public int Tw;
    public int tK;

    public e(int i, int i2) {
        this.Tw = i;
        this.tK = i2;
        if (this.Tw > this.tK) {
            int i3 = this.tK;
            this.tK = this.Tw;
            this.Tw = i3;
        }
    }

    public e(EditText editText) {
        this(editText.getSelectionStart(), editText.getSelectionEnd());
    }

    public final boolean isEmpty() {
        return this.Tw == this.tK;
    }

    public final e es(int i, int i2) {
        this.Tw = Math.max(0, this.Tw - i);
        this.tK += i2;
        return this;
    }

    public String toString() {
        return "[" + this.Tw + ", " + this.tK + "]";
    }
}
