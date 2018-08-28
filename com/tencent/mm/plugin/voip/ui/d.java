package com.tencent.mm.plugin.voip.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public abstract class d extends Fragment {
    protected static int mScreenHeight;
    protected static int mScreenWidth;
    protected static final int[] oQq = new int[]{-1, R.l.voip_one_dot, R.l.voip_two_dot, R.l.voip_three_dot};
    static int oQv = -1;
    protected String cYO;
    protected ag guJ;
    protected int mStatus = -1;
    protected boolean oLU;
    protected WeakReference<c> oQd;
    protected long oQe = -1;
    protected RelativeLayout oQr;
    protected ImageView oQs;
    protected ImageView oQt;
    protected int oQu = 4096;
    protected d oQw;
    protected c oQx = new c();
    private a oQy;
    private b oQz;

    public class b implements Runnable {
        public final void run() {
            x.i("MicroMsg.VoipBaseFragment", "try create blur bitmap,timestamp: " + System.currentTimeMillis());
            Bitmap CV = c.CV(R.g.voip_video_called_blur_background);
            x.i("MicroMsg.VoipBaseFragment", "blur transparent ok, timestamp: " + System.currentTimeMillis());
            d.this.guJ.post(new 1(this, CV));
        }
    }

    public interface d {
        void H(boolean z, boolean z2);
    }

    protected abstract void OH(String str);

    public abstract void a(CaptureView captureView);

    public abstract void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6);

    public abstract void bKB();

    protected abstract void bLF();

    protected abstract void bLG();

    public abstract void c(int i, int i2, int[] iArr);

    protected abstract void co(String str, int i);

    public abstract void setHWDecMode(int i);

    public abstract void setMute(boolean z);

    public abstract void yN(int i);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.cYO = arguments.getString("key_username");
        this.oLU = arguments.getBoolean("key_isoutcall");
        if (-1 == this.mStatus) {
            this.mStatus = arguments.getInt("key_status");
        }
        this.guJ = new ag();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Display defaultDisplay;
        if (VERSION.SDK_INT >= 23) {
            defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            mScreenWidth = displayMetrics.widthPixels;
            mScreenHeight = displayMetrics.heightPixels;
        } else if (mScreenWidth == 0) {
            defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            mScreenWidth = defaultDisplay.getWidth();
            mScreenHeight = defaultDisplay.getHeight();
        }
    }

    public void dQ(int i, int i2) {
        x.l("MicroMsg.VoipBaseFragment", "newState: " + com.tencent.mm.plugin.voip.b.b.yR(i2) + ", action: " + com.tencent.mm.plugin.voip.b.b.yR(i) + ", lastStatus: " + com.tencent.mm.plugin.voip.b.b.yR(oQv), new Object[0]);
        if (!(oQv == this.mStatus || i2 == this.mStatus)) {
            oQv = this.mStatus;
        }
        this.oQu = i;
        this.mStatus = i2;
    }

    public final void fw(long j) {
        this.oQe = j;
    }

    public void uninit() {
        x.d("MicroMsg.VoipBaseFragment", "uninit");
        this.oQx.bLJ();
        c cVar = this.oQx;
        x.d("MicroMsg.DynamicTextWrap", "uninit");
        cVar.bLJ();
        cVar.eOf = null;
        if (this.oQy != null) {
            e.remove(this.oQy);
            this.oQy = null;
        }
        if (this.oQz != null) {
            e.remove(this.oQz);
            this.oQz = null;
        }
    }

    public void onDetach() {
        if (this.guJ != null) {
            this.guJ.removeCallbacksAndMessages(null);
        }
        this.oQw = null;
        super.onDetach();
    }

    public final void setVoipUIListener(c cVar) {
        this.oQd = new WeakReference(cVar);
    }

    public final void a(d dVar) {
        this.oQw = dVar;
    }

    protected final void c(TextView textView, String str) {
        if (textView == null || bi.oW(str)) {
            x.e("MicroMsg.VoipBaseFragment", "TextView is null or text is null");
            return;
        }
        textView.setText(str);
        textView.measure(MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, Integer.MIN_VALUE));
        textView.setWidth(textView.getMeasuredWidth());
    }

    public void onStop() {
        super.onStop();
    }

    protected final void bLH() {
        if (this.cYO != null && this.oQs.getVisibility() != 0) {
            this.oQs.setVisibility(0);
            this.oQy = new a(this);
            e.post(this.oQy, "VoipBaseFragment_blurbitmap");
        }
    }

    protected final void bLI() {
        this.oQt.setVisibility(0);
        this.oQz = new b();
        e.post(this.oQz, "VoipBaseFragment_blurtransparentbitmap");
    }

    protected static String bx(long j) {
        return String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)});
    }

    protected static void H(View view, int i) {
        if (view != null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.topMargin += i;
            view.setLayoutParams(layoutParams);
        }
    }
}
