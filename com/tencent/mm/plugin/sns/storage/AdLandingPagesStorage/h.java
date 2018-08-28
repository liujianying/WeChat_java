package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.ui.am;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public final class h {
    private int bgColor;
    private Context context;
    private int hmV;
    private int hmW;
    private ViewGroup mgl;
    private LinkedHashMap<String, i> nHh;
    private LayoutInflater nHi;
    private List<s> nIQ;

    public h(List<s> list, Context context, int i, ViewGroup viewGroup) {
        this.nIQ = list;
        this.context = context;
        this.bgColor = i;
        this.mgl = viewGroup;
    }

    public final void cl(List<s> list) {
        if (list != null && !list.equals(this.nIQ)) {
            this.nIQ = list;
            bAD();
        }
    }

    public final void bAD() {
        if (this.nIQ != null && !this.nIQ.isEmpty()) {
            if (this.nHh == null) {
                this.nHh = new LinkedHashMap();
            }
            if (this.nHi == null) {
                this.nHi = (LayoutInflater) this.context.getSystemService("layout_inflater");
                WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
                this.hmV = windowManager.getDefaultDisplay().getWidth();
                this.hmW = windowManager.getDefaultDisplay().getHeight();
            }
            for (int i = 0; i < this.nIQ.size(); i++) {
                s sVar = (s) this.nIQ.get(i);
                i iVar = (i) this.nHh.get(sVar.nAW);
                if (iVar != null) {
                    iVar.a(sVar);
                } else {
                    iVar = am.a(this.context, sVar, this.mgl, this.bgColor);
                    if (iVar != null) {
                        this.nHh.put(sVar.nAW, iVar);
                    }
                }
                try {
                    if (this.mgl != iVar.getView().getParent()) {
                        if (this.mgl.getChildCount() > i) {
                            this.mgl.addView(iVar.getView(), i);
                        } else {
                            this.mgl.addView(iVar.getView());
                        }
                    }
                } catch (Throwable e) {
                    x.e("CompRenderer", "component may have same id %s,%s", new Object[]{sVar.nAW, bi.i(e)});
                }
            }
        }
    }

    public final Collection<i> bAu() {
        return this.nHh == null ? Collections.EMPTY_LIST : this.nHh.values();
    }
}
