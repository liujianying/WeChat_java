package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.view.View;
import com.tencent.mm.R;
import java.lang.reflect.Array;

public class a {
    protected View hmt;
    protected boolean isAnimating;
    protected int lvk;
    protected int qeT;
    protected int qeU;
    protected int qeV;
    protected int qeW;
    protected View qeX;
    protected View qeY;
    protected View qeZ;
    protected View qfa;
    protected View qfb;
    protected View qfc;
    protected View qfd;
    protected View qfe;
    protected float[][] qff;
    protected int qfg = b.qfq;
    protected a qfh;
    protected AnimatorUpdateListener qfi = new 3(this);
    protected AnimatorUpdateListener qfj = new 4(this);
    protected AnimatorUpdateListener qfk = new 5(this);
    protected AnimatorUpdateListener qfl = new 6(this);

    public enum b {
        ;

        public static int[] bXF() {
            return (int[]) qfs.clone();
        }

        static {
            qfq = 1;
            qfr = 2;
            qfs = new int[]{qfq, qfr};
        }
    }

    public a(Context context, View view, View view2, View view3, View view4, View view5, View view6, View view7, View view8, View view9) {
        this.qeT = com.tencent.mm.bp.a.fromDPToPix(context, 48) / 2;
        this.lvk = (int) context.getResources().getDimension(R.f.sos_search_edittext_margin);
        this.qff = (float[][]) Array.newInstance(Float.TYPE, new int[]{3, 2});
        this.qeX = view;
        this.qeY = view2;
        this.qeZ = view3;
        this.qfa = view4;
        this.qfb = view5;
        this.hmt = view6;
        this.qfc = view7;
        this.qfd = view8;
        this.qfe = view9;
        this.qeX.post(new 1(this, view));
        this.qfd.post(new 2(this, view8));
    }

    public final void AX(int i) {
        this.qff[0][0] = (float) i;
    }

    public final void AY(int i) {
        this.qfg = i;
    }

    public void AZ(int i) {
        if (i != this.qfg) {
            switch (7.qfp[i - 1]) {
                case 1:
                    bXC();
                    break;
                case 2:
                    bXD();
                    break;
            }
            this.qfg = i;
        }
    }

    protected void bXC() {
    }

    protected void bXD() {
    }

    public final void a(a aVar) {
        this.qfh = aVar;
    }

    protected boolean bXE() {
        return true;
    }
}
