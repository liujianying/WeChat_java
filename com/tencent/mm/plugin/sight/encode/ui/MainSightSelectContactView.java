package com.tencent.mm.plugin.sight.encode.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sight.encode.ui.d.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.contact.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MainSightSelectContactView extends FrameLayout implements OnScrollListener, a, l {
    public ListView CU;
    boolean nfB = false;
    public MMFragmentActivity nfG;
    public int ngf;
    public d ngg;
    Animation ngh;
    public c ngi;
    private View ngj;
    public a ngk;
    public LinearLayout ngl;
    private View ngm;
    private int ngn = -1;
    private int ngo = -1;
    public HashSet<String> ngp;
    public HashSet<String> ngq;

    public MainSightSelectContactView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MainSightSelectContactView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setMainSightContentView(a aVar) {
        this.ngk = aVar;
    }

    public void setEmptyBgView(View view) {
        this.ngj = view;
    }

    public void setSearchView(View view) {
        Object obj = this.ngg;
        obj.nfX = view;
        obj.nfV = (EditText) view.findViewById(R.h.edittext);
        obj.nfW = (TextView) view.findViewById(R.h.search_cancel_tv);
        obj.nfV.setOnFocusChangeListener(obj);
        obj.nfV.addTextChangedListener(obj);
        obj.nfW.setOnClickListener(obj);
        obj.nfZ = (InputMethodManager) view.getContext().getSystemService("input_method");
    }

    public ListView getListView() {
        return this.CU;
    }

    public final void bwv() {
        if (this.ngl != null) {
            this.ngl.getChildAt(0).setVisibility(0);
            this.ngj.setVisibility(8);
            C(true, false);
            this.ngk.bwl();
        }
    }

    public final void bwu() {
        if (this.ngl != null) {
            this.ngl.getChildAt(0).setVisibility(8);
            this.ngj.setVisibility(0);
            List list = this.ngi.nfO;
            list.remove("@search.tencent");
            list.remove("@sns.tencent");
            list.remove("@draft.tencent");
            b(list, false, true);
            this.ngk.bwm();
            if (!this.ngk.BD()) {
                this.ngk.bwn();
            }
            this.ngk.bwo();
        }
    }

    public final void bww() {
        this.CU.post(new Runnable() {
            public final void run() {
                if (MainSightSelectContactView.this.ngn != MainSightSelectContactView.this.ngi.getCount() || MainSightSelectContactView.this.ngk.getViewHeight() < MainSightSelectContactView.this.ngo) {
                    if (MainSightSelectContactView.this.ngm != null) {
                        MainSightSelectContactView.this.CU.removeFooterView(MainSightSelectContactView.this.ngm);
                    }
                    int d = MainSightSelectContactView.this.ngo;
                    if (MainSightSelectContactView.this.ngo < 0 || MainSightSelectContactView.this.ngo > MainSightSelectContactView.this.ngk.getViewHeight()) {
                        d = MainSightSelectContactView.this.ngk.getViewHeight();
                    }
                    MainSightSelectContactView.this.ngn = MainSightSelectContactView.this.ngi.getCount();
                    MainSightSelectContactView.this.ngo = d;
                    int i = 0;
                    int i2 = 0;
                    while (i < MainSightSelectContactView.this.ngi.getCount()) {
                        View view = MainSightSelectContactView.this.ngi.getView(i, null, MainSightSelectContactView.this.CU);
                        view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                        i2 += view.getMeasuredHeight();
                        if (i2 < d) {
                            i++;
                        } else {
                            return;
                        }
                    }
                    d -= i2;
                    if (d > 0) {
                        MainSightSelectContactView.this.ngm = new View(MainSightSelectContactView.this.getContext());
                        MainSightSelectContactView.this.ngm.setLayoutParams(new LayoutParams(-1, d));
                        MainSightSelectContactView.this.ngm.setBackgroundResource(R.e.black);
                        MainSightSelectContactView.this.CU.addFooterView(MainSightSelectContactView.this.ngm);
                    }
                }
            }
        });
    }

    private void b(List<String> list, boolean z, boolean z2) {
        if (!this.nfB && list != null) {
            if (z) {
                this.ngq.clear();
                this.ngp.clear();
                c.nfQ = true;
                c.nfR = false;
            }
            if (this.ngi != null) {
                c cVar = this.ngi;
                cVar.clearCache();
                cVar.nfO = list;
                cVar.notifyDataSetChanged();
            }
            if (z2) {
                bww();
            } else if (this.ngm != null) {
                this.CU.removeFooterView(this.ngm);
            }
        }
    }

    public final void C(boolean z, boolean z2) {
        List arrayList = new ArrayList();
        arrayList.add("@search.tencent");
        arrayList.add("@sns.tencent");
        Collection<String> initData = getInitData();
        if (z) {
            arrayList.addAll(this.ngq);
            for (String str : initData) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        } else {
            arrayList.addAll(initData);
        }
        b(arrayList, z2, true);
    }

    public List<String> getInitData() {
        List<String> arrayList = new ArrayList();
        au.HU();
        Collection clD = c.FW().clD();
        clD.remove(q.GF());
        arrayList.addAll(clD);
        return arrayList;
    }

    public Activity getActivity() {
        return this.nfG;
    }

    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.ujX || aVar.guS == null) {
            return false;
        }
        return this.ngp.contains(aVar.guS.field_username);
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.ujX || aVar.guS == null) {
            return false;
        }
        return this.ngq.contains(aVar.guS.field_username);
    }

    public ListView getContentLV() {
        return this.CU;
    }

    public LinkedList<String> getSelectedContact() {
        LinkedList<String> linkedList = new LinkedList();
        linkedList.addAll(this.ngq);
        return linkedList;
    }

    public final boolean bwx() {
        return this.ngq == null ? true : this.ngq.isEmpty();
    }

    final String jd(int i) {
        com.tencent.mm.ui.contact.a.a FM = this.ngi.FM(i);
        if (FM == null) {
            return null;
        }
        ab abVar = FM.guS;
        if (abVar != null) {
            return abVar.field_username;
        }
        return null;
    }

    public static boolean wg(int i) {
        return i == -1;
    }

    public void setIsMultiSelect(boolean z) {
        this.ngi.nfP = z;
    }

    public final void ce(List<String> list) {
        b(list, false, false);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            bi.hideVKB(absListView);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.ngl != null && absListView != null && this.ngl.getHeight() > 0 && this.nfG != null) {
            int height = this.ngl.getHeight() - this.nfG.getSupportActionBar().getHeight();
            int i4 = -this.ngl.getTop();
            if (i4 >= 0) {
                this.ngk.setCameraShadowAlpha(((float) i4) / ((float) height));
                boolean z = this.ngl.getTop() < 0 && this.ngl.getTop() <= (-height);
                this.ngk.hN(z);
            }
        }
    }
}
