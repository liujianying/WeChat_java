package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.d;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b extends BaseAdapter {
    private LayoutInflater Bc;
    private final int kYA = 3;
    List<ArrayList<c>> kYB = new ArrayList();
    d kYC;
    private boolean kYD = true;
    int kYE = 0;
    int kYF = 0;
    boolean kYG = false;
    private boolean kYH = false;
    SparseArray<String> kYb = null;
    int kYc;
    private final int kYy = 3;
    private final int kYz = 9;
    private Context mContext;

    class a {
        public View kYL = null;
        public ImageView kYM = null;
        public ImageView kYN = null;
        public TextView kYO = null;
        public TextView kYP = null;
        public String kYQ = null;
        public String kYR = null;
        public ImageView kYS = null;
        public ImageView kYT = null;
        public ImageView kYU = null;
        public ImageView kYV = null;

        a() {
        }
    }

    public b(Context context, int i) {
        this.mContext = context;
        this.kYc = i;
        this.Bc = LayoutInflater.from(this.mContext);
    }

    public final int getCount() {
        return this.kYB.size();
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        boolean z;
        int i3 = -1;
        if (this.kYE > 9) {
            int i4 = 0;
            for (int i5 = 0; i5 <= i; i5++) {
                i4 += ((ArrayList) this.kYB.get(i5)).size();
            }
            i3 = this.kYF > 3 ? 3 : this.kYF;
            if (i4 >= 9) {
                if (this.kYD && i == i3) {
                    i2 = i3;
                    z = true;
                    if (view == null) {
                        r0 = (b) view.getTag();
                    } else {
                        b bVar = new b(this);
                        view = this.Bc.inflate(g.mall_function_list_line, viewGroup, false);
                        bVar.kYW = (LinearLayout) view.findViewById(f.mall_function_list_line_container);
                        bVar.kYX = (TextView) view.findViewById(f.mall_fucntion_list_section_title);
                        bVar.kYY = view.findViewById(f.divider);
                        bVar.kYZ = view.findViewById(f.line_margin);
                        bVar.kZa = view.findViewById(f.mall_show_more_function_switch);
                        bVar.kZc = (TextView) view.findViewById(f.mall_show_more_tv);
                        bVar.kZb = (ImageView) view.findViewById(f.mall_show_more_arrow);
                        bVar.kZd = view.findViewById(f.more_function_reddot);
                        bVar.kZa.setOnClickListener(new 1(this));
                        view.setTag(bVar);
                        r0 = bVar;
                    }
                    if (!z) {
                        r0.kYX.setVisibility(8);
                        r0.kYY.setVisibility(8);
                        r0.kYZ.setVisibility(8);
                        r0.kZa.setVisibility(0);
                        r0.kZb.setImageResource(h.wallet_arrow_down);
                        r0.kZc.setText(this.mContext.getString(a$i.mall_index_show_more));
                        if (!this.kYG || this.kYH) {
                            r0.kZd.setVisibility(8);
                        } else {
                            r0.kZd.setVisibility(0);
                        }
                        if (this.kYD) {
                            r0.kYW.setVisibility(8);
                            r0.kZc.setText(this.mContext.getString(a$i.mall_index_show_more));
                        } else {
                            r0.kYW.setVisibility(0);
                            a(i, r0);
                            r0.kZc.setText(this.mContext.getString(a$i.mall_index_hide_more));
                        }
                    } else if (i2 <= 0 || !this.kYD || i < i2 || i > this.kYF) {
                        r0.kYW.setVisibility(0);
                        a(i, r0);
                        r0.kZa.setVisibility(8);
                        r0.kZd.setVisibility(8);
                    } else {
                        r0.kYW.setVisibility(8);
                        r0.kZa.setVisibility(8);
                        r0.kZd.setVisibility(8);
                        r0.kYX.setVisibility(8);
                        r0.kYY.setVisibility(8);
                        r0.kYZ.setVisibility(8);
                    }
                    return view;
                } else if (i == this.kYF && !this.kYD) {
                    b bVar2;
                    i2 = i3;
                    z = true;
                    if (view == null) {
                        b bVar3 = new b(this);
                        view = this.Bc.inflate(g.mall_function_list_line, viewGroup, false);
                        bVar3.kYW = (LinearLayout) view.findViewById(f.mall_function_list_line_container);
                        bVar3.kYX = (TextView) view.findViewById(f.mall_fucntion_list_section_title);
                        bVar3.kYY = view.findViewById(f.divider);
                        bVar3.kYZ = view.findViewById(f.line_margin);
                        bVar3.kZa = view.findViewById(f.mall_show_more_function_switch);
                        bVar3.kZc = (TextView) view.findViewById(f.mall_show_more_tv);
                        bVar3.kZb = (ImageView) view.findViewById(f.mall_show_more_arrow);
                        bVar3.kZd = view.findViewById(f.more_function_reddot);
                        bVar3.kZa.setOnClickListener(new 1(this));
                        view.setTag(bVar3);
                        bVar2 = bVar3;
                    } else {
                        bVar2 = (b) view.getTag();
                    }
                    if (!z) {
                        bVar2.kYX.setVisibility(8);
                        bVar2.kYY.setVisibility(8);
                        bVar2.kYZ.setVisibility(8);
                        bVar2.kZa.setVisibility(0);
                        bVar2.kZb.setImageResource(h.wallet_arrow_down);
                        bVar2.kZc.setText(this.mContext.getString(a$i.mall_index_show_more));
                        if (!this.kYG || this.kYH) {
                            bVar2.kZd.setVisibility(8);
                        } else {
                            bVar2.kZd.setVisibility(0);
                        }
                        if (this.kYD) {
                            bVar2.kYW.setVisibility(8);
                            bVar2.kZc.setText(this.mContext.getString(a$i.mall_index_show_more));
                        } else {
                            bVar2.kYW.setVisibility(0);
                            a(i, bVar2);
                            bVar2.kZc.setText(this.mContext.getString(a$i.mall_index_hide_more));
                        }
                    } else if (i2 <= 0 || !this.kYD || i < i2 || i > this.kYF) {
                        bVar2.kYW.setVisibility(0);
                        a(i, bVar2);
                        bVar2.kZa.setVisibility(8);
                        bVar2.kZd.setVisibility(8);
                    } else {
                        bVar2.kYW.setVisibility(8);
                        bVar2.kZa.setVisibility(8);
                        bVar2.kZd.setVisibility(8);
                        bVar2.kYX.setVisibility(8);
                        bVar2.kYY.setVisibility(8);
                        bVar2.kYZ.setVisibility(8);
                    }
                    return view;
                }
            }
        }
        i2 = i3;
        z = false;
        if (view == null) {
            b bVar32 = new b(this);
            view = this.Bc.inflate(g.mall_function_list_line, viewGroup, false);
            bVar32.kYW = (LinearLayout) view.findViewById(f.mall_function_list_line_container);
            bVar32.kYX = (TextView) view.findViewById(f.mall_fucntion_list_section_title);
            bVar32.kYY = view.findViewById(f.divider);
            bVar32.kYZ = view.findViewById(f.line_margin);
            bVar32.kZa = view.findViewById(f.mall_show_more_function_switch);
            bVar32.kZc = (TextView) view.findViewById(f.mall_show_more_tv);
            bVar32.kZb = (ImageView) view.findViewById(f.mall_show_more_arrow);
            bVar32.kZd = view.findViewById(f.more_function_reddot);
            bVar32.kZa.setOnClickListener(new 1(this));
            view.setTag(bVar32);
            bVar2 = bVar32;
        } else {
            bVar2 = (b) view.getTag();
        }
        if (!z) {
            bVar2.kYX.setVisibility(8);
            bVar2.kYY.setVisibility(8);
            bVar2.kYZ.setVisibility(8);
            bVar2.kZa.setVisibility(0);
            bVar2.kZb.setImageResource(h.wallet_arrow_down);
            bVar2.kZc.setText(this.mContext.getString(a$i.mall_index_show_more));
            if (!this.kYG || this.kYH) {
                bVar2.kZd.setVisibility(8);
            } else {
                bVar2.kZd.setVisibility(0);
            }
            if (this.kYD) {
                bVar2.kYW.setVisibility(8);
                bVar2.kZc.setText(this.mContext.getString(a$i.mall_index_show_more));
            } else {
                bVar2.kYW.setVisibility(0);
                a(i, bVar2);
                bVar2.kZc.setText(this.mContext.getString(a$i.mall_index_hide_more));
            }
        } else if (i2 <= 0 || !this.kYD || i < i2 || i > this.kYF) {
            bVar2.kYW.setVisibility(0);
            a(i, bVar2);
            bVar2.kZa.setVisibility(8);
            bVar2.kZd.setVisibility(8);
        } else {
            bVar2.kYW.setVisibility(8);
            bVar2.kZa.setVisibility(8);
            bVar2.kZd.setVisibility(8);
            bVar2.kYX.setVisibility(8);
            bVar2.kYY.setVisibility(8);
            bVar2.kYZ.setVisibility(8);
        }
        return view;
    }

    private void a(int i, b bVar) {
        List list = (List) this.kYB.get(i);
        int i2 = ((c) list.get(0)).kZe.type;
        if (list.size() > 0) {
            CharSequence charSequence;
            boolean z;
            int i3 = ((c) list.get(0)).kZe.type;
            if (this.kYb == null) {
                charSequence = null;
            } else {
                Object charSequence2 = (String) this.kYb.get(i3);
            }
            if (!bi.oW(charSequence2)) {
                if (i == 0) {
                    z = true;
                } else if (((ArrayList) this.kYB.get(i - 1)).size() > 0 && i3 != ((c) ((ArrayList) this.kYB.get(i - 1)).get(0)).kZe.type) {
                    z = true;
                }
                if (z) {
                    bVar.kYX.setVisibility(8);
                    bVar.kYY.setVisibility(8);
                    bVar.kYZ.setVisibility(8);
                } else {
                    bVar.kYX.setText(charSequence2);
                    bVar.kYX.setVisibility(0);
                    bVar.kYY.setVisibility(0);
                    bVar.kYZ.setVisibility(0);
                }
            }
            z = false;
            if (z) {
                bVar.kYX.setVisibility(8);
                bVar.kYY.setVisibility(8);
                bVar.kYZ.setVisibility(8);
            } else {
                bVar.kYX.setText(charSequence2);
                bVar.kYX.setVisibility(0);
                bVar.kYY.setVisibility(0);
                bVar.kYZ.setVisibility(0);
            }
        } else {
            bVar.kYX.setVisibility(8);
            bVar.kYY.setVisibility(8);
            bVar.kYZ.setVisibility(8);
        }
        ViewGroup viewGroup = bVar.kYW;
        viewGroup.setFocusable(true);
        int i4 = 0;
        while (i4 < 3) {
            a aVar;
            if (i4 >= viewGroup.getChildCount() || viewGroup.getChildAt(i4) == null) {
                a aVar2 = new a();
                View inflate = this.Bc.inflate(g.mall_index_function_item, viewGroup, false);
                aVar2.kYL = inflate.findViewById(f.mall_index_function_item_main);
                aVar2.kYM = (ImageView) inflate.findViewById(f.mall_index_function_icon);
                aVar2.kYO = (TextView) inflate.findViewById(f.mall_index_function_name);
                aVar2.kYP = (TextView) inflate.findViewById(f.mall_index_function_activity);
                aVar2.kYN = (ImageView) inflate.findViewById(f.new_pic_holder);
                aVar2.kYS = (ImageView) inflate.findViewById(f.divider_top);
                aVar2.kYT = (ImageView) inflate.findViewById(f.divider_right);
                aVar2.kYU = (ImageView) inflate.findViewById(f.divider_bottom);
                aVar2.kYV = (ImageView) inflate.findViewById(f.divider_left);
                inflate.setTag(aVar2);
                if (i4 < list.size()) {
                    a(inflate, (c) list.get(i4));
                } else {
                    inflate.setFocusable(true);
                    aVar = (a) inflate.getTag();
                    aVar.kYL.setVisibility(4);
                    inflate.setOnClickListener(null);
                    inflate.setEnabled(false);
                    inflate.setClickable(false);
                    a(aVar);
                }
                viewGroup.addView(inflate, new LayoutParams(-2, a.bbK(), 1.0f));
            } else {
                View childAt = viewGroup.getChildAt(i4);
                childAt.setVisibility(0);
                if (i4 < list.size()) {
                    a(childAt, (c) list.get(i4));
                } else {
                    viewGroup.getChildAt(i4).setFocusable(true);
                    viewGroup.getChildAt(i4).setOnClickListener(null);
                    aVar = (a) viewGroup.getChildAt(i4).getTag();
                    aVar.kYL.setVisibility(4);
                    childAt.setEnabled(false);
                    childAt.setClickable(false);
                    a(aVar);
                }
            }
            i4++;
        }
    }

    private static void a(a aVar) {
        aVar.kYT.setVisibility(4);
    }

    final boolean bbN() {
        if (this.kYB.size() > 3) {
            ArrayList arrayList = (ArrayList) this.kYB.get(3);
            if (arrayList != null && arrayList.size() > 0) {
                int i = ((c) arrayList.get(0)).kZe.type;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar.kZe.type != i) {
                        break;
                    } else if (a(cVar.kZe)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean a(MallFunction mallFunction) {
        if (mallFunction.prU == null || bi.oW(mallFunction.prU.psd) || !b(mallFunction) || d.bPO().Ph(mallFunction.moy) == null) {
            return false;
        }
        return true;
    }

    private void a(View view, c cVar) {
        if (view != null) {
            a aVar = (a) view.getTag();
            MallFunction mallFunction = cVar.kZe;
            int i = cVar.kZf;
            aVar.kYR = mallFunction.kYR;
            aVar.kYQ = mallFunction.kYQ;
            com.tencent.mm.plugin.mall.b.a.f(aVar.kYM, aVar.kYQ, h.mall_index_icon_default);
            aVar.kYO.setText(mallFunction.cbR);
            aVar.kYN.setVisibility(8);
            if (mallFunction.prU == null || bi.oW(mallFunction.prU.psd) || !b(mallFunction)) {
                if (mallFunction.prU == null || mallFunction.prU.psi != 1) {
                    aVar.kYP.setText("");
                    aVar.kYP.setVisibility(4);
                } else {
                    aVar.kYP.setText(mallFunction.prU.psd);
                    aVar.kYP.setVisibility(0);
                }
                aVar.kYN.setImageBitmap(null);
                aVar.kYN.setVisibility(8);
            } else {
                if (d.bPO().Ph(mallFunction.moy) != null) {
                    x.w("MicroMsg.FunctionListAdapter", "show the news : " + d.bPO().Ph(mallFunction.moy).psd);
                    aVar.kYP.setText(mallFunction.prU.psd);
                    aVar.kYP.setVisibility(0);
                } else {
                    aVar.kYP.setVisibility(4);
                }
                com.tencent.mm.plugin.mall.b.a.j(aVar.kYN, aVar.kYR);
                aVar.kYN.setVisibility(0);
                String str = mallFunction.moy;
            }
            view.setOnClickListener(new 2(this, i, mallFunction));
            aVar.kYL.setVisibility(0);
            view.setEnabled(true);
            view.setClickable(true);
            aVar.kYT.setVisibility(0);
            aVar.kYU.setVisibility(0);
        }
    }

    private static boolean b(MallFunction mallFunction) {
        MallNews Ph = d.bPO().Ph(mallFunction.moy);
        if (Ph == null || bi.oW(Ph.oqH) || !Ph.oqH.equals(mallFunction.prU.oqH)) {
            x.d("MicroMsg.FunctionListAdapter", "old news null or should be replaced %s %s", new Object[]{mallFunction.prU.oqH, mallFunction.cbR});
            d bPO = d.bPO();
            Ph = mallFunction.prU;
            if (Ph == null) {
                x.w("MicroMsg.MallNewsManagerNewVersion", "null obj");
            } else {
                Ph.psj = "<sysmsg><mallactivitynew><functionid>" + Ph.psc + "</functionid><activityid>" + Ph.oqH + "</activityid><type>" + Ph.type + "</type><showflag>" + Ph.psa + "</showflag><newsTipFlag>" + Ph.psb + "</newsTipFlag></mallactivitynew></sysmsg>;";
                bPO.psm.put(Ph.psc, Ph);
                bPO.bna();
            }
            return true;
        } else if (Ph == null) {
            return false;
        } else {
            if ("0".equals(Ph.psa)) {
                x.d("MicroMsg.FunctionListAdapter", "still old news and should show");
                return true;
            }
            x.d("MicroMsg.FunctionListAdapter", "still old news or clicked, then should not show");
            return false;
        }
    }
}
