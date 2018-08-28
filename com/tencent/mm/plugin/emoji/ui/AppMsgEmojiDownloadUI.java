package com.tencent.mm.plugin.emoji.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.f;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.pluginsdk.model.app.ac;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.chat.l.b;
import com.tencent.mm.pluginsdk.ui.emoji.PreViewEmojiView;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.g;
import java.io.IOException;

public class AppMsgEmojiDownloadUI extends MMActivity implements e, a {
    private String appName;
    private String bGP;
    private long bJC;
    private String bOX;
    private String bPS;
    private String bWW;
    private bd bXQ;
    private String dwq;
    private ProgressBar eVR;
    private ac ijW;
    private f ijX;
    private TextView ijY;
    private String ijZ;
    private PreViewEmojiView ika;

    protected final int getLayoutId() {
        return R.i.app_msg_emoji_download;
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        this.ijZ = "da_" + bi.VF();
        this.bJC = getIntent().getLongExtra("msgid", -1);
        if (this.bJC == -1) {
            z = false;
        } else {
            au.HU();
            this.bXQ = c.FT().dW(this.bJC);
            if (this.bXQ == null || this.bXQ.field_msgId == 0 || this.bXQ.field_content == null) {
                z = false;
            } else {
                this.bWW = this.bXQ.field_content;
                g.a gp = g.a.gp(this.bWW);
                if (gp == null) {
                    z = false;
                } else {
                    this.dwq = gp.dwq;
                    this.bGP = gp.bGP;
                    this.bPS = gp.appId;
                    this.appName = com.tencent.mm.pluginsdk.model.app.g.b(this.mController.tml, com.tencent.mm.pluginsdk.model.app.g.bl(this.bPS, true), null);
                    this.bOX = this.bXQ.field_imgPath;
                }
            }
        }
        if (z) {
            ao.asF().c(this);
            initView();
            this.ijX = new 1(this);
            if (ao.asF().SR(this.bGP) == null) {
                long j = this.bJC;
                String str = this.bWW;
                StringBuilder stringBuilder = new StringBuilder();
                au.HU();
                l.c(j, str, stringBuilder.append(c.Gg()).append(this.ijZ).toString());
            }
            this.ijW = new ac(this.bGP, this.ijX, 8);
            au.DF().a(this.ijW, 0);
            return;
        }
        finish();
    }

    protected final void initView() {
        this.ika = (PreViewEmojiView) findViewById(R.h.custom_smiley_preview_emojiview);
        this.ika.setImageBitmap(o.Pf().a(this.bOX, 1.0f, true));
        setMMTitle("");
        this.ijY = (TextView) findViewById(R.h.download_text);
        TextView textView = (TextView) findViewById(R.h.appsource);
        this.appName = com.tencent.mm.pluginsdk.model.app.g.b(this.mController.tml, com.tencent.mm.pluginsdk.model.app.g.bl(this.bPS, true), null);
        if (this.bPS != null && this.bPS.length() > 0) {
            String str = this.appName;
            boolean z = (str == null || str.trim().length() == 0 || str.equals("weixinfile") || str.equals("invalid_appname")) ? false : true;
            if (z) {
                textView.setText(getString(R.l.chatting_source_from, new Object[]{this.appName}));
                textView.setVisibility(0);
                str = this.bPS;
                b bVar = new b();
                bVar.appId = str;
                bVar.bXS = "message";
                textView.setTag(bVar);
                textView.setOnClickListener(new com.tencent.mm.pluginsdk.ui.chat.l(this));
                Bitmap b = com.tencent.mm.pluginsdk.model.app.g.b(this.bPS, 2, com.tencent.mm.bp.a.getDensity(this));
                if (b == null || b.isRecycled()) {
                    a(this, textView, BitmapFactory.decodeResource(getResources(), R.g.nosdcard_watermark_icon));
                } else {
                    a(this, textView, b);
                }
                this.eVR = (ProgressBar) findViewById(R.h.emoji_download_pb);
                this.eVR.setMax(100);
                setBackBtn(new 2(this));
            }
        }
        textView.setVisibility(8);
        this.eVR = (ProgressBar) findViewById(R.h.emoji_download_pb);
        this.eVR.setMax(100);
        setBackBtn(new 2(this));
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        if (lVar.getType() == 221) {
            if (i == 0 && i2 == 0) {
                oM(this.eVR.getMax());
                return;
            }
            Toast.makeText(this, R.l.download_fail, 0).show();
            this.eVR.setVisibility(8);
            this.ijY.setVisibility(8);
            x.e("MicroMsg.emoji.AppMsgEmojiDownloadUI", "onSceneEnd, download fail, errType = " + i + ", errCode = " + i2);
        }
    }

