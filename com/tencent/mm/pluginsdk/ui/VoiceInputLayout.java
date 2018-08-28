package com.tencent.mm.pluginsdk.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.modelvoiceaddr.f;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Set;

public abstract class VoiceInputLayout extends LinearLayout {
    private final al erD = new al(new 4(this), true);
    ag giD = new 1(this);
    int qHA = 10000;
    public a qHB;
    private ag qHC = new 3(this);
    public int qHc = 1;
    private b qHw = null;
    private f qHx;
    protected boolean qHy = false;
    int qHz = 3000;

    public interface a {
        void cdE();
    }

    public interface b {
        void ag(int i, int i2, int i3);

        void b(String[] strArr, Set<String> set);

        void cdF();

        void cdG();

        void cdH();

        void cdI();

        void cdJ();
    }

    public abstract void BV(int i);

    public abstract void cN(boolean z);

    public abstract void cdB();

    public abstract void onReset();

    public void setLongClickLisnter(a aVar) {
        this.qHB = aVar;
    }

    public void setVoiceDetectListener(b bVar) {
        this.qHw = bVar;
    }

    public void setFromFullScreen(boolean z) {
        this.qHy = z;
    }

    @TargetApi(11)
    public VoiceInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public VoiceInputLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void cdC() {
        if (com.tencent.mm.p.a.by(getContext()) || com.tencent.mm.p.a.bw(getContext())) {
            x.d("MicroMsg.VoiceInputLayout", "voip is running, cann't record voice");
            onReset();
            return;
        }
        x.d("MicroMsg.VoiceInputLayout", "summerper checkPermission checkMicrophone[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.bj(getContext(), "android.permission.RECORD_AUDIO"))});
        if (com.tencent.mm.pluginsdk.permission.a.bj(getContext(), "android.permission.RECORD_AUDIO")) {
            x.d("MicroMsg.VoiceInputLayout", "doStart currentState = %s", new Object[]{Integer.valueOf(this.qHc)});
            if (this.qHc == 1) {
                this.qHc = 2;
                if (this.qHw != null) {
                    this.qHw.cdF();
                }
                this.erD.J(50, 50);
                cdB();
                this.qHx = new f(new 2(this));
                f fVar = this.qHx;
                x.i("MicroMsg.SceneVoiceInputAddr", "start record");
                e.b(new com.tencent.mm.modelvoiceaddr.f.a(fVar, (byte) 0), "SceneVoiceInputAddr_record", 10);
            }
        } else if (getContext() instanceof Activity) {
            com.tencent.mm.pluginsdk.permission.a.g((Activity) getContext(), "android.permission.RECORD_AUDIO");
        }
    }

    public final void Uh() {
        x.d("MicroMsg.VoiceInputLayout", "doCancel. state = %s", new Object[]{Integer.valueOf(this.qHc)});
        if (this.qHc != 1) {
            this.qHc = 1;
            if (this.qHw != null) {
                this.qHw.cdH();
            }
            if (this.qHx != null) {
                this.qHx.an(true);
            }
            onReset();
        }
    }

    public final void bs() {
        x.d("MicroMsg.VoiceInputLayout", "do Stop. currentState = %s", new Object[]{Integer.valueOf(this.qHc)});
        if (this.qHc != 1 && this.qHc == 2) {
            this.qHc = 3;
            if (this.qHw != null) {
                this.qHw.cdG();
            }
            if (this.erD != null) {
                this.erD.SO();
            }
            this.giD.removeMessages(0);
            this.giD.sendEmptyMessageDelayed(0, (long) this.qHz);
            this.giD.sendEmptyMessageDelayed(1, (long) this.qHA);
            cN(true);
            if (this.qHx != null) {
                this.qHx.aJ(true);
            }
        }
    }

    public final void cdD() {
        af(12, -1, -1);
    }

    public final void af(int i, int i2, int i3) {
        x.d("MicroMsg.VoiceInputLayout", "doNetworkError localerrorType:%s,errorType:%s,errCode:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        this.qHc = 1;
        onReset();
        if (this.qHw != null) {
            this.qHw.ag(i, i2, i3);
        }
    }

    public final void reset(boolean z) {
        x.d("MicroMsg.VoiceInputLayout", "reset currentState %s", new Object[]{Integer.valueOf(this.qHc)});
        if (this.qHc != 1) {
            this.qHc = 1;
            onReset();
            if (z && this.qHw != null) {
                this.qHw.cdI();
            }
        }
    }

    public int getCurrentState() {
        return this.qHc;
    }
}
