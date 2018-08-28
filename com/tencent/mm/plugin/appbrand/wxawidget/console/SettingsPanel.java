package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class SettingsPanel extends FrameLayout {
    private Button gQN;
    private Button gQO;
    private OnClickListener gQP;
    private Runnable gQQ;

    public SettingsPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SettingsPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(c.settings_panel, this, true);
        findViewById(b.restart_support_process_btn).setOnClickListener(new 1(this));
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById(b.enable_release_debug_btn);
        mMSwitchBtn.setCheck(((e) g.l(e.class)).JN().JP());
        mMSwitchBtn.setSwitchListener(new 2(this));
        this.gQN = (Button) findViewById(b.drawable_view_mode_btn);
        mt(com.tencent.mm.plugin.appbrand.dynamic.widget.c.afA());
        this.gQN.setOnClickListener(new 3(this));
        this.gQO = (Button) findViewById(b.json_parser_btn);
        mu(com.tencent.mm.v.g.De());
        this.gQO.setOnClickListener(new 4(this));
        findViewById(b.close_debugger_btn).setOnClickListener(new 5(this));
        if (((e) g.l(e.class)).JN().JQ()) {
            findViewById(b.enable_release_debug_item).setVisibility(0);
            findViewById(b.drawable_view_mode_item).setVisibility(0);
            findViewById(b.json_parser_item).setVisibility(0);
        }
    }

    public void setOnCloseDebuggerClickListener(OnClickListener onClickListener) {
        this.gQP = onClickListener;
    }

    public void setOnResetDebuggerRunnable(Runnable runnable) {
        this.gQQ = runnable;
    }

    private void mt(int i) {
        this.gQN.setTag(Integer.valueOf(i));
        switch (i) {
            case 1:
                this.gQN.setText("MTextureView");
                com.tencent.mm.plugin.appbrand.dynamic.widget.c.ki(1);
                return;
            case 2:
                this.gQN.setText("MSurfaceView");
                com.tencent.mm.plugin.appbrand.dynamic.widget.c.ki(2);
                return;
            case 3:
                this.gQN.setText("MCanvasView");
                com.tencent.mm.plugin.appbrand.dynamic.widget.c.ki(3);
                return;
            case 4:
                this.gQN.setText("MDrawableView");
                com.tencent.mm.plugin.appbrand.dynamic.widget.c.ki(4);
                return;
            default:
                this.gQN.setText("MHADrawableView");
                com.tencent.mm.plugin.appbrand.dynamic.widget.c.ki(0);
                return;
        }
    }

    private void mu(int i) {
        CharSequence charSequence;
        int i2;
        this.gQO.setTag(Integer.valueOf(i));
        switch (i) {
            case 1:
                charSequence = "Minimal-json";
                i2 = 1;
                break;
            default:
                charSequence = "Normal";
                i2 = 0;
                break;
        }
        this.gQO.setText(charSequence);
        com.tencent.mm.v.g.gF(i2);
        f.a("com.tencent.mm:support", new IPCInteger(i2), a.class, null);
    }
}
