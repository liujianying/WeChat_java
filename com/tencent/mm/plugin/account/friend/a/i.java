package com.tencent.mm.plugin.account.friend.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.account.a;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.applet.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i extends BaseAdapter {
    private Context context;
    public List<String[]> eHv;
    public int[] eIr;
    public LinkedList<arf> eKc = new LinkedList();
    private LinkedList<arf> eKd = new LinkedList();
    private List<String[]> eKe = new LinkedList();
    private a eKf;
    public b eKg = new b(new 1(this));
    private b.b eKh = null;
    int showType = 1;

    public i(Context context, a aVar, int i) {
        this.context = context;
        this.showType = i;
        this.eKf = aVar;
        this.eIr = new int[this.eKc.size()];
    }

    public final int getSelectCount() {
        int i = 0;
        for (int i2 : this.eIr) {
            if (this.showType == 1) {
                if (i2 == 1) {
                    i++;
                }
            } else if (this.showType == 2 && i2 == 2) {
                i++;
            }
        }
        return i;
    }

    public final boolean Xx() {
        if (this.eIr == null || this.eIr.length == 0) {
            return false;
        }
        for (int i : this.eIr) {
            if (this.showType == 1) {
                if (i == 0) {
                    return false;
                }
            } else if (this.showType == 2 && i == 0) {
                return false;
            }
        }
        return true;
    }

    public final void jb(int i) {
        if (this.showType == 1) {
            this.eIr[i] = 1;
        } else if (this.showType == 2) {
            this.eIr[i] = 2;
        }
        notifyDataSetChanged();
    }

    public final void ci(boolean z) {
        int i;
        int i2;
        if (this.showType == 1) {
            for (i = 0; i < this.eIr.length; i++) {
                int[] iArr = this.eIr;
                if (z) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                iArr[i] = i2;
            }
        } else if (this.showType == 2) {
            for (i = 0; i < this.eIr.length; i++) {
                int[] iArr2 = this.eIr;
                if (z) {
                    i2 = 2;
                } else {
                    i2 = 0;
                }
                iArr2[i] = i2;
            }
        }
        notifyDataSetChanged();
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        if (this.eKf != null) {
            this.eKf.notifyDataSetChanged();
        }
    }

    public final void p(LinkedList<arf> linkedList) {
        if (linkedList != null) {
            this.eKd.clear();
            this.eKc.clear();
            this.eKe.clear();
            for (String[] strArr : this.eHv) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    arf arf = (arf) it.next();
                    if (this.showType == 1) {
                        if ((arf.hcd == 1 || arf.hcd == 0) && !bi.oW(strArr[2]) && arf.mEl.equals(g.u(strArr[2].getBytes()))) {
                            a(arf, strArr);
                        }
                    } else if (this.showType == 2 && arf.hcd == 2 && !bi.oW(strArr[2]) && arf.mEl.equals(g.u(strArr[2].getBytes()))) {
                        a(arf, strArr);
                    }
                }
            }
        }
        this.eIr = new int[this.eKd.size()];
        this.eKc.addAll(this.eKd);
        this.eKd.clear();
    }

    private void a(arf arf, String[] strArr) {
        Iterator it = this.eKd.iterator();
        while (it.hasNext()) {
            arf arf2 = (arf) it.next();
            if (arf2.mEl != null && arf.mEl != null && arf2.mEl.equals(arf.mEl)) {
                x.d("MicroMsg.FriendAdapter", "tigerreg mobile already added");
                return;
            }
        }
        this.eKd.add(arf);
        this.eKe.add(new String[]{strArr[2], strArr[1]});
    }

    public final int getCount() {
        return this.eKc.size();
    }

    /* renamed from: jc */
    public final arf getItem(int i) {
        return (arf) this.eKc.get(i);
    }

    public final long getItemId(int i) {
        return (long) ((arf) this.eKc.get(i)).hashCode();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (this.showType == 1) {
            if (this.eKh == null) {
                this.eKh = new 2(this);
            }
            if (this.eKg != null) {
                this.eKg.a(i, this.eKh);
            }
        }
        arf arf = (arf) this.eKc.get(i);
        if (view == null) {
            bVar = new b();
            if (this.showType == 1) {
                view = View.inflate(this.context, a.g.find_friend_add_item, null);
                bVar.eIz = (TextView) view.findViewById(f.mobile_friend_name);
                bVar.eKl = (TextView) view.findViewById(f.mobile_friend_add_state);
                bVar.eKm = (Button) view.findViewById(f.mobile_friend_add_tv);
                bVar.eKn = (Button) view.findViewById(f.mobile_friend_invite_tv);
                bVar.eKk = (ImageView) view.findViewById(f.friend_avatar_iv);
                bVar.eKo = (TextView) view.findViewById(f.mobile_friend_selected);
                bVar.eKp = (TextView) view.findViewById(f.mobile_friend_unselect);
                view.setTag(bVar);
            } else if (this.showType == 2) {
                view = View.inflate(this.context, a.g.find_friend_item, null);
                bVar.eIz = (TextView) view.findViewById(f.mobile_friend_name);
                bVar.eKl = (TextView) view.findViewById(f.mobile_friend_add_state);
                bVar.eKm = (Button) view.findViewById(f.mobile_friend_add_tv);
                bVar.eKn = (Button) view.findViewById(f.mobile_friend_invite_tv);
                bVar.eKo = (TextView) view.findViewById(f.mobile_friend_selected);
                bVar.eKp = (TextView) view.findViewById(f.mobile_friend_unselect);
                view.setTag(bVar);
            }
        } else {
            bVar = (b) view.getTag();
        }
        bVar.eKp.setOnClickListener(new 3(this, i));
        if (this.showType == 1) {
            if (!bi.oW(((String[]) this.eKe.get(i))[1])) {
                bVar.eIz.setText(((String[]) this.eKe.get(i))[1]);
            } else if (bi.oW(arf.hcS)) {
                bVar.eIz.setText(arf.hbL);
            } else {
                bVar.eIz.setText(arf.hcS);
            }
            bVar.eKm.setOnClickListener(new 4(this, i));
            com.tencent.mm.pluginsdk.ui.a.b.a(bVar.eKk, arf.hbL);
        } else if (this.showType == 2) {
            bVar.eIz.setText(((String[]) this.eKe.get(i))[1]);
            bVar.eKn.setOnClickListener(new 5(this, i));
        }
        switch (this.eIr[i]) {
            case 0:
                if (this.showType != 1) {
                    if (this.showType == 2) {
                        bVar.eKl.setVisibility(8);
                        bVar.eKm.setVisibility(8);
                        bVar.eKn.setVisibility(0);
                        bVar.eKo.setVisibility(8);
                        bVar.eKp.setVisibility(8);
                        break;
                    }
                }
                bVar.eKl.setVisibility(8);
                bVar.eKm.setVisibility(0);
                bVar.eKn.setVisibility(8);
                bVar.eKo.setVisibility(8);
                bVar.eKp.setVisibility(8);
                break;
                break;
            case 1:
                bVar.eKm.setVisibility(8);
                bVar.eKl.setVisibility(0);
                bVar.eKo.setVisibility(0);
                bVar.eKp.setVisibility(0);
                break;
            case 2:
                bVar.eKm.setVisibility(8);
                bVar.eKn.setVisibility(8);
                bVar.eKl.setVisibility(0);
                bVar.eKo.setVisibility(0);
                bVar.eKp.setVisibility(0);
                break;
            case 3:
                bVar.eKm.setVisibility(8);
                bVar.eKl.setVisibility(0);
                bVar.eKo.setVisibility(0);
                bVar.eKp.setVisibility(0);
                break;
        }
        return view;
    }

    public final void pu(String str) {
        List arrayList = new ArrayList();
        for (int i = 0; i < this.eKe.size(); i++) {
            if (this.eIr[i] == 2) {
                arrayList.add(((String[]) this.eKe.get(i))[0]);
            }
        }
        com.tencent.mm.kernel.g.DF().a(new ai(str, arrayList), 0);
    }
}
