package kp.cmsc.cmsc98.svc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kp.cmsc.cmsc98.vo.Cmsc98010000Vo;

public interface Cmsc98010000Svc {
    public Map<String, Object> selectErrCdList(Cmsc98010000Vo inputVo) throws Exception;
    public Map<String, Object> excuteErrCdList(Cmsc98010000Vo inputVo) throws Exception;
}