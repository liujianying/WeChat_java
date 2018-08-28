package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.setting.a;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ShowQRCodeStep1UI extends MMActivity implements e {
    private ProgressDialog eHw = null;
    private int mPD = 1;
    private ImageView mPI = null;
    byte[] mPJ = null;

    protected final int getLayoutId() {
        return g.show_qrcode_step1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        com.tencent.mm.kernel.g.DF().a(168, this);
    }

    public void onDestroy() {
        com.tencent.mm.kernel.g.DF().b(168, this);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(i.send_qrcode_to_microblog);
        this.mPI = (ImageView) findViewById(f.self_qrcode_iv);
        this.mPD = getIntent().getIntExtra("show_to", 1);
        TextView textView = (TextView) findViewById(f.show_qrcode_info_tv);
        if (this.mPD == 3) {
            textView.setText(getString(i.self_qrcode_show_all, new Object[]{getString(i.self_qrcode_show_all_sina)}));
        } else if (this.mPD == 4) {
            textView.setText(getString(i.self_qrcode_show_all, new Object[]{getString(i.self_qrcode_show_all_facebook)}));
        } else if (this.mPD == 2) {
            textView.setText(getString(i.self_qrcode_show_all, new Object[]{getString(i.self_qrcode_show_all_qzone)}));
        } else {
            textView.setText(getString(i.self_qrcode_show_all, new Object[]{getString(i.self_qrcode_show_all_qqwb)}));
        }
        bts();
        setBackBtn(new 1(this));
        addIconOptionMenu(0, a.e.mm_title_btn_menu, new 2(this));
        ((Button) findViewById(f.self_qrcode_share_btn)).setOnClickListener(new 3(this));
    }

    final void bts() {
        com.tencent.mm.as.a aVar = new com.tencent.mm.as.a();
        com.tencent.mm.kernel.g.DF().a(aVar, 0);
        Context context = this.mController.tml;
        getString(i.app_tip);
        this.eHw = h.a(context, getString(i.self_qrcode_getting), true, new 5(this, aVar));
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.ShowQRCodeStep1UI", "onSceneEnd: errType = %d errCode = %d errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.eHw != null) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        if (!b.ezo.b(this.mController.tml, i, i2, str)) {
            if (i == 0 && i2 == 0) {
                this.mPJ = ((com.tencent.mm.as.a) lVar).edg;
                this.mPI.setImageBitmap(c.bs(this.mPJ));
                return;
            }
            Toast.makeText(this, getString(i.fmt_self_qrcode_getting_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
