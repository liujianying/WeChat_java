package com.tencent.mm.plugin.game.wepkg;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.game.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.game.wepkg.model.WepkgPreloadFile;
import com.tencent.mm.plugin.game.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.game.wepkg.model.e;
import com.tencent.mm.plugin.game.wepkg.model.f;
import com.tencent.mm.plugin.game.wepkg.model.g;
import com.tencent.mm.plugin.game.wepkg.utils.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import java.io.File;
import java.util.regex.Pattern;

public final class a {
    private static final Pattern eXs = Pattern.compile(".*#.*wechat_redirect");
    private long YH;
    private al bAZ;
    private MMWebView dEn;
    private MMActivity gKS;
    private String jIl;
    private boolean kdF;
    private e kdG;
    private WepkgVersion kdH;
    public a kdI;
    private int kdJ;
    private boolean kdK;
    public c kdL;
    public b kdM;
    private a kdN;

    public class b extends com.tencent.xweb.x5.a.a.a.a.b {
        public final Object onMiscCallBack(String str, Bundle bundle) {
            String str2 = "MicroMsg.Wepkg.WePkgPlugin";
            String str3 = "method = %s, bundler == null ? %b";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(bundle == null);
            x.i(str2, str3, objArr);
            if (bi.oW(str) || bundle == null || !a.this.kdF || a.this.kdG == null || !str.equalsIgnoreCase("shouldInterceptMediaUrl")) {
                return null;
            }
            String string = bundle.getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
            x.i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack origin mediaUrl:" + string);
            if (bi.oW(string)) {
                return null;
            }
            x.i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack replace localPath");
            e k = a.this.kdG;
            string = d.Ew(string);
            if (!(bi.oW(string) || k.kfq == null || k.kfq.get(string) == null)) {
                WepkgPreloadFile wepkgPreloadFile = (WepkgPreloadFile) k.kfq.get(string);
                if (!bi.oW(wepkgPreloadFile.filePath)) {
                    File file = new File(wepkgPreloadFile.filePath);
                    if (file.exists() && file.isFile() && file.length() == ((long) wepkgPreloadFile.size)) {
                        string = wepkgPreloadFile.filePath;
                        if (!bi.oW(string)) {
                            return null;
                        }
                        x.i("MicroMsg.Wepkg.WePkgPlugin", "localFile:" + string);
                        h.mEJ.a(859, 14, 1, false);
                        return string;
                    }
                }
            }
            string = null;
            if (!bi.oW(string)) {
                return null;
            }
            x.i("MicroMsg.Wepkg.WePkgPlugin", "localFile:" + string);
            h.mEJ.a(859, 14, 1, false);
            return string;
        }
    }

    static /* synthetic */ a c(a aVar) {
        return aVar.kdI == null ? aVar.kdN : aVar.kdI;
    }

    static /* synthetic */ int f(a aVar) {
        SharedPreferences sharedPreferences = aVar.gKS.getSharedPreferences("we_pkg_sp", 4);
        return sharedPreferences != null ? sharedPreferences.getInt("white_screen_times", 0) : 0;
    }

    static /* synthetic */ void h(a aVar) {
        SharedPreferences sharedPreferences = aVar.gKS.getSharedPreferences("we_pkg_sp", 4);
        if (sharedPreferences != null) {
            x.i("MicroMsg.Wepkg.WePkgPlugin", "disableWePkg");
            sharedPreferences.edit().putBoolean("disable_we_pkg", true).commit();
        }
    }

    public a(MMActivity mMActivity, MMWebView mMWebView) {
        this.kdF = false;
        this.YH = 0;
        this.kdJ = 0;
        this.kdK = false;
        this.bAZ = new al(new 3(this), false);
        this.kdL = new c(this);
        this.kdM = new b();
        this.kdN = new 4(this);
        this.gKS = mMActivity;
        this.dEn = mMWebView;
    }

    public a(MMActivity mMActivity, MMWebView mMWebView, int i) {
        this(mMActivity, mMWebView);
        this.kdJ = i;
        if (!WepkgMainProcessService.ajG()) {
            d.a("", null);
        }
    }

    public final boolean az(String str, boolean z) {
        if (this.kdJ == 0) {
            this.kdJ = this.gKS.hashCode();
        }
        com.tencent.mm.plugin.game.wepkg.utils.b.kgj.add(Integer.valueOf(this.kdJ));
        this.jIl = str;
        this.kdK = z;
        if (!d.Ex(this.jIl)) {
            com.tencent.mm.plugin.game.wepkg.utils.a.b("EnterWeb", this.jIl, d.Eu(this.jIl), null, 2, 0, null);
        } else if (WepkgMainProcessService.ajG()) {
            x.i("MicroMsg.Wepkg.WePkgPlugin", "WepkgMainProcessService is live");
            boolean aVy = g.aVy();
            com.tencent.mm.plugin.game.wepkg.utils.b.kgl = aVy;
            if (!aVy) {
                this.kdG = f.Eh(this.jIl);
                if (!(this.kdG == null || this.kdG.kff == null)) {
                    this.kdF = true;
                    this.kdH = this.kdG.kff;
                }
                d.Em().h(new 2(this, z), 0);
                x.i("MicroMsg.Wepkg.WePkgPlugin", "wepkgAvailable:%s", new Object[]{Boolean.valueOf(this.kdF)});
                if (this.kdF && this.kdH != null) {
                    com.tencent.mm.plugin.game.wepkg.utils.a.b("EnterWeb", this.jIl, this.kdH.kfA, this.kdH.version, 1, 0, null);
                }
            }
        } else {
            x.i("MicroMsg.Wepkg.WePkgPlugin", "WepkgMainProcessService is dead");
            d.a(this.jIl, new 1(this, z));
            com.tencent.mm.plugin.game.wepkg.utils.a.b("EnterWeb", this.jIl, d.Eu(this.jIl), null, 0, 0, com.tencent.mm.plugin.game.wepkg.utils.a.rd(10));
        }
        x.i("MicroMsg.Wepkg.WePkgPlugin", "pkgid:%s,  wepkgAvailable:%b", new Object[]{d.Eu(str), Boolean.valueOf(this.kdF)});
        return this.kdF;
    }

    public final void onDestroy() {
        if (this.kdK) {
            String Eu = d.Eu(this.jIl);
            if (!bi.oW(Eu)) {
                f.Ei(Eu);
            }
        }
        if (com.tencent.mm.plugin.game.wepkg.utils.b.kgj.contains(Integer.valueOf(this.kdJ))) {
            com.tencent.mm.plugin.game.wepkg.utils.b.kgj.remove(Integer.valueOf(this.kdJ));
        }
        if (com.tencent.mm.plugin.game.wepkg.utils.b.kgj.size() == 0) {
            com.tencent.mm.plugin.game.wepkg.utils.b.kgk.kgm.clear();
            x.i("MicroMsg.Wepkg.WePkgPlugin", "clear wepkg info in memory");
        }
    }

    public final void aVl() {
        x.i("MicroMsg.Wepkg.WePkgPlugin", "disable current wepkg");
        this.kdF = false;
    }

    public final boolean DS(String str) {
        if (eXs.matcher(bi.oV(str)).find()) {
            return false;
        }
        return this.kdF;
    }

    public final boolean aVm() {
        return this.kdH == null || !this.kdH.kfR;
    }
}
