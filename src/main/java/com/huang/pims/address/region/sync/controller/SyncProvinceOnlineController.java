package com.huang.pims.address.region.sync.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addr/province/sync/online")
public class SyncProvinceOnlineController {

    /**
     * 在线获取省市区信息
     *
     *
     * 高德参考文档：https://lbs.amap.com/api/webservice/guide/api/district
     * @param target
     * @return
     */
    public Object getRegionOnline(@RequestParam(value = "target", required = false) String target) {
        target = StringUtils.isBlank(target) ? "lbs" : target;
        return null;
    }


}
