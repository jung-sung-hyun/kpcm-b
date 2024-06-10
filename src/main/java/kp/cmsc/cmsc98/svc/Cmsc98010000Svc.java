package kp.cmsc.cmsc98.svc;

import java.util.HashMap;
import java.util.List;

import kp.cmsc.cmsc98.vo.Cmsc98010000Vo;

public interface Cmsc98010000Svc {
    public List<Cmsc98010000Vo> selectCommonCodeList(List<HashMap<String, Object>> list) throws Exception;
}