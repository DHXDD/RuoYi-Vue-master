package com.ruoyi.common.utils.Neo4j;

import java.util.UUID;

public  class UuidUtil {
	public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString(); 
        String uuidStr=str.replace("-", "");
        return uuidStr;
      }
}
