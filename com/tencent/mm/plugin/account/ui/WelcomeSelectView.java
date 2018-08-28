package com.tencent.mm.plugin.account.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.account.a.b;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.w;

public class WelcomeSelectView extends WelcomeView {
    private Context context;
    private View eRT;
    private Button eXt;
    private Button eXu;
    private TextView eXv;
    private int mHeight = 800;

    @TargetApi(11)
    public WelcomeSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        co(context);
    }

    public WelcomeSelectView(Context context) {
        super(context);
        co(context);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    private void co(final Context context) {
        this.context = context;
        View inflate = LayoutInflater.from(context).inflate(g.welcome_select_ui, this);
        this.eRT = inflate.findViewById(f.select_lv);
        this.eXt = (Button) inflate.findViewById(f.select_login_btn);
        this.eXu = (Button) inflate.findViewById(f.select_register_btn);
        this.eXv = (TextView) inflate.findViewById(f.welcome_language_tv);
        this.eRT.setVisibility(8);
        this.eXv.setVisibility(8);
        this.eXv.setText(w.h(context, b.language_setting, j.app_lang_sys));
        this.mHeight = context.getResources().getDisplayMetrics().heightPixels;
        this.eXv.setOnClickListener(new 1(this));
        this.eXt.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(context, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 1);
                context.startActivity(intent);
            }
        });
        this.eXu.setOnClickListener(new 3(this, context));
        String e = w.e(this.context.getSharedPreferences(ad.chY(), 0));
        this.eXv.setText(w.h(this.context, b.language_setting, j.app_lang_sys));
        if (e != null && e.equals("language_default")) {
            this.eXv.setText(this.context.getString(j.login_language));
        }
        this.eXt.setText(j.intro_existed_login);
        this.eXu.setText(j.intro_create_account_qq);
    }

    public final void Zt() {
        bE(this.eRT);
        bE(this.eXv);
        this.eRT.setVisibility(0);
        this.eXv.setVisibility(0);
        ah.A(new 4(this));
    }
}
