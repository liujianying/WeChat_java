package com.tencent.mm.ui.chatting.gallery;

import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ak.o;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.gj;
import com.tencent.mm.g.a.gk;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.model.au;
import com.tencent.mm.model.m;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.chatting.a$b;
import com.tencent.mm.ui.chatting.ah;
import com.tencent.mm.ui.chatting.as;
import com.tencent.mm.ui.chatting.gallery.g.b;
import com.tencent.mm.ui.chatting.i;
import com.tencent.mm.ui.chatting.k;
import com.tencent.mm.y.g;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@a(19)
public class ImageGalleryGridUI extends MMActivity implements OnMenuItemClickListener, OnClickListener, OnPreDrawListener, OnItemClickListener, ah, b {
    protected ag handler;
    public long hpD;
    private TextView jCc;
    private boolean mIsPause = true;
    private Animation nen;
    public boolean qIZ;
    private boolean qUB = false;
    private c tQa = new 4(this);
    private long tUA = 0;
    Runnable tUB = new 8(this);
    public View tUC = null;
    private View tUD;
    private int tUE = -1;
    private View tUF;
    private View tUG;
    private View tUH;
    private View tUI;
    public int tUq;
    private GridView tUr;
    c tUs;
    private WeakReference<c$a> tUt;
    private Boolean tUu;
    private Boolean tUv;
    private TextView tUw;
    private Runnable tUx = new 1(this);
    private Runnable tUy = new 3(this);
    private boolean tUz = false;
    private String talker;

    static /* synthetic */ void a(ImageGalleryGridUI imageGalleryGridUI, int i, gj gjVar) {
        if (imageGalleryGridUI.tUr != null) {
            int firstVisiblePosition = imageGalleryGridUI.tUr.getFirstVisiblePosition();
            int lastVisiblePosition = imageGalleryGridUI.tUr.getLastVisiblePosition();
            if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
                View childAt = imageGalleryGridUI.tUr.getChildAt(i - firstVisiblePosition);
                if (childAt != null) {
                    int[] iArr = new int[2];
                    childAt.getLocationInWindow(iArr);
                    gjVar.bPy.bIb = iArr[0];
                    gjVar.bPy.bIc = iArr[1];
                    gjVar.bPy.bId = childAt.getWidth();
                    gjVar.bPy.bIe = childAt.getHeight();
                }
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.image_gallery_grid;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.tUz = true;
        this.handler = new ag();
        Fy(0);
        com.tencent.mm.sdk.b.a.sFg.b(this.tQa);
    }

    protected final boolean cpZ() {
        return true;
    }

    protected void onDestroy() {
        this.handler.removeCallbacks(this.tUy);
        this.handler = null;
        o.Pj().br(0);
        com.tencent.mm.sdk.b.a.sFg.c(this.tQa);
        super.onDestroy();
    }

    protected void onResume() {
        g.a.cwU().a(this);
        this.mIsPause = false;
        if (this.tUz) {
            if (g.a.cwU().tVs) {
                cwx();
            } else {
                cwy();
            }
        }
        this.handler.postDelayed(this.tUy, 300);
        super.onResume();
        if (this.tUs != null) {
            this.tUs.tUj = true;
            c cVar = this.tUs;
            if (cVar.tUj) {
                cVar.notifyDataSetChanged();
            }
            if (g.a.cwU().tVs) {
                setMMTitle(getString(R.l.gallery_selected_title, new Object[]{Integer.valueOf(g.a.cwU().tTJ.size())}));
            }
        }
        this.tUz = false;
        cwR();
    }

    protected void onPause() {
        g cwU = g.a.cwU();
        if (this != null) {
            cwU.tVt.remove(this);
        }
        this.mIsPause = true;
        super.onPause();
    }

    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        super.onNewIntent(intent);
        Fy(1);
    }

    public void onBackPressed() {
        if (g.a.cwU().tVs) {
            cwy();
        } else if (this.tUu.booleanValue()) {
            super.onBackPressed();
        } else {
            if (this.tUq >= 0) {
                M(null, this.tUq);
            }
            finish();
        }
    }

