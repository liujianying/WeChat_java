package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.tools.o.b;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MailAddrListUI extends MMActivity {
    private TextView eMY = null;
    private j mcZ = null;
    private p mgE = null;
    private TextView mgF = null;
    private ListView mgG;
    private a mgH;
    private List<i> mgI;
    private com.tencent.mm.plugin.qqmail.b.j.a mgJ = new 1(this);

    class a extends BaseAdapter {
        private final Context context;
        boolean mgL = false;
        boolean mgM = false;
        Map<String, i> mgN = new HashMap();

        public a(Context context) {
            this.context = context;
        }

        public final void c(i iVar) {
            this.mgN.put(iVar.kCs, iVar);
        }

        public final int boX() {
            return this.mgN.size();
        }

        public final int getCount() {
            int size = MailAddrListUI.this.mgI.size();
            if (size != 0) {
                return !this.mgM ? size + 1 : size;
            } else {
                if (this.mgL) {
                    return 1;
                }
                return 0;
            }
        }

        private TextView getTitleTextView() {
            TextView textView = new TextView(this.context);
            textView.setBackgroundResource(R.g.list_thicklinecell_bg);
            textView.setTextColor(-16777216);
            textView.setTextSize(0, (float) MailAddrListUI.this.getResources().getDimensionPixelSize(R.f.HintTextSize));
            int dimensionPixelSize = MailAddrListUI.this.getResources().getDimensionPixelSize(R.f.LargePadding);
            int dimensionPixelSize2 = MailAddrListUI.this.getResources().getDimensionPixelSize(R.f.SmallPadding);
            textView.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2);
            return textView;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            boolean z;
            if (i == 0) {
                if (this.mgL) {
                    view = getTitleTextView();
                    view.setText(R.l.plugin_qqmail_composeui_addr_list_search_empty);
                    int dimensionPixelSize = MailAddrListUI.this.getResources().getDimensionPixelSize(R.f.LargePadding);
                    view.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                    view.setTextSize(0, (float) MailAddrListUI.this.getResources().getDimensionPixelSize(R.f.BigTextSize));
                    view.setGravity(17);
                    return view;
                } else if (!this.mgM) {
                    view = getTitleTextView();
                    view.setText(R.l.plugin_qqmail_composeui_addr_list_recent_contacts);
                    return view;
                }
            }
            if (view == null || view.getTag() == null) {
                a aVar2 = new a(this);
                view = View.inflate(this.context, R.i.qqmail_addrlist_item, null);
                aVar2.mgO = (TextView) view.findViewById(R.h.qqmail_addrlist_item_category);
                aVar2.eMe = (TextView) view.findViewById(R.h.qqmail_addrlist_item_name_tv);
                aVar2.mgP = (TextView) view.findViewById(R.h.qqmail_addrlist_item_addr_iv);
                aVar2.eCo = (CheckBox) view.findViewById(R.h.qqmail_addrlist_item_select_cb);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            i uZ = getItem(i);
            if (this.mgM || i <= 10) {
                aVar.mgO.setVisibility(8);
            } else {
                i uZ2 = getItem(i - 1);
                if (i == 11) {
                    uZ2 = null;
                }
                String d = d(uZ);
                String d2 = d(uZ2);
                if (d == null) {
                    aVar.mgO.setVisibility(8);
                } else if (d.equals(d2)) {
                    aVar.mgO.setVisibility(8);
                } else {
                    aVar.mgO.setText(d.toUpperCase());
                    aVar.mgO.setVisibility(0);
                }
            }
            aVar.eMe.setText(uZ.name);
            aVar.mgP.setText(uZ.kCs);
            CheckBox checkBox = aVar.eCo;
            if (this.mgN.get(uZ.kCs) != null) {
                z = true;
            } else {
                z = false;
            }
            checkBox.setChecked(z);
            return view;
        }

        private static String d(i iVar) {
            if (iVar == null) {
                return null;
            }
            String JO = com.tencent.mm.plugin.qqmail.b.a.JO(iVar.mcD);
            char charAt = JO.length() > 1 ? JO.charAt(0) : '~';
            switch (charAt) {
                case TbsListener$ErrorCode.DOWNLOAD_RETRYTIMES302_EXCEED /*123*/:
                    charAt = JO.charAt(1);
                    if (bi.p(charAt)) {
                        return String.valueOf(charAt);
                    }
                    return "~";
                case '~':
                    return "~";
                default:
                    if (bi.o(charAt)) {
                        return String.valueOf(charAt);
                    }
                    return "~";
            }
        }

        /* renamed from: uZ */
        public final i getItem(int i) {
            if (!this.mgM) {
                i = i == 0 ? 0 : i - 1;
            }
            return (i) MailAddrListUI.this.mgI.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final boolean areAllItemsEnabled() {
            return false;
        }

        public final boolean isEnabled(int i) {
            if (i == 0) {
                return this.mgM;
            }
            return true;
        }
    }

    protected final int getLayoutId() {
        return R.i.qqmail_addrlist;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.plugin_qqmail_addrlist_title);
        this.mgI = new ArrayList();
        this.mcZ = w.bow().mcZ;
        initView();
        this.mcZ.a(this.mgJ);
        this.mcZ.bom();
    }

    protected final void initView() {
        this.mgG = (ListView) findViewById(R.h.qqmail_addrlist_lv);
        this.eMY = (TextView) findViewById(R.h.empty_tip_tv);
        this.mgF = (TextView) findViewById(R.h.nofind_tip_tv);
        this.mgH = new a(this);
        o oVar = new o((byte) 0);
        oVar.uBw = new b() {
            public final void WY() {
            }

            public final void WZ() {
            }

            public final boolean pj(String str) {
                return false;
            }

            public final void pk(String str) {
                String aG = bi.aG(str, "");
                MailAddrListUI.this.mgI = MailAddrListUI.this.mcZ.JS(aG.toLowerCase().trim());
                if (aG.length() > 0) {
                    MailAddrListUI.this.mgH.mgM = true;
                } else {
                    MailAddrListUI.this.mgH.mgM = false;
                }
                MailAddrListUI.this.mgH.mgL = false;
                if (MailAddrListUI.this.mgI.size() == 0) {
                    MailAddrListUI.this.enableOptionMenu(false);
                    MailAddrListUI.this.mgF.setVisibility(0);
                } else {
                    MailAddrListUI.this.enableOptionMenu(true);
                    MailAddrListUI.this.mgF.setVisibility(8);
                }
                MailAddrListUI.this.mgH.notifyDataSetChanged();
            }

            public final void WW() {
            }

            public final void WX() {
            }
        };
        a(oVar);
        this.mgG.setAdapter(this.mgH);
        this.mgG.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                a e = MailAddrListUI.this.mgH;
                i uZ = e.getItem(i - MailAddrListUI.this.mgG.getHeaderViewsCount());
                String str = uZ.kCs;
                if (e.mgN.containsKey(str)) {
                    e.mgN.remove(str);
                } else {
                    e.mgN.put(str, uZ);
                }
                e.notifyDataSetChanged();
                MailAddrListUI.this.setMMTitle(MailAddrListUI.this.getString(R.l.plugin_qqmail_addrlist_title) + (MailAddrListUI.this.mgH.boX() > 0 ? "(" + MailAddrListUI.this.mgH.boX() + ")" : ""));
            }
        });
        this.mgG.setOnScrollListener(new 4(this));
        this.mgI = this.mcZ.JS(null);
        this.mgH.notifyDataSetChanged();
        setBackBtn(new 5(this));
        6 6 = new 6(this);
        addTextOptionMenu(0, getString(R.l.plugin_qqmail_addrlist_choose), new 7(this));
        enableOptionMenu(!this.mgI.isEmpty());
        ActionBarActivity actionBarActivity = this.mController.tml;
        getString(R.l.app_tip);
        this.mgE = h.a(actionBarActivity, getString(R.l.plugin_qqmail_addressui_sync_dlg), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        this.mgH.notifyDataSetChanged();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.mcZ.b(this.mgJ);
    }
}
