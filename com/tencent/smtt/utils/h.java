package com.tencent.smtt.utils;

import android.widget.Toast;

class h implements Runnable {
    final /* synthetic */ e a;

    h(e eVar) {
        this.a = eVar;
    }

    public void run() {
        Toast.makeText(this.a.b, "下载失败，请检查网络", 0).show();
    }
}
