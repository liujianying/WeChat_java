package com.tencent.mm.pluginsdk.ui.d;

import android.view.View;

public class o extends n {
    private a qQA;
    private Object tag;

    public o(Object obj, a aVar) {
        super(2, null);
        this.qQA = aVar;
        this.tag = obj;
    }

    public o(Object obj, a aVar, int i) {
        super(2, null);
        this.qQA = aVar;
        this.tag = obj;
        zu(i);
    }

    public void onClick(View view) {
        if (this.qQA != null) {
            this.qQA.bQ(this.tag);
        }
    }
}
