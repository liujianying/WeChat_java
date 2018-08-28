package com.tencent.mm.plugin.facedetect.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a$d;
import com.tencent.mm.plugin.facedetect.a$h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public final class a {
    static c iQn = new c();
    RelativeLayout iQc = null;
    Button iQd = null;
    ImageView iQe = null;
    TextView iQf = null;
    TextView iQg = null;
    Button iQh = null;
    Button iQi = null;
    TextView iQj = null;
    Animation iQk = null;
    Animation iQl = null;
    WeakReference<FaceDetectPrepareUI> iQm = null;

    a(FaceDetectPrepareUI faceDetectPrepareUI) {
        this.iQm = new WeakReference(faceDetectPrepareUI);
    }

    public final void dismiss() {
        iQn.cancel();
        if (this.iQc.getVisibility() == 0) {
            ah.A(new 1(this));
        }
    }

    public final void z(Bitmap bitmap) {
        this.iQc.setBackgroundDrawable(new BitmapDrawable(bitmap));
    }

    public final void a(b bVar) {
        if (iQn != null) {
            iQn.cancel();
        }
        if (bVar != null) {
            x.i("MicroMsg.FaceDetectJumper", "hy: request show conf: %s", new Object[]{bVar.toString()});
            if (bVar.iQu) {
                this.iQh.setVisibility(0);
                this.iQh.setText(bVar.iQD);
                this.iQh.setOnClickListener(bVar.iQK);
            } else {
                this.iQh.setVisibility(4);
            }
            if (bVar.iQr) {
                this.iQd.setVisibility(0);
                this.iQd.setText(bVar.iQB);
                this.iQd.setOnClickListener(bVar.iQH);
            } else {
                this.iQd.setVisibility(4);
            }
            if (bVar.iQv) {
                this.iQi.setVisibility(0);
                this.iQi.setText(bVar.iQC);
                this.iQi.setOnClickListener(bVar.iQI);
            } else {
                this.iQi.setVisibility(4);
            }
            if (bVar.iQs) {
                this.iQf.setVisibility(0);
                if (bVar.iQw) {
                    this.iQg.setVisibility(0);
                    int i = bVar.iQy;
                    CharSequence charSequence = bVar.iQA;
                    if (bi.oW(charSequence) || i >= charSequence.length() || i < 0) {
                        x.e("MicroMsg.FaceDetectJumper", "hy: invalid showing one by one");
                        this.iQf.setText(charSequence);
                        this.iQg.setText("");
                    } else {
                        iQn.cancel();
                        c cVar = iQn;
                        WeakReference weakReference = new WeakReference(this.iQf);
                        WeakReference weakReference2 = new WeakReference(this.iQg);
                        cVar.iQN = charSequence;
                        cVar.iQO = i;
                        cVar.iQL = weakReference;
                        cVar.iQM = weakReference2;
                        iQn.start();
                    }
                } else {
                    this.iQg.setVisibility(4);
                    this.iQf.setText(bVar.iQA);
                }
            } else {
                this.iQf.setVisibility(4);
                this.iQg.setVisibility(4);
            }
            if (bVar.iQt) {
                this.iQe.setVisibility(0);
                this.iQe.setImageResource(bVar.iQE);
            } else {
                this.iQe.setVisibility(4);
            }
            if (bVar.iQx) {
                this.iQj.setVisibility(0);
                this.iQj.setText(bVar.iQF);
                this.iQj.setOnClickListener(bVar.iQJ);
            } else {
                this.iQj.setVisibility(4);
            }
            if (bVar.iQz != null) {
                this.iQc.setBackgroundDrawable(new BitmapDrawable(bVar.iQz));
            }
            if (this.iQc.getVisibility() != 0) {
                this.iQc.setVisibility(0);
                this.iQc.startAnimation(this.iQk);
                this.iQk.setAnimationListener(new 2(this, bVar));
            }
        }
    }

    public final boolean aKp() {
        return this.iQc.getVisibility() != 8;
    }

    public static b pC(int i) {
        return b(i, null, null, null, null, null);
    }

    public static b a(int i, String str, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return b(i, str, str2, str3, onClickListener, onClickListener2);
    }

    public static b b(int i, String str, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2) {
        boolean z = true;
        b bVar = new b();
        bVar.iQE = i;
        bVar.iQA = str;
        bVar.iQr = str2 != null;
        bVar.iQB = str2;
        bVar.iQv = false;
        bVar.iQC = null;
        if (str3 == null) {
            z = false;
        }
        bVar.iQu = z;
        bVar.iQD = str3;
        bVar.iQx = false;
        bVar.iQF = null;
        bVar.iQH = onClickListener;
        bVar.iQI = null;
        bVar.iQK = onClickListener2;
        bVar.iQJ = null;
        return bVar;
    }

    public static b a(b bVar, String str, OnClickListener onClickListener) {
        bVar.iQx = str != null;
        bVar.iQF = str;
        bVar.iQJ = onClickListener;
        return bVar;
    }

    public static b a(Context context, OnClickListener onClickListener) {
        b a = a(a$d.face_confirm_icon, context.getString(a$h.face_detect_preparing), null, context.getString(a$h.app_cancel), null, onClickListener);
        a.iQw = true;
        a.iQy = context.getString(a$h.face_detect_preparing).length() - 3;
        return a;
    }
}
