package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.s;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupCardSelectUI extends MMActivity {
    private TextView emptyTipTv;
    private List<ab> laD;
    private boolean ujD = true;
    private boolean ujE;
    private boolean ujF = false;
    private List<String> ujG = null;
    private int ujH;
    private ListView ujI;
    private a ujJ;
    private HashMap<String, Long> ujK;

    class a extends BaseAdapter {
        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            ab abVar = (ab) GroupCardSelectUI.this.laD.get(i);
            if (view == null) {
                b bVar2 = new b(GroupCardSelectUI.this);
                view = View.inflate(GroupCardSelectUI.this, R.i.group_card_select_item, null);
                bVar2.hrM = (TextView) view.findViewById(R.h.group_card_item_count_tv);
                bVar2.ujM = (TextView) view.findViewById(R.h.group_card_item_nick);
                bVar2.eKk = (ImageView) view.findViewById(R.h.group_card_item_avatar_iv);
                bVar2.lSA = (CheckBox) view.findViewById(R.h.select_cb);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            b.a(bVar.eKk, abVar.field_username);
            bVar.ujM.setText(j.a(GroupCardSelectUI.this, r.gT(abVar.field_username), com.tencent.mm.bp.a.ad(GroupCardSelectUI.this.mController.tml, R.f.NormalTextSize)));
            bVar.hrM.setText("(" + m.gK(abVar.field_username) + ")");
            if (GroupCardSelectUI.this.ujF) {
                bVar.lSA.setVisibility(0);
                if (GroupCardSelectUI.this.ujG.contains(abVar.field_username)) {
                    bVar.lSA.setChecked(true);
                } else {
                    bVar.lSA.setChecked(false);
                }
            }
            return view;
        }

        public final int getCount() {
            return GroupCardSelectUI.this.laD.size();
        }

        public final Object getItem(int i) {
            return GroupCardSelectUI.this.laD.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }
    }

    static /* synthetic */ void a(GroupCardSelectUI groupCardSelectUI, ab abVar) {
        int i = 1;
        Intent intent;
        if (groupCardSelectUI.ujF) {
            if (groupCardSelectUI.ujG.contains(abVar.field_username)) {
                groupCardSelectUI.ujG.remove(abVar.field_username);
            } else {
                if (!groupCardSelectUI.ujF || groupCardSelectUI.ujG.size() < groupCardSelectUI.ujH) {
                    i = 0;
                } else {
                    h.a(groupCardSelectUI.mController.tml, groupCardSelectUI.getString(R.l.select_contact_num_limit_tips_withgroup, new Object[]{Integer.valueOf(groupCardSelectUI.ujH)}), groupCardSelectUI.getString(R.l.app_remind), new 4(groupCardSelectUI));
                }
                if (i == 0) {
                    groupCardSelectUI.ujG.add(abVar.field_username);
                }
            }
            groupCardSelectUI.ujJ.notifyDataSetChanged();
        } else if (!groupCardSelectUI.ujD) {
            intent = new Intent();
            au.HU();
            intent.putExtra("Select_Contact", bi.c(c.Ga().il(abVar.field_username), ","));
            intent.putExtra("Select_room_name", r.gT(abVar.field_username));
            groupCardSelectUI.setResult(-1, intent);
            groupCardSelectUI.finish();
        } else if (groupCardSelectUI.ujE) {
            intent = new Intent();
            intent.putExtra("Select_Conv_User", abVar.field_username);
            groupCardSelectUI.setResult(-1, intent);
            groupCardSelectUI.finish();
        } else {
            intent = new Intent(groupCardSelectUI, ChattingUI.class);
            intent.addFlags(67108864);
            intent.putExtra("Chat_User", abVar.field_username);
            groupCardSelectUI.startActivity(intent);
            groupCardSelectUI.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(getString(R.l.address_select_group_card));
        this.ujD = getIntent().getBooleanExtra("group_select_type", true);
        this.ujE = getIntent().getBooleanExtra("group_select_need_result", false);
        this.ujF = getIntent().getBooleanExtra("group_multi_select", false);
        if (this.ujF) {
            String stringExtra = getIntent().getStringExtra("already_select_contact");
            if (bi.oW(stringExtra)) {
                this.ujG = new LinkedList();
            } else {
                this.ujG = ai.h(stringExtra.split(","));
            }
            this.ujH = getIntent().getIntExtra("max_limit_num", 0);
        }
        cyn();
        initView();
        if (this.ujF) {
            a(1, getString(R.l.app_ok), new 3(this), s.b.tmX);
            enableOptionMenu(1, true);
            Wp();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected final void initView() {
        this.ujI = (ListView) findViewById(R.h.group_card_select_list);
        this.ujJ = new a();
        this.ujI.setAdapter(this.ujJ);
        this.ujI.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ab abVar = (ab) GroupCardSelectUI.this.ujJ.getItem(i);
                if (abVar == null) {
                    x.v("MicroMsg.GroupCardSelectUI", "onItemClick contact null");
                    return;
                }
                GroupCardSelectUI.a(GroupCardSelectUI.this, abVar);
                GroupCardSelectUI.this.Wp();
            }
        });
        this.emptyTipTv = (TextView) findViewById(R.h.group_card_empty_tip_tv);
        if (this.ujJ.getCount() <= 0) {
            this.emptyTipTv.setVisibility(0);
        } else {
            this.emptyTipTv.setVisibility(8);
        }
        setBackBtn(new 2(this));
    }

    private void cyn() {
        au.HU();
        this.ujK = c.FW().clA();
        this.laD = new LinkedList();
        List<ab> Hq = com.tencent.mm.model.s.Hq();
        if (Hq.size() != 0) {
            int i = 0;
            for (ab abVar : Hq) {
                int i2;
                if (this.ujK.containsKey(abVar.field_username)) {
                    a(i, abVar, ((Long) this.ujK.get(abVar.field_username)).longValue());
                    i2 = i + 1;
                } else if (com.tencent.mm.l.a.gd(abVar.field_type)) {
                    this.laD.add(abVar);
                } else {
                    i2 = i;
                }
                i = i2;
            }
            Hq.clear();
        }
    }

    private void a(int i, ab abVar, long j) {
        int i2 = 0;
        while (i2 < i && j <= ((Long) this.ujK.get(((ab) this.laD.get(i2)).field_username)).longValue()) {
            i2++;
        }
        this.laD.add(i2, abVar);
    }

    protected final int getLayoutId() {
        return R.i.group_card_select;
    }

    private void Wp() {
        if (this.ujF) {
            String format;
            StringBuilder append = new StringBuilder().append(getString(R.l.app_ok));
            if (this.ujG.size() > 0) {
                format = String.format("(%s)", new Object[]{Integer.valueOf(this.ujG.size())});
            } else {
                format = "";
            }
            updateOptionMenuText(1, append.append(format).toString());
        }
    }
}
