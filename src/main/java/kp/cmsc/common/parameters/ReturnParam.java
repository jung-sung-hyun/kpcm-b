package kp.cmsc.common.parameters;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kp.cmsc.common.util.MessageUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReturnParam {
//    Map<String, Object>
//    param:
//    paramS:
//    dateSingle:
//    dataMuilte:
//    errCode:
//    errMessage:
//    bizCode:
//    bizMessage:
//    connectHash:
//    pageTot:
//    currentPage:
//    totCnt :


    /**
     *  화면에 전달 되는 파라미터의 정의 화면에서 해당 파라미터로 전달 받아 처리함.
     * @param inputObj
     *  param     : 화면에서 전달된 single 형태의 파라미터
     *  paramS    : 화면에 List로 전달된 파라미터
     * @param outputObj
     * @return
     *  dateSingle : 화면으로 전달될 single 형 파리미터
     *  dataList   : 화면에 전달되는 리스트 형태의 파라미터
     *  bizCode    : 화면으로 전달될 비지니스 메시지 코드
     *  bizMessage : 화면으로 전달될 비지니스 메시지명
     *  connectHash: 화몀으로 전달되는 connection Hans code
     * throws Exception
     * @author : jung sung hyun
     */
    public static Map<String, Object>  pushParamAction(Object inputObj, Object outputObj,String bizCode,String bizMessage ) throws Exception{
        Map<String, Object> returnParam = new HashMap<>();

        if (inputObj  instanceof List) {
            returnParam.put("param", null);
            returnParam.put("paramS", inputObj);
        }else {
            returnParam.put("param", inputObj);
            returnParam.put("paramS", null);
        }
        if (outputObj  instanceof List) {

            returnParam.put("dateSingle", null);
            returnParam.put("dataList", outputObj);
        }else {
            returnParam.put("dateSingle", outputObj);
            returnParam.put("dataList", null);
        }
        returnParam.put("bizCode", bizCode);
        returnParam.put("bizMessage", bizMessage);
        returnParam.put("connectHash", GlobalVariables.connectionHashCode);
        returnParam.put("errCode", null);
        returnParam.put("errMessage", null);
        return returnParam;
    }
    /**
     *  화면에 전달 되는 파라미터의 정의 화면에서 해당 파라미터로 전달 받아 처리함.
     * @param inputObj
     *  param     : 화면에서 전달된 single 형태의 파라미터
     *  paramS    : 화면에 List로 전달된 파라미터
     * @param outputObj
     * @return
     *  dateSingle: 화면으로 전달될 single 형 파리미터
     *  dataList  : 화면에 전달되는 리스트 형태의 파라미터
     *  connectHash: 화몀으로 전달되는 connection Hans code
     * throws Exception
     * @author : jung sung hyun
     */
    public static Map<String, Object>  pushParamAction(Object inputObj, Object outputObj) throws Exception{
        Map<String, Object> returnParam = new HashMap<>();
        if (inputObj  instanceof List) {
            returnParam.put("param", null);
            returnParam.put("paramS", inputObj);
        }else {
            returnParam.put("param", inputObj);
            returnParam.put("paramS", null);
        }
        if (outputObj  instanceof List) {

            returnParam.put("dateSingle", null);
            returnParam.put("dataList", outputObj);
        }else {
            returnParam.put("dateSingle", outputObj);
            returnParam.put("dataList", null);
        }
        returnParam.put("bizCode", null);
        returnParam.put("bizMessage", null);
        returnParam.put("connectHash", GlobalVariables.connectionHashCode);
        returnParam.put("errCode", null);
        returnParam.put("errMessage", null);

        return returnParam;
    }

    /**
     *  화면에 전달 되는 파라미터의 정의 화면에서 해당 파라미터로 전달 받아 처리함.
     * @param inputObj
     *  param     : 화면에서 전달된 single 형태의 파라미터
     *  paramS    : 화면에 List로 전달된 파라미터
     * @param outputObj
     * @return
     *  dateSingle: 화면으로 전달될 single 형 파리미터
     *  dataList  : 화면에 전달되는 리스트 형태의 파라미터
     *  connectHash: 화몀으로 전달되는 connection Hans code
     * throws Exception
     * @author : jung sung hyun
     */
    public static Map<String, Object>   pushErrorAction(String errCode) throws Exception{
        Map<String, Object> returnParam = new HashMap<>();
        returnParam.put("errCode", errCode);
        returnParam.put("errMessage", MessageUtil.getMessage(errCode));
        return returnParam;
    }

    /**
     *  화면에 전달 되는 파라미터의 정의 화면에서 해당 파라미터로 전달 받아 처리함.
     * @param String errCode : 에러커드전달
     * @param int num: 들어갈 숫자형 가변형 숫자 메세지에 "%d"로 입력함.
     * @return
     *  dateSingle: 화면으로 전달될 single 형 파리미터
     *  dataList  : 화면에 전달되는 리스트 형태의 파라미터
     *  connectHash: 화몀으로 전달되는 connection Hans code
     * throws Exception
     * @author : jung sung hyun
     */
    public static Map<String, Object>   pushErrorAction(String errCode,int num) throws Exception{
        Map<String, Object> returnParam = new HashMap<>();
        returnParam.put("errCode", errCode);
        //String.format("이름: %s, 나이: %d", name, name);
        returnParam.put("errMessage", String.format(MessageUtil.getMessage(errCode),num));
        return returnParam;
    }

    /**
     *  화면에 전달 되는 파라미터의 정의 화면에서 해당 파라미터로 전달 받아 처리함.
     * @param String errCode : 에러커드전달
     * @param String message: 들어갈 문자열 가변형문자에는 "%s" 선언
     * @return
     *  dateSingle: 화면으로 전달될 single 형 파리미터
     *  dataList  : 화면에 전달되는 리스트 형태의 파라미터
     *  connectHash: 화몀으로 전달되는 connection Hans code
     * throws Exception
     * @author : jung sung hyun
     */
    public static Map<String, Object>   pushErrorAction(String errCode,String message) throws Exception{
        Map<String, Object> returnParam = new HashMap<>();
        returnParam.put("errCode", errCode);
        //String.format("이름: %s, 나이: %d", name, name);
        returnParam.put("errMessage", String.format(MessageUtil.getMessage(errCode),message));
        return returnParam;
    }

    /**
     *  화면에 전달 되는 파라미터의 정의 화면에서 해당 파라미터로 전달 받아 처리함.
     * @param String errCode : 에러커드전달
     * @param int num: 들어갈 숫자형 가변형 숫자 메세지에 "%d"로 입력함.
     * @return
     *  dateSingle: 화면으로 전달될 single 형 파리미터
     *  dataList  : 화면에 전달되는 리스트 형태의 파라미터
     *  connectHash: 화몀으로 전달되는 connection Hans code
     * throws Exception
     */
    public static Map<String, Object>   pushErrorAction(String errCode,Object[] messageArguments) throws Exception{
        Map<String, Object> returnParam = new HashMap<>();
        returnParam.put("errCode", errCode);
        //MessageFormat.format(pattern, messageArguments);
        returnParam.put("errMessage", MessageFormat.format(MessageUtil.getMessage(errCode),messageArguments));
        return returnParam;
    }

    /**
     *  화면에 전달 되는 파라미터의 정의 화면에서 해당 파라미터로 전달 받아 처리함.
     * @param inputObj
     *  param     : 화면에서 전달된 single 형태의 파라미터
     *  paramS    : 화면에 List로 전달된 파라미터
     * @param outputObj
     * @return
     *  dateSingle: 화면으로 전달될 single 형 파리미터
     *  dataList  : 화면에 전달되는 리스트 형태의 파라미터
     *  connectHash: 화몀으로 전달되는 connection Hans code
     * throws Exception
     * @author : jung sung hyun
     */
    public static Map<String, Object>   pushInfoMesseage(String errCode) throws Exception{
        Map<String, Object> returnParam = new HashMap<>();
        returnParam.put("errCode", errCode);
        returnParam.put("errMessage", MessageUtil.getMessage(errCode));
        return returnParam;
    }
    /**
     *  화면에 전달 되는 파라미터의 정의 화면에서 해당 파라미터로 전달 받아 처리함.
     * @param String errCode : 메세지코드전달
     * @param int num: 들어갈 숫자형 가변형 숫자 메세지에 "%d"로 입력함.
     * @return
     *  dateSingle: 화면으로 전달될 single 형 파리미터
     *  dataList  : 화면에 전달되는 리스트 형태의 파라미터
     *  connectHash: 화몀으로 전달되는 connection Hans code
     * throws Exception
     * @author : jung sung hyun
     */
    public static Map<String, Object>   pushInfoMesseage(String errCode,int num) throws Exception{
        Map<String, Object> returnParam = new HashMap<>();
        returnParam.put("errCode", errCode);
        //String.format("이름: %s, 나이: %d", name, name);
        returnParam.put("errMessage", String.format(MessageUtil.getMessage(errCode),num));
        return returnParam;
    }

    /**
     *  화면에 전달 되는 파라미터의 정의 화면에서 해당 파라미터로 전달 받아 처리함.
     * @param String errCode : 에러커드전달
     * @param String message: 들어갈 문자열 가변형문자에는 "%s" 선언
     * @return
     *  dateSingle: 화면으로 전달될 single 형 파리미터
     *  dataList  : 화면에 전달되는 리스트 형태의 파라미터
     *  connectHash: 화몀으로 전달되는 connection Hans code
     * throws Exception
     * @author : jung sung hyun
     */
    public static Map<String, Object>   pushInfoMesseage(String errCode,String message) throws Exception{
        Map<String, Object> returnParam = new HashMap<>();
        returnParam.put("bizCode", errCode);
        returnParam.put("bizMessage", String.format(MessageUtil.getMessage(errCode),message));
        return returnParam;
    }

    /**
     *  화면에 전달 되는 파라미터의 정의 화면에서 해당 파라미터로 전달 받아 처리함.
     * @param String errCode : 에러커드전달
     * @param int num: 들어갈 숫자 횟수
     * @return
     *  dateSingle: 화면으로 전달될 single 형 파리미터
     *  dataList  : 화면에 전달되는 리스트 형태의 파라미터
     *  connectHash: 화몀으로 전달되는 connection Hans code
     * throws Exception
     */
    public static Map<String, Object>   pushInfoMesseage(String errCode,Object[] messageArguments) throws Exception{
        Map<String, Object> returnParam = new HashMap<>();
        returnParam.put("bizCode", errCode);
        returnParam.put("bizMessage", MessageFormat.format(MessageUtil.getMessage(errCode),messageArguments));
        return returnParam;
    }


    // Object[] messageArguments
}
