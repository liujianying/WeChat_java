package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.appbrand.wxawidget.a;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;
import java.util.List;

public class ConsolePanel extends FrameLayout implements a {
    final List<LogInfo> gQl = new LinkedList();
    EditText gQr;
    Button[] gQs;
    Button gQt;
    Button gQu;
    a gQv;
    int gQw;
    String gQx;
    MRecyclerView gvH;

    static /* synthetic */ void a(ConsolePanel consolePanel) {
        consolePanel.gQv.gQl.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < consolePanel.gQl.size()) {
                LogInfo logInfo = (LogInfo) consolePanel.gQl.get(i2);
                if ((consolePanel.gQw <= 0 || logInfo.level == consolePanel.gQw) && !consolePanel.wr(logInfo.message)) {
                    consolePanel.gQv.gQl.add(logInfo);
                }
                i = i2 + 1;
            } else {
                consolePanel.gQv.RR.notifyChanged();
                return;
            }
        }
    }

    public ConsolePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize();
    }

    public ConsolePanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initialize();
    }

    private void initialize() {
        LayoutInflater.from(getContext()).inflate(c.console_panel, this, true);
        this.gQr = (EditText) findViewById(b.console_dt);
        this.gQr.clearFocus();
        this.gQs = new Button[5];
        cd(0, b.log_all_btn);
        cd(1, b.log_log_btn);
        cd(2, b.log_info_btn);
        cd(3, b.log_warn_btn);
        cd(4, b.log_error_btn);
        this.gQs[0].setSelected(true);
        this.gQw = 0;
        this.gQt = (Button) findViewById(b.clear_log_btn);
        this.gQu = (Button) findViewById(b.save_log_btn);
        this.gQu.setEnabled(false);
        this.gQt.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ConsolePanel.this.gQl.clear();
                ConsolePanel.this.gQv.gQl.clear();
                ConsolePanel.this.gQv.RR.notifyChanged();
            }
        });
        this.gQu.setOnClickListener(new 2(this));
        this.gQr.addTextChangedListener(new 3(this));
        this.gQr.setOnKeyListener(new 4(this));
        this.gQr.setOnFocusChangeListener(new 5(this));
        findViewById(b.do_filter_btn).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ConsolePanel.this.gQx = ConsolePanel.this.gQr.getText().toString();
                ConsolePanel.a(ConsolePanel.this);
            }
        });
        setOnTouchListener(new 7(this));
        this.gvH = (MRecyclerView) findViewById(b.log_rv);
        this.gQv = new a(getContext());
        MRecyclerView mRecyclerView = this.gvH;
        getContext();
        mRecyclerView.setLayoutManager(new LinearLayoutManager());
        this.gvH.setItemAnimator(null);
        this.gvH.setAdapter(this.gQv);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int i;
            View currentFocus = ((Activity) getContext()).getCurrentFocus();
            if (currentFocus != null && (currentFocus instanceof EditText)) {
                int[] iArr = new int[]{0, 0};
                currentFocus.getLocationInWindow(iArr);
                int i2 = iArr[0];
                i = iArr[1];
                int height = currentFocus.getHeight() + i;
                int width = currentFocus.getWidth() + i2;
                if (motionEvent.getX() <= ((float) i2) || motionEvent.getX() >= ((float) width) || motionEvent.getY() <= ((float) i) || motionEvent.getY() >= ((float) height)) {
                    i = 1;
                    if (i != 0) {
                        f.ck(currentFocus);
                    }
                }
            }
            i = 0;
            if (i != 0) {
                f.ck(currentFocus);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void cd(int i, int i2) {
        Button button = (Button) findViewById(i2);
        button.setOnClickListener(new 8(this));
        this.gQs[i] = button;
    }

    public final void at(List<LogInfo> list) {
        if (list != null) {
            List linkedList = new LinkedList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                LogInfo logInfo = (LogInfo) list.get(i2);
                this.gQl.add(logInfo);
                if ((logInfo.level == this.gQw || this.gQw == 0) && !wr(logInfo.message)) {
                    linkedList.add(logInfo);
                }
                i = i2 + 1;
            }
            if (!linkedList.isEmpty()) {
                com.tencent.mm.bu.a.ab(new 9(this, linkedList));
            }
        }
    }

    private boolean wr(String str) {
        return !bi.oW(this.gQx) && (str == null || !str.toLowerCase().contains(this.gQx.toLowerCase()));
    }
}
