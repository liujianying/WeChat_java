package com.tencent.mm.plugin.webview.fts.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.webview.fts.c.a;
import com.tencent.mm.sdk.platformtools.bd;

class b$4 extends bd<Boolean> {
    final /* synthetic */ int fKG;
    final /* synthetic */ b pQL;
    final /* synthetic */ a pQM;
    final /* synthetic */ boolean pQN;

    public b$4(b bVar, Boolean bool, int i, a aVar, boolean z) {
        this.pQL = bVar;
        this.fKG = i;
        this.pQM = aVar;
        this.pQN = z;
        super(1000, bool, (byte) 0);
    }

    protected final /* synthetic */ Object run() {
        boolean z;
        b bVar = this.pQL;
        int i = this.fKG;
        a aVar = this.pQM;
        boolean z2 = this.pQN;
        if (i == bVar.goN) {
            z = false;
        } else {
            b.a Aj = bVar.Aj(i);
            if (Aj == null || Aj.gpb == null) {
                z = false;
            } else {
                View view = (View) Aj.gpb.get();
                if (view == null) {
                    z = false;
                } else {
                    bVar.goR = i;
                    ViewGroup ls = bVar.ls(Aj.gpc);
                    b.a Aj2 = bVar.Aj(Aj.gpc);
                    if (Aj2 != null) {
                        ViewGroup ls2 = bVar.ls(Aj2.gpc);
                        if (ls2 != null) {
                            View view2 = (View) Aj.gpb.get();
                            if (view2 != null) {
                                LayoutParams layoutParams = view2.getLayoutParams();
                                layoutParams.width = -1;
                                layoutParams.height = -1;
                                view2.setLayoutParams(layoutParams);
                            }
                            bVar.goR = Aj2.id;
                            ls = ls2;
                            if (ls != null) {
                                view = (View) Aj2.gpb.get();
                                ls.addView(bVar.goP, ls.indexOfChild(view));
                                ls.removeView(view);
                            }
                            bVar.goO = new float[]{view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight(), (float) Aj2.z};
                            bVar.pQK.k(view, z2);
                            bVar.goN = i;
                            bVar.pQJ = aVar;
                            z = true;
                        }
                    }
                    Aj2 = Aj;
                    if (ls != null) {
                        view = (View) Aj2.gpb.get();
                        ls.addView(bVar.goP, ls.indexOfChild(view));
                        ls.removeView(view);
                    }
                    bVar.goO = new float[]{view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight(), (float) Aj2.z};
                    bVar.pQK.k(view, z2);
                    bVar.goN = i;
                    bVar.pQJ = aVar;
                    z = true;
                }
            }
        }
        return Boolean.valueOf(z);
    }
}
