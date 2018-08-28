package com.tencent.mm.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.c.bma;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd.d;
import com.tencent.mm.y.g.a;
import java.util.Iterator;
import java.util.LinkedList;

public class AllRemindMsgUI extends MMActivity implements e {
    private static final f<Integer, c> dzj = new f(32);
    private RecyclerView Sa;
    private ProgressBar eWx;
    private LinkedList<d> hBf;
    private View tgc;
    private b tgd;
    private a tge = new a(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        au.DF().a(866, this.tge);
        au.DF().a(525, this);
        h.mEJ.a(795, 3, 1, false);
        initView();
        com.tencent.mm.sdk.f.e.post(new a(this), "load remind data!");
    }

    protected void onDestroy() {
        super.onDestroy();
        au.DF().b(866, this.tge);
        au.DF().b(525, this);
    }

    protected final void initView() {
        setMMTitle(R.l.remind_title);
        this.Sa = (RecyclerView) findViewById(R.h.all_msg_list);
        this.eWx = (ProgressBar) findViewById(R.h.progress_bar);
        this.tgc = findViewById(R.h.hint_tip);
        this.Sa.setVisibility(8);
        RecyclerView recyclerView = this.Sa;
        ActionBarActivity actionBarActivity = this.mController.tml;
        recyclerView.setLayoutManager(new LinearLayoutManager());
        this.tgd = new b(this);
        this.Sa.setAdapter(this.tgd);
        this.tgd.a(new 1(this));
        setBackBtn(new 2(this));
    }

    public void onBackPressed() {
        finish();
    }

    protected final int getLayoutId() {
        return R.i.all_remind_msg_ui;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            Toast.makeText(this.mController.tml, bi.aG(str, getString(R.l.notify_message_settings_complain_failed)), 0).show();
        } else if (lVar.getType() == 525) {
            bma bma = (bma) ((com.tencent.mm.modelsimple.x) lVar).dZf.dID.dIL;
            Iterator listIterator = this.hBf.listIterator();
            while (listIterator.hasNext()) {
                if (((d) listIterator.next()).tgn == bma.sky.shm) {
                    listIterator.remove();
                }
            }
            this.tgd.RR.notifyChanged();
        }
    }

    public static String a(Context context, int i, String str, int i2) {
        String str2 = "";
        a gp = a.gp(str);
        switch (i) {
            case -1879048186:
                return context.getString(R.l.record_share_location_with_title, new Object[]{""});
            case -1879048185:
            case -1879048183:
            case -1879048176:
                return context.getString(R.l.record_app_with_title, new Object[]{""});
            case 1:
                return context.getString(R.l.app_brand_default_name_with_brackets);
            case 3:
            case 23:
            case 33:
                return context.getString(R.l.app_pic);
            case 34:
                n nVar = new n(str);
                return context.getString(R.l.record_voice_with_time, new Object[]{Integer.valueOf((int) q.bD(nVar.time))});
            case 37:
                if (str == null || str.length() <= 0) {
                    return str2;
                }
                d YY = d.YY(str);
                if (YY.otZ == null || YY.otZ.length() <= 0) {
                    return str2;
                }
                switch (YY.scene) {
                    case 18:
                        return context.getString(R.l.fmt_say_hello_to_you, new Object[]{YY.getDisplayName()});
                    case 22:
                    case 23:
                    case 24:
                    case 26:
                    case 27:
                    case f$k.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                    case f$k.AppCompatTheme_actionModeBackground /*29*/:
                        return context.getString(R.l.fmt_shake_say_hello_to_you, new Object[]{YY.getDisplayName()});
                    case 25:
                        return context.getString(R.l.fmt_bottle_say_hello_to_you, new Object[]{YY.getDisplayName()});
                    default:
                        return context.getString(R.l.fmt_want_to_be_your_friend, new Object[]{YY.getDisplayName()});
                }
            case f$k.AppCompatTheme_dialogTheme /*42*/:
            case f$k.AppCompatTheme_textAppearanceSearchResultSubtitle /*66*/:
                return context.getString(R.l.app_friend_card);
            case f$k.AppCompatTheme_dialogPreferredPadding /*43*/:
            case f$k.AppCompatTheme_editTextColor /*62*/:
                return context.getString(62 == i ? R.l.app_shortvideo : R.l.app_video);
            case f$k.AppCompatTheme_spinnerDropDownItemStyle /*47*/:
                return context.getString(R.l.app_emoji);
            case f$k.AppCompatTheme_homeAsUpIndicator /*48*/:
                au.HU();
                com.tencent.mm.model.c.FT().GS(str);
                return context.getString(R.l.record_location_with_title, new Object[]{""});
            case f$k.AppCompatTheme_actionButtonStyle /*49*/:
            case 553648177:
            case 587202609:
                if (gp != null) {
                    switch (gp.type) {
                        case 2:
                            return context.getString(R.l.app_pic);
                        case 3:
                            return context.getString(R.l.record_music_with_title, new Object[]{""});
                        case 4:
                            return context.getString(R.l.record_video_with_title, new Object[]{""});
                        case 5:
                        case 7:
                            return context.getString(R.l.record_url_with_title, new Object[]{""});
                        case 6:
                            return context.getString(R.l.record_file_with_title, new Object[]{gp.title});
                        case 8:
                            return context.getString(R.l.app_emoji2);
                        case 15:
                        case 26:
                        case 27:
                            return context.getString(R.l.app_emoji);
                        case 17:
                            return context.getString(R.l.record_location_with_title, new Object[]{""});
                        case 19:
                            return context.getString(R.l.record_record_with_title, new Object[]{""});
                        case 24:
                            return context.getString(R.l.record_note_with_title, new Object[]{""});
                        case 25:
                            return context.getString(R.l.app_designer_share);
                        case 33:
                            return context.getString(R.l.app_brand_default_name_with_brackets);
                        default:
                            x.i("MicroMsg.emoji.AllRemindMsgUI", "default type:%s", new Object[]{Integer.valueOf(gp.type)});
                            break;
                    }
                }
                x.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
                return "";
            case 369098801:
            case 452984881:
                return context.getString(R.l.record_card_with_title, new Object[]{""});
            case 419430449:
                return context.getString(R.l.record_remittance_with_title);
            case 436207665:
            case 469762097:
                if (gp == null) {
                    x.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
                    return "";
                } else if (i2 == 1) {
                    return context.getString(R.l.record_c2c_with_title, new Object[]{gp.dxZ, ""});
                } else {
                    return context.getString(R.l.record_c2c_with_title, new Object[]{gp.dxZ, ""});
                }
            case 503316529:
                if (gp == null) {
                    x.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
                    return "";
                }
                return context.getString(R.l.record_c2c_with_title, new Object[]{gp.dxZ, ""});
            case 520093745:
                return context.getString(R.l.record_card_with_title, new Object[]{""});
        }
        return context.getString(R.l.none_type);
    }
}
