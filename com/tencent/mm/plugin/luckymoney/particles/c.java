package com.tencent.mm.plugin.luckymoney.particles;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.tencent.mm.plugin.luckymoney.particles.a.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public final class c {
    ValueAnimator gGc;
    private final b kRS;
    private final d kRT;
    final ViewGroup kRU;
    final ConfettiView kRV;
    final Queue<b> kRW;
    final List<b> kRX;
    long kRY;
    int kRZ;
    public float kSA;
    public float kSB;
    long kSa;
    float kSb;
    float kSc;
    public Interpolator kSd;
    private Rect kSe;
    private float kSf;
    private float kSg;
    private float kSh;
    private float kSi;
    private float kSj;
    private float kSk;
    private float kSl;
    private float kSm;
    private Float kSn;
    private Float kSo;
    private Float kSp;
    private Float kSq;
    private int kSr;
    private int kSs;
    private float kSt;
    private float kSu;
    private float kSv;
    private float kSw;
    private Float kSx;
    private Float kSy;
    private long kSz;
    final Random random;

    public c(Context context, b bVar, d dVar, ViewGroup viewGroup) {
        this(bVar, dVar, viewGroup, ConfettiView.dN(context));
    }

    private c(b bVar, d dVar, ViewGroup viewGroup, ConfettiView confettiView) {
        this.random = new Random();
        this.kRW = new LinkedList();
        this.kRX = new ArrayList(300);
        this.kRS = bVar;
        this.kRT = dVar;
        this.kRU = viewGroup;
        this.kRV = confettiView;
        this.kRV.kRX = this.kRX;
        this.kRV.addOnAttachStateChangeListener(new 1(this));
        this.kSz = -1;
        this.kSe = new Rect(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
    }

    public final c I(float f, float f2) {
        this.kSf = f / 1000.0f;
        this.kSg = f2 / 1000.0f;
        return this;
    }

    public final c J(float f, float f2) {
        this.kSh = f / 1000.0f;
        this.kSi = f2 / 1000.0f;
        return this;
    }

    public final c al(float f) {
        this.kSj = f / 1000000.0f;
        this.kSk = 0.0f;
        return this;
    }

    public final c am(float f) {
        this.kSl = f / 1000000.0f;
        this.kSm = 0.0f;
        return this;
    }

    public final c bbb() {
        this.kSr = 180;
        this.kSs = 180;
        return this;
    }

    public final c bbc() {
        this.kSv = 3.6E-4f;
        this.kSw = 1.8E-4f;
        return this;
    }

    public final c bbd() {
        this.kSx = Float.valueOf(0.36f);
        this.kSy = Float.valueOf(0.0f);
        return this;
    }

    public final void bbe() {
        if (this.gGc != null) {
            this.gGc.cancel();
        }
        this.kRV.bbe();
    }

    final void A(int i, long j) {
        for (int i2 = 0; i2 < i; i2++) {
            b bVar = (b) this.kRW.poll();
            if (bVar == null) {
                bVar = this.kRS.b(this.random);
            }
            d dVar = this.kRT;
            Random random = this.random;
            bVar.kSO = 0;
            bVar.kSQ = 0.0f;
            bVar.kSP = 0.0f;
            bVar.kSS = 0.0f;
            bVar.kSR = 0.0f;
            bVar.kSl = 0.0f;
            bVar.kSj = 0.0f;
            bVar.kSp = null;
            bVar.kSn = null;
            bVar.kSU = null;
            bVar.kST = null;
            bVar.kSV = 0.0f;
            bVar.kSW = 0.0f;
            bVar.kSv = 0.0f;
            bVar.kSx = null;
            bVar.kSX = null;
            bVar.kSz = 0;
            bVar.kSY = 0.0f;
            bVar.kSZ = 0.0f;
            bVar.kSd = null;
            bVar.kTb = 0.0f;
            bVar.kTa = 0.0f;
            bVar.kTc = 0.0f;
            bVar.alpha = 255;
            bVar.kTd = false;
            bVar.terminated = false;
            bVar.kSO = j;
            bVar.kSP = (random.nextFloat() * ((float) (dVar.kSF - dVar.kSD))) + ((float) dVar.kSD);
            bVar.kSQ = (((float) (dVar.kSG - dVar.kSE)) * random.nextFloat()) + ((float) dVar.kSE);
            bVar.kSR = a(this.kSf, this.kSg, random);
            bVar.kSS = a(this.kSh, this.kSi, random);
            bVar.kSj = a(this.kSj, this.kSk, random);
            bVar.kSl = a(this.kSl, this.kSm, random);
            bVar.kSn = this.kSn == null ? null : Float.valueOf(a(this.kSn.floatValue(), this.kSo.floatValue(), random));
            bVar.kSp = this.kSp == null ? null : Float.valueOf(a(this.kSp.floatValue(), this.kSq.floatValue(), random));
            bVar.kSV = a((float) this.kSr, (float) this.kSs, random);
            bVar.kSW = a(this.kSt, this.kSu, random);
            bVar.kSv = a(this.kSv, this.kSw, random);
            bVar.kSx = this.kSx == null ? null : Float.valueOf(a(this.kSx.floatValue(), this.kSy.floatValue(), random));
            bVar.kSz = this.kSz;
            bVar.kSd = this.kSd;
            bVar.kSY = a(this.kSA, this.kSB, random);
            bVar.i(this.kSe);
            this.kRX.add(bVar);
        }
    }

    private static float a(float f, float f2, Random random) {
        return (((random.nextFloat() * 2.0f) - 1.0f) * f2) + f;
    }
}
