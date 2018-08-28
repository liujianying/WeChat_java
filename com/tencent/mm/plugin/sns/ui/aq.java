package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class aq extends a {
    public static int[] nXP = new int[]{j.sns_label_public_hint, j.sns_label_private_hint, j.sns_label_include_hint, j.sns_label_exclude_hint};
    public static int[] nXt = new int[]{j.sns_label_public, j.sns_label_private, j.sns_label_include, j.sns_label_exclude};
    private LayoutInflater Bc;
    private Context mContext;
    ArrayList<String> nXQ;
    public int nXR = 0;
    public boolean nXS = false;
    public ArrayList<String> nXT = new ArrayList();
    public ArrayList<String> nXU = new ArrayList();
    public ArrayList<String> nXV = new ArrayList();
    public ArrayList<String> nXW = new ArrayList();
    public int style;

    public aq(Context context) {
        this.mContext = context;
        this.Bc = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public final Object getChild(int i, int i2) {
        return this.nXQ.get(i2);
    }

    public final long getChildId(int i, int i2) {
        return 0;
    }

    public final void O(ArrayList<String> arrayList) {
        List<String> bDD = bDD();
        Object arrayList2 = new ArrayList();
        if (!(bDD == null || arrayList == null)) {
            for (String str : bDD) {
                if (i(arrayList, str)) {
                    arrayList.remove(str);
                    arrayList2.add(str);
                }
            }
            arrayList.addAll(0, arrayList2);
            String str2 = bi.c(arrayList2, ",");
            g.Ek();
            g.Ei().DT().set(335875, str2);
        }
        this.nXQ = arrayList;
    }

    private static List<String> bDD() {
        g.Ek();
        String str = (String) g.Ei().DT().get(335875, null);
        x.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "dz:getTopFive : %s", new Object[]{str});
        if (bi.oW(str)) {
            return null;
        }
        return bi.F(str.split(","));
    }

    public static void NW(String str) {
        x.d("MicroMsg.Sns.AnimatedExpandableListAdapter", "recordTopFive : %s", new Object[]{str});
        if (bDD() != null) {
            List arrayList = new ArrayList(bDD());
            if (!i(arrayList, str)) {
                if (arrayList.size() == 5) {
                    arrayList.remove(4);
                }
                arrayList.add(0, str);
                String c = bi.c(arrayList, ",");
                g.Ek();
                g.Ei().DT().set(335875, c);
                return;
            }
            return;
        }
        g.Ek();
        g.Ei().DT().set(335875, str);
    }

    private CharSequence NX(String str) {
        List<String> FD = com.tencent.mm.plugin.label.a.a.aYK().FD(com.tencent.mm.plugin.label.a.a.aYK().FA(str));
        if (FD == null || FD.size() == 0) {
            return "";
        }
        List arrayList = new ArrayList(FD.size());
        for (String gT : FD) {
            arrayList.add(((b) g.l(b.class)).gT(gT));
        }
        return com.tencent.mm.pluginsdk.ui.d.j.a(this.mContext, bi.c(arrayList, ","));
    }

    private static boolean i(List<String> list, String str) {
        for (String equals : list) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean aH(int i, String str) {
        if (i == 1) {
            return i(this.nXT, str);
        }
        return i(this.nXU, str);
    }

    public final Object getGroup(int i) {
        return null;
    }

    public final int getGroupCount() {
        return 4;
    }

    public final long getGroupId(int i) {
        return 0;
    }

    public final View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || !(view.getTag() instanceof a)) {
            View inflate;
            if (this.style == 1) {
                inflate = this.Bc.inflate(i.g.sns_label_expand_item_black, null);
            } else {
                inflate = this.Bc.inflate(i.g.sns_label_expand_item, null);
            }
            a aVar2 = new a(this, (byte) 0);
            aVar2.titleView = (TextView) inflate.findViewById(f.sns_label_title);
            aVar2.kYT = (ImageView) inflate.findViewById(f.sns_label_right_img);
            aVar2.kJq = (TextView) inflate.findViewById(f.sns_label_sub_title);
            inflate.setTag(aVar2);
            view = inflate;
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.titleView.setText(nXt[i]);
        aVar.kJq.setText(nXP[i]);
        switch (i) {
            case 0:
            case 1:
                if (this.nXR == i) {
                    aVar.kYT.setImageResource(i.i.radio_on);
                    aVar.kYT.setContentDescription(this.mContext.getString(j.selected_Imgbtn));
                    break;
                }
                aVar.kYT.setImageResource(i.i.radio_off);
                break;
            case 2:
                if (this.nXR == i) {
                    aVar.kYT.setImageResource(i.i.radio_on);
                    aVar.kYT.setContentDescription(this.mContext.getString(j.selected_Imgbtn));
                    break;
                }
                aVar.kYT.setImageResource(i.i.radio_off);
                break;
            case 3:
                if (this.style != 1) {
                    if (this.nXR == i) {
                        aVar.kYT.setImageResource(i.i.radio_on_red);
                        aVar.kYT.setContentDescription(this.mContext.getString(j.selected_Imgbtn));
                        break;
                    }
                    aVar.kYT.setImageResource(i.i.radio_off);
                    break;
                } else if (this.nXR == i) {
                    aVar.kYT.setImageResource(i.i.round_selector_checked_orange);
                    aVar.kYT.setContentDescription(this.mContext.getString(j.selected_Imgbtn));
                    break;
                } else {
                    aVar.kYT.setImageResource(i.i.radio_off);
                    break;
                }
        }
        if (!this.nXS || i != 1) {
            return view;
        }
        view = new View(this.mContext);
        view.setVisibility(8);
        return view;
    }

    public final boolean hasStableIds() {
        return false;
    }

    public final boolean isChildSelectable(int i, int i2) {
        return true;
    }

    private static List<String> aE(List<String> list) {
        List<String> linkedList = new LinkedList();
        g.Ek();
        if (!g.Eg().Dx()) {
            return linkedList;
        }
        if (list == null) {
            return linkedList;
        }
        for (Object obj : list) {
            Object obj2;
            g.Ek();
            ab Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yg(obj2);
            if (!(Yg == null || ((int) Yg.dhP) == 0)) {
                obj2 = Yg.BL();
            }
            linkedList.add(obj2);
        }
        return linkedList;
    }

    public final View d(int i, int i2, View view) {
        View inflate;
        a aVar;
        if (view == null) {
            if (this.style == 1) {
                inflate = this.Bc.inflate(i.g.sns_label_child_item_black, null);
            } else {
                inflate = this.Bc.inflate(i.g.sns_label_child_item, null);
            }
            aVar = new a(this, (byte) 0);
            aVar.titleView = (TextView) inflate.findViewById(f.sns_label_title);
            aVar.kJq = (TextView) inflate.findViewById(f.sns_label_sub_title);
            aVar.nXX = (TextView) inflate.findViewById(f.sns_label_single_line);
            aVar.nXY = (TextView) inflate.findViewById(f.sns_label_selected_other_users);
            aVar.kYT = (ImageView) inflate.findViewById(f.sns_label_right_img);
            inflate.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
            inflate = view;
        }
        if (i2 == this.nXQ.size()) {
            aVar.titleView.setVisibility(8);
            aVar.kJq.setVisibility(8);
            aVar.kYT.setVisibility(8);
            aVar.nXX.setVisibility(0);
            aVar.nXY.setVisibility(0);
            if (i == 3) {
                if (this.nXW.size() > 0) {
                    aVar.nXY.setText("√" + bi.c(aE(this.nXW), ","));
                    aVar.nXY.setVisibility(0);
                    aVar.nXY.setTextColor(this.mContext.getResources().getColor(c.sns_selected_other_user_name_color_black));
                } else {
                    aVar.nXY.setText("");
                    aVar.nXY.setVisibility(8);
                }
            } else if (i == 2) {
                if (this.nXV.size() > 0) {
                    aVar.nXY.setText("√" + bi.c(aE(this.nXV), ","));
                    aVar.nXY.setVisibility(0);
                    aVar.nXY.setTextColor(this.mContext.getResources().getColor(c.sns_selected_other_user_name_color));
                } else {
                    aVar.nXY.setText("");
                    aVar.nXY.setVisibility(8);
                }
            }
        } else {
            aVar.titleView.setVisibility(0);
            aVar.kJq.setVisibility(0);
            aVar.kYT.setVisibility(0);
            aVar.nXX.setVisibility(8);
            aVar.nXY.setVisibility(8);
            String str = (String) this.nXQ.get(i2);
            aVar.titleView.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.mContext, str));
            aVar.kJq.setText(NX(str));
            aVar.kYT.setVisibility(0);
            if (this.style == 1) {
                if (i == 2) {
                    if (aH(1, str)) {
                        aVar.kYT.setImageResource(i.i.sight_list_checkbox_selected);
                    } else {
                        aVar.kYT.setImageResource(i.i.sight_list_checkbox_unselected);
                    }
                } else if (i == 3) {
                    if (this.nXR != i) {
                        aVar.kYT.setImageResource(i.i.sight_list_checkbox_unselected_red);
                    } else {
                        aVar.kYT.setImageResource(i.i.sight_list_checkbox_selected_red);
                    }
                    if (aH(2, str)) {
                        aVar.kYT.setImageResource(i.i.sight_list_checkbox_selected_red);
                    } else {
                        aVar.kYT.setImageResource(i.i.sight_list_checkbox_unselected_red);
                    }
                }
            } else if (i == 2) {
                if (aH(1, str)) {
                    aVar.kYT.setImageResource(i.i.checkbox_selected);
                } else {
                    aVar.kYT.setImageResource(i.i.checkbox_unselected);
                }
            } else if (i == 3) {
                if (aH(2, str)) {
                    aVar.kYT.setImageResource(i.i.checkbox_selected_red);
                } else {
                    aVar.kYT.setImageResource(i.i.checkbox_unselected);
                }
            }
        }
        return inflate;
    }

    public final int xv(int i) {
        if (i <= 1 || this.nXQ == null) {
            return 0;
        }
        return this.nXQ.size() + 1;
    }
}
