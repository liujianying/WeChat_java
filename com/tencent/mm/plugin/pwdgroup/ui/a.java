package com.tencent.mm.plugin.pwdgroup.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import com.tencent.mm.R;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;
import java.util.LinkedList;

public final class a extends BaseAdapter {
    private LinkedList<vt> iqd = new LinkedList();
    private Animation kwe;
    private Context mContext;
    private HashMap<String, Boolean> maA = new HashMap();
    private Animation maw;
    private Animation maz;

    public a(Context context) {
        this.mContext = context;
        this.kwe = AnimationUtils.loadAnimation(this.mContext, R.a.alpha_in);
        this.maz = AnimationUtils.loadAnimation(this.mContext, R.a.alpha_in);
        this.maw = AnimationUtils.loadAnimation(this.mContext, R.a.alpha_out);
        this.kwe.setInterpolator(new AccelerateDecelerateInterpolator());
        this.maz.setInterpolator(new AccelerateInterpolator());
        this.maw.setInterpolator(new AccelerateDecelerateInterpolator());
        this.kwe.setDuration(300);
        this.maz.setDuration(1000);
        this.maw.setDuration(1000);
    }

    public final void setData(LinkedList<vt> linkedList) {
        this.iqd = linkedList;
        if (this.iqd != null && this.iqd.size() > 0) {
            int size = this.iqd.size();
            for (int i = 0; i < size; i++) {
                String a = a((vt) this.iqd.get(i));
                if (!this.maA.containsKey(a)) {
                    this.maA.put(a, Boolean.valueOf(false));
                }
            }
        }
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.iqd == null ? 1 : this.iqd.size() + 1;
    }

    public final Object getItem(int i) {
        if (this.iqd != null && i < this.iqd.size()) {
            return this.iqd.get(i);
        }
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.i.facing_create_chatroom_detail_item, null);
            a aVar2 = new a(this, view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        vt vtVar = (vt) getItem(i);
        if (vtVar != null) {
            if (bi.oW(vtVar.hcS)) {
                aVar.eGX.setText(vtVar.hbL);
            } else {
                aVar.eGX.setText(vtVar.hcS);
            }
            if (bi.oW(vtVar.hbL)) {
                com.tencent.mm.plugin.pwdgroup.b.a.a(aVar.gwj, vtVar.ryZ);
            } else {
                com.tencent.mm.plugin.pwdgroup.b.a.a(aVar.gwj, vtVar.hbL);
            }
            String a = a(vtVar);
            view.clearAnimation();
            if (this.maA.containsKey(a) && !((Boolean) this.maA.get(a)).booleanValue()) {
                view.startAnimation(this.kwe);
                this.maA.put(a, Boolean.valueOf(true));
            }
        }
        if (i + 1 == getCount()) {
            aVar.eGX.setText("");
            aVar.gwj.setImageResource(R.g.account_avatar_bg_pwd);
            if (view != null) {
                this.maz.setAnimationListener(new 1(this, view));
                this.maw.setAnimationListener(new 2(this, view));
                view.startAnimation(this.maz);
            }
        }
        return view;
    }

    private static String a(vt vtVar) {
        if (vtVar == null) {
            return "";
        }
        if (bi.oW(vtVar.hbL)) {
            return vtVar.ryZ;
        }
        return vtVar.hbL;
    }
}
