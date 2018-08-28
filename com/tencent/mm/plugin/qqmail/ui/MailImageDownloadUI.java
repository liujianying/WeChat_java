package com.tencent.mm.plugin.qqmail.ui;

import android.os.Bundle;
import android.os.Looper;
import android.support.design.a$i;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.f;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.k;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class MailImageDownloadUI extends MMActivity implements e, f {
    private long bJC = 0;
    private long bYu = 0;
    private int dTO;
    private ag handler = new ag(Looper.getMainLooper());
    private ProgressBar mhq;
    private TextView mhr;
    private TextView mhs;
    private TextView mht;
    private TextView mhu;
    private RelativeLayout mhv;
    private com.tencent.mm.ak.e mhw;
    private k mhx;
    private ImageView mhy;
    private LinearLayout mhz;
    private String username;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bJC = getIntent().getLongExtra("img_msg_id", 0);
        this.bYu = getIntent().getLongExtra("img_server_id", 0);
        this.dTO = getIntent().getIntExtra("img_download_compress_type", 0);
        this.username = getIntent().getStringExtra("img_download_username");
        initView();
        if (this.bJC > 0) {
            this.mhw = o.Pf().br(this.bJC);
        }
        if ((this.mhw == null || this.mhw.dTK <= 0) && this.bYu > 0) {
            this.mhw = o.Pf().bq(this.bYu);
        }
        if (this.mhw == null || this.mhw.dTK <= 0) {
            x.e("MicroMsg.MailImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.bJC + ", or msgSvrId = " + this.bYu);
            return;
        }
        if (this.bJC <= 0 && this.bYu > 0) {
            au.HU();
            this.bJC = c.FT().I(this.username, this.bYu).field_msgId;
        }
        String str = this.mhw.dTL;
        String o = o.Pf().o(str, null, null);
        if (bi.oW(str) || !com.tencent.mm.a.e.cn(o)) {
            this.mhx = new k(this.mhw.dTK, this.bJC, this.dTO, this);
            au.DF().a(this.mhx, 0);
            return;
        }
        x.i("MicroMsg.MailImageDownloadUI", "has big image, bigImgPath = %s, hasHDImg = %b, fullPath = %s", new Object[]{str, Boolean.valueOf(this.mhw.ON()), o});
        if (o == null || o.equals("") || !com.tencent.mm.a.e.cn(o)) {
            x.d("MicroMsg.MailImageDownloadUI", "showImg : imgPath is null");
            return;
        }
        this.mhz.setVisibility(8);
        this.mhq.setVisibility(8);
        this.mhy.setVisibility(0);
        this.mhy.setImageBitmap(com.tencent.mm.sdk.platformtools.c.Wb(o));
        this.mhv.invalidate();
    }

    protected final int getLayoutId() {
        return R.i.mail_image_download;
    }

    protected void onPause() {
        super.onPause();
        au.DF().b(a$i.AppCompatTheme_seekBarStyle, this);
    }

    protected void onResume() {
        super.onResume();
        au.DF().a(a$i.AppCompatTheme_seekBarStyle, this);
    }

    protected final void initView() {
        this.mhr = (TextView) findViewById(R.h.image_download_percent_tv);
        this.mhs = (TextView) findViewById(R.h.image_download_percent_tv);
        this.mht = (TextView) findViewById(R.h.image_download_size_tv);
        this.mhu = (TextView) findViewById(R.h.image_download_length_tv);
        this.mhy = (ImageView) findViewById(R.h.mail_image);
        this.mhr.setVisibility(0);
        this.mhz = (LinearLayout) findViewById(R.h.image_bottom_info_layout);
        this.mhv = (RelativeLayout) findViewById(R.h.mail_img_download_layout);
        this.mhs.setVisibility(8);
        this.mht.setVisibility(8);
        this.mhu.setVisibility(8);
        setTitleVisibility(8);
        setBackBtn(new 1(this));
        this.mhq = (ProgressBar) findViewById(R.h.image_download_pb);
    }

    private void va(int i) {
        this.mhr.setText(getString(R.l.fmt_percent, new Object[]{Integer.valueOf(i)}));
        if (i >= this.mhq.getMax()) {
            com.tencent.mm.ak.e b = o.Pf().b(Long.valueOf(this.mhx.dVh));
            if (this.dTO == 1) {
                com.tencent.mm.ak.f.c(b);
            }
            finish();
            startActivity(getIntent());
        }
    }

    public final void a(int i, int i2, l lVar) {
        x.d("MicroMsg.MailImageDownloadUI", "offset " + i + "totaolLen  " + i2);
        if (lVar.getType() == a$i.AppCompatTheme_seekBarStyle) {
            va(Math.max(0, i2 != 0 ? ((i * 100) / i2) - 1 : 0));
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() == a$i.AppCompatTheme_seekBarStyle) {
            if (i == 0 && i2 == 0) {
                va(this.mhq.getMax());
                return;
            }
            x.e("MicroMsg.MailImageDownloadUI", "onSceneEnd : fail, errType = " + i + ", errCode = " + i2);
            Toast.makeText(this, R.l.imgdownload_fail, 1).show();
        }
    }
}