    protected void onPause() {
        super.onPause();
        au.DF().b(221, this);
    }

    protected void onResume() {
        super.onResume();
        au.DF().a(221, this);
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        com.tencent.mm.pluginsdk.model.app.b SR = ao.asF().SR(this.bGP);
        if (SR == null) {
            x.e("MicroMsg.emoji.AppMsgEmojiDownloadUI", "updateProgress fail");
            return;
        }
        long j = SR.field_totalLen;
        long j2 = SR.field_offset;
        this.ijY.setText(getString(R.l.download_ing) + " " + getString(R.l.download_data, new Object[]{bi.bF(j2), bi.bF(j)}));
        int i = (int) ((SR.field_offset * 100) / SR.field_totalLen);
        x.v("MicroMsg.emoji.AppMsgEmojiDownloadUI", "attach progress:" + i + " offset:" + j2 + " totallen:" + j);
        oM(i);
    }

    private void oM(int i) {
        this.eVR.setProgress(i);
        if (i >= 100) {
            au.HU();
            String Gg = c.Gg();
            com.tencent.mm.pluginsdk.model.app.b SR = ao.asF().SR(this.bGP);
            if (SR == null) {
                x.e("MicroMsg.emoji.AppMsgEmojiDownloadUI", "saveImageAndPreview fail, info is null, attachid = " + this.bGP + ", msgContent = " + this.bWW);
            } else {
                int cm = com.tencent.mm.a.e.cm(SR.field_fileFullPath);
                Object e = com.tencent.mm.a.e.e(SR.field_fileFullPath, 0, cm);
                String u = com.tencent.mm.a.g.u(e);
                if (!bi.oW(u)) {
                    if (u == null || this.dwq == null || u.equalsIgnoreCase(this.dwq)) {
                        com.tencent.mm.a.e.i(Gg, this.ijZ, u);
                        SR.field_fileFullPath = Gg + u;
                        ao.asF().a(SR.field_msgInfoId, SR);
                        Bitmap a = o.Pf().a(this.bOX, 1.0f, true);
                        if (a != null) {
                            n(Gg + u + "_thumb", a);
                        }
                        EmojiInfo a2 = com.tencent.mm.sdk.platformtools.o.bv(e) ? i.aEA().igx.a(u, "", EmojiInfo.tcB, EmojiInfo.tcL, cm, this.bPS, "") : i.aEA().igx.a(u, "", EmojiInfo.tcB, EmojiInfo.tcM, cm, this.bPS, "");
                        this.eVR.setVisibility(8);
                        this.ijY.setVisibility(8);
                        if (a2 != null) {
                            this.ika.setImageFilePath(a2.cnF());
                            this.ika.resume();
                        }
                    } else {
                        x.e("MicroMsg.emoji.AppMsgEmojiDownloadUI", "md5 not match!! emoticonmd5 is=" + this.dwq + ", gen md5 is=" + u);
                        x.e("MicroMsg.emoji.AppMsgEmojiDownloadUI", "fileFullPath = " + SR.field_fileFullPath + ", fileLength = " + cm + ", bufLength = " + e.length + ", buf = " + e);
                        Toast.makeText(this, getString(R.l.download_fail), 0).show();
                        finish();
                    }
                }
            }
            ao.asF().d(this);
            au.DF().b(221, this);
        }
    }

    private static boolean n(String str, Bitmap bitmap) {
        try {
            com.tencent.mm.sdk.platformtools.c.a(bitmap, 100, CompressFormat.PNG, str, true);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private static void a(AppMsgEmojiDownloadUI appMsgEmojiDownloadUI, TextView textView, Bitmap bitmap) {
        Drawable bitmapDrawable = new BitmapDrawable(bitmap);
        int dimension = (int) appMsgEmojiDownloadUI.getResources().getDimension(R.f.HintTextSize);
        bitmapDrawable.setBounds(0, 0, dimension, dimension);
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
    }

    protected void onDestroy() {
        super.onDestroy();
        au.DF().c(this.ijW);
        ao.asF().d(this);
    }
}
