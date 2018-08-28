package com.tencent.mm.plugin.normsg;

import android.os.Build.VERSION;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.plugin.comm.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PluginNormsg extends f implements c, n, a {
    private static final String lFF = b.lFB.IO("\u001c:/-9+\n.\"0:41\r\"!");

    public void installed() {
        alias(a.class);
    }

    public void dependency() {
        dependsOn(d.class);
        dependsOn(com.tencent.mm.plugin.report.c.class);
        dependsOn(a.class);
        dependsOn(o.class);
    }

    public void configure(g gVar) {
        b.a(b.lFB);
    }

    public void execute(g gVar) {
    }

    public void onAccountInitialized(e.c cVar) {
        com.tencent.mm.plugin.normsg.b.a bjF = com.tencent.mm.plugin.normsg.b.a.bjF();
        g DM = com.tencent.mm.kernel.g.Ef().DM();
        if (com.tencent.mm.plugin.normsg.b.a.c.isEnabled()) {
            int bjL = com.tencent.mm.plugin.normsg.b.a.c.bjL();
            if (bjL <= 0) {
                bjL = 26;
            }
            if (VERSION.SDK_INT > bjL) {
                x.w("MircoMsg.AEDHLP", "[tomys] unsupported system, aedh is not enabled.");
            } else if (com.tencent.mm.plugin.normsg.b.a.lFM.contains(com.tencent.mm.plugin.normsg.b.a.IQ(DM.dox))) {
                try {
                    com.tencent.mm.plugin.normsg.b.b bjN = com.tencent.mm.plugin.normsg.b.b.bjN();
                    bjN.initialize(DM.dsQ);
                    bjN.Ff();
                    bjN.lGs.add(bjF);
                    x.i("MircoMsg.AEDHLP", "[tomys] aed installed.");
                } catch (Throwable e) {
                    x.printErrStackTrace("MircoMsg.AEDHLP", e, "[tomys] aed install failed.", new Object[0]);
                    bjF.g(e);
                }
            } else {
                x.w("MircoMsg.AEDHLP", "[tomys] not target process, skip installing aed.");
            }
        } else {
            x.w("MircoMsg.AEDHLP", "[tomys] aedh is not enabled.");
        }
        ((o) com.tencent.mm.kernel.g.n(o.class)).getSysCmdMsgExtension().a(lFF, this);
    }

    public void onAccountRelease() {
        ((o) com.tencent.mm.kernel.g.n(o.class)).getSysCmdMsgExtension().b(lFF, this);
    }

    public void onNewXmlReceived(String str, Map<String, String> map, com.tencent.mm.ab.d.a aVar) {
        x.i("MicroMsg.PluginNormsg", "xml cmd received, subType: %s", new Object[]{str});
        if (lFF.equals(str)) {
            processUpdateCCEncryptKey(map);
        }
    }

    private void processUpdateCCEncryptKey(Map<String, String> map) {
        String str = (String) map.get(b.lFB.IO("k5>3,1$b\u0018>+)=/\u000e:6$. %\u00196%s+-4"));
        if (bi.oW(str)) {
            x.e("MicroMsg.PluginNormsg", "uccek: cannot get required url.");
            return;
        }
        String bjy = Normsg.a.bjy();
        File file = bjy != null ? new File(bjy) : null;
        if (file == null) {
            x.e("MicroMsg.PluginNormsg", "uccek: failure to get required path.");
            h.mEJ.e(876, 0, 1);
            return;
        }
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!(parentFile.exists() || parentFile.mkdirs())) {
                x.e("MicroMsg.PluginNormsg", "uccek: failure to create required path.");
                h.mEJ.e(876, 1, 1);
                return;
            }
        }
        File file2 = new File(bjy + "_@tmp");
        if (file2.exists()) {
            file2.delete();
        } else {
            file2.getParentFile().mkdirs();
        }
        i iVar = new i();
        iVar.ceW = false;
        iVar.dPW = str;
        iVar.field_fileType = com.tencent.mm.modelcdntran.b.dOw;
        iVar.field_fullpath = file2.getAbsolutePath();
        iVar.field_mediaId = bjy;
        iVar.allow_mobile_net_download = false;
        iVar.dQa = true;
        iVar.is_resume_task = false;
        iVar.field_autostart = true;
        iVar.dPX = (int) TimeUnit.MINUTES.toSeconds(1);
        iVar.dPY = (int) TimeUnit.MINUTES.toSeconds(10);
        iVar.dPV = new 1(this, file2, file);
        com.tencent.mm.modelcdntran.g.ND().b(iVar, -1);
    }
}
