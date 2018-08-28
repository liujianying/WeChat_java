package com.tencent.mm.plugin.facedetect.d;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a$e;
import com.tencent.mm.plugin.facedetect.a.c;
import com.tencent.mm.plugin.facedetect.a.f;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.d.a.b;
import com.tencent.mm.plugin.facedetect.d.b.a;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.views.FaceNumberItemView;
import com.tencent.mm.plugin.facedetect.views.FaceNumberView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d implements b {
    boolean hxu;
    private b iOA;
    boolean iOL;
    private String iOZ;
    private int iPa;
    a iPb;
    String[] iPc;
    int iPd;
    int iPe;
    private FaceNumberView iPf;
    private long iPg;
    private long iPh;
    boolean iPi;
    boolean iPj;
    boolean iPk;
    boolean iPl;
    private Animation iPm;
    private Animation iPn;
    private AnimationSet iPo;
    private Animation iPp;
    final Object iPq;
    boolean iPr;
    a iPs;
    ag iPt;
    private CountDownTimer iPu;
    Runnable iPw;
    private View idE;

    public d(String str) {
        this.iOZ = null;
        this.iPa = 0;
        this.iPb = null;
        this.iPc = null;
        this.iPd = 0;
        this.iPe = 0;
        this.idE = null;
        this.iPf = null;
        this.iOL = false;
        this.iPg = -1;
        this.iPh = -1;
        this.iPi = false;
        this.iPj = false;
        this.iPk = false;
        this.iPl = false;
        this.iPq = new Object();
        this.hxu = false;
        this.iPr = false;
        this.iPs = null;
        this.iPt = new 1(this, Looper.getMainLooper());
        this.iPu = new 2(this);
        this.iPw = new 3(this);
        this.iOA = new 9(this);
        this.iPb = new a();
        this.iPb.iOA = this.iOA;
        this.iPm = AnimationUtils.loadAnimation(ad.getContext(), com.tencent.mm.plugin.facedetect.a.a.slide_right_in);
        this.iPn = AnimationUtils.loadAnimation(ad.getContext(), com.tencent.mm.plugin.facedetect.a.a.face_slide_left_out);
        this.iPp = AnimationUtils.loadAnimation(ad.getContext(), com.tencent.mm.plugin.facedetect.a.a.fast_faded_in);
        this.iPp.setDuration(250);
        this.iPp.setFillAfter(true);
        this.iOZ = str;
        this.iPa = this.iOZ == null ? 0 : this.iOZ.length();
        aKj();
        if (aKi()) {
            this.iPo = (AnimationSet) AnimationUtils.loadAnimation(ad.getContext(), com.tencent.mm.plugin.facedetect.a.a.face_title_scale_multi);
        } else {
            this.iPo = (AnimationSet) AnimationUtils.loadAnimation(ad.getContext(), com.tencent.mm.plugin.facedetect.a.a.face_title_scale_single);
        }
        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) ad.getResources().getDimensionPixelSize(c.face_hint_msg_tv_anim_distance));
        translateAnimation.setDuration((long) ad.getContext().getResources().getInteger(f.scaleAnimDuration));
        this.iPo.addAnimation(translateAnimation);
        x.i("MicroMsg.NumberFaceMotion", "hy: starting read number: %s", this.iOZ);
    }

    private boolean aKi() {
        return this.iPa >= 6;
    }

    private void aKj() {
        int i = 0;
        if (bi.oW(this.iOZ) || !aKi()) {
            this.iPc = new String[1];
            this.iPc[0] = this.iOZ;
            return;
        }
        x.i("MicroMsg.NumberFaceMotion", "hy: data too long. need to split into %d rounds", Integer.valueOf(2));
        this.iPc = new String[2];
        int i2 = this.iPa / 2;
        while (i < 2) {
            this.iPc[i] = this.iOZ.substring(i2 * i, (i + 1) * i2);
            i++;
        }
    }

    public final boolean aKc() {
        return this.iOL;
    }

    private TextView aKh() {
        if (this.idE != null) {
            return (TextView) this.idE.findViewById(a$e.hint_msg_tv);
        }
        return null;
    }

    public final void a(Context context, ViewGroup viewGroup, ViewGroup viewGroup2) {
        x.d("MicroMsg.NumberFaceMotion", "hy: on number init motion");
        this.idE = LayoutInflater.from(context).inflate(g.face_hint_number, viewGroup2);
        this.iPf = (FaceNumberView) this.idE.findViewById(a$e.face_text_number);
        cy(this.iPc.length, -1);
        aKh().startAnimation(this.iPm);
        if (this.iPf != null) {
            this.iPf.setVisibility(0);
            this.iPf.startAnimation(this.iPm);
            this.iPd = 0;
            eK(false);
            this.iPe = -1;
            aKk();
            this.iPg = bi.VG();
            this.iPh = bi.VG();
            this.hxu = false;
        }
    }

    private static String pB(int i) {
        switch (i) {
            case 1:
                return ad.getContext().getString(h.face_number_hint_1);
            case 2:
                return ad.getContext().getString(h.face_number_hint_2);
            case 3:
                return ad.getContext().getString(h.face_number_hint_3);
            case 4:
                return ad.getContext().getString(h.face_number_hint_4);
            default:
                x.e("MicroMsg.NumberFaceMotion", "hy: unknown length!!");
                return "";
        }
    }

    private void cy(int i, int i2) {
        x.i("MicroMsg.NumberFaceMotion", "alvinluo groupIndex: %d, itemDataLength: %d", Integer.valueOf(i2), Integer.valueOf(i));
        if (aKh() == null) {
            return;
        }
        if (i == 1) {
            aKh().setText(ad.getContext().getString(h.face_number_msg_single));
            return;
        }
        CharSequence string;
        TextView aKh = aKh();
        if (i2 == -1) {
            String string2;
            Context context = ad.getContext();
            int i3 = h.face_number_msg_first;
            Object[] objArr = new Object[1];
            switch (i) {
                case 2:
                    string2 = ad.getContext().getString(h.face_number_hint_2nd);
                    break;
                default:
                    string2 = pB(i);
                    break;
            }
            objArr[0] = string2;
            string = context.getString(i3, objArr);
        } else {
            string = ad.getContext().getString(h.face_number_msg, new Object[]{pB(this.iPd + 1)});
        }
        aKh.setText(string);
        if (i2 > 0) {
            x.i("MicroMsg.NumberFaceMotion", "alvinluo start %d group number", Integer.valueOf(i2 + 1));
            com.tencent.mm.plugin.facedetect.model.g gVar = com.tencent.mm.plugin.facedetect.model.f.iNu.iNv.iPA;
            if (gVar.iNy == null) {
                x.e("MicroMsg.FaceDetectNativeManager", "hy: startRecord not init");
            } else {
                gVar.iNy.engineGroupChange();
            }
        }
    }

    final void eK(boolean z) {
        if (this.iPf != null) {
            cy(this.iPc.length, this.iPd);
            this.iPf.setNumberLengthAndInflate(this.iPc[this.iPd].length());
            this.iPl = false;
            if (z) {
                this.iPm.setAnimationListener(new 4(this));
                if (this.idE != null) {
                    this.idE.startAnimation(this.iPm);
                    return;
                }
                return;
            }
            ah.i(new 5(this), 500);
        }
    }

    final void aKk() {
        if (this.iPf == null) {
            return;
        }
        if (this.iPd >= 0) {
            this.iPf.AY(this.iPc[this.iPd].substring(0, this.iPe + 1));
        } else {
            this.iPf.AY(null);
        }
    }

    public final boolean aKd() {
        this.iPj = true;
        return this.iPr;
    }

    public final boolean a(FaceCharacteristicsResult faceCharacteristicsResult) {
        this.iPj = true;
        return this.iPr;
    }

    public final boolean b(FaceCharacteristicsResult faceCharacteristicsResult) {
        this.iPj = false;
        return this.iPr;
    }

    public final void aKe() {
        this.hxu = true;
        this.iPr = false;
        a aVar = this.iPb;
        aVar.iOB = true;
        x.i("MicroMsg.FaceVoiceRecordLogic", "hy: face start reset");
        synchronized (aVar) {
            if (aVar.bDp != null) {
                aVar.bDp.we();
                aVar.bDp = null;
            }
            if (aVar.eqz != null) {
                aVar.eqz.wA();
                aVar.eqz = null;
            }
            if (aVar.eqF != null) {
                try {
                    aVar.eqF.release();
                    aVar.eqF = null;
                    aVar.erb = true;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.FaceVoiceRecordLogic", e, "mVoiceSilentDetectAPI.release error", new Object[0]);
                }
            }
            aVar.equ = 0;
        }
        a aVar2 = this.iPb;
        x.i("MicroMsg.FaceVoiceRecordLogic", "hy: recycling voice.");
        aVar2.iOA = null;
        this.iPb.aKa();
        if (com.tencent.mm.plugin.facedetect.e.a.aKA().iSn && com.tencent.mm.plugin.facedetect.e.a.aKA().isStarted()) {
            this.iPb.iOD.remove(com.tencent.mm.plugin.facedetect.e.a.aKA().aKB());
            if (this.iOL) {
                com.tencent.mm.plugin.facedetect.e.a.aKA().a(null);
            } else {
                com.tencent.mm.plugin.facedetect.e.a.aKA().aKC();
            }
        }
        this.iPu.cancel();
        this.iPt.removeCallbacksAndMessages(null);
        if (this.iPf != null) {
            FaceNumberView faceNumberView = this.iPf;
            if (faceNumberView.iUq != null && faceNumberView.iUq.length > 0) {
                for (FaceNumberItemView aKM : faceNumberView.iUq) {
                    aKM.aKM();
                }
            }
        }
        if (this.idE != null) {
            this.iOL = false;
            this.iPg = -1;
            this.idE = null;
            this.iPf = null;
        }
    }

    public final b.b aKf() {
        return new b.b(90004, "user cancelled in processing");
    }

    public final a aKg() {
        return this.iPs;
    }

    final void aKl() {
        this.iPu.start();
    }
}
