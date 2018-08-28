package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.x;

public abstract class AbstractTabChildActivity$a extends x implements o {
    private Bundle nSa;
    private boolean tfN;
    private boolean tfO;
    private boolean tfP;
    protected boolean tfQ;
    protected boolean tfR = false;
    protected boolean tfS = false;
    protected boolean tfT;
    protected boolean tfU = false;

    public abstract void coA();

    public abstract void coB();

    public abstract void coC();

    public abstract void coD();

    public abstract void coE();

    public abstract void coF();

    public abstract void coG();

    public abstract void coy();

    public abstract void coz();

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.tfO = true;
        this.nSa = bundle;
    }

    public int getLayoutId() {
        return 0;
    }

    public final void coH() {
        coF();
        this.tfP = true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void onResume() {
        super.onResume();
        LauncherUI cpQ = LauncherUI.cpQ();
        if (cpQ != null && cpQ.tkr) {
            this.tfR = true;
            if (this.tfS) {
                coK();
                this.tfS = false;
            }
        }
    }

    public final void coI() {
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

    public final void coK() {
        if (this.tfR) {
            if (this.tfO) {
                coy();
                this.tfO = false;
            } else if (this.tfN) {
                if (this.tfU) {
                    coD();
                }
                coy();
                x.v("MicroMsg.INIT", "KEVIN tab onRecreate " + toString());
                this.tfN = false;
            }
            this.tfU = true;
            long currentTimeMillis = System.currentTimeMillis();
            if (this.tfP) {
                this.tfP = false;
                coG();
            }
            coz();
            x.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - currentTimeMillis));
            this.tfQ = true;
            this.tfR = false;
        }
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
        if (this.tfU) {
            coD();
        }
        super.onDestroy();
    }

    public boolean supportNavigationSwipeBack() {
        return false;
    }
}
