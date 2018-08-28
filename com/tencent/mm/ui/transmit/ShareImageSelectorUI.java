package com.tencent.mm.ui.transmit;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.rtmp.TXLiveConstants;
import java.util.ArrayList;

public class ShareImageSelectorUI extends MMActivity implements OnItemClickListener {
    private static int uEP = 1;
    private ListView CU;
    private View imD;
    private ImageView isa;
    private String kWv;
    private ag mHandler = new 2(this);
    private a uEQ;
    private Dialog uER;
    private OnClickListener uES = new 1(this);
    private int ulm = 2;

    static /* synthetic */ void a(ShareImageSelectorUI shareImageSelectorUI) {
        Intent intent = new Intent(shareImageSelectorUI, ShowImageUI.class);
        intent.putExtra("key_image_path", shareImageSelectorUI.kWv);
        intent.putExtra("show_menu", false);
        shareImageSelectorUI.startActivity(intent);
    }

    protected final int getLayoutId() {
        return R.i.share_image_selector;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        au.HU();
        Object obj = c.DT().get(229635, null);
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            if (intValue == 0 || intValue == 1) {
                uEP = intValue;
            }
        }
        setMMTitle(R.l.menu_item_send_image);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ShareImageSelectorUI.this.aZM();
                return false;
            }
        });
        this.ulm = getIntent().getIntExtra("Select_Conv_Type", 2);
        this.kWv = getIntent().getStringExtra("intent_extra_image_path");
        this.imD = findViewById(R.h.main);
        this.isa = (ImageView) findViewById(R.h.image);
        this.isa.setOnClickListener(this.uES);
        this.CU = (ListView) findViewById(R.h.list);
        this.uEQ = new a(this);
        this.CU.setAdapter(this.uEQ);
        this.CU.setOnItemClickListener(this);
        x.d("MicroMsg.ShareImageSelectorUI", "mSelectType:%s ImagePath:%s", new Object[]{this.ulm, this.kWv});
        if (uEP == 1) {
            setTitleVisibility(8);
            this.CU.setVisibility(8);
            this.isa.setLayoutParams(new LayoutParams(-1, -1));
            this.isa.setPadding(0, 0, 0, 0);
            this.isa.setOnClickListener(null);
            this.imD.setBackgroundColor(getResources().getColor(R.e.dark_bg_color));
            cAk();
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bitmap oQ = y.oQ(this.kWv);
        x.d("MicroMsg.ShareImageSelectorUI", "cpan [onCreate]degree:%d", new Object[]{Integer.valueOf(ExifHelper.VX(this.kWv))});
        oQ = com.tencent.mm.sdk.platformtools.c.b(oQ, (float) r3);
        if (!(oQ == null || oQ.isRecycled())) {
            this.isa.setImageBitmap(oQ);
        }
        x.d("MicroMsg.ShareImageSelectorUI", "cpan[onCreate] Read Bitmap Time:%s", new Object[]{(System.currentTimeMillis() - currentTimeMillis) + "'"});
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected void onResume() {
        super.onResume();
        if (uEP != 1) {
            return;
        }
        if (this.uER == null || !this.uER.isShowing()) {
            cAk();
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (i) {
            case 0:
                cAl();
                return;
            case 1:
                cAm();
                return;
            case 2:
                cAn();
                return;
            default:
                x.e("MicroMsg.ShareImageSelectorUI", "unknow postion.");
                return;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.ShareImageSelectorUI", "requestCode:%d , resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case TXLiveConstants.PUSH_EVT_CONNECT_SUCC /*1001*/:
                if (i2 == -1) {
                    ArrayList arrayList = null;
                    if (intent != null) {
                        arrayList = intent.getStringArrayListExtra("Select_Contact");
                    }
                    if (arrayList != null && arrayList.size() == 1) {
                        Intent intent2 = new Intent(this, ChattingUI.class);
                        intent2.putExtra("Chat_User", (String) arrayList.get(0));
                        startActivity(intent2);
                    }
                    finish();
                    return;
                }
                x.w("MicroMsg.ShareImageSelectorUI", "user cancle");
                return;
            case TXLiveConstants.PUSH_EVT_PUSH_BEGIN /*1002*/:
                if (i2 == -1) {
                    Toast.makeText(this.mController.tml, R.l.confirm_dialog_sent, 0).show();
                    finish();
                    return;
                }
                x.w("MicroMsg.ShareImageSelectorUI", "user cancle");
                return;
            default:
                x.w("MicroMsg.ShareImageSelectorUI", "unknow result");
                return;
        }
    }

    public void onBackPressed() {
        aZM();
    }

    private void aZM() {
        h.a(this.mController.tml, getString(R.l.cropimg_share_cancle), getString(R.l.cropimg_share_title), true, new 4(this), new 5(this));
    }

    private void cAk() {
        if (this.uER == null || !this.uER.isShowing()) {
            this.uER = h.a(this.mController.tml, getString(R.l.menu_item_send_image), new String[]{getString(R.l.cropimg_share_to_friend), getString(R.l.cropimg_share_to_sns), getString(R.l.cropimg_share_to_fav)}, null, new 6(this), new 7(this));
        }
    }

    private void cAl() {
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_attr", s.ukL);
        intent.putExtra("titile", getString(R.l.address_title_dis_send_friend));
        intent.putExtra("list_type", 11);
        intent.putExtra("shareImage", true);
        intent.putExtra("shareImagePath", this.kWv);
        startActivityForResult(intent, TXLiveConstants.PUSH_EVT_CONNECT_SUCC);
    }

    private void cAm() {
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_type", 0);
        intent.putExtra("sns_kemdia_path", this.kWv);
        intent.putExtra("need_result", true);
        d.b(this.mController.tml, "sns", ".ui.SnsUploadUI", intent, TXLiveConstants.PUSH_EVT_PUSH_BEGIN);
    }

    private void cAn() {
        ch chVar = new ch();
        e.a(chVar, 6, this.kWv);
        chVar.bJF.activity = this;
        chVar.bJF.bJM = 52;
        a.sFg.m(chVar);
        com.tencent.mm.plugin.report.service.h.mEJ.h(11048, new Object[]{Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0)});
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(0, 800);
        }
    }
}
