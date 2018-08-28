package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.a.g;
import com.tencent.mm.ab.d.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.a.c.c;
import com.tencent.mm.g.a.re;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.e.j;
import com.tencent.mm.plugin.emoji.e.n;
import com.tencent.mm.plugin.emoji.f.o;
import com.tencent.mm.plugin.emoji.f.r;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.m;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class d implements e {
    c ihc = new 3(this);
    public HashMap<Long, String> ihf = new HashMap();
    private boolean ihg = false;
    List<b> ihh = new LinkedList();
    private re ihi;
    public a ihj;
    List ihk = Collections.synchronizedList(new ArrayList());

    public d() {
        au.DF().a(ac.CTRL_BYTE, this);
    }

    public final void a(String str, EmojiInfo emojiInfo, bd bdVar) {
        if (!bi.oW(str) && emojiInfo != null) {
            long j;
            long T;
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = false;
            if (emojiInfo == null || bi.oW(emojiInfo.field_groupId)) {
                i.aEB().aEe();
            } else {
                boolean z2;
                j aEB = i.aEB();
                String str2 = emojiInfo.field_groupId;
                if (bi.oW(str2)) {
                    x.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip product id is null.");
                    z2 = false;
                } else if (aEB.igc || q.GO()) {
                    m mVar;
                    if (aEB.igg == null || !aEB.igg.containsKey(str2)) {
                        mVar = new m();
                        mVar.field_prodcutID = str2;
                    } else {
                        mVar = (m) aEB.igg.get(str2);
                    }
                    if (System.currentTimeMillis() - mVar.field_showTipsTime < aEB.igd) {
                        x.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip in cool down time.");
                        aEB.aEe();
                        z2 = false;
                    } else {
                        String str3;
                        String str4;
                        Object[] objArr;
                        String str5;
                        String str6;
                        int i;
                        int i2;
                        Object[] objArr2;
                        Object[] objArr3;
                        Object[] objArr4;
                        if (mVar == null || System.currentTimeMillis() - mVar.field_setFlagTime <= 86400000) {
                            str3 = "MicroMsg.emoji.EmojiRewardTipMgr";
                            str4 = "no need to get reward today. continue count:%d total count:%d";
                            objArr = new Object[2];
                            objArr[0] = Integer.valueOf(aEB.igf == null ? 0 : aEB.igf.field_continuCount);
                            objArr[1] = Integer.valueOf(aEB.igf == null ? 0 : aEB.igf.field_totalCount);
                            x.d(str3, str4, objArr);
                        } else if (aEB.igf != null && str2.equalsIgnoreCase(aEB.igf.field_prodcutID) && aEB.igf.field_continuCount >= aEB.ige - 1 && aEB.igf.field_continuCount <= (aEB.ige + 5) - 1) {
                            au.DF().a(new o(str2, o.iiT), 0);
                        } else if (mVar.field_totalCount >= aEB.hou - 1 && mVar.field_totalCount <= (aEB.hou + 5) - 1) {
                            au.DF().a(new o(str2, o.iiT), 0);
                        }
                        Object[] objArr5;
                        if (aEB.igf == null || !str2.equalsIgnoreCase(aEB.igf.field_prodcutID) || aEB.igf.field_continuCount < aEB.ige) {
                            if (mVar != null && mVar.field_totalCount >= aEB.hou) {
                                if ((mVar.field_flag & o.iiU) != o.iiU || (mVar.field_flag & o.iiV) == o.iiV) {
                                    str5 = "MicroMsg.emoji.EmojiRewardTipMgr";
                                    str6 = "isNeedShowTip:%b productid:%s  total count :%d flag:%d";
                                    objArr5 = new Object[4];
                                    objArr5[0] = Boolean.valueOf(false);
                                    objArr5[1] = str2;
                                    objArr5[2] = Integer.valueOf(aEB.igf == null ? 0 : aEB.igf.field_totalCount);
                                    i = 3;
                                    if (aEB.igf == null) {
                                        i2 = 0;
                                        objArr2 = objArr5;
                                        objArr3 = objArr5;
                                        objArr2[i] = Integer.valueOf(i2);
                                        x.i(str5, str6, objArr3);
                                    } else {
                                        objArr4 = objArr5;
                                        objArr3 = objArr5;
                                    }
                                } else {
                                    str3 = "MicroMsg.emoji.EmojiRewardTipMgr";
                                    str4 = "isNeedShowTip:%b productid:%s  total count :%d";
                                    objArr = new Object[3];
                                    objArr[0] = Boolean.valueOf(true);
                                    objArr[1] = str2;
                                    objArr[2] = Integer.valueOf(aEB.igf == null ? 0 : aEB.igf.field_totalCount);
                                    x.i(str3, str4, objArr);
                                    aEB.a(mVar, true);
                                    h hVar = h.mEJ;
                                    objArr5 = new Object[2];
                                    objArr5[0] = Integer.valueOf(0);
                                    objArr5[1] = aEB.igf == null ? "" : aEB.igf.field_prodcutID;
                                    hVar.h(12953, objArr5);
                                    z2 = true;
                                }
                            }
                            aEB.a(mVar, false);
                            z2 = false;
                        } else if ((aEB.igf.field_flag & o.iiU) != o.iiU || (aEB.igf.field_flag & o.iiV) == o.iiV) {
                            str5 = "MicroMsg.emoji.EmojiRewardTipMgr";
                            str6 = "isNeedShowTip:%b productid:%s  continue count:%d flag:%d";
                            objArr5 = new Object[4];
                            objArr5[0] = Boolean.valueOf(false);
                            objArr5[1] = str2;
                            objArr5[2] = Integer.valueOf(aEB.igf.field_continuCount);
                            i = 3;
                            objArr4 = objArr5;
                            objArr3 = objArr5;
                        } else {
                            x.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip:%b productid:%s  continue count:%d", new Object[]{Boolean.valueOf(true), str2, Integer.valueOf(aEB.igf.field_continuCount)});
                            aEB.a(mVar, true);
                            h.mEJ.h(12953, new Object[]{Integer.valueOf(0), aEB.igf.field_prodcutID});
                            z2 = true;
                        }
                        i2 = aEB.igf.field_flag;
                        objArr2 = objArr4;
                        objArr2[i] = Integer.valueOf(i2);
                        x.i(str5, str6, objArr3);
                        aEB.a(mVar, false);
                        z2 = false;
                    }
                } else {
                    x.i("MicroMsg.emoji.EmojiRewardTipMgr", "isNeedShowTip reward tip is disable. mRewardTipEnable:%b isOpenForWallet:%b", new Object[]{Boolean.valueOf(aEB.igc), Boolean.valueOf(q.GO())});
                    z2 = false;
                }
                x.i("MicroMsg.emoji.EmojiService", "isNeedShowRewardTip:%b", new Object[]{Boolean.valueOf(z2)});
                z = z2;
            }
            if (bdVar == null) {
                bd bdVar2 = new bd();
                if (emojiInfo.field_type == EmojiInfo.tcL || emojiInfo.field_type == EmojiInfo.tcM) {
                    bdVar2.setType(1048625);
                } else {
                    bdVar2.setType(47);
                }
                bdVar2.ep(str);
                bdVar2.eX(1);
                String GF = q.GF();
                boolean z3 = (emojiInfo.aaq() || emojiInfo.isGif()) ? false : true;
                bdVar2.setContent(an.a(GF, currentTimeMillis, z3, emojiInfo.Xh(), z, ""));
                bdVar2.eq(emojiInfo.Xh());
                bdVar2.ay(com.tencent.mm.model.bd.iD(bdVar2.field_talker));
                au.HU();
                j = currentTimeMillis;
                T = com.tencent.mm.model.c.FT().T(bdVar2);
            } else {
                long j2 = bdVar.field_msgId;
                an YJ = an.YJ(bdVar.field_content);
                if (YJ.time != 0) {
                    j = YJ.time;
                    T = j2;
                } else {
                    return;
                }
            }
            x.i("MicroMsg.emoji.EmojiService", "NetSceneUploadEmoji: msgId = " + T);
            this.ihh.add(new b(this, T, str, emojiInfo, String.valueOf(j)));
            if (!this.ihg || this.ihh.size() == 1) {
                this.ihg = true;
                au.DF().a(new r(String.valueOf(j), str, emojiInfo, T), 0);
            }
            String str7 = emojiInfo.field_md5;
            zD(emojiInfo.field_groupId);
        }
    }

    public final void zD(String str) {
        ah.A(new 1(this, str));
    }

    public final boolean g(EmojiInfo emojiInfo) {
        ap apVar;
        if (emojiInfo == null) {
            x.i("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiInfo failed. emojiinfo is null.");
            apVar = null;
        } else {
            ap apVar2 = new ap();
            apVar2.bKg = emojiInfo.field_md5;
            apVar2.taZ = emojiInfo.field_type;
            apVar2.tba = emojiInfo.field_size;
            apVar2.bKk = emojiInfo.field_groupId;
            apVar2.tbe = emojiInfo.field_designerID;
            apVar2.thumbUrl = emojiInfo.field_thumbUrl;
            apVar2.bOt = emojiInfo.field_encrypturl;
            apVar2.aeskey = emojiInfo.field_aeskey;
            apVar2.width = emojiInfo.field_width;
            apVar2.height = emojiInfo.field_height;
            apVar2.knh = emojiInfo.field_cdnUrl;
            apVar2.tbf = emojiInfo.field_externUrl;
            apVar2.tbg = emojiInfo.field_externMd5;
            apVar2.tbi = emojiInfo.field_activityid;
            apVar2.dwu = emojiInfo.field_tpurl;
            apVar2.dwA = emojiInfo.field_tpauthkey;
            apVar = apVar2;
        }
        if (apVar == null) {
            x.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
        } else {
            apVar.talker = emojiInfo == null ? "" : emojiInfo.talker;
            apVar.tbh = false;
            a(apVar, null, true);
            zD(emojiInfo == null ? null : emojiInfo.field_groupId);
        }
        return true;
    }

    public final void a(ap apVar, a aVar, boolean z) {
        if (apVar == null) {
            x.w("MicroMsg.emoji.EmojiService", "downloadEmoji msginfo is null.");
            return;
        }
        EmojiInfo emojiInfo;
        if (!(aVar == null || aVar.dIN == null || aVar.dIN.rcq != apVar.bYu)) {
            apVar.cqa = com.tencent.mm.model.bd.c(aVar);
            apVar.dYP = aVar.dIN.rcr;
            apVar.createTime = (long) aVar.dIN.lOH;
        }
        EmojiInfo Zy = i.aEA().igx.Zy(apVar.bKg);
        if (Zy != null) {
            Object obj = null;
            if (!(bi.oW(apVar.bKk) || apVar.bKk.equals(Zy.field_groupId))) {
                Zy.field_groupId = apVar.bKk;
                obj = 1;
            }
            if (!(bi.oW(apVar.tbe) || apVar.tbe.equals(Zy.field_designerID))) {
                Zy.field_designerID = apVar.tbe;
                obj = 1;
            }
            if (!(bi.oW(apVar.thumbUrl) || apVar.thumbUrl.equals(Zy.field_thumbUrl))) {
                Zy.field_thumbUrl = apVar.thumbUrl;
                obj = 1;
            }
            if (!(bi.oW(apVar.bOt) || apVar.bOt.equals(Zy.field_encrypturl))) {
                Zy.field_encrypturl = apVar.bOt;
                obj = 1;
            }
            if (!(bi.oW(apVar.aeskey) || apVar.aeskey.equals(Zy.field_aeskey))) {
                Zy.field_aeskey = apVar.aeskey;
                obj = 1;
            }
            if (!(bi.oW(apVar.knh) || apVar.knh.equals(Zy.field_cdnUrl))) {
                Zy.field_cdnUrl = apVar.knh;
                obj = 1;
            }
            if (!(bi.oW(apVar.dwu) || apVar.dwu.equals(Zy.field_tpurl))) {
                Zy.field_tpurl = apVar.dwu;
                obj = 1;
            }
            if (!(bi.oW(apVar.dwA) || apVar.dwA.equals(Zy.field_tpauthkey))) {
                Zy.field_tpauthkey = apVar.dwA;
                obj = 1;
            }
            if (apVar.width > 0 && apVar.width != Zy.field_width) {
                Zy.field_width = apVar.width;
                obj = 1;
            }
            if (apVar.height > 0 && apVar.height != Zy.field_height) {
                Zy.field_height = apVar.height;
                obj = 1;
            }
            if (!(bi.oW(apVar.tbf) || apVar.tbf.equals(Zy.field_externUrl))) {
                Zy.field_externUrl = apVar.tbf;
                obj = 1;
            }
            if (!(bi.oW(apVar.tbg) || apVar.tbg.equals(Zy.field_externMd5))) {
                Zy.field_externMd5 = apVar.tbg;
                obj = 1;
            }
            if (!(bi.oW(apVar.tbi) || apVar.tbi.equalsIgnoreCase(Zy.field_activityid))) {
                Zy.field_activityid = apVar.tbi;
                obj = 1;
            }
            if (obj != null) {
                i.aEA().igx.p(Zy);
                x.i("MicroMsg.emoji.EmojiService", "update designer info. designer:%s thumbUrl:%s", new Object[]{Zy.field_designerID, Zy.field_thumbUrl});
            }
            emojiInfo = Zy;
        } else {
            x.d("MicroMsg.emoji.EmojiService", "jacks prepare Emoji check groupId&md5 handle remote server old emoji version");
            EmojiInfo emojiInfo2 = new EmojiInfo();
            emojiInfo2.field_md5 = apVar.bKg;
            emojiInfo2.field_svrid = apVar.id;
            emojiInfo2.field_catalog = EmojiInfo.tcB;
            emojiInfo2.field_type = apVar.taZ;
            emojiInfo2.field_size = apVar.tba;
            emojiInfo2.field_groupId = apVar.bKk;
            emojiInfo2.field_designerID = apVar.tbe;
            emojiInfo2.field_thumbUrl = apVar.thumbUrl;
            emojiInfo2.field_cdnUrl = apVar.knh;
            emojiInfo2.field_temp = 1;
            emojiInfo2.field_encrypturl = apVar.bOt;
            emojiInfo2.field_aeskey = apVar.aeskey;
            emojiInfo2.field_designerID = apVar.tbe;
            emojiInfo2.field_thumbUrl = apVar.thumbUrl;
            emojiInfo2.field_state = EmojiInfo.tcR;
            emojiInfo2.field_width = apVar.width;
            emojiInfo2.field_height = apVar.height;
            emojiInfo2.field_externUrl = apVar.tbf;
            emojiInfo2.field_externMd5 = apVar.tbg;
            emojiInfo2.field_activityid = apVar.tbi;
            i.aEA().igx.n(emojiInfo2);
            emojiInfo = emojiInfo2;
        }
        long j = 0;
        if (apVar.tbh) {
            long j2;
            emojiInfo.cnv();
            if (apVar.bYu != 0) {
                au.HU();
                bd I = com.tencent.mm.model.c.FT().I(apVar.talker, apVar.bYu);
                if (I.field_msgSvrId == apVar.bYu) {
                    j2 = I.field_msgId;
                    j = j2;
                }
            }
            au.HU();
            ab Yg = com.tencent.mm.model.c.FR().Yg(apVar.talker);
            if (Yg == null || ((int) Yg.dhP) == 0) {
                Yg = new ab(apVar.talker);
                Yg.setType(2);
                au.HU();
                com.tencent.mm.model.c.FR().T(Yg);
            }
            bd bdVar = new bd();
            bdVar.setType(47);
            bdVar.ep(apVar.talker);
            bdVar.eX(q.gQ(apVar.enF) ? 1 : 0);
            bdVar.eq(emojiInfo.Xh());
            bdVar.ax(apVar.bYu);
            String str = apVar.enF;
            boolean z2 = (emojiInfo.aaq() || emojiInfo.isGif()) ? false : true;
            bdVar.setContent(an.a(str, 0, z2, emojiInfo.Xh(), false, apVar.tbd));
            bdVar.ay(com.tencent.mm.model.bd.o(bdVar.field_talker, apVar.createTime));
            bdVar.setStatus(3);
            if (!bi.oW(apVar.cqb)) {
                bdVar.dt(apVar.cqb);
            }
            if (aVar == null) {
                int i = apVar.cqa;
                if (i != 0) {
                    bdVar.fg(i);
                    if (bdVar.field_msgId == 0 && bdVar.field_isSend == 0 && (i & 2) != 0) {
                        bdVar.ay(com.tencent.mm.model.bd.g(bdVar.field_talker, apVar.createTime, bdVar.field_msgSeq));
                    }
                }
                if (apVar.dYP != 0) {
                    bdVar.aA((long) apVar.dYP);
                }
                x.i("MicroMsg.emoji.EmojiService", "summerbadcr insertEmojiMsg addMsgInfo is null but flag[%d], msgSeq[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(apVar.dYP)});
            } else {
                com.tencent.mm.model.bd.a(bdVar, aVar);
            }
            if (this.ihf != null && this.ihf.containsKey(Long.valueOf(bdVar.field_msgSvrId))) {
                x.i("MicroMsg.emoji.EmojiService", "this msg had been revoke.");
                bdVar.setContent((String) this.ihf.get(Long.valueOf(bdVar.field_msgSvrId)));
                bdVar.setType(10000);
                this.ihf.remove(Long.valueOf(bdVar.field_msgSvrId));
            }
            long i2 = com.tencent.mm.model.bd.i(bdVar);
            if (!q.gQ(apVar.enF)) {
                au.HU();
                ((ao) au.getNotification()).a(com.tencent.mm.model.c.FT().dW(i2));
            }
            j2 = i2;
            j = j2;
        }
        x.d("MicroMsg.emoji.EmojiService", "start download emoji %s, fileExist %b, download %b", new Object[]{emojiInfo.Xh(), Boolean.valueOf(emojiInfo.cnv()), Boolean.valueOf(z)});
        if (!emojiInfo.cnv()) {
            if (!z) {
                x.i("MicroMsg.emoji.EmojiService", "cdnurl and cncrypt url is null. autodownload %b", new Object[]{Boolean.valueOf(z)});
                this.ihk.remove(apVar.bKg);
                a(apVar);
            } else if (this.ihk == null || !this.ihk.contains(apVar.bKg)) {
                this.ihk.add(apVar.bKg);
                String cnF = emojiInfo.cnF();
                if (!bi.oW(apVar.dwu)) {
                    i iVar = new i();
                    iVar.field_mediaId = "downemoj_" + g.u(apVar.dwu.getBytes()).substring(0, 16) + "_" + apVar.bYu;
                    iVar.field_fullpath = cnF + "_openim";
                    iVar.field_fileType = 19;
                    iVar.field_authKey = emojiInfo.field_tpauthkey;
                    iVar.dPW = emojiInfo.field_tpurl;
                    iVar.field_priority = b.dOk;
                    final ap apVar2 = apVar;
                    final EmojiInfo emojiInfo3 = emojiInfo;
                    iVar.dPV = new i.a() {
                        public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
                            if (i == 0 && keep_sceneresult != null && keep_sceneresult.field_retCode == 0) {
                                d.this.ihc.a(true, new Object[]{apVar2, emojiInfo3, Integer.valueOf(103), Long.valueOf(j)});
                            }
                            return 0;
                        }

                        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                        }

                        public final byte[] i(String str, byte[] bArr) {
                            return new byte[0];
                        }
                    };
                    if (!com.tencent.mm.modelcdntran.g.ND().b(iVar, -1)) {
                        x.e("MicroMsg.emoji.EmojiService", "recv openim emoj, add task failed");
                    }
                } else if (n.aEm() && n.aEn() && !bi.oW(emojiInfo.field_externUrl) && !bi.oW(emojiInfo.field_externMd5)) {
                    i.aDZ().a(apVar.tbf, f.p(cnF + "_extern", new Object[]{apVar, emojiInfo, Integer.valueOf(101), Long.valueOf(j)}), this.ihc);
                    com.tencent.mm.plugin.emoji.c.cA(10);
                } else if (!bi.oW(apVar.bOt) && !bi.oW(apVar.aeskey)) {
                    i.aDZ().a(apVar.bOt, f.p(cnF + "_encrypt", new Object[]{apVar, emojiInfo, Integer.valueOf(102), Long.valueOf(j)}), this.ihc);
                    com.tencent.mm.plugin.emoji.c.cA(6);
                } else if (bi.oW(apVar.knh)) {
                    this.ihk.remove(apVar.bKg);
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(apVar.bKg);
                    au.DF().a(new com.tencent.mm.plugin.emoji.f.e(linkedList), 0);
                    x.i("MicroMsg.emoji.EmojiService", "emoji encrypt url and cdn url is null. md5:%s try to batch emoji download for get url.", new Object[]{apVar.bKg});
                    com.tencent.mm.plugin.emoji.c.cA(9);
                } else {
                    i.aDZ().a(apVar.knh, f.o(cnF, new Object[]{apVar, emojiInfo, Integer.valueOf(100), Long.valueOf(j)}), this.ihc);
                    com.tencent.mm.plugin.emoji.c.cA(1);
                }
            } else {
                x.i("MicroMsg.emoji.EmojiService", "emoji md5:%s is downloading.", new Object[]{apVar.bKg});
            }
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        int i3 = 2;
        x.d("MicroMsg.emoji.EmojiService", "errType %d,errCode %d,errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (!(lVar instanceof r)) {
            return;
        }
        if (this.ihh.size() <= 0) {
            this.ihg = false;
            return;
        }
        b bVar;
        b bVar2 = (b) this.ihh.remove(0);
        if (!(i == 0 && i2 == 0)) {
            com.tencent.mm.plugin.report.f.mDy.a(111, 35, 1, true);
            i3 = 5;
        }
        au.HU();
        bd dW = com.tencent.mm.model.c.FT().dW(bVar2.bJC);
        dW.setStatus(i3);
        au.HU();
        com.tencent.mm.model.c.FT().a(bVar2.bJC, dW);
        if (this.ihh.size() > 0) {
            bVar = (b) this.ihh.get(0);
            au.DF().a(new r(bVar.bNH, bVar.toUserName, bVar.bIk, bVar.bJC), 0);
        } else {
            this.ihg = false;
            bVar = bVar2;
        }
        if (this.ihi == null) {
            this.ihi = new re();
        }
        this.ihi.cbW.bKk = bVar.bIk.field_groupId;
        com.tencent.mm.sdk.b.a.sFg.m(this.ihi);
    }

    static void a(ap apVar) {
        if (apVar != null) {
            au.HU();
            com.tencent.mm.model.c.FT().a(new com.tencent.mm.plugin.messenger.foundation.a.a.f.c(apVar.talker, "update", null));
        }
    }
}
