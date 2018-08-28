package com.google.android.gms.tagmanager;

import android.content.SharedPreferences.Editor;

class af$1 implements Runnable {
    final /* synthetic */ Editor bcB;

    af$1(Editor editor) {
        this.bcB = editor;
    }

    public final void run() {
        this.bcB.commit();
    }
}
