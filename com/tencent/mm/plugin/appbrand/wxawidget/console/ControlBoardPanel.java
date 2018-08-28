package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.sdk.platformtools.x;

public class ControlBoardPanel extends FrameLayout {
    ConsolePanel fxO;
    a gQB;
    View gQC;
    SettingsPanel gQD;
    View gQE;
    View gQF;
    View gQG;
    View gQH;
    WindowManager gQI;
    LayoutParams gQJ;
    boolean gQK;

    static /* synthetic */ void a(ControlBoardPanel controlBoardPanel) {
        controlBoardPanel.gQJ.width = -2;
        controlBoardPanel.gQJ.height = -2;
        controlBoardPanel.gQJ.flags = 520;
        controlBoardPanel.gQI.updateViewLayout(controlBoardPanel, controlBoardPanel.gQJ);
    }

    static /* synthetic */ void b(ControlBoardPanel controlBoardPanel) {
        controlBoardPanel.gQJ.width = -1;
        controlBoardPanel.gQJ.height = -1;
        controlBoardPanel.gQJ.flags = 544;
        controlBoardPanel.gQI.updateViewLayout(controlBoardPanel, controlBoardPanel.gQJ);
    }

    public ControlBoardPanel(Context context) {
        super(context);
        init();
    }

    public ControlBoardPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ControlBoardPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        Context context = getContext();
        this.gQI = (WindowManager) context.getSystemService("window");
        LayoutInflater.from(context).inflate(c.control_board_panel, this, true);
        this.gQC = findViewById(b.content_vg);
        this.fxO = (ConsolePanel) findViewById(b.console_panel);
        this.gQD = (SettingsPanel) findViewById(b.settings_panel);
        this.gQE = findViewById(b.performance_panel);
        this.gQF = findViewById(b.console_btn);
        this.gQG = findViewById(b.settings_btn);
        this.gQH = findViewById(b.performance_btn);
        if (!((e) g.l(e.class)).JN().JQ()) {
            this.gQH.setVisibility(8);
        }
        this.gQF.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (ControlBoardPanel.this.fxO.getVisibility() == 0) {
                    ControlBoardPanel.this.gQC.setVisibility(8);
                    ControlBoardPanel.this.fxO.setVisibility(8);
                    ControlBoardPanel.this.gQF.setSelected(false);
                    ControlBoardPanel.a(ControlBoardPanel.this);
                    return;
                }
                ControlBoardPanel.this.gQC.setVisibility(0);
                ControlBoardPanel.this.fxO.setVisibility(0);
                ControlBoardPanel.this.gQD.setVisibility(8);
                ControlBoardPanel.this.gQE.setVisibility(8);
                ControlBoardPanel.this.gQF.setSelected(true);
                ControlBoardPanel.this.gQG.setSelected(false);
                ControlBoardPanel.this.gQH.setSelected(false);
                ControlBoardPanel.b(ControlBoardPanel.this);
            }
        });
        this.gQG.setOnClickListener(new 2(this));
        this.gQH.setOnClickListener(new 3(this));
        setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                x.i("MicroMsg.ControlBoardPanel", "onKey(%s, %s)", new Object[]{Integer.valueOf(i), keyEvent});
                if (i == 4) {
                    ControlBoardPanel.this.gQC.setVisibility(8);
                    ControlBoardPanel.this.gQE.setVisibility(8);
                    ControlBoardPanel.this.gQE.setVisibility(8);
                    ControlBoardPanel.this.gQH.setSelected(false);
                    ControlBoardPanel.this.gQF.setSelected(false);
                    ControlBoardPanel.this.gQG.setSelected(false);
                    ControlBoardPanel.a(ControlBoardPanel.this);
                }
                return false;
            }
        });
        this.gQD.setOnCloseDebuggerClickListener(new 5(this));
        this.gQD.setOnResetDebuggerRunnable(new 6(this));
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        x.i("MicroMsg.ControlBoardPanel", "onKeyUp(%s, %s)", new Object[]{Integer.valueOf(i), keyEvent});
        return super.onKeyUp(i, keyEvent);
    }

    public final void reset() {
        d.b(this.fxO);
        d.a(this.fxO);
    }
}
