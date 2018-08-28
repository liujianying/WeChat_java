package com.tencent.mm.compatible.e;

import com.tencent.mm.compatible.i.a;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

final class r {
    r() {
    }

    public static boolean a(String str, o oVar, c cVar, b bVar, k kVar, v vVar, z zVar, s sVar, u uVar, x xVar, t tVar, a aVar) {
        try {
            x.d("MicroMsg.DeviceInfoParser", "xml: " + str);
            Map z = bl.z(str, "deviceinfoconfig");
            if (z == null) {
                x.i("MicroMsg.DeviceInfoParser", "hy: null device config");
                return false;
            }
            if (z.get(".deviceinfoconfig.voip.cpu.armv7") != null) {
                oVar.dez = bi.getInt((String) z.get(".deviceinfoconfig.voip.cpu.armv7"), 0);
                oVar.dey = true;
            }
            if (z.get(".deviceinfoconfig.voip.cpu.armv6") != null) {
                oVar.deA = bi.getInt((String) z.get(".deviceinfoconfig.voip.cpu.armv6"), 0);
                oVar.dey = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.num") != null) {
                cVar.dcI = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.num"), 0);
                cVar.dcJ = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.surface") != null) {
                cVar.dcK = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.surface"), 0);
                cVar.dcL = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.format") != null) {
                cVar.dcM = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.format"), 0);
                cVar.anb = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.back.enable") != null) {
                cVar.dcP.ddp = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.back.enable"), 0);
                cVar.dcQ = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.back.fps") != null) {
                cVar.dcP.fps = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.back.fps"), 0);
                cVar.dcQ = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.back.orien") != null) {
                cVar.dcP.ddq = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.back.orien"), 0);
                cVar.dcQ = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.back.rotate") != null) {
                cVar.dcP.bYE = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.back.rotate"), 0);
                cVar.dcQ = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.back.isleft") != null) {
                cVar.dcP.ddr = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.back.isleft"), 0);
                cVar.dcQ = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.back.width") != null) {
                cVar.dcP.width = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.back.width"), 0);
                cVar.dcQ = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.back.height") != null) {
                cVar.dcP.height = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.back.height"), 0);
                cVar.dcQ = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.front.enable") != null) {
                cVar.dcN.ddp = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.front.enable"), 0);
                cVar.dcO = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.front.fps") != null) {
                cVar.dcN.fps = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.front.fps"), 0);
                cVar.dcO = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.front.orien") != null) {
                cVar.dcN.ddq = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.front.orien"), 0);
                cVar.dcO = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.front.rotate") != null) {
                cVar.dcN.bYE = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.front.rotate"), 0);
                cVar.dcO = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.front.isleft") != null) {
                cVar.dcN.ddr = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.front.isleft"), 0);
                cVar.dcO = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.front.width") != null) {
                cVar.dcN.width = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.front.width"), 0);
                cVar.dcO = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.front.height") != null) {
                cVar.dcN.height = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.front.height"), 0);
                cVar.dcO = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.videorecord.frotate") != null) {
                cVar.dcS = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.videorecord.frotate"), 0);
                cVar.dcR = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.videorecord.forientation") != null) {
                cVar.dcT = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.videorecord.forientation"), 0);
                cVar.dcR = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.videorecord.brotate") != null) {
                cVar.dcU = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.videorecord.brotate"), 0);
                cVar.dcR = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.videorecord.borientation") != null) {
                cVar.dcV = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.videorecord.borientation"), 0);
                cVar.dcR = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.videorecord.num") != null) {
                cVar.dcW = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
                cVar.dcX = true;
                cVar.dcR = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
                cVar.dcZ = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
                cVar.dcY = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold") != null) {
                cVar.dda = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.scannerImageQuality") != null) {
                cVar.ddb = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.scannerImageQuality"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.autoFocusTimeInterval") != null) {
                cVar.ddn = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.autoFocusTimeInterval"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.focusType") != null) {
                cVar.ddo = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.focusType"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.videorecord.num") != null) {
                cVar.dcW = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
                cVar.dcX = true;
                cVar.dcR = true;
            }
            if (z.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
                cVar.dcZ = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
                cVar.dcY = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.useFixFPSMode") != null) {
                cVar.ddc = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.useFixFPSMode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.useRangeFPSMode") != null) {
                cVar.ddd = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.useRangeFPSMode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat") != null) {
                cVar.dde = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.useMeteringMode") != null) {
                cVar.ddf = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.useMeteringMode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode") != null) {
                cVar.ddg = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported") != null) {
                cVar.ddh = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.sightCameraID") != null) {
                cVar.ddj = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.sightCameraID"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.needEnhance") != null) {
                cVar.ddk = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.needEnhance"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.support480enc") != null) {
                cVar.ddl = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.support480enc"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.camera.supportHWenc") != null) {
                cVar.ddm = bi.getInt((String) z.get(".deviceinfoconfig.voip.camera.supportHWenc"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.streamtype") != null) {
                bVar.dbz = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.streamtype"), 0);
                bVar.dby = true;
            }
            if (z.get(".deviceinfoconfig.voip.audio.smode") != null) {
                bVar.dbA = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.smode"), 0);
                bVar.dby = true;
            }
            if (z.get(".deviceinfoconfig.voip.audio.omode") != null) {
                bVar.dbB = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.omode"), 0);
                bVar.dby = true;
            }
            if (z.get(".deviceinfoconfig.voip.audio.ospeaker") != null) {
                bVar.dbC = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.ospeaker"), 0);
                bVar.dby = true;
            }
            if (z.get(".deviceinfoconfig.voip.audio.operating") != null) {
                bVar.dbD = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.operating"), 0);
                bVar.dby = true;
            }
            if (z.get(".deviceinfoconfig.voip.audio.moperating") != null) {
                bVar.dbE = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.moperating"), 0);
                bVar.dby = true;
            }
            if (z.get(".deviceinfoconfig.voip.audio.mstreamtype") != null) {
                bVar.dbF = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.mstreamtype"), 0);
                bVar.dby = true;
            }
            if (z.get(".deviceinfoconfig.voip.audio.recordmode") != null) {
                bVar.dbG = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.recordmode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
                bVar.dbH = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.aecmode") != null) {
                bVar.dbI = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.aecmode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.nsmode") != null) {
                bVar.dbJ = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.nsmode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.volummode") != null) {
                bVar.dbK = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.volummode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.sourcemode") != null) {
                bVar.dbX = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.sourcemode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.micmode") != null) {
                bVar.dbW = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.micmode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.speakerMode") != null) {
                bVar.dbY = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.speakerMode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.phoneMode") != null) {
                bVar.dbZ = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.phoneMode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType") != null) {
                bVar.dca = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.speakerstreamtype") != null) {
                bVar.dcb = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.speakerstreamtype"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.phonestreamtype") != null) {
                bVar.dcc = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.phonestreamtype"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.ringphonestream") != null) {
                bVar.dce = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.ringphonestream"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.ringphonemode") != null) {
                bVar.dcf = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.ringphonemode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.ringspeakerstream") != null) {
                bVar.dcg = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.ringspeakerstream"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.ringspeakermode") != null) {
                bVar.dch = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.ringspeakermode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.aecmodenew") != null) {
                bVar.dci = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.aecmodenew"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.nsmodenew") != null) {
                bVar.dcj = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.nsmodenew"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agcmodenew") != null) {
                bVar.dck = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.agcmodenew"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agcmode") != null) {
                bVar.dcl = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.agcmode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agctargetdb") != null) {
                bVar.dcm = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.agctargetdb"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agcgaindb") != null) {
                bVar.dcn = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.agcgaindb"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agcflag") != null) {
                bVar.dco = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.agcflag"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agclimiter") != null) {
                bVar.dcp = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.agclimiter"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.inputvolumescale") != null) {
                bVar.dbL = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.inputvolumescale"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.outputvolumescale") != null) {
                bVar.dbM = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.outputvolumescale"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker") != null) {
                bVar.dbN = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker") != null) {
                bVar.dbO = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.ehanceheadsetec") != null) {
                bVar.dbR = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.ehanceheadsetec"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset") != null) {
                bVar.dbS = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker") != null) {
                bVar.dbT = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec") != null) {
                bVar.dbU = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.enablerectimer") != null) {
                bVar.dcq = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.enablerectimer"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.enablePlayTimer") != null) {
                bVar.dcr = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.enablePlayTimer"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof0") != null) {
                bVar.dct[0] = (short) bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof0"), 0);
                bVar.dcs = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof1") != null) {
                bVar.dct[1] = (short) bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof1"), 0);
                bVar.dcs = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof2") != null) {
                bVar.dct[2] = (short) bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof2"), 0);
                bVar.dcs = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof3") != null) {
                bVar.dct[3] = (short) bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof3"), 0);
                bVar.dcs = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof4") != null) {
                bVar.dct[4] = (short) bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof4"), 0);
                bVar.dcs = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof5") != null) {
                bVar.dct[5] = (short) bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof5"), 0);
                bVar.dcs = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof6") != null) {
                bVar.dct[6] = (short) bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof6"), 0);
                bVar.dcs = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof7") != null) {
                bVar.dct[7] = (short) bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof7"), 0);
                bVar.dcs = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof8") != null) {
                bVar.dct[8] = (short) bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof8"), 0);
                bVar.dcs = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof9") != null) {
                bVar.dct[9] = (short) bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof9"), 0);
                bVar.dcs = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof10") != null) {
                bVar.dct[10] = (short) bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof10"), 0);
                bVar.dcs = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof11") != null) {
                bVar.dct[11] = (short) bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof11"), 0);
                bVar.dcs = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof12") != null) {
                bVar.dct[12] = (short) bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof12"), 0);
                bVar.dcs = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof13") != null) {
                bVar.dct[13] = (short) bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof13"), 0);
                bVar.dcs = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctcof.cof14") != null) {
                bVar.dct[14] = (short) bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctcof.cof14"), 0);
                bVar.dcs = 1;
            }
            if (z.get(".deviceinfoconfig.voip.audio.correctoff") != null && bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.correctoff"), 0) == 1) {
                bVar.dcs = 0;
            }
            if (z.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone") != null) {
                bVar.dbP = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker") != null) {
                bVar.dbQ = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0") != null) {
                bVar.dcu[0] = (short) bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1") != null) {
                bVar.dcu[1] = (short) bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agcrxflag") != null) {
                bVar.dcE = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.agcrxflag"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agcrxtargetdb") != null) {
                bVar.dcF = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.agcrxtargetdb"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agcrxgaindb") != null) {
                bVar.dcG = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.agcrxgaindb"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.agcrxlimiter") != null) {
                bVar.dcH = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.agcrxlimiter"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.spkecenable") != null) {
                bVar.dcw = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.spkecenable"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.enableXnoiseSup") != null) {
                bVar.dbV = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.enableXnoiseSup"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
                bVar.dbH = bi.getInt((String) z.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.ipcall.speakermode") != null) {
                bVar.dcy = bi.getInt((String) z.get(".deviceinfoconfig.voip.ipcall.speakermode"), 0);
                bVar.dcx = true;
            }
            if (z.get(".deviceinfoconfig.voip.ipcall.phonemode") != null) {
                bVar.dcz = bi.getInt((String) z.get(".deviceinfoconfig.voip.ipcall.phonemode"), 0);
                bVar.dcx = true;
            }
            if (z.get(".deviceinfoconfig.voip.ipcall.sourcemode") != null) {
                bVar.dcA = bi.getInt((String) z.get(".deviceinfoconfig.voip.ipcall.sourcemode"), 0);
                bVar.dcx = true;
            }
            if (z.get(".deviceinfoconfig.voip.ipcall.streamtype") != null) {
                bVar.dcB = bi.getInt((String) z.get(".deviceinfoconfig.voip.ipcall.streamtype"), 0);
                bVar.dcx = true;
            }
            if (z.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype") != null) {
                bVar.dcC = bi.getInt((String) z.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype"), 0);
                bVar.dcx = true;
            }
            if (z.get(".deviceinfoconfig.voip.ipcall.phonestreamtype") != null) {
                bVar.dcD = bi.getInt((String) z.get(".deviceinfoconfig.voip.ipcall.phonestreamtype"), 0);
                bVar.dcx = true;
            }
            if (z.get(".deviceinfoconfig.voip.common.js") != null) {
                kVar.ddC = true;
                kVar.ddD = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.js"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.js") != null) {
                kVar.ddu = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.js"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.stopbluetoothbr") != null) {
                kVar.ddv = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.stopbluetoothbr"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.stopbluetoothbu") != null) {
                kVar.ddw = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.stopbluetoothbu"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.setbluetoothscoon") != null) {
                kVar.ddy = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.setbluetoothscoon"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.startbluetoothsco") != null) {
                kVar.ddx = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.startbluetoothsco"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.voicesearchfastmode") != null) {
                kVar.ddz = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.voicesearchfastmode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.pcmreadmode") != null) {
                kVar.ddB = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.pcmreadmode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.pcmbufferrate") != null) {
                kVar.ddA = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.pcmbufferrate"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.app") != null) {
                kVar.ddE = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.app"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp") != null) {
                kVar.ddX = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns") != null) {
                kVar.ddY = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec") != null) {
                kVar.ddZ = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc") != null) {
                kVar.dea = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.vmfd") != null) {
                kVar.ddF = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.vmfd"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.htcvoicemode") != null) {
                kVar.ddG = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.htcvoicemode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.samsungvoicemode") != null) {
                kVar.ddH = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.samsungvoicemode"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.speexbufferrate") != null) {
                kVar.ddI = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.speexbufferrate"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.linespe") != null) {
                kVar.ddJ = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.linespe"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.fixspan") != null) {
                kVar.ddU = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.fixspan"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.extvideo") != null) {
                kVar.ddK = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.extvideo"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.extvideosam") != null) {
                kVar.ddL = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.extvideosam"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.sysvideodegree") != null) {
                kVar.ddM = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.sysvideodegree"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.mmnotify") != null) {
                kVar.ddP = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.mmnotify"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.extsharevcard") != null) {
                kVar.ddO = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.extsharevcard"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.audioformat") != null) {
                kVar.ddQ = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.audioformat"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.qrcam") != null) {
                kVar.ddR = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.qrcam"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.sysvideofdegree") != null) {
                kVar.ddN = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.sysvideofdegree"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.audioformat") != null) {
                kVar.ddQ = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.audioformat"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.qrcam") != null) {
                kVar.ddR = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.qrcam"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.base") != null) {
                kVar.deb = (String) z.get(".deviceinfoconfig.voip.common.base");
            }
            if (z.get(".deviceinfoconfig.voip.common.packageinfo") != null) {
                kVar.dec = (String) z.get(".deviceinfoconfig.voip.common.packageinfo");
            }
            if (z.get(".deviceinfoconfig.voip.common.classloader") != null) {
                kVar.ded = (String) z.get(".deviceinfoconfig.voip.common.classloader");
            }
            if (z.get(".deviceinfoconfig.voip.common.resources") != null) {
                kVar.dee = (String) z.get(".deviceinfoconfig.voip.common.resources");
            }
            if (z.get(".deviceinfoconfig.voip.common.sysvideofp") != null) {
                kVar.ddS = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.sysvideofp"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.common.extstoragedir") != null) {
                kVar.def = (String) z.get(".deviceinfoconfig.voip.common.extstoragedir");
            }
            if (z.get(".deviceinfoconfig.voip.common.extpubdir") != null) {
                kVar.deg = (String) z.get(".deviceinfoconfig.voip.common.extpubdir");
            }
            if (z.get(".deviceinfoconfig.voip.common.extdatadir") != null) {
                kVar.deh = (String) z.get(".deviceinfoconfig.voip.common.extdatadir");
            }
            if (z.get(".deviceinfoconfig.voip.common.extrootdir") != null) {
                kVar.dei = (String) z.get(".deviceinfoconfig.voip.common.extrootdir");
            }
            if (z.get(".deviceinfoconfig.voip.common.extstoragestate") != null) {
                kVar.dej = (String) z.get(".deviceinfoconfig.voip.common.extstoragestate");
            }
            if (z.get(".deviceinfoconfig.voip.common.extcachedir") != null) {
                kVar.dek = (String) z.get(".deviceinfoconfig.voip.common.extcachedir");
            }
            if (z.get(".deviceinfoconfig.voip.common.extvideoplayer") != null) {
                kVar.ddT = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.extvideoplayer"), -1);
            }
            if (z.get(".deviceinfoconfig.voip.common.loadDrawable") != null) {
                kVar.del = (String) z.get(".deviceinfoconfig.voip.common.loadDrawable");
            }
            if (z.get(".deviceinfoconfig.voip.common.loadXmlResourceParser") != null) {
                kVar.dem = (String) z.get(".deviceinfoconfig.voip.common.loadXmlResourceParser");
            }
            if (z.get(".deviceinfoconfig.voip.common.sensorNearFar") != null && 1 == bi.getInt((String) z.get(".deviceinfoconfig.voip.common.sensorNearFar"), 0)) {
                SensorController.sJa = true;
            }
            if (z.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio") != null) {
                SensorController.sJb = bi.getDouble((String) z.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio"), 0.0d);
            }
            if (z.get(".deviceinfoconfig.voip.common.sightFullType") != null) {
                kVar.den = (String) z.get(".deviceinfoconfig.voip.common.sightFullType");
            }
            if (z.get(".deviceinfoconfig.voip.common.slyTextureView") != null) {
                kVar.deo = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.slyTextureView"), -1);
            }
            if (z.get(".deviceinfoconfig.voip.common.checkSightDraftMd5") != null) {
                kVar.dep = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.checkSightDraftMd5"), 1);
            }
            if (z.get(".deviceinfoconfig.voip.common.swipeBackConfig") != null) {
                kVar.deq = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.swipeBackConfig"), 1);
                a.bf(kVar.deq == 1);
            }
            if (z.get(".deviceinfoconfig.voip.common.canDecodeWebp") != null) {
                kVar.der = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.canDecodeWebp"), 1);
            }
            if (z.get(".deviceinfoconfig.voip.common.isScanZoom") != null) {
                kVar.ddV = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.isScanZoom"), -1);
            }
            if (z.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio") != null) {
                kVar.ddW = bi.getDouble((String) z.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio"), -1.0d);
            }
            if (z.get(".deviceinfoconfig.voip.common.notificationSetMode") != null) {
                kVar.des = bi.getInt((String) z.get(".deviceinfoconfig.voip.common.notificationSetMode"), -1);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo") != null) {
                vVar.dfq = bi.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo"), 0) == 1;
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.width") != null) {
                vVar.mVideoWidth = bi.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.width"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.height") != null) {
                vVar.mVideoHeight = bi.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.height"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.frameRate") != null) {
                vVar.dfr = bi.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.frameRate"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate") != null) {
                vVar.dfs = bi.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.useSystem") != null) {
                vVar.dft = bi.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.useSystem"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek") != null) {
                vVar.dfu = bi.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC") != null) {
                vVar.dfv = bi.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate") != null) {
                vVar.dfw = bi.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera") != null) {
                vVar.dfx = bi.getInt((String) z.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera"), 0);
            }
            if (z.get(".deviceinfoconfig.voip.webview.notifythread") != null) {
                zVar.dfB = bi.getInt((String) z.get(".deviceinfoconfig.voip.webview.notifythread"), 0) == 1;
            }
            if (z.get(".deviceinfoconfig.voip.webview.forceUseSysWebView") != null) {
                zVar.dfC = bi.getInt((String) z.get(".deviceinfoconfig.voip.webview.forceUseSysWebView"), 0) == 1;
                x.i("MicroMsg.DeviceInfoParser", "save forceusesystemwebview = %b", Boolean.valueOf(zVar.dfC));
                ad.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit().putBoolean("tbs_force_user_sys_webview", zVar.dfC).commit();
            }
            kVar.dump();
            int i = bi.getInt((String) z.get(".deviceinfoconfig.fingerprint.forceFingerprintStatus"), 0);
            int i2 = bi.getInt((String) z.get(".deviceinfoconfig.fingerprint.supportExportEntrance"), 0);
            x.i("MicroMsg.DeviceInfoParser", "hy: got fingerprint force status: %d", Integer.valueOf(i));
            if (sVar != null) {
                sVar.fO(i);
                sVar.fN(i2);
            }
            x.i("MicroMsg.DeviceInfoParser", "hy: get soter status: %d", Integer.valueOf(bi.getInt((String) z.get(".deviceinfoconfig.soter.isSupport"), 0)));
            if (xVar != null) {
                xVar.bd(i2 == 1);
            }
            x.i("MicroMsg.DeviceInfoParser", "lm: got PublicNum: %s", (String) z.get(".deviceinfoconfig.freeWifi.operations.bizUserName"));
            if (uVar != null) {
                uVar.fe(r2);
            }
            x.i("MicroMsg.DeviceInfoParser", "lm: got manufacturerNameMaps: %s", bl.z(str, "manufacturerName"));
            if (uVar != null) {
                uVar.i(r2);
            }
            x.i("MicroMsg.DeviceInfoParser", "lm: got swipback: %d", Integer.valueOf(bi.getInt((String) z.get(".deviceinfoconfig.style.swipback"), 0)));
            if (uVar != null) {
                uVar.fP(i2);
            }
            x.i("MicroMsg.DeviceInfoParser", "lm: get game status: %d,gamePrompt:%s", Integer.valueOf(bi.getInt((String) z.get(".deviceinfoconfig.game.isLimit"), 0)), (String) z.get(".deviceinfoconfig.game.limitPrompt"));
            if (aVar != null) {
                aVar.bb(i == 1);
                aVar.fa(r2);
            }
            i = bi.getInt((String) z.get(".deviceinfoconfig.mmsight.recordertype"), -1);
            int i3 = bi.getInt((String) z.get(".deviceinfoconfig.mmsight.needRotateEachFrame"), -1);
            int i4 = bi.getInt((String) z.get(".deviceinfoconfig.mmsight.enableHighResolutionRecord"), -1);
            int i5 = bi.getInt((String) z.get(".deviceinfoconfig.mmsight.landscapeRecordModeEnable"), -1);
            int i6 = bi.getInt((String) z.get(".deviceinfoconfig.mmsight.transcodeDecoderType"), -1);
            int i7 = bi.getInt((String) z.get(".deviceinfoconfig.mmsight.mediaPlayerType"), -1);
            int i8 = bi.getInt((String) z.get(".deviceinfoconfig.mmsight.strategyMask"), -1);
            int i9 = bi.getInt((String) z.get(".deviceinfoconfig.mmsight.recorderOption"), -1);
            int i10 = bi.getInt((String) z.get(".deviceinfoconfig.mmsight.useMetering"), -1);
            int i11 = bi.getInt((String) z.get(".deviceinfoconfig.mmsight.transcodeEncoderType"), -1);
            i2 = bi.getInt((String) z.get(".deviceinfoconfig.mmsight.checkSendVideoBitrate"), -1);
            if (tVar != null) {
                tVar.dfb = i;
                tVar.dfc = i3;
                tVar.dfd = i4;
                tVar.dfe = i5;
                tVar.dff = i6;
                tVar.dfg = i7;
                tVar.dfh = i8;
                tVar.dfi = i9;
                tVar.dfj = i10;
                tVar.dfk = i11;
                tVar.dfl = i2;
                x.i("MicroMsg.DeviceInfoParser", "get mmSightRecorderInfo: %s", tVar.toString());
            }
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.DeviceInfoParser", e, "", new Object[0]);
            return false;
        }
    }
}
