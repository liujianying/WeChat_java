package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.a$i;
import android.widget.ImageView;
import android.widget.ProgressBar;
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
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;

public class ImageDownloadUI extends MMActivity implements e, f {
    private long bJC = 0;
    private long bYu = 0;
    private int dTO;
    private ProgressBar mhq;
    private TextView mhr;
    private TextView mhs;
    private TextView mht;
    private TextView mhu;
    private com.tencent.mm.ak.e mhw;
    private k mhx;
    private ImageView tMv;
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
            x.e("ImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.bJC + ", or msgSvrId = " + this.bYu);
            return;
        }
        if (this.bJC <= 0 && this.bYu > 0) {
            au.HU();
            this.bJC = c.FT().I(this.username, this.bYu).field_msgId;
        }
        this.mhx = new k(this.mhw.dTK, this.bJC, this.dTO, this);
        au.DF().a(this.mhx, 0);
    }

    protected final int getLayoutId() {
        return R.i.video_download;
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
        this.mhs = (TextView) findViewById(R.h.video_download_percent_tv);
        this.mht = (TextView) findViewById(R.h.video_download_size_tv);
        this.mhu = (TextView) findViewById(R.h.video_download_length_tv);
        this.tMv = (ImageView) findViewById(R.h.down_background);
        this.tMv.setImageResource(R.k.download_image_icon);
        this.mhr.setVisibility(0);
        this.mhs.setVisibility(8);
        this.mht.setVisibility(8);
        this.mhu.setVisibility(8);
        setBackBtn(new 1(this));
        this.mhq = (ProgressBar) findViewById(R.h.video_download_pb);
    }

    public final void a(int i, int i2, l lVar) {
        x.d("ImageDownloadUI", "offset " + i + "totaolLen  " + i2);
        if (lVar.getType() == a$i.AppCompatTheme_seekBarStyle) {
            int i3;
            if (i2 != 0) {
                i3 = ((i * 100) / i2) - 1;
            } else {
                i3 = 0;
            }
            va(Math.max(0, i3));
        }
    }

    private void va(int i) {
        this.mhq.setProgress(i);
        this.mhr.setText(getString(R.l.fmt_percent, new Object[]{Integer.valueOf(i)}));
        if (i >= this.mhq.getMax()) {
            com.tencent.mm.ak.e b = o.Pf().b(Long.valueOf(this.mhx.dVh));
            String str = b.dTL;
            if (this.dTO == 1) {
                str = com.tencent.mm.ak.f.c(b);
            }
            str = o.Pf().o(str, null, null);
            if (str == null || str.equals("") || !com.tencent.mm.a.e.cn(str)) {
                x.d("ImageDownloadUI", "showImg : imgPath is null");
                return;
            }
            Intent intent = new Intent(this, ImageGalleryUI.class);
            intent.putExtra("key_message_id", this.bJC);
            intent.putExtra("key_image_path", str);
            intent.putExtra("key_compress_type", this.dTO);
            intent.putExtra("key_favorite", true);
            intent.putExtra("img_gallery_msg_id", this.bJC);
            intent.putExtra("img_gallery_talker", this.username);
            finish();
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() == a$i.AppCompatTheme_seekBarStyle) {
            if (i == 0 && i2 == 0) {
                va(this.mhq.getMax());
                return;
            }
            x.e("ImageDownloadUI", "onSceneEnd : fail, errType = " + i + ", errCode = " + i2);
            Toast.makeText(this, R.l.imgdownload_fail, 1).show();
        }
    }
}
