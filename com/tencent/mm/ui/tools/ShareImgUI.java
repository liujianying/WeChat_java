package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.k.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.plugin.account.ui.SimpleLoginUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;
import com.tencent.rtmp.TXLivePushConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class ShareImgUI extends AutoLoginActivity implements e {
    private ProgressDialog eHw = null;
    String filePath = null;
    private ag handler = new 3(this);
    private Intent intent = null;
    Intent uBM = null;
    Uri uri = null;
    ArrayList<String> uvy = null;

    static /* synthetic */ void c(ShareImgUI shareImgUI) {
        int i;
        Intent intent = shareImgUI.getIntent();
        int aaZ = aaZ(intent.resolveType(shareImgUI));
        if (aaZ == 0 && o.Wf(shareImgUI.filePath)) {
            x.i("MicroMsg.ShareImgUI", "fix msg type to emoji.");
            i = 5;
        } else {
            i = aaZ;
        }
        x.i("MicroMsg.ShareImgUI", "filepath:[%s], msgType:%d", new Object[]{shareImgUI.filePath, Integer.valueOf(i)});
        if (i == -1) {
            x.e("MicroMsg.ShareImgUI", "launch, msgType is invalid");
            shareImgUI.finish();
        } else if (bi.oW(shareImgUI.filePath) || !bi.Xh(shareImgUI.filePath) || aaY(shareImgUI.filePath)) {
            if (i == 5 && !bi.oW(shareImgUI.filePath)) {
                if (com.tencent.mm.a.e.cm(shareImgUI.filePath) > b.AA()) {
                    h.mEJ.h(13459, new Object[]{Integer.valueOf(com.tencent.mm.a.e.cm(shareImgUI.filePath)), Integer.valueOf(1), "", Integer.valueOf(2)});
                    shareImgUI.czT();
                    return;
                }
                Options options = new Options();
                options.inJustDecodeBounds = true;
                if ((c.decodeFile(shareImgUI.filePath, options) != null && options.outHeight > b.Az()) || options.outWidth > b.Az()) {
                    h.mEJ.h(13459, new Object[]{Integer.valueOf(com.tencent.mm.a.e.cm(shareImgUI.filePath)), Integer.valueOf(1), "", Integer.valueOf(2)});
                    shareImgUI.czT();
                    return;
                }
            }
            l dVar;
            if (!bi.oW(shareImgUI.filePath) && i != 1) {
                String str = shareImgUI.filePath;
                if (str == null || str.length() == 0) {
                    x.e("MicroMsg.ShareImgUI", "dealWithFile fail, filePath is empty");
                } else if (bi.Xg(str)) {
                    int cm = com.tencent.mm.a.e.cm(str);
                    x.i("MicroMsg.ShareImgUI", "filelength: [%d]", new Object[]{Integer.valueOf(cm)});
                    if (cm == 0) {
                        x.e("MicroMsg.ShareImgUI", "dealWithFile fail, fileLength is 0");
                    } else if (cm > 10485760) {
                        x.e("MicroMsg.ShareImgUI", "summerbig dealWithFile fail, fileLength is too large fileLength[%d],filePath[%s] ", new Object[]{Integer.valueOf(cm), str});
                        Toast.makeText(shareImgUI, R.l.shareimg_file_too_large, 1).show();
                    } else {
                        IMediaObject wXImageObject;
                        switch (i) {
                            case 0:
                                wXImageObject = new WXImageObject();
                                ((WXImageObject) wXImageObject).setImagePath(str);
                                break;
                            default:
                                wXImageObject = new WXFileObject(str);
                                break;
                        }
                        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXImageObject);
                        wXMediaMessage.title = new File(str).getName();
                        wXMediaMessage.description = bi.bF((long) cm);
                        if (cm < 30720) {
                            wXMediaMessage.thumbData = com.tencent.mm.a.e.e(str, 0, -1);
                        } else {
                            x.i("MicroMsg.ShareImgUI", "thumb data is exceed 30k, ignore");
                        }
                        Req req = new Req();
                        req.transaction = null;
                        req.message = wXMediaMessage;
                        Bundle bundle = new Bundle();
                        req.toBundle(bundle);
                        bundle.putInt("_mmessage_sdkVersion", 620823808);
                        bundle.putString("_mmessage_appPackage", "com.tencent.mm.openapi");
                        bundle.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
                        intent = new Intent();
                        intent.setClass(shareImgUI, SelectConversationUI.class);
                        intent.putExtra("Select_Conv_NextStep", new Intent(shareImgUI, SendAppMessageWrapperUI.class).putExtras(bundle).putExtra("animation_pop_in", true));
                        if (!au.HW() || au.Dr()) {
                            x.w("MicroMsg.ShareImgUI", "not logged in, jump to simple login");
                            MMWizardActivity.b(shareImgUI, new Intent(shareImgUI, SimpleLoginUI.class), shareImgUI.getIntent().addFlags(67108864));
                            return;
                        }
                        g.DF().a(837, shareImgUI);
                        List arrayList = new ArrayList();
                        arrayList.add(str);
                        switch (i) {
                            case 0:
                                dVar = new d(1, arrayList, shareImgUI.cqk());
                                break;
                            default:
                                dVar = new d(4, arrayList, shareImgUI.cqk());
                                break;
                        }
                        g.DF().a(dVar, 0);
                        shareImgUI.showDialog();
                        shareImgUI.uBM = intent;
                    }
                } else {
                    x.e("MicroMsg.ShareImgUI", "dealWithFile fail, filePath is refer to private file.");
                }
            } else if (!s.a(shareImgUI.getIntent(), "Intro_Switch", false) && au.HW() && !au.Dr()) {
                intent.setData(shareImgUI.uri);
                intent.setClass(shareImgUI, MsgRetransmitUI.class);
                intent.addFlags(268435456).addFlags(67108864);
                intent.putExtra("Retr_File_Name", shareImgUI.filePath);
                intent.putStringArrayListExtra("Retr_File_Path_List", shareImgUI.uvy);
                intent.putExtra("Retr_Msg_Type", i);
                intent.putExtra("Retr_Scene", 1);
                intent.putExtra("Retr_start_where_you_are", false);
                au.DF().a(837, shareImgUI);
                if (i == 1) {
                    List arrayList2 = new ArrayList();
                    arrayList2.add(shareImgUI.filePath);
                    dVar = new d(3, arrayList2, shareImgUI.cqk());
                } else {
                    dVar = new d(1, shareImgUI.uvy, shareImgUI.cqk());
                }
                g.DF().a(dVar, 0);
                shareImgUI.showDialog();
                shareImgUI.uBM = intent;
            } else if (!shareImgUI.czS()) {
                shareImgUI.Gf(0);
                shareImgUI.finish();
            }
        } else {
            x.w("MicroMsg.ShareImgUI", "try to share illegal image.");
            shareImgUI.Gf(0);
            shareImgUI.finish();
        }
    }

    protected final boolean A(Intent intent) {
        return true;
    }

    protected final boolean bjv() {
        if (au.HW() && !au.Dr()) {
            return false;
        }
        x.w("MicroMsg.ShareImgUI", "not login");
        this.intent = getIntent();
        aak();
        return true;
    }

    protected final void a(a aVar, Intent intent) {
        switch (7.hdM[aVar.ordinal()]) {
            case 1:
                this.intent = intent;
                x.i("MicroMsg.ShareImgUI", "now permission = %d", new Object[]{Integer.valueOf(bi.getInt(com.tencent.mm.k.g.AT().getValue("SystemShareControlBitset"), 0))});
                if ((bi.getInt(com.tencent.mm.k.g.AT().getValue("SystemShareControlBitset"), 0) & 1) > 0) {
                    x.e("MicroMsg.ShareImgUI", "now allowed to share to friend");
                    finish();
                    return;
                }
                x.i("MicroMsg.ShareImgUI", "postLogin, text = %s", new Object[]{s.j(intent, "android.intent.extra.TEXT")});
                if (bi.oW(s.j(intent, "android.intent.extra.TEXT"))) {
                    aak();
                    return;
                }
                String format = String.format("weixin://dl/business/systemshare/?txt=%s", new Object[]{URLEncoder.encode(format)});
                showDialog();
                au.DF().a(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, this);
                au.DF().a(new aa(format, 15, null), 0);
                return;
            default:
                finish();
                com.tencent.mm.ui.base.b.gF(this);
                return;
        }
    }

    protected void onDestroy() {
        au.DF().b(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, this);
        au.DF().b(837, this);
        dismissDialog();
        super.onDestroy();
    }

    private void aak() {
        if (this.intent == null) {
            x.e("MicroMsg.ShareImgUI", "launch : fail, intent is null");
            Gf(0);
            finish();
            return;
        }
        String action = this.intent.getAction();
        Bundle extras = this.intent.getExtras();
        if (bi.oW(action)) {
            x.e("MicroMsg.ShareImgUI", "launch : fail, action is null");
            Gf(0);
            finish();
            return;
        }
        if (extras != null) {
            Parcelable parcelable = extras.getParcelable("android.intent.extra.STREAM");
            if (parcelable != null && (parcelable instanceof Uri)) {
                this.uri = (Uri) parcelable;
                if (!bi.n(this.uri)) {
                    x.e("MicroMsg.ShareImgUI", "launch : fail, not accepted: %s", new Object[]{this.uri});
                    Gf(0);
                    finish();
                    return;
                }
            }
        }
        showDialog();
        if (action.equals("android.intent.action.SEND")) {
            x.i("MicroMsg.ShareImgUI", "send signal: " + action);
            if (this.uri == null) {
                boolean z;
                Intent intent = getIntent();
                if (intent == null) {
                    x.e("MicroMsg.ShareImgUI", "intent is null");
                    z = false;
                } else {
                    String j = s.j(intent, "android.intent.extra.TEXT");
                    String j2 = s.j(intent, "android.intent.extra.SUBJECT");
                    if (j == null || j.length() == 0) {
                        x.i("MicroMsg.ShareImgUI", "text is null");
                        z = false;
                    } else {
                        WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXTextObject(j));
                        wXMediaMessage.description = j;
                        Req req = new Req();
                        req.transaction = null;
                        req.message = wXMediaMessage;
                        Bundle bundle = new Bundle();
                        req.toBundle(bundle);
                        bundle.putInt("_mmessage_sdkVersion", 620823808);
                        bundle.putString("_mmessage_appPackage", "com.tencent.mm.openapi");
                        bundle.putString("SendAppMessageWrapper_AppId", "wx4310bbd51be7d979");
                        Intent intent2 = new Intent();
                        intent2.setClass(this, SelectConversationUI.class);
                        intent2.putExtra("Select_Conv_NextStep", new Intent(this, SendAppMessageWrapperUI.class).putExtras(bundle).putExtra("animation_pop_in", true));
                        if (!au.HW() || au.Dr()) {
                            x.w("MicroMsg.ShareImgUI", "not logged in, jump to simple login");
                            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent().addFlags(67108864));
                        } else {
                            au.DF().a(837, this);
                            List arrayList = new ArrayList();
                            arrayList.add(j2 + "|" + j);
                            g.DF().a(new d(5, arrayList, cqk()), 0);
                            showDialog();
                            this.uBM = intent2;
                        }
                        z = true;
                    }
                }
                x.i("MicroMsg.ShareImgUI", "dealWithText: %b", new Object[]{Boolean.valueOf(z)});
                if (!z) {
                    Gf(0);
                    finish();
                    return;
                }
                return;
            }
            com.tencent.mm.sdk.f.e.post(new a(this, this.uri, new 1(this)), "ShareImgUI_getFilePath");
        } else if (action.equals("android.intent.action.SEND_MULTIPLE") && extras != null && extras.containsKey("android.intent.extra.STREAM")) {
            x.i("MicroMsg.ShareImgUI", "send multi: " + action);
            com.tencent.mm.sdk.f.e.post(new 4(this, extras, new 2(this), System.currentTimeMillis()), "getMultiSendFilePathList");
        } else {
            x.e("MicroMsg.ShareImgUI", "launch : fail, uri is null");
            Gf(0);
            finish();
        }
    }

    private boolean czS() {
        Intent intent = new Intent(this, ShareImgUI.class);
        if ("android.intent.action.SEND".equals(getIntent().getAction())) {
            if (bi.oW(this.filePath)) {
                return false;
            }
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(this.filePath)));
            intent.setAction("android.intent.action.SEND");
            intent.setType(getIntent().getType());
        } else if (!"android.intent.action.SEND_MULTIPLE".equals(getIntent().getAction()) || bi.cX(this.uvy)) {
            return false;
        } else {
            ArrayList arrayList = new ArrayList(this.uvy.size());
            Iterator it = this.uvy.iterator();
            while (it.hasNext()) {
                arrayList.add(Uri.fromFile(new File((String) it.next())));
            }
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
            intent.setAction("android.intent.action.SEND_MULTIPLE");
            intent.setType(getIntent().getType());
        }
        intent.addFlags(67108864);
        MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(32768).addFlags(268435456), intent);
        return true;
    }

    private static boolean aaY(String str) {
        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
        boolean b = o.b(str, decodeResultLogger);
        if (!b && decodeResultLogger.getDecodeResult() >= 2000) {
            h.mEJ.k(12712, KVStatHelper.getKVStatString(str, 3, decodeResultLogger));
        }
        return b;
    }

    private String a(Uri uri, Cursor cursor) {
        AssetFileDescriptor openAssetFileDescriptor;
        FileNotFoundException e;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        IOException e2;
        Exception e3;
        Throwable th;
        if (uri != null) {
            String str = "contact.vcf";
            int columnIndex = cursor.getColumnIndex("_display_name");
            if (columnIndex != -1) {
                try {
                    str = cursor.getString(columnIndex);
                } catch (Exception e4) {
                    x.w("MicroMsg.ShareImgUI", "try to get Vcard Name fail: %s", new Object[]{e4.getMessage()});
                }
                if (!(str == null || str == null)) {
                    str = str.replaceAll("[^.\\w]+", "_");
                }
                x.i("MicroMsg.ShareImgUI", "vcard file name: " + str);
            }
            cursor.close();
            try {
                openAssetFileDescriptor = getContentResolver().openAssetFileDescriptor(uri, "r");
            } catch (FileNotFoundException e5) {
                e = e5;
                fileOutputStream = null;
                openAssetFileDescriptor = null;
                fileInputStream = null;
            } catch (IOException e6) {
                e2 = e6;
                fileOutputStream = null;
                openAssetFileDescriptor = null;
                fileInputStream = null;
                x.e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e7) {
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            } catch (Exception e8) {
                e3 = e8;
                fileOutputStream = null;
                openAssetFileDescriptor = null;
                fileInputStream = null;
                x.e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                x.e("MicroMsg.ShareImgUI", e3.toString());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e9) {
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                openAssetFileDescriptor = null;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e10) {
                        throw th;
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
            try {
                fileInputStream = openAssetFileDescriptor.createInputStream();
                try {
                    au.HU();
                    if (com.tencent.mm.model.c.isSDCardAvailable()) {
                        String str2 = com.tencent.mm.compatible.util.e.bnE + "share";
                        str = com.tencent.mm.compatible.util.e.bnE + "share/" + str;
                        File file = new File(str2);
                        if (!file.exists()) {
                            file.mkdir();
                        }
                        File file2 = new File(str);
                        if (!file2.exists()) {
                            file2.createNewFile();
                        }
                        fileOutputStream = new FileOutputStream(str, false);
                    } else {
                        deleteFile(str);
                        String str3 = getFilesDir().getPath() + "/" + str;
                        fileOutputStream = openFileOutput(str, 0);
                        str = str3;
                    }
                } catch (FileNotFoundException e11) {
                    e = e11;
                    fileOutputStream = null;
                    try {
                        x.e("MicroMsg.ShareImgUI", "vcard uri file not found " + e.getMessage());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e12) {
                            }
                        }
                        if (openAssetFileDescriptor != null) {
                            openAssetFileDescriptor.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return null;
                    } catch (Throwable th3) {
                        th = th3;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e102) {
                                throw th;
                            }
                        }
                        if (openAssetFileDescriptor != null) {
                            openAssetFileDescriptor.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (IOException e13) {
                    e2 = e13;
                    fileOutputStream = null;
                    x.e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e72) {
                        }
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (Exception e14) {
                    e3 = e14;
                    fileOutputStream = null;
                    x.e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                    x.e("MicroMsg.ShareImgUI", e3.toString());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e92) {
                        }
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    fileOutputStream = null;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e1022) {
                            throw th;
                        }
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[5120];
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 5120);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e15) {
                            return str;
                        }
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream == null) {
                        return str;
                    }
                    fileOutputStream.close();
                    return str;
                } catch (FileNotFoundException e16) {
                    e = e16;
                    x.e("MicroMsg.ShareImgUI", "vcard uri file not found " + e.getMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e122) {
                        }
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (IOException e17) {
                    e2 = e17;
                    x.e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e722) {
                        }
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                } catch (Exception e18) {
                    e3 = e18;
                    x.e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                    x.e("MicroMsg.ShareImgUI", e3.toString());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e922) {
                        }
                    }
                    if (openAssetFileDescriptor != null) {
                        openAssetFileDescriptor.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return null;
                }
            } catch (FileNotFoundException e19) {
                e = e19;
                fileOutputStream = null;
                fileInputStream = null;
            } catch (IOException e20) {
                e2 = e20;
                fileOutputStream = null;
                fileInputStream = null;
                x.e("MicroMsg.ShareImgUI", "vcard uri ioexception" + e2.getMessage());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e7222) {
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            } catch (Exception e21) {
                e3 = e21;
                fileOutputStream = null;
                fileInputStream = null;
                x.e("MicroMsg.ShareImgUI", "vcard uri exception" + e3.getMessage());
                x.e("MicroMsg.ShareImgUI", e3.toString());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e9222) {
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e10222) {
                        throw th;
                    }
                }
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        }
        return null;
    }

    private static int aaZ(String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.ShareImgUI", "map : mimeType is null");
            return -1;
        }
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.equalsIgnoreCase("image/gif")) {
            return 5;
        }
        if (toLowerCase.contains("image")) {
            return 0;
        }
        if (toLowerCase.contains("video")) {
            return 1;
        }
        x.d("MicroMsg.ShareImgUI", "map : unknown mimetype, send as file");
        return 3;
    }

    private void Gf(int i) {
        switch (i) {
            case 1:
                Toast.makeText(this, R.l.shareimg_err_not_support_type, 1).show();
                return;
            default:
                Toast.makeText(this, R.l.shareimg_get_res_fail, 1).show();
                return;
        }
    }

    private void czT() {
        Toast.makeText(this, R.l.emoji_custom_gif_max_size_limit_cannot_send, 1).show();
        finish();
    }

    private void showDialog() {
        getString(R.l.app_tip);
        this.eHw = com.tencent.mm.ui.base.h.a(this, getString(R.l.app_waiting), true, new 6(this));
    }

    private void dismissDialog() {
        if (this.eHw != null && this.eHw.isShowing()) {
            this.eHw.dismiss();
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.ShareImgUI", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        dismissDialog();
        if (lVar instanceof aa) {
            if (i == 0 && i2 == 0) {
                aak();
            } else {
                finish();
            }
        }
        if (lVar instanceof d) {
            if (!(i == 0 && i2 == 0)) {
                if (lVar.dJd != null) {
                    ol olVar = (ol) ((com.tencent.mm.ab.b) lVar.dJd).dIE.dIL;
                    if (!(olVar == null || bi.oW(olVar.rsN))) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", olVar.rsN);
                        intent.putExtra("showShare", false);
                        intent.putExtra("show_bottom", false);
                        intent.putExtra("needRedirect", false);
                        com.tencent.mm.bg.d.b(this, "webview", ".ui.tools.WebViewUI", intent);
                    }
                }
                finish();
            }
            startActivity(this.uBM);
            finish();
        }
    }
}
