package com.tencent.mm.plugin.webview.stub;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.g.a.aj;
import com.tencent.mm.g.a.cb;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;

@a(7)
public class WebviewScanImageActivity extends Activity {
    private int bJr;
    private int bJs;
    private String edG;
    private String nMW = null;
    private c nNd = new 1(this);
    private boolean pVh = false;
    private String url;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.WebviewScanImageActivity", "hy: on create");
        if (VERSION.SDK_INT >= 21) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().setStatusBarColor(0);
        }
        setContentView(R.i.layout_empty_activity);
    }

    protected void onStart() {
        super.onStart();
        x.i("MicroMsg.WebviewScanImageActivity", "hy: on start");
        if (!(this.pVh || getIntent() == null)) {
            this.nMW = getIntent().getStringExtra("key_string_for_scan");
            this.bJr = getIntent().getIntExtra("key_codetype_for_scan", 0);
            this.bJs = getIntent().getIntExtra("key_codeversion_for_scan", 0);
            this.url = getIntent().getStringExtra("key_string_for_url");
            this.edG = getIntent().getStringExtra("key_string_for_image_url");
            if (this.nMW != null) {
                cb cbVar = new cb();
                cbVar.bJq.activity = this;
                cbVar.bJq.bHL = this.nMW;
                cbVar.bJq.bJs = this.bJs;
                cbVar.bJq.bJr = this.bJr;
                cbVar.bJq.bJt = 6;
                cbVar.bJq.imagePath = this.edG;
                cbVar.bJq.scene = 40;
                Bundle bundle = new Bundle();
                bundle.putString("stat_url", this.url);
                bundle.putInt("stat_scene", 4);
                cbVar.bJq.bJx = bundle;
                com.tencent.mm.sdk.b.a.sFg.m(cbVar);
                com.tencent.mm.sdk.b.a.sFg.b(this.nNd);
            }
        }
        this.pVh = true;
    }

    protected void onPause() {
        super.onPause();
        x.i("MicroMsg.WebviewScanImageActivity", "hy: on pause");
        aj ajVar = new aj();
        ajVar.bHK.activity = this;
        ajVar.bHK.bHL = this.nMW;
        com.tencent.mm.sdk.b.a.sFg.m(ajVar);
        com.tencent.mm.sdk.b.a.sFg.c(this.nNd);
        finish();
    }
}
