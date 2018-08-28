package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;

public abstract class AppBrandLauncherUI$a extends Fragment {
    public View FU;
    public int fdx;
    private final ag guJ = new ag(Looper.getMainLooper());
    public String guK;

    public abstract void initView();

    public void anp() {
    }

    public void anq() {
    }

    public void setScene(int i) {
        this.fdx = i;
    }

    public final int lG(int i) {
        Context activity = getActivity();
        if (activity == null) {
            activity = ad.getContext();
        }
        return a.fromDPToPix(activity, i);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.FU = new FrameLayout(viewGroup.getContext());
        initView();
        return this.FU;
    }

    public final void u(Runnable runnable) {
        if (runnable != null) {
            this.guJ.post(runnable);
        }
    }

    public final void runOnUiThread(Runnable runnable) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(runnable);
        }
    }
}