    @TargetApi(11)
    private void Fy(int i) {
        Intent intent = getIntent();
        this.tUu = Boolean.valueOf(intent.getIntExtra("kintent_intent_source", 0) == 1);
        this.talker = intent.getStringExtra("kintent_talker");
        this.tUq = intent.getIntExtra("kintent_image_index", 0);
        this.qIZ = intent.getBooleanExtra("key_is_biz_chat", false);
        this.hpD = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.tUv = Boolean.valueOf(true);
        setMMTitle(getString(R.l.all_pictures));
        setBackBtn(new 5(this));
        this.tUD = findViewById(R.h.more_bottom_root);
        View findViewById = findViewById(R.h.fav_btn);
        this.tUF = findViewById;
        findViewById.setOnClickListener(this);
        findViewById = findViewById(R.h.trans_btn);
        this.tUG = findViewById;
        findViewById.setOnClickListener(this);
        findViewById = findViewById(R.h.save_btn);
        this.tUH = findViewById;
        findViewById.setOnClickListener(this);
        findViewById = findViewById(R.h.del_btn);
        this.tUI = findViewById;
        findViewById.setOnClickListener(this);
        this.jCc = (TextView) findViewById(R.h.album_tips_bar);
        this.tUw = (TextView) findViewById(R.h.album_no_img_tip);
        if (i == 0) {
            this.tUr = (GridView) findViewById(R.h.image_gallery_grid);
            this.tUr.setOnItemClickListener(this);
            this.tUr.setNumColumns(3);
            bd bdVar = new bd();
            if (this.qIZ) {
                bdVar.az(this.hpD);
            }
            this.tUs = new c(this, bdVar, this.talker);
            if (this.tUs.getCount() == 0) {
                this.tUw.setVisibility(0);
                return;
            }
            this.tUw.setVisibility(8);
            this.tUr.setAdapter(this.tUs);
            cwQ();
        } else if (this.tUs != null) {
            this.tUs.notifyDataSetChanged();
            cwQ();
        }
        this.tUr.setOnScrollListener(new OnScrollListener() {
            private Runnable jCG = new 1(this);

            private void fj(boolean z) {
                if (z) {
                    ImageGalleryGridUI.this.jCc.removeCallbacks(this.jCG);
                    if (ImageGalleryGridUI.this.jCc.getVisibility() != 0) {
                        ImageGalleryGridUI.this.jCc.clearAnimation();
                        Animation loadAnimation = AnimationUtils.loadAnimation(ImageGalleryGridUI.this.mController.tml, R.a.fast_faded_in);
                        ImageGalleryGridUI.this.jCc.setVisibility(0);
                        ImageGalleryGridUI.this.jCc.startAnimation(loadAnimation);
                        return;
                    }
                    return;
                }
                ImageGalleryGridUI.this.jCc.removeCallbacks(this.jCG);
                ImageGalleryGridUI.this.jCc.postDelayed(this.jCG, 256);
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (1 == i) {
                    fj(true);
                } else if (i == 0) {
                    fj(false);
                }
                o.Pj().br(i);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                CharSequence charSequence;
                Object obj = ImageGalleryGridUI.this;
                bd bdVar = (bd) obj.tUs.getItem(i);
                if (bdVar == null) {
                    charSequence = null;
                } else {
                    charSequence = com.tencent.mm.ui.gridviewheaders.a.czj().a(new Date(bdVar.field_createTime), obj);
                }
                ImageGalleryGridUI.this.jCc.setText(charSequence);
            }
        });
    }

    private void cwQ() {
        int firstVisiblePosition = this.tUr.getFirstVisiblePosition();
        int lastVisiblePosition = this.tUr.getLastVisiblePosition();
        int i = this.tUq;
        if (i < firstVisiblePosition || i > lastVisiblePosition) {
            this.tUr.setSelection(i);
        }
    }

