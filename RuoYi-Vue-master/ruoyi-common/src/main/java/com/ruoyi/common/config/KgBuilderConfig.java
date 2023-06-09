package com.ruoyi.common.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
@Data
public class KgBuilderConfig {

    /**
     * 在配置文件中配置的文件保存路径
     */
    @Value("${file.location}")
    private String location;

    @Value("${file.serverurl}")
    private String serverurl;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}