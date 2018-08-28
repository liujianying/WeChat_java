package com.tencent.mm.ui.f.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.plugin.comm.a.d;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.f.a.c.a;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView$a;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public final class f extends i {
    static final float[] utx = new float[]{20.0f, 60.0f};
    static final float[] uty = new float[]{40.0f, 60.0f};
    static final LayoutParams utz = new LayoutParams(-1, -1);
    private MMWebView dEn;
    private String mUrl;
    private a utA;
    private ProgressDialog utB;
    private ImageView utC;
    private FrameLayout utD;

    public f(Context context, String str, a aVar) {
        super(context, 16973840);
        this.mUrl = str;
        this.utA = aVar;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.utB = new ProgressDialog(getContext());
        this.utB.requestWindowFeature(1);
        this.utB.setMessage(getContext().getString(h.facebook_sdk_loading));
        requestWindowFeature(1);
        this.utD = new FrameLayout(getContext());
        this.utC = new ImageView(getContext());
        this.utC.setOnClickListener(new 1(this));
        this.utC.setImageDrawable(getContext().getResources().getDrawable(d.close_facebook));
        this.utC.setVisibility(4);
        int intrinsicWidth = this.utC.getDrawable().getIntrinsicWidth() / 2;
        View linearLayout = new LinearLayout(getContext());
        this.dEn = MMWebView$a.cS(getContext());
        this.dEn.setVerticalScrollBarEnabled(false);
        this.dEn.setHorizontalScrollBarEnabled(false);
        this.dEn.setWebViewClient(new a(this, (byte) 0));
        this.dEn.getSettings().setJavaScriptEnabled(true);
        this.dEn.loadUrl(this.mUrl);
        this.dEn.setLayoutParams(utz);
        this.dEn.setVisibility(4);
        linearLayout.setPadding(intrinsicWidth, intrinsicWidth, intrinsicWidth, intrinsicWidth);
        linearLayout.addView(this.dEn);
        this.utD.addView(linearLayout);
        this.utD.addView(this.utC, new ViewGroup.LayoutParams(-2, -2));
        addContentView(this.utD, new ViewGroup.LayoutParams(-1, -1));
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        this.utA.onCancel();
        dismiss();
        return true;
    }
}