    public void finish() {
        super.finish();
        g.a.cwU().detach();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g.a J;
        bd bdVar = (bd) this.tUs.getItem(i);
        String str = bdVar.field_content;
        if (str != null) {
            J = g.a.J(str, bdVar.field_reserved);
        } else {
            J = null;
        }
        String B;
        String str2;
        int i2;
        long j2;
        String bs;
        Intent intent;
        PackageInfo packageInfo;
        Bundle bundle;
        if (J != null && J.type == 6) {
            bt(bdVar);
        } else if (J != null && J.type == 3) {
            str = p.B(J.url, "message");
            B = p.B(J.dwn, "message");
            PackageInfo packageInfo2 = getPackageInfo(this.mController.tml, J.appId);
            str2 = packageInfo2 == null ? null : packageInfo2.versionName;
            i2 = packageInfo2 == null ? 0 : packageInfo2.versionCode;
            String str3 = J.appId;
            j2 = bdVar.field_msgId;
            long j3 = bdVar.field_msgSvrId;
            if ((str == null || str.length() == 0) && (B == null || B.length() == 0)) {
                x.e("MicroMsg.GalleryGridUI", "url, lowUrl both are empty");
                return;
            }
            if (ao.isMobile(this.mController.tml) ? B != null && B.length() > 0 : str == null || str.length() <= 0) {
                str = B;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("msg_id", j2);
            intent2.putExtra("rawUrl", str);
            intent2.putExtra("version_name", str2);
            intent2.putExtra("version_code", i2);
            intent2.putExtra("usePlugin", true);
            intent2.putExtra("geta8key_username", this.talker);
            intent2.putExtra("KPublisherId", "msg_" + Long.toString(j3));
            intent2.putExtra("KAppId", str3);
            bs = bs(bdVar);
            intent2.putExtra("pre_username", bs);
            intent2.putExtra("prePublishId", "msg_" + Long.toString(j3));
            if (bdVar != null) {
                intent2.putExtra("preUsername", bs);
            }
            intent2.putExtra("preChatName", this.talker);
            intent2.putExtra("preChatTYPE", t.N(bs, this.talker));
            intent2.putExtra("preMsgIndex", 0);
            d.b(this.mController.tml, "webview", ".ui.tools.WebViewUI", intent2);
        } else if (J == null || J.type != 5) {
            Intent intent3;
            String y;
            Object obj;
            String str4;
            int i3;
            if (J != null && J.type == 19) {
                intent3 = new Intent();
                intent3.putExtra("message_id", bdVar.field_msgId);
                intent3.putExtra("record_xml", J.dwW);
                d.b(this.mController.tml, "record", ".ui.RecordMsgDetailUI", intent3);
            } else if (J != null && J.type == 24) {
                lj ljVar = new lj();
                ljVar.bVI.context = this.mController.tml;
                ljVar.bVI.bJC = bdVar.field_msgId;
                ljVar.bVI.bVJ = J.dwW;
                com.tencent.mm.sdk.b.a.sFg.m(ljVar);
            } else if (J != null && J.type == 7) {
                f bl = com.tencent.mm.pluginsdk.model.app.g.bl(J.appId, false);
                if (bl != null && bl.aaq()) {
                    Object obj2;
                    bs = this.talker;
                    if (s.fq(bs)) {
                        bs = com.tencent.mm.model.bd.iB(bdVar.field_content);
                    }
                    j2 = bdVar.field_msgSvrId;
                    int i4 = (bl == null || !p.r(this.mController.tml, bl.field_packageName)) ? 6 : 3;
                    if (J.type == 2) {
                        i4 = 4;
                    } else if (J.type == 5) {
                        i4 = 1;
                    }
                    nk nkVar = new nk();
                    nkVar.bYs.context = this.mController.tml;
                    nkVar.bYs.scene = 1;
                    nkVar.bYs.bPS = J.appId;
                    nkVar.bYs.packageName = bl == null ? null : bl.field_packageName;
                    nkVar.bYs.msgType = J.type;
                    nkVar.bYs.bSS = bs;
                    nkVar.bYs.bYt = i4;
                    nkVar.bYs.mediaTagName = J.mediaTagName;
                    nkVar.bYs.bYu = j2;
                    nkVar.bYs.bYv = "";
                    com.tencent.mm.sdk.b.a.sFg.m(nkVar);
                    com.tencent.mm.plugin.game.a.a aSm = com.tencent.mm.plugin.game.a.a.a.aSm();
                    if (com.tencent.mm.pluginsdk.model.app.g.a(this.mController.tml, bl) || aSm == null) {
                        obj2 = null;
                    } else {
                        if (!bi.oW(bl.cmK)) {
                            x.i("MicroMsg.GalleryGridUI", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", new Object[]{bl.cmK, Boolean.valueOf(q.bi(this.mController.tml, bl.cmK))});
                            if (q.bi(this.mController.tml, bl.cmK)) {
                                obj2 = 1;
                            }
                        }
                        gk gkVar = new gk();
                        gkVar.bPB.actionCode = 2;
                        gkVar.bPB.scene = 1;
                        gkVar.bPB.appId = bl.field_appId;
                        gkVar.bPB.context = this.mController.tml;
                        com.tencent.mm.sdk.b.a.sFg.m(gkVar);
                        Intent intent4 = new Intent();
                        ActionBarActivity actionBarActivity = this.mController.tml;
                        aSm.S(bl.field_appId, 1, 1);
                        obj2 = 1;
                    }
                    if (obj2 != null) {
                        return;
                    }
                    if (J.bGP == null || J.bGP.length() == 0) {
                        bs = bdVar.field_content;
                        if (bdVar.field_isSend == 0) {
                            i4 = bdVar.field_isSend;
                            if (!this.qIZ && s.fq(this.talker) && bs != null && i4 == 0) {
                                bs = com.tencent.mm.model.bd.iC(bs);
                            }
                        }
                        g.a gp = g.a.gp(bs);
                        f bl2 = com.tencent.mm.pluginsdk.model.app.g.bl(gp.appId, true);
                        if (bl2 == null || !p.r(this.mController.tml, bl2.field_packageName)) {
                            y = p.y(this.mController.tml, gp.appId, "message");
                            intent3 = new Intent();
                            intent3.putExtra("rawUrl", y);
                            d.b(this.mController.tml, "webview", ".ui.tools.WebViewUI", intent3);
                        } else if (bl2.field_status == 3) {
                            x.e("MicroMsg.GalleryGridUI", "requestAppShow fail, app is in blacklist, packageName = " + bl2.field_packageName);
                        } else if (!p.b(this.mController.tml, bl2)) {
                            x.e("MicroMsg.GalleryGridUI", "The app %s signature is incorrect.", new Object[]{bl2.field_appName});
                            Toast.makeText(this.mController.tml, getString(R.l.game_launch_fail_alert, new Object[]{com.tencent.mm.pluginsdk.model.app.g.b(this.mController.tml, bl2, null)}), 1).show();
                        } else if (!a(bdVar, bl2)) {
                            WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
                            wXAppExtendObject.extInfo = gp.extInfo;
                            if (gp.bGP != null && gp.bGP.length() > 0) {
                                com.tencent.mm.pluginsdk.model.app.b SR = com.tencent.mm.pluginsdk.model.app.ao.asF().SR(gp.bGP);
                                wXAppExtendObject.filePath = SR == null ? null : SR.field_fileFullPath;
                            }
                            WXMediaMessage wXMediaMessage = new WXMediaMessage();
                            wXMediaMessage.sdkVer = 620823808;
                            wXMediaMessage.mediaObject = wXAppExtendObject;
                            wXMediaMessage.title = gp.title;
                            wXMediaMessage.description = gp.description;
                            wXMediaMessage.messageAction = gp.messageAction;
                            wXMediaMessage.messageExt = gp.messageExt;
                            wXMediaMessage.thumbData = e.e(o.Pf().lN(bdVar.field_imgPath), 0, -1);
                            new as(this).a(bl2.field_packageName, wXMediaMessage, bl2.field_appId, bl2.field_openId);
                        }
                    } else if (this.qUB) {
                        intent3 = new Intent();
                        intent3.setClassName(this.mController.tml, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                        intent3.putExtra("app_msg_id", bdVar.field_msgId);
                        startActivityForResult(intent3, 210);
                    } else {
                        com.tencent.mm.ui.base.s.gH(this.mController.tml);
                    }
                }
            } else if (bdVar.cmj() || bdVar.ckA() || bdVar.cmk() || bdVar.cmo()) {
                if (J == null || bi.oW(J.dyJ)) {
                    obj = null;
                } else {
                    bs = bdVar.field_imgPath;
                    intent = new Intent();
                    intent.putExtra("IsAd", false);
                    intent.putExtra("KStremVideoUrl", J.dyJ);
                    intent.putExtra("KThumUrl", J.dyO);
                    intent.putExtra("KThumbPath", bs);
                    intent.putExtra("KMediaId", "fakeid_" + bdVar.field_msgId);
                    intent.putExtra("KMediaVideoTime", J.dyK);
                    intent.putExtra("StremWebUrl", J.dyN);
                    intent.putExtra("StreamWording", J.dyM);
                    intent.putExtra("KMediaTitle", J.title);
                    str = bdVar.field_talker;
                    boolean endsWith = str.endsWith("@chatroom");
                    bs = endsWith ? com.tencent.mm.model.bd.iB(bdVar.field_content) : str;
                    intent.putExtra("KSta_StremVideoAduxInfo", J.dyP);
                    intent.putExtra("KSta_StremVideoPublishId", J.dyQ);
                    intent.putExtra("KSta_SourceType", 1);
                    intent.putExtra("KSta_Scene", endsWith ? a$b.TalkChat.value : a$b.Chat.value);
                    intent.putExtra("KSta_FromUserName", bs);
                    intent.putExtra("KSta_ChatName", str);
                    intent.putExtra("KSta_MsgId", bdVar.field_msgSvrId);
                    intent.putExtra("KSta_SnsStatExtStr", J.bZN);
                    if (endsWith) {
                        intent.putExtra("KSta_ChatroomMembercount", m.gK(str));
                    }
                    d.b(this.mController.tml, "sns", ".ui.VideoAdPlayerUI", intent);
                    obj = 1;
                }
                if (obj == null) {
                    M(view, i);
                }
            } else if (J != null && J.type == 15) {
                obj = J.dwZ;
                if (TextUtils.isEmpty(obj)) {
                    obj = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zn(J.url);
                }
                if (TextUtils.isEmpty(obj)) {
                    Intent intent5 = new Intent();
                    intent5.putExtra("geta8key_username", com.tencent.mm.model.q.GF());
                    intent5.putExtra("rawUrl", J.url);
                    d.b(this.mController.tml, "webview", ".ui.tools.WebViewUI", intent5);
                    return;
                }
                x.d("MicroMsg.GalleryGridUI", "start emoji detail from brandcontact");
                intent3 = new Intent();
                intent3.putExtra("extra_id", obj);
                intent3.putExtra("preceding_scence", 123);
                intent3.putExtra("download_entrance_scene", 23);
                d.b(this.mController.tml, "emoji", ".ui.EmojiStoreDetailUI", intent3);
                h.mEJ.h(10993, new Object[]{Integer.valueOf(2), obj});
            } else if (J != null && J.type == 26) {
                i2 = J.tid;
                str = J.dyH;
                B = J.desc;
                str2 = J.iconUrl;
                str4 = J.secondUrl;
                i3 = J.pageType;
                if (i2 != 0) {
                    Intent intent6 = new Intent();
                    intent6.putExtra("geta8key_username", bs(bdVar));
                    intent6.putExtra("rawUrl", J.cGB);
                    intent6.putExtra("topic_id", i2);
                    intent6.putExtra("topic_name", str);
                    intent6.putExtra("topic_desc", B);
                    intent6.putExtra("topic_icon_url", str2);
                    intent6.putExtra("topic_ad_url", str4);
                    intent6.putExtra("extra_scence", 23);
                    d.b(this.mController.tml, "emoji", ".ui.EmojiStoreTopicUI", intent6);
                    return;
                }
                x.i("MicroMsg.GalleryGridUI", "topic id is zero.");
            } else if (J == null || J.type != 27) {
                x.i("MicroMsg.GalleryGridUI", "talker:%s, msgId:%s, msgType:%s, msgContent:%s", new Object[]{bdVar.field_talker, Long.valueOf(bdVar.field_msgId), Integer.valueOf(bdVar.getType()), bdVar.field_content});
                if (J.url != null && !J.url.equals("") && J.url != null && !J.url.equals("")) {
                    bs = p.B(J.url, s.fq(this.talker) ? "groupmessage" : "singlemessage");
                    str = J.url;
                    packageInfo = getPackageInfo(this.mController.tml, J.appId);
                    intent = new Intent();
                    intent.putExtra("rawUrl", bs);
                    intent.putExtra("webpageTitle", J.title);
                    if (J.appId != null && ("wx751a1acca5688ba3".equals(J.appId) || "wxfbc915ff7c30e335".equals(J.appId) || "wx482a4001c37e2b74".equals(J.appId))) {
                        bundle = new Bundle();
                        bundle.putString("jsapi_args_appid", J.appId);
                        intent.putExtra("jsapiargs", bundle);
                    }
                    if (bi.oW(str)) {
                        intent.putExtra("shortUrl", J.url);
                    } else {
                        intent.putExtra("shortUrl", str);
                    }
                    intent.putExtra("version_name", packageInfo == null ? null : packageInfo.versionName);
                    intent.putExtra("version_code", packageInfo == null ? 0 : packageInfo.versionCode);
                    if (!bi.oW(J.bZG)) {
                        intent.putExtra("srcUsername", J.bZG);
                        intent.putExtra("srcDisplayname", J.bZH);
                    }
                    intent.putExtra("msg_id", bdVar.field_msgId);
                    intent.putExtra("KPublisherId", "msg_" + Long.toString(bdVar.field_msgSvrId));
                    intent.putExtra("KAppId", J.appId);
                    intent.putExtra("geta8key_username", com.tencent.mm.model.q.GF());
                    intent.putExtra("pre_username", bs(bdVar));
                    intent.putExtra("prePublishId", "msg_" + Long.toString(bdVar.field_msgSvrId));
                    y = bs(bdVar);
                    bs = com.tencent.mm.model.q.GF();
                    intent.putExtra("preUsername", y);
                    intent.putExtra("preChatName", bs);
                    intent.putExtra("preChatTYPE", t.N(y, bs));
                    intent.putExtra("preMsgIndex", 0);
                    d.b(this.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
                }
            } else {
                i2 = J.tid;
                str = J.dyH;
                B = J.desc;
                str2 = J.iconUrl;
                str4 = J.secondUrl;
                i3 = J.pageType;
                if (i2 != 0) {
                    Intent intent7 = new Intent();
                    intent7.putExtra("geta8key_username", bs(bdVar));
                    intent7.putExtra("rawUrl", J.cGB);
                    intent7.putExtra("set_id", i2);
                    intent7.putExtra("set_title", str);
                    intent7.putExtra("set_iconURL", str2);
                    intent7.putExtra("set_desc", B);
                    intent7.putExtra("headurl", str4);
                    intent7.putExtra("pageType", i3);
                    d.b(this.mController.tml, "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent7);
                    return;
                }
                x.i("MicroMsg.GalleryGridUI", "topic id is zero.");
            }
        } else if (J.url != null && !J.url.equals("")) {
            bs = p.B(J.url, this.talker.endsWith("@chatroom") ? "groupmessage" : "singlemessage");
            str = J.url;
            packageInfo = getPackageInfo(this.mController.tml, J.appId);
            intent = new Intent();
            intent.putExtra("rawUrl", bs);
            intent.putExtra("webpageTitle", J.title);
            if (J.appId != null && ("wx751a1acca5688ba3".equals(J.appId) || "wxfbc915ff7c30e335".equals(J.appId) || "wx482a4001c37e2b74".equals(J.appId))) {
                bundle = new Bundle();
                bundle.putString("jsapi_args_appid", J.appId);
                intent.putExtra("jsapiargs", bundle);
            }
            if (bi.oW(str)) {
                intent.putExtra("shortUrl", J.url);
            } else {
                intent.putExtra("shortUrl", str);
            }
            intent.putExtra("version_name", packageInfo == null ? null : packageInfo.versionName);
            intent.putExtra("version_code", packageInfo == null ? 0 : packageInfo.versionCode);
            if (!bi.oW(J.bZG)) {
                intent.putExtra("srcUsername", J.bZG);
                intent.putExtra("srcDisplayname", J.bZH);
            }
            intent.putExtra("msg_id", bdVar.field_msgId);
            intent.putExtra("KPublisherId", "msg_" + Long.toString(bdVar.field_msgSvrId));
            intent.putExtra("KAppId", J.appId);
            intent.putExtra("geta8key_username", this.talker);
            bs = bs(bdVar);
            intent.putExtra("pre_username", bs);
            intent.putExtra("prePublishId", "msg_" + Long.toString(bdVar.field_msgSvrId));
            intent.putExtra("preUsername", bs);
            intent.putExtra("preChatName", this.talker);
            intent.putExtra("preChatTYPE", t.N(bs, this.talker));
            intent.putExtra("preMsgIndex", 0);
            d.b(this.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    private boolean a(bd bdVar, f fVar) {
        if (!bdVar.field_talker.endsWith("@qqim") || !fVar.field_packageName.equals("com.tencent.mobileqq")) {
            return false;
        }
        int i;
        x.d("MicroMsg.GalleryGridUI", "jacks open QQ");
        Intent intent = new Intent("android.intent.action.MAIN", null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.addFlags(268435456);
        intent.setClassName("com.tencent.mobileqq", aF(this.mController.tml, "com.tencent.mobileqq"));
        intent.putExtra(Token.WX_TOKEN_PLATFORMID_KEY, Token.WX_TOKEN_PLATFORMID_VALUE);
        au.HU();
        Object obj = com.tencent.mm.model.c.DT().get(9, null);
        if (obj == null || !(obj instanceof Integer)) {
            i = 0;
        } else {
            i = ((Integer) obj).intValue();
        }
        if (i != 0) {
            try {
                byte[] bytes = String.valueOf(i).getBytes(ProtocolPackage.ServerEncoding);
                byte[] bytes2 = "asdfghjkl;'".getBytes(ProtocolPackage.ServerEncoding);
                int length = bytes2.length;
                i = 0;
                int i2 = 0;
                while (i < length) {
                    byte b = bytes2[i];
                    if (i2 >= bytes.length) {
                        break;
                    }
                    int i3 = i2 + 1;
                    bytes[i2] = (byte) (b ^ bytes[i2]);
                    i++;
                    i2 = i3;
                }
                intent.putExtra("tencent_gif", bytes);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.GalleryGridUI", e, "", new Object[0]);
            }
        }
        try {
            startActivity(intent);
        } catch (Exception e2) {
        }
        return true;
    }

    private static String aF(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                return resolveInfo.activityInfo.name;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GalleryGridUI", e, "", new Object[0]);
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String bs(com.tencent.mm.storage.bd r4) {
        /*
        r3 = this;
        r0 = r3.talker;
        r1 = "";
        r1 = com.tencent.mm.sdk.platformtools.bi.aG(r0, r1);
        r0 = r3.talker;
        r2 = "@chatroom";
        r0 = r0.endsWith(r2);
        if (r0 != 0) goto L_0x0015;
    L_0x0014:
        return r1;
    L_0x0015:
        if (r0 == 0) goto L_0x0027;
    L_0x0017:
        r0 = r4.field_content;
        r0 = com.tencent.mm.model.bd.iB(r0);
        if (r0 == 0) goto L_0x0027;
    L_0x001f:
        r2 = r0.length();
        if (r2 <= 0) goto L_0x0027;
    L_0x0025:
        r1 = r0;
        goto L_0x0014;
    L_0x0027:
        r0 = r1;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI.bs(com.tencent.mm.storage.bd):java.lang.String");
    }

    private static PackageInfo getPackageInfo(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        if (str == null || str.length() == 0) {
            str2 = packageInfo;
        } else {
            f bl = com.tencent.mm.pluginsdk.model.app.g.bl(str, true);
            if (bl == null) {
                Object str22 = packageInfo;
            } else {
                str22 = bl.field_packageName;
            }
        }
        if (str22 == null) {
            return packageInfo;
        }
        try {
            return context.getPackageManager().getPackageInfo(str22, 0);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GalleryGridUI", e, "", new Object[0]);
            return packageInfo;
        }
    }

    private void bt(bd bdVar) {
        long j = this.tUA + 30000;
        long currentTimeMillis = System.currentTimeMillis();
        this.tUA = currentTimeMillis;
        if (j < currentTimeMillis) {
            au.HU();
            this.qUB = com.tencent.mm.model.c.isSDCardAvailable();
        }
        if (this.qUB) {
            Intent intent = new Intent();
            intent.setClassName(this.mController.tml, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            intent.putExtra("app_msg_id", bdVar.field_msgId);
            startActivity(intent);
            return;
        }
        com.tencent.mm.ui.base.s.gH(this.mController.tml);
    }

    private void M(View view, int i) {
        if (this.tUs != null) {
            Intent intent = new Intent(this, ImageGalleryUI.class);
            intent.putExtra("key_biz_chat_id", this.hpD);
            intent.putExtra("key_is_biz_chat", this.qIZ);
            intent.putExtra("intent.key.with.footer", true);
            bd bdVar = (bd) this.tUs.getItem(i);
            if (bdVar != null) {
                int width;
                int height;
                int i2 = getResources().getConfiguration().orientation;
                int[] iArr = new int[2];
                if (view != null) {
                    width = view.getWidth();
                    height = view.getHeight();
                    view.getLocationInWindow(iArr);
                } else {
                    height = 0;
                    width = 0;
                }
                intent.addFlags(536870912);
                intent.putExtra("img_gallery_msg_id", bdVar.field_msgId).putExtra("img_gallery_msg_svr_id", bdVar.field_msgSvrId).putExtra("img_gallery_talker", bdVar.field_talker).putExtra("img_gallery_chatroom_name", bdVar.field_talker).putExtra("img_gallery_orientation", i2);
                if (view != null) {
                    intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]).putExtra("img_gallery_enter_from_grid", true);
                } else {
                    intent.putExtra("img_gallery_back_from_grid", true);
                }
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        }
    }

    public boolean onPreDraw() {
        c$a c_a = (c$a) this.tUt.get();
        if (c_a != null) {
            ViewTreeObserver viewTreeObserver = c_a.mZb.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
                int measuredWidth = c_a.mZb.getMeasuredWidth();
                int measuredHeight = c_a.mZb.getMeasuredHeight();
                if (measuredWidth > 0 && measuredHeight > 0) {
                    LayoutParams layoutParams = (LayoutParams) c_a.tNO.getLayoutParams();
                    layoutParams.width = measuredWidth;
                    layoutParams.height = measuredHeight;
                    c_a.tNO.setLayoutParams(layoutParams);
                    View view = c_a.tNO;
                    TimeInterpolator decelerateInterpolator = new DecelerateInterpolator();
                    if (VERSION.SDK_INT >= 12) {
                        this.tUC = view;
                        this.handler.postDelayed(new 7(this, view, decelerateInterpolator), 700);
                    }
                }
            }
        }
        return true;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getTitle().equals(getString(R.l.gallery_grid_selected_option))) {
            g.a.cwU().clear();
            cwx();
        } else {
            cwy();
        }
        return false;
    }

    private void cwx() {
        setMMTitle(getString(R.l.gallery_selected_title, new Object[]{Integer.valueOf(g.a.cwU().tTJ.size())}));
        g.a.cwU().tVs = true;
        if (this.tUs != null) {
            if (this.nen == null) {
                this.nen = AnimationUtils.loadAnimation(this, R.a.push_up_in);
            }
            c cVar = this.tUs;
            cVar.mGh = false;
            cVar.notifyDataSetChanged();
            this.tUD.setVisibility(0);
            this.tUD.startAnimation(this.nen);
            this.tUF.setEnabled(false);
            this.tUG.setEnabled(false);
            this.tUH.setEnabled(false);
            this.tUI.setEnabled(false);
            this.tUE = this.tUr.getPaddingBottom();
            this.tUr.setPadding(this.tUr.getPaddingLeft(), this.tUr.getPaddingTop(), this.tUr.getPaddingRight(), com.tencent.mm.bp.a.ad(this.mController.tml, R.f.SmallListHeight));
            h.mEJ.h(11627, new Object[]{Integer.valueOf(2)});
            removeOptionMenu(0);
            addTextOptionMenu(0, getString(R.l.gallery_grid_cancel_selected_option), this);
        }
    }

    private void cwR() {
        boolean z = !g.a.cwU().tTJ.isEmpty() && g.a.cwU().tVs;
        if (z) {
            this.tUF.setEnabled(true);
            this.tUG.setEnabled(true);
            this.tUH.setEnabled(true);
            this.tUI.setEnabled(true);
            return;
        }
        this.tUF.setEnabled(false);
        this.tUG.setEnabled(false);
        this.tUH.setEnabled(false);
        this.tUI.setEnabled(false);
    }

    public final void cwy() {
        g.a.cwU().tVs = false;
        setMMTitle(getString(R.l.all_pictures));
        if (this.tUs != null) {
            this.tUs.notifyDataSetChanged();
            if (this.tUE >= 0) {
                this.tUr.setPadding(this.tUr.getPaddingLeft(), this.tUr.getPaddingTop(), this.tUr.getPaddingRight(), this.tUE);
            }
            this.tUD.setVisibility(8);
            removeOptionMenu(0);
            addTextOptionMenu(0, getString(R.l.gallery_grid_selected_option), this);
        }
    }

    public void onClick(View view) {
        if (!g.a.cwU().tTJ.isEmpty()) {
            boolean endsWith = this.talker.toLowerCase().endsWith("@chatroom");
            List<bd> list = g.a.cwU().tTJ;
            if (list != null && !list.isEmpty()) {
                bd bdVar;
                String str;
                if (view.getId() == R.h.del_btn) {
                    h.mEJ.h(11627, new Object[]{Integer.valueOf(5)});
                    final Set treeSet = new TreeSet();
                    for (bd bdVar2 : list) {
                        treeSet.add(Long.valueOf(bdVar2.field_msgId));
                    }
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.confirm_delete), "", getString(R.l.delete_message), getString(R.l.app_cancel), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            x.i("MicroMsg.GalleryGridUI", "delete message");
                            i.a(ImageGalleryGridUI.this, treeSet, ImageGalleryGridUI.this);
                            ImageGalleryGridUI.this.cwy();
                        }
                    }, null);
                } else if (view.getId() == R.h.fav_btn) {
                    h.mEJ.a(219, 18, 1, true);
                    ch chVar = new ch();
                    if (com.tencent.mm.pluginsdk.model.g.a(this.mController.tml, chVar, this.talker, list, false, false)) {
                        b(chVar);
                        dG(list);
                    } else if (list.size() > 1) {
                        String string;
                        Context context = this.mController.tml;
                        String string2 = chVar.bJF.bJL >= 0 ? this.mController.tml.getString(R.l.favorite_fail_recordtype_error) : this.mController.tml.getString(R.l.favorite_fail_record_expired_bigfile);
                        str = "";
                        if (chVar.bJF.bJL >= 0) {
                            string = this.mController.tml.getString(R.l.confirm_dialog_ok);
                        } else {
                            string = this.mController.tml.getString(R.l.plugin_favorite_opt);
                        }
                        com.tencent.mm.ui.base.h.a(context, string2, str, string, this.mController.tml.getString(R.l.confirm_dialog_cancel), new 10(this, chVar, list), null);
                    } else {
                        com.tencent.mm.ui.base.h.i(this.mController.tml, chVar.bJF.bJL, 0);
                    }
                } else if (view.getId() == R.h.trans_btn) {
                    h.mEJ.a(219, 19, 1, true);
                    k.a(this, list, endsWith, this.talker, this);
                    cwy();
                } else {
                    h.mEJ.h(11627, new Object[]{Integer.valueOf(3)});
                    final List dJ = dJ(list);
                    if (dJ.size() != list.size()) {
                        com.tencent.mm.ui.base.h.a(this.mController.tml, R.l.gallery_save_sight_tips, R.l.app_tip, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                b.e(ImageGalleryGridUI.this.mController.tml, dJ);
                                ImageGalleryGridUI.this.cwy();
                            }
                        }, null);
                        return;
                    }
                    bdVar2 = (bd) dJ.get(0);
                    if (list.size() == 1 && bdVar2 != null && bdVar2.aQm()) {
                        str = bdVar2.field_content;
                        g.a aVar = null;
                        if (str != null) {
                            aVar = g.a.J(str, bdVar2.field_reserved);
                        }
                        if (aVar != null && aVar.type == 6) {
                            bt(bdVar2);
                            return;
                        }
                        return;
                    }
                    b.e(this, list);
                    cwy();
                }
            }
        }
    }

    private static void dG(List<bd> list) {
        for (bd a : list) {
            com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.c.tFU, com.tencent.mm.ui.chatting.a.d.tFZ, a, 0);
        }
    }

    private static List<bd> dJ(List<bd> list) {
        List<bd> arrayList = new ArrayList();
        for (bd bdVar : list) {
            if (!(b.bi(bdVar) || b.bj(bdVar))) {
                arrayList.add(bdVar);
            }
        }
        return arrayList;
    }

    private void b(ch chVar) {
        chVar.bJF.activity = this;
        chVar.bJF.bJM = 45;
        com.tencent.mm.sdk.b.a.sFg.m(chVar);
        if (chVar.bJG.ret != -2 && chVar.bJG.ret <= 0 && chVar.bJG.ret <= 0) {
            cwy();
            if (14 != chVar.bJF.type) {
                x.d("MicroMsg.GalleryGridUI", "not record type, do not report");
            } else if (chVar.bJF.bJI == null) {
                x.e("MicroMsg.GalleryGridUI", "want to report record fav, but type count is null");
            } else {
                h.mEJ.h(11142, new Object[]{Integer.valueOf(chVar.bJF.bJI.rBY), Integer.valueOf(chVar.bJF.bJI.rBZ), Integer.valueOf(chVar.bJF.bJI.rCa), Integer.valueOf(chVar.bJF.bJI.rCb), Integer.valueOf(chVar.bJF.bJI.rCc), Integer.valueOf(chVar.bJF.bJI.rCd), Integer.valueOf(chVar.bJF.bJI.rCe), Integer.valueOf(chVar.bJF.bJI.rCf), Integer.valueOf(chVar.bJF.bJI.rCg), Integer.valueOf(chVar.bJF.bJI.rCh), Integer.valueOf(chVar.bJF.bJI.rCi), Integer.valueOf(chVar.bJF.bJI.rCj), Integer.valueOf(chVar.bJF.bJI.rCk), Integer.valueOf(chVar.bJF.bJI.rCl), Integer.valueOf(chVar.bJF.bJI.rCm)});
            }
        }
    }

    public final void cwS() {
        if (this.tUs != null && this.mIsPause) {
            this.tUs.tUj = true;
        }
        setMMTitle(getString(R.l.gallery_selected_title, new Object[]{Integer.valueOf(g.a.cwU().tTJ.size())}));
        cwR();
    }

    public final void clear() {
        if (this.tUs != null && this.mIsPause) {
            this.tUs.tUj = true;
        }
        cwR();
    }

    public final void cug() {
    }

    public final void a(ah.a aVar) {
    }

    public final boolean cuh() {
        return true;
    }

    public final void b(ah.a aVar) {
        if (aVar == ah.a.tMx) {
            this.tUs.WT();
            this.tUs.notifyDataSetChanged();
        }
        cwy();
    }
}
