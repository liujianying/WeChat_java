package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.xweb.k;

class a$7 implements OnClickListener {
    final /* synthetic */ a vEm;
    final /* synthetic */ Button vEo;

    a$7(a aVar, Button button) {
        this.vEm = aVar;
        this.vEo = button;
    }

    public final void onClick(View view) {
        k.cIn().mW(!k.cIn().vAv);
        this.vEo.setText(k.cIn().vAv ? "使用正式版config" : "使用测试config");
    }
}
