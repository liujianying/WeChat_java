package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.widget.ListView;

public class lf extends ListView {
    private a a;

    public lf(Context context) {
        super(context);
    }

    protected void handleDataChanged() {
        super.handleDataChanged();
        if (this.a != null) {
            this.a.c();
        }
    }

    public void setOnDataChangedListener(a aVar) {
        this.a = aVar;
    }
}
