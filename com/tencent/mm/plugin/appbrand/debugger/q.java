package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.s.d;
import com.tencent.mm.plugin.appbrand.s.f;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import java.util.Iterator;
import java.util.LinkedList;

public final class q extends FrameLayout {
    ViewGroup ftJ;
    RemoteDebugMoveView ftK;
    private LinkedList<String> ftL = new LinkedList();
    TextView ftM;
    TextView ftN;
    TextView ftO;
    TextView ftP;
    TextView ftQ;
    TextView ftR;
    TextView ftS;
    ImageView ftT;
    ImageView ftU;
    View ftV;
    boolean ftW = false;
    private a ftX;
    private c ftY;
    private h ftb;
    OnClickListener mOnClickListener = new 3(this);

    static /* synthetic */ void a(q qVar, String str) {
        qVar.ftL.add(0, str);
        while (qVar.ftL.size() > 10) {
            qVar.ftL.removeLast();
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = qVar.ftL.iterator();
        while (it.hasNext()) {
            stringBuilder.append((String) it.next());
            stringBuilder.append("\n");
        }
        qVar.ftS.setText(stringBuilder.toString());
        if (qVar.ftW) {
            qVar.ftS.setVisibility(0);
        } else {
            qVar.ftS.setVisibility(8);
        }
    }

    static /* synthetic */ void h(q qVar) {
        if (qVar.ftb.isBusy() || !qVar.ftb.hv()) {
            qVar.ftT.setImageResource(f.app_brand_remote_debug_abnormal_dot);
            qVar.ftM.setText(qVar.getContext().getString(j.app_brand_remote_debug_server_abnormal));
            return;
        }
        qVar.ftT.setImageResource(f.app_brand_remote_debug_normal_dot);
        qVar.ftM.setText(qVar.getContext().getString(j.app_brand_remote_debug_server_normal));
    }

    public q(Context context, h hVar, a aVar) {
        super(context);
        this.ftb = hVar;
        this.ftX = aVar;
        setLayoutParams(new LayoutParams(-1, -1));
        setBackgroundColor(getContext().getResources().getColor(d.transparent));
        setId(g.app_brand_debug_view);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (aeK()) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void bringToFront() {
        if (this.ftJ == null) {
            x.w("MicroMsg.RemoteDebugView", "bringoFront mContentView is null");
        } else {
            this.ftJ.bringChildToFront(this);
        }
    }

    public final void aeJ() {
        ah.A(new 2(this));
    }

    private boolean aeK() {
        if (!(this.ftb.aex() || this.ftb.aey())) {
            if (!(this.ftb.getStatus() == 5)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: aeL */
    final void i() {
        if (this.ftY == null || !this.ftY.isShowing()) {
            this.ftY = h.a(getContext(), getContext().getString(j.app_brand_remote_debug_quit_confirm), "", getContext().getString(j.app_ok), getContext().getString(j.app_cancel), new 4(this), null);
        }
    }

    public final void aeM() {
        ah.A(new 5(this));
    }

    public final void show() {
        if (this.ftW) {
            this.ftV.setVisibility(0);
            if (this.ftL.size() > 0) {
                this.ftS.setVisibility(0);
            } else {
                this.ftS.setVisibility(8);
            }
            this.ftQ.setVisibility(8);
        } else {
            this.ftV.setVisibility(8);
            this.ftS.setVisibility(8);
            this.ftQ.setVisibility(0);
        }
        invalidate();
    }

    public final void aeN() {
        aeJ();
        aeM();
    }

    public final void ss(String str) {
        if (!bi.oW(str)) {
            ah.A(new 9(this, str));
        }
    }
}
