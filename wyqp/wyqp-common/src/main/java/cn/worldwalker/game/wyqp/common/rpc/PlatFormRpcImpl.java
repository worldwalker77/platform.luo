package cn.worldwalker.game.wyqp.common.rpc;

import java.util.HashMap;
import java.util.LinkedHashMap;

import cn.worldwalker.game.wyqp.common.constant.Constant;
import cn.worldwalker.game.wyqp.common.domain.base.PlatFormLoginResponse;
import cn.worldwalker.game.wyqp.common.utils.HttpClientUtils;
import cn.worldwalker.game.wyqp.common.utils.JsonUtil;
import cn.worldwalker.game.wyqp.common.utils.MD5Util1;

public class PlatFormRpcImpl implements PlatFormRpc{

	public static int DeductionDiamo(String applicationid, String applicationname,
			String gameid, String gamename, String clientip, int userId, int Num) {
		
		HashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("applicationid", applicationid);
		map.put("applicationname", applicationname);
		map.put("gameid", gameid);
		map.put("gamename", gamename);
		map.put("clientip", clientip);
		map.put("userId", userId + "");
		map.put("Num", Num + "");
		String signkey = MD5Util1.encryptByMD5(applicationid + userId + Num + "1234567890qwertyuiop" + "asdfghjklzxcvbnmpoiuytrewq");
		System.out.println(signkey);
		map.put("signkey", signkey);
		String loginRes = "";
		try {
			loginRes = HttpClientUtils.postFormData(Constant.deductionDiamo, map);
			System.out.println(loginRes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		PlatFormLoginResponse platFormLoginResponse = JsonUtil.toObject(loginRes, PlatFormLoginResponse.class);
		
		return 0;
	}
	
	public static void main(String[] args) {
		DeductionDiamo("applicationid", "applicationname", "gameid123121", "gamename123121", "127.0.0.1", 100026, 1);
		
	}

}
