package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.ar.d;
import com.tencent.mm.bp.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public class ChattingAnimFrame extends FrameLayout {
    private static String ify = "";
    private int aaG;
    private int aaH;
    private int mScreenHeight = a.fl(getContext());
    private int sKa = 40;
    List<MMAnimateView> tIj = new ArrayList();
    private int tIk = 30;
    private int tIl = 30;
    private boolean tIm = false;
    private int tIn = 0;
    private ArrayList<Integer> tIo = new ArrayList();

    static /* synthetic */ long EL(int i) {
        switch (i) {
            case 2:
                return 1200;
            case 3:
                return 1500;
            default:
                return (long) ((int) E(4000.0f, 6000.0f));
        }
    }

    private static String getDataEmojiPath() {
        if (bi.oW(ify)) {
            ify = e.duO.replace("/data/user/0", "/data/data");
            ify += "/emoji";
        }
        return ify;
    }

    public ChattingAnimFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.aaH = getMeasuredHeight();
        this.aaG = getMeasuredWidth();
        x.d("MicroMsg.ChattingAnimFrame", "onFinishInflate width:%d height:%d", new Object[]{Integer.valueOf(this.aaG), Integer.valueOf(this.aaH)});
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.aaH = i4 - i2;
        this.aaG = i3 - i;
        if (this.aaH < this.mScreenHeight) {
            this.tIm = true;
            this.tIn = this.mScreenHeight - this.aaH;
        } else {
            this.tIm = false;
            this.tIn = 0;
        }
        x.d("MicroMsg.ChattingAnimFrame", "onLayout width:%d height:%d isKeyBordUp:%b keyBordHeight:%d", new Object[]{Integer.valueOf(this.aaG), Integer.valueOf(this.aaH), Boolean.valueOf(this.tIm), Integer.valueOf(this.tIn)});
    }

    public final void a(d dVar) {
        stop();
        if (dVar == null) {
            x.w("MicroMsg.ChattingAnimFrame", "egg info is null. ignore.");
            return;
        }
        String str = getDataEmojiPath() + "/egg/" + dVar.ecE;
        if (com.tencent.mm.a.e.cn(str)) {
            setVisibility(0);
            if (dVar.ecG > 0) {
                this.tIk = dVar.ecG;
                if (this.tIk > 60) {
                    this.tIk = 60;
                }
            } else {
                this.tIk = 30;
            }
            if (dVar.ecH > 0) {
                this.tIl = dVar.ecH;
            } else {
                this.tIl = 30;
            }
            if (dVar.maxSize > 0) {
                this.sKa = dVar.maxSize;
            } else {
                this.sKa = 40;
            }
            x.i("MicroMsg.ChattingAnimFrame", "Egg viewCount:%d minSize:%d maxSize:%d AnimType:%d reportType:%d", new Object[]{Integer.valueOf(this.tIk), Integer.valueOf(this.tIl), Integer.valueOf(this.sKa), Integer.valueOf(dVar.ecF), Integer.valueOf(dVar.ecA)});
            long j = 0;
            EK(this.tIk);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.tIk) {
                    int fromDPToPix = a.fromDPToPix(getContext(), (int) E((float) this.tIl, (float) this.sKa));
                    int i3 = dVar.ecF;
                    boolean z = this.tIo != null && this.tIo.contains(Integer.valueOf(i2));
                    c cVar = new c(this, i3, fromDPToPix, j, z);
                    MMAnimateView mMAnimateView = new MMAnimateView(getContext());
                    mMAnimateView.setImageFilePath(str);
                    mMAnimateView.setAnimation(cVar);
                    mMAnimateView.setLayerType(2, null);
                    cVar.tIy = mMAnimateView;
                    mMAnimateView.setLayoutParams(new LayoutParams(cVar.fi, cVar.fi));
                    this.tIj.add(mMAnimateView);
                    addView(mMAnimateView);
                    i = dVar.ecF;
                    int i4 = this.tIk;
                    switch (i) {
                        case 2:
                            j = i2 < 2 ? 800 + j : ((long) (((Math.abs((((double) i2) - (((double) i4) * 0.5d)) - 5.0d) / ((double) (i4 * 3))) + 0.01d) * 1000.0d)) + j;
                            break;
                        case 3:
                            j += (long) (((Math.abs((((double) i2) - (((double) i4) * 0.5d)) - 5.0d) / ((double) (i4 * 6))) + 0.06d) * 1000.0d);
                            break;
                        default:
                            j = (long) ((int) (E(0.0f, 4.0f) * 1000.0f));
                            break;
                    }
                    i = i2 + 1;
                } else if (this.tIj != null) {
                    for (View view : this.tIj) {
                        if (view != null && (view.getAnimation() instanceof c)) {
                            c.a((c) view.getAnimation());
                        }
                    }
                    return;
                } else {
                    return;
                }
            }
        }
        x.w("MicroMsg.ChattingAnimFrame", "egg file isn't exist. ignore");
    }

    private void EK(int i) {
        if (i <= 0) {
            x.w("MicroMsg.ChattingAnimFrame", "count is zero.");
            return;
        }
        int i2 = (int) (((double) i) * 0.1d);
        if (this.tIo != null) {
            this.tIo.clear();
        } else {
            this.tIo = new ArrayList();
        }
        while (this.tIo.size() < i2) {
            int E = (int) E(0.0f, (float) i);
            if (!this.tIo.contains(Integer.valueOf(E))) {
                this.tIo.add(Integer.valueOf(E));
            }
        }
    }

    public final void stop() {
        for (MMAnimateView mMAnimateView : this.tIj) {
            mMAnimateView.clearAnimation();
            mMAnimateView.recycle();
        }
        removeAllViews();
    }

    static float E(float f, float f2) {
        return (((float) Math.random()) * (f2 - f)) + f;
    }
}
