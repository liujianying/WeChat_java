package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.i;

public abstract class a extends i implements o {
    private Bundle nSa;
    private boolean tfN;
    private boolean tfO;
    private boolean tfP;
    private boolean tfQ;
    protected boolean tfR = false;
    protected boolean tfS = false;
    protected boolean tfT;

    protected abstract void coA();

    protected abstract void coB();

    protected abstract void coC();

    protected abstract void coD();

    protected abstract void coy();

    protected abstract void coz();

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.nSa = bundle;
        this.tfO = true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void onResume() {
        super.onResume();
        coI();
        LauncherUI cpQ = LauncherUI.cpQ();
        if (cpQ != null && cpQ.tkr) {
            this.tfR = true;
            if (this.tfS) {
                coK();
                this.tfS = false;
            }
        }
    }

    public final void coH() {
        coF();
        this.tfP = true;
    }

    public final void coK() {
        if (this.tfR) {
            if (this.tfO) {
                coy();
                this.tfO = false;
            } else if (this.tfN) {
                coD();
                coy();
                x.v("MicroMsg.INIT", "KEVIN tab onRecreate ");
                this.tfN = false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.tfP) {
                coG();
                this.tfP = false;
            }
            if (!this.tDd) {
                int Ys = Ys();
                if (Ys != -1) {
                    this.tCL.addPreferencesFromResource(Ys);
                    this.tDd = true;
                }
            }
            coz();
            x.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - currentTimeMillis));
            this.tfQ = true;
            this.tfR = false;
        }
    }

    public final void coJ() {
        this.tfS = true;
    }

    public void onPause() {
        super.onPause();
        this.tfT = true;
        if (!this.tfT) {
            return;
        }
        if (this.tfQ) {
            long currentTimeMillis = System.currentTimeMillis();
            coB();
            x.d("MicroMsg.INIT", "KEVIN " + toString() + " onTabPause last : " + (System.currentTimeMillis() - currentTimeMillis));
            this.tfQ = false;
            this.tfT = false;
            return;
        }
        this.tfT = false;
    }

    public void onStop() {
        super.onStop();
        coC();
    }

    public void onStart() {
        super.onStart();
        LauncherUI cpQ = LauncherUI.cpQ();
        if (cpQ != null && cpQ.tkr) {
            coA();
        }
    }

    public void onDestroy() {
        coD();
        super.onDestroy();
    }
}
