package com.tencent.mm.plugin.facedetect.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a$a;
import com.tencent.mm.plugin.facedetect.a$g;
import com.tencent.mm.plugin.facedetect.a$h;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.d.b.a;
import com.tencent.mm.plugin.facedetect.d.b.b;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Timer;

public final class c implements b {
    private static String TAG = "MicroMsg.NormalFaceMotion";
    private static long iOK = 500;
    private boolean iOL = false;
    private boolean iOM = false;
    private View iON = null;
    private View iOO = null;
    private String iOP;
    private long iOQ;
    private final Object iOR = new Object();
    private Timer iOS = null;
    private volatile boolean iOT = false;
    private Animation iOU;
    private volatile boolean iOV = false;
    private volatile boolean iOW = false;

    public c(String str, long j) {
        this.iOP = str;
        this.iOQ = j;
        this.iOU = AnimationUtils.loadAnimation(ad.getContext(), a$a.slide_right_in);
    }

    public final boolean aKc() {
        return this.iOL && this.iOM;
    }

    public final TextView aKh() {
        if (!this.iOL && this.iON != null) {
            return (TextView) this.iON.findViewById(e.hint_msg_tv);
        }
        if (!this.iOL || this.iOO == null) {
            return null;
        }
        return (TextView) this.iOO.findViewById(e.hint_msg_tv);
    }

    public final void a(Context context, ViewGroup viewGroup, ViewGroup viewGroup2) {
        this.iON = LayoutInflater.from(context).inflate(a$g.face_hint_normal, viewGroup);
        this.iOO = LayoutInflater.from(context).inflate(a$g.face_hint_normal_center, viewGroup2);
        this.iOO.setVisibility(4);
        if (aKh() != null) {
            aKh().setText(this.iOP);
        }
        x.i(TAG, "hy: starting tween timer: tween: %d", new Object[]{Long.valueOf(this.iOQ)});
        if (this.iOS != null) {
            this.iOS.cancel();
        }
        this.iOS = new Timer("FaceDetect_hint", true);
        this.iOT = true;
        this.iOS.scheduleAtFixedRate(new 2(this), 0, r4);
    }

    public final boolean aKd() {
        return false;
    }

    public final boolean a(FaceCharacteristicsResult faceCharacteristicsResult) {
        if (!this.iOL || faceCharacteristicsResult == null || faceCharacteristicsResult.errCode != 18) {
            return false;
        }
        x.d(TAG, "hy: ignore too active");
        return true;
    }

    public final boolean b(FaceCharacteristicsResult faceCharacteristicsResult) {
        if (faceCharacteristicsResult.errCode == -1) {
            this.iOL = true;
            if (!this.iOV) {
                as.I(ad.getContext(), a$h.qrcode_completed);
                TextView textView = (TextView) this.iON.findViewById(e.hint_msg_tv);
                Animation loadAnimation = AnimationUtils.loadAnimation(ad.getContext(), a$a.faded_out);
                Animation loadAnimation2 = AnimationUtils.loadAnimation(ad.getContext(), a$a.fast_faded_in);
                loadAnimation.setDuration(iOK);
                loadAnimation2.setDuration(iOK);
                textView.startAnimation(loadAnimation);
                textView.setVisibility(4);
                this.iOO.setVisibility(0);
                this.iOO.startAnimation(loadAnimation2);
                this.iOO.findViewById(e.face_normal_confirm_btn).setOnClickListener(new 1(this));
                this.iOV = true;
                return true;
            }
        }
        return false;
    }

    public final void aKe() {
        this.iOT = false;
        if (this.iOS != null) {
            this.iOS.cancel();
        }
        this.iOL = false;
        this.iOV = false;
        this.iOW = false;
        this.iOM = false;
    }

    public final b aKf() {
        if (this.iOL) {
            return new b(90025, "user cancelled in intermediate page");
        }
        return new b(90004, "user cancelled in processing");
    }

    public final a aKg() {
        if (!this.iOL || this.iOW) {
            return null;
        }
        this.iOW = true;
        return new a();
    }
}
