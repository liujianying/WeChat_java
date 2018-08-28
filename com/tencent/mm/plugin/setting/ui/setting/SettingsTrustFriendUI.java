package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.setting.a.d;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.air;
import com.tencent.mm.protocal.c.bud;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.contact.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SettingsTrustFriendUI extends MMActivity implements e {
    private static int mUk = 5;
    private p iKZ;
    private GridView jBW;
    private TextView kbW;
    private boolean mSv;
    private List<String> mUh;
    private a mUi;
    private View mUj;

    private class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(SettingsTrustFriendUI settingsTrustFriendUI, byte b) {
            this();
        }

        public final int getCount() {
            int size = SettingsTrustFriendUI.this.mUh.size();
            if (SettingsTrustFriendUI.this.mSv) {
                return size;
            }
            if (size == 0) {
                return 1;
            }
            if (size <= 0 || size >= SettingsTrustFriendUI.mUk) {
                return size >= SettingsTrustFriendUI.mUk ? size + 1 : 0;
            } else {
                return size + 2;
            }
        }

        public final Object getItem(int i) {
            if (getItemViewType(i) == 0) {
                return SettingsTrustFriendUI.this.mUh.get(i);
            }
            return null;
        }

        public final int getItemViewType(int i) {
            int size = SettingsTrustFriendUI.this.mUh.size();
            if (SettingsTrustFriendUI.this.mSv || i < size) {
                return 0;
            }
            if (size == 0) {
                return 1;
            }
            if (size >= SettingsTrustFriendUI.mUk) {
                return 2;
            }
            if (i == size) {
                return 1;
            }
            if (i == size + 1) {
                return 2;
            }
            return -1;
        }

        public final int getViewTypeCount() {
            return 3;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = SettingsTrustFriendUI.this.getLayoutInflater().inflate(g.settings_trust_friend_item, null);
                ImageView imageView = (ImageView) view.findViewById(f.trust_friend_avatar);
                ImageView imageView2 = (ImageView) view.findViewById(f.trust_friend_del_btn);
                TextView textView = (TextView) view.findViewById(f.trust_friend_name);
                a aVar2 = new a(this, (byte) 0);
                aVar2.mMu = imageView;
                aVar2.mUo = imageView2;
                aVar2.haS = textView;
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                String str = (String) SettingsTrustFriendUI.this.mUh.get(i);
                ab Yg = ((i) com.tencent.mm.kernel.g.l(i.class)).FR().Yg(str);
                aVar.mMu.setScaleType(ScaleType.FIT_XY);
                b.a(aVar.mMu, str);
                aVar.haS.setText(j.a(SettingsTrustFriendUI.this, Yg.BL(), aVar.haS.getTextSize()));
                if (SettingsTrustFriendUI.this.mSv) {
                    aVar.mUo.setVisibility(0);
                } else {
                    aVar.mUo.setVisibility(8);
                }
            } else {
                aVar.haS.setVisibility(4);
                aVar.mUo.setVisibility(8);
                aVar.mMu.setScaleType(ScaleType.FIT_XY);
                if (getItemViewType(i) == 1) {
                    aVar.mMu.setImageResource(com.tencent.mm.plugin.setting.a.e.big_add_selector);
                } else if (getItemViewType(i) == 2) {
                    aVar.mMu.setImageResource(com.tencent.mm.plugin.setting.a.e.big_del_selector);
                }
            }
            return view;
        }
    }

    static /* synthetic */ void a(SettingsTrustFriendUI settingsTrustFriendUI) {
        com.tencent.mm.plugin.setting.model.e eVar = new com.tencent.mm.plugin.setting.model.e();
        com.tencent.mm.kernel.g.DF().a(eVar, 0);
        settingsTrustFriendUI.getString(com.tencent.mm.plugin.setting.a.i.app_empty_string);
        settingsTrustFriendUI.iKZ = h.a(settingsTrustFriendUI, settingsTrustFriendUI.getString(com.tencent.mm.plugin.setting.a.i.loading_tips), true, new 5(settingsTrustFriendUI, eVar));
    }

    static /* synthetic */ void h(SettingsTrustFriendUI settingsTrustFriendUI) {
        if (settingsTrustFriendUI.mUh.size() <= 0 || settingsTrustFriendUI.mUh.size() >= 3) {
            com.tencent.mm.plugin.setting.model.b bVar = new com.tencent.mm.plugin.setting.model.b(settingsTrustFriendUI.mUh);
            com.tencent.mm.kernel.g.DF().a(bVar, 0);
            if (settingsTrustFriendUI.iKZ != null) {
                settingsTrustFriendUI.iKZ.dismiss();
            }
            settingsTrustFriendUI.getString(com.tencent.mm.plugin.setting.a.i.app_empty_string);
            settingsTrustFriendUI.iKZ = h.a(settingsTrustFriendUI, settingsTrustFriendUI.getString(com.tencent.mm.plugin.setting.a.i.app_sending), true, new 2(settingsTrustFriendUI, bVar));
            return;
        }
        h.b(settingsTrustFriendUI, settingsTrustFriendUI.getString(com.tencent.mm.plugin.setting.a.i.settings_trust_friend_min_limit_tip, new Object[]{Integer.valueOf(3)}), settingsTrustFriendUI.getString(com.tencent.mm.plugin.setting.a.i.app_tip), true);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String str = (String) com.tencent.mm.kernel.g.Ei().DT().get(352277, null);
        if (!bi.oW(str)) {
            this.mUh = bi.F(str.split(","));
        }
        if (this.mUh == null) {
            this.mUh = new ArrayList();
        }
        this.mController.contentView.post(new 1(this));
        initView();
    }

    protected final int getLayoutId() {
        return g.settings_trust_friend;
    }

    public void onStart() {
        super.onStart();
        com.tencent.mm.kernel.g.DF().a(869, this);
        com.tencent.mm.kernel.g.DF().a(583, this);
    }

    protected void onStop() {
        super.onStop();
        com.tencent.mm.kernel.g.DF().b(869, this);
        com.tencent.mm.kernel.g.DF().b(583, this);
    }

    protected final void initView() {
        setMMTitle(com.tencent.mm.plugin.setting.a.i.settings_trust_friend);
        this.jBW = (GridView) findViewById(f.trust_friend_grid);
        this.mUi = new a(this, (byte) 0);
        this.jBW.setColumnWidth(getResources().getDimensionPixelSize(d.NormalAvatarWrapSize));
        this.jBW.setNumColumns(-1);
        this.jBW.setStretchMode(1);
        this.jBW.setHorizontalSpacing(getResources().getDimensionPixelSize(d.grid_item_left_right_padding) * 2);
        this.jBW.setVerticalSpacing(getResources().getDimensionPixelSize(d.grid_item_top_bottom_padding));
        this.jBW.setAdapter(this.mUi);
        ((ViewGroup) this.jBW.getParent()).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (SettingsTrustFriendUI.this.mSv) {
                    SettingsTrustFriendUI.this.mSv = false;
                    SettingsTrustFriendUI.this.mUi.notifyDataSetChanged();
                }
            }
        });
        this.jBW.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (!SettingsTrustFriendUI.this.mSv || motionEvent.getAction() != 1 || SettingsTrustFriendUI.this.jBW.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY()) != -1) {
                    return false;
                }
                SettingsTrustFriendUI.this.mSv = false;
                SettingsTrustFriendUI.this.mUi.notifyDataSetChanged();
                return true;
            }
        });
        this.jBW.setHorizontalScrollBarEnabled(false);
        this.jBW.setVerticalScrollBarEnabled(false);
        this.jBW.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (SettingsTrustFriendUI.this.mUi.getItemViewType(i) == 1) {
                    Intent intent = new Intent();
                    intent.putExtra("list_type", 12);
                    intent.putExtra("titile", SettingsTrustFriendUI.this.getString(com.tencent.mm.plugin.setting.a.i.address_title_select_contact));
                    intent.putExtra("scene", 2);
                    intent.putExtra("max_limit_num", SettingsTrustFriendUI.mUk);
                    intent.putExtra("stay_in_wechat", true);
                    intent.putExtra("already_select_contact", bi.c(SettingsTrustFriendUI.this.mUh, ","));
                    intent.putExtra("block_contact", q.GF());
                    intent.putExtra("list_attr", s.fc(s.ukK, 256));
                    intent.putExtra("too_many_member_tip_string", SettingsTrustFriendUI.this.getString(com.tencent.mm.plugin.setting.a.i.settings_trust_friend_max_limit_tip, new Object[]{Integer.valueOf(SettingsTrustFriendUI.mUk)}));
                    com.tencent.mm.bg.d.b(SettingsTrustFriendUI.this, ".ui.contact.SelectContactUI", intent, 1);
                    return;
                }
                if (SettingsTrustFriendUI.this.mUi.getItemViewType(i) == 2) {
                    if (!SettingsTrustFriendUI.this.mSv) {
                        SettingsTrustFriendUI.this.mSv = true;
                    } else {
                        return;
                    }
                } else if (SettingsTrustFriendUI.this.mUi.getItemViewType(i) == 0 && SettingsTrustFriendUI.this.mSv) {
                    SettingsTrustFriendUI.this.mUh.remove(SettingsTrustFriendUI.this.mUi.getItem(i));
                    if (SettingsTrustFriendUI.this.mUh.size() == 0) {
                        SettingsTrustFriendUI.this.mSv = false;
                    }
                } else {
                    return;
                }
                SettingsTrustFriendUI.this.mUi.notifyDataSetChanged();
            }
        });
        this.kbW = (TextView) findViewById(f.trust_friend_desc);
        CharSequence stringExtra = getIntent().getStringExtra(com.tencent.mm.ui.e.g.thy);
        if (bi.oW(stringExtra)) {
            this.kbW.setText(getResources().getString(com.tencent.mm.plugin.setting.a.i.settings_trust_friend_tip, new Object[]{Integer.valueOf(3)}));
        } else {
            this.kbW.setText(stringExtra);
        }
        this.mUj = findViewById(f.trust_friend_warn_banner);
        this.mUj.setVisibility(8);
        ((TextView) this.mUj.findViewById(f.warn_tip)).setText(getString(com.tencent.mm.plugin.setting.a.i.settings_trust_friend_min_limit_tip, new Object[]{Integer.valueOf(3)}));
        this.mUj.findViewById(f.close_icon).setOnClickListener(new 9(this));
        findViewById(f.trust_friend_link).setOnClickListener(new 10(this));
        setBackBtn(new 11(this));
        a(1, getString(com.tencent.mm.plugin.setting.a.i.app_finish), new 12(this), com.tencent.mm.ui.s.b.tmX);
        showOptionMenu(true);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            String stringExtra = intent.getStringExtra("Select_Contact");
            if (!bi.oW(stringExtra)) {
                this.mUh.clear();
                this.mUh.addAll(bi.F(stringExtra.split(",")));
                this.mUi.notifyDataSetChanged();
            }
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.SettingsTrustFriendUI", "errType %d,errCode %d,errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.iKZ != null) {
            this.iKZ.dismiss();
        }
        if (i == 0 && i2 == 0) {
            if (lVar.getType() == 869) {
                int i3;
                air air = (air) ((com.tencent.mm.ab.b) lVar.dJd).dIE.dIL;
                mUk = air.rLs;
                List<bud> list = air.rcx;
                if (list.size() != this.mUh.size()) {
                    i3 = 1;
                    break;
                } else if (list.size() == 0) {
                    i3 = 0;
                } else {
                    for (bud bud : list) {
                        if (!this.mUh.contains(bud.hbL)) {
                            i3 = 1;
                            break;
                        }
                    }
                    i3 = 0;
                }
                if (i3 != 0) {
                    this.mUh.clear();
                    for (bud bud2 : list) {
                        this.mUh.add(bud2.hbL);
                    }
                    this.mUi.notifyDataSetChanged();
                }
                if (this.mUh.size() > 0 && this.mUh.size() < 3) {
                    this.mUj.setVisibility(0);
                }
                com.tencent.mm.kernel.g.Ei().DT().set(352277, bi.c(this.mUh, ","));
            } else if (lVar.getType() == 583) {
                com.tencent.mm.kernel.g.Ei().DT().set(352277, bi.c(this.mUh, ","));
                finish();
            }
        } else if (!bi.oW(str)) {
            h.bA(this, str);
        }
    }

    private void bua() {
        Collection F;
        String str = (String) com.tencent.mm.kernel.g.Ei().DT().get(352277, null);
        ArrayList arrayList = new ArrayList();
        if (bi.oW(str)) {
            Object F2 = arrayList;
        } else {
            F2 = bi.F(str.split(","));
        }
        if (this.mUh.size() == F2.size() && this.mUh.containsAll(F2)) {
            finish();
        } else {
            h.a(this, getString(com.tencent.mm.plugin.setting.a.i.save_label_msg), getString(com.tencent.mm.plugin.setting.a.i.app_tip), getString(com.tencent.mm.plugin.setting.a.i.app_save), getString(com.tencent.mm.plugin.setting.a.i.app_not_save), true, new 3(this), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SettingsTrustFriendUI.this.finish();
                }
            });
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        bua();
        return true;
    }
}
