package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.ipcall.a.e.e;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.l;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public class IPCallUserProfileUI extends MMActivity {
    private String cbH;
    private String cbJ;
    private ImageView eBM;
    private boolean kut = false;
    private TextView kzg;
    private TextView kzh;
    private LinearLayout kzi;
    private LinearLayout kzj;
    private TextView kzk;
    private TextView kzl;
    private TextView kzm;
    private TextView kzn;
    private TextView kzo;
    private Button kzp;
    private String kzq;
    private String kzr;
    private Bitmap kzs;
    private boolean kzt;
    private Cursor kzu = null;
    private boolean kzv = false;
    private e kzw = new e();

    static /* synthetic */ void b(IPCallUserProfileUI iPCallUserProfileUI, String str) {
        if (!bi.oW(iPCallUserProfileUI.cbH) && !bi.oW(str) && !str.endsWith("@stranger")) {
            c EP = i.aXv().EP(iPCallUserProfileUI.cbH);
            if (EP.sKx > 0) {
                EP.field_wechatUsername = str;
                i.aXv().a(EP.sKx, EP);
            }
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h.mEJ.h(12061, new Object[]{Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        setBackBtn(new 1(this));
        setMMTitle(R.l.ip_call_profile_title);
        this.eBM = (ImageView) findViewById(R.h.avatar_iv);
        this.kzg = (TextView) findViewById(R.h.system_addrbook_username_tv);
        this.kzh = (TextView) findViewById(R.h.wechat_username_tv);
        this.kzi = (LinearLayout) findViewById(R.h.profile_phonenumber_ll);
        this.kzk = (TextView) findViewById(R.h.profile_op_save_phonenumber_button);
        this.kzm = (TextView) findViewById(R.h.profile_op_copy_phonenumber_button);
        this.kzl = (TextView) findViewById(R.h.profile_op_call_phonenumber_button);
        this.kzj = (LinearLayout) findViewById(R.h.profile_record_ll);
        this.kzn = (TextView) findViewById(R.h.record_title);
        this.kzo = (TextView) findViewById(R.h.invite_friend_text);
        this.kzp = (Button) findViewById(R.h.profile_invite_op_btn);
        this.cbH = getIntent().getStringExtra("IPCallProfileUI_contactid");
        this.kzq = getIntent().getStringExtra("IPCallProfileUI_systemUsername");
        this.kzr = getIntent().getStringExtra("IPCallProfileUI_wechatUsername");
        this.cbJ = getIntent().getStringExtra("IPCallProfileUI_phonenumber");
        this.kzv = getIntent().getBooleanExtra("IPCallProfileUI_isNeedShowRecord", false);
        if (!bi.oW(this.cbH)) {
            this.kzs = a.ay(this, this.cbH);
            if (this.kzs != null) {
                this.eBM.setImageBitmap(this.kzs);
            }
        }
        if (this.kzs == null && !bi.oW(this.kzr)) {
            this.kzs = com.tencent.mm.aa.c.a(this.kzr, false, -1);
            if (this.kzs != null) {
                this.eBM.setImageBitmap(this.kzs);
            }
        }
        if (!bi.oW(this.kzq)) {
            this.kzg.setText(this.kzq);
        } else if (!bi.oW(this.cbJ)) {
            this.kzg.setText(a.Ft(this.cbJ));
        }
        if (bi.oW(this.kzr) || this.kzr.endsWith("@stranger")) {
            this.kzh.setVisibility(8);
        } else {
            this.kzh.setText(j.a(this, getString(R.l.ip_call_profile_wechat_username_format, new Object[]{r.gT(this.kzr)})));
        }
        if (!bi.oW(this.cbH)) {
            if (com.tencent.mm.pluginsdk.permission.a.bj(this, "android.permission.READ_CONTACTS")) {
                this.kzu = getContentResolver().query(Phone.CONTENT_URI, null, "contact_id=?", new String[]{this.cbH}, null);
                this.kut = this.kzu.getCount() <= 1;
            } else {
                x.e("MicroMsg.IPCallUserProfileUI", "no contact permission");
                return;
            }
        }
        aYs();
        this.kzm.setVisibility(8);
        this.kzl.setVisibility(8);
        this.kzk.setVisibility(8);
        this.kzp.setVisibility(8);
        this.kzo.setVisibility(8);
        if (!bi.oW(this.kzr) && !bi.oW(this.kzq)) {
            au.HU();
            ab Yg = com.tencent.mm.model.c.FR().Yg(this.kzr);
            if (!(Yg == null || com.tencent.mm.l.a.gd(Yg.field_type))) {
                this.kzp.setOnClickListener(new 8(this));
                this.kzp.setText(R.l.ip_call_profile_add_wechat_friend_btn);
                this.kzp.setVisibility(0);
            }
        } else if (!bi.oW(this.cbH) && !bi.oW(this.kzq)) {
            aYr();
            this.kzp.setText(R.l.ip_call_profile_invite_wechat_friend_btn);
        } else if (!bi.oW(this.cbJ)) {
            this.kzl.setVisibility(0);
            this.kzm.setVisibility(0);
            Context context = ad.getContext();
            Intent intent = new Intent("android.intent.action.INSERT");
            intent.setType("vnd.android.cursor.dir/contact");
            intent.putExtra("phone", "10086");
            if (bi.k(context, intent)) {
                this.kzk.setVisibility(0);
            }
            this.kzk.setOnClickListener(new 10(this));
            this.kzl.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    IPCallUserProfileUI.a(IPCallUserProfileUI.this, IPCallUserProfileUI.this.cbJ);
                }
            });
            this.kzm.setOnClickListener(new 2(this));
            aYr();
            this.kzp.setText(R.l.ip_call_profile_invite_wechat_friend_btn);
        }
        aYq();
    }

    protected final int getLayoutId() {
        return R.i.ip_call_user_profile_ui;
    }

    private void aYq() {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        if (this.kzu == null || this.kzu.getCount() <= 0) {
            this.kzi.setVisibility(8);
            return;
        }
        try {
            if (this.kzu.moveToFirst()) {
                while (!this.kzu.isAfterLast()) {
                    i++;
                    String string = this.kzu.getString(this.kzu.getColumnIndex("data1"));
                    int i2 = this.kzu.getInt(this.kzu.getColumnIndex("data2"));
                    if (!arrayList.contains(string)) {
                        arrayList.add(string);
                        if (i == this.kzu.getCount()) {
                            k(string, i2, false);
                        } else {
                            k(string, i2, true);
                        }
                    }
                    this.kzu.moveToNext();
                }
            }
            this.kzu.close();
        } catch (Exception e) {
            x.e("MicroMsg.IPCallUserProfileUI", "initPhoneNumberList error: %s", new Object[]{e.getMessage()});
            this.kzu.close();
        } catch (Throwable th) {
            this.kzu.close();
            throw th;
        }
    }

    private void k(String str, int i, boolean z) {
        View inflate = LayoutInflater.from(this).inflate(R.i.profile_phonenumber_item, this.kzi, false);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.h.list_item_layot);
        if (z) {
            linearLayout.setBackgroundDrawable(getResources().getDrawable(R.g.list_item_normal));
        } else {
            linearLayout.setBackgroundDrawable(null);
        }
        TextView textView = (TextView) inflate.findViewById(R.h.phonenumber_type_tv);
        TextView textView2 = (TextView) inflate.findViewById(R.h.phonenumber_tv);
        textView2.setText(a.Ft(com.tencent.mm.plugin.ipcall.b.c.Fx(str)));
        textView.setText(a.rK(i));
        inflate.setClickable(true);
        inflate.setOnClickListener(new 4(this, str));
        inflate.setOnLongClickListener(new 5(this, textView2));
        this.kzi.addView(inflate);
    }

    private static String Fh(String str) {
        Exception e;
        String str2 = "";
        if (com.tencent.mm.pluginsdk.permission.a.bj(ad.getContext(), "android.permission.READ_CONTACTS")) {
            Cursor query = ad.getContext().getContentResolver().query(Phone.CONTENT_URI, null, "contact_id=?", new String[]{str}, null);
            if (query == null) {
                return null;
            }
            String str3;
            try {
                if (query.moveToFirst()) {
                    str3 = str2;
                    while (!query.isAfterLast()) {
                        try {
                            str3 = str3 + query.getString(query.getColumnIndex("data1")) + ",";
                            query.moveToNext();
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                x.e("MicroMsg.IPCallUserProfileUI", "extractAddressItemFromCursor, error: %s, class: %s", new Object[]{e.getMessage(), e.getClass().getSimpleName()});
                                if (str3.lastIndexOf(",") >= 0) {
                                    str3 = str3.substring(0, str3.lastIndexOf(","));
                                }
                                return str3;
                            } finally {
                                query.close();
                            }
                        }
                    }
                } else {
                    str3 = str2;
                }
                query.close();
            } catch (Exception e3) {
                e = e3;
                str3 = str2;
            }
            if (str3.lastIndexOf(",") >= 0) {
                str3 = str3.substring(0, str3.lastIndexOf(","));
            }
            return str3;
        }
        x.e("MicroMsg.IPCallUserProfileUI", "no contact permission");
        return null;
    }

    private void aYr() {
        this.kzp.setOnClickListener(new 9(this));
    }

    private void aYs() {
        Cursor query;
        if (!this.kzv) {
            this.kzj.setVisibility(8);
            this.kzn.setVisibility(8);
        }
        if (bi.oW(this.cbH)) {
            l aXw = i.aXw();
            String str = this.cbJ;
            query = aXw.diF.query("IPCallRecord", l.ksH, "phonenumber=?", new String[]{str}, null, null, "calltime desc limit 4");
        } else {
            Cursor query2;
            String str2 = this.cbH;
            if (!bi.oW(str2)) {
                c EP = i.aXv().EP(str2);
                if (!(EP == null || EP.sKx == -1)) {
                    long j = EP.sKx;
                    query2 = i.aXw().diF.query("IPCallRecord", l.ksH, "addressId=?", new String[]{String.valueOf(j)}, null, null, "calltime desc limit 4");
                    query = query2;
                }
            }
            query2 = null;
            query = query2;
        }
        if (query == null || query.getCount() <= 0) {
            this.kzj.setVisibility(8);
            this.kzn.setVisibility(8);
            return;
        }
        try {
            if (query.moveToFirst()) {
                int i = 0;
                while (!query.isAfterLast()) {
                    Object obj;
                    k kVar = new k();
                    kVar.d(query);
                    int i2 = i + 1;
                    if (i2 >= 3) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    int count = query.getCount();
                    View inflate = LayoutInflater.from(this).inflate(R.i.profile_record_item, this.kzj, false);
                    TextView textView = (TextView) inflate.findViewById(R.h.profile_record_calltime_tv);
                    TextView textView2 = (TextView) inflate.findViewById(R.h.profile_record_status_duration_tv);
                    ((TextView) inflate.findViewById(R.h.profile_record_phonenumber_tv)).setText(a.Ft(kVar.field_phonenumber));
                    if (kVar.field_duration > 0) {
                        textView2.setText(com.tencent.mm.plugin.ipcall.b.c.dT(kVar.field_duration));
                    } else {
                        textView2.setText(com.tencent.mm.plugin.ipcall.b.c.rL(kVar.field_status));
                    }
                    textView.setText(com.tencent.mm.plugin.ipcall.b.c.dR(kVar.field_calltime));
                    if (obj != null) {
                        inflate.setBackgroundDrawable(getResources().getDrawable(R.g.profile_record_background_with_line));
                        i = getResources().getDimensionPixelSize(R.f.profile_info_basic_left_right_margin);
                        inflate.setPadding(i, 0, i, 0);
                    }
                    if (1 == count) {
                        LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
                        layoutParams.height = com.tencent.mm.bp.a.ad(this.mController.tml, R.f.only_one_record_layout_height);
                        inflate.setLayoutParams(layoutParams);
                    }
                    this.kzj.addView(inflate);
                    if (obj != null) {
                        i = i2;
                        break;
                    } else {
                        query.moveToNext();
                        i = i2;
                    }
                }
                if (i <= 0) {
                    this.kzj.setVisibility(8);
                } else if (query.getCount() >= 4) {
                    View inflate2 = LayoutInflater.from(this).inflate(R.i.profile_record_item_see_more, this.kzj, false);
                    this.kzj.addView(inflate2);
                    inflate2.setOnClickListener(new 3(this));
                }
            }
            query.close();
        } catch (Exception e) {
            x.e("MicroMsg.IPCallUserProfileUI", "initRecordList, error: %s", new Object[]{e.getMessage()});
            query.close();
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.kzt) {
            this.kzt = false;
            this.kzj.removeAllViews();
            aYs();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }
}
